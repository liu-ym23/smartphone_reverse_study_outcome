package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u000e\u001a\u00020\u00072:\u0010\t\u001a6\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0000j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\nH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lkotlin/Function2;", "Lcom/relax/relaxframework/j1;", "Lkotlin/ParameterName;", "name", "event", "Lcom/relax/relaxframework/l1;", "stateManager", "", "Lcom/relax/relaxframework/GestureControlCallback;", "value", "", "key", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class BaseGesture$__getCallbackNames$1 extends Lambda implements Function2<Function2<? super j1, ? super l1, ? extends Unit>, String, Unit> {
    final /* synthetic */ ArrayList<String> $callbacks;

    public BaseGesture$__getCallbackNames$1(ArrayList<String> r100) {
        this.$callbacks = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function2<? super j1, ? super l1, Unit> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "key");
        com.bytedance.rts.foundation.j.j(this.$callbacks, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super j1, ? super l1, ? extends Unit> r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
