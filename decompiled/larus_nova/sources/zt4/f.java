package zt4;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f573590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BitableResourceData f573591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.preload.g.a f573592g;

    @Override // zt4.a
    public final String d() {
        return "mainPage";
    }

    @Override // zt4.a
    public final boolean e() {
        return true;
    }

    @Override // zt4.a
    public final boolean f() {
        return false;
    }

    @Override // zt4.a
    public final boolean g() {
        return false;
    }

    @Override // zt4.a
    public final void a() {
        this.f573581a.A("BITABLE_MAIN_PAGE_PRELOAD_CACHE_END", System.currentTimeMillis());
        com.bytedance.ee.bear.bitable.preload.g.a r100 = this.f573592g;
        if (r100 == null) goto L12;
        BitableResourceData r101 = this.f573591f;
        if (r101 == null) goto L9;
        String r102 = r101.getResValue();
        if (r102 == null) goto L9;
        long r103 = r102.length();
    L10:
        com.bytedance.ee.bear.bitable.preload.g.d(r100, r103, "", "");
        return;
    L9:
        r103 = -1;
        goto L10
    }

    @Override // zt4.a
    public final void b() {
        this.f573581a.A("BITABLE_MAIN_PAGE_PRELOAD_CACHE_START", System.currentTimeMillis());
        this.f573592g = com.bytedance.ee.bear.bitable.preload.g.b("BITABLE_MAIN_PAGE", "Use");
    }

    @Override // zt4.a
    public final boolean h() {
        BitableResourceData r100 = this.f573591f;
        if (r100 == null) goto L10;
        String r101 = r100.getResValue();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.length() > 0) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        BitableResourceData r101 = new BitableResourceData();
        r101.setResValue(r100);
        this.f573591f = r101;
        String r102 = r101.getResValue();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f573590e = r103;
        this.f573583c.countDown();
        return;
    L5:
        if (r102.length() <= 0) goto L7;
        r103 = true;
        goto L8
    }

    public f(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
    }
}
