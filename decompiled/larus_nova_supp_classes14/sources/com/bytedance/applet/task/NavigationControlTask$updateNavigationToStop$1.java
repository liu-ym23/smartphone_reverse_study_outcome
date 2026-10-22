package com.bytedance.applet.task;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.larus.multitask_management.api.CancelFrom;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.task.NavigationControlTask$updateNavigationToStop$1", f = "NavigationControlTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NavigationControlTask$updateNavigationToStop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public NavigationControlTask$updateNavigationToStop$1(Continuation<? super NavigationControlTask$updateNavigationToStop$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        NavigationControlTask$updateNavigationToStop$1 r0 = new NavigationControlTask$updateNavigationToStop$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        String r7 = p.a;
        if (r7 == null) goto L11;
        FLogger.a.i("NavigationControlTask", "updateNavigationStatus: stop");
        il9.a r2 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r2 == null) goto L9;
        Boolean r8 = Boxing.boxBoolean(r2.b1(r7, CancelFrom.MANUAL));
    L10:
        if (r8 == null) goto L11;
    L12:
        AppletRuntimeManager.INSTANCE.getClass();
        AppletRuntime r9 = AppletRuntimeManager.i(null, null, "com.flow.locallife");
        if (r9 == null) goto L15;
        r9.p();
    L16:
        p.d = null;
        p.a = null;
        return Unit.INSTANCE;
    L15:
        FLogger.a.e("NavigationControlTask", "updateNavigationToStop: cancelAlive failed");
        goto L16
    L9:
        r8 = null;
    L11:
        FLogger.a.e("NavigationControlTask", "updateNavigationToStop: taskId is empty");
        Unit r10 = Unit.INSTANCE;
        goto L12
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
