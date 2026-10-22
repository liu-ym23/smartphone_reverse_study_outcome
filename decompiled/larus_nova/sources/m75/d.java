package m75;

import android.content.Intent;
import android.os.Bundle;
import m75.e;

/* JADX INFO: loaded from: classes16.dex */
public interface d<V extends e> {
    void detachView();

    void e(Bundle r100, Bundle r101);

    void f(V r100);

    void h(Bundle r100);

    void onActivityResult(int r100, int r101, Intent r102);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
