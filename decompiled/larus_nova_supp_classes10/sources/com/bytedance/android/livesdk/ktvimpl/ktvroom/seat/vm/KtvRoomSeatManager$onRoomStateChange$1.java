package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class KtvRoomSeatManager$onRoomStateChange$1 extends FunctionReferenceImpl implements Function1<i, Unit> {
    public KtvRoomSeatManager$onRoomStateChange$1(KtvRoomSeatManager r8) {
        super(1, r8, KtvRoomSeatManager.class, "onSubSceneChange", "onSubSceneChange(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneEvent;)V", 0);
    }

    public final void invoke(i r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        KtvRoomSeatManager r0 = (KtvRoomSeatManager) ((CallableReference) this).receiver;
        int r1 = KtvRoomSeatManager.t;
        r0.c(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((i) r1);
        return Unit.INSTANCE;
    }
}
