package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {
    public VFSFile b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        tt5.a.h("GrayResourceInterceptor", "getResource, use gray");
        File[] r0 = e().listFiles();
        Intrinsics.checkNotNull(r0);
        String r1 = r0[0].getName();
        return c(e(), r1, EChannel.DOCS_GRAY_CHANNEL.toString());
    L5:
        e = move-exception;
        tt5.a.e("GrayResourceInterceptor", "getResource error", e, false);
        return a();
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r1 = r0.i("spacekit.res.use_grayscale_package", false);
        boolean r3 = d0.m(EChannel.DOCS_FULLPKG_CHANNEL.toString());
        if (r0.g("ccm.mobile.full_pkg_included") == false) goto L13;
        tt5.a.h("GrayResourceInterceptor", "isFullPkgIncluded true");
        if (r1 == false) goto L22;
        String[] r2 = e().list();
        if (r2 == null) goto L9;
        int r4 = r2.length;
    L10:
        if (r4 <= 0) goto L23;
        return true;
    L23:
        return false;
    L9:
        r4 = 0;
        goto L10
    L22:
        return false;
    L13:
        if (r1 == false) goto L24;
        if (r3 == false) goto L25;
        String[] r5 = e().list();
        if (r5 == null) goto L18;
        int r6 = r5.length;
    L19:
        if (r6 <= 0) goto L26;
        return true;
    L26:
        return false;
    L18:
        r6 = 0;
        goto L19
    L25:
        return false;
    L24:
        return false;
    }

    public final VFSFile e() {
        if (this.b != null) goto L5;
        this.b = d0.j(EChannel.DOCS_GRAY_CHANNEL.toString());
    L5:
        VFSFile r0 = this.b;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
