package sk3;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.store.utils.screenAdapt.FragmentLifecycleCallbacksImplToAndroidx;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    public final FragmentLifecycleCallbacksImplToAndroidx a;
    public final b b;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public a(h r2) {
        this.b = r2;
        if (e.t == false) goto L6;
        this.a = new FragmentLifecycleCallbacksImplToAndroidx(r2);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        b r0 = this.b;
        if (r0 == null) goto L6;
        r0.b(r2, r2);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        b r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r2, r2);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        e r5 = e.s;
        if (e.u.o == false) goto L10;
        FragmentLifecycleCallbacksImplToAndroidx r6 = this.a;
        if (r6 == null) goto L10;
        if ((r3 instanceof FragmentActivity) == false) goto L10;
        if (r6 == null) goto L10;
        ((FragmentActivity) r3).getSupportFragmentManager().registerFragmentLifecycleCallbacks(r6, true);
    L10:
        b r7 = this.b;
        if (r7 == null) goto L14;
        r7.a(r3, r3);
        return;
    }
}
