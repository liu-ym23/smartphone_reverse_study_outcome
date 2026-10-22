package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.disk.api.CacheHandlerBiz;
import com.larus.disk.api.CacheHandlerBusiness;

/* JADX INFO: loaded from: classes4.dex */
public final class o0 implements com.larus.disk.api.c {

    public static final class a {
    }

    static {
    }

    public o0() {
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return CacheHandlerBiz.BIZ_VOICE_CHECK_FILE;
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return CacheHandlerBusiness.UGC_VOICE;
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
        return aa9.a.f2357a.b(CacheHandlerBiz.BIZ_VOICE_CHECK_FILE, false).getAbsolutePath();
    }

    @Override // com.larus.disk.api.c
    public final long getCacheSize() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(a());
        if (r100.exists() == true) goto L7;
        return 0;
    L7:
        return com.larus.utils.r.r(r100);
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        return getCacheSize();
    }
}
