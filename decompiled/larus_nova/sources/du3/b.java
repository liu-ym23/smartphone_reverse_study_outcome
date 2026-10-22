package du3;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    String a();

    String b();

    void c();

    JSONObject d();

    Map<String, String> e();

    int getAid();

    String getAppVersion();

    String getChannel();

    Context getContext();

    String getDeviceId();

    int getManifestVersionCode();

    String getSessionId();

    long getUid();

    int getUpdateVersionCode();

    int getVersionCode();

    String getVersionName();
}
