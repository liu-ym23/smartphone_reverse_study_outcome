package com.bytedance.ee.larkwebview.service.impl;

import com.bytedance.ee.larkwebview.base.LarkWebView;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import otb.h;
import st5.o;

/* JADX INFO: loaded from: classes19.dex */
public final class WebViewPerformanceService implements pt5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f242942a;

    public static final class a {
    }

    static {
    }

    @Override // pt5.b
    public final void E() {
    }

    public WebViewPerformanceService() {
        new CopyOnWriteArraySet();
        this.f242942a = LazyKt.lazy(new WebViewPerformanceService$mPerformanceTimingListener$2(this));
    }

    @Override // pt5.b
    public final void b(LarkWebView r100) {
        if (r100 == null) goto L8;
        o r101 = r100.getServiceManager();
        if (r101 == null) goto L8;
        st5.g r102 = (st5.g) r101.a(st5.g.class);
        if (r102 == null) goto L8;
        otb.e r103 = r102.B();
    L9:
        if (r103 == null) goto L12;
        r103.a((h) this.f242942a.getValue());
        return;
    L12:
        return;
    L8:
        r103 = null;
        goto L9
    }
}
