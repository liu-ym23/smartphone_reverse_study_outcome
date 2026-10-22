package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/relax/relaxframework/k1;", "newGesture", "oldGesture", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/k1;Lcom/relax/relaxframework/k1;)V", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class RxAttributedElementImpl$setGesture$3 extends Lambda implements Function2<k1, k1, Unit> {
    final /* synthetic */ RxAttributedElementImpl this$0;

    public RxAttributedElementImpl$setGesture$3(RxAttributedElementImpl r100) {
        this.this$0 = r100;
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v8, types: [com.relax.relaxframework.k5] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(k1 r100, k1 r101) {
        Intrinsics.checkNotNullParameter(r100, "newGesture");
        final RxAttributedElementImpl r102 = this.this$0;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "gesture");
        r102.f404924m = false;
        ((LinkedHashMap) r102.f404933v).clear();
        Map<Integer, BaseGesture> r103 = r102.f404933v;
        n0 r104 = RelaxFrameworkKt.f404871a;
        Intrinsics.checkNotNullParameter(r100, "gesture");
        Intrinsics.checkNotNullParameter(r103, "gestureMap");
        if (r100.getType() == GestureTypeInner.Composed) goto L11;
        com.bytedance.rts.foundation.m.e(r103, 0, (BaseGesture) r100);
        Map<Integer, BaseGesture> r105 = r102.f404933v;
        Intrinsics.checkNotNullParameter(r105, "gestureMap");
        final ArrayList r106 = new ArrayList();
        RelaxFrameworkKt.X(r105, new RelaxFrameworkKt$gestureMapToArray$1(r106));
        if (r102.f404932u.rtsPipelineEnabled() == true) goto L8;
        long r107 = r102.E();
        ?? r108 = new k5(r102);
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().l0(r107, r106, r108);
        return;
    L8:
        if (r102.f404932u.getUIProxy() == null) goto L13;
        throw null;
    L13:
        return;
    L11:
        ComposedGesture r109 = (ComposedGesture) r100;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(k1 r100, k1 r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
