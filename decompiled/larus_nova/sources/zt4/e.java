package zt4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f573589e;

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

    public e(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
    }
}
