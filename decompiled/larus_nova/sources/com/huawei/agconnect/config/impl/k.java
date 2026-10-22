package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.huawei.agconnect.config.AesDecrypt;

/* JADX INFO: loaded from: classes23.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AesDecrypt f276737a;

    public k(Context r100, String r101) {
        if (TextUtils.isEmpty(a(r100, r101)) == false) goto L5;
    L8:
        AesDecrypt r102 = new g(r100, r101);
    L9:
        this.f276737a = r102;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L8;
        r102 = new h(r100, r101);
        goto L9
    }

    private String a(Context r100, String r101) {
        String r102 = l.a(r100, r101, "agc_plugin_", "crypto");
        if (r102 == null) goto L14;
        return new String(Hex.decodeHexString(r102), XML.CHARSET_UTF8);
    L8:
        e = move-exception;
        e.getMessage();
        return null;
    L14:
        return null;
    }

    public String a(String r100, String r101) {
        return this.f276737a.decrypt(r100, r101);
    }
}
