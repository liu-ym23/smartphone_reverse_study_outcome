package com.bytedance.crypto.local;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.obfuscated.h;
import com.bytedance.crypto.obfuscated.i;
import com.bytedance.crypto.obfuscated.j;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.UByte;

/* JADX INFO: loaded from: classes15.dex */
public class MasterKeyManager {
    private static final String MASTER_KEY_ALIAS = "local_master_key";
    private static final int MASTER_KEY_VERSION = 1;
    public static final String TAG = "MasterKeyManager";
    private static volatile MasterKeyManager keyManager;
    private byte[] localMasterKey;

    public MasterKeyManager() {
        this.localMasterKey = null;
    }

    public static MasterKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(MasterKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new MasterKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MasterKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    public byte[] decryptByMasterKey(Context r100, String r101, byte[] r102) {
        if (this.localMasterKey != null) goto L10;
        byte[] r103 = loadMasterKey(r100);
        this.localMasterKey = r103;
        if (r103 != null) goto L10;
        String r104 = TAG;
        String r105 = "Load master key failed!!";
    L7:
        LogUtils.e(r104, r105);
    L9:
        return new byte[0];
    L10:
        byte[] r106 = new byte[4];
        if (r102.length >= 4) goto L15;
        r104 = TAG;
        StringBuilder r107 = new StringBuilder("Input data len is too short! len:");
    L13:
        r107.append(r102.length);
    L14:
        r105 = r107.toString();
        goto L7
    L15:
        System.arraycopy(r102, 0, r106, 0, 4);
        int r108 = CryptoUtils.byteArrayToInt(r106);
        if (r108 == 317657839) goto L19;
        r104 = TAG;
        r107 = new StringBuilder("Cannot parse input cipher data! magic:");
        r107.append(r108);
        goto L14
    L19:
        if (r102.length >= 5) goto L21;
        r104 = TAG;
        r107 = new StringBuilder("Input data len is too short!! len:");
        goto L13
    L21:
        int r109 = r102[4] & UByte.MAX_VALUE;
        if (r109 == 1) goto L25;
        LogUtils.e(TAG, "Input cipher data version is wrong! version:" + r109);
        goto L9
    L25:
        if (r102.length >= 17) goto L27;
        r104 = TAG;
        r107 = new StringBuilder("Input data len is too short!! len:");
        goto L13
    L27:
        byte[] r110 = new byte[12];
        System.arraycopy(r102, 5, r110, 0, 12);
        if (r102.length >= 33) goto L30;
        r104 = TAG;
        r107 = new StringBuilder("Input data len is too short!! len:");
        goto L13
    L30:
        int r111 = r102.length - 17;
        byte[] r112 = new byte[r111];
        System.arraycopy(r102, 17, r112, 0, r111);
        byte[] r113 = AES.gcmXcrypt(2, this.localMasterKey, r101.getBytes(), r110, r112);
        if (r113 != null) goto L33;
    L36:
        r104 = TAG;
        r105 = "Data key decrypt failed!!";
        goto L7
    L33:
        if (r113.length == 0) goto L36;
        return r113;
    }

    public byte[] encryptByMasterKey(Context r100, String r101, byte[] r102) {
        byte[] r103 = this.localMasterKey;
        if (r103 != null) goto L5;
    L6:
        byte[] r104 = loadMasterKey(r100);
        this.localMasterKey = r104;
        if (r104 != null) goto L9;
    L24:
        String r105 = TAG;
        String r106 = "Load master key failed!!";
    L14:
        LogUtils.e(r105, r106);
        return new byte[0];
    L9:
        if (r104.length == 0) goto L24;
    L11:
        byte[] r107 = CryptoUtils.generateSecureRandom(12);
        if (r107.length != 0) goto L16;
        r105 = TAG;
        r106 = "Generate IV failed!!";
        goto L14
    L16:
        byte[] r108 = AES.gcmXcrypt(1, this.localMasterKey, r101.getBytes(), r107, r102);
        if (r108 != null) goto L19;
    L23:
        r105 = TAG;
        r106 = "Data key encrypt failed!!";
        goto L14
    L19:
        if (r108.length == 0) goto L23;
        byte[] r109 = new byte[(r107.length + 5) + r108.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_KEY_CIPHER_MAGIC_NUM), 0, r109, 0, 4);
        r109[4] = 1;
        System.arraycopy(r107, 0, r109, 5, r107.length);
        System.arraycopy(r108, 0, r109, r107.length + 5, r108.length);
        return r109;
    L5:
        if (r103.length != 0) goto L11;
        goto L6
    }

    private boolean isMasterKeyExist(Context r100) {
        Bundle r101 = new Bundle();
        r101.putInt("query_mode", 0);
        if (j.a().a(r100, MASTER_KEY_ALIAS, r101).f204248a == 0) goto L5;
        return false;
    L5:
        return true;
    }

    private byte[] loadMasterKey(Context r100) {
        if (isMasterKeyExist(r100) == true) goto L5;
        byte[] r101 = CryptoUtils.generateSecureRandom(32);
        if (r101.length != 0) goto L10;
        LogUtils.e(TAG, "Generate master key failed!!");
        return new byte[0];
    L10:
        i r102 = new i();
        r102.f204255f = CryptoUtils.byteArrayToHexString(r101);
        r102.f204250a = MASTER_KEY_ALIAS;
        r102.f204251b = "local_key";
        if (j.a().a(r100, r102, new Bundle()).f204232a == 0) goto L14;
        LogUtils.e(TAG, "Store master key failed!!");
        return new byte[0];
    L14:
        return r101;
    L5:
        return queryMasterKey(r100);
    }

    private byte[] queryMasterKey(Context r100) {
        Bundle r101 = new Bundle();
        r101.putInt("query_mode", 2);
        h r102 = j.a().a(r100, MASTER_KEY_ALIAS, r101);
        if (r102.f204248a == 0) goto L7;
        LogUtils.e(TAG, "Query master key failed!!");
        return new byte[0];
    L7:
        return CryptoUtils.hexStringToByteArray(((i) ListProtector.get(r102.f204249b, 0)).f204255f);
    }
}
