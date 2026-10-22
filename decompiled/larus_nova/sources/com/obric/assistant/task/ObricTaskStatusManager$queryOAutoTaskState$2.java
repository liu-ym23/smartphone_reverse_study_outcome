package com.obric.assistant.task;

import android.os.Build;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.task.ObricTaskStatusManager$queryOAutoTaskState$2", f = "ObricTaskStatusManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricTaskStatusManager$queryOAutoTaskState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends String>>, Object> {
    int label;

    public ObricTaskStatusManager$queryOAutoTaskState$2(Continuation<? super ObricTaskStatusManager$queryOAutoTaskState$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricTaskStatusManager$queryOAutoTaskState$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Pair<? extends String, ? extends String>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Pair<String, String>> r101) {
        return ((ObricTaskStatusManager$queryOAutoTaskState$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        String r101 = null;
        if (Build.VERSION.SDK_INT >= 29) goto L20;
    L10:
        Bundle r102 = null;
    L11:
        if (r102 == null) goto L13;
        String r103 = r102.getString("state");
    L14:
        if (r102 == null) goto L17;
        r101 = r102.getString("o_task_source");
    L17:
        return TuplesKt.to(r103, r101);
    L13:
        r103 = null;
        goto L14
    L20:
        r102 = AppHost.f326268a.getApplication().getApplicationContext().getContentResolver().call("com.obric.assistantaiagent.OAutoStateProvider", "get_current_state", null, null);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        FLogger.f375446a.e("ObricTaskStatusManager", "queryOAutoTaskState, call failed", e);
        goto L10
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
