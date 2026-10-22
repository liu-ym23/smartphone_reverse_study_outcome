package com.larus.disk.impl.handler;

import com.larus.disk.api.CacheHandlerBiz;
import com.larus.disk.api.CacheHandlerBusiness;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class w implements com.larus.disk.api.c {

    public static final class a {
    }

    static {
    }

    public w() {
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return CacheHandlerBiz.BIZ_MMKV;
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return CacheHandlerBusiness.SHARED_PREFERENCES;
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
        return aa9.a.f2357a.c("mmkv", false).getAbsolutePath();
    }

    @Override // com.larus.disk.api.c
    public final long getCacheSize() {
        aa9.a.C0042a r100 = aa9.a.f2357a;
        if (r100.c("mmkv", false).exists() == true) goto L5;
        return 0;
    L5:
        return RangesKt.coerceAtLeast(com.larus.utils.r.r(r100.c("mmkv", false)), 0);
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        return getCacheSize();
    }
}
