package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ge;
import com.xiaomi.push.go;
import com.xiaomi.push.hd;
import com.xiaomi.push.service.aj;

/* JADX INFO: loaded from: classes41.dex */
public class MiPushClient4VR {
    public MiPushClient4VR() {
    }

    public static void uploadData(Context r100, String r101) {
        hd r102 = new hd();
        r102.c(go.O.f650a);
        r102.b(b.m8743a(r100).m8744a());
        r102.d(r100.getPackageName());
        r102.a("data", r101);
        r102.a(aj.a());
        u.a(r100).a(r102, ge.f463654i, null);
    }
}
