package com.ss.android.lark.officewebview.service.impl;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import otb.h;
import oxb.n;

/* JADX INFO: loaded from: classes37.dex */
public final class WebViewPerformanceService implements mxb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f437513a;

    public static final class a {
    }

    static {
    }

    @Override // mxb.b
    public final void E() {
    }

    public WebViewPerformanceService() {
        new CopyOnWriteArraySet();
        this.f437513a = LazyKt.lazy(new WebViewPerformanceService$mPerformanceTimingListener$2(this));
    }

    @Override // mxb.b
    public final void b(OfficeWebView r100) {
        if (r100 == null) goto L8;
        n r101 = r100.getServiceManager();
        if (r101 == null) goto L8;
        oxb.f r102 = (oxb.f) r101.a(oxb.f.class);
        if (r102 == null) goto L8;
        otb.e r103 = r102.B();
    L9:
        if (r103 == null) goto L12;
        r103.a((h) this.f437513a.getValue());
        return;
    L12:
        return;
    L8:
        r103 = null;
        goto L9
    }
}
