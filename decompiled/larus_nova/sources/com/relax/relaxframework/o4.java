package com.relax.relaxframework;

import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class o4 extends p8 {
    public o4(Function0<? extends ArrayList<Double>> r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        super(TransformType.Rotate, r100, null);
    }
}
