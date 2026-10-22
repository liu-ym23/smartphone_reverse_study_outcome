package h16;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

/* JADX INFO: loaded from: classes19.dex */
public interface c {
    void a(Activity r100, Bundle r101);

    void b(Activity r100, Bundle r101);

    void e(Activity r100, Configuration r101);

    boolean f(Activity r100);

    void onActivityResult(Activity r100, int r101, int r102, Intent r103);

    void onCreate(Activity r100, Bundle r101);

    void onDestroy(Activity r100);

    void onPause(Activity r100);

    void onRequestPermissionsResult(Activity r100, int r101, String[] r102, int[] r103);

    void onResume(Activity r100);

    void onStart(Activity r100);

    void onStop(Activity r100);

    void onWindowFocusChanged(Activity r100, boolean r101);
}
