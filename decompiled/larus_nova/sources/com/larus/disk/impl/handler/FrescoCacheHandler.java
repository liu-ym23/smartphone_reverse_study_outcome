package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes4.dex */
public final class FrescoCacheHandler implements com.larus.disk.api.d {

    public static final class a {
    }

    static {
    }

    public FrescoCacheHandler() {
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        return 0;
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return "fresco_cache";
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
        return true;
    }

    @Override // com.larus.disk.api.d
    public final boolean g() {
        return false;
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return true;
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        return aa9.a.f2357a.b("image_cache", false).getAbsolutePath();
    }

    @Override // com.larus.disk.api.d
    public final long d() {
        return k.b(new PolarisFileWrapper(a()));
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
    public final boolean c(boolean r100, boolean r101) {
        return com.larus.disk.api.d.a.a(this, r100, r101);
    }

    @Override // com.larus.disk.api.c
    public final void h(boolean r100, boolean r101) {
        if (r101 == false) goto L5;
        k.a(new FrescoCacheHandler$cleanCache$1(this), FrescoCacheHandler$cleanCache$2.INSTANCE);
        return;
    }
}
