package s67;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.utils.f;
import com.bytedance.push.utils.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends Observable implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f540834d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f540835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f540836f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Application.ActivityLifecycleCallbacks> f540837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f540838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Activity> f540839c;

    public static class a extends k<d> {
        public a() {
        }

        @Override // com.bytedance.push.utils.k
        public final d create(Object[] r100) {
            return new d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    static {
        f540834d = new a();
        f540835e = true;
        f540836f = false;
    }

    public static d a() {
        return f540834d.get(new Object[0]);
    }

    public d() {
        this.f540837a = new ArrayList();
        f540835e = ActivityLifecycleObserver.getIns().isBackGround();
        Activity r100 = ActivityLifecycleObserver.getIns().getTopActivity();
        if (r100 == null) goto L5;
        this.f540839c = new WeakReference(r100);
    L5:
        ActivityLifecycleObserver.getIns().addActivityLifeCycleListener(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        f.b("SysDialogActivityLifecycleObserver", "onActivityPaused:".concat(r100.getClass().getName()));
        if (r100.getClass().getName().contains("tSysActivity") == false) goto L5;
        return;
    L5:
        if (r100.getClass().getName().contains("BSysActivity") == true) goto L35;
        int r101 = this.f540838b - 1;
        this.f540838b = r101;
        Object[] r102 = null;
        if (r101 > 0) goto L14;
        StringBuilder r103 = new StringBuilder("onEnterBackground,topActivity:");
        WeakReference<Activity> r104 = this.f540839c;
        if (r104 == null) goto L12;
        Activity r105 = r104.get();
    L13:
        r103.append(r105);
        f.b("SysDialogActivityLifecycleObserver", r103.toString());
        f540835e = true;
        setChanged();
        notifyObservers(Boolean.valueOf(f540835e));
        goto L14
    L12:
        r105 = null;
    L14:
        int r106 = 0;
        if (this.f540838b >= 0) goto L17;
        this.f540838b = 0;
    L17:
        List<Application.ActivityLifecycleCallbacks> r107 = this.f540837a;
        monitor-enter(r107);
    L27:
        th = move-exception;
        throw th;
    L20:
        if (((ArrayList) this.f540837a).size() <= 0) goto L22;
        r102 = ((ArrayList) this.f540837a).toArray();     // Catch: Throwable -> L27
    L22:
        monitor-exit(r107);     // Catch: Throwable -> L27
        if (r102 == null) goto L34;
        int r108 = r102.length;
    L25:
        if (r106 >= r108) goto L36;
        ((Application.ActivityLifecycleCallbacks) r102[r106]).onActivityPaused(r100);
        r106 = r106 + 1;
        goto L25
    L36:
        return;
    L34:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        if (f.f267065a == false) goto L6;
        f.b("SysDialogActivityLifecycleObserver", "onActivityResumed:".concat(r100.getClass().getName()));
    L6:
        if (r100.getClass().getName().contains("tSysActivity") == false) goto L8;
        return;
    L8:
        if (r100.getClass().getName().contains("BSysActivity") == true) goto L38;
        int r101 = 0;
        if (this.f540838b >= 0) goto L13;
        this.f540838b = 0;
    L13:
        this.f540839c = new WeakReference(r100);
        Object[] r102 = null;
        if (this.f540838b != 0) goto L20;
        StringBuilder r103 = new StringBuilder("onEnterForeground,topActivity:");
        WeakReference<Activity> r104 = this.f540839c;
        if (r104 == null) goto L18;
        Activity r105 = r104.get();
    L19:
        r103.append(r105);
        f.b("SysDialogActivityLifecycleObserver", r103.toString());
        f540835e = false;
        f540836f = true;
        setChanged();
        notifyObservers(Boolean.valueOf(f540835e));
        goto L20
    L18:
        r105 = null;
    L20:
        this.f540838b++;
        List<Application.ActivityLifecycleCallbacks> r106 = this.f540837a;
        monitor-enter(r106);
    L30:
        th = move-exception;
        throw th;
    L23:
        if (((ArrayList) this.f540837a).size() <= 0) goto L25;
        r102 = ((ArrayList) this.f540837a).toArray();     // Catch: Throwable -> L30
    L25:
        monitor-exit(r106);     // Catch: Throwable -> L30
        if (r102 == null) goto L37;
        int r107 = r102.length;
    L28:
        if (r101 >= r107) goto L39;
        ((Application.ActivityLifecycleCallbacks) r102[r101]).onActivityResumed(r100);
        r101 = r101 + 1;
        goto L28
    L39:
        return;
    L37:
        return;
    }
}
