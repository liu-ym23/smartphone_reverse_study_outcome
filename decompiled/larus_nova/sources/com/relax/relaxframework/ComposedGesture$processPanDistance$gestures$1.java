package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/relax/relaxframework/k1;", "gesture", "Ljava/util/ArrayList;", "Lcom/relax/relaxframework/BaseGesture;", "Lcom/bytedance/rts/foundation/RTSArray;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/k1;)Ljava/util/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class ComposedGesture$processPanDistance$gestures$1 extends Lambda implements Function1<k1, ArrayList<BaseGesture>> {
    public static final ComposedGesture$processPanDistance$gestures$1 INSTANCE = null;

    static {
        INSTANCE = new ComposedGesture$processPanDistance$gestures$1();
    }

    public ComposedGesture$processPanDistance$gestures$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ArrayList<BaseGesture> invoke2(k1 r100) {
        Intrinsics.checkNotNullParameter(r100, "gesture");
        return r100.a();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ArrayList<BaseGesture> invoke(k1 r100) {
        return invoke2(r100);
    }
}
