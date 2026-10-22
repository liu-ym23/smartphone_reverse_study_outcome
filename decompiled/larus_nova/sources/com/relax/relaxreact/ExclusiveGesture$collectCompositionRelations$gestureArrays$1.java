package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0003H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/relax/relaxreact/BaseGesture;", "Lcom/bytedance/rts/kmp/foundation/RTSArray;", "gesture", "Lcom/relax/relaxreact/GestureKind;", "_index", "", "_array", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ExclusiveGesture$collectCompositionRelations$gestureArrays$1 extends Lambda implements Function3<x, Integer, ArrayList<x>, ArrayList<BaseGesture>> {
    public static final ExclusiveGesture$collectCompositionRelations$gestureArrays$1 INSTANCE = null;

    static {
        INSTANCE = new ExclusiveGesture$collectCompositionRelations$gestureArrays$1();
    }

    public ExclusiveGesture$collectCompositionRelations$gestureArrays$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ ArrayList<BaseGesture> invoke(x r100, Integer r101, ArrayList<x> r102) {
        return invoke(r100, r101.intValue(), r102);
    }

    public final ArrayList<BaseGesture> invoke(x r100, int r101, ArrayList<x> r102) {
        Intrinsics.checkNotNullParameter(r100, "gesture");
        Intrinsics.checkNotNullParameter(r102, "_array");
        return r100.a();
    }
}
