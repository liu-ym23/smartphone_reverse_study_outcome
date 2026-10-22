package com.relax.relaxframework;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PositionOffset_Type___ f405210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d3 f405211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d3 f405212c;

    public final PositionOffset_Type___ getType() {
        return this.f405210a;
    }

    public p3(PositionOffset_Type___ r100, d3 r101, d3 r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r102, "h");
        this.f405210a = r100;
        this.f405211b = r101;
        this.f405212c = r102;
    }
}
