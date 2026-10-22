package ff7;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    void onActivityCreated(Activity r100, Bundle r101);

    void onActivityPause(Activity r100);

    void onActivityResume(Activity r100);

    void onActivityStarted(Activity r100);

    void onBackground(Activity r100);

    void onChange(Activity r100, Fragment r101);

    void onFront(Activity r100);
}
