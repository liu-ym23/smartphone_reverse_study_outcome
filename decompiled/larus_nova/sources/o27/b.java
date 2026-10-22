package o27;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f521784a;

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
        this.f521784a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        c r101 = this.f521784a;
        if (r101.f521786a != 0) goto L15;
        r101.f521787b = false;
        if (r101.f521789d == true) goto L11;
        Iterator r102 = ((ArrayList) r101.f521788c).iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((a) r102.next()).b();
        goto L8
    L10:
        this.f521784a.f521789d = true;
    L11:
        Iterator r103 = ((ArrayList) this.f521784a.f521788c).iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        ((a) r103.next()).a();
    L15:
        this.f521784a.f521786a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        c r101 = this.f521784a;
        int r102 = r101.f521786a - 1;
        r101.f521786a = r102;
        if (r102 != 0) goto L8;
        r101.f521787b = true;
        Iterator r103 = ((ArrayList) r101.f521788c).iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((a) r103.next()).c();
        goto L6
    L10:
        return;
    }
}
