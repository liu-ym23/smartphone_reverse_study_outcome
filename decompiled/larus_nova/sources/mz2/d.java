package mz2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f516473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f516474b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<c> f516475c = null;

    public d() {
    }

    static {
        f516473a = new d();
        f516474b = new a();
        ArrayList r100 = new ArrayList();
        f516475c = r100;
        b r101 = new b();
        Intrinsics.checkNotNullParameter(r101, "delegate");
        r100.add(r101);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator r101 = ((ArrayList) f516475c).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator r101 = ((ArrayList) f516475c).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator r101 = ((ArrayList) f516475c).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator r101 = ((ArrayList) f516475c).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).onActivityStarted(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator r101 = ((ArrayList) f516475c).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).onActivityStopped(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Iterator r102 = ((ArrayList) f516475c).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
        Iterator r102 = ((ArrayList) f516475c).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).onActivitySaveInstanceState(r100, r101);
        goto L4
    }
}
