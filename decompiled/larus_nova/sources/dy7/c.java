package dy7;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import by7.e;
import by7.h;
import com.ixigua.lib.track.FrozenTrackNode;
import ey7.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<b> f470547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f470548b = null;

    public c() {
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    static {
        f470548b = new c();
        f470547a = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        if ((r100 instanceof by7.c) == false) goto L5;
        List<b> r101 = f470547a;
        ArrayList r102 = (ArrayList) r101;
        r102.remove(new b((by7.c) r100));
    L5:
        int r103 = ey7.c.f474809a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        if (r100 == 0) goto L6;
        Intent r102 = r100.getIntent();
        if (r102 == null) goto L6;
    L7:
        ConcurrentHashMap<String, FrozenTrackNode> r103 = d.f474810a;
        if (h.c(r102) != null) goto L16;
        if ((r100 instanceof a) == false) goto L12;
        e r104 = ((a) r100).a();
    L13:
        if (r104 == null) goto L16;
        h.i(r102, r104);
        goto L16
    L12:
        r104 = null;
    L16:
        if ((r100 instanceof by7.c) == false) goto L18;
        List<b> r105 = f470547a;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new b((by7.c) r100));
    L18:
        int r107 = ey7.c.f474809a;
        return;
    L6:
        r102 = new Intent();
        goto L7
    }
}
