package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes23.dex */
public class j {
    public static k a(o r100) {
        k r101 = k.f277615a;
        if (r100.v() >= 0) goto L5;
        return r101;
    L5:
        if (r100.v() < k.values().length) goto L7;
        return r101;
    L7:
        return k.values()[r100.v()];
    }

    public static void a(Notification.Builder r100, String r101, o r102) {
        Notification.BigTextStyle r103 = new Notification.BigTextStyle();
        if (TextUtils.isEmpty(r102.g()) == true) goto L6;
        r103.setBigContentTitle(r102.g());
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = null;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        r103.bigText(r101);
    L12:
        r100.setStyle(r103);
    }
}
