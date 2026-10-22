package j74;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.bdinstall.k0;
import com.bytedance.bdinstall.t;
import com.bytedance.bdinstall.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks, b {
    public int a;
    public boolean b;
    public boolean c;
    public b.a d;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r1) {
    }

    public a() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        int r3 = this.a - 1;
        this.a = r3;
        if (r3 > 0) goto L5;
        this.b = false;
    L5:
        if (r3 >= 0) goto L8;
        this.a = 0;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r3) {
        if (this.a >= 0) goto L5;
        this.a = 0;
    L5:
        int r4 = this.a;
        if (r4 != 0) goto L8;
        this.b = true;
    L8:
        this.a = r4 + 1;
        this.c = true;
        k0 r5 = this.d;
        if (r5 == null) goto L12;
        k0 r6 = r5;
        ((a) r6.b.d).d = null;
        t.a("dispatcher#active onResume");
        v.e(r6.b.a.a(), r6.a);
        return;
    }
}
