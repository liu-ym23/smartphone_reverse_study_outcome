package ll7;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Application.ActivityLifecycleCallbacks {
    public i() {
    }

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
        if (r100.getComponentName() != null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("WindowTopActivityListener", "registerActivityResume onActivityPaused activity.getComponentName() == null");
        return;
    L6:
        String r101 = r100.getComponentName().getClassName();
        if (TextUtils.isEmpty(r101) == true) goto L12;
        boolean r102 = j.f509705a;
        CopyOnWriteArrayList<String> r103 = j.f509706b;
        if (r103.contains(r101) == false) goto L13;
        r103.remove(r101);
        return;
    L13:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        if (r100.getComponentName() != null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("WindowTopActivityListener", "registerActivityResume onActivityResumed activity.getComponentName() == null");
        return;
    L6:
        String r101 = r100.getComponentName().getClassName();
        if (TextUtils.isEmpty(r101) == true) goto L10;
        boolean r102 = j.f509705a;
        j.f509706b.add(r101);
        return;
    }
}
