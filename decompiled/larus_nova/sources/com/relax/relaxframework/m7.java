package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class m7 extends p8 {
    public m7(Function0<? extends ArrayList<Double>> r100, Function0<? extends ArrayList<Double>> r101) {
        Intrinsics.checkNotNullParameter(r100, "x");
        super(TransformType.Scale, r100, r101);
    }
}
