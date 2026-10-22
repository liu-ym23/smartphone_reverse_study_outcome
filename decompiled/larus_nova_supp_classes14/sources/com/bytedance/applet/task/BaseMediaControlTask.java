package com.bytedance.applet.task;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.KeepAliveRequester;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.larus.multitask_management.api.data.TaskKey;
import com.larus.multitask_management.api.data.TaskPriority;
import com.larus.multitask_management.api.data.TaskReplaceStrategy;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.multitask_management.api.data.TaskType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.UUID;
import kl9.l0;
import kl9.p0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class BaseMediaControlTask {
    public final String a;
    public TaskCardStatus b;
    public final BaseMediaControlTask$appLifecycleObserver$1 c;
    public final String d;
    public boolean e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applet/task/BaseMediaControlTask$TaskCardStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYING", "PAUSED", "STOPPED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TaskCardStatus extends Enum<TaskCardStatus> {
        public static final TaskCardStatus PAUSED = null;
        public static final TaskCardStatus PLAYING = null;
        public static final TaskCardStatus STOPPED = null;
        public static final /* synthetic */ TaskCardStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TaskCardStatus> getEntries() {
            return b;
        }

        static {
            TaskCardStatus r0 = new TaskCardStatus("PLAYING", 0);
            PLAYING = r0;
            TaskCardStatus r1 = new TaskCardStatus("PAUSED", 1);
            PAUSED = r1;
            TaskCardStatus r3 = new TaskCardStatus("STOPPED", 2);
            STOPPED = r3;
            TaskCardStatus[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static TaskCardStatus[] values() {
            return (TaskCardStatus[]) a.clone();
        }

        public static TaskCardStatus valueOf(String r1) {
            return (TaskCardStatus) r27.a.a(TaskCardStatus.class, r1);
        }

        public TaskCardStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements il9.d {
        public final /* synthetic */ BaseMediaControlTask a;

        /* JADX INFO: renamed from: com.bytedance.applet.task.BaseMediaControlTask$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0060a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TaskStatus.values().length];
                r0[TaskStatus.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[TaskStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[TaskStatus.CANCELED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a(BaseMediaControlTask r1) {
            this.a = r1;
        }

        public final void a(String r5, TaskDisplayStatus r6) {
            Intrinsics.checkNotNullParameter(r5, "taskId");
            Intrinsics.checkNotNullParameter(r6, "taskDisplayStatus");
            FLogger.a.i(this.a.a(), "onRequestTaskDisplayStatusChange: " + r5 + ", " + r6);
        }

        public final void b(String r6, TaskStatus r7) {
            Intrinsics.checkNotNullParameter(r6, "taskId");
            Intrinsics.checkNotNullParameter(r7, "taskStatus");
            FLogger r0 = FLogger.a;
            r0.i(this.a.a(), "onRequestTaskStatusChange: " + r6 + ", " + r7);
            if (Intrinsics.areEqual(r6, this.a.d) == true) goto L6;
            r0.i(this.a.a(), "onRequestTaskStatusChange: " + r6 + " is not our task");
            return;
        L6:
            int r8 = C0060a.a[r7.ordinal()];
            if (r8 != 1) goto L9;
            this.a.f();
            return;
        L9:
            if (r8 != 2) goto L11;
            this.a.d();
            return;
        L11:
            if (r8 == 3) goto L13;
            r0.e(this.a.a(), "onRequestTaskStatusChange: Unknown status " + r7);
            return;
        L13:
            this.a.h();
        }

        public final boolean c(kl9.u r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "task");
            Intrinsics.checkNotNullParameter(r5, "currentPage");
            FLogger r6 = FLogger.a;
            r6.i(this.a.a(), "onInterceptTaskClick: " + r4);
            if (Intrinsics.areEqual(r4.a, this.a.d) == true) goto L6;
            r6.i(this.a.a(), "onInterceptTaskClick: " + r4 + " is not our task");
            return false;
        L6:
            this.a.c();
            return true;
        }
    }

    public abstract String a();

    public abstract TaskKey b();

    public abstract void c();

    public abstract void d();

    public abstract void f();

    public abstract void h();

    public final void e() {
        if (this.d.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        FLogger.a.e(a(), "removeTask: taskId is empty");
        return;
    L9:
        TaskCardStatus r1 = this.b;
        TaskCardStatus r2 = TaskCardStatus.STOPPED;
        if (r1 != r2) goto L13;
        FLogger.a.e(a(), "removeTask: task is stopped");
        return;
    L13:
        this.b = r2;
        FLogger r3 = FLogger.a;
        r3.i(a(), "removeTask: appId = " + this.a + ", taskId = " + this.d);
        AppletAppManagerService r4 = AppletAppManagerService.INSTANCE;
        String r5 = this.a;
        r4.getClass();
        AppletApplication r6 = AppletAppManagerService.a(r5);
        if (r6 == null) goto L16;
        r3.i(a(), "removeTask: releaseKeepAlive, appId = " + this.a);
        r6.F(KeepAliveRequester.AUDIO_PLAYER);
        r6.getLifecycle().removeObserver(this.c);
    L20:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new BaseMediaControlTask$removeTask$3(this, null), 3, null);
        return;
    L16:
        AppletRuntimeManager r7 = AppletRuntimeManager.INSTANCE;
        String r8 = this.a;
        r7.getClass();
        AppletRuntime r9 = AppletRuntimeManager.i(null, null, r8);
        if (r9 == null) goto L19;
        r3.i(a(), "removeTask: cancelAlive, appId = " + this.a);
        r9.p();
        goto L20
    L19:
        r3.e(a(), "removeTask: cancelAlive failed, appId = " + this.a);
        goto L20
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.applet.task.BaseMediaControlTask$appLifecycleObserver$1] */
    public BaseMediaControlTask(String r37) {
        Intrinsics.checkNotNullParameter(r37, "appId");
        this.a = r37;
        this.b = TaskCardStatus.STOPPED;
        a r2 = new a(this);
        this.c = new BaseMediaControlTask$appLifecycleObserver$1(this);
        il9.a r3 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r3 == null) goto L6;
        String r1 = r3.o0(new kl9.i(UUID.randomUUID().toString(), b(), TaskPriority.MEDIA_TASK.getValue(), TaskType.LOCAL, false, null, null, new kl9.p(null, null, "sslocal://task_management/start_task", Boolean.TRUE, null, null, 215), new kl9.p(null, null, "sslocal://task_management/cancel_task", null, null, null, 247), new kl9.v(-1, 0, TaskReplaceStrategy.REPLACE_TASK_WITH_SAME_TASK_KEY_IN_PLACE, 2), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("source_id", r37), TuplesKt.to("source_type", CommentScene.COMMENTSCENE_NO_AWEME)}), 103171), r2);
        if (r1 == null) goto L6;
    L7:
        this.d = r1;
        FLogger.a.i(a(), "createTask, taskId=".concat(r1));
        this.e = true;
        return;
    L6:
        r1 = "";
        goto L7
    }

    public final void g(boolean r11) {
        if (this.e == r11) goto L17;
        this.e = r11;
        FLogger.a.i(a(), "visible changed to " + r11);
        if (this.d.length() <= 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L18;
        il9.a r13 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r13 == null) goto L19;
        String r2 = this.d;
        if (this.e == false) goto L14;
        TaskDisplayStatus r3 = TaskDisplayStatus.DISPLAYED;
    L15:
        r13.P(new p0(r2, null, new l0(null, r3, null, null, 4093)), false);
        return;
    L14:
        r3 = TaskDisplayStatus.HIDDEN;
        goto L15
    L19:
        return;
    L18:
        return;
    L7:
        r12 = false;
        goto L8
    }
}
