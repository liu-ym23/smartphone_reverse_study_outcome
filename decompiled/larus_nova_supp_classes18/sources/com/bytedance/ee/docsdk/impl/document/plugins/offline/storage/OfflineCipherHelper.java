package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.utils.AESUtils;
import com.ss.android.lark.chameleon.idependency.Log;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfflineCipherHelper {
    private static final String TAG = "OfflineCipherHelper";
    private boolean isDebug;
    private SecretKey mSecretKey;

    public OfflineCipherHelper(char[] r2) {
        this.isDebug = false;
        setSecretKey(r2);
    }

    private void setSecretKey(char[] r1) {
        this.mSecretKey = AESUtils.getKey(r1);
    }

    public ResourceData aesDecrypt(ResourceData r7) {
        if (r7 != null) goto L4;
    L9:
        return r7;
    L4:
        if (TextUtils.isEmpty(r7.getResvalue()) == true) goto L9;
        Long r0 = Long.valueOf(System.currentTimeMillis());
        r7.setResvalue(AESUtils.Base64DecodeAndDecrypt(r7.getResvalue(), this.mSecretKey));
        if (this.isDebug == false) goto L9;
        Log r1 = Log.INSTANCE;
        Log.d(TAG, "OfflineCipherHelper.aesDecrypt:  " + (System.currentTimeMillis() - r0.longValue()) + "ms");
        goto L9
    }

    public ResourceData aesEncrypt(ResourceData r7) {
        if (r7 != null) goto L4;
    L9:
        return r7;
    L4:
        if (TextUtils.isEmpty(r7.getResvalue()) == true) goto L9;
        Long r0 = Long.valueOf(System.currentTimeMillis());
        r7.setResvalue(AESUtils.encryptAndBase64Encode(r7.getResvalue(), this.mSecretKey));
        if (this.isDebug == false) goto L9;
        Log r1 = Log.INSTANCE;
        Log.d(TAG, "OfflineCipherHelper.aesEncrypt:  " + (System.currentTimeMillis() - r0.longValue()) + "ms");
        goto L9
    }

    public String aesDecrypt(byte[] r7) {
        if (r7 != null) goto L4;
        return null;
    L4:
        if (r7.length == 0) goto L12;
        Long r0 = Long.valueOf(System.currentTimeMillis());
        String r8 = AESUtils.decrypt(r7, this.mSecretKey);
        if (this.isDebug == false) goto L9;
        Log r1 = Log.INSTANCE;
        Log.d(TAG, "OfflineCipherHelper.aesDecrypt:  " + (System.currentTimeMillis() - r0.longValue()) + "ms");
    L9:
        return r8;
    L12:
        return null;
    }

    public byte[] aesEncrypt(String r7) {
        if (r7 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r7) == true) goto L12;
        Long r0 = Long.valueOf(System.currentTimeMillis());
        byte[] r8 = AESUtils.encrypt(r7, this.mSecretKey);
        if (this.isDebug == false) goto L9;
        Log r1 = Log.INSTANCE;
        Log.d(TAG, "OfflineCipherHelper.aesEncrypt:  " + (System.currentTimeMillis() - r0.longValue()) + "ms");
    L9:
        return r8;
    L12:
        return null;
    }
}
