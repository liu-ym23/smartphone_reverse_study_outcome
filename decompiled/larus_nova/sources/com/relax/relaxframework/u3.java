package com.relax.relaxframework;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PositionOffset_Type___ f405287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f405288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f405289c;

    public final PositionOffset_Type___ getType() {
        return this.f405287a;
    }

    public u3(PositionOffset_Type___ r100, Function0<Integer> r101, Function0<Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r102, "h");
        this.f405287a = r100;
        this.f405288b = r101;
        this.f405289c = r102;
    }
}
