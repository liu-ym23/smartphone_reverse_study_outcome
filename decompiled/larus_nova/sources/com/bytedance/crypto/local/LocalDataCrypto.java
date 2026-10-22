package com.bytedance.crypto.local;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import kotlin.UByte;

/* JADX INFO: loaded from: classes6.dex */
public class LocalDataCrypto {
    public static final String TAG = "LocalDataCrypto";
    private static volatile LocalDataCrypto dataCrypto;
    private Context mContext;

    public LocalDataCrypto() {
    }

    private byte[] bytesDecrypt(Context r100, int r101, String r102, String r110, byte[] r111) {
        byte[] r103 = new byte[4];
        if (r111.length >= 4) goto L9;
        String r104 = TAG;
        StringBuilder r105 = new StringBuilder("Input data len is too short! len:");
    L5:
        r105.append(r111.length);
    L6:
        String r106 = r105.toString();
    L7:
        LogUtils.e(r104, r106);
        return new byte[0];
    L9:
        System.arraycopy(r111, 0, r103, 0, 4);
        int r107 = CryptoUtils.byteArrayToInt(r103);
        if (r107 == 315429581) goto L13;
        r104 = TAG;
        r105 = new StringBuilder("Cannot parse input cipher data! magic:");
        r105.append(r107);
        goto L6
    L13:
        if (r111.length >= 5) goto L15;
        r104 = TAG;
        r105 = new StringBuilder("Input data len is too short!! len:");
        goto L5
    L15:
        int r108 = r111[4] & UByte.MAX_VALUE;
        if (r108 == 1) goto L21;
        if (r108 == 2) goto L21;
        r104 = TAG;
        r105 = new StringBuilder("Input cipher data version is wrong! version:");
        r105.append(r108);
    L21:
        if (r111.length >= 17) goto L23;
        r104 = TAG;
        r105 = new StringBuilder("Input data len is too short for iv! len:");
        goto L5
    L23:
        byte[] r109 = new byte[12];
        System.arraycopy(r111, 5, r109, 0, 12);
        if (r111.length >= 82) goto L26;
        r104 = TAG;
        r105 = new StringBuilder("Input data len is too short for key cipher! len:");
        goto L5
    L26:
        byte[] r112 = new byte[65];
        System.arraycopy(r111, 17, r112, 0, 65);
        if (TextUtils.equals(r102, CryptoConst.ALGORITHM_CHACHA20) == false) goto L29;
        int r113 = 0;
    L31:
        if (r111.length >= (r113 + 82)) goto L33;
        r104 = TAG;
        r105 = new StringBuilder("Input data len is too short for data cipher! len:");
        goto L5
    L33:
        int r114 = r111.length - 82;
        byte[] r115 = new byte[r114];
        System.arraycopy(r111, 82, r115, 0, r114);
        String r116 = r100.getPackageName() + r110;
        byte[] r117 = MasterKeyManager.getInstance().decryptByMasterKey(r100, r116, r112);
        if (r117 != null) goto L36;
    L48:
        r104 = TAG;
        r106 = "Data key decrypt failed!!";
        goto L7
    L36:
        if (r117.length == 0) goto L48;
        if (TextUtils.equals(r102, CryptoConst.ALGORITHM_AES) == false) goto L41;
        byte[] r118 = AES.gcmXcrypt(r101, r117, r116.getBytes(), r109, r115);
    L42:
        if (r118 != null) goto L44;
    L47:
        r104 = TAG;
        r106 = "Data decrypt failed!!";
        goto L7
    L44:
        if (r118.length == 0) goto L47;
        return r118;
    L41:
        r118 = ChaCha20.xcryptBytes(r101, r102, r117, r109, r115);
        goto L42
    L29:
        r113 = 16;
        goto L31
    }

