package com.ss.android.lark.forseti.global;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements yua.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<yua.c> f424465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yua.c f424466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final yua.c f424467c;

    @Override // yua.a
    public final List<yua.c> a() {
        return this.f424465a;
    }

    @Override // yua.a
    public final yua.c b() {
        return this.f424467c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends yua.c> r100, yua.c r101) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        this.f424465a = r100;
        this.f424466b = r101;
        this.f424467c = r101;
    }
}
