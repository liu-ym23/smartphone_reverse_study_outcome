package mm9;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.larus.nova.NovaApplication;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements f09.a, Application.ActivityLifecycleCallbacks {
    public final Stack<Activity> a;
    public final Stack<Activity> b;
    public final Stack<Activity> c;
    public boolean d;
    public boolean e;
    public final CopyOnWriteArrayList<f09.a.b> f;
    public final CopyOnWriteArrayList<f09.a.a> g;

    /* JADX INFO: renamed from: mm9.a$a, reason: collision with other inner class name */
    public static final class C0011a {
    }

    static {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    @Override // f09.a
    public final Integer d() {
        return Integer.valueOf(this.a.size());
    }

    @Override // f09.a
    public final void finishAllActivities() {
        Stack<Activity> r0 = this.a;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(this.a);     // Catch: Throwable -> L22
        monitor-exit(r0);
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((Activity) r2.next()).finish();
        goto L8
    L10:
        Stack<Activity> r3 = this.a;
        monitor-enter(r3);
        Iterator r4 = r1.iterator();     // Catch: Throwable -> L19
    L14:
        if (r4.hasNext() == false) goto L16;
        Activity r5 = (Activity) r4.next();     // Catch: Throwable -> L19
        this.a.remove(r5);     // Catch: Throwable -> L19
        goto L14
    L16:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r3);
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // f09.a
    public final List<Activity> g() {
        return CollectionsKt.toList(this.a);
    }

    @Override // f09.a
    public final Activity getCurrentActivity() {
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

    @Override // f09.a
    public final Activity getTopActivity() {
        return this.a.peek();
    L4:
        return null;
    }

    @Override // f09.a
    public final void k() {
        Stack<Activity> r0 = this.a;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(this.a);     // Catch: Throwable -> L22
        monitor-exit(r0);
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((Activity) r2.next()).finishAndRemoveTask();
        goto L8
    L10:
        Stack<Activity> r3 = this.a;
        monitor-enter(r3);
        Iterator r4 = r1.iterator();     // Catch: Throwable -> L19
    L14:
        if (r4.hasNext() == false) goto L16;
        Activity r5 = (Activity) r4.next();     // Catch: Throwable -> L19
        this.a.remove(r5);     // Catch: Throwable -> L19
        goto L14
    L16:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r3);
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // f09.a
    public final List<Activity> m() {
        return CollectionsKt.toList(this.b);
    }

    @Override // f09.a
    public final boolean isAppBackground() {
        return this.d;
    }

    @Override // f09.a
    public final boolean isAppPaused() {
        return this.e;
    }

    public a(NovaApplication r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        r2.registerActivityLifecycleCallbacks(this);
        this.a = new Stack();
        this.b = new Stack();
        this.c = new Stack();
        this.d = true;
        this.e = true;
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
    }

    @Override // f09.a
    public final void b(Activity r2) {
        if (r2 == null) goto L5;
        r2.finish();
        this.a.remove(r2);
        return;
    }

    @Override // f09.a
    public final synchronized void c(f09.a.b r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L11
        if (this.f.contains(r2) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L9;
        this.f.remove(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // f09.a
    public final synchronized void e(f09.a.a r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "callback");     // Catch: Throwable -> L11
        if ((!this.g.contains(r2)) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L9;
        this.g.add(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // f09.a
    public final synchronized void f(f09.a.a r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "callback");     // Catch: Throwable -> L11
        if (this.g.contains(r2) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L9;
        this.g.remove(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // f09.a
    public final boolean h(Class<? extends Activity> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Iterator<Activity> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().getClass(), r3) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // f09.a
    public final synchronized void j(f09.a.b r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L11
        if ((!this.f.contains(r2)) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L9;
        this.f.add(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.a.remove(r4);
        this.c.remove(r4);
        if (this.a.isEmpty() == false) goto L8;
        Iterator<T> r0 = this.f.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((f09.a.b) r0.next()).onAllActivityDestroyed();
    L8:
        yp9.d.b.a("LifecycleHandler", "destroy " + r4);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityPaused(Activity r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "activity");     // Catch: Throwable -> L11
        yp9.d.b.a("LifecycleHandler", "pause " + r5);     // Catch: Throwable -> L11
        this.c.remove(r5);     // Catch: Throwable -> L11
        this.e = this.c.isEmpty();     // Catch: Throwable -> L11
        Iterator<T> r0 = this.g.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L9;
        ((f09.a.a) r0.next()).onPaused(r5);     // Catch: Throwable -> L11
        goto L6
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreDestroyed(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f09.a.a) r0.next()).onPreDestroyed(r3);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityResumed(Activity r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "activity");     // Catch: Throwable -> L21
        if (this.c.contains(r5) == true) goto L7;
        this.c.add(r5);     // Catch: Throwable -> L21
    L7:
        this.e = false;     // Catch: Throwable -> L21
        if (this.d == false) goto L13;
        System.currentTimeMillis();     // Catch: Throwable -> L21
        this.d = false;     // Catch: Throwable -> L21
        yp9.d.b.a("LifecycleHandler", "resume " + r5 + "; [AppEnterForeground]");     // Catch: Throwable -> L21
        Iterator<T> r0 = this.f.iterator();     // Catch: Throwable -> L21
    L11:
        if (r0.hasNext() == false) goto L14;
        ((f09.a.b) r0.next()).onAppForeground();     // Catch: Throwable -> L21
    L14:
        Iterator<T> r1 = this.g.iterator();     // Catch: Throwable -> L21
    L15:
        if (r1.hasNext() == false) goto L19;
        ((f09.a.a) r1.next()).onResumed(r5);     // Catch: Throwable -> L21
        goto L15
    L19:
        monitor-exit(this);
        return;
    L13:
        yp9.d.b.a("LifecycleHandler", "resume " + r5);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.b.add(r4);
        yp9.d.b.a("LifecycleHandler", "start " + r4);
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f09.a.a) r0.next()).onStart(r4);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final synchronized void onActivityStopped(Activity r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "activity");     // Catch: Throwable -> L20
        this.b.remove(r5);     // Catch: Throwable -> L20
        if (this.d == false) goto L7;
    L12:
        yp9.d.b.a("LifecycleHandler", "stop " + r5);     // Catch: Throwable -> L20
    L13:
        Iterator<T> r0 = this.g.iterator();     // Catch: Throwable -> L20
    L14:
        if (r0.hasNext() == false) goto L18;
        ((f09.a.a) r0.next()).onStopped(r5);     // Catch: Throwable -> L20
        goto L14
    L18:
        monitor-exit(this);
        return;
    L7:
        if (this.b.isEmpty() == false) goto L12;
        this.d = true;     // Catch: Throwable -> L20
        yp9.d.b.a("LifecycleHandler", "stop " + r5 + "; [AppEnterBackground]");     // Catch: Throwable -> L20
        Iterator<T> r1 = this.f.iterator();     // Catch: Throwable -> L20
    L10:
        if (r1.hasNext() == false) goto L13;
        ((f09.a.b) r1.next()).onAppBackground();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    @Override // f09.a
    public final Activity a(Activity r7, Function1<? super Activity, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r7, "curActivity");
        int r0 = this.a.size() - 1;
        boolean r3 = false;
    L3:
        if (r0 < 0) goto L23;
        if (r3 == false) goto L20;
        Activity r4 = this.a.get(r0);
        if (r8 == null) goto L8;
        Intrinsics.checkNotNull(r4);
        boolean r5 = r8.invoke(r4).booleanValue();
    L9:
        if (r5 == false) goto L22;
        if (r4 == null) goto L22;
        if (r4.isFinishing() == true) goto L22;
        if (r4.getTaskId() != 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L22;
        return r4;
    L16:
        r6 = false;
    L22:
        r0 = r0 - 1;
        goto L3
    L8:
        r5 = true;
        goto L9
    L20:
        if (this.a.get(r0) != r7) goto L22;
        r3 = true;
        goto L22
    L23:
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.a.add(r4);
        yp9.d r0 = yp9.d.b;
        StringBuilder r1 = new StringBuilder("create ");
        r1.append(r4);
        r1.append(' ');
        if (r5 != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.a("LifecycleHandler", r1.toString());
        Iterator<T> r3 = this.g.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ((f09.a.a) r3.next()).onCreate(r4, r5);
        goto L8
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }
}
