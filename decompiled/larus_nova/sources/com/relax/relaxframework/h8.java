package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TimingFunctionType___0 f405119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Double> f405120b;

    public static final class a {
    }

    static {
    }

    public final TimingFunctionType___0 getType() {
        TimingFunctionType___0 r100 = this.f405119a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public h8(TimingFunctionType___0 r100, ArrayList<Double> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405119a = r100;
        this.f405120b = r101;
    }
}
