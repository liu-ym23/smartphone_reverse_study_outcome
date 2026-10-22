package ss6;

import android.app.Activity;
import android.content.Context;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public interface c {
    String a(boolean r100);

    void b();

    List<Activity> getActivityStack();

    Observable<Boolean> getAppEnterBackgroundOb();

    int getAppId();

    String getAppName();

    String getAppVersion();

    Context getApplicationContext();

    String getBussinessVersionName();

    String getChannel();

    String getColdLaunchTime();

    Activity getCurrentActivity();

    String getDeviceId();

    long getServerTime();

    long getUpdateVersionCode();

    boolean isDebug();

    boolean isPluginReady();
}
