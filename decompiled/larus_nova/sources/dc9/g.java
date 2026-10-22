package dc9;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.larus.platform.service.e2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Application.ActivityLifecycleCallbacks {
    public g() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    L24:
        th = move-exception;
        FLogger.f375446a.e("PadController", "adaptScreenOrientation failed:" + th, th);
        return;
    L4:
        if (h.a(r100) == false) goto L29;
        String r102 = r100.getClass().getName();     // Catch: Throwable -> L24
        int r103 = 1;
        if (e2.f365734a.isPad() == false) goto L16;
        List r104 = (List) h.f467895a.getValue();     // Catch: Throwable -> L24
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == true) goto L16;
    L21:
        r103 = 13;
    L22:
        r100.setRequestedOrientation(r103);     // Catch: Throwable -> L24
        FLogger.f375446a.i("PadController", "change " + r102 + " orientation to " + r103);     // Catch: Throwable -> L24
        return;
    L11:
        if (r104.contains(r102) != true) goto L13;
        r105 = true;
    L16:
        if ((r100 instanceof i19.a) == false) goto L20;
        if (((i19.a) r100).x() == true) goto L21;
    L20:
        if (h.f467896b.contains(r102) == false) goto L22;
    }
}
