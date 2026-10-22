package com.bytedance.reparo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f267303a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    public b(c r100) {
        this.f267303a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        c r101 = this.f267303a;
        if (r101.f267305a != 0) goto L15;
        r101.getClass();
        c r102 = this.f267303a;
        if (r102.f267307c == true) goto L11;
        Iterator r103 = ((ArrayList) r102.f267306b).iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((a) r103.next()).b();
        goto L8
    L10:
        this.f267303a.f267307c = true;
    L11:
        Iterator r104 = ((ArrayList) this.f267303a.f267306b).iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        ((a) r104.next()).a();
    L15:
        this.f267303a.f267305a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        c r101 = this.f267303a;
        if (r101.f267307c == true) goto L5;
        return;
    L5:
        int r102 = r101.f267305a - 1;
        r101.f267305a = r102;
        if (r102 != 0) goto L11;
        r101.getClass();
        Iterator r103 = ((ArrayList) this.f267303a.f267306b).iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        ((a) r103.next()).c();
        goto L9
    L13:
        return;
    }
}
