package gd9;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.applet.task.x;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d implements Application.ActivityLifecycleCallbacks {
    public final Stack<Activity> a;
    public final Stack<Activity> b;
    public final CopyOnWriteArrayList<b> c;
    public final CopyOnWriteArrayList<a> d;
    public boolean e;
    public boolean f;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    public final List<Activity> d() {
        return CollectionsKt.toList(this.a);
    }

    public final Activity e() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m49constructorimpl((Activity) CollectionsKt.lastOrNull(this.b));     // Catch: Throwable -> L4
    L7:
        if (Result.m55isFailureimpl(r1) == false) goto L10;
        r1 = null;
    L10:
        return (Activity) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public d(NovaApplication r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        r2.registerActivityLifecycleCallbacks(this);
        this.a = new Stack();
        this.b = new Stack();
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.e = true;
        this.f = true;
    }

    public final synchronized void a(x r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "callback");     // Catch: Throwable -> L11
        if ((!this.d.contains(r2)) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L9;
        this.d.add(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(b r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L11
        if ((!this.c.contains(r2)) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L9;
        this.c.add(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean c(Class<? extends Activity> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Stack<Activity> r0 = this.a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((Activity) r1.next()).getClass(), r3) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final synchronized void f(b r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L11
        if (this.c.contains(r2) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L9;
        this.c.remove(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.remove(r2);
        if (this.a.isEmpty() == false) goto L8;
        Iterator<T> r3 = this.c.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((b) r3.next()).onAllActivityDestroyed();
        goto L6
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        this.f = true;
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).onPaused(r3);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreDestroyed(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).onPreDestroyed(r3);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityResumed(Activity r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "activity");     // Catch: Throwable -> L16
        this.f = false;     // Catch: Throwable -> L16
        if (this.e == false) goto L9;
        this.e = false;     // Catch: Throwable -> L16
        Iterator<T> r0 = this.c.iterator();     // Catch: Throwable -> L16
    L7:
        if (r0.hasNext() == false) goto L9;
        ((b) r0.next()).onAppForeground();     // Catch: Throwable -> L16
    L9:
        Iterator<T> r1 = this.d.iterator();     // Catch: Throwable -> L16
    L10:
        if (r1.hasNext() == false) goto L14;
        ((a) r1.next()).onResumed(r3);     // Catch: Throwable -> L16
        goto L10
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.b.add(r2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStopped(Activity r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "activity");     // Catch: Throwable -> L18
        this.b.remove(r3);     // Catch: Throwable -> L18
        if (this.e == false) goto L6;
    L11:
        Iterator<T> r0 = this.d.iterator();     // Catch: Throwable -> L18
    L12:
        if (r0.hasNext() == false) goto L16;
        ((a) r0.next()).onStopped(r3);     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(this);
        return;
    L6:
        if (this.b.isEmpty() == false) goto L11;
        this.e = true;     // Catch: Throwable -> L18
        Iterator<T> r1 = this.c.iterator();     // Catch: Throwable -> L18
    L9:
        if (r1.hasNext() == false) goto L11;
        ((b) r1.next()).onAppBackground();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.add(r2);
        Iterator<a> r4 = this.d.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().onCreate(r2);
        goto L4
    }
}
