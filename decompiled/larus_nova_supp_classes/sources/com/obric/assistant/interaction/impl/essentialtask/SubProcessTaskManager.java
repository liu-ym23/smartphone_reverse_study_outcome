package com.obric.assistant.interaction.impl.essentialtask;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Messenger;
import android.util.EventsUtils;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.essentialtask.ipc.EssentialTaskIPCProvider;
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
import mda.a;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/SubProcessTaskManager;", XmlPullParser.NO_NAMESPACE, "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "executeSucceedState", "Lkotlinx/coroutines/flow/MutableStateFlow;", XmlPullParser.NO_NAMESPACE, "retryQueryInterval", XmlPullParser.NO_NAMESPACE, "queryCounts", "Ljava/util/concurrent/atomic/AtomicInteger;", EssentialTaskIPCProvider.KEY_MESSENGER, "Landroid/os/Messenger;", "getMessenger", "()Landroid/os/Messenger;", "messenger$delegate", "Lkotlin/Lazy;", "init", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "getExecuteSucceedState", "Lkotlinx/coroutines/flow/StateFlow;", "queryAndMonitorMainProcessExecuteState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class SubProcessTaskManager {
    public static final SubProcessTaskManager INSTANCE = null;
    private static final String TAG = "EssentialTaskSubProcessTaskManager";
    private static final z0<Boolean> executeSucceedState = null;
    private static final Lazy messenger$delegate = null;
    private static final AtomicInteger queryCounts = null;
    private static final long[] retryQueryInterval = null;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.SubProcessTaskManager$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", XmlPullParser.NO_NAMESPACE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.SubProcessTaskManager$init$1", f = "SubProcessTaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        public AnonymousClass1(Context r1, Continuation<? super AnonymousClass1> r2) {
            this.$context = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$context, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
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

    public static /* synthetic */ void c(Context r0) {
        queryAndMonitorMainProcessExecuteState$lambda$6$lambda$5(r0);
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
        final Looper r1 = Looper.getMainLooper();
        return new Messenger(new SubProcessTaskManager$messenger$2$1(r1));
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

    private final void queryAndMonitorMainProcessExecuteState(Context r14) {
        int r0 = queryCounts.getAndIncrement();
        if (r0 >= 0) goto L5;
        r0 = retryQueryInterval.length - 1;
    L5:
        int r2 = r0;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        FLogger.a.w(TAG, "query execute state");     // Catch: Throwable -> L8
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "query execute state", null, 4, null);     // Catch: Throwable -> L8
        ContentResolver r3 = r14.getContentResolver();     // Catch: Throwable -> L8
        Uri r4 = EssentialTaskIPCProvider.Companion.getAUTHORITY();     // Catch: Throwable -> L8
        Bundle r5 = new Bundle();     // Catch: Throwable -> L8
        r5.putParcelable(EssentialTaskIPCProvider.KEY_MESSENGER, getMessenger());     // Catch: Throwable -> L8
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L8
        Object r7 = Result.m49constructorimpl(r3.call(r4, EssentialTaskIPCProvider.METHOD_QUERY_EXECUTE_STATE, null, r5));     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.m52exceptionOrNullimpl(r7);
        if (r8 == null) goto L14;
        FLogger r9 = FLogger.a;
        r9.e(TAG, "query execute state failed: " + r8, r8);
        TaskUtils r10 = TaskUtils.INSTANCE;
        TaskUtils.systemLog$default(r10, TAG, "query execute state failed: " + r8, null, 4, null);
        long[] r11 = retryQueryInterval;
        long r12 = r11[RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r2, 0), r11.length + (-1))];
        r9.w(TAG, "query execute state failed, retry after " + r12 + " ms");
        TaskUtils.systemLog$default(r10, TAG, "query execute state failed, retry after " + r12 + " ms", null, 4, null);
        t0.b(new e(r14), r12);
    L14:
        if (Result.m56isSuccessimpl(r7) == false) goto L24;
        Bundle r13 = (Bundle) r7;
        if (r13 != null) goto L18;
        FLogger.a.e(TAG, "query execute state failed, queryResult is null");
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "query execute state failed, queryResult is null", null, 4, null);
        return;
    L18:
        boolean r15 = r13.getBoolean(EssentialTaskIPCProvider.KEY_IS_SUCCEED);
        FLogger.a.i(TAG, "query execute state success, isSucceed: " + r15);
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "query execute state success, isSucceed: " + r15, null, 4, null);
        if (r15 == false) goto L26;
        t0.e(new f());
        return;
    L26:
        return;
    L24:
        return;
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r7 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private static final void queryAndMonitorMainProcessExecuteState$lambda$6$lambda$5(Context r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m49constructorimpl(AppHost.a.getApplication());     // Catch: Throwable -> L4
    L6:
        Object r11 = r10;
        if (Result.m55isFailureimpl(r1) == true) goto L10;
        r11 = r1;
    L10:
        Context r12 = (Context) r11;
        FLogger.a.w(TAG, "retry query use context: " + r12);
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "retry query use context: " + r12, null, 4, null);
        INSTANCE.queryAndMonitorMainProcessExecuteState(r12);
        return;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void init(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        FLogger r0 = FLogger.a;
        r0.i(TAG, "init");
        if (a.a(r8) == false) goto L5;
        r0.i(TAG, "isInteractorProcess: true");
        executeSucceedState.setValue(Boolean.TRUE);
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r8, null), 3, null);
    }

    public static final /* synthetic */ void access$queryAndMonitorMainProcessExecuteState(SubProcessTaskManager r0, Context r1) {
        r0.queryAndMonitorMainProcessExecuteState(r1);
    }
}
