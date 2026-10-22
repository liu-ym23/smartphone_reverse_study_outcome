package com.relax.relaxframework;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PositionOffset_Type___ f405321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d3 f405322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f405323c;

    public final PositionOffset_Type___ getType() {
        return this.f405321a;
    }

    public v3(PositionOffset_Type___ r100, d3 r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        this.f405321a = r100;
        this.f405322b = r101;
        this.f405323c = 0;
    }
}
