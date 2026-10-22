package com.relax.relaxframework;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PositionOffset_Type___ f405263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f405264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f405265c;

    public final PositionOffset_Type___ getType() {
        return this.f405263a;
    }

    public s3(PositionOffset_Type___ r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "h");
        this.f405263a = r100;
        this.f405264b = 0;
        this.f405265c = r101;
    }
}
