package qb4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.bdturing.EventReport;

/* JADX INFO: loaded from: classes12.dex */
public final class o implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f532368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f532369b;

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
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    public o(Activity r100) {
        this.f532369b = 1;
        this.f532368a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        if (r100 != this.f532368a) goto L6;
        this.f532369b++;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        if (r100 != this.f532368a) goto L8;
        int r101 = this.f532369b - 1;
        this.f532369b = r101;
        if (r101 != 0) goto L9;
        EventReport.H(null);
        return;
    L9:
        return;
    }
}
