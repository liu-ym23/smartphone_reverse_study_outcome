package com.bytedance.ee.bear.bitable.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.lark.dependency.i;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public static final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Uri r0 = UriProtector.parse(r3);
        String r1 = r0.getQuery();
        String r2 = Uri.encode(r1, "=&");
        if (TextUtils.equals(r1, r2) == false) goto L5;
        return r3;
    L5:
        return r0.buildUpon().clearQuery().encodedQuery(r2).build().toString();
    }

    public static final void b(String r5, String r6, Context r7) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r7, "context");
        t45.c r8 = (t45.c) k.a(LarkContext.getApplication(), t45.c.class);
        com.bytedance.ee.bear.route.h r0 = (com.bytedance.ee.bear.route.h) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class);
        if (r8.v6(r5) == false) goto L9;
        Bundle r1 = new Bundle();
        r1.putBoolean("force_load_same", true);
        RouteBean r3 = new RouteBean();
        r3.n = r1;
        String r9 = r8.v8(r5);
        if (r9 == null) goto L7;
        r5 = r9;
    L7:
        if (r6 == null) goto L10;
        r5 = ow4.a.a(r5, b.a(r6));
    L10:
        ((i) org.koin.java.a.c(i.class, null, null, 6)).a();
        r0.m9(a(r5), r3);
        return;
    L9:
        r3 = null;
        goto L10
    }
}
