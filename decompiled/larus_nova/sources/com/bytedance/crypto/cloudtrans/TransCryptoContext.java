package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class TransCryptoContext {
    private static final String TAG = "TransCryptoContext";
    private final String mAppId;
    private final Context mContext;
    private byte[] mDataIv;
    private final String mDid;
    private SecretKey mEncryptKey;
    private byte[] mKeyCipher;
    private byte[] mKeyCipherHash;

    public TransCryptoContext(Context r100, String r101, String r102) {
        this.mContext = r100;
        this.mAppId = r102;
        this.mDid = r101;
    }

    private byte[] buildFullEncDataKeyCipher(byte[] r100, byte[] r110, boolean r111, SensitiveData r112) {
        LogUtils.d(TAG, "fileEncrypt:" + r111);     // Catch: IOException -> L9
        LogUtils.d(TAG, "keyVersion:" + r112.getKeyVersion());     // Catch: IOException -> L9
        LogUtils.d(TAG, "dataIv:" + CryptoUtils.byteArrayToHexString(r110));     // Catch: IOException -> L9
        LogUtils.d(TAG, "keyCipher:" + CryptoUtils.byteArrayToHexString(r100));     // Catch: IOException -> L9
        LogUtils.d(TAG, "salt:" + CryptoUtils.byteArrayToHexString(r112.getHKDFSalt()));     // Catch: IOException -> L9
        if (r111 == false) goto L6;
        int r113 = CryptoConst.TRANS_FILE_FULL_KEY_MAGIC_NUM;
    L7:
        return TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(r113), TransUtils.longToByteArray(r112.getKeyVersion()), TransUtils.intToByteArray(r110.length + r100.length), r110, r100});
    L6:
        r113 = CryptoConst.STREAM_CIPHER_MAGIC_NUM;
    L10:
        throw new CloudTransException("data full encrypt failed, concatenate error.");
    }

    private byte[] buildPageEncDataKeyCipher(byte[] r100, byte[] r101, SensitiveData r110) {
        byte[] r102 = this.mDid.getBytes(StandardCharsets.UTF_8);     // Catch: IOException -> L4
        byte[] r103 = this.mAppId.getBytes(StandardCharsets.UTF_8);     // Catch: IOException -> L4
        this.mKeyCipherHash = CryptoUtils.messageDigest(r100, "MD5");     // Catch: IOException -> L4
        return TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(CryptoConst.TRANS_FILE_PAGE_KEY_MAGIC_NUM), TransUtils.intToByteArray(1), new byte[]{(byte) r102.length}, r102, new byte[]{(byte) r103.length}, r103, r110.getHKDFSalt(), TransUtils.longToByteArray(r110.getKeyVersion()), TransUtils.intToByteArray(r101.length + r100.length), r101, r100, this.mKeyCipherHash});
    L5:
        throw new CloudTransException("data page encrypt failed, concatenate error.");
    }

    private static SecretKey constructChaCha20Key(byte[] r100) {
        return new SecretKeySpec(r100, CryptoConst.ALGORITHM_CHACHA20);
    }

    public void deInitKey() {
        this.mEncryptKey = null;
        this.mKeyCipher = new byte[0];
    }

    public String getAppId() {
        return this.mAppId;
    }

    public byte[] getDataIv() {
        return this.mDataIv;
    }

    public String getDid() {
        return this.mDid;
    }

    public SecretKey getEncryptKey() {
        return this.mEncryptKey;
    }

    public byte[] getKeyCipher() {
        return this.mKeyCipher;
    }

    public byte[] getKeyCipherHash() {
        return this.mKeyCipherHash;
    }

    public boolean initEncryptKey(SensitiveData r100, boolean r101, boolean r110) {
        if (this.mContext != null) goto L8;
        String r102 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r102);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L31:
        r102 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L31;
        if (r100 != null) goto L14;
    L30:
        r102 = "session key is null!!";
        goto L5
    L14:
        if (r100.getSessionEncryptKey() == null) goto L30;
        SecretKey r103 = CryptoUtils.generateSymmetricKey(CryptoConst.ALGORITHM_CHACHA20, 32);
        if (r103 != null) goto L19;
        r102 = "Generate file encrypt key failed!!";
        goto L5
    L19:
        LogUtils.d(TAG, "file key len:" + r103.getEncoded().length);
        byte[] r104 = new byte[12];
        new SecureRandom().nextBytes(r104);
        byte[] r105 = DataEncryptHelper.encrypt(r103.getEncoded(), constructChaCha20Key(r100.getSessionEncryptKey()), r104, CryptoConst.TRANS_AES_KEY_AAD.getBytes());
        if (r105 != null) goto L22;
    L29:
        r102 = "File key encrypt failed!!";
        goto L5
    L22:
        if (r105.length == 0) goto L29;
        if (r101 == false) goto L26;
        this.mKeyCipher = buildPageEncDataKeyCipher(r105, r104, r100);
    L27:
        this.mEncryptKey = r103;
        return true;
    L26:
        this.mKeyCipher = buildFullEncDataKeyCipher(r105, r104, r110, r100);
        goto L27
    }

    public boolean initFullDecryptKey(byte[] r110, byte[] r111, boolean r112, SensitiveData r113) {
        if (this.mContext != null) goto L8;
        String r114 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r114);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L50:
        r114 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L50;
        LogUtils.i(TAG, "full file key cipher len:" + r110.length);
        byte[] r100 = new byte[4];
        if (r110.length >= 4) goto L16;
        StringBuilder r115 = new StringBuilder("Input data len is too short! len:");
    L15:
        r115.append(r110.length);
        r114 = r115.toString();
        goto L5
    L16:
        System.arraycopy(r110, 0, r100, 0, 4);
        int r101 = CryptoUtils.byteArrayToInt(r100);
        if (r112 == true) goto L19;
    L23:
        if (r112 == true) goto L28;
        if (r101 == 305450445) goto L28;
        StringBuilder r116 = new StringBuilder("Cannot parse input stream cipher data! magic:");
    L21:
        r116.append(r101);
    L22:
        r114 = r116.toString();
    L28:
        if (r110.length >= 12) goto L30;
        r115 = new StringBuilder("Input data len is too short!! len:");
        goto L15
    L30:
        long r102 = TransUtils.bytesToLong(Arrays.copyOfRange(r110, 4, 12));
        LogUtils.d(TAG, "keyVersion:" + r102);
        if (r102 != r113.getKeyVersion()) goto L34;
        byte[] r117 = HKDFHelper.deriveKey(r113.getDeviceShareKey(), r111, r113.getHKDFInfo());
        SecretKeySpec r103 = new SecretKeySpec(r117, CryptoConst.ALGORITHM_AES);
        LogUtils.d(TAG, "sessionKey:" + CryptoUtils.byteArrayToHexString(r117));
        LogUtils.d(TAG, "salt:" + CryptoUtils.byteArrayToHexString(r111));
    L39:
        if (r110.length >= 16) goto L41;
        r115 = new StringBuilder("Input data len is too short!! len:");
        goto L15
    L41:
        int r118 = TransUtils.bytesToInt(Arrays.copyOfRange(r110, 12, 16));
        if (r110.length >= 28) goto L44;
        r115 = new StringBuilder("Input data len is too short!! len:");
        goto L15
    L44:
        byte[] r119 = Arrays.copyOfRange(r110, 16, 28);
        if (r110.length >= 44) goto L47;
        r115 = new StringBuilder("Input data len is too short!! len:");
        goto L15
    L47:
        byte[] r120 = DataEncryptHelper.decrypt(Arrays.copyOfRange(r110, 28, (r118 + 28) - 12), r103, r119, CryptoConst.TRANS_AES_KEY_AAD.getBytes());
        this.mKeyCipher = r110;
        this.mEncryptKey = constructChaCha20Key(r120);
        return true;
    L34:
        if (r113.isOlidKeyExist() == true) goto L36;
    L49:
        r116 = new StringBuilder("key version is error, web version: ");
        r116.append(r102);
        r116.append(", current version: ");
        r116.append(r113.getKeyVersion());
        goto L22
    L36:
        if (r102 != r113.getOldKeyVersion()) goto L49;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r102);
        r103 = new SecretKeySpec(HKDFHelper.deriveKey(r113.getOldDeviceShareKey(), r111, r113.getHKDFInfo()), CryptoConst.ALGORITHM_AES);
        goto L39
    L19:
        if (r101 == 305419896) goto L23;
        r116 = new StringBuilder("Cannot parse input full cipher data! magic:");
        goto L21
    }

    public boolean initPageDecryptKey(byte[] r110, SensitiveData r111) {
        if (this.mContext != null) goto L8;
        String r112 = "Context is null!!";
    L5:
        LogUtils.e(TAG, r112);
        return false;
    L8:
        if (TextUtils.isEmpty(this.mDid) == false) goto L10;
    L63:
        r112 = "did or appid is empty!!";
        goto L5
    L10:
        if (TextUtils.isEmpty(this.mAppId) == true) goto L63;
        if (r110 != null) goto L14;
    L62:
        r112 = "dataKeyCipher is empty!!";
        goto L5
    L14:
        if (r110.length == 0) goto L62;
        LogUtils.i(TAG, "page file key cipher len:" + r110.length);
        byte[] r100 = new byte[4];
        if (r110.length >= 4) goto L20;
        StringBuilder r113 = new StringBuilder("Input data len is too short! len:");
    L19:
        r113.append(r110.length);
        r112 = r113.toString();
        goto L5
    L20:
        System.arraycopy(r110, 0, r100, 0, 4);
        int r101 = CryptoUtils.byteArrayToInt(r100);
        if (r101 == 591751049) goto L25;
        StringBuilder r114 = new StringBuilder("Cannot parse input cipher data! magic:");
        r114.append(r101);
    L23:
        r112 = r114.toString();
        goto L5
    L25:
        if (r110.length >= 8) goto L27;
        r113 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L27:
        byte[] r102 = new byte[4];
        System.arraycopy(r110, 4, r102, 0, 4);
        int r103 = CryptoUtils.byteArrayToInt(r102);
        if (r103 == 1) goto L31;
        r114 = new StringBuilder("Input cipher data version is wrong! version:");
        r114.append(r103);
        goto L23
    L31:
        if (r110.length >= (r111.getExtraInfo().length + 8)) goto L34;
        r113 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L34:
        if (Arrays.equals(r111.getExtraInfo(), Arrays.copyOfRange(r110, 8, r111.getExtraInfo().length + 8)) == true) goto L36;
        r112 = "dId and appId is error, " + CryptoUtils.byteArrayToHexString(Arrays.copyOfRange(r110, 8, r111.getExtraInfo().length + 8));
        goto L5
    L36:
        int r104 = r111.getExtraInfo().length + 8;
        int r105 = r104 + 32;
        if (r110.length >= r105) goto L39;
        r113 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L39:
        byte[] r106 = Arrays.copyOfRange(r110, r104, r105);
        int r107 = r105 + 8;
        if (r110.length >= r107) goto L42;
        r113 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L42:
        long r108 = TransUtils.bytesToLong(Arrays.copyOfRange(r110, r105, r107));
        if (r108 != r111.getKeyVersion()) goto L46;
        SecretKeySpec r109 = new SecretKeySpec(HKDFHelper.deriveKey(r111.getDeviceShareKey(), r106, r111.getHKDFInfo()), CryptoConst.ALGORITHM_AES);
    L50:
        int r115 = r107 + 4;
        if (r110.length >= r115) goto L53;
        r113 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L53:
        int r116 = TransUtils.bytesToInt(Arrays.copyOfRange(r110, r107, r115));
        int r117 = r115 + 12;
        if (r110.length >= r117) goto L56;
        r113 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L56:
        byte[] r118 = Arrays.copyOfRange(r110, r115, r117);
        if (r110.length >= (r117 + 16)) goto L59;
        r113 = new StringBuilder("Input data len is too short!! len:");
        goto L19
    L59:
        this.mEncryptKey = constructChaCha20Key(DataEncryptHelper.decrypt(Arrays.copyOfRange(r110, r117, (r116 + r117) - 12), r109, r118, CryptoConst.TRANS_AES_KEY_AAD.getBytes()));
        return true;
    L46:
        if (r111.isOlidKeyExist() == true) goto L48;
    L61:
        r114 = new StringBuilder("key version is error, web version: ");
        r114.append(r108);
        r114.append(", current version: ");
        r114.append(r111.getKeyVersion());
        goto L23
    L48:
        if (r108 != r111.getOldKeyVersion()) goto L61;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r108);
        r109 = new SecretKeySpec(HKDFHelper.deriveKey(r111.getOldDeviceShareKey(), r106, r111.getHKDFInfo()), CryptoConst.ALGORITHM_AES);
        goto L50
    }

    public void setDataIv(byte[] r100) {
        this.mDataIv = r100;
    }
}
