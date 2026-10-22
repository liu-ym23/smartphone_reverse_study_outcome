package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "STATE", "", AlarmSessionType.EVENT, "state", "cause", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class StateMachine$GraphBuilder$StateDefinitionBuilder$onEnter$1$1 extends Lambda implements Function2<Object, Object, Unit> {
    final /* synthetic */ Function2<Object, Object, Unit> $listener;

    public StateMachine$GraphBuilder$StateDefinitionBuilder$onEnter$1$1(Function2<Object, Object, Unit> r100) {
        this.$listener = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "cause");
        this.$listener.invoke(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object r100, Object r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
