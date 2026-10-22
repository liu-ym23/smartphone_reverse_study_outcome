package com.relax.relaxreact;

import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class SimultaneousGesture extends ComposedGesture {
    @Override // com.relax.relaxreact.ComposedGesture
    public final void c(Map<Integer, Map<String, ArrayList<BaseGesture>>> r100, final ArrayList<BaseGesture> r101, ArrayList<BaseGesture> r102) {
        Intrinsics.checkNotNullParameter(r100, "collectedRelations");
        Intrinsics.checkNotNullParameter(r101, "simultaneousGestures");
        Intrinsics.checkNotNullParameter(r102, "waitFor");
        Intrinsics.throwUninitializedPropertyAccessException("__gestures");
        com.bytedance.rts.kmp.foundation.i.e(null, new SimultaneousGesture$collectCompositionRelations$simultaneousArrays$1(this, r101));
        throw null;
    }
}
