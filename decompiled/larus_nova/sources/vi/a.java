package vi;

import android.app.Activity;
import android.content.Context;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface a {
    Activity a();

    boolean b(Activity r100);

    Activity c(Context r100, boolean r101);

    void d(JSONObject r100);

    String e();

    boolean f();

    String getAppId();

    String getAppVersion();

    String getAppVersionName();

    Context getApplicationContext();

    String getBussinessVersionName();

    String getChannel();

    @Deprecated(message = "dont use， return wrong sometimes")
    Activity getCurrentActivity();

    Float getCurrentFontScale();

    String getInstallId();

    String getServerDeviceId();

    String getSessionID();

    String getSessionKey();

    String getUpdateVersionCode();

    boolean isDebug();

    boolean isLocalTest();

    boolean isNightMode();
}
