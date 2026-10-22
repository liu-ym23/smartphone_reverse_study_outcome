package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class v8 extends p8 {
    public v8(Function0<? extends ArrayList<Double>> r100) {
        Intrinsics.checkNotNullParameter(r100, "y");
        super(TransformType.TranslateY, r100, null);
    }
}
