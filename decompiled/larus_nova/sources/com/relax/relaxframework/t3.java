package com.relax.relaxframework;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PositionOffset_Type___ f405280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f405281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f405282c;

    public final PositionOffset_Type___ getType() {
        return this.f405280a;
    }

    public t3(PositionOffset_Type___ r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        this.f405280a = r100;
        this.f405281b = r101;
        this.f405282c = 0;
    }
}
