package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public class ho {
    public static <T extends hp<T, ?>> byte[] a(T r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return new hu(new hv.a()).a(r100);
    L7:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e);
        return null;
    }

    public static short a(Context r100, ha r101) {
        gr r102 = r101.m9197a();
        if (r102 != null) goto L5;
    L7:
        String r103 = null;
    L9:
        return m9264a(r100, r101.f777b, r103);
    L5:
        if (r102.m9164a() == null) goto L7;
        r103 = r102.m9164a().get("channel_id");
        goto L9
    }

    public static <T extends hp<T, ?>> void a(T r100, byte[] r101) {
        if (r101 == null) goto L6;
        new hs(new Cif.a(true, true, r101.length)).a(r100, r101);
        return;
    L6:
        throw new ht("the message byte is empty.");
    }

    public static short a(Context r100, String r101) {
        return m9264a(r100, r101, null);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static short m9264a(Context r100, String r101, String r102) {
        int r103 = 0;
        int r104 = g.a(r100, r101, false).a() + 0;
        if (ac.b(r100) == false) goto L5;
        int r105 = 4;
    L6:
        int r106 = r104 + r105;
        if (ac.a(r100) == false) goto L9;
        int r107 = 8;
    L10:
        int r108 = r106 + r107;
        if (com.xiaomi.push.service.af.m9347a(r100) == false) goto L14;
        r103 = 16;
    L14:
        return (short) ((r108 + r103) + a(r100, r101, r102));
    L9:
        r107 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    private static int a(Context r100, String r101, String r102) {
        if (Build.VERSION.SDK_INT < 26) goto L15;
        if (r100 == null) goto L15;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        com.xiaomi.push.service.af r103 = com.xiaomi.push.service.af.a(r100, r101);
        if (r103 == null) goto L15;
        NotificationChannel r104 = r103.m9349a(r103.m9352a(r102));
        if (r104 == null) goto L15;
        if (r104.getImportance() == 0) goto L14;
        return 32;
    L14:
        return 64;
    L15:
        return 0;
    }
}
