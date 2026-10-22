package com.bytedance.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.ss.android.message.PushThreadHandlerManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f266870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v67.u f266871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f266872c;

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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        k r101 = this.f266872c;
        r101.f266887b = false;
        r101.f266888c = new WeakReference(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        WeakReference<Activity> r101 = this.f266872c.f266888c;
        if (r101 == null) goto L5;
        Activity r102 = r101.get();
    L6:
        if (r102 == null) goto L8;
        if (r102 == r100) goto L8;
        return;
    L8:
        k r103 = this.f266872c;
        r103.f266888c = null;
        int r104 = k.f266884d;
        if (r104 == 2) goto L13;
        if (r104 == 3) goto L13;
    L20:
        k r105 = this.f266872c;
        r105.f266887b = true;
        k.a r106 = r105.f266886a;
        if (r106 == null) goto L27;
        r106.f266892d = true;
        r105.f266886a = null;
        return;
    L27:
        return;
    L13:
        if (r103.f266887b == true) goto L20;
        Context r107 = this.f266870a;
        PushThreadHandlerManager.inst().postRunnable(new i(this.f266871b, r107));     // Catch: Exception -> L17
    L19:
        com.bytedance.push.utils.f.b("Polling", "report switch status when app go to foreground");
    L17:
        e = move-exception;
        com.bytedance.push.utils.f.f("Polling", "performForegroundAction：Failed to report the switch status", e);
        goto L19
    L5:
        r102 = null;
        goto L6
    }

    public g(k r100, Context r101, v67.u r102) {
        this.f266872c = r100;
        this.f266870a = r101;
        this.f266871b = r102;
    }
}
