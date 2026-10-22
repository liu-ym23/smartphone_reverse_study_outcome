package com.relax.relaxframework;

import com.byted.cast.common.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class u7<T> implements o7, z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f405292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t7 f405293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f405294c;

    @Override // com.relax.relaxframework.z1
    public final int a() {
        return this.f405294c;
    }

    @Override // com.relax.relaxframework.z1
    public final t7 c() {
        return this.f405293b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u7(Object r100) {
        this.f405293b = new t7();
        this.f405292a = r100;
    }

    @Override // com.relax.relaxframework.z1
    public final void b(int r100) {
        this.f405293b.c(r100);
    }

    @Override // com.relax.relaxframework.z1
    public final int e(y1 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        return this.f405293b.a(r100, r101);
    }
}
