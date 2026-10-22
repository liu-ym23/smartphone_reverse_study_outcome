package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f217987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f217988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f217989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f217990e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        boolean r100 = this.f217989d;
        if (r100 == true) goto L5;
    L10:
        if (r100 == false) goto L12;
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, use hotfix");
        return this.f217987b.b();
    L12:
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, use fullPkg");
        return this.f217988c.b();
    L5:
        if (this.f217990e == false) goto L10;
        e0 r101 = this.f217987b.b();
        e0 r102 = this.f217988c.b();
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, there are both hotfix and fullPkg resource, compare version");
        if (tu5.b.a(r101.f218008b, r102.f218008b) >= 0) goto L9;
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, use fullPkg");
        return r102;
    L9:
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, use hotfix");
        return r101;
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        this.f217989d = this.f217987b.d();
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.full_pkg_included") == false) goto L5;
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "isFullPkgIncluded true");
        boolean r100 = false;
    L6:
        this.f217990e = r100;
        if (this.f217989d == true) goto L9;
        if (r100 == true) goto L9;
        return false;
    L9:
        return true;
    L5:
        r100 = this.f217988c.d();
        goto L6
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f217987b = new g(r100);
        this.f217988c = new d(r100);
    }
}
