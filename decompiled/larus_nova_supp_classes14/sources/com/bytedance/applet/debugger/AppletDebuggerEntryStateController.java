package com.bytedance.applet.debugger;

import com.larus.im.FlowRuntime;
import com.larus.platform.api.AppletDebuggerEntryState;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.x1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletDebuggerEntryStateController {
    public final AppletDebuggerRegistrationRepository a;
    public final MutexImpl b;
    public final StateFlowImpl c;
    public final CoroutineScope d;
    public a e;

    public static final class a {
        public final String a;
        public final Deferred<Unit> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "InFlightRefresh(userId=" + this.a + ", deferred=" + this.b + ')';
        }

        public a(String r2, Deferred<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            Intrinsics.checkNotNullParameter(r3, "deferred");
            this.a = r2;
            this.b = r3;
        }
    }

    public AppletDebuggerEntryStateController() {
        this(0);
    }

    public AppletDebuggerEntryStateController(int r2) {
        AppletDebuggerRegistrationRepository r3 = new AppletDebuggerRegistrationRepository();
        Intrinsics.checkNotNullParameter(r3, "registrationRepository");
        this.a = r3;
        this.b = kotlinx.coroutines.sync.b.a();
        this.c = j1.a(AppletDebuggerEntryState.HIDDEN);
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        com.larus.platform.api.b r4 = new AppletDebuggerEntryStateController$accountStatusCallback$1(this);
        AccountService.a.E(r4);
    }

    public final Object b(Continuation<? super Unit> r4) {
        FlowRuntime.a().isOversea();
        this.c.setValue(AppletDebuggerEntryState.HIDDEN);
        gd9.l r0 = FlowRuntime.a();
        r0.isOversea();
        r0.isPlugin();
        if (x1.a.a() == true) goto L10;
        AccountService r1 = AccountService.a;
        if (r1.isLogin().booleanValue() == false) goto L10;
        String r2 = r1.getUserId();
        if ((!StringsKt.isBlank(r2)) == false) goto L10;
    L11:
        if (r2 == null) goto L13;
        Object r5 = CoroutineScopeKt.coroutineScope(new AppletDebuggerEntryStateController$refreshEntryState$2(this, r2, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r5;
    L18:
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    L10:
        r2 = null;
        goto L11
    }

    public static final Object a(AppletDebuggerEntryStateController r4, String r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof AppletDebuggerEntryStateController$refreshEntryState$3) == false) goto L7;
        AppletDebuggerEntryStateController$refreshEntryState$3 r0 = (AppletDebuggerEntryStateController$refreshEntryState$3) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        boolean r8 = ((Boolean) r7).booleanValue();
        StateFlowImpl r9 = r4.c;
        AccountService r10 = AccountService.a;
        if (r10.isLogin().booleanValue() == true) goto L20;
    L23:
        AppletDebuggerEntryState r11 = AppletDebuggerEntryState.HIDDEN;
    L24:
        r9.setValue(r11);
        return Unit.INSTANCE;
    L20:
        if (Intrinsics.areEqual(r10.getUserId(), r5) == false) goto L23;
        if (r8 == false) goto L23;
        r11 = AppletDebuggerEntryState.VISIBLE;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r4.c.setValue(AppletDebuggerEntryState.LOADING);
        AppletDebuggerRegistrationRepository r12 = r4.a;
        r0.L$0 = r5;
        r0.label = 1;
        r7 = r12.a(r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new AppletDebuggerEntryStateController$refreshEntryState$3(r4, r6);
        goto L8
    }
}
