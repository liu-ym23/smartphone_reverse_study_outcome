package com.huawei.hms.aaid.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.l;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;

/* JADX INFO: loaded from: classes23.dex */
public class PushEncrypter {
    public PushEncrypter() {
    }

    public static String decrypter(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return "";
    L7:
        return AesCbc.decrypt(r101, l.b(r100));
    }

    public static String encrypter(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return "";
    L7:
        return AesCbc.encrypt(r101, l.b(r100));
    }

    public static String encrypterOld(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return "";
    L7:
        return AesCbc.encrypt(r101, l.a(r100));
    }
}
