package com.obric.assistant.interaction.impl.essentialtask.base;

import android.content.Context;
import android.os.SystemClock;
import android.util.EventsUtils;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IObricApmService;
import com.obric.assistant.interaction.api.IObricApmServiceKt;
import com.obric.assistant.interaction.impl.essentialtask.EssentialTaskManager;
import com.obric.assistant.interaction.impl.essentialtask.TaskUtils;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.j;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\rJ\b\u0010\u0016\u001a\u00020\rH$J\u000e\u0010\u0017\u001a\u00020\u0013H¤@¢\u0006\u0002\u0010\u0014J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0005H\u0014J\u000e\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001e\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014J,\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "taskName", XmlPullParser.NO_NAMESPACE, "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getTaskName", "()Ljava/lang/String;", "needExecuteCache", XmlPullParser.NO_NAMESPACE, "getNeedExecuteCache", "()Z", "needExecuteCache$delegate", "Lkotlin/Lazy;", "execute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "needExecute", "internalNeedExecute", "internalExecute", "canRetry", "getMaxRetryCount", XmlPullParser.NO_NAMESPACE, "getRetryDisplayText", "waitRetrySignal", XmlPullParser.NO_NAMESPACE, "executeWrapped", "report", "isSuccess", "duration", XmlPullParser.NO_NAMESPACE, "errorMsg", "retry", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public abstract class EssentialTask {
    public static final Companion Companion = null;
    private static final int MAX_RETRY_COUNT = 1;
    private static final String TAG = "EssentialTask";
    private final Context context;
    private final Lazy needExecuteCache$delegate;
    private final String taskName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask$Companion;", XmlPullParser.NO_NAMESPACE, "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "MAX_RETRY_COUNT", XmlPullParser.NO_NAMESPACE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ boolean a(EssentialTask r0) {
        return needExecuteCache_delegate$lambda$0(r0);
    }

    public boolean canRetry() {
        return false;
    }

    public int getMaxRetryCount() {
        return 1;
    }

    public abstract Object internalExecute(Continuation<? super ExecuteResult> r1);

    public abstract boolean internalNeedExecute();

    private final boolean getNeedExecuteCache() {
        return ((Boolean) this.needExecuteCache$delegate.getValue()).booleanValue();
    }

    public String getRetryDisplayText() {
        return AppHost.a.getApplication().getString(2131912400);
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

    private final Object executeWrapped(Continuation<? super ExecuteResult> r13) {
        if ((r13 instanceof executeWrapped.1) == false) goto L7;
        executeWrapped.1 r1 = (executeWrapped.1) r13;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r14 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L17;
        if (r4 != 1) goto L16;
        ResultKt.throwOnFailure(r14);     // Catch: CancellationException -> L13
    L21:
        FLogger.a.i(TAG, "executeWrapped: execute finished. taskName: " + this.taskName + ", isSuccess: " + ((ExecuteResult) r14).isSuccess());     // Catch: CancellationException -> L13
        return (ExecuteResult) r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r14);
        FLogger.a.i(TAG, "executeWrapped: startExecute: " + this.taskName);
        r1.label = 1;     // Catch: CancellationException -> L13
        r14 = internalExecute(r1);     // Catch: CancellationException -> L13
        if (r14 != r3) goto L21;
        return r3;
    L13:
        e = move-exception;
        FLogger.a.w(TAG, "executeWrapped: execute failed. task " + this.taskName + ", error info " + e.getMessage(), e);
        TaskUtils r6 = TaskUtils.INSTANCE;
        StringBuilder r0 = new StringBuilder("executeWrapped: execute cancelled. task ");
        r0.append(this.taskName);
        TaskUtils.systemLog$default(r6, TAG, r0.toString(), null, 4, null);
        String r15 = e.getMessage();
        if (r15 != null) goto L27;
        r15 = XmlPullParser.NO_NAMESPACE;
    L27:
        return new ExecuteResult.Failed(r15);
    L7:
        r1 = new executeWrapped.1(this, r13);
        goto L8
    }

    private static final boolean needExecuteCache_delegate$lambda$0(EssentialTask r0) {
        return r0.internalNeedExecute();
    }

    private final Object waitRetrySignal(Continuation<? super Unit> r5) {
        String r0 = getRetryDisplayText();
        FLogger.a.w(TAG, "waitRetrySignal, retryText = " + r0);
        j r1 = new j(IntrinsicsKt.intercepted(r5), 1);
        r1.C();
        EssentialTaskManager.INSTANCE.addWaitRetrySignal(r0, r1);
        Object r2 = r1.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L6:
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r2;
    L9:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x01e9 -> B:47:0x01ec). Please report as a decompilation issue!!! */
    public final Object execute(Continuation<? super ExecuteResult> r31) {
        if ((r31 instanceof execute.1) == false) goto L7;
        execute.1 r2 = (execute.1) r31;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r6 = XmlPullParser.NO_NAMESPACE;
        int r8 = 1;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        int r7 = r2.I$2;
        int r11 = r2.I$1;
        int r12 = r2.I$0;
        boolean r13 = r2.Z$0;
        ResultKt.throwOnFailure(r1);
        int r9 = r7;
        String r20 = XmlPullParser.NO_NAMESPACE;
        boolean r10 = r13;
        EssentialTask r14 = this;
        int r0 = r12;
    L47:
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, TAG, "execute: task " + r14.taskName + ", got retry signal.", null, 4, null);
        FLogger.a.i(TAG, "execute: task " + r14.taskName + " got retry signal.");
        int r15 = r9 + 1;
        r6 = r20;
        r8 = 1;
        int r16 = r0;
    L25:
        if (r15 >= r11) goto L50;
        long r17 = SystemClock.elapsedRealtime();
        r2.Z$0 = r10;
        r2.I$0 = r16;
        r2.I$1 = r11;
        r2.I$2 = r15;
        r2.I$3 = r15;
        r2.J$0 = r17;
        r2.label = r8;
        Object r18 = r14.executeWrapped(r2);
        if (r18 != r4) goto L29;
        return r4;
    L29:
        boolean r19 = r10;
        r1 = r18;
        int r110 = r11;
        int r28 = r16;
        r9 = r15;
        int r111 = r28;
        EssentialTask r112 = r14;
        long r113 = r17;
    L30:
        ExecuteResult r21 = (ExecuteResult) r1;
        long r114 = SystemClock.elapsedRealtime() - r113;
        boolean r115 = r21.isSuccess();
        String r116 = r21.getErrorInfo();
        if (r116 != null) goto L33;
        r116 = r6;
    L33:
        EssentialTask r22 = r112;
        r0 = r111;
        r20 = r6;
        int r23 = r110;
        r112.report(r115, r114, r116, r15);
        TaskUtils r117 = TaskUtils.INSTANCE;
        StringBuilder r118 = new StringBuilder("execute: task ");
        r118.append(r22.taskName);
        r118.append(", isSuccess = ");
        r118.append(r21.isSuccess());
        r118.append(", repeatIndex = ");
        r118.append(r15);
        r118.append(", used time = ");
        r118.append(r114);
        r118.append(" ms, errorMsg = ");
        String r119 = r21.getErrorInfo();
        if (r119 != null) goto L36;
        r119 = r20;
    L36:
        r118.append(r119);
        TaskUtils.systemLog$default(r117, TAG, r118.toString(), null, 4, null);
        if (r21.isSuccess() == true) goto L48;
        if (r19 == false) goto L48;
        if (r15 != r0) goto L43;
        FLogger.a.i(TAG, "execute: task " + r22.taskName + " failed, max retry count reached");
        return r21;
    L43:
        TaskUtils.systemLog$default(r117, TAG, "execute: task " + r22.taskName + ", wait retry signal, index = " + r15, null, 4, null);
        FLogger.a.i(TAG, "execute: task " + r22.taskName + " failed, wait retry signal, index = " + r15);
        r2.Z$0 = r19;
        r2.I$0 = r0;
        r2.I$1 = r23;
        r2.I$2 = r9;
        r2.label = 2;
        if (r22.waitRetrySignal(r2) != r4) goto L46;
        return r4;
    L46:
        r11 = r23;
        r10 = r19;
        r14 = r22;
    L48:
        return r21;
    L50:
        return new ExecuteResult(false, "should not reach here");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r113 = r2.J$0;
        r15 = r2.I$3;
        int r120 = r2.I$2;
        int r121 = r2.I$1;
        int r122 = r2.I$0;
        boolean r24 = r2.Z$0;
        ResultKt.throwOnFailure(r1);
        r19 = r24;
        r9 = r120;
        r112 = this;
        r110 = r121;
        r111 = r122;
        goto L30
    L16:
        ResultKt.throwOnFailure(r1);
        if (needExecute() == true) goto L20;
        FLogger.a.i(TAG, "execute: task " + this.taskName + " no need execute");
        return new ExecuteResult(true, XmlPullParser.NO_NAMESPACE);
    L20:
        r10 = canRetry();
        int r25 = RangesKt.coerceAtLeast(getMaxRetryCount(), 0);
        if (r10 == false) goto L23;
        FLogger.a.i(TAG, "execute: task " + this.taskName + " start execute, max retry count = " + r25);
    L24:
        r14 = this;
        r11 = r25 + 1;
        r16 = r25;
        r15 = 0;
        goto L25
    L23:
        FLogger.a.i(TAG, "execute: task " + this.taskName + " start execute");
    L7:
        r2 = new execute.1(this, r31);
        goto L8
    }

    public EssentialTask(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskName");
        this.context = r2;
        this.taskName = r3;
        this.needExecuteCache$delegate = LazyKt.lazy(new a(this));
    }

    public static final /* synthetic */ Object access$executeWrapped(EssentialTask r0, Continuation r1) {
        return r0.executeWrapped(r1);
    }

    public static final /* synthetic */ Object access$waitRetrySignal(EssentialTask r0, Continuation r1) {
        return r0.waitRetrySignal(r1);
    }

    private final void report(boolean r4, long r5, String r7, int r8) {
        FLogger.a.i(TAG, "report: taskName = " + this.taskName + ", isSuccess = " + r4 + ", duration = " + r5);
        IObricApmService r0 = IObricApmServiceKt.getObricApmServiceDelegate();
        if (r0 == null) goto L6;
        JSONObject r1 = new JSONObject();
        r1.put("is_success", r4);
        r1.put("name", this.taskName);
        Unit r6 = Unit.INSTANCE;
        JSONObject r9 = new JSONObject();
        r9.put("duration", r5);
        r9.put("retry", r8);
        JSONObject r10 = new JSONObject();
        r10.put("error_msg", r7);
        r0.monitorEventForSlardar("obric_essential_task", r1, r9, r10);
        return;
    }

    public static /* synthetic */ void report$default(EssentialTask r6, boolean r7, long r8, String r10, int r11, int r12, Object r13) {
        if (r13 != null) goto L13;
        if ((r12 & 4) == 0) goto L6;
        r10 = XmlPullParser.NO_NAMESPACE;
    L6:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L9;
        int r5 = 0;
    L10:
        r6.report(r7, r8, r4, r5);
        return;
    L9:
        r5 = r11;
        goto L10
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
    }
}
