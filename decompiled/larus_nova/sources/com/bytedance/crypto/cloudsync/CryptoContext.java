package com.bytedance.crypto.cloudsync;

import android.content.Context;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.keymanager.SyncKeyManager;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes15.dex */
public class CryptoContext {
    public static final String TAG = "CryptoContext";
    private String mAppId;
    private Context mContext;
    private SecretKey mFileEncryptKey;
    private byte[] mFileKeyCipher;
    private String mFilePath;

    public CryptoContext(Context r100, String r101, String r102) {
        this.mContext = r100;
        this.mFilePath = r101;
        this.mAppId = r102;
    }

    private static SecretKey constructChaCha20Key(byte[] r100) {
        return new SecretKeySpec(r100, CryptoConst.ALGORITHM_CHACHA20);
    }

    public void deinitFileKey() {
        this.mFileEncryptKey = null;
        this.mFileKeyCipher = new byte[0];
    }

    public String getAppId() {
        return this.mAppId;
    }

    public Context getContext() {
        return this.mContext;
    }

    public SecretKey getFileEncryptKey() {
        return this.mFileEncryptKey;
    }

    public byte[] getFileKeyCipher() {
        return this.mFileKeyCipher;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public boolean initFileDecryptKey(byte[] r110) {
        if (this.mContext != null) goto L7;
        LogUtils.e(TAG, "Context is null!!");
        String r100 = this.mAppId;
        int r101 = -2;
        int r102 = 3;
        String r103 = "";
    L5:
        EventTrace.eventTrace(r101, r102, r103, r100, 0, 0);
        return false;
    L7:
        String r104 = TAG;
        LogUtils.i(r104, "file key cipher len:" + r110.length);
        byte[] r105 = SyncKeyManager.getInstance().decryptByKeyManager(this.mContext, this.mAppId, r110, CloudConfig.getInstance().getPkgName(this.mAppId) + this.mAppId);
        if (r105 != null) goto L10;
    L14:
        LogUtils.e(r104, "File key decrypt failed!! key cipher len:" + r110.length);
        r103 = this.mContext.getPackageName();
        r100 = this.mAppId;
        r101 = -4;
        r102 = 3;
        goto L5
    L10:
        if (r105.length == 0) goto L14;
        this.mFileEncryptKey = constructChaCha20Key(r105);
        EventTrace.eventTrace(0, 3, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return true;
    }

    public boolean initFileEncryptKey() {
        if (this.mContext != null) goto L6;
        LogUtils.e(TAG, "Context is null!!");
        EventTrace.eventTrace(-2, 2, "", this.mAppId, 0, 0);
        return false;
    L6:
        SecretKey r100 = CryptoUtils.generateSymmetricKey(CryptoConst.ALGORITHM_CHACHA20, 32);
        if (r100 != null) goto L10;
        LogUtils.e(TAG, "Generate file encrypt key failed!!");
        EventTrace.eventTrace(-100, 2, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return false;
    L10:
        String r101 = TAG;
        LogUtils.d(r101, "file key len:" + r100.getEncoded().length);
        byte[] r102 = SyncKeyManager.getInstance().encryptByKeyManager(this.mContext, this.mAppId, r100.getEncoded(), CloudConfig.getInstance().getPkgName(this.mAppId) + this.mAppId);
        if (r102 != null) goto L13;
    L17:
        LogUtils.e(r101, "File key encrypt failed!!");
        EventTrace.eventTrace(-4, 2, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return false;
    L13:
        if (r102.length == 0) goto L17;
        byte[] r103 = new byte[r102.length];
        this.mFileKeyCipher = r103;
        System.arraycopy(r102, 0, r103, 0, r102.length);
        this.mFileEncryptKey = r100;
        EventTrace.eventTrace(0, 2, this.mContext.getPackageName(), this.mAppId, 0, 0);
        return true;
    }
}
