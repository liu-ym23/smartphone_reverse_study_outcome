package com.bytedance.ee.bear.bitable.infoarch.nativeview;

import com.alipay.sdk.m.p.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter("DataPreloadDetail", e.f25671s);
        Intrinsics.checkNotNullParameter(r100, "msg");
        tt5.a.h("NativeViewDemand", "preload>>DataPreloadDetail>> " + r100);
    }

    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "msg");
        tt5.a.h("NativeViewDemand", "uiDetail>>" + r100 + ">> " + r101);
    }

    public static final void c(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        tt5.a.h("NativeViewDemand", "update>>data>> " + r100);
        if (r101 == false) goto L6;
        tt5.a.h("NativeViewDemand", "core>> " + r100);
        return;
    }

    public static final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        tt5.a.h("NativeViewDemand", "update>>ui>> " + r100);
        if (r101 == false) goto L6;
        tt5.a.h("NativeViewDemand", "core>> " + r100);
        return;
    }
}
