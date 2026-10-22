package my7;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes24.dex */
public interface c {
    void a();

    void b();

    Resources getResources(Activity r100, Resources r101);

    Resources getResources(Application r100, Resources r101);

    void onDestroy();
}
