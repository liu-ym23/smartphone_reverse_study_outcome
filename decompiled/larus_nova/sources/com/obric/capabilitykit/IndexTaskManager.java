package com.obric.capabilitykit;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.capabilitykit.logger.Logger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001c\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/IndexTaskManager;", "", "()V", "DELAY_MILLIS", "", "MSG_EXECUTE_TASK", "", "TAG", "", "currentHandlerThread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "pendingTaskList", "", "Lcom/obric/capabilitykit/IndexTaskManager$PendingIndexTask;", "kotlin.jvm.PlatformType", "", "getFullTaskName", "taskName", "init", "", "init$capabilitykit_release", "postTask", "task", "Ljava/lang/Runnable;", "postTaskDelay", "delayTimeMs", "runTask", "scheduleRestoreHistoryProcessTask", "IndexTask", "PendingIndexTask", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IndexTaskManager {
    private static final long DELAY_MILLIS = 60000;
    public static final IndexTaskManager INSTANCE = null;
    private static final int MSG_EXECUTE_TASK = 1;
    private static final String TAG = "IndexTaskManager";
    private static volatile HandlerThread currentHandlerThread;
    private static volatile Handler handler;
    private static final List<b> pendingTaskList = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f396121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f396122b;

        public a(String r100, Runnable r101) {
            Intrinsics.checkNotNullParameter(r101, "runnable");
            this.f396121a = r101;
            this.f396122b = IndexTaskManager.access$getFullTaskName(IndexTaskManager.INSTANCE, r100);
        }

        public final void a() {
            Logger r100 = Logger.INSTANCE;
            r100.i(IndexTaskManager.TAG, "Task: " + this.f396122b + ", start");
            long r101 = System.currentTimeMillis();
            this.f396121a.run();
            r100.i(IndexTaskManager.TAG, "Task: " + this.f396122b + " end, costTime: " + (System.currentTimeMillis() - r101));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f396123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f396124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f396125c;

        public b(long r100, String r101, Runnable r102) {
            Intrinsics.checkNotNullParameter(r102, "runnable");
            this.f396123a = r100;
            this.f396124b = r101;
            this.f396125c = r102;
        }
    }

    public static final class c extends PthreadHandlerThreadV2 {

        public static final class a extends Handler {
            public a(Looper r100) {
                super(r100);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message r100) {
                Intrinsics.checkNotNullParameter(r100, "msg");
                if (r100.what != 1) goto L6;
                p.f396259a.b();
                return;
            }
        }

        public c() {
            super("EntityProviderThread");
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            IndexTaskManager r100 = IndexTaskManager.INSTANCE;
            monitor-enter(r100);
            IndexTaskManager.access$setHandler$p(new a(getLooper()));     // Catch: Throwable -> L11
            Iterator r101 = IndexTaskManager.access$getPendingTaskList$p().iterator();     // Catch: Throwable -> L11
        L6:
            if (r101.hasNext() == false) goto L8;
            b r102 = (b) r101.next();     // Catch: Throwable -> L11
            IndexTaskManager.INSTANCE.postTaskDelay(r102.f396123a, r102.f396124b, r102.f396125c);     // Catch: Throwable -> L11
            goto L6
        L8:
            IndexTaskManager.access$getPendingTaskList$p().clear();     // Catch: Throwable -> L11
            monitor-exit(r100);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    static {
        INSTANCE = new IndexTaskManager();
        pendingTaskList = Collections.synchronizedList(new ArrayList());
    }

    private IndexTaskManager() {
    }

    public static final /* synthetic */ String access$getFullTaskName(IndexTaskManager r100, String r101) {
        return r100.getFullTaskName(r101);
    }

    public static final /* synthetic */ List access$getPendingTaskList$p() {
        return pendingTaskList;
    }

    public static final /* synthetic */ void access$setHandler$p(Handler r100) {
        handler = r100;
    }

    private final String getFullTaskName(String r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L6;
        String r102 = r100.concat("_");
        if (r102 == null) goto L6;
    L7:
        r101.append(r102);
        r101.append(System.currentTimeMillis());
        return r101.toString();
    L6:
        r102 = "";
        goto L7
    }

    public static /* synthetic */ void postTaskDelay$default(IndexTaskManager r100, long r101, String r102, Runnable r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.postTaskDelay(r101, r102, r103);
    }

    public final synchronized void init$capabilitykit_release() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (handler != null) goto L16;
        HandlerThread r100 = currentHandlerThread;     // Catch: Throwable -> L18
        if (r100 == null) goto L10;
        boolean r101 = true;
        if (ThreadMethodProxy.isAlive(r100) != true) goto L10;
    L11:
        if (r101 == true) goto L16;
        c r102 = new c();     // Catch: Throwable -> L18
        currentHandlerThread = r102;     // Catch: Throwable -> L18
        ThreadMethodProxy.start(r102);     // Catch: Throwable -> L18
        Logger.INSTANCE.d(TAG, "IndexTaskManager thread start");     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L10:
        r101 = false;
    L16:
        monitor-exit(this);
    }

    public final synchronized void postTask(String r100, Runnable r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "task");     // Catch: Throwable -> L6
        postTaskDelay(0, r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void postTaskDelay(long r100, String r101, Runnable r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r102, "task");     // Catch: Throwable -> L14
        if (handler != null) goto L9;
        Logger.INSTANCE.d(TAG, "postPending: " + r101);     // Catch: Throwable -> L14
        pendingTaskList.add(new b(r100, r101, r102));     // Catch: Throwable -> L14
        init$capabilitykit_release();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L9:
        Logger.INSTANCE.d(TAG, "postTaskDelay: " + r101);     // Catch: Throwable -> L14
        Handler r103 = handler;     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        r103.postDelayed(new a(r101, r102), r100);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void runTask(String r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r101, "task");
        Looper r102 = Looper.myLooper();
        if (r102 == null) goto L11;
        Handler r103 = handler;
        if (r103 == null) goto L7;
        Looper r104 = r103.getLooper();
    L9:
        if (Intrinsics.areEqual(r104, r102) == false) goto L11;
        new a(r100, r101).run();
        return;
    L7:
        r104 = null;
    L11:
        postTask(r100, r101);
    }

    public final void scheduleRestoreHistoryProcessTask() {
        Handler r100 = handler;
        if (r100 != null) goto L5;
        Logger.INSTANCE.e(TAG, "scheduleRestoreHistoryProcessTask handler is null");
        return;
    L5:
        if (r100.hasMessages(1) == false) goto L7;
        return;
    L7:
        Logger.INSTANCE.i(TAG, "scheduleRestoreHistoryProcessTask send");
        r100.sendEmptyMessageDelayed(1, 60000);
    }
}
