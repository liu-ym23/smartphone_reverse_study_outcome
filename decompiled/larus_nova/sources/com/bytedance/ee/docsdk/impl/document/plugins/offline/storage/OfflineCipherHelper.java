package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.utils.AESUtils;
import com.ss.android.lark.chameleon.idependency.Log;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes18.dex */
public final class OfflineCipherHelper {
    private static final String TAG = "OfflineCipherHelper";
    private boolean isDebug;
    private SecretKey mSecretKey;

    public OfflineCipherHelper(char[] r100) {
        this.isDebug = false;
        setSecretKey(r100);
    }

    private void setSecretKey(char[] r100) {
        this.mSecretKey = AESUtils.getKey(r100);
    }

    public ResourceData aesDecrypt(ResourceData r100) {
        if (r100 != null) goto L4;
    L9:
        return r100;
    L4:
        if (TextUtils.isEmpty(r100.getResvalue()) == true) goto L9;
        Long r101 = Long.valueOf(System.currentTimeMillis());
        r100.setResvalue(AESUtils.Base64DecodeAndDecrypt(r100.getResvalue(), this.mSecretKey));
        if (this.isDebug == false) goto L9;
        Log r102 = Log.INSTANCE;
        Log.d(TAG, "OfflineCipherHelper.aesDecrypt:  " + (System.currentTimeMillis() - r101.longValue()) + "ms");
        goto L9
    }

    public ResourceData aesEncrypt(ResourceData r100) {
        if (r100 != null) goto L4;
    L9:
        return r100;
    L4:
        if (TextUtils.isEmpty(r100.getResvalue()) == true) goto L9;
        Long r101 = Long.valueOf(System.currentTimeMillis());
        r100.setResvalue(AESUtils.encryptAndBase64Encode(r100.getResvalue(), this.mSecretKey));
        if (this.isDebug == false) goto L9;
        Log r102 = Log.INSTANCE;
        Log.d(TAG, "OfflineCipherHelper.aesEncrypt:  " + (System.currentTimeMillis() - r101.longValue()) + "ms");
        goto L9
    }

    public String aesDecrypt(byte[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length == 0) goto L12;
        Long r101 = Long.valueOf(System.currentTimeMillis());
        String r102 = AESUtils.decrypt(r100, this.mSecretKey);
        if (this.isDebug == false) goto L9;
        Log r103 = Log.INSTANCE;
        Log.d(TAG, "OfflineCipherHelper.aesDecrypt:  " + (System.currentTimeMillis() - r101.longValue()) + "ms");
    L9:
        return r102;
    L12:
        return null;
    }

    public byte[] aesEncrypt(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L12;
        Long r101 = Long.valueOf(System.currentTimeMillis());
        byte[] r102 = AESUtils.encrypt(r100, this.mSecretKey);
        if (this.isDebug == false) goto L9;
        Log r103 = Log.INSTANCE;
        Log.d(TAG, "OfflineCipherHelper.aesEncrypt:  " + (System.currentTimeMillis() - r101.longValue()) + "ms");
    L9:
        return r102;
    L12:
        return null;
    }
}
