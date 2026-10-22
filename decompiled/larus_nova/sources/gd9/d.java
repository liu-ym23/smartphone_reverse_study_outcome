package gd9;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.larus.nova.NovaApplication;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Stack<Activity> f480957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Stack<Activity> f480958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f480959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f480960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f480961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f480962f;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    public final List<Activity> d() {
        return CollectionsKt.toList(this.f480957a);
    }

    public final Activity e() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl((Activity) CollectionsKt.lastOrNull(this.f480958b));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        return (Activity) r101;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public d(NovaApplication r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        r100.registerActivityLifecycleCallbacks(this);
        this.f480957a = new Stack();
        this.f480958b = new Stack();
        this.f480959c = new CopyOnWriteArrayList();
        this.f480960d = new CopyOnWriteArrayList();
        this.f480961e = true;
        this.f480962f = true;
    }

    public final synchronized void a(com.bytedance.applet.task.x r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "callback");     // Catch: Throwable -> L11
        if ((!this.f480960d.contains(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L9;
        this.f480960d.add(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(b r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "listener");     // Catch: Throwable -> L11
        if ((!this.f480959c.contains(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L9;
        this.f480959c.add(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean c(Class<? extends Activity> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Stack<Activity> r101 = this.f480957a;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((Activity) r102.next()).getClass(), r100) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    public final synchronized void f(b r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "listener");     // Catch: Throwable -> L11
        if (this.f480959c.contains(r100) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L9;
        this.f480959c.remove(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f480957a.remove(r100);
        if (this.f480957a.isEmpty() == false) goto L8;
        Iterator<T> r101 = this.f480959c.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((b) r101.next()).onAllActivityDestroyed();
        goto L6
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f480962f = true;
        Iterator<T> r101 = this.f480960d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).onPaused(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator<T> r101 = this.f480960d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).onPreDestroyed(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityResumed(Activity r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L16
        this.f480962f = false;     // Catch: Throwable -> L16
        if (this.f480961e == false) goto L9;
        this.f480961e = false;     // Catch: Throwable -> L16
        Iterator<T> r101 = this.f480959c.iterator();     // Catch: Throwable -> L16
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b) r101.next()).onAppForeground();     // Catch: Throwable -> L16
    L9:
        Iterator<T> r102 = this.f480960d.iterator();     // Catch: Throwable -> L16
    L10:
        if (r102.hasNext() == false) goto L14;
        ((a) r102.next()).onResumed(r100);     // Catch: Throwable -> L16
        goto L10
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f480958b.add(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStopped(Activity r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L18
        this.f480958b.remove(r100);     // Catch: Throwable -> L18
        if (this.f480961e == false) goto L6;
    L11:
        Iterator<T> r101 = this.f480960d.iterator();     // Catch: Throwable -> L18
    L12:
        if (r101.hasNext() == false) goto L16;
        ((a) r101.next()).onStopped(r100);     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(this);
        return;
    L6:
        if (this.f480958b.isEmpty() == false) goto L11;
        this.f480961e = true;     // Catch: Throwable -> L18
        Iterator<T> r102 = this.f480959c.iterator();     // Catch: Throwable -> L18
    L9:
        if (r102.hasNext() == false) goto L11;
        ((b) r102.next()).onAppBackground();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f480957a.add(r100);
        Iterator<a> r102 = this.f480960d.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onCreate(r100);
        goto L4
    }
}
