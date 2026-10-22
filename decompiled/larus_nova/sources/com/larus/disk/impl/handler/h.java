package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.disk.api.CacheHandlerBiz;
import com.larus.disk.api.CacheHandlerBusiness;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements com.larus.disk.api.c {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return CacheHandlerBiz.BIZ_EXTERNAL_TEMP;
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return CacheHandlerBusiness.COMMON_CACHE_TEMP;
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return true;
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        aa9.a.C0042a r100 = aa9.a.f2357a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(CacheHandlerBiz.BIZ_EXTERNAL_TEMP, "subPath");
        aa9.h r101 = r100.f2359b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(CacheHandlerBiz.BIZ_EXTERNAL_TEMP, "subPath");
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.f2370f.getValue(), CacheHandlerBiz.BIZ_EXTERNAL_TEMP);
        r101.g(r102, "getDirOfExternalCache");
        return r102.getAbsolutePath();
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

    @Override // com.larus.disk.api.c
    public final void h(boolean r100, boolean r101) {
        com.larus.utils.l0.b(new g(this));
    }
}
