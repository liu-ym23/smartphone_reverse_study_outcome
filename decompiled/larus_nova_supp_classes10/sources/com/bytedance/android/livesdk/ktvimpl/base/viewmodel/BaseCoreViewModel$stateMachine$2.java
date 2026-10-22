package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class BaseCoreViewModel$stateMachine$2 extends FunctionReferenceImpl implements Function1<KtvRoomLyricsStateMachineConfig.d, Unit> {
    public BaseCoreViewModel$stateMachine$2(BaseCoreViewModel r8) {
        super(1, r8, BaseCoreViewModel.class, "onStateEnter", "onStateEnter(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$State;)V", 0);
    }

    public final void invoke(KtvRoomLyricsStateMachineConfig.d r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        BaseCoreViewModel.access$onStateEnter((BaseCoreViewModel) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((KtvRoomLyricsStateMachineConfig.d) r1);
        return Unit.INSTANCE;
    }
}
