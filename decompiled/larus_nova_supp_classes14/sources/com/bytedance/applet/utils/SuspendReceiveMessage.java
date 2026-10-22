package com.bytedance.applet.utils;

import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import com.bytedance.applet.event.EventDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SuspendReceiveMessage {
    public Function1<? super Boolean, Unit> a;
    public String b;
    public final a c;

    public static final class a implements com.bytedance.applet.event.n {
        public final /* synthetic */ SuspendReceiveMessage a;

        public a(SuspendReceiveMessage r1) {
            this.a = r1;
        }

        @Override // com.bytedance.applet.event.n
        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
            if (r3.getMessageStatusLocal() == 21) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r3.getLocalMessageId(), this.a.b) == false) goto L11;
            FLogger.a.i("SuspendReceiveMessage", "onMessage");
            EventDispatcher r4 = EventDispatcher.a;
            Intrinsics.checkNotNullParameter(this, "listener");
            EventDispatcher.h.remove(this);
            Function1<? super Boolean, Unit> r5 = this.a.a;
            if (r5 == null) goto L12;
            r5.invoke(Boolean.TRUE);
            return;
        L12:
            return;
        }
    }

    public SuspendReceiveMessage() {
        this.c = new a(this);
    }

    public final Object a(String r8, Continuation<? super Boolean> r9) {
        if ((r9 instanceof SuspendReceiveMessage$msgReceivedByLocalMsg$1) == false) goto L7;
        SuspendReceiveMessage$msgReceivedByLocalMsg$1 r0 = (SuspendReceiveMessage$msgReceivedByLocalMsg$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L17:
        Boolean r11 = (Boolean) r10;
        FLogger.a.i("SuspendReceiveMessage", "msgReceivedByLocalMsg result " + r11);
        if (Intrinsics.areEqual(r11, Boxing.boxBoolean(true)) == true) goto L20;
        EventDispatcher r12 = EventDispatcher.a;
        a r13 = this.c;
        Intrinsics.checkNotNullParameter(r13, "listener");
        EventDispatcher.h.remove(r13);
    L20:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        FLogger.a.i("SuspendReceiveMessage", "msgReceivedByLocalMsg start " + r8);
        this.b = r8;
        SuspendReceiveMessage$msgReceivedByLocalMsg$receiveMsgResult$1 r14 = new SuspendReceiveMessage$msgReceivedByLocalMsg$receiveMsgResult$1(this, null);
        r0.label = 1;
        r10 = TimeoutKt.c(DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS, r14, r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new SuspendReceiveMessage$msgReceivedByLocalMsg$1(this, r9);
        goto L8
    }
}
