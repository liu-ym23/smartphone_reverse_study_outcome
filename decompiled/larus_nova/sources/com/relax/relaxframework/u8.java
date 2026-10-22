package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class u8 extends p8 {
    public u8(Function0<? extends ArrayList<Double>> r100) {
        Intrinsics.checkNotNullParameter(r100, "x");
        super(TransformType.TranslateX, r100, null);
    }
}
