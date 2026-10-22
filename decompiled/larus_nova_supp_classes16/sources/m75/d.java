package m75;

import android.content.Intent;
import android.os.Bundle;
import m75.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d<V extends e> {
    void detachView();

    void e(Bundle r1, Bundle r2);

    void f(V r1);

    void h(Bundle r1);

    void onActivityResult(int r1, int r2, Intent r3);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
