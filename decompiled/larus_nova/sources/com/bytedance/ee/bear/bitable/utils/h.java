package com.bytedance.ee.bear.bitable.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.lark.dependency.i;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getQuery();
        String r103 = Uri.encode(r102, "=&");
        if (TextUtils.equals(r102, r103) == false) goto L5;
        return r100;
    L5:
        return r101.buildUpon().clearQuery().encodedQuery(r103).build().toString();
    }

    public static final void b(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        t45.c r103 = (t45.c) k.a(LarkContext.getApplication(), t45.c.class);
        com.bytedance.ee.bear.route.h r104 = (com.bytedance.ee.bear.route.h) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class);
        if (r103.v6(r100) == false) goto L9;
        Bundle r105 = new Bundle();
        r105.putBoolean("force_load_same", true);
        RouteBean r106 = new RouteBean();
        r106.f236649n = r105;
        String r107 = r103.v8(r100);
        if (r107 == null) goto L7;
        r100 = r107;
    L7:
        if (r101 == null) goto L10;
        r100 = ow4.a.a(r100, b.a(r101));
    L10:
        ((i) org.koin.java.a.c(i.class, null, null, 6)).a();
        r104.m9(a(r100), r106);
        return;
    L9:
        r106 = null;
        goto L10
    }
}
