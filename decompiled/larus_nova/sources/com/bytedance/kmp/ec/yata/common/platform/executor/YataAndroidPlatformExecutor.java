package com.bytedance.kmp.ec.yata.common.platform.executor;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class YataAndroidPlatformExecutor implements x96.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f251510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f251511b;

    @Override // x96.a
    public final void c() {
        ((a) this.f251511b.getValue()).a();
    }

    @Override // x96.a
    public final void destroy() {
        ((c) this.f251510a.getValue()).b();
        ((a) this.f251511b.getValue()).shutdown();
    }

    @Override // x96.a
    public final com.bytedance.kmp.ec.yata.common.platform.g e() {
        int r100 = com.bytedance.kmp.ec.yata.common.platform.h.f251540a;
        return new com.bytedance.kmp.ec.yata.common.platform.g();
    }

    public YataAndroidPlatformExecutor() {
        this.f251510a = LazyKt.lazy(YataAndroidPlatformExecutor$parallelQueue$2.INSTANCE);
        this.f251511b = LazyKt.lazy(YataAndroidPlatformExecutor$mainQueue$2.INSTANCE);
    }

    @Override // x96.a
    public final void a(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        ((a) this.f251511b.getValue()).c(r100, r101);
    }

    @Override // x96.a
    public final void b(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        c r102 = (c) this.f251510a.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        r102.a(new b(r100, r101), 0);
    }

    @Override // x96.a
    public final void d(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        ((a) this.f251511b.getValue()).b(r100, r101);
    }
}
