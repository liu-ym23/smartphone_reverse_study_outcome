package com.bytedance.android.livesdk.ktvimpl.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/j;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/j;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class KtvControlWidget$onCreate$4$2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.viewmodel.j, Unit> {
    public KtvControlWidget$onCreate$4$2(KtvControlWidget r8) {
        super(1, r8, KtvControlWidget.class, "handleVideoSceneChange", "handleVideoSceneChange(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneWithPlayModeEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.chatroom.viewmodel.j r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        KtvControlWidget r0 = (KtvControlWidget) ((CallableReference) this).receiver;
        int r1 = KtvControlWidget.v;
        r0.getClass();
        if (r4.a == 8) goto L5;
    L7:
        r0.k = false;
        return;
    L5:
        if (r4.c != 63) goto L7;
        r0.k = true;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.chatroom.viewmodel.j) r1);
        return Unit.INSTANCE;
    }
}
