package z4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f569879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<Activity> f569880b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedList<Activity> f569881c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<c> f569882d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f569883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List<String> f569884f;

    /* JADX INFO: renamed from: z4.a$a, reason: collision with other inner class name */
    public static class C8414a extends b {
        public C8414a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            List<String> r101 = a.f569884f;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
            r101 = null;
        L6:
            if (r101.contains(r100.getClass().getName()) == false) goto L8;
            return;
        L8:
            a.f569880b.remove(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            List<String> r101 = a.f569884f;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
            r101 = null;
        L6:
            if (r101.contains(r100.getClass().getName()) == false) goto L8;
            return;
        L8:
            Intrinsics.checkNotNullParameter(r100, "activity");
            a.f569881c.add(r100);
            if (a.f569883e == false) goto L16;
            a r102 = a.f569879a;
            a.f569883e = false;
            ArrayList r103 = (ArrayList) a.f569882d;
            if ((!r103.isEmpty()) == false) goto L18;
            Iterator r104 = r103.iterator();
        L14:
            if (r104.hasNext() == false) goto L19;
            ((c) r104.next()).onAppForeground();
            goto L14
        L19:
            return;
        L18:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            List<String> r101 = a.f569884f;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
            r101 = null;
        L6:
            if (r101.contains(r100.getClass().getName()) == false) goto L8;
            return;
        L8:
            Intrinsics.checkNotNullParameter(r100, "activity");
            LinkedList<Activity> r102 = a.f569881c;
            r102.remove(r100);
            if (a.f569883e == false) goto L11;
            return;
        L11:
            if (r102.isEmpty() == false) goto L20;
            a.f569883e = true;
            List<c> r103 = a.f569882d;
            if ((true ^ r103.isEmpty()) == false) goto L21;
            Iterator r104 = ((ArrayList) r103).iterator();
        L16:
            if (r104.hasNext() == false) goto L22;
            ((c) r104.next()).onAppBackground();
            goto L16
        L22:
            return;
        L21:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            List<String> r102 = a.f569884f;
            if (r102 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("excludedActivityClasses");
            r102 = null;
        L6:
            if (r102.contains(r100.getClass().getName()) == false) goto L8;
            return;
        L8:
            LinkedList<Activity> r103 = a.f569880b;
            r103.remove(r100);
            r103.add(r100);
        }
    }

    public static class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }
    }

    public interface c {
        void onAppBackground();

        void onAppForeground();
    }

    public a() {
    }

    public final synchronized Activity a() {
        monitor-enter(this);
        LinkedList<Activity> r100 = f569880b;     // Catch: Throwable -> L12
        if (r100.isEmpty() == false) goto L6;
        Activity r101 = null;
    L7:
        if (r101 != null) goto L9;
    L14:
        monitor-exit(this);
        return r101;
    L9:
        if (r101.isFinishing() == false) goto L14;
        r100.removeLast();     // Catch: Throwable -> L12
        r101 = a();     // Catch: Throwable -> L12
        goto L14
    L6:
        r101 = r100.getLast();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    static {
        f569879a = new a();
        f569880b = new LinkedList();
        f569881c = new LinkedList();
        f569882d = new ArrayList();
        f569883e = true;
    }
}
