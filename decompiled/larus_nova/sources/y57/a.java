package y57;

import android.app.Activity;
import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface a {
    void a();

    void b();

    void c(Context r100);

    void d();

    String getAppId();

    String getHost();

    String getPackageName();

    Activity getTopActivity();

    void onEvent(String r100, JSONObject r101);
}
