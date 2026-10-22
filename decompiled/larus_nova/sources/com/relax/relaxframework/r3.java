package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PositionOffset_Type___ f405251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f405252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f405253c;

    public final PositionOffset_Type___ getType() {
        return this.f405251a;
    }

    public r3(PositionOffset_Type___ r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f405251a = r100;
        this.f405252b = 0;
        this.f405253c = 0;
    }
}
