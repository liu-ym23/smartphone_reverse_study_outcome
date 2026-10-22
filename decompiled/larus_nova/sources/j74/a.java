package j74;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.bdinstall.k0;
import com.bytedance.bdinstall.t;
import com.bytedance.bdinstall.v;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f497574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f497575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f497576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b.a f497577d;

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

    public a() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        int r101 = this.f497574a - 1;
        this.f497574a = r101;
        if (r101 > 0) goto L5;
        this.f497575b = false;
    L5:
        if (r101 >= 0) goto L8;
        this.f497574a = 0;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        if (this.f497574a >= 0) goto L5;
        this.f497574a = 0;
    L5:
        int r101 = this.f497574a;
        if (r101 != 0) goto L8;
        this.f497575b = true;
    L8:
        this.f497574a = r101 + 1;
        this.f497576c = true;
        b.a r102 = this.f497577d;
        if (r102 == null) goto L12;
        k0 r103 = (k0) r102;
        ((a) r103.f199688b.f199657d).f497577d = null;
        t.a("dispatcher#active onResume");
        v.e(r103.f199688b.f199654a.a(), r103.f199687a);
        return;
    }
}
