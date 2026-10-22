package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.cloudtrans.response.DSKExchangeResponse;
import com.bytedance.crypto.engine.ECDHHelper;
import com.bytedance.crypto.engine.KeyPairHelper;
import com.bytedance.crypto.network.ChallengeManager;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.CryptoConfig;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class CloudTransCryptoManager implements ICloudTransCrypto {
    private static final int DATA_MAX_SIZE = 10485760;
    private static final Object LOCK = null;
    private static final String TAG = "CloudTransCryptoManager";
    private static final long UPDATE_SESSION_KEY = 86400000;
    private static volatile CloudTransCryptoManager instance;
    private String alias;
    private final boolean isBDDevice;
    private Context mContext;
    private String mDid;
    private IEnvBridge mEnvBridge;
    private String mSecAppId;
    private long mSessionKeyStartTime;
    private SensitiveData sensitiveData;

    static {
        LOCK = new Object();
    }

    private CloudTransCryptoManager() {
        this.sensitiveData = null;
        this.mContext = null;
        this.mSecAppId = null;
        this.mDid = null;
        this.mEnvBridge = null;
        this.mSessionKeyStartTime = 0;
        boolean r100 = TransUtils.isBDDevice();
        this.isBDDevice = r100;
        LogUtils.i(TAG, "isBDDevice: " + r100);
    }

    private String buildExchangeRequestBody(PrivateKey r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        String r105 = CryptoUtils.ecdsaSign(r102 + r101 + r103, r100);     // Catch: Exception -> L6
        r104.put("app_id", r102);     // Catch: Exception -> L6
        r104.put(a.KEY_DID, r101);     // Catch: Exception -> L6
        r104.put("nonce", r103);     // Catch: Exception -> L6
        r104.put("signature", r105);     // Catch: Exception -> L6
        return r104.toString();
    L6:
        e = move-exception;
        throw new CloudTransException("buildExchangeRequestBody failed, " + e.getMessage());
    }

    private void checkInputParams(TransCryptoContext r100, int r101, InputStream r102, OutputStream r103) {
        if (r100 != null) goto L5;
        TransUtils.printErrorInfo(TAG, "TransCryptoContext is null!!");
    L5:
        if (r102 == null) goto L7;
        if (r103 == null) goto L7;
    L9:
        if (TextUtils.isEmpty(r100.getAppId()) == false) goto L11;
    L12:
        TransUtils.printErrorInfo(TAG, "Input appid or did is empty!!");
    L19:
        int r104 = r102.available();     // Catch: Exception -> L15
    L17:
        LogUtils.i(TAG, "Stream xcrypt params check ok, mode:" + r101 + ", app:" + r100.getAppId() + ", data len:" + r104);
        return;
    L15:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Input stream available failed, error:" + e.getMessage());
        r104 = 0;
        goto L17
    L11:
        if (TextUtils.isEmpty(r100.getDid()) == false) goto L19;
    L7:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L9
    }

    private CloudDskBody dskExchangeByCert(DSKExchangeResponse r100, Context r101, String r102, String r103) {
        LogUtils.i(TAG, "DSK exchange by cert.");
        Certificate[] r104 = initSensitive(r101, ChallengeManager.requestChallenge(), r102, r103);
    L10:
        e = move-exception;
        this.sensitiveData = null;
        throw new CloudTransException("dsk exchange by cert failed, ", e);
    L4:
        if (this.isBDDevice == false) goto L6;
        int r105 = r104.length - 1;     // Catch: CloudTransException -> L10
    L7:
        return r100.jsonParsing(r100.dskExchangeByCert(TransUtils.certChainsToPEM(r104, r105)));
    L6:
        r105 = r104.length;     // Catch: CloudTransException -> L10
        goto L7
    }

    private CloudDskBody dskExchangeByTempKey(DSKExchangeResponse r110, Context r111, String r112, String r113) {
        LogUtils.i(TAG, "DSK exchange by keypair.");
        String r114 = ChallengeManager.requestChallenge();
        byte[] r100 = r112.getBytes(StandardCharsets.UTF_8);
        byte[] r101 = r113.getBytes(StandardCharsets.UTF_8);
        Object r102 = LOCK;
        monitor-enter(r102);
        this.sensitiveData.setExtraInfo(TransUtils.concatenate(new byte[][]{new byte[]{(byte) r100.length}, r100, new byte[]{(byte) r101.length}, r101}));     // Catch: Throwable -> L8 IOException -> L10
        monitor-exit(r102);     // Catch: Throwable -> L8
        KeyPair r103 = CryptoUtils.generateECCKeyPair();
        CloudDskBody r115 = r110.jsonParsing(r110.dskExchangeByTempKey(TransUtils.convertToPem(r103.getPublic()), buildExchangeRequestBody(r103.getPrivate(), r112, r113, r114)));
        r115.deviceTempPriKey = r103.getPrivate();
        return r115;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, DID and appId save failed, ", e);     // Catch: Throwable -> L8
    }

    private void generateSharedSecret(Context r100, CloudDskBody r101) {
        PublicKey r102 = TransUtils.getPublicKeyFromPEM(r101.data.cloudPublicKey);     // Catch: Exception -> L42
    L39:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, generate shared secret failed, error:" + e.getMessage());
    L5:
        if (this.isBDDevice == true) goto L7;
        PrivateKey r103 = KeyPairHelper.loadKeyPair(this.alias).getPrivate();     // Catch: Exception -> L39
    L15:
        byte[] r104 = ECDHHelper.generateSharedSecret(r103, r102);     // Catch: Exception -> L39
    L46:
    L36:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, shared key hash is error", e);
    L17:
        if (CryptoUtils.byteArrayToHexString(TransUtils.sha256(r104)).equals(r101.data.sharedKeyHash) == false) goto L35;
        Object r105 = LOCK;
        monitor-enter(r105);
        this.sensitiveData.setDeviceShareKey(r104);     // Catch: Throwable -> L31
        this.sensitiveData.setKeyVersion(r101.data.keyVersion);     // Catch: Throwable -> L31
        long r106 = r101.data.expectExpiryTime * 1000;     // Catch: Exception -> L28 Throwable -> L31
        LogUtils.d(TAG, "validityPeriod:" + r106);     // Catch: Exception -> L28 Throwable -> L31
        if (r106 < System.currentTimeMillis()) goto L26;
        this.sensitiveData.setKeyValidityPeriod(r106);     // Catch: Exception -> L28 Throwable -> L31
        monitor-exit(r105);     // Catch: Throwable -> L31
        return;
    L26:
        LogUtils.e(TAG, "validityPeriod is error, validityPeriod:" + r106 + " current:" + System.currentTimeMillis());     // Catch: Exception -> L28 Throwable -> L31
        throw new CloudTransException("generateSharedSecret failed, info time is error, validityPeriod is error");     // Catch: Exception -> L28 Throwable -> L31
    L28:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, info cannot be converted to time", e);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L35:
        throw new CloudTransException("generateSharedSecret failed, shared key hash is error");     // Catch: Exception -> L36
    L7:
        if (TransUtils.isDevCertExist(r100) == false) goto L10;
        r104 = ECDHHelper.generateBDSharedSecret(r100, this.alias, CryptoUtils.parseECCPublicKey(r102.getEncoded()));     // Catch: Exception -> L39
        goto L46
    L10:
        if (CloudTransConfig.isAllowTempKeyExchange() == false) goto L13;
        r103 = r101.deviceTempPriKey;     // Catch: Exception -> L39
        goto L15
    L13:
        throw new CloudTransException("generateSharedSecret failed, device cert not exist!");     // Catch: Exception -> L39
    L43:
        throw new CloudTransException("generateSharedSecret failed, info information cannot be converted to public key");
    }

    public static CloudTransCryptoManager getInstance() {
        if (instance != null) goto L15;
        Object r100 = LOCK;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CloudTransCryptoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private void initInternal(Context r110, String r210, String r211, IEnvBridge r212, boolean r213) {
        Object r111 = LOCK;
        monitor-enter(r111);
        if (r110 == null) goto L106;
    L103:
        th = th;
        Object r112 = r111;
    L108:
        monitor-exit(r112);     // Catch: Throwable -> L107
        throw th;
    L6:
        if (TextUtils.isEmpty(r210) == true) goto L102;
        if (TextUtils.isEmpty(r211) == true) goto L102;
        LogUtils.d(TAG, "init did:" + r211 + " secAppId:" + r210);     // Catch: Throwable -> L103
        if (r212 == null) goto L100;
        this.mContext = r110;     // Catch: Throwable -> L103
        this.mSecAppId = r210;     // Catch: Throwable -> L103
        this.mDid = r211;     // Catch: Throwable -> L103
        this.mEnvBridge = r212;     // Catch: Throwable -> L103
        String r113 = "device_share_key_" + r210;     // Catch: Throwable -> L103
    L95:
        e = e;
    L97:
        this.sensitiveData = null;     // Catch: Throwable -> L107
        throw new CloudTransException("init failed, loadSensitiveDate failed", e);     // Catch: Throwable -> L107
    L13:
        if (this.sensitiveData != null) goto L15;
    L23:
        SensitiveData r114 = new SensitiveData();     // Catch: CloudTransException -> L95 Throwable -> L103
        this.sensitiveData = r114;     // Catch: CloudTransException -> L95 Throwable -> L103
        r112 = r111;
        this.mSessionKeyStartTime = 0;     // Catch: CloudTransException -> L93 Throwable -> L107
        if (r114.getKeyValidityPeriod() != 0) goto L28;
        this.sensitiveData.loadSensitiveDate(r110, r113, r210, this.isBDDevice);     // Catch: CloudTransException -> L93 Throwable -> L107
        this.mSessionKeyStartTime = System.currentTimeMillis();     // Catch: CloudTransException -> L93 Throwable -> L107
    L28:
        printSensitiveDebugInfo(this.sensitiveData);     // Catch: CloudTransException -> L93 Throwable -> L107
        if (TextUtils.isEmpty(parseAppId(this.sensitiveData.getExtraInfo())) == false) goto L32;
    L36:
        if (r213 == false) goto L38;
    L42:
        NetworkConfig.getInstance().init(r212);     // Catch: Throwable -> L107
        DSKExchangeResponse r115 = new DSKExchangeResponse();     // Catch: Throwable -> L107
        if (TransUtils.isDevCertExist(r110) == false) goto L47;
        CloudDskBody r100 = dskExchangeByCert(r115, r110, r211, r210);     // Catch: Throwable -> L107
    L45:
        CloudDskBody r116 = r100;
        if (r116.code == 200) goto L121;
        LogUtils.e(TAG, "code is error, response body: " + r116.bodyJson);     // Catch: Throwable -> L107
        this.sensitiveData = null;     // Catch: Throwable -> L107
        throw new CloudTransException("init failed, response code is " + r116.code);     // Catch: Throwable -> L107
    L121:
        LogUtils.d(TAG, "expectExpiryTime:" + r116.data.expectExpiryTime);     // Catch: Exception -> L81 Throwable -> L107
        if (TransUtils.verifySignature(TransUtils.getPublicKeyFromPEM(r115.getPlublicKey()), TransUtils.concatenate(new byte[][]{r116.data.cloudPublicKey.getBytes(), r116.data.sharedKeyHash.getBytes(), TransUtils.longToByteArray(r116.data.keyVersion), TransUtils.longToByteArray(r116.data.expectExpiryTime)}), r116.data.signature) == false) goto L80;
        generateSharedSecret(r110, r116);     // Catch: CloudTransException -> L76 Throwable -> L107
    L114:
        this.sensitiveData.updateSensitiveDate(r110, r113, r210);     // Catch: Exception -> L69 Throwable -> L107
    L119:
        String r101 = r115.dskExchangeResult(r115.constructBodyJson(r210, r211, r116.data.keyVersion, 1));     // Catch: Exception -> L62 Throwable -> L107
        int r102 = new JSONObject(r101).getInt("code");     // Catch: Exception -> L62 Throwable -> L107
        if (r102 != 200) goto L60;
        monitor-exit(r112);     // Catch: Throwable -> L107
        return;
    L60:
        LogUtils.e(TAG, "code is error, response body: " + r101);     // Catch: Exception -> L62 Throwable -> L107
        throw new CloudTransException("init failed, web response code is " + r102);     // Catch: Exception -> L62 Throwable -> L107
    L62:
        e = move-exception;
        this.sensitiveData.deleteSensitiveDate(r110, r113);     // Catch: Throwable -> L107
        this.sensitiveData = null;     // Catch: Throwable -> L107
        if ((e instanceof CloudTransException) == false) goto L68;
        throw ((CloudTransException) e);     // Catch: Throwable -> L107
    L68:
        throw new CloudTransException("init failed, parse exchange result body failed", e);     // Catch: Throwable -> L107
    L69:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L107
        r115.dskExchangeResult(r115.constructBodyJson(r210, r211, r116.data.keyVersion, 2));     // Catch: Throwable -> L107
        if ((e instanceof CloudTransException) == false) goto L75;
        throw ((CloudTransException) e);     // Catch: Throwable -> L107
    L75:
        throw new CloudTransException("init failed, update sensitive data failed", e);     // Catch: Throwable -> L107
    L76:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L107
        r115.dskExchangeResult(r115.constructBodyJson(r210, r211, r116.data.keyVersion, 2));     // Catch: Throwable -> L107
        throw new CloudTransException("init failed, " + e);     // Catch: Throwable -> L107
    L80:
        throw new CloudTransException("init failed, verifySignature failed.");     // Catch: Exception -> L81 Throwable -> L107
    L81:
        e = move-exception;
        this.sensitiveData = null;     // Catch: Throwable -> L107
        if ((e instanceof CloudTransException) == false) goto L88;
        throw ((CloudTransException) e);     // Catch: Throwable -> L107
    L88:
        throw new CloudTransException("init failed, signature is error", e);     // Catch: Throwable -> L107
    L47:
        if (CloudTransConfig.isAllowTempKeyExchange() == false) goto L91;
        r100 = dskExchangeByTempKey(r115, r110, r211, r210);     // Catch: Throwable -> L107
        goto L45
    L91:
        LogUtils.e(TAG, "init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L107
        throw new CloudTransException("init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L107
    L38:
        if (isNeedRenegotiated(r211) == true) goto L42;
        LogUtils.i(TAG, "no need to renew");     // Catch: Throwable -> L107
        monitor-exit(r112);     // Catch: Throwable -> L107
        return;
    L32:
        if (TextUtils.equals(r210, parseAppId(this.sensitiveData.getExtraInfo())) == true) goto L36;
        throw new CloudTransException("init failed, appId is not match!");     // Catch: Throwable -> L107
    L93:
        e = e;
        goto L97
    L15:
        if (isSessionKeyExpired() == true) goto L23;
        if (isDidChanged(r211) == true) goto L23;
        if (r213 == true) goto L23;
        printSensitiveDebugInfo(this.sensitiveData);     // Catch: CloudTransException -> L95 Throwable -> L103
        monitor-exit(r111);     // Catch: Throwable -> L103
        return;
    L100:
        throw new CloudTransException("init failed, bridge is null");     // Catch: Throwable -> L107
    L102:
        throw new CloudTransException("init failed, appId or did is empty");     // Catch: Throwable -> L107
    L106:
        throw new CloudTransException("init failed, context is null");     // Catch: Throwable -> L107
    L107:
        th = th;
        goto L108
    }

    private Certificate[] initSensitive(Context r100, String r101, String r110, String r111) {
        this.alias = Process.myUid() + "_" + r100.getPackageName();
        String r102 = r101 + ":" + r110 + ":" + r111;
        byte[] r112 = r110.getBytes(StandardCharsets.UTF_8);
        byte[] r113 = r111.getBytes(StandardCharsets.UTF_8);
        Object r103 = LOCK;
        monitor-enter(r103);
        this.sensitiveData.setExtraInfo(TransUtils.concatenate(new byte[][]{new byte[]{(byte) r112.length}, r112, new byte[]{(byte) r113.length}, r113}));     // Catch: Throwable -> L15 IOException -> L17
        monitor-exit(r103);     // Catch: Throwable -> L15
    L12:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, ", e);
    L7:
        if (this.isBDDevice == false) goto L10;
        KeyPairHelper.deleteBDKey(r100, this.alias);     // Catch: Exception -> L12
        KeyPairHelper.generateECDSABDKeyPair(r100, this.alias);     // Catch: Exception -> L12
        return KeyPairHelper.getBDCertificateChain(r100, this.alias, r102);
    L10:
        KeyPairHelper.deleteKey(this.alias);     // Catch: Exception -> L12
        KeyPairHelper.generateECDSAKeyPair(this.alias, r102);     // Catch: Exception -> L12
        return KeyPairHelper.getCertificateChain(this.alias);
    L17:
        e = move-exception;
        throw new CloudTransException("initSensitive failed, DID and appId save failed, ", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private boolean isDidChanged(String r100) {
        SensitiveData r101 = this.sensitiveData;
        if (r101 != null) goto L6;
        return true;
    L6:
        return !TextUtils.equals(r100, parseDid(r101.getExtraInfo()));
    }

    private boolean isNeedRenegotiated(String r100) {
        Object r101 = LOCK;
        monitor-enter(r101);
        boolean r102 = isDidChanged(r100);     // Catch: Throwable -> L15
        if (r102 == false) goto L8;
        LogUtils.i(TAG, "did changed!");     // Catch: Throwable -> L15
    L8:
        if (this.sensitiveData.getKeyValidityPeriod() < System.currentTimeMillis()) goto L12;
        if (r102 == true) goto L12;
        boolean r103 = false;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return r103;
    L12:
        r103 = true;
    L15:
        th = move-exception;
        throw th;
    }

    private boolean isSessionKeyExpired() {
        if ((System.currentTimeMillis() - this.mSessionKeyStartTime) <= 86400000) goto L5;
        return true;
    L5:
        return false;
    }

    private String parseAppId(byte[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.length < 1) goto L19;
        int r101 = (r100[0] & UByte.MAX_VALUE) + 1;
        if (r101 <= r100.length) goto L10;
        return "";
    L10:
        int r102 = r101 + 1;
        if (r102 <= r100.length) goto L13;
        return "";
    L13:
        int r103 = (r100[r101] & UByte.MAX_VALUE) + r102;
        if (r103 <= r100.length) goto L17;
        return "";
    L17:
        return new String(Arrays.copyOfRange(r100, r102, r103), StandardCharsets.UTF_8);
    L19:
        return "";
    }

    private String parseDid(byte[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.length < 1) goto L13;
        int r101 = (r100[0] & UByte.MAX_VALUE) + 1;
        if (r101 <= r100.length) goto L11;
        return "";
    L11:
        return new String(Arrays.copyOfRange(r100, 1, r101), StandardCharsets.UTF_8);
    L13:
        return "";
    }

    private void printSensitiveDebugInfo(SensitiveData r100) {
        if (CryptoConfig.isDebug() == false) goto L8;
        LogUtils.d(TAG, "keyVersion:" + r100.getKeyVersion());
        if (Build.VERSION.SDK_INT < 26) goto L9;
        DateTimeFormatter r101 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        LogUtils.d(TAG, "deviceKey Validity Period:" + r101.format(Instant.ofEpochMilli(r100.getKeyValidityPeriod())));
        LogUtils.d(TAG, "sessionKey Start Time:" + r101.format(Instant.ofEpochMilli(this.mSessionKeyStartTime)));
        LogUtils.d(TAG, "current Time:" + r101.format(Instant.ofEpochMilli(System.currentTimeMillis())));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public byte[] dataDecrypt(byte[] r110) {
        if (r110 == null) goto L25;
        if (r110.length == 0) goto L25;
        Object r100 = LOCK;
        monitor-enter(r100);
        SensitiveData r101 = this.sensitiveData;     // Catch: Throwable -> L21
        if (r101 == null) goto L20;
        if (r101.getDeviceShareKey() == null) goto L20;
        byte[] r111 = DataEncryptHelper.dataDecrypt(r110, this.sensitiveData);     // Catch: CloudTransException -> L14 Throwable -> L21
        monitor-exit(r100);     // Catch: Throwable -> L21
        return r111;
    L14:
        e = move-exception;
        if (e.getErrorCode() != (-22)) goto L18;
        LogUtils.e(TAG, "key version mismatch, need to force init!");     // Catch: Throwable -> L21
        initInternal(this.mContext, this.mSecAppId, this.mDid, this.mEnvBridge, true);     // Catch: Throwable -> L21
    L18:
        throw e;     // Catch: Throwable -> L21
    L20:
        throw new CloudTransException("dataDecrypt failed, not completely initialized.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new CloudTransException("dataDecrypt failed, ciphertext is null");
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public byte[] dataEncrypt(byte[] r100) {
        if (r100 == null) goto L24;
        if (r100.length == 0) goto L24;
        if (r100.length > 10485760) goto L22;
        Object r101 = LOCK;
        monitor-enter(r101);
        SensitiveData r102 = this.sensitiveData;     // Catch: Throwable -> L18
        if (r102 == null) goto L17;
        if (r102.getSessionEncryptKey() == null) goto L17;
        byte[] r103 = DataEncryptHelper.dataEncrypt(r100, this.sensitiveData);     // Catch: Throwable -> L18
        monitor-exit(r101);     // Catch: Throwable -> L18
        return r103;
    L17:
        throw new CloudTransException("dataEncrypt failed, not completely initialized.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new CloudTransException("dataEncrypt failed, plaintext length is too large");
    L24:
        throw new CloudTransException("dataEncrypt failed, plaintext is null");
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void fullFileDecrypt(InputStream r100, OutputStream r101) {
        if (r100 == null) goto L4;
        if (r101 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamDecrypt(this.mContext, this.sensitiveData, true, r100, r101);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void fullFileEncrypt(InputStream r100, OutputStream r110) {
        if (r100 == null) goto L4;
        if (r110 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamEncrypt(DataEncryptHelper.initEncryptContextInner(this.mContext, this.mSecAppId, this.mDid, this.sensitiveData, false, true), this.sensitiveData, true, r100, r110);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void init(Context r100, String r101, String r102, IEnvBridge r110) {
        initInternal(r100, r101, r102, r110, false);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext initDecryptContext(Context r100, String r101, String r102, byte[] r103, IEnvBridge r104) {
        init(r100, r101, r102, r104);
        TransCryptoContext r105 = new TransCryptoContext(r100, r102, r101);
    L8:
        e = move-exception;
        throw new CloudTransException("initDecryptContext failed, error:" + e.getMessage());
    L4:
        if (r105.initPageDecryptKey(r103, this.sensitiveData) == false) goto L7;
        return r105;
    L7:
        throw new CloudTransException("initDecryptContext failed, initPageDecryptKey failed");     // Catch: Exception -> L8
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext initEncryptContext(Context r100, String r101, String r102, IEnvBridge r110) {
        init(r100, r101, r102, r110);
        return DataEncryptHelper.initEncryptContextInner(r100, r101, r102, this.sensitiveData, true, true);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void pageFileDecrypt(TransCryptoContext r100, InputStream r101, OutputStream r102) {
        checkInputParams(r100, 2, r101, r102);
        DataEncryptHelper.streamDecrypt(r100, r101, r102);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void pageFileEncrypt(TransCryptoContext r100, InputStream r101, OutputStream r102) {
        checkInputParams(r100, 1, r101, r102);
        DataEncryptHelper.streamEncrypt(r100, r101, r102);
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void streamDecrypt(InputStream r100, OutputStream r101) {
        if (r100 == null) goto L4;
        if (r101 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamDecrypt(this.mContext, this.sensitiveData, false, r100, r101);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L5
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public byte[] streamDecryptBytes(TransCryptoContext r100, byte[] r101) {
        if (r100 != null) goto L6;
        TransUtils.printErrorInfo(TAG, "TransCryptoContext is null!!");
    L6:
        if (TextUtils.isEmpty(r100.getAppId()) == false) goto L8;
    L9:
        TransUtils.printErrorInfo(TAG, "Input appid or did is empty!!");
    L10:
        if (r101 == null) goto L16;
        if (r101.length == 0) goto L16;
        return DataEncryptHelper.streamDecryptBytes(r100, r101);
    L16:
        throw new CloudTransException("streamDecryptBytes failed, cipherData is null");
    L8:
        if (TextUtils.isEmpty(r100.getDid()) == false) goto L10;
        goto L9
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public TransCryptoContext streamDecryptFirstBytes(byte[] r100) {
        if (r100 == null) goto L8;
        if (r100.length == 0) goto L8;
        return DataEncryptHelper.streamDecryptFirstBytes(this.mContext, this.sensitiveData, r100);
    L8:
        throw new CloudTransException("streamDecryptFirstBytes failed, cipherData is null");
    }

    @Override // com.bytedance.crypto.cloudtrans.ICloudTransCrypto
    public void streamEncrypt(InputStream r100, OutputStream r110) {
        if (r100 == null) goto L4;
        if (r110 == null) goto L4;
    L5:
        DataEncryptHelper.fullStreamEncrypt(DataEncryptHelper.initEncryptContextInner(this.mContext, this.mSecAppId, this.mDid, this.sensitiveData, false, false), this.sensitiveData, false, r100, r110);
        return;
    L4:
        TransUtils.printErrorInfo(TAG, "Input stream is null!!");
        goto L5
    }
}
