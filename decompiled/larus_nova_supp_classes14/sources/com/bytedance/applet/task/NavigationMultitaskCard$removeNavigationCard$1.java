package com.bytedance.applet.task;

import com.larus.multitask_management.api.CancelFrom;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.task.NavigationMultitaskCard$removeNavigationCard$1", f = "NavigationMultitaskCard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NavigationMultitaskCard$removeNavigationCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    final /* synthetic */ long $revision;
    int label;

    public NavigationMultitaskCard$removeNavigationCard$1(String r1, long r2, Continuation<? super NavigationMultitaskCard$removeNavigationCard$1> r4) {
        this.$reason = r1;
        this.$revision = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new NavigationMultitaskCard$removeNavigationCard$1(this.$reason, this.$revision, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L45;
        ResultKt.throwOnFailure(r11);
        NavigationMultitaskCard r12 = NavigationMultitaskCard.a;
        String r0 = this.$reason;
        long r1 = this.$revision;
        r12.getClass();
        NavigationCardSessionState r4 = NavigationMultitaskCard.e;
        monitor-enter(r4);
        boolean r6 = false;
        if (r4.b != null) goto L12;
        if (r4.a != r1) goto L12;
        boolean r2 = true;
    L13:
        monitor-exit(r4);
        if (r2 == false) goto L38;
        String r3 = NavigationMultitaskCard.d;
        int r5 = com.larus.navigation.api.c.a;
        StringBuilder r7 = new StringBuilder("removeNavigationCard: enter currentTaskId=");
        if (r3 != null) goto L19;
        String r8 = "null";
    L20:
        r7.append(r8);
        r7.append(" reason=");
        r7.append(r0);
        r7.append(" thread=");
        r7.append(ThreadMethodProxy.currentThread().getName());
        com.larus.navigation.api.c.d("nav_multitask_map", r7.toString());
        if (r3 != null) goto L23;
    L24:
        r6 = true;
    L26:
        if (r6 == false) goto L46;
        NavigationMultitaskCard.n(null);
        NavigationMultitaskCard.m(true);
        com.larus.navigation.api.c.d("nav_multitask_map", "removeNavigationCard: no taskId to remove");
        goto L38
    L46:
        il9.a r9 = NavigationMultitaskCard.k("removeNavigationCard");     // Catch: Throwable -> L32 Exception -> L34
        if (r9 == null) goto L31;
        com.larus.navigation.api.c.d("nav_multitask_map", "removeNavigationCard: removeLocalTask returned " + r9.b1(r3, CancelFrom.MANUAL) + " for taskId=" + r3);     // Catch: Throwable -> L32 Exception -> L34
    L31:
        NavigationMultitaskCard.i();
        NavigationMultitaskCard.h = null;
        NavigationMultitaskCard.d = null;
        NavigationMultitaskCard.n(null);
        NavigationMultitaskCard.m(true);
        com.larus.navigation.api.c.d("nav_multitask_map", "removeNavigationCard: done, taskId cleared");
    L34:
        e = move-exception;
        int r10 = com.larus.navigation.api.c.a;     // Catch: Throwable -> L32
        com.larus.navigation.api.c.c("nav_multitask_map", "removeNavigationCard: removeLocalTask failed for taskId=" + r3, e);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        NavigationMultitaskCard.i();
        NavigationMultitaskCard.h = null;
        NavigationMultitaskCard.d = null;
        NavigationMultitaskCard.n(null);
        NavigationMultitaskCard.m(true);
        com.larus.navigation.api.c.d("nav_multitask_map", "removeNavigationCard: done, taskId cleared");
        throw th;
    L23:
        if (r3.length() != 0) goto L26;
    L19:
        r8 = r3;
    L38:
        return Unit.INSTANCE;
    L12:
        r2 = false;
    L41:
        th = move-exception;
        throw th;
    L45:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
