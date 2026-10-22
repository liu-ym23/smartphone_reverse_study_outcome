package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.disk.api.CacheHandlerBiz;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements com.larus.disk.api.c {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return CacheHandlerBiz.BIZ_APP_WEBVIEW;
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return "webview";
    }

    @Override // com.larus.disk.api.c
    public final void h(boolean r100, boolean r101) {
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return false;
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        StringBuilder r100 = new StringBuilder();
        File r101 = aa9.a.f2357a.a().getParentFile();
        if (r101 == null) goto L6;
        String r102 = r101.getAbsolutePath();
        if (r102 == null) goto L6;
    L7:
        r100.append(r102);
        r100.append(File.separator);
        r100.append("app_webview");
        return r100.toString();
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.larus.disk.api.c
    public final long getCacheSize() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(a());
        if (r100.exists() == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L10;
        return 0;
    L10:
        return com.larus.utils.r.r(r100);
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        return getCacheSize();
    }
}
