package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {
    public final Context b;
    public VFSFile c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included") == false) goto L6;
        tt5.a.h("FullPkgResourceInterceptor", "isFullPkgIncluded true");
        return a();
    L6:
        Context r0 = this.b;
        EChannel r2 = EChannel.DOCS_FULLPKG_CHANNEL;
        String r1 = d0.e(r0, r2.toString(), false);
        tt5.a.h("FullPkgResourceInterceptor", "getResource, fullPkg version: " + r1);
    L12:
        e = move-exception;
        tt5.a.e("FullPkgResourceInterceptor", "getResource error", e, false);
        return a();
    L8:
        if (this.c != null) goto L10;
        this.c = d0.j(r2.toString());     // Catch: Exception -> L12
    L10:
        VFSFile r3 = this.c;     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L12
        return c(r3, r1, r2.toString());
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included") == false) goto L6;
        tt5.a.h("FullPkgResourceInterceptor", "isFullPkgIncluded true");
        return false;
    L6:
        EChannel r0 = EChannel.DOCS_FULLPKG_CHANNEL;
        if (d0.m(r0.toString()) == true) goto L9;
        return false;
    L9:
        if (this.c != null) goto L11;
        this.c = d0.j(r0.toString());
    L11:
        VFSFile r1 = this.c;
        Intrinsics.checkNotNull(r1);
        String[] r2 = r1.list();
        if (r2 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L24;
        if (r2 == null) goto L31;
        String r4 = r2[0];
        if (r4 != null) goto L22;
        return false;
    L22:
        if (StringsKt.contains$default(r4, "_temp", false, 2, null) == true) goto L33;
    L28:
        return true;
    L33:
        return false;
    L31:
        return false;
    L24:
        if (r2 == null) goto L26;
        int r5 = r2.length;
    L27:
        if (r5 > 0) goto L28;
        return false;
    L26:
        r5 = 0;
        goto L27
    L14:
        if (r2.length != 1) goto L16;
        r3 = true;
        goto L17
    }

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = r2;
    }
}
