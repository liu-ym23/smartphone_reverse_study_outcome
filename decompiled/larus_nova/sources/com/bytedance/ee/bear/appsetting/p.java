package com.bytedance.ee.bear.appsetting;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class p implements awa.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final awa.d f206267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f206268b;

    @Override // awa.d
    public final String a() {
        return this.f206267a.a();
    }

    @Override // awa.d
    public final <T> T get(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        T r101 = (T) this.f206268b.b(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return (T) this.f206267a.get(r100);
    }

    public p(awa.d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "userSetting");
        Intrinsics.checkNotNullParameter(r101, "emergencySettingFG");
        this.f206267a = r100;
        this.f206268b = r101;
    }
}
