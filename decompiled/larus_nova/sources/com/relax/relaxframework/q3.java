package com.relax.relaxframework;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PositionOffset_Type___ f405232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3 f405233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e3 f405234c;

    public final PositionOffset_Type___ getType() {
        return this.f405232a;
    }

    public q3(PositionOffset_Type___ r100, e3 r101, e3 r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r102, "h");
        this.f405232a = r100;
        this.f405233b = r101;
        this.f405234c = r102;
    }
}
