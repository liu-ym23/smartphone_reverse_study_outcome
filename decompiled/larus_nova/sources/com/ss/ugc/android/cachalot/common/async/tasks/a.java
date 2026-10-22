package com.ss.ugc.android.cachalot.common.async.tasks;

import android.os.Looper;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.AsyncBindManager;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTask;
import com.ss.android.ugc.aweme.search.utils.DynamicTool;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T> extends AsyncTask<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Field f457141e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<T> f457142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f457143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Exception, Unit> f457144d;

    /* JADX INFO: renamed from: com.ss.ugc.android.cachalot.common.async.tasks.a$a, reason: collision with other inner class name */
    public static final class C5466a {
        public static void a(Looper r100) {
            if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
            return;
        L5:
            Field r101 = a.f457141e;
            r101.setAccessible(true);
            Object r102 = null;
            Object r103 = r101.get(null);
            if ((r103 instanceof ThreadLocal) == false) goto L9;
            r102 = r103;
        L9:
            ThreadLocal r104 = (ThreadLocal) r102;
            if (r104 == null) goto L13;
            r104.set(r100);
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f457145a;

        public b(a r100) {
            this.f457145a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f457145a.f457143c.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f457146a;

        public c(a r100) {
            this.f457146a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f457146a.f457143c.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTask
    public final void a() {
        C5466a.a(null);
        DynamicTool.b(new b(this));
    }

    static {
        f457141e = Looper.class.getDeclaredField("sThreadLocal");
    }

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTask
    public final T d() {
        return this.f457142b.invoke();
    }

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTask
    public final void b() {
        C5466a.a(Looper.getMainLooper());
    }

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTask
    public final void c(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r100, "e");
        C5466a.a(null);
        this.f457144d.invoke(r100);
        AsyncBindManager.f450607n.getClass();
        AsyncBindManager.Companion.c(r100);
        DynamicTool.b(new c(this));
    }

    public a(Function0 r100, Function0 r101) {
        MainThreadCheckTask$2 r102 = MainThreadCheckTask$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter("", "name");
        Intrinsics.checkNotNullParameter(r101, "onComplete");
        Intrinsics.checkNotNullParameter(r102, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f457142b = r100;
        this.f457143c = r101;
        this.f457144d = r102;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        this.f450728a = "";
    }
}
