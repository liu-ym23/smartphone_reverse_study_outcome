package com.obric.assistant.interaction.impl.essentialtask.base;

import android.content.Context;
import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IObricApmService;
import com.obric.assistant.interaction.api.IObricApmServiceKt;
import com.obric.assistant.interaction.impl.essentialtask.EssentialTaskManager;
import com.obric.assistant.interaction.impl.essentialtask.TaskUtils;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\rJ\b\u0010\u0016\u001a\u00020\rH$J\u000e\u0010\u0017\u001a\u00020\u0013H¤@¢\u0006\u0002\u0010\u0014J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0005H\u0014J\u000e\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001e\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014J,\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "taskName", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getTaskName", "()Ljava/lang/String;", "needExecuteCache", "", "getNeedExecuteCache", "()Z", "needExecuteCache$delegate", "Lkotlin/Lazy;", "execute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "needExecute", "internalNeedExecute", "internalExecute", "canRetry", "getMaxRetryCount", "", "getRetryDisplayText", "waitRetrySignal", "", "executeWrapped", "report", "isSuccess", "duration", "", "errorMsg", EventConstant.Value.RETRY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class EssentialTask {
    public static final Companion Companion = null;
    private static final int MAX_RETRY_COUNT = 1;
    private static final String TAG = "EssentialTask";
    private final Context context;
    private final Lazy needExecuteCache$delegate;
    private final String taskName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask$Companion;", "", "<init>", "()V", "TAG", "", "MAX_RETRY_COUNT", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask$execute$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask", f = "EssentialTask.kt", i = {0, 0, 0, 0, 1, 1}, l = {46, 64}, m = "execute", n = {"canRetry", "maxRetryCount", "index", DyPayConstant.KEY_START_TIME, "canRetry", "maxRetryCount"}, s = {"Z$0", "I$0", "I$3", "J$0", "Z$0", "I$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EssentialTask this$0;

        public AnonymousClass1(EssentialTask r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.execute(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask$executeWrapped$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask", f = "EssentialTask.kt", i = {}, l = {113}, m = "executeWrapped", n = {}, s = {})
    public static final class C116221 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EssentialTask this$0;

        public C116221(EssentialTask r100, Continuation<? super C116221> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return EssentialTask.access$executeWrapped(this.this$0, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ boolean a(EssentialTask r100) {
        return needExecuteCache_delegate$lambda$0(r100);
    }

    public boolean canRetry() {
        return false;
    }

    public int getMaxRetryCount() {
        return 1;
    }

    public abstract Object internalExecute(Continuation<? super ExecuteResult> r100);

    public abstract boolean internalNeedExecute();

    private final boolean getNeedExecuteCache() {
        return ((Boolean) this.needExecuteCache$delegate.getValue()).booleanValue();
    }

    public String getRetryDisplayText() {
        return AppHost.f326268a.getApplication().getString(R.string.obric_service_load_error);
    }

    public final boolean needExecute() {
        return getNeedExecuteCache();
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    private final Object executeWrapped(Continuation<? super ExecuteResult> r110) {
        if ((r110 instanceof C116221) == false) goto L7;
        C116221 r100 = (C116221) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L17;
        if (r103 != 1) goto L16;
        ResultKt.throwOnFailure(r111);     // Catch: CancellationException -> L13
    L21:
        FLogger.f375446a.i(TAG, "executeWrapped: execute finished. taskName: " + this.taskName + ", isSuccess: " + ((ExecuteResult) r111).isSuccess());     // Catch: CancellationException -> L13
        return (ExecuteResult) r111;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r111);
        FLogger.f375446a.i(TAG, "executeWrapped: startExecute: " + this.taskName);
        r100.label = 1;     // Catch: CancellationException -> L13
        r111 = internalExecute(r100);     // Catch: CancellationException -> L13
        if (r111 != r102) goto L21;
        return r102;
    L13:
        e = move-exception;
        FLogger.f375446a.w(TAG, "executeWrapped: execute failed. task " + this.taskName + ", error info " + e.getMessage(), e);
        TaskUtils r104 = TaskUtils.INSTANCE;
        StringBuilder r105 = new StringBuilder("executeWrapped: execute cancelled. task ");
        r105.append(this.taskName);
        TaskUtils.systemLog$default(r104, TAG, r105.toString(), null, 4, null);
        String r112 = e.getMessage();
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        return new ExecuteResult.Failed(r112);
    L7:
        r100 = new C116221(this, r110);
        goto L8
    }

    private static final boolean needExecuteCache_delegate$lambda$0(EssentialTask r100) {
        return r100.internalNeedExecute();
    }

    private final Object waitRetrySignal(Continuation<? super Unit> r100) {
        String r101 = getRetryDisplayText();
        FLogger.f375446a.w(TAG, "waitRetrySignal, retryText = " + r101);
        j r102 = new j(IntrinsicsKt.intercepted(r100), 1);
        r102.C();
        EssentialTaskManager.INSTANCE.addWaitRetrySignal(r101, r102);
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L6:
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r103;
    L9:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x01e9 -> B:47:0x01ec). Please report as a decompilation issue!!! */
    public final Object execute(Continuation<? super ExecuteResult> r310) {
        if ((r310 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = "";
        int r106 = 1;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r107 = r100.I$2;
        int r110 = r100.I$1;
        int r111 = r100.I$0;
        boolean r112 = r100.Z$0;
        ResultKt.throwOnFailure(r102);
        int r108 = r107;
        String r210 = "";
        boolean r109 = r112;
        EssentialTask r113 = this;
        int r114 = r111;
    L47:
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "execute: task " + r113.taskName + ", got retry signal.", null, 4, null);
        FLogger.f375446a.i(TAG, "execute: task " + r113.taskName + " got retry signal.");
        int r115 = r108 + 1;
        r105 = r210;
        r106 = 1;
        int r116 = r114;
    L25:
        if (r115 >= r110) goto L50;
        long r117 = SystemClock.elapsedRealtime();
        r100.Z$0 = r109;
        r100.I$0 = r116;
        r100.I$1 = r110;
        r100.I$2 = r115;
        r100.I$3 = r115;
        r100.J$0 = r117;
        r100.label = r106;
        Object r118 = r113.executeWrapped(r100);
        if (r118 != r103) goto L29;
        return r103;
    L29:
        boolean r119 = r109;
        r102 = r118;
        int r120 = r110;
        int r211 = r116;
        r108 = r115;
        int r121 = r211;
        EssentialTask r122 = r113;
        long r123 = r117;
    L30:
        ExecuteResult r124 = (ExecuteResult) r102;
        long r125 = SystemClock.elapsedRealtime() - r123;
        boolean r126 = r124.isSuccess();
        String r127 = r124.getErrorInfo();
        if (r127 != null) goto L33;
        r127 = r105;
    L33:
        EssentialTask r128 = r122;
        r114 = r121;
        r210 = r105;
        int r129 = r120;
        r122.report(r126, r125, r127, r115);
        TaskUtils r130 = TaskUtils.INSTANCE;
        StringBuilder r131 = new StringBuilder("execute: task ");
        r131.append(r128.taskName);
        r131.append(", isSuccess = ");
        r131.append(r124.isSuccess());
        r131.append(", repeatIndex = ");
        r131.append(r115);
        r131.append(", used time = ");
        r131.append(r125);
        r131.append(" ms, errorMsg = ");
        String r132 = r124.getErrorInfo();
        if (r132 != null) goto L36;
        r132 = r210;
    L36:
        r131.append(r132);
        TaskUtils.systemLog$default(r130, TAG, r131.toString(), null, 4, null);
        if (r124.isSuccess() == true) goto L48;
        if (r119 == false) goto L48;
        if (r115 != r114) goto L43;
        FLogger.f375446a.i(TAG, "execute: task " + r128.taskName + " failed, max retry count reached");
        return r124;
    L43:
        TaskUtils.systemLog$default(r130, TAG, "execute: task " + r128.taskName + ", wait retry signal, index = " + r115, null, 4, null);
        FLogger.f375446a.i(TAG, "execute: task " + r128.taskName + " failed, wait retry signal, index = " + r115);
        r100.Z$0 = r119;
        r100.I$0 = r114;
        r100.I$1 = r129;
        r100.I$2 = r108;
        r100.label = 2;
        if (r128.waitRetrySignal(r100) != r103) goto L46;
        return r103;
    L46:
        r110 = r129;
        r109 = r119;
        r113 = r128;
    L48:
        return r124;
    L50:
        return new ExecuteResult(false, "should not reach here");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r123 = r100.J$0;
        r115 = r100.I$3;
        int r133 = r100.I$2;
        int r134 = r100.I$1;
        int r135 = r100.I$0;
        boolean r136 = r100.Z$0;
        ResultKt.throwOnFailure(r102);
        r119 = r136;
        r108 = r133;
        r122 = this;
        r120 = r134;
        r121 = r135;
        goto L30
    L16:
        ResultKt.throwOnFailure(r102);
        if (needExecute() == true) goto L20;
        FLogger.f375446a.i(TAG, "execute: task " + this.taskName + " no need execute");
        return new ExecuteResult(true, "");
    L20:
        r109 = canRetry();
        int r137 = RangesKt.coerceAtLeast(getMaxRetryCount(), 0);
        if (r109 == false) goto L23;
        FLogger.f375446a.i(TAG, "execute: task " + this.taskName + " start execute, max retry count = " + r137);
    L24:
        r113 = this;
        r110 = r137 + 1;
        r116 = r137;
        r115 = 0;
        goto L25
    L23:
        FLogger.f375446a.i(TAG, "execute: task " + this.taskName + " start execute");
    L7:
        r100 = new AnonymousClass1(this, r310);
        goto L8
    }

    public EssentialTask(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "taskName");
        this.context = r100;
        this.taskName = r101;
        this.needExecuteCache$delegate = LazyKt.lazy(new a(this));
    }

    public static final /* synthetic */ Object access$executeWrapped(EssentialTask r100, Continuation r101) {
        return r100.executeWrapped(r101);
    }

    public static final /* synthetic */ Object access$waitRetrySignal(EssentialTask r100, Continuation r101) {
        return r100.waitRetrySignal(r101);
    }

    private final void report(boolean r100, long r101, String r102, int r103) {
        FLogger.f375446a.i(TAG, "report: taskName = " + this.taskName + ", isSuccess = " + r100 + ", duration = " + r101);
        IObricApmService r104 = IObricApmServiceKt.getObricApmServiceDelegate();
        if (r104 == null) goto L6;
        JSONObject r105 = new JSONObject();
        r105.put("is_success", r100);
        r105.put("name", this.taskName);
        Unit r106 = Unit.INSTANCE;
        JSONObject r107 = new JSONObject();
        r107.put("duration", r101);
        r107.put(EventConstant.Value.RETRY, r103);
        JSONObject r108 = new JSONObject();
        r108.put("error_msg", r102);
        r104.monitorEventForSlardar("obric_essential_task", r105, r107, r108);
        return;
    }

    public static /* synthetic */ void report$default(EssentialTask r100, boolean r101, long r102, String r110, int r111, int r112, Object r113) {
        if (r113 != null) goto L13;
        if ((r112 & 4) == 0) goto L6;
        r110 = "";
    L6:
        String r103 = r110;
        if ((r112 & 8) == 0) goto L9;
        int r104 = 0;
    L10:
        r100.report(r101, r102, r103, r104);
        return;
    L9:
        r104 = r111;
        goto L10
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
    }
}
