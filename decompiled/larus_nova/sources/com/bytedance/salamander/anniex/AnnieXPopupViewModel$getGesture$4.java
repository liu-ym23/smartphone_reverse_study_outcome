package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/relax/relaxframework/j1;", "e", "Lcom/relax/relaxframework/l1;", "stateManager", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/j1;Lcom/relax/relaxframework/l1;)V", "<no name provided>"}, k = 3, mv = {1, 4, 3})
final class AnnieXPopupViewModel$getGesture$4 extends Lambda implements Function2<com.relax.relaxframework.j1, com.relax.relaxframework.l1, Unit> {
    public static final AnnieXPopupViewModel$getGesture$4 INSTANCE = null;

    static {
        INSTANCE = new AnnieXPopupViewModel$getGesture$4();
    }

    public AnnieXPopupViewModel$getGesture$4() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.relax.relaxframework.j1 r100, com.relax.relaxframework.l1 r101) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r101, "stateManager");
        r101.end();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.relax.relaxframework.j1 r100, com.relax.relaxframework.l1 r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
