package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.disk.api.CacheHandlerBiz;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements com.larus.disk.api.d {
    public o() {
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return CacheHandlerBiz.BIZ_IM_FRESCO_CACHE;
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return "fresco_cache";
    }

    @Override // com.larus.disk.api.d
    public final boolean e(boolean r100) {
        return false;
    }

    @Override // com.larus.disk.api.d
    public final boolean f() {
        return false;
    }

    @Override // com.larus.disk.api.d
    public final boolean g() {
        return false;
    }

    @Override // com.larus.disk.api.c
    public final void h(boolean r100, boolean r101) {
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return true;
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        return aa9.a.f2357a.b(CacheHandlerBiz.BIZ_IM_FRESCO_CACHE, false).getAbsolutePath();
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

    @Override // com.larus.disk.api.d
    public final long d() {
        return getCacheSize();
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        return getCacheSize();
    }

    @Override // com.larus.disk.api.d
    public final boolean c(boolean r100, boolean r101) {
        return com.larus.disk.api.d.a.a(this, r100, r101);
    }
}
