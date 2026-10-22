package ct3;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ff7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f465316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f465317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f465318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f465319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f465320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f465321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f465322g;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f465323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f465324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f465325c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.f465323a.get() != null) goto L5;
            return;
        L5:
            View r100 = ((View) this.f465323a.get()).findViewById(this.f465324b.intValue());
            if (r100 != null) goto L8;
            return;
        L8:
            if (r100.getVisibility() == 0) goto L10;
            return;
        L10:
            if (r100.getWidth() <= 0) goto L29;
            ViewTreeObserver r101 = ((View) this.f465323a.get()).getViewTreeObserver();
            if (r101.isAlive() == false) goto L16;
            ViewTreeObserver.OnGlobalLayoutListener r102 = this.f465325c.f465318c;
            if (r102 == null) goto L16;
            r101.removeOnGlobalLayoutListener(r102);
        L16:
            c r103 = this.f465325c;
            Runnable r104 = r103.f465319d;
            if (r104 == null) goto L19;
            r103.f465320e.removeCallbacks(r104);
            this.f465325c.f465319d = null;
        L19:
            c r105 = this.f465325c;
            r105.f465318c = null;
            if (r105.f465316a <= 0) goto L30;
            long r106 = System.currentTimeMillis();
            c r107 = this.f465325c;
            long r108 = r106 - r107.f465316a;
            r107.f465316a = 0;
            if (r108 < r107.f465321f) goto L24;
            return;
        L24:
            if (r108 <= 0) goto L32;
            AutoPageTraceHelper.reportViewIdStats(r106, r107.f465317b);
            MonitorTool.reportTraceTime(this.f465325c.f465317b, "activityOnCreateToViewShow", r108);
            return;
        L32:
            return;
        L30:
            return;
        }

        public a(c r100, WeakReference r101, Integer r102) {
            this.f465325c = r100;
            this.f465323a = r101;
            this.f465324b = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f465326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f465327b;

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f465327b.f465318c != null) goto L5;
            return;
        L5:
            if (this.f465326a.get() == null) goto L15;
            ((View) this.f465326a.get()).getViewTreeObserver().removeOnGlobalLayoutListener(this.f465327b.f465318c);     // Catch: Throwable -> L8
            return;
        }

        public b(c r100, WeakReference r101) {
            this.f465327b = r100;
            this.f465326a = r101;
        }
    }

    @Override // ff7.c
    public final void onActivityResume(Activity r100) {
    }

    @Override // ff7.c
    public final void onActivityStarted(Activity r100) {
    }

    @Override // ff7.c
    public final void onBackground(Activity r100) {
    }

    @Override // ff7.c
    public final void onChange(Activity r100, Fragment r101) {
    }

    @Override // ff7.c
    public final void onFront(Activity r100) {
    }

    public c() {
        this.f465316a = -1;
        this.f465320e = new Handler(Looper.getMainLooper());
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

    public final void b(Activity r100) {
        this.f465316a = System.currentTimeMillis();
        String r101 = r100.getClass().getCanonicalName();
        this.f465317b = r101;
        Integer r102 = ft3.a.a(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        WeakReference r103 = new WeakReference(a(r100.getWindow()));
        this.f465318c = new a(this, r103, r102);
        ((View) r103.get()).getViewTreeObserver().addOnGlobalLayoutListener(this.f465318c);
        b r104 = new b(this, r103);
        this.f465319d = r104;
        this.f465320e.postDelayed(r104, this.f465321f);
    }

    @Override // ff7.c
    public final void onActivityPause(Activity r100) {
        this.f465316a = 0;
        if (this.f465318c == null) goto L6;
        a(r100.getWindow()).getViewTreeObserver().removeOnGlobalLayoutListener(this.f465318c);     // Catch: Exception -> L10
        this.f465318c = null;     // Catch: Exception -> L10
    L6:
        Runnable r101 = this.f465319d;     // Catch: Exception -> L10
        if (r101 == null) goto L13;
        this.f465320e.removeCallbacks(r101);     // Catch: Exception -> L10
        this.f465319d = null;     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    @Override // ff7.c
    public final void onActivityCreated(Activity r100, Bundle r101) {
        if (this.f465322g == true) goto L8;
        return;
    L8:
        b(r100);     // Catch: Exception -> L7
        return;
    }
}
