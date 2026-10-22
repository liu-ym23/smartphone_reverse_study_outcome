package ia;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public interface e {
    void a(View r100);

    void b(View r100, Bundle r101);

    void onActivityCreated(Bundle r100);

    void onActivityResult(int r100, int r101, Intent r102);

    void onConfigurationChanged(Configuration r100);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void setUserVisibleHint(boolean r100);
}
