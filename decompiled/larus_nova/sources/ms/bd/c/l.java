package ms.bd.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.mobsec.metasec.ml.MSC;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes5.dex */
public final class l implements Application.ActivityLifecycleCallbacks {
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

    public l() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        if (n.f515227e == true) goto L6;
        n.f515227e = true;
        n.f515230h.post(new i(r100));
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        if (n.f515227e == false) goto L6;
        n.f515230h.post(new k(this));
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(final Activity r100, Bundle r101) {
        if (((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5e1c26", new byte[]{32, 104, 87, 14, 4, 47})).equals((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "18ed96", new byte[]{36, 53, 3, 9, 15, 47})) == true) goto L5;
        return;
    L5:
        if ((MSC.GetABSwitch() & 256) != 256) goto L9;
        n.f515230h.post(new l4(r100));
        return;
    }
}
