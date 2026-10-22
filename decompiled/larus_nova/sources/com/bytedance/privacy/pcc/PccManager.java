package com.bytedance.privacy.pcc;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.privacy.pcc.network.model.g;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.obric.sva.sdk.data.ISmModel;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public class PccManager {
    private static final String CLOUD_CERT_BOE = "-----BEGIN CERTIFICATE-----\nMIICNTCCAdqgAwIBAgIUGJmWDf76XK7QEDg7ePQ6Zp5a/QAwCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQwODE4MzVaFw00MTAyMjgwODI4MzRaMGUxEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEuMCwGA1UEAxMlQk9FIEJ5\ndGVEYW5jZSBTbWFydCBTaWduIE9QQ0MgR2F0ZXdheTBZMBMGByqGSM49AgEGCCqG\nSM49AwEHA0IABM25nWwFbu/tBeKoSdmqIEFzkGsiNlVBzp++3/y3PSAl3X5JQ98U\nkN8af1gEabmQWsnQ6rfAu+/3N1eLdaeyAH+jdjB0MAwGA1UdEwEB/wQCMAAwHwYD\nVR0jBBgwFoAUI3ocFBGPZx1O0yRJxLCCPmaMCkwwQwYIKwYBBQUHAQEENzA1MDMG\nCCsGAQUFBzABhidodHRwOi8vbmV4dXMtYm9lLmJ5dGVkYW5jZS5uZXQvcGNhL29j\nc3AwCgYIKoZIzj0EAwIDSQAwRgIhANzuvWkxo2IGpnbJNEWvZRuyp/brvmy9u76P\nRj9AkGSzAiEAuxwuHmrS6OmMWFi5ha9DpqLJijiXzNEKcdVYsJuAFTY=\n-----END CERTIFICATE-----";
    private static final String CLOUD_CERT_ONLINE = "-----BEGIN CERTIFICATE-----\nMIICODCCAd2gAwIBAgIUGJmcpAzL0+i5GIb6FxhoxPQSMtswCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQxMDE5MTZaFw00MTAyMjgxMDI5MTZaMGExEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEqMCgGA1UEAxMhQnl0ZURh\nbmNlIFNtYXJ0IFNpZ24gT1BDQyBHYXRld2F5MFkwEwYHKoZIzj0CAQYIKoZIzj0D\nAQcDQgAE1eO/rIuiv0g/zgUMel9/Jyv3msFzoimqEuwjFIRJGKKe51ONP9jMv7zP\ng/IuRK5HFR3IMZYjz507Az0wuT8jIKN9MHswDAYDVR0TAQH/BAIwADAfBgNVHSME\nGDAWgBRgISfbugqIUe075DXEeifDk4vhATBKBggrBgEFBQcBAQQ+MDwwOgYIKwYB\nBQUHMAGGLmh0dHA6Ly9uZXh1cy1wcm9kdWN0aW9uLmJ5dGVkYW5jZS5uZXQvcGNh\nL29jc3AwCgYIKoZIzj0EAwIDSQAwRgIhAM5X3JaXiaAD1sFDDFpRB5rNQS3G7mSc\nGDbtKnvJ3SQ4AiEAwH5JexV4T1BLcNoZctl6iOo5JeUbEwZ11lVi0fzXPI0=\n-----END CERTIFICATE-----";
    private static final int DATA_PROTOCOL_VERSION = 2;
    public static final String HEADER_LANE_TYPE = "rpc-persist-lane-c-ocean-secure";
    private static final int KEY_ENVELOPE_VERSION = 2;
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_LANE_TYPE = "lane_type";
    public static final int LANE_TYPE_CPU_NORMAL = 1;
    public static final int LANE_TYPE_CPU_TEE = 2;
    public static final int LANE_TYPE_GPU_TEE = 3;
    public static final int LANE_TYPE_IGNORE = 0;
    private static final int MAX_STRING_LENGTH = 512;
    private static final String PCC_CLIENT_VERSION = "2.0.0";
    private static final String PCC_PROTOCOL_VERSION = "2.0";
    private static final String PCC_SIGN_KEY_ALIAS = "pcc_sign_key";
    private static final String TAG = null;
    private static volatile PccManager pccManager;
    private Context appContext;
    private f67.b channelDb;
    private final Map<String, a> sessionContextCache;

    /* JADX INFO: loaded from: classes21.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppInfo f266689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f266690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f266691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final KeyPair f266692d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.bytedance.privacy.pcc.network.model.c.d f266693e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f266694f;

        public a(AppInfo r100, String r101, KeyPair r102, com.bytedance.privacy.pcc.network.model.c.d r103, byte[] r104) {
            this.f266689a = r100;
            this.f266690b = 1;
            this.f266691c = r101;
            this.f266692d = r102;
            this.f266693e = r103;
            this.f266694f = r104;
        }
    }

    public String getVersion() {
        return "2.0";
    }

    static {
        TAG = "PccManager";
    }

    private PccManager() {
        this.sessionContextCache = new ConcurrentHashMap();
    }

    private void attachContext(Context r100) {
        if (r100 == null) goto L5;
        this.appContext = r100.getApplicationContext();
        this.channelDb = new f67.b(this.appContext);
        return;
    }

    public static PccManager getInstance(Context r100) {
        if (pccManager != null) goto L15;
        monitor-enter(PccManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (pccManager != null) goto L9;
        pccManager = new PccManager();     // Catch: Throwable -> L11
        pccManager.attachContext(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(PccManager.class);     // Catch: Throwable -> L11
    L15:
        return pccManager;
    }

    private boolean isChannelExpired(com.bytedance.privacy.pcc.network.model.c r100) {
        com.bytedance.privacy.pcc.network.model.c.b r101 = r100.f266703a;
        if (r101 == null) goto L5;
        String r102 = com.bytedance.privacy.pcc.network.model.c.b.e(r101);
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L17;
        return true;
    L17:
        if ((System.currentTimeMillis() / 1000) >= CastLongProtector.parseLong(r102)) goto L19;
        return false;
    L19:
        return true;
    L15:
        k67.b.c(TAG, "isChannelExpired: invalid expiry format: " + r102);
        return true;
    L5:
        r102 = "";
        goto L7
    }

    private static boolean isValidAppInfo(AppInfo r100) {
        if (r100 != null) goto L4;
    L12:
        return false;
    L4:
        if (isValidString(r100.rpdid) == false) goto L12;
        if (isValidString(r100.rpuid) == false) goto L12;
        if (isValidString(r100.appId) == false) goto L12;
        if (isValidString(r100.appSvcId) == false) goto L12;
        return true;
    }

    private static boolean isValidBytes(byte[] r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length <= 0) goto L6;
        return true;
    }

    private static boolean isValidString(String r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.length() <= 0) goto L8;
        if (r100.length() >= 512) goto L8;
        return true;
    }

    private static int parseKeyVersion(String r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (r100.isEmpty() == true) goto L14;
        return CastIntegerProtector.parseInt(r100);
    L8:
        k67.b.c(TAG, "parseKeyVersion: non-integer '" + r100 + "', defaulting to 0");
        return 0;
    L14:
        return 0;
    }

    private com.bytedance.privacy.pcc.network.model.c queryChannelFromDb(AppInfo r100) {
        f67.b r101 = this.channelDb;
        if (r101 != null) goto L7;
        k67.b.c(TAG, "queryChannelFromDb: DB not ready");
        return null;
    L7:
        return r101.query(r100.rpdid, r100.rpuid, r100.appId, r100.appSvcId);
    }

    private boolean verifyCloudSignature(com.bytedance.privacy.pcc.network.model.c r100) {
        boolean r101 = e67.b.a().b();
        if (r101 == false) goto L5;
        String r102 = CLOUD_CERT_BOE;
    L6:
        String r103 = TAG;
        if (r101 == false) goto L9;
        String r104 = "BOE";
    L10:
        k67.b.a(r103, "verifyCloudSignature: env=".concat(r104));
        if (TextUtils.isEmpty(r100.f266706d) == false) goto L22;
        k67.b.c(r103, "verifyCloudSignature: server signature is empty");
        return false;
    L22:
        boolean r105 = com.bytedance.privacy.pcc.a.f(r102, (r100.f266705c + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r100.f266704b).getBytes(StandardCharsets.UTF_8), Base64.decode(r100.f266706d, 8));     // Catch: Exception -> L19
        if (r105 == true) goto L17;
        k67.b.c(r103, "verifyCloudSignature: ECDSA verification failed");     // Catch: Exception -> L19
    L18:
        return r105;
    L17:
        k67.b.e(r103, "verifyCloudSignature: signature valid");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        k67.b.c(TAG, "verifyCloudSignature exception: " + e.getMessage());
        return false;
    L9:
        r104 = "Online";
        goto L10
    L5:
        r102 = CLOUD_CERT_ONLINE;
        goto L6
    }

    public int closeSecuritySession(String r100) {
        String r101 = TAG;
        k67.b.a(r101, "closeSecuritySession called: sessionId=" + r100);
        if (isValidString(r100) == true) goto L7;
        k67.b.c(r101, "closeSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L7:
        if (this.sessionContextCache.get(r100) != null) goto L10;
        k67.b.c(r101, "closeSecuritySession failed: session not found, sessionId=" + r100);
        return -32;
    L10:
        this.sessionContextCache.remove(r100);
        k67.b.a(r101, "closeSecuritySession success: sessionId=" + r100);
        return 0;
    }

    private Bundle createResultBundle(int r100, int r101) {
        Bundle r102 = new Bundle();
        r102.putInt("error_code", r100);
        r102.putInt(KEY_LANE_TYPE, r101);
        return r102;
    }

    public byte[] dataDecrypt(String r100, String r101) {
        if (r101 != null) goto L5;
    L13:
        k67.b.c(TAG, "dataDecrypt failed: invalid data (null, empty)");
        return null;
    L5:
        if (r101.length() == 0) goto L13;
        return dataDecryptBytes(r100, Base64.decode(r101, 8));
    L10:
        e = move-exception;
        k67.b.c(TAG, "dataDecrypt failed: invalid Base64 data: " + e.getMessage());
        return null;
    }

    public byte[] dataDecryptBytes(String r100, byte[] r101) {
        String r102 = TAG;
        k67.b.a(r102, "dataDecryptBytes called: sessionId=" + r100);
        if (isValidString(r100) == true) goto L6;
        k67.b.c(r102, "dataDecryptBytes failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r101 != null) goto L8;
    L34:
        k67.b.c(r102, "dataDecryptBytes failed: invalid data (null, empty)");
        return null;
    L8:
        if (r101.length == 0) goto L34;
        a r103 = this.sessionContextCache.get(r100);
        if (r103 != null) goto L36;
        k67.b.c(r102, "dataDecryptBytes failed: session not found");
        return null;
    L36:
        k67.b.a(r102, "dataDecryptBytes encodedLen=" + r101.length);     // Catch: Exception -> L31
        b r104 = b.a(r101);     // Catch: Exception -> L31
        EncryptedPayloadTlv r105 = r104.f266696a;     // Catch: Exception -> L31
        byte[] r106 = r104.f266697b;     // Catch: Exception -> L31
        StringBuilder r107 = new StringBuilder("dataDecryptBytes TLV JSON:\n");     // Catch: Exception -> L31
        r105.getClass();     // Catch: Exception -> L31
        r107.append(GsonProtectorUtils.toJson(EncryptedPayloadTlv.f266683a, r105));     // Catch: Exception -> L31
        k67.b.a(r102, r107.toString());     // Catch: Exception -> L31
        EncryptedPayloadTlv.b r108 = r105.contentInfoMeta;     // Catch: Exception -> L31
        if (r108 == null) goto L29;
        EncryptedPayloadTlv.f r109 = r108.otherKeyAttribute;     // Catch: Exception -> L31
        if (r109 == null) goto L29;
        byte[] r110 = r109.nonce;     // Catch: Exception -> L31
        if (r110 == null) goto L29;
        if (r106 != null) goto L23;
    L27:
        k67.b.c(r102, "dataDecryptBytes failed: no ciphertext in Body");     // Catch: Exception -> L31
        return null;
    L23:
        if (r106.length == 0) goto L27;
        k67.b.a(r102, "dataDecryptBytes sessionKey=" + com.bytedance.privacy.pcc.a.e(r103.f266694f) + " nonce=" + com.bytedance.privacy.pcc.a.e(r110) + " ciphertextLen=" + r106.length);     // Catch: Exception -> L31
        byte[] r111 = r103.f266694f;     // Catch: Exception -> L31
        Cipher r112 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L31
        r112.init(2, new SecretKeySpec(r111, CryptoConst.ALGORITHM_AES), new GCMParameterSpec(128, r110));     // Catch: Exception -> L31
        byte[] r113 = r112.doFinal(r106);     // Catch: Exception -> L31
        k67.b.a(r102, "dataDecryptBytes success: plaintextLen=" + r113.length);     // Catch: Exception -> L31
        return r113;
    L29:
        k67.b.c(r102, "dataDecryptBytes failed: missing ContentInfoMeta or nonce");     // Catch: Exception -> L31
        return null;
    L31:
        e = move-exception;
        k67.b.c(TAG, "dataDecryptBytes exception: " + e.getMessage());
        return null;
    }

    public String dataEncrypt(String r100, byte[] r101) {
        byte[] r102 = dataEncryptBytes(r100, r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        return Base64.encodeToString(r102, 11);
    }

    public byte[] dataEncryptBytes(String r110, byte[] r111) {
        String r112 = TAG;
        k67.b.a(r112, "dataEncryptBytes called: sessionId=" + r110);
        if (isValidString(r110) == true) goto L6;
        k67.b.c(r112, "dataEncryptBytes failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r111 != null) goto L9;
        k67.b.c(r112, "dataEncryptBytes failed: data is null");
        return null;
    L9:
        a r113 = this.sessionContextCache.get(r110);
        if (r113 != null) goto L47;
        k67.b.c(r112, "dataEncryptBytes failed: session not found");
        return null;
    L47:
        k67.b.a(r112, "dataEncryptBytes sessionKey=" + com.bytedance.privacy.pcc.a.e(r113.f266694f));     // Catch: Exception -> L42
        byte[] r114 = new byte[12];     // Catch: Exception -> L42
        new SecureRandom().nextBytes(r114);     // Catch: Exception -> L42
        k67.b.a(r112, "dataEncryptBytes nonce=" + com.bytedance.privacy.pcc.a.e(r114) + " plainLen=" + r111.length);     // Catch: Exception -> L42
        byte[] r100 = com.bytedance.privacy.pcc.a.a(r113.f266694f, r114, r111);     // Catch: Exception -> L42
        StringBuilder r115 = new StringBuilder("dataEncryptBytes ciphertextLen=");     // Catch: Exception -> L42
        r115.append(r100.length);     // Catch: Exception -> L42
        k67.b.a(r112, r115.toString());     // Catch: Exception -> L42
        EncryptedPayloadTlv r116 = new EncryptedPayloadTlv();     // Catch: Exception -> L42
        EncryptedPayloadTlv.e r117 = new EncryptedPayloadTlv.e();     // Catch: Exception -> L42
        r116.metaInfo = r117;     // Catch: Exception -> L42
        r117.version = 2;     // Catch: Exception -> L42
        r117.contentType = 1;     // Catch: Exception -> L42
        EncryptedPayloadTlv.a r118 = new EncryptedPayloadTlv.a();     // Catch: Exception -> L42
        AppInfo r119 = r113.f266689a;     // Catch: Exception -> L42
        r118.appId = r119.appId;     // Catch: Exception -> L42
        r118.serviceId = r119.appSvcId;     // Catch: Exception -> L42
        r118.bizType = r113.f266690b;     // Catch: Exception -> L42
        r118.sessionKeyId = r110.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L42
        String r101 = r113.f266691c;     // Catch: Exception -> L42
        if (r101 == null) goto L16;
        byte[] r102 = r101.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L42
    L17:
        r118.accessToken = r102;     // Catch: Exception -> L42
        r116.metaInfo.bizAttribute = r118;     // Catch: Exception -> L42
        byte[] r103 = com.bytedance.privacy.pcc.a.b(r113.f266692d.getPublic());     // Catch: Exception -> L42
        k67.b.a(r112, "dataEncryptBytes ephemeralDhPK=" + com.bytedance.privacy.pcc.a.e(r103));     // Catch: Exception -> L42
        EncryptedPayloadTlv.d r104 = new EncryptedPayloadTlv.d();     // Catch: Exception -> L42
        r116.keyEnvelopePayload = r104;     // Catch: Exception -> L42
        r104.version = 2;     // Catch: Exception -> L42
        r104.envelopeType = 1;     // Catch: Exception -> L42
        r104.keyEnvelopeList = new ArrayList();     // Catch: Exception -> L42
        com.bytedance.privacy.pcc.network.model.c.d r105 = r113.f266693e;     // Catch: Exception -> L42
        byte[] r106 = new byte[16];     // Catch: Exception -> L42
        new SecureRandom().nextBytes(r106);     // Catch: Exception -> L42
        k67.b.e(r112, "dataEncryptBytes keyId=" + r105.a() + " keyType=" + r105.b() + " keyVer=" + r105.c() + " salt=" + com.bytedance.privacy.pcc.a.e(r106));     // Catch: Exception -> L42
        if (r105.a() != null) goto L22;
        k67.b.c(r112, "dataEncryptBytes failed: svcKeyId is null");     // Catch: Exception -> L42
        return null;
    L22:
        if (r105.d() != null) goto L25;
        k67.b.c(r112, "dataEncryptBytes failed: svcPubKey is null (keyId=" + r105.a() + ")");     // Catch: Exception -> L42
        return null;
    L25:
        byte[] r107 = com.bytedance.privacy.pcc.a.c(r113.f266692d.getPrivate(), r103, r105.d(), r106, r113.f266694f);     // Catch: Exception -> L42
        k67.b.a(r112, "dataEncryptBytes encryptedSessionKey=" + com.bytedance.privacy.pcc.a.e(r107));     // Catch: Exception -> L42
        EncryptedPayloadTlv.c r108 = new EncryptedPayloadTlv.c();     // Catch: Exception -> L42
        r108.index = 1;     // Catch: Exception -> L42
        r108.keyIdentify = r105.a().getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L42
        r108.keyVersion = parseKeyVersion(r105.c());     // Catch: Exception -> L42
        r108.keyEncryptionAlgorithm = 1;     // Catch: Exception -> L42
        r108.dhPK = r103;     // Catch: Exception -> L42
        r108.salt = r106;     // Catch: Exception -> L42
        r108.encryptedSessionKey = r107;     // Catch: Exception -> L42
        r116.keyEnvelopePayload.keyEnvelopeList.add(r108);     // Catch: Exception -> L42
        r116.keyEnvelopePayload.keyEnvelopeListSize = 1;     // Catch: Exception -> L42
        EncryptedPayloadTlv.b r109 = new EncryptedPayloadTlv.b();     // Catch: Exception -> L42
        r116.contentInfoMeta = r109;     // Catch: Exception -> L42
        r109.contentType = 1;     // Catch: Exception -> L42
        r109.contentEncryptionAlgorithm = 1;     // Catch: Exception -> L42
        EncryptedPayloadTlv.f r120 = new EncryptedPayloadTlv.f();     // Catch: Exception -> L42
        r120.nonce = r114;     // Catch: Exception -> L42
        r116.contentInfoMeta.otherKeyAttribute = r120;     // Catch: Exception -> L42
        EncryptedPayloadTlv.i r121 = new EncryptedPayloadTlv.i();     // Catch: Exception -> L42
        EncryptedPayloadTlv.e r122 = r116.metaInfo;     // Catch: Exception -> L42
        if (r122 == null) goto L28;
        r121.c(256, EncryptedPayloadTlv.c(r122));     // Catch: Exception -> L42
    L28:
        EncryptedPayloadTlv.d r123 = r116.keyEnvelopePayload;     // Catch: Exception -> L42
        if (r123 == null) goto L31;
        r121.c(512, EncryptedPayloadTlv.b(r123));     // Catch: Exception -> L42
    L31:
        EncryptedPayloadTlv.b r124 = r116.contentInfoMeta;     // Catch: Exception -> L42
        if (r124 == null) goto L45;
        r121.c(ISmModel.VERSION_0300, EncryptedPayloadTlv.a(r124));     // Catch: Exception -> L42
    L45:
        byte[] r125 = c.b(this.appContext, r121.a());     // Catch: Exception -> L38
        EncryptedPayloadTlv.g r126 = new EncryptedPayloadTlv.g();     // Catch: Exception -> L38
        r126.signatureAlgorithm = 1;     // Catch: Exception -> L38
        r126.contentSignature = r125;     // Catch: Exception -> L38
        r116.signContentInfo = r126;     // Catch: Exception -> L38
        k67.b.a(r112, "dataEncryptBytes TLV JSON:\n" + GsonProtectorUtils.toJson(EncryptedPayloadTlv.f266683a, r116));     // Catch: Exception -> L42
        byte[] r127 = new b(r116, r100).b();     // Catch: Exception -> L42
        k67.b.a(r112, "dataEncryptBytes success: encodedLen=" + r127.length);     // Catch: Exception -> L42
        return r127;
    L38:
        e = move-exception;
        k67.b.c(TAG, "dataEncryptBytes failed: sign TLV: " + e.getMessage());     // Catch: Exception -> L42
        return null;
    L16:
        r102 = new byte[0];     // Catch: Exception -> L42
    L42:
        e = move-exception;
        k67.b.c(TAG, "dataEncryptBytes exception: " + Log.getStackTraceString(e));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public Bundle init(AppInfo r410, Bundle r411) {
        String r100 = ")";
        String r101 = " svcId=";
        String r102 = "pcc_channel";
        if (this.appContext != null) goto L7;
        k67.b.c(TAG, "init failed: context not attached");
        return createResultBundle(-31, 1);
    L7:
        if (isValidAppInfo(r410) == true) goto L10;
        k67.b.c(TAG, "init failed: invalid params (null, empty, or exceeds max length)");
        return createResultBundle(-2, 1);
    L10:
        LaneType r103 = LaneType.CPU_NORMAL;
        if (r411.containsKey(KEY_LANE_TYPE) == false) goto L17;
        int r104 = r411.getInt(KEY_LANE_TYPE, r103.getValue());
        if (LaneType.isValid(r104) == true) goto L16;
        k67.b.c(TAG, "init failed: invalid lane_type=" + r104 + " (must be 0-3)");
        return createResultBundle(-2, r103);
    L16:
        r103 = LaneType.fromValue(r104);
    L17:
        String r105 = TAG;
        k67.b.e(r105, "init called: appId=" + r410.appId + ", appSvcId=" + r410.appSvcId + ", rpdid=" + r410.rpdid + ", rpuid=" + r410.rpuid + ", clientLaneType=" + r103);
        com.bytedance.privacy.pcc.network.model.c r106 = queryChannelFromDb(r410);
        if (r106 != null) goto L20;
    L31:
        k67.b.e(r105, "init: no valid cached channel, proceeding with network flow");
        HashMap r107 = new HashMap();
        r107.put(HEADER_LANE_TYPE, String.valueOf(r103.getValue()));
        String r110 = UUID.randomUUID().toString();
        g67.a.a().getClass();
        String r111 = "https://opcc-gateway-boe.bytedance.net";
        if (e67.b.a().b() == false) goto L34;
        String r108 = "https://opcc-gateway-boe.bytedance.net";
    L35:
        String r109 = r108.concat("/opcc/v2/auth/get/challenge");
        String r112 = "x-requestId";
        Request.Builder r113 = new Request.Builder().url(r109).get().addHeader("x-requestId", r110).addHeader("x-timestamp", String.valueOf(System.currentTimeMillis()));
        e67.b.a().b();
        Iterator r114 = r107.entrySet().iterator();
    L37:
        if (r114.hasNext() == false) goto L39;
        Map.Entry r115 = (Map.Entry) r114.next();
        Iterator r210 = r114;
        r113.addHeader((String) r115.getKey(), (String) r115.getValue());
        r111 = r111;
        r114 = r210;
        goto L37
    L39:
        String r211 = r111;
        Request r116 = r113.build();
        String r117 = g67.a.f480168a;
        k67.b.a(r117, "PCC GetChallenge request: " + r109);
        int r118 = 1;
    L40:
        String r212 = "";
        String r213 = r112;
        String r214 = r110;
        String r215 = r100;
        String r310 = r101;
        String r311 = r102;
        if (r118 > 3) goto L96;
        Response r119 = g67.a.f480169b.newCall(r116).execute();     // Catch: Exception -> L81 IOException -> L83 ConnectException -> L86 SocketTimeoutException -> L89
    L65:
        th = th;
    L67:
        Throwable r120 = th;
    L68:
        if (r119 == null) goto L331;
        r119.close();     // Catch: Throwable -> L71
        throw r120;     // Catch: IOException -> L75 ConnectException -> L77 SocketTimeoutException -> L79 Exception -> L275
    L71:
        th = move-exception;
        r120.addSuppressed(th);     // Catch: IOException -> L75 ConnectException -> L77 SocketTimeoutException -> L79 Exception -> L275
        throw r120;     // Catch: IOException -> L75 ConnectException -> L77 SocketTimeoutException -> L79 Exception -> L275
    L331:
        throw r120;     // Catch: IOException -> L75 ConnectException -> L77 SocketTimeoutException -> L79 Exception -> L275
    L44:
        if (r119.body() != null) goto L304;
        String r121 = r212;
    L50:
        if (r119.isSuccessful() == true) goto L292;
        k67.b.c(r117, "PCC GetChallenge attempt " + r118 + ": HTTP " + r119.code() + " body=" + r121);     // Catch: Throwable -> L63
    L320:
        r119.close();     // Catch: IOException -> L75 ConnectException -> L77 SocketTimeoutException -> L79 Exception -> L275
    L93:
        if (r118 >= 3) goto L95;
        Thread.sleep(500);     // Catch: InterruptedException -> L274
    L95:
        r118 = r118 + 1;
        r112 = r213;
        r110 = r214;
        r100 = r215;
        r101 = r310;
        r102 = r311;
        r116 = r116;
    L77:
        e = e;
    L88:
        k67.b.c(r117, "PCC GetChallenge attempt " + r118 + ": ConnectException: " + e.getMessage());
    L79:
        e = e;
    L91:
        k67.b.c(r117, "PCC GetChallenge attempt " + r118 + ": SocketTimeoutException: " + e.getMessage());
    L75:
        e = e;
    L85:
        k67.b.c(r117, "PCC GetChallenge attempt " + r118 + ": IOException: " + e.getMessage());
    L82:
        k67.b.b(r117, "PCC GetChallenge attempt " + r118 + ": unexpected exception: ");
        goto L93
    L292:
        k67.b.a(r117, "PCC GetChallenge response: " + r121);     // Catch: Throwable -> L63
        com.bytedance.privacy.pcc.network.model.a r122 = com.bytedance.privacy.pcc.network.model.a.a(r121);     // Catch: Throwable -> L63
        String r123 = r122.f266700a;     // Catch: Throwable -> L63
        if (r123 != null) goto L56;
    L59:
        k67.b.c(r117, "PCC GetChallenge attempt " + r118 + ": nonce empty in response");     // Catch: Throwable -> L63
        goto L320
    L56:
        if (r123.isEmpty() == true) goto L59;
        r119.close();     // Catch: IOException -> L75 ConnectException -> L77 SocketTimeoutException -> L79 Exception -> L275
    L97:
        if (r122 != null) goto L99;
    L270:
        k67.b.c(TAG, "init failed: get PCC challenge failed");
        return createResultBundle(-31, r103);
    L99:
        if (TextUtils.isEmpty(r122.f266700a) == true) goto L270;
        String r124 = r122.f266700a;
        LaneType r125 = LaneType.fromValue(r122.getType());
        LaneType r126 = LaneType.negotiate(r103, r125);
        String r127 = TAG;
        k67.b.e(r127, "Lane routing decision: client=" + r103 + ", server=" + r125 + ", final=" + r126);
        StringBuilder r128 = new StringBuilder("PCC challenge obtained, nonce=");
        r128.append(r124);
        k67.b.e(r127, r128.toString());
        r107.put(HEADER_LANE_TYPE, String.valueOf(r126.getValue()));
        String r129 = c.a(this.appContext, r124, r410.rpdid, r410.rpuid);     // Catch: Exception -> L267
        f67.b r130 = this.channelDb;
        String r131 = r410.rpdid;
        String r132 = r410.rpuid;
        LaneType r312 = r103;
        String r133 = r410.appId;
        String r134 = r410.appSvcId;
        r130.getClass();
        String r135 = f67.b.f475713b;
        String r313 = ": SocketTimeoutException: ";
        String r314 = ": ConnectException: ";
        String r315 = ": IOException: ";
        String[] r136 = new String[4];     // Catch: Exception -> L124
        r136[0] = r133;     // Catch: Exception -> L124
        r136[1] = r134;     // Catch: Exception -> L122
        r136[2] = r131;     // Catch: Exception -> L122
        r136[3] = r132;     // Catch: Exception -> L122
        String r316 = ": unexpected exception: ";
        String r137 = r311;
        int r138 = r130.f475714a.getWritableDatabase().delete(r137, "app_id=? AND svc_id=? AND (rpdid!=? OR rpuid!=?)", r136);     // Catch: Exception -> L120
        StringBuilder r139 = new StringBuilder("deleteOtherRpuidChannels: deleted ");     // Catch: Exception -> L120
        r139.append(r138);     // Catch: Exception -> L120
        r139.append(" rows for appId=");     // Catch: Exception -> L120
        r139.append(r133);     // Catch: Exception -> L120
        String r140 = r310;
        r139.append(r140);     // Catch: Exception -> L118
        r139.append(r134);     // Catch: Exception -> L118
        r139.append(" (keeping rpdid=");     // Catch: Exception -> L118
        r139.append(r131);     // Catch: Exception -> L118
        r139.append(" rpuid=");     // Catch: Exception -> L118
        r139.append(r132);     // Catch: Exception -> L118
        String r141 = r215;
        r139.append(r141);     // Catch: Exception -> L116
        k67.b.e(r135, r139.toString());     // Catch: Exception -> L116
    L129:
        k67.b.e(TAG, "init: cleaned up " + r138 + " old channel(s) for other rpuids");
        String r142 = String.valueOf(System.currentTimeMillis());
        byte[] r143 = new byte[8];
        new SecureRandom().nextBytes(r143);
        String r144 = com.bytedance.privacy.pcc.a.e(r143);
        String r145 = Base64.encodeToString(GsonProtectorUtils.toJson(new GsonBuilder().disableHtmlEscaping().create(), new com.bytedance.privacy.pcc.network.model.b.a(r144, r410)).getBytes(StandardCharsets.UTF_8), 11);
        String r146 = GsonProtectorUtils.toJson(new GsonBuilder().disableHtmlEscaping().create(), new com.bytedance.privacy.pcc.network.model.b(r129, r145, Base64.encodeToString(c.b(this.appContext, (r214 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r142 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r145).getBytes(StandardCharsets.UTF_8)), 11)));
        g67.a.a().getClass();
        if (e67.b.a().b() == false) goto L134;
        String r147 = r211;
    L135:
        String r148 = r147.concat("/opcc/v2/auth/create/channel");
        String r149 = r141;
        Request.Builder r150 = new Request.Builder().url(r148).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r146)).addHeader("Content-Type", "application/json").addHeader(r213, r214).addHeader("x-timestamp", r142);
        e67.b.a().b();
        Iterator r151 = r107.entrySet().iterator();
    L137:
        if (r151.hasNext() == false) goto L139;
        Map.Entry r152 = (Map.Entry) r151.next();
        r150.addHeader((String) r152.getKey(), (String) r152.getValue());
        goto L137
    L139:
        Request r153 = r150.build();
        String r154 = g67.a.f480168a;
        k67.b.a(r154, "PCC CreateChannel request: " + r148);
        k67.b.a(r154, "PCC CreateChannel request body: " + r146);
        int r155 = 1;
        int r156 = 3;
    L140:
        if (r155 > r156) goto L202;
        Response r157 = g67.a.f480169b.newCall(r153).execute();     // Catch: Exception -> L186 IOException -> L188 ConnectException -> L192 SocketTimeoutException -> L195
    L173:
        th = th;
    L175:
        Throwable r158 = th;
        if (r157 == null) goto L333;
        r157.close();     // Catch: Throwable -> L179
        throw r158;     // Catch: IOException -> L156 ConnectException -> L158 SocketTimeoutException -> L160 Exception -> L273
    L179:
        th = move-exception;
        r158.addSuppressed(th);     // Catch: IOException -> L156 ConnectException -> L158 SocketTimeoutException -> L160 Exception -> L273
        throw r158;     // Catch: IOException -> L156 ConnectException -> L158 SocketTimeoutException -> L160 Exception -> L273
    L333:
        throw r158;     // Catch: IOException -> L156 ConnectException -> L158 SocketTimeoutException -> L160 Exception -> L273
    L143:
        if (r157.body() == null) goto L145;
        String r159 = r157.body().string();     // Catch: Throwable -> L173
    L147:
        String r160 = r212;
        String r161 = r157.header("x-responseId", r160);     // Catch: Throwable -> L170
        if (r157.isSuccessful() == true) goto L302;
        Request r162 = r153;
        r212 = r160;
        k67.b.c(r154, "PCC CreateChannel attempt " + r155 + ": HTTP " + r157.code() + " body=" + r159);     // Catch: Throwable -> L168
        r157.close();     // Catch: IOException -> L156 ConnectException -> L158 SocketTimeoutException -> L160 Exception -> L273
        String r163 = r313;
        String r164 = r314;
        String r165 = r315;
    L198:
        r156 = 3;
        if (r155 >= 3) goto L201;
        Thread.sleep(500);     // Catch: InterruptedException -> L272
    L201:
        r155 = r155 + 1;
        r313 = r163;
        r315 = r165;
        r314 = r164;
        r153 = r162;
    L158:
        e = e;
    L184:
        r165 = r315;
        String r166 = r316;
        StringBuilder r167 = new StringBuilder("PCC CreateChannel attempt ");
        r167.append(r155);
        r164 = r314;
        r167.append(r164);
        r167.append(e.getMessage());
        k67.b.c(r154, r167.toString());
        r316 = r166;
        r163 = r313;
    L160:
        e = e;
    L185:
        r164 = r314;
        r165 = r315;
        String r168 = r316;
        StringBuilder r169 = new StringBuilder("PCC CreateChannel attempt ");
        r169.append(r155);
        r316 = r168;
        r163 = r313;
        r169.append(r163);
        r169.append(e.getMessage());
        k67.b.c(r154, r169.toString());
    L156:
        e = e;
    L183:
        String r170 = r316;
        StringBuilder r171 = new StringBuilder("PCC CreateChannel attempt ");
        r171.append(r155);
        r165 = r315;
        r171.append(r165);
        r171.append(e.getMessage());
        k67.b.c(r154, r171.toString());
    L191:
        r316 = r170;
        r163 = r313;
        r164 = r314;
    L187:
        StringBuilder r172 = new StringBuilder("PCC CreateChannel attempt ");
        r172.append(r155);
        r170 = r316;
        r172.append(r170);
        k67.b.b(r154, r172.toString());
        r165 = r315;
    L168:
        th = th;
        goto L175
    L302:
        StringBuilder r173 = new StringBuilder();     // Catch: Throwable -> L162
        r212 = r160;
        r173.append("PCC CreateChannel response: ");     // Catch: Throwable -> L168
        r173.append(r159);     // Catch: Throwable -> L168
        k67.b.a(r154, r173.toString());     // Catch: Throwable -> L168
        com.bytedance.privacy.pcc.network.model.c r174 = com.bytedance.privacy.pcc.network.model.c.d(r159, r161);     // Catch: Throwable -> L168
        r157.close();     // Catch: IOException -> L156 ConnectException -> L158 SocketTimeoutException -> L160 Exception -> L273
        com.bytedance.privacy.pcc.network.model.c r175 = r174;
    L203:
        if (r175 != null) goto L207;
        k67.b.c(TAG, "init failed: createChannel returned null");
        return createResultBundle(-31, r126);
    L207:
        if (verifyCloudSignature(r175) == true) goto L211;
        k67.b.c(TAG, "init failed: cloud response signature verification failed");
        return createResultBundle(-31, r126);
    L211:
        if (verifyEvidenceToken(r175, r124, r144, r410) == true) goto L214;
        k67.b.c(TAG, "init failed: evidence token verification failed");
        return createResultBundle(-31, r126);
    L214:
        int r176 = r312.getValue();
        int r177 = r125.getValue();
        int r178 = r126.getValue();
        f67.a r179 = new f67.a(r176, r177, r178);
        f67.b r180 = this.channelDb;
        String r181 = r410.rpdid;
        String r182 = r410.rpuid;
        String r183 = r410.appId;
        String r184 = r410.appSvcId;
        r180.getClass();
        String r185 = f67.b.f475713b;
    L218:
        e = move-exception;
        k67.b.c(r185, "save exception: " + e.getMessage());
    L243:
        boolean r186 = false;
    L244:
        if (r186 == true) goto L247;
        k67.b.c(TAG, "init warning: failed to persist channel data to DB");
    L247:
        if (this.channelDb.b(r410.rpdid, r410.rpuid, r410.appId, r410.appSvcId, r175) == true) goto L249;
        k67.b.c(TAG, "init warning: failed to save key attestation history");
    L249:
        String r187 = TAG;
        StringBuilder r188 = new StringBuilder("init success, channelId=");
        com.bytedance.privacy.pcc.network.model.c.b r189 = r175.f266703a;
        if (r189 == null) goto L252;
        String r190 = com.bytedance.privacy.pcc.network.model.c.b.d(r189);
    L253:
        r188.append(r190);
        r188.append(", finalLaneType=");
        r188.append(r126);
        r188.append(" (value=");
        r188.append(r126.getValue());
        r188.append(r149);
        k67.b.e(r187, r188.toString());
        com.bytedance.privacy.pcc.network.model.c.b r191 = r175.f266703a;
        if (r191 == null) goto L256;
        String r192 = com.bytedance.privacy.pcc.network.model.c.b.d(r191);
    L257:
        String r193 = Base64.encodeToString(GsonProtectorUtils.toJson(new Gson(), new g.a(r410, r192)).getBytes(StandardCharsets.UTF_8), 11);
        String r194 = String.valueOf(System.currentTimeMillis());
        String r195 = GsonProtectorUtils.toJson(new Gson(), new g(r193, Base64.encodeToString(c.b(this.appContext, (r214 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r194 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r193).getBytes(StandardCharsets.UTF_8)), 11)));     // Catch: Exception -> L260
        g67.a.a().getClass();     // Catch: Exception -> L260
        k67.b.e(r187, "init: uploadChannelRet logId=" + g67.a.b(r214, r194, r195));     // Catch: Exception -> L260
    L263:
        return createResultBundle(0, r126);
    L260:
        e = move-exception;
        k67.b.c(TAG, "init: uploadChannelRet sign failed (non-fatal): " + e.getMessage());
        goto L263
    L256:
        r192 = r212;
        goto L257
    L252:
        r190 = r212;
        goto L253
    L216:
        if (r175.c() == null) goto L220;
        com.bytedance.privacy.pcc.network.model.c.C3731c r196 = r175.c();     // Catch: Exception -> L218
        r196.getClass();     // Catch: Exception -> L218
        String r197 = GsonProtectorUtils.toJson(new Gson(), r196);     // Catch: Exception -> L218
    L222:
        if (r175.b() == null) goto L224;
        com.bytedance.privacy.pcc.network.model.c.a r198 = r175.b();     // Catch: Exception -> L218
        r198.getClass();     // Catch: Exception -> L218
        String r199 = GsonProtectorUtils.toJson(new Gson(), r198);     // Catch: Exception -> L218
    L225:
        ContentValues r1100 = new ContentValues();     // Catch: Exception -> L218
        String r317 = r140;
        r1100.put("rpdid", r181);     // Catch: Exception -> L218
        r1100.put("rpuid", r182);     // Catch: Exception -> L218
        r1100.put("app_id", r183);     // Catch: Exception -> L218
        r1100.put("svc_id", r184);     // Catch: Exception -> L218
        com.bytedance.privacy.pcc.network.model.c.b r1101 = r175.f266703a;     // Catch: Exception -> L218
        if (r1101 == null) goto L228;
        String r1102 = com.bytedance.privacy.pcc.network.model.c.b.c(r1101);     // Catch: Exception -> L218
    L229:
        r1100.put("access_token", r1102);     // Catch: Exception -> L218
        com.bytedance.privacy.pcc.network.model.c.b r1103 = r175.f266703a;     // Catch: Exception -> L218
        if (r1103 == null) goto L232;
        String r1104 = com.bytedance.privacy.pcc.network.model.c.b.d(r1103);     // Catch: Exception -> L218
    L233:
        r1100.put("channel_id", r1104);     // Catch: Exception -> L218
        com.bytedance.privacy.pcc.network.model.c.b r1105 = r175.f266703a;     // Catch: Exception -> L218
        if (r1105 == null) goto L236;
        String r1106 = com.bytedance.privacy.pcc.network.model.c.b.e(r1105);     // Catch: Exception -> L218
    L237:
        r1100.put("channel_expiry_time", r1106);     // Catch: Exception -> L218
        r1100.put("service_info", r197);     // Catch: Exception -> L218
        r1100.put("evidence_info", r199);     // Catch: Exception -> L218
        r1100.put("payload_json", r175.f266704b);     // Catch: Exception -> L218
        r1100.put("response_id", r175.f266705c);     // Catch: Exception -> L218
        r1100.put("signature", r175.f266706d);     // Catch: Exception -> L218
        r1100.put("protocol_version", 2);     // Catch: Exception -> L218
        r1100.put("client_lane_type", Integer.valueOf(r176));     // Catch: Exception -> L218
        r1100.put("server_lane_type", Integer.valueOf(r177));     // Catch: Exception -> L218
        r1100.put("final_lane_type", Integer.valueOf(r178));     // Catch: Exception -> L218
        if (r180.f475714a.getWritableDatabase().insertWithOnConflict(r137, null, r1100, 5) != (-1)) goto L240;
        k67.b.c(r185, "save: insertWithOnConflict returned -1");     // Catch: Exception -> L218
        goto L243
    L240:
        k67.b.e(r185, "save success: rpdid=" + r181 + " appId=" + r183 + r317 + r184 + " protocolVersion=2 " + r179);     // Catch: Exception -> L218
        r186 = true;
        goto L244
    L236:
        r1106 = r212;
        goto L237
    L232:
        r1104 = r212;
        goto L233
    L228:
        r1102 = r212;
        goto L229
    L224:
        r199 = r212;
        goto L225
    L220:
        r197 = r212;
    L162:
        th = th;
    L170:
        th = th;
        goto L175
    L145:
        r159 = r212;
        goto L147
    L192:
        e = e;
        r162 = r153;
    L195:
        e = e;
        r162 = r153;
    L188:
        e = e;
        r162 = r153;
    L186:
        r162 = r153;
        goto L187
    L202:
        r175 = null;
        goto L203
    L134:
        r147 = "https://opcc-gateway.obriccloud.com";
    L264:
        e = move-exception;
        k67.b.c(TAG, "init failed: sign request: " + e.getMessage());
        return createResultBundle(-31, r126);
    L116:
        e = e;
    L128:
        k67.b.c(r135, "deleteOtherRpuidChannels exception: " + e.getMessage());
        r138 = 0;
    L118:
        e = e;
        r141 = r215;
    L120:
        e = e;
        r141 = r215;
        r140 = r310;
    L122:
        e = e;
        r316 = ": unexpected exception: ";
        r141 = r215;
        r140 = r310;
        r137 = r311;
    L124:
        e = e;
        r316 = ": unexpected exception: ";
        r141 = r215;
        r140 = r310;
        r137 = r311;
    L267:
        e = move-exception;
        k67.b.c(TAG, "init failed: attestation: " + e.getMessage());
        return createResultBundle(-31, r126);
    L63:
        th = th;
        goto L67
    L304:
        r121 = r119.body().string();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        r120 = th;
        goto L68
    L86:
        e = e;
        r116 = r116;
    L89:
        e = e;
        r116 = r116;
    L83:
        e = e;
        r116 = r116;
    L81:
        r116 = r116;
        goto L82
    L96:
        r122 = null;
        goto L97
    L34:
        r108 = "https://opcc-gateway.obriccloud.com";
        goto L35
    L20:
        if (isChannelExpired(r106) == true) goto L31;
        if (r106.f266707e != 2) goto L31;
        f67.a r200 = this.channelDb.a(r410.rpdid, r410.rpuid, r410.appId, r410.appSvcId);
        if (r200 != null) goto L26;
    L28:
        if (r200 == null) goto L31;
        k67.b.e(r105, "init: using valid cached V2 channel " + r200);
        return createResultBundle(0, LaneType.fromValue(r200.f475712c));
    L26:
        if (r200.f475710a == r103.getValue()) goto L28;
        k67.b.e(r105, "init: client lane_type changed (cached=" + r200.f475710a + ", requested=" + r103.getValue() + "), deleting old channel and re-negotiating");
        this.channelDb.delete(r410.rpdid, r410.rpuid, r410.appId, r410.appSvcId);
        goto L31
    }

    private Bundle createResultBundle(int r100, LaneType r101) {
        return createResultBundle(r100, r101.getValue());
    }

    public Bundle openSecuritySession(String r110, AppInfo r111, Bundle r112) {
        String r100 = TAG;
        k67.b.a(r100, "openSecuritySession called: sessionId=" + r110);
        if (isValidString(r110) == true) goto L7;
        k67.b.c(r100, "openSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L7:
        if (isValidAppInfo(r111) == true) goto L10;
        k67.b.c(r100, "openSecuritySession failed: invalid appInfo (null, empty, or exceeds max length)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L10:
        LaneType r101 = LaneType.CPU_NORMAL;
        if (r112.containsKey(KEY_LANE_TYPE) == false) goto L17;
        int r102 = r112.getInt(KEY_LANE_TYPE, r101.getValue());
        if (LaneType.isValid(r102) == true) goto L16;
        k67.b.c(r100, "openSecuritySession failed: invalid lane_type=" + r102 + " (must be 0-3)");
        return createResultBundle(-2, r101);
    L16:
        r101 = LaneType.fromValue(r102);
    L17:
        com.bytedance.privacy.pcc.network.model.c r103 = queryChannelFromDb(r111);
        if (r103 != null) goto L20;
    L31:
        k67.b.a(r100, "openSecuritySession: channel missing or expired, re-initialising");
    L32:
        boolean r104 = true;
        LaneType r113 = r101;
    L34:
        if (r104 == false) goto L43;
        Bundle r105 = init(r111, r112);
        int r106 = r105.getInt("error_code", -31);
        if (r106 == 0) goto L39;
        k67.b.c(r100, "openSecuritySession failed: re-init returned " + r106);
        return r105;
    L39:
        r113 = LaneType.fromValue(r105.getInt(KEY_LANE_TYPE, r101.getValue()));
        r103 = queryChannelFromDb(r111);
        if (r103 != null) goto L43;
        k67.b.c(r100, "openSecuritySession failed: channel still null after re-init");
        return createResultBundle(-31, r113);
    L43:
        com.bytedance.privacy.pcc.network.model.c.C3731c r107 = r103.c();
        if (r107 != null) goto L46;
    L58:
        k67.b.c(r100, "openSecuritySession failed: service key info is empty");
        return createResultBundle(-31, r113);
    L46:
        if (r107.b() == null) goto L58;
        String r108 = com.bytedance.privacy.pcc.a.f266695a;     // Catch: Exception -> L55
        KeyPairGenerator r109 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L55
        r109.initialize(new ECGenParameterSpec("secp256r1"));     // Catch: Exception -> L55
        KeyPair r114 = r109.generateKeyPair();     // Catch: Exception -> L55
        byte[] r115 = new byte[32];
        new SecureRandom().nextBytes(r115);
        com.bytedance.privacy.pcc.network.model.c.d r116 = r107.b();
        Map<String, a> r117 = this.sessionContextCache;
        com.bytedance.privacy.pcc.network.model.c.b r118 = r103.f266703a;
        if (r118 == null) goto L52;
        String r119 = com.bytedance.privacy.pcc.network.model.c.b.c(r118);
    L53:
        r117.put(r110, new a(r111, r119, r114, r116, r115));
        k67.b.a(r100, "openSecuritySession success: sessionId=" + r110 + ", finalLaneType=" + r113.getValue());
        return createResultBundle(0, r113);
    L52:
        r119 = "";
    L55:
        e = move-exception;
        k67.b.c(TAG, "openSecuritySession failed: generate ephemeral key pair: " + e.getMessage());
        return createResultBundle(-31, r113);
    L20:
        if (isChannelExpired(r103) == true) goto L31;
        f67.a r120 = this.channelDb.a(r111.rpdid, r111.rpuid, r111.appId, r111.appSvcId);
        if (r120 != null) goto L25;
    L27:
        if (r120 == null) goto L29;
        LaneType r121 = LaneType.fromValue(r120.f475712c);
    L30:
        r113 = r121;
        r104 = false;
        goto L34
    L29:
        r121 = r101;
        goto L30
    L25:
        if (r120.f475710a == r101.getValue()) goto L27;
        k67.b.e(r100, "openSecuritySession: client lane_type changed (cached=" + r120.f475710a + ", requested=" + r101.getValue() + "), re-initialising");
        goto L32
    }

    private boolean verifyEvidenceToken(com.bytedance.privacy.pcc.network.model.c r100, String r110, String r111, AppInfo r112) {
        com.bytedance.privacy.pcc.network.model.c.a r101 = r100.b();
        if (r101 != null) goto L6;
        k67.b.c(TAG, "verifyEvidenceToken: evidence_info is missing");
        return false;
    L6:
        String r102 = r101.a();
        if (TextUtils.isEmpty(r102) == false) goto L10;
        k67.b.c(TAG, "verifyEvidenceToken: evidence_token is empty");
        return false;
    L10:
        com.bytedance.privacy.pcc.network.model.c.C3731c r103 = r100.c();
        if (r103 == null) goto L13;
        com.bytedance.privacy.pcc.network.model.c.d r104 = r103.b();
    L21:
        EvidenceTokenVerifier.b(r102, r112.appId, r112.appSvcId, r110, r111, r104);     // Catch: Exception -> L18
        k67.b.a(TAG, "verifyEvidenceToken: result=true");     // Catch: Exception -> L18
        return true;
    L18:
        e = move-exception;
        k67.b.c(TAG, "verifyEvidenceToken exception: " + Log.getStackTraceString(e));
        return false;
    L13:
        r104 = null;
        goto L21
    }
}
