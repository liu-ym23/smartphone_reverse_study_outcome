package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f217984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VFSFile f217985c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.full_pkg_included") == false) goto L6;
        tt5.a.h("FullPkgResourceInterceptor", "isFullPkgIncluded true");
        return a();
    L6:
        Context r100 = this.f217984b;
        EChannel r101 = EChannel.DOCS_FULLPKG_CHANNEL;
        String r102 = d0.e(r100, r101.toString(), false);
        tt5.a.h("FullPkgResourceInterceptor", "getResource, fullPkg version: " + r102);
    L12:
        e = move-exception;
        tt5.a.e("FullPkgResourceInterceptor", "getResource error", e, false);
        return a();
    L8:
        if (this.f217985c != null) goto L10;
        this.f217985c = d0.j(r101.toString());     // Catch: Exception -> L12
    L10:
        VFSFile r103 = this.f217985c;     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L12
        return c(r103, r102, r101.toString());
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.full_pkg_included") == false) goto L6;
        tt5.a.h("FullPkgResourceInterceptor", "isFullPkgIncluded true");
        return false;
    L6:
        EChannel r100 = EChannel.DOCS_FULLPKG_CHANNEL;
        if (d0.m(r100.toString()) == true) goto L9;
        return false;
    L9:
        if (this.f217985c != null) goto L11;
        this.f217985c = d0.j(r100.toString());
    L11:
        VFSFile r101 = this.f217985c;
        Intrinsics.checkNotNull(r101);
        String[] r102 = r101.list();
        if (r102 != null) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == false) goto L24;
        if (r102 == null) goto L31;
        String r104 = r102[0];
        if (r104 != null) goto L22;
        return false;
    L22:
        if (StringsKt.contains$default(r104, ChameleonResConstants.TEMP_SUFFIX, false, 2, null) == true) goto L33;
    L28:
        return true;
    L33:
        return false;
    L31:
        return false;
    L24:
        if (r102 == null) goto L26;
        int r105 = r102.length;
    L27:
        if (r105 > 0) goto L28;
        return false;
    L26:
        r105 = 0;
        goto L27
    L14:
        if (r102.length != 1) goto L16;
        r103 = true;
        goto L17
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f217984b = r100;
    }
}
