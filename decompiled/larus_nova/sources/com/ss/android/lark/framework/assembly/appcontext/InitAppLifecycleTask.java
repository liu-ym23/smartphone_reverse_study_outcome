package com.ss.android.lark.framework.assembly.appcontext;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.FocusHitPoint;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.appcontext.applifecycle.e;
import com.ss.android.lark.appcontext.applifecycle.n;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.appcontext.applifecycle.z;
import com.ss.android.lark.appcontext.applifecycle2.api.AppLifecycle2;
import com.ss.android.lark.appcontext.applifecycle2.impl.c;
import com.ss.android.lark.appcontext.applifecycle2.impl.g;
import com.ss.android.lark.appcontext.applifecycle2.ipc.BroadcastRemoteStateService;
import com.ss.android.lark.appcontext.timingdector.MainPageLifecycleManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mva.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/framework/assembly/appcontext/InitAppLifecycleTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "dependency", "Lcom/ss/android/lark/appcontext/applifecycle/IRunningProcessChecker;", "<init>", "(Lcom/ss/android/lark/appcontext/applifecycle/IRunningProcessChecker;)V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "appcontext-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitAppLifecycleTask extends AbstractLaunchTask<Object> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f425619d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f425620c;

    public static final class a {
    }

    public static final class b implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f425621a;

        public b(Context r100) {
            this.f425621a = r100;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.y
        public final void f(y.a r100, y.a r101) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            Intrinsics.checkNotNullParameter(r101, "newState");
            if (r101.f408860c == true) goto L5;
            return;
        L5:
            if (r100.f408860c == true) goto L12;
            String r102 = com.larksuite.framework.utils.z.b(this.f425621a);
            boolean r103 = DevEnvUtil.isDebugMode(this.f425621a);
            String r104 = ApkUtil.getAppVersionName(this.f425621a);
            if (r103 == false) goto L9;
            r104 = r104 + "-debug";
        L9:
            Log.i("InitAppLifecycleTask", "app enter foreground, process=" + r102 + ", app_version=" + r104);
            return;
        }
    }

    static {
        f425619d = new AtomicBoolean(false);
    }

    @Inject
    public InitAppLifecycleTask(z r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f425620c = r100;
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r100 = false;
        if (f425619d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        boolean r101 = r110 instanceof Application;
        if (r101 == false) goto L8;
        Application r102 = (Application) r110;
        LifecycleHandler.a(r102);
        MainPageLifecycleManager r103 = MainPageLifecycleManager.a.f408911a;
        r103.getClass();
        r102.registerActivityLifecycleCallbacks(r103);
    L8:
        boolean r104 = this.f425620c.canUseRunningProcess();
        final AppLifecycle r105 = AppLifecycle.a.f408803a;
        ArrayList r106 = new ArrayList();
        r105.getClass();
        if (r101 == false) goto L11;
        final Application r107 = (Application) r110;
    L12:
        r105.f408779b = r107;
        r105.f408790m = r104;
        r105.f408791n = true;
        String r108 = com.larksuite.framework.utils.z.c(r110);
        if (TextUtils.isEmpty(r108) == false) goto L15;
        r108 = PullConfiguration.PROCESS_NAME_MAIN;
    L15:
        r105.f408778a = r108;
        Iterator r109 = r106.iterator();
    L17:
        if (r109.hasNext() == false) goto L21;
        String r111 = (String) r109.next();
        if (r105.f408778a.startsWith(r111) == false) goto L17;
        Log.i("AppLifecycle", "init func, process " + r111 + ", not call setup");
    L28:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppLifecycle2.ProcessStateSyncMode r112 = AppLifecycle2.ProcessStateSyncMode.SINGLE;
        ArrayList r113 = new ArrayList();
        if (com.larksuite.framework.utils.z.e(r110) == true) goto L49;
        String r114 = com.larksuite.framework.utils.z.b(r110);
        if (TextUtils.isEmpty(r114) == false) goto L33;
    L35:
        boolean r115 = false;
    L36:
        if (r115 == true) goto L49;
        if (o0.c(r110) == true) goto L48;
        String r116 = com.larksuite.framework.utils.z.b(r110);
        if (TextUtils.isEmpty(r116) == false) goto L43;
    L45:
        if (r100 == true) goto L48;
        AppLifecycle2.ProcessStateSyncMode r117 = AppLifecycle2.ProcessStateSyncMode.SINGLE;
    L50:
        Intrinsics.checkNotNullParameter(r117, "mode");
        lva.a r118 = new lva.a();
        Intrinsics.checkNotNullParameter(r118, "extension");
        r113.add(r118);
        if (r101 == false) goto L53;
        Application r119 = (Application) r110;
    L54:
        ArrayList r120 = new ArrayList(r113);
        AppLifecycle2.b r121 = new AppLifecycle2.b(r119, r117, r104, r120);
        c r122 = AppLifecycle2.f408863a;
        Intrinsics.checkNotNullParameter(r121, "config");
        Application r123 = r121.getContext();
        String r124 = AppLifecycle2.c(r123);
        g r125 = new g(r124, new com.ss.android.lark.appcontext.applifecycle2.impl.a(r123, r120));
        Intrinsics.checkNotNullParameter("broadcast", "name");
        Intrinsics.checkNotNullParameter(r123, "application");
        if (Intrinsics.areEqual("broadcast", "broadcast") == false) goto L80;
        BroadcastRemoteStateService r126 = new BroadcastRemoteStateService(r123);
        int r127 = AppLifecycle2.c.f408870a[r117.ordinal()];
        mva.a r128 = r126;
        if (r127 != 1) goto L59;
    L66:
        AppLifecycle2.f408863a = new c(r123, r125, r128, r104);
        LinkedList<jva.b> r129 = AppLifecycle2.f408864b;
        monitor-enter(r129);
        Iterator<T> r130 = r129.iterator();     // Catch: Throwable -> L76
    L70:
        if (r130.hasNext() == false) goto L72;
        AppLifecycle2.d((jva.b) r130.next());     // Catch: Throwable -> L76
        goto L70
    L72:
        AppLifecycle2.f408864b.clear();     // Catch: Throwable -> L76
        Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L76
        monitor-exit(r129);
        Log.i("AppLifecycle2", "process: " + r124 + ", AppLifecycle2 init end");
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(new b(r110));
        boolean r132 = FocusHitPoint.f408807a;
        InitAppLifecycleTask$execute$2 r133 = InitAppLifecycleTask$execute$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r133, "logger");
        FocusHitPoint.f408810d = r133;
        Log.i("InitAppLifecycleTask", "init finish, canUseRunningProcess:" + r104);
        return;
    L76:
        th = move-exception;
        throw th;
    L59:
        if (r127 != 2) goto L61;
        mva.a r134 = new d(r126);
    L65:
        r128 = r134;
        goto L66
    L61:
        if (r127 == 3) goto L63;
        r128 = new mva.b();
        goto L66
    L63:
        r134 = new mva.c(r124, r126);
        goto L65
    L80:
        throw new UnsupportedOperationException("process service broadcast not implement yet");
    L53:
        Context r135 = r110.getApplicationContext();
        Intrinsics.checkNotNull(r135, "null cannot be cast to non-null type android.app.Application");
        r119 = (Application) r135;
        goto L54
    L43:
        if (r116.contains(":sandboxed_process") == false) goto L45;
        r100 = true;
    L48:
        r117 = AppLifecycle2.ProcessStateSyncMode.ONLY_DETECTOR;
        goto L50
    L33:
        if (r114.contains(":simple") == false) goto L35;
        r115 = true;
    L49:
        r117 = AppLifecycle2.ProcessStateSyncMode.ONLY_TRIGGER;
        goto L50
    L21:
        com.ss.android.lark.appcontext.applifecycle.g r136 = r105.f408788k;
        if (r136 == null) goto L24;
        Uri r137 = AppLifecycle.LifecycleContentProvider.f408792g;
        r107.getContentResolver().unregisterContentObserver(r136);
    L24:
        n r138 = r105.f408789l;
        if (r138 == null) goto L27;
        r107.unregisterActivityLifecycleCallbacks(r138);
    L27:
        r105.f408787j = y.a.a(null, r105.g(), r105.f408778a, 0);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new e(r105, r107));
        com.ss.android.lark.appcontext.applifecycle.g r139 = new com.ss.android.lark.appcontext.applifecycle.g(r105, new Handler(Looper.getMainLooper()), r107);
        r105.f408788k = r139;
        Uri r140 = AppLifecycle.LifecycleContentProvider.f408792g;
        r107.getContentResolver().registerContentObserver(AppLifecycle.LifecycleContentProvider.a(r107), true, r139);
        n r141 = new n(r105);
        r105.f408789l = r141;
        r107.registerActivityLifecycleCallbacks(r141);
        goto L28
    L11:
        r107 = (Application) r110.getApplicationContext();
        goto L12
    }
}
