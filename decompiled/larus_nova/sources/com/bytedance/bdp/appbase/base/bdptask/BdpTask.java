package com.bytedance.bdp.appbase.base.bdptask;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004/012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\fH\u0007R\u0014\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u000fR\u0016\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0016\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010'R1\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask;", "", "", "", "getElapsedTimeDurationUs", "()[Ljava/lang/Long;", "", "nonCancel", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$Stage;", "getTaskStage", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$Builder;", "newBuilder", "", "start", "priority", "I", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/Runnable;", "delayMillis", "J", "queueHead", "Z", "queueTail", "tryCatch", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$TaskType;", "taskType", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$TaskType;", "isDefTaskType", "Lcom/bytedance/bdp/appbase/base/bdptask/j;", "group", "Lcom/bytedance/bdp/appbase/base/bdptask/j;", DBDefinition.TASK_ID, "", "trace", "Ljava/lang/String;", "debugTag", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "stage", "", "stageListener", "Lkotlin/jvm/functions/Function1;", "Builder", "Companion", "Stage", "TaskType", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpTask {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicInteger f200456i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f200457j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Stage f200458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b<?> f200459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f200460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f200461d;
    public final String debugTag;
    public final long delayMillis;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f200462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f200463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f200464g;
    public final j group;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f200465h;
    public final boolean isDefTaskType;
    public final TaskLifecycle lifecycle;
    private final boolean nonCancel;
    public final int priority;
    public final boolean queueHead;
    public final boolean queueTail;
    public final Runnable runnable;
    public final Function1<Stage, Unit> stageListener;
    public final int taskId;
    public final TaskType taskType;
    public final String trace;
    public final boolean tryCatch;

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u0000H\u0007J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bH\u0007J\b\u0010\r\u001a\u00020\u0000H\u0007J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0016\u0010\u000f\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007J\b\u0010\u0013\u001a\u00020\u0000H\u0007J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\b\u0010\u0014\u001a\u00020\u0000H\u0007J\b\u0010\u0015\u001a\u00020\u0000H\u0007J\b\u0010\u0016\u001a\u00020\u0000H\u0007J\b\u0010\u0017\u001a\u00020\u0000H\u0007J\b\u0010\u0018\u001a\u00020\u0000H\u0007J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0007J\u0012\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0007J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0002H\u0007J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0007J\b\u0010!\u001a\u00020\u0000H\u0007J\u0012\u0010\"\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0007J\u0012\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010$\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010%H\u0007J\u0012\u0010'\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010%H\u0007J-\u0010-\u001a\u00020\u00002#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110)¢\u0006\f\b*\u0012\b\b\u001f\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u0011\u0018\u00010(H\u0007J\b\u0010/\u001a\u00020.H\u0007J\b\u00100\u001a\u00020\u0002H\u0007¨\u00063"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$Builder;", "", "", "priority", "", "delayMillis", "delayedMillis", "time", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "delayed", "", "head", "tail", "Ljava/lang/Runnable;", "runnable", "Lkotlin/Function0;", "", "r", "tryCatch", "onLogic", "onMain", "onIO", "onCPU", "onOWN", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$TaskType;", "taskType", "Lcom/bytedance/bdp/appbase/base/bdptask/j;", "group", DBDefinition.TASK_ID, "", "name", "debugTag", "nonCancel", "trace", "Lcom/bytedance/bdp/appbase/base/bdptask/TaskLifecycle;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/LifecycleOwner;", "owner", "lifecycleOnlyDestroy", "Lkotlin/Function1;", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$Stage;", "Lkotlin/ParameterName;", "stage", "listener", "stageListener", "Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask;", "build", "start", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f200466a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0 f200467a;

            public a(Function0 r100) {
                this.f200467a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f200467a.invoke();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final Builder head() {
            return head(true);
        }

        public final Builder tail() {
            return tail(true);
        }

        public final BdpTask build() {
            return new BdpTask(this.f200466a);
        }

        public final Builder nonCancel() {
            this.f200466a.f200531n = true;
            return this;
        }

        public final Builder onCPU() {
            return taskType(TaskType.CPU);
        }

        public final Builder onIO() {
            return taskType(TaskType.IO);
        }

        public final Builder onLogic() {
            return taskType(TaskType.LOGIC);
        }

        public final Builder onMain() {
            return taskType(TaskType.MAIN);
        }

        public final Builder onOWN() {
            return taskType(TaskType.OWN);
        }

        public final Builder tryCatch() {
            this.f200466a.f200523f = true;
            return this;
        }

        public Builder() {
            this.f200466a = new m();
        }

        public final int start() {
            return build().start();
        }

        public Builder(BdpTask r100) {
            m r101 = new m();
            this.f200466a = r101;
            r101.f200518a = r100.priority;
            r101.f200519b = r100.runnable;
            r101.f200520c = r100.delayMillis;
            r101.f200521d = r100.queueHead;
            r101.f200522e = r100.queueTail;
            r101.f200523f = r100.tryCatch;
            r101.f200524g = r100.taskType;
            r101.f200525h = r100.isDefTaskType;
            r101.f200526i = r100.group;
            r101.f200530m = r100.debugTag;
            r101.f200531n = BdpTask.a(r100);
            if (r100.f200465h == false) goto L5;
            r101.f200529l = r100.trace;
        L6:
            r101.f200533p = r100.stageListener;
            TaskLifecycle r102 = r100.lifecycle;
            if (r102 == null) goto L10;
            r101.f200532o = r102.copy();
            return;
        L10:
            return;
        L5:
            r101.f200528k = r100.trace;
            goto L6
        }

        public final Builder debugTag(String r100) {
            this.f200466a.f200530m = r100;
            return this;
        }

        public final Builder delayedMillis(long r100) {
            return delayed(r100, TimeUnit.MILLISECONDS);
        }

        public final Builder group(j r100) {
            this.f200466a.f200526i = r100;
            return this;
        }

        public final Builder head(boolean r100) {
            this.f200466a.f200521d = r100;
            return this;
        }

        public final Builder lifecycle(LifecycleOwner r100) {
            m r101 = this.f200466a;
            if (r100 == null) goto L5;
            TaskLifecycle r102 = new TaskLifecycle().with(r100);
        L6:
            r101.f200532o = r102;
            return this;
        L5:
            r102 = null;
            goto L6
        }

        public final Builder lifecycleOnlyDestroy(LifecycleOwner r100) {
            m r101 = this.f200466a;
            if (r100 == null) goto L5;
            TaskLifecycle r102 = new TaskLifecycle().with(r100);
            TaskLifecycle.Event.a r103 = TaskLifecycle.Event.a.f200477a;
            TaskLifecycle r104 = r102.pause(r103).start(r103);
        L6:
            r101.f200532o = r104;
            return this;
        L5:
            r104 = null;
            goto L6
        }

        public final Builder priority(int r100) {
            this.f200466a.f200518a = r100;
            return this;
        }

        public final Builder runnable(Function0<Unit> r100) {
            runnable(new a(r100));
            m r101 = this.f200466a;
            Class<?> r102 = r100.getClass();
            Boolean r103 = k.f200514a;
            r101.f200529l = r102.getName();
            return this;
        }

        public final Builder stageListener(Function1<? super Stage, Unit> r100) {
            this.f200466a.f200533p = r100;
            return this;
        }

        public final Builder tail(boolean r100) {
            this.f200466a.f200522e = r100;
            return this;
        }

        public final Builder taskId(int r100) {
            this.f200466a.f200527j = r100;
            return this;
        }

        public final Builder taskType(TaskType r100) {
            m r101 = this.f200466a;
            r101.f200525h = false;
            r101.f200524g = r100;
            return this;
        }

        public final Builder trace(String r100) {
            m r101 = this.f200466a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r101.f200528k = r100;
            return this;
        }

        public final Builder tryCatch(boolean r100) {
            this.f200466a.f200523f = r100;
            return this;
        }

        public final Builder lifecycle(TaskLifecycle r100) {
            this.f200466a.f200532o = r100;
            return this;
        }

        public final Builder runnable(Runnable r100) {
            m r101 = this.f200466a;
            r101.f200519b = r100;
            Class<?> r102 = r100.getClass();
            Boolean r103 = k.f200514a;
            r101.f200529l = r102.getName();
            return this;
        }

        public final Builder delayed(long r100, TimeUnit r101) {
            if (r100 < 0) goto L8;
            if (r100 < 0) goto L6;
            this.f200466a.f200520c = r101.toMillis(r100);
        L6:
            return this;
        L8:
            throw new IllegalArgumentException("time < 0: " + r100);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$Companion;", "", "Lcom/bytedance/bdp/appbase/base/bdptask/j;", "produceGroup", "", "concurrent", "Ljava/util/concurrent/atomic/AtomicInteger;", "TASK_ID", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public final j produceGroup() {
            return new j(Integer.MAX_VALUE);
        }

        @JvmStatic
        public final j produceGroup(int r100) {
            return new j(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$Stage;", "", "(Ljava/lang/String;I)V", "CREATE", "DELAY", "DELAY_FIN", "QUEUE", "EXECUTE", "CANCEL", "FINISH", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
    public static final enum Stage extends Enum<Stage> {
        private static final /* synthetic */ Stage[] $VALUES = null;
        public static final Stage CANCEL = null;
        public static final Stage CREATE = null;
        public static final Stage DELAY = null;
        public static final Stage DELAY_FIN = null;
        public static final Stage EXECUTE = null;
        public static final Stage FINISH = null;
        public static final Stage QUEUE = null;

        static {
            Stage r100 = new Stage("CREATE", 0);
            CREATE = r100;
            Stage r101 = new Stage("DELAY", 1);
            DELAY = r101;
            Stage r102 = new Stage("DELAY_FIN", 2);
            DELAY_FIN = r102;
            Stage r103 = new Stage("QUEUE", 3);
            QUEUE = r103;
            Stage r104 = new Stage("EXECUTE", 4);
            EXECUTE = r104;
            Stage r105 = new Stage("CANCEL", 5);
            CANCEL = r105;
            Stage r106 = new Stage("FINISH", 6);
            FINISH = r106;
            $VALUES = new Stage[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static Stage valueOf(String r100) {
            return (Stage) r27.a.a(Stage.class, r100);
        }

        public static Stage[] values() {
            return (Stage[]) $VALUES.clone();
        }

        private Stage(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpTask$TaskType;", "", "(Ljava/lang/String;I)V", "IO", "CPU", "OWN", "LOGIC", AccountType.MAIN, "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
    public static final enum TaskType extends Enum<TaskType> {
        private static final /* synthetic */ TaskType[] $VALUES = null;
        public static final TaskType CPU = null;
        public static final TaskType IO = null;
        public static final TaskType LOGIC = null;
        public static final TaskType MAIN = null;
        public static final TaskType OWN = null;

        static {
            TaskType r100 = new TaskType("IO", 0);
            IO = r100;
            TaskType r101 = new TaskType("CPU", 1);
            CPU = r101;
            TaskType r102 = new TaskType("OWN", 2);
            OWN = r102;
            TaskType r103 = new TaskType("LOGIC", 3);
            LOGIC = r103;
            TaskType r104 = new TaskType(AccountType.MAIN, 4);
            MAIN = r104;
            $VALUES = new TaskType[]{r100, r101, r102, r103, r104};
        }

        public static TaskType valueOf(String r100) {
            return (TaskType) r27.a.a(TaskType.class, r100);
        }

        public static TaskType[] values() {
            return (TaskType[]) $VALUES.clone();
        }

        private TaskType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JvmStatic
    public static final j produceGroup() {
        return f200457j.produceGroup();
    }

    @JvmStatic
    public static final j produceGroup(int r100) {
        return f200457j.produceGroup(r100);
    }

    public final Long[] getElapsedTimeDurationUs() {
        Long[] r100 = new Long[2];
        int r101 = 0;
    L3:
        if (r101 >= 2) goto L9;
        if (r101 != 0) goto L7;
        long r102 = Math.max(0, (this.f200461d - this.f200460c) + (this.f200463f - this.f200462e));
    L8:
        r100[r101] = Long.valueOf(r102);
        r101 = r101 + 1;
        goto L3
    L7:
        r102 = Math.max(0, this.f200464g - this.f200463f);
        goto L8
    L9:
        return r100;
    }

    public final Stage getTaskStage() {
        monitor-enter(this);
        Stage r100 = this.f200458a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f200457j = new Companion();
        f200456i = new AtomicInteger(0);
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final boolean nonCancel() {
        if (this.nonCancel == true) goto L5;
    L11:
        return false;
    L5:
        if (this.lifecycle != null) goto L11;
        if (this.group != null) goto L11;
        if (this.delayMillis != 0) goto L11;
        return true;
    }

    public final int start() {
        return BdpPool.execute(this);
    }

    public BdpTask(m r100) {
        this.f200458a = Stage.CREATE;
        this.priority = r100.f200518a;
        this.runnable = r100.f200519b;
        this.delayMillis = r100.f200520c;
        this.queueHead = r100.f200521d;
        this.queueTail = r100.f200522e;
        this.tryCatch = r100.f200523f;
        this.taskType = r100.f200524g;
        this.isDefTaskType = r100.f200525h;
        this.group = r100.f200526i;
        this.lifecycle = r100.f200532o;
        this.stageListener = r100.f200533p;
        this.debugTag = r100.f200530m;
        this.nonCancel = r100.f200531n;
        int r101 = r100.f200527j;
        if (r101 != 0) goto L5;
        r101 = f200456i.incrementAndGet();
    L5:
        this.taskId = r101;
        String r102 = r100.f200528k;
        if (r102 != null) goto L8;
        this.trace = r100.f200529l;
        this.f200465h = true;
        return;
    L8:
        this.trace = r102;
        this.f200465h = false;
    }

    public static final /* synthetic */ boolean a(BdpTask r100) {
        return r100.nonCancel;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.bdp.appbase.base.bdptask.TaskLifecycle$startObserver$$inlined$also$lambda$1] */
    public final boolean b(final Stage r100) {
        monitor-enter(this);
    L53:
        th = move-exception;
        throw th;
    L4:
        if (r100.compareTo(this.f200458a) <= 0) goto L51;
        this.f200458a = r100;     // Catch: Throwable -> L53
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(this);
        int r102 = i.f200510a[r100.ordinal()];
        if (r102 != 1) goto L10;
        this.f200461d = System.nanoTime() / ((long) 1000);
    L20:
        String r103 = this.debugTag;
        if (r103 != null) goto L23;
    L26:
        boolean r104 = true;
    L27:
        if (r104 == false) goto L29;
    L31:
        final TaskLifecycle r105 = this.lifecycle;
        if (r105 != null) goto L34;
    L44:
        Function1<Stage, Unit> r106 = this.stageListener;
        if (r106 == null) goto L48;
        Unit r107 = r106.invoke(r100);
    L48:
        if (r100 != this.f200458a) goto L50;
        return true;
    L50:
        return false;
    L34:
        if (r100 != Stage.DELAY) goto L42;
        final Function3<? super TaskLifecycle.LifecycleEvent, ? super TaskLifecycle.State, ? super TaskLifecycle.State, Unit> r108 = r105.stateChanged;
        r105.stateChanged = new BdpTask$setTaskStage$$inlined$apply$lambda$1(r108, this, r100);
        r105.f200474f = true;
        WeakReference<LifecycleRegistry> r109 = r105.f200475g;
        if (r109 == null) goto L40;
        final LifecycleRegistry r110 = r109.get();
        if (r110 == null) goto L40;
        final ?? r111 = new TaskLifecycle$startObserver$$inlined$also$lambda$1(r105);
        r105.f200476h = r111;
        BdpPool.runOnMainQuickly(new TaskLifecycle$startObserver$$inlined$also$lambda$2(r110, r111));
    L40:
        r105.b(true);
        goto L44
    L42:
        if (r100 != Stage.FINISH) goto L44;
        r105.c();
        goto L44
    L29:
        if (q94.a.f532096b == false) goto L31;
        g94.b.a(this.debugTag, new Object[]{"BdpTask taskId:" + this.taskId + " stage changed:" + r100.name()});
        goto L31
    L23:
        if (r103.length() == 0) goto L26;
        r104 = false;
        goto L27
    L10:
        if (r102 != 2) goto L12;
        this.f200462e = System.nanoTime() / ((long) 1000);
        goto L20
    L12:
        if (r102 != 3) goto L14;
        this.f200463f = System.nanoTime() / ((long) 1000);
        goto L20
    L14:
        if (r102 != 4) goto L20;
        this.f200464g = System.nanoTime() / ((long) 1000);
        goto L20
    L51:
        monitor-exit(this);
        return false;
    }
}