    private byte[] bytesEncrypt(Context r100, int r101, String r102, String r110, byte[] r111) {
        byte[] r103 = CryptoUtils.generateSecureRandom(32);
        if (r103.length != 0) goto L8;
        String r104 = TAG;
        String r105 = "Generate data key failed!!";
    L5:
        LogUtils.e(r104, r105);
    L7:
        return new byte[0];
    L8:
        byte[] r106 = CryptoUtils.generateSecureRandom(12);
        if (r106.length != 0) goto L11;
        r104 = TAG;
        r105 = "Generate IV failed!!";
        goto L5
    L11:
        String r112 = r100.getPackageName() + r110;
        if (TextUtils.equals(r102, CryptoConst.ALGORITHM_AES) == false) goto L14;
        byte[] r107 = AES.gcmXcrypt(r101, r103, r112.getBytes(), r106, r111);
    L15:
        if (r107 != null) goto L17;
    L30:
        r104 = TAG;
        r105 = "Data encrypt failed!!";
        goto L5
    L17:
        if (r107.length == 0) goto L30;
        byte[] r108 = MasterKeyManager.getInstance().encryptByMasterKey(r100, r112, r103);
        if (r108 != null) goto L22;
    L29:
        r104 = TAG;
        r105 = "Data key encrypt failed!!";
        goto L5
    L22:
        if (r108.length == 0) goto L29;
        if (r108.length == 65) goto L27;
        LogUtils.e(TAG, "Data key cipher length is error, length:" + r108.length);
        goto L7
    L27:
        byte[] r109 = new byte[(r108.length + 17) + r107.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_CIPHER_MAGIC_NUM), 0, r109, 0, 4);
        r109[4] = 2;
        System.arraycopy(r106, 0, r109, 5, 12);
        System.arraycopy(r108, 0, r109, 17, 65);
        System.arraycopy(r107, 0, r109, 82, r107.length);
        return r109;
    L14:
        r107 = ChaCha20.xcryptBytes(r101, r102, r103, r106, r111);
        goto L15
    }

    private int checkInputParams(Context r100, int r101, String r102, String r103, byte[] r104) {
        if (r100 != null) goto L7;
        String r105 = TAG;
        String r106 = "Context is null!!";
    L5:
        LogUtils.e(r105, r106);
        return -2;
    L7:
        if (r104 != null) goto L9;
    L35:
        r105 = TAG;
        r106 = "Input data is empty!!";
        goto L5
    L9:
        if (r104.length == 0) goto L35;
        if (r101 != 1) goto L14;
        int r107 = 1048576;
    L16:
        if (r104.length <= r107) goto L20;
        r105 = TAG;
        StringBuilder r108 = new StringBuilder("Input data is too large!! len:");
        r108.append(r104.length);
    L18:
        r106 = r108.toString();
        goto L5
    L20:
        if (TextUtils.isEmpty(r103) == false) goto L22;
        r105 = TAG;
        r106 = "Input alias is empty!!";
        goto L5
    L22:
        if (r101 == 1) goto L27;
        if (r101 == 2) goto L27;
        r105 = TAG;
        r106 = "Input mode is invalid!! mode:" + r101;
    L27:
        if (TextUtils.equals(r102, CryptoConst.ALGORITHM_AES) == false) goto L29;
        return 0;
    L29:
        if (TextUtils.equals(r102, CryptoConst.ALGORITHM_CHACHA20_POLY1305) == false) goto L31;
        return 0;
    L31:
        if (TextUtils.equals(r102, CryptoConst.ALGORITHM_CHACHA20) == true) goto L37;
        r105 = TAG;
        r108 = new StringBuilder("Input algorithm is invalid!! algorithm:");
        r108.append(r102);
        goto L18
    L37:
        return 0;
    L14:
        r107 = CryptoConst.DECRYPT_BYTES_MAX_SIZE;
        goto L16
    }

    public static LocalDataCrypto getInstance() {
        if (dataCrypto != null) goto L15;
        monitor-enter(LocalDataCrypto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (dataCrypto != null) goto L9;
        dataCrypto = new LocalDataCrypto();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LocalDataCrypto.class);     // Catch: Throwable -> L11
    L15:
        return dataCrypto;
    }

    public byte[] bytesXcrypt(int r100, String r101, String r110, byte[] r111) {
        if (checkInputParams(this.mContext, r100, r101, r110, r111) == 0) goto L7;
        LogUtils.e(TAG, "Input param is invalid!!");
        return new byte[0];
    L7:
        if (r100 != 1) goto L11;
        return bytesEncrypt(this.mContext, r100, r101, r110, r111);
    L11:
        return bytesDecrypt(this.mContext, r100, r101, r110, r111);
    }

    public void init(Context r100) {
        this.mContext = r100;
    }
}
