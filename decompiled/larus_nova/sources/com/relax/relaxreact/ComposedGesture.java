package com.relax.relaxreact;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public class ComposedGesture implements x {
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.util.ArrayList] */
    @Override // com.relax.relaxreact.c0
    public final ArrayList<BaseGesture> a() {
        Intrinsics.throwUninitializedPropertyAccessException("__gestures");
        Intrinsics.checkNotNullParameter(null, "gestures");
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        com.bytedance.rts.kmp.foundation.i.c(null, new GestureCompositionKt$flatMapGestures$1(r100));
        throw null;
    }

    @Override // com.relax.relaxreact.c0
    public final Map<String, Object> serialize() {
        LinkedHashMap r100 = new LinkedHashMap();
        Integer r101 = Integer.valueOf(getType().getValue());
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("type", r101);
        Intrinsics.throwUninitializedPropertyAccessException("__gestures");
        com.bytedance.rts.kmp.foundation.i.e(null, AnonymousClass1.INSTANCE);
        throw null;
    }

    @Override // com.relax.relaxreact.x, com.relax.relaxreact.c0
    public GestureTypeInner getType() {
        return GestureTypeInner.Composed;
    }

    public void c(final Map<Integer, Map<String, ArrayList<BaseGesture>>> r100, final ArrayList<BaseGesture> r101, final ArrayList<BaseGesture> r102) {
        Intrinsics.checkNotNullParameter(r100, "collectedRelations");
        Intrinsics.checkNotNullParameter(r101, "simultaneousGestures");
        Intrinsics.checkNotNullParameter(r102, "waitFor");
        Intrinsics.throwUninitializedPropertyAccessException("__gestures");
        com.bytedance.rts.kmp.foundation.i.c(null, new ComposedGesture$collectCompositionRelations$1(this, r100, r101, r102));
        throw null;
    }

    public static void b(Map r100, BaseGesture r101, String r102, ArrayList r103) {
        Integer r104 = Integer.valueOf(r101.f405383a);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map r105 = (Map) r100.get(r104);
        if (r105 != null) goto L5;
        r105 = new LinkedHashMap();
        Integer r106 = Integer.valueOf(r101.f405383a);
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put(r106, r105);
    L5:
        Intrinsics.checkNotNullParameter(r105, "<this>");
        ArrayList r107 = (ArrayList) r105.get(r102);
        if (r107 != null) goto L8;
        r107 = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
    L8:
        Intrinsics.checkNotNullParameter(r107, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "source");
        final ArrayList r108 = com.bytedance.rts.kmp.foundation.i.h(r107);
        com.bytedance.rts.kmp.foundation.i.c(r103, new GestureCompositionKt$extendRelation$1(r108));
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r105.put(r102, r108);
    }
}
