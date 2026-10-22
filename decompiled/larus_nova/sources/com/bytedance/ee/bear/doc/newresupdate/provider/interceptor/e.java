package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VFSFile f217986b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        tt5.a.h("GrayResourceInterceptor", "getResource, use gray");
        VFSFile[] r100 = e().listFiles();
        Intrinsics.checkNotNull(r100);
        String r101 = r100[0].getName();
        return c(e(), r101, EChannel.DOCS_GRAY_CHANNEL.toString());
    L5:
        e = move-exception;
        tt5.a.e("GrayResourceInterceptor", "getResource error", e, false);
        return a();
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        boolean r101 = r100.i("spacekit.res.use_grayscale_package", false);
        boolean r102 = d0.m(EChannel.DOCS_FULLPKG_CHANNEL.toString());
        if (r100.g("ccm.mobile.full_pkg_included") == false) goto L13;
        tt5.a.h("GrayResourceInterceptor", "isFullPkgIncluded true");
        if (r101 == false) goto L22;
        String[] r103 = e().list();
        if (r103 == null) goto L9;
        int r104 = r103.length;
    L10:
        if (r104 <= 0) goto L23;
        return true;
    L23:
        return false;
    L9:
        r104 = 0;
        goto L10
    L22:
        return false;
    L13:
        if (r101 == false) goto L24;
        if (r102 == false) goto L25;
        String[] r105 = e().list();
        if (r105 == null) goto L18;
        int r106 = r105.length;
    L19:
        if (r106 <= 0) goto L26;
        return true;
    L26:
        return false;
    L18:
        r106 = 0;
        goto L19
    L25:
        return false;
    L24:
        return false;
    }

    public final VFSFile e() {
        if (this.f217986b != null) goto L5;
        this.f217986b = d0.j(EChannel.DOCS_GRAY_CHANNEL.toString());
    L5:
        VFSFile r100 = this.f217986b;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
