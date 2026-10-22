package to7;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.Window;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set<String> f546943k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f546944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f546945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f546946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f546947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f546948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f546949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedList<Activity> f546950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArraySet<WeakReference<uo7.a>> f546951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArraySet<WeakReference<uo7.b>> f546952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f546953j;

    /* JADX INFO: renamed from: to7.a$a, reason: collision with other inner class name */
    public class C7754a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f546954a;

        public C7754a(a r100) {
            this.f546954a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            if (a.b(this.f546954a, r100) == false) goto L5;
            return;
        L5:
            a r101 = this.f546954a;     // Catch: Throwable -> L18
            r101.getClass();     // Catch: Throwable -> L18
            r100.getClass();     // Catch: Throwable -> L18
            Iterator<WeakReference<uo7.a>> r102 = r101.f546951h.iterator();     // Catch: Throwable -> L18
        L7:
            if (r102.hasNext() == false) goto L14;
            WeakReference<uo7.a> r103 = r102.next();     // Catch: Throwable -> L18
            if (r103 == null) goto L7;
            uo7.a r104 = r103.get();     // Catch: Throwable -> L18
            if (r104 == null) goto L7;
            r104.onActivityDestroyed(r100);     // Catch: Throwable -> L18
            goto L7
        L14:
            if (this.f546954a.f546950g.contains(r100) == false) goto L16;
            this.f546954a.f546950g.remove(r100);     // Catch: Throwable -> L18
        L16:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            if (a.b(this.f546954a, r100) == false) goto L6;
            return;
        L6:
            if (this.f546954a.f546950g.contains(r100) == true) goto L8;
            this.f546954a.f546950g.add(r100);     // Catch: Throwable -> L10
        L8:
            this.f546954a.f546948e = false;     // Catch: Throwable -> L10
            r100.getClass();     // Catch: Throwable -> L10
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            if (a.b(this.f546954a, r100) == false) goto L5;
            return;
        L5:
            Activity r101 = this.f546954a.e();     // Catch: Throwable -> L19
            if (r101 == null) goto L12;
            if (r101.equals(r100) == false) goto L10;
            this.f546954a.f546953j = null;     // Catch: Throwable -> L19
            goto L12
        L10:
            a r102 = this.f546954a;     // Catch: Throwable -> L19
            r102.f546953j = r101.getClass().getName();     // Catch: Throwable -> L19
        L12:
            if (this.f546954a.f546950g.contains(r100) == true) goto L14;
            this.f546954a.f546950g.add(r100);     // Catch: Throwable -> L19
        L14:
            a r103 = this.f546954a;     // Catch: Throwable -> L19
            if (r103.f546946c == true) goto L17;
            a.c(r103, r100);     // Catch: Throwable -> L19
        L17:
            this.f546954a.f546948e = true;     // Catch: Throwable -> L19
            r100.getClass();     // Catch: Throwable -> L19
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            if (a.b(this.f546954a, r100) == false) goto L6;
            return;
        L6:
            if (this.f546954a.f546950g.contains(r100) == true) goto L8;
            this.f546954a.f546950g.add(r100);     // Catch: Throwable -> L10
        L8:
            a.c(this.f546954a, r100);     // Catch: Throwable -> L10
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            if (a.b(this.f546954a, r100) == false) goto L6;
            return;
        L6:
            if (this.f546954a.f546950g.contains(r100) == true) goto L8;
            this.f546954a.f546950g.add(r100);     // Catch: Throwable -> L15
        L8:
            a r101 = this.f546954a;     // Catch: Throwable -> L15
            r101.getClass();     // Catch: Throwable -> L15
            r100.getClass();     // Catch: Throwable -> L15
            int r102 = r101.f546944a - 1;     // Catch: Throwable -> L15
            r101.f546944a = r102;     // Catch: Throwable -> L15
            if (r102 > 0) goto L13;
            r101.f546944a = 0;     // Catch: Throwable -> L15
            if (r101.f546946c == false) goto L13;
            r101.f546946c = false;     // Catch: Throwable -> L15
            r101.f(r100, true);     // Catch: Throwable -> L15
            r101.f546947d = 2;     // Catch: Throwable -> L15
        L13:
            r101.f(r100, false);     // Catch: Throwable -> L15
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            if (a.b(this.f546954a, r100) == false) goto L5;
            return;
        L5:
            a r102 = this.f546954a;     // Catch: Throwable -> L11
            r102.f546953j = null;     // Catch: Throwable -> L11
            if (r102.f546950g.contains(r100) == false) goto L8;
            this.f546954a.f546950g.remove(r100);     // Catch: Throwable -> L11
        L8:
            this.f546954a.f546950g.add(r100);     // Catch: Throwable -> L11
        L9:
            r100.getClass();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            if (a.b(this.f546954a, r100) == false) goto L5;
            return;
        L5:
            r100.getClass();     // Catch: Throwable -> L7
            return;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f546955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f546956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f546957c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f546957c.g(this.f546955a, this.f546956b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100, Activity r101, boolean r102) {
            this.f546957c = r100;
            this.f546955a = r101;
            this.f546956b = r102;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class c implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f546958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f546959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f546960c;

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            this.f546960c.g(this.f546958a, this.f546959b);
            return false;
        }

        public c(a r100, Activity r101, boolean r102) {
            this.f546960c = r100;
            this.f546958a = r101;
            this.f546959b = r102;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f546961a = null;

        static {
            f546961a = new a();
        }
    }

    static {
        HashSet r100 = new HashSet();
        f546943k = r100;
        r100.add("com.ss.android.article.base.feature.app.schema.AdsAppActivity");
        r100.add("com.bytedance.news.schema.AdsAppActivity");
        r100.add("com.dragon.read.push.AppSdkActivity");
        r100.add("com.dragon.read.push.AppSdkActivity");
        r100.add("com.ss.android.ugc.aweme.app.DeepLinkHandlerActivity");
        r100.add("com.ss.android.ugc.aweme.app.AppLinkHandler");
        r100.add("com.ixigua.schema.specific.AdsAppActivity");
        r100.add("com.ixigua.schema.specific.OppoAdsAppActivity");
        r100.add("com.ss.android.ugc.live.schema.SchemaActivity");
        r100.add("com.ss.android.ugc.live.schema.SingleTaskSchemaActivity");
    }

    public final Activity e() {
        LinkedList<Activity> r100 = this.f546950g;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == false) goto L8;
        return null;
    L8:
        return this.f546950g.getLast();
    }

    public a() {
        this.f546944a = 0;
        this.f546945b = 0;
        this.f546946c = false;
        this.f546947d = 1;
        this.f546951h = new CopyOnWriteArraySet();
        this.f546952i = new CopyOnWriteArraySet();
        this.f546950g = new LinkedList();
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static boolean b(a r100, Activity r101) {
        r100.getClass();
        if (r101 == null) goto L5;
        Set<String> r102 = f546943k;
        HashSet r103 = (HashSet) r102;
        return r103.contains(r101.getClass().getName());
    L5:
        return false;
    }

    public static void c(a r100, Activity r101) {
        r100.getClass();
        r101.getClass();
        if (r100.f546944a > 0) goto L7;
        r100.f546944a = 0;
        if (r100.f546946c == true) goto L7;
        r100.f546946c = true;
        r100.d(r101, true);
    L7:
        r100.f546944a++;
        r100.d(r101, false);
    }

    public final void d(Activity r100, boolean r101) {
        r100.getClass();
        if (Build.VERSION.SDK_INT >= 29) goto L18;
        g(r100, r101);
    L14:
        if (r101 == false) goto L20;
        h(r100, true);
        return;
    L20:
        return;
    L18:
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L14
    L5:
        if (r100.getWindow() != null) goto L7;
    L9:
        Looper.getMainLooper().getQueue().addIdleHandler(new c(this, r100, r101));     // Catch: Throwable -> L11
    L17:
        goto L14
    L7:
        if (a(r100.getWindow()) == null) goto L9;
        a(r100.getWindow()).post(new b(this, r100, r101));     // Catch: Throwable -> L11
        goto L17
    }

    public final void f(Activity r100, boolean r101) {
        if (r101 == false) goto L12;
        r100.getClass();
        Iterator<WeakReference<uo7.a>> r102 = this.f546951h.iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        WeakReference<uo7.a> r103 = r102.next();
        if (r103 == null) goto L5;
        uo7.a r104 = r103.get();
        if (r104 == null) goto L5;
        r104.onEnterBackground(r100);
        goto L5
    L11:
        h(r100, false);
        return;
    L12:
        r100.getClass();
        Iterator<WeakReference<uo7.a>> r105 = this.f546951h.iterator();
    L14:
        if (r105.hasNext() == false) goto L35;
        WeakReference<uo7.a> r106 = r105.next();
        if (r106 == null) goto L14;
        uo7.a r107 = r106.get();
        if (r107 == null) goto L14;
        r107.onEnterActivityBackground(r100);
        goto L14
    }

    public final void g(Activity r100, boolean r101) {
        if (r101 == false) goto L11;
        r100.getClass();
        Iterator<WeakReference<uo7.a>> r102 = this.f546951h.iterator();
    L5:
        if (r102.hasNext() == false) goto L19;
        WeakReference<uo7.a> r103 = r102.next();
        if (r103 == null) goto L5;
        uo7.a r104 = r103.get();
        if (r104 == null) goto L5;
        r104.onEnterForeground(r100);
        goto L5
    L19:
        return;
    L11:
        r100.getClass();
        Iterator<WeakReference<uo7.a>> r105 = this.f546951h.iterator();
    L13:
        if (r105.hasNext() == false) goto L34;
        WeakReference<uo7.a> r106 = r105.next();
        if (r106 == null) goto L13;
        uo7.a r107 = r106.get();
        if (r107 == null) goto L13;
        r107.onEnterActivityForeground(r100);
        goto L13
    }

    public final void h(Activity r100, boolean r101) {
        r100.getClass();
        Iterator<WeakReference<uo7.b>> r102 = this.f546952i.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        WeakReference<uo7.b> r103 = r102.next();
        if (r103 == null) goto L4;
        uo7.b r104 = r103.get();
        if (r104 == null) goto L4;
        if (r101 == true) goto L10;
        r104.onEnterBackground(r100);
        goto L4
    L10:
        r104.onEnterForeground(r100);
        goto L4
    }

    public final void i(Application r100, boolean r101) {
        if (this.f546949f == false) goto L5;
        return;
    L5:
        this.f546949f = true;
        r100.registerActivityLifecycleCallbacks(new C7754a(this));
        if (r101 == true) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Looper.getMainLooper().getQueue().addIdleHandler(new to7.b(this, r100));
        return;
    }
}
