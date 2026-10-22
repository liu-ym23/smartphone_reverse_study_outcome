package com.obric.assistant.interaction.impl.essentialtask;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Messenger;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.essentialtask.ipc.EssentialTaskIPCProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/SubProcessTaskManager;", "", "<init>", "()V", "TAG", "", "executeSucceedState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "retryQueryInterval", "", "queryCounts", "Ljava/util/concurrent/atomic/AtomicInteger;", "messenger", "Landroid/os/Messenger;", "getMessenger", "()Landroid/os/Messenger;", "messenger$delegate", "Lkotlin/Lazy;", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getExecuteSucceedState", "Lkotlinx/coroutines/flow/StateFlow;", "queryAndMonitorMainProcessExecuteState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubProcessTaskManager {
    public static final SubProcessTaskManager INSTANCE = null;
    private static final String TAG = "EssentialTaskSubProcessTaskManager";
    private static final z0<Boolean> executeSucceedState = null;
    private static final Lazy messenger$delegate = null;
    private static final AtomicInteger queryCounts = null;
    private static final long[] retryQueryInterval = null;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.SubProcessTaskManager$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.SubProcessTaskManager$init$1", f = "SubProcessTaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        public AnonymousClass1(Context r100, Continuation<? super AnonymousClass1> r101) {
            this.$context = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$context, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            SubProcessTaskManager.access$queryAndMonitorMainProcessExecuteState(SubProcessTaskManager.INSTANCE, this.$context);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private SubProcessTaskManager() {
    }

    public static /* synthetic */ Messenger a() {
        return messenger_delegate$lambda$0();
    }

    public static /* synthetic */ void b() {
        queryAndMonitorMainProcessExecuteState$lambda$8$lambda$7();
    }

    public static /* synthetic */ void c(Context r100) {
        queryAndMonitorMainProcessExecuteState$lambda$6$lambda$5(r100);
    }

    static {
        INSTANCE = new SubProcessTaskManager();
        executeSucceedState = j1.a(Boolean.FALSE);
        retryQueryInterval = new long[]{1, 100, 200, 500, 1000, 2000, 10000, 60000, 120000};
        queryCounts = new AtomicInteger(0);
        messenger$delegate = LazyKt.lazy(new g());
    }

    private final Messenger getMessenger() {
        return (Messenger) messenger$delegate.getValue();
    }

    private static final Messenger messenger_delegate$lambda$0() {
        return new Messenger(new SubProcessTaskManager$messenger$2$1(Looper.getMainLooper()));
    }

    private static final void queryAndMonitorMainProcessExecuteState$lambda$8$lambda$7() {
        executeSucceedState.setValue(Boolean.TRUE);
    }

    public static final /* synthetic */ z0 access$getExecuteSucceedState$p() {
        return executeSucceedState;
    }

    public final i1<Boolean> getExecuteSucceedState() {
        return executeSucceedState;
    }

    private final void queryAndMonitorMainProcessExecuteState(final Context r110) {
        int r100 = queryCounts.getAndIncrement();
        if (r100 >= 0) goto L5;
        r100 = retryQueryInterval.length - 1;
    L5:
        int r101 = r100;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        FLogger.f375446a.w(TAG, "query execute state");     // Catch: Throwable -> L8
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "query execute state", null, 4, null);     // Catch: Throwable -> L8
        ContentResolver r103 = r110.getContentResolver();     // Catch: Throwable -> L8
        Uri r104 = EssentialTaskIPCProvider.Companion.getAUTHORITY();     // Catch: Throwable -> L8
        Bundle r105 = new Bundle();     // Catch: Throwable -> L8
        r105.putParcelable("messenger", getMessenger());     // Catch: Throwable -> L8
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L8
        Object r107 = Result.m9449constructorimpl(r103.call(r104, EssentialTaskIPCProvider.METHOD_QUERY_EXECUTE_STATE, null, r105));     // Catch: Throwable -> L8
    L10:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L14;
        FLogger r109 = FLogger.f375446a;
        r109.e(TAG, "query execute state failed: " + r108, r108);
        TaskUtils r111 = TaskUtils.INSTANCE;
        TaskUtils.systemLog$default(r111, TAG, "query execute state failed: " + r108, null, 4, null);
        long[] r112 = retryQueryInterval;
        long r113 = r112[RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r101, 0), r112.length + (-1))];
        r109.w(TAG, "query execute state failed, retry after " + r113 + " ms");
        TaskUtils.systemLog$default(r111, TAG, "query execute state failed, retry after " + r113 + " ms", null, 4, null);
        t0.b(new e(r110), r113);
    L14:
        if (Result.m9456isSuccessimpl(r107) == false) goto L24;
        Bundle r114 = (Bundle) r107;
        if (r114 != null) goto L18;
        FLogger.f375446a.e(TAG, "query execute state failed, queryResult is null");
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "query execute state failed, queryResult is null", null, 4, null);
        return;
    L18:
        boolean r115 = r114.getBoolean(EssentialTaskIPCProvider.KEY_IS_SUCCEED);
        FLogger.f375446a.i(TAG, "query execute state success, isSucceed: " + r115);
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "query execute state success, isSucceed: " + r115, null, 4, null);
        if (r115 == false) goto L26;
        t0.e(new f());
        return;
    L26:
        return;
    L24:
        return;
    L8:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private static final void queryAndMonitorMainProcessExecuteState$lambda$6$lambda$5(Context r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(AppHost.f326268a.getApplication());     // Catch: Throwable -> L4
    L6:
        Object r111 = r110;
        if (Result.m9455isFailureimpl(r101) == true) goto L10;
        r111 = r101;
    L10:
        Context r112 = (Context) r111;
        FLogger.f375446a.w(TAG, "retry query use context: " + r112);
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "retry query use context: " + r112, null, 4, null);
        INSTANCE.queryAndMonitorMainProcessExecuteState(r112);
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FLogger r101 = FLogger.f375446a;
        r101.i(TAG, "init");
        if (mda.a.a(r100) == false) goto L5;
        r101.i(TAG, "isInteractorProcess: true");
        executeSucceedState.setValue(Boolean.TRUE);
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r100, null), 3, null);
    }

    public static final /* synthetic */ void access$queryAndMonitorMainProcessExecuteState(SubProcessTaskManager r100, Context r101) {
        r100.queryAndMonitorMainProcessExecuteState(r101);
    }
}
