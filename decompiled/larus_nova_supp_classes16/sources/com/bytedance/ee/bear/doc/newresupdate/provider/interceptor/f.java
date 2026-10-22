package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {
    public final g b;
    public final d c;
    public boolean d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        boolean r0 = this.d;
        if (r0 == true) goto L5;
    L10:
        if (r0 == false) goto L12;
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, use hotfix");
        return this.b.b();
    L12:
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, use fullPkg");
        return this.c.b();
    L5:
        if (this.e == false) goto L10;
        e0 r1 = this.b.b();
        e0 r4 = this.c.b();
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, there are both hotfix and fullPkg resource, compare version");
        if (tu5.b.a(r1.b, r4.b) >= 0) goto L9;
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, use fullPkg");
        return r4;
    L9:
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "getResource, use hotfix");
        return r1;
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        this.d = this.b.d();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included") == false) goto L5;
        tt5.a.h("HotfixAndFullPkgResourceInterceptor", "isFullPkgIncluded true");
        boolean r0 = false;
    L6:
        this.e = r0;
        if (this.d == true) goto L9;
        if (r0 == true) goto L9;
        return false;
    L9:
        return true;
    L5:
        r0 = this.c.d();
        goto L6
    }

    public f(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = new g(r2);
        this.c = new d(r2);
    }
}
