package com.bytedance.applet.debugger;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletDebuggerRegistrationRepository {
    public AppletDebuggerRegistrationRepository() {
    }

    public final Object a(Continuation<? super Boolean> r7) {
        if ((r7 instanceof AppletDebuggerRegistrationRepository$isRegistered$1) == false) goto L7;
        AppletDebuggerRegistrationRepository$isRegistered$1 r0 = (AppletDebuggerRegistrationRepository$isRegistered$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        Boolean r9 = (Boolean) r8;
        if (r9 != null) goto L20;
        com.bytedance.ai.utils.g.a.w("AppletDebuggerRegistration", "[isRegistered] request timeout");
    L20:
        if (r9 == null) goto L22;
        boolean r10 = r9.booleanValue();
    L24:
        return Boxing.boxBoolean(r10);
    L22:
        r10 = false;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        com.bytedance.ai.utils.g.a.i("AppletDebuggerRegistration", "[isRegistered] request start");
        AppletDebuggerRegistrationRepository$isRegistered$registered$1 r11 = new AppletDebuggerRegistrationRepository$isRegistered$registered$1(null);
        r0.label = 1;
        r8 = TimeoutKt.c(DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS, r11, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new AppletDebuggerRegistrationRepository$isRegistered$1(this, r7);
        goto L8
    }
}
