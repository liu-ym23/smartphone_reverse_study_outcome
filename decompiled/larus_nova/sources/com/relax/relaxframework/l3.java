package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f405177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LengthType f405178b;

    public final LengthType getType() {
        return this.f405178b;
    }

    public l3(double r100, LengthType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f405177a = r100;
        this.f405178b = r101;
    }
}
