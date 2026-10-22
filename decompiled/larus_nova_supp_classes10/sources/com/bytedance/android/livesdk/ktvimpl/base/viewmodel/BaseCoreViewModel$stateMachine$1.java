package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$c;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/LyricsStateTransition;", "p1", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class BaseCoreViewModel$stateMachine$1 extends FunctionReferenceImpl implements Function1<StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b>, Unit> {
    public BaseCoreViewModel$stateMachine$1(BaseCoreViewModel r8) {
        super(1, r8, BaseCoreViewModel.class, "listener", "listener(Lcom/bytedance/android/live/core/utils/StateMachine$Transition;)V", 0);
    }

    public final void invoke(StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        BaseCoreViewModel.access$listener((BaseCoreViewModel) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.c) r1);
        return Unit.INSTANCE;
    }
}
