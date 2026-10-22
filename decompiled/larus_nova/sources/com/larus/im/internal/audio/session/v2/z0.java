package com.larus.im.internal.audio.session.v2;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class z0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<q0> f347495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f347496b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.im.internal.audio.session.v2.p0
    public final void a() {
        this.f347496b = true;
    }

    public z0() {
        this.f347495a = new LinkedHashSet();
    }

    @Override // com.larus.im.internal.audio.session.v2.p0
    public final void b(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f347495a.remove(r100);
    }

    @Override // com.larus.im.internal.audio.session.v2.p0
    public final void c(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f347495a.add(r100);
    }
}
