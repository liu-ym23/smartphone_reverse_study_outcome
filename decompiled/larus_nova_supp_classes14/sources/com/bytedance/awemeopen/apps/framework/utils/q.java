package com.bytedance.awemeopen.apps.framework.utils;

import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q {
    static {
    }

    public static List a() {
        ArrayList r0 = new ArrayList();
        r0.add(new u24.f());
        m54.a r1 = AosExtConfig.b.J();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.a != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        r0.add(new u24.e());
    L10:
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public static List b() {
        ArrayList r0 = new ArrayList();
        r0.add(new u24.f());
        d14.a r1 = b14.a.a;
        if (b14.a.a(l24.b.class).c() == false) goto L6;
        r0.add(new u24.c());
    L6:
        if (b14.a.a(l24.a.class).c() == false) goto L9;
        r0.add(new u24.a());
    L9:
        if (AoLive.b() == false) goto L11;
        r0.add(new u24.d());
    L11:
        m54.a r2 = AosExtConfig.b.J();
        if (r2 == null) goto L16;
        boolean r3 = true;
        if (r2.a != true) goto L16;
    L17:
        if (r3 == false) goto L19;
        r0.add(new u24.e());
    L19:
        return r0;
    L16:
        r3 = false;
        goto L17
    }
}
