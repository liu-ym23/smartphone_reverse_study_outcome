package com.ss.android.lark.appcontext.applifecycle2.impl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements jva.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<kva.a> f408881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityRecorder2 f408882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<Application.ActivityLifecycleCallbacks> f408883c;

    /* JADX INFO: renamed from: com.ss.android.lark.appcontext.applifecycle2.impl.a$a, reason: collision with other inner class name */
    public static final class C4747a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f408884a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        public C4747a(a r100) {
            this.f408884a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            a r101 = this.f408884a;
            r101.f408882b.a(r100, Lifecycle.Event.ON_DESTROY);
            Iterator<T> r102 = r101.f408883c.iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            Application.ActivityLifecycleCallbacks r103 = (Application.ActivityLifecycleCallbacks) r102.next();
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
            r103.onActivityDestroyed(r100);     // Catch: Throwable -> L8
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L4
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            a r101 = this.f408884a;
            r101.f408882b.a(r100, Lifecycle.Event.ON_PAUSE);
            Iterator<T> r102 = r101.f408883c.iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            Application.ActivityLifecycleCallbacks r103 = (Application.ActivityLifecycleCallbacks) r102.next();
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
            r103.onActivityPaused(r100);     // Catch: Throwable -> L8
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L4
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            a r101 = this.f408884a;
            r101.f408882b.a(r100, Lifecycle.Event.ON_RESUME);
            Iterator<T> r102 = r101.f408883c.iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            Application.ActivityLifecycleCallbacks r103 = (Application.ActivityLifecycleCallbacks) r102.next();
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
            r103.onActivityResumed(r100);     // Catch: Throwable -> L8
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L4
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            a r101 = this.f408884a;
            r101.f408882b.a(r100, Lifecycle.Event.ON_START);
            Iterator<T> r102 = r101.f408883c.iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            Application.ActivityLifecycleCallbacks r103 = (Application.ActivityLifecycleCallbacks) r102.next();
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
            r103.onActivityStarted(r100);     // Catch: Throwable -> L8
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L4
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            a r101 = this.f408884a;
            r101.f408882b.a(r100, Lifecycle.Event.ON_STOP);
            Iterator<T> r102 = r101.f408883c.iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            Application.ActivityLifecycleCallbacks r103 = (Application.ActivityLifecycleCallbacks) r102.next();
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
            r103.onActivityStopped(r100);     // Catch: Throwable -> L8
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L4
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            a r102 = this.f408884a;
            r102.f408882b.a(r100, Lifecycle.Event.ON_CREATE);
            Iterator<T> r103 = r102.f408883c.iterator();
        L4:
            if (r103.hasNext() == false) goto L10;
            Application.ActivityLifecycleCallbacks r104 = (Application.ActivityLifecycleCallbacks) r103.next();
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
            r104.onActivityCreated(r100, r101);     // Catch: Throwable -> L8
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L4
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jva.a
    public final Activity getTopActivity() {
        final ActivityRecorder2 r100 = this.f408882b;
        r100.getClass();
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        r100.b(new ActivityRecorder2$getTopActivity$1(r100, r101));
        return (Activity) r101.element;
    }

    @Override // jva.a
    public final void a(com.ss.android.lark.appcontext.applifecycle.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        LinkedList<Application.ActivityLifecycleCallbacks> r101 = this.f408883c;
        monitor-enter(r101);
        this.f408883c.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // jva.a
    public final void b(Application.ActivityLifecycleCallbacks r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        LinkedList<Application.ActivityLifecycleCallbacks> r101 = this.f408883c;
        monitor-enter(r101);
        this.f408883c.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Application r100, List<? extends kva.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "extensions");
        this.f408881a = r101;
        this.f408882b = new ActivityRecorder2();
        this.f408883c = new LinkedList();
        r100.registerActivityLifecycleCallbacks(new C4747a(this));
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((kva.a) r102.next()).a(this);
        goto L4
    }
}
