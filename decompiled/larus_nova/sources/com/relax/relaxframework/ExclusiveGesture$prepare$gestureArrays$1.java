package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0004j\b\u0012\u0004\u0012\u00020\u0007`\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0004j\b\u0012\u0004\u0012\u00020\u0000`\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/relax/relaxframework/k1;", "gesture", "", "index", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "arr", "Lcom/relax/relaxframework/BaseGesture;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/k1;ILjava/util/ArrayList;)Ljava/util/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class ExclusiveGesture$prepare$gestureArrays$1 extends Lambda implements Function3<k1, Integer, ArrayList<k1>, ArrayList<BaseGesture>> {
    public static final ExclusiveGesture$prepare$gestureArrays$1 INSTANCE = null;

    static {
        INSTANCE = new ExclusiveGesture$prepare$gestureArrays$1();
    }

    public ExclusiveGesture$prepare$gestureArrays$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ ArrayList<BaseGesture> invoke(k1 r100, Integer r101, ArrayList<k1> r102) {
        return invoke(r100, r101.intValue(), r102);
    }

    public final ArrayList<BaseGesture> invoke(k1 r100, int r101, ArrayList<k1> r102) {
        Intrinsics.checkNotNullParameter(r100, "gesture");
        Intrinsics.checkNotNullParameter(r102, "arr");
        return r100.a();
    }
}
