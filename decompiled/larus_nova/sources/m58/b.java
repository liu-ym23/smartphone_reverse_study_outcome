package m58;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    boolean a();

    long b();

    String c(CharSequence r100, boolean r101, boolean r102);

    Activity currentActivity();

    boolean g();

    Application getApplication();

    boolean isAppBackground();

    boolean isAppPaused();
}
