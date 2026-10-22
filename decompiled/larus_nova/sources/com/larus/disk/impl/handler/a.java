package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.disk.api.CacheHandlerBiz;
import com.larus.disk.api.CacheHandlerBusiness;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.larus.disk.api.c {

    /* JADX INFO: renamed from: com.larus.disk.impl.handler.a$a, reason: collision with other inner class name */
    public static final class C4200a {
    }

    static {
    }

    public a() {
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return CacheHandlerBiz.BIZ_A_LOG;
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return CacheHandlerBusiness.APP_TECH;
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
        return aa9.a.f2357a.c("ALOG", false).getAbsolutePath();
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
