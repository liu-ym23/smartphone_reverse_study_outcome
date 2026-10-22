package ki7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SharedPreferences f503642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile JSONObject f503643b;

    public d() {
    }

    public static SharedPreferences a(Context r100) {
        if (f503642a != null) goto L19;
        monitor-enter(d.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f503642a != null) goto L13;
        if (r100 == null) goto L13;
        f503642a = r100.getSharedPreferences("deep_link_settings_id", 0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
    L13:
        monitor-exit(d.class);     // Catch: Throwable -> L15
    L19:
        return f503642a;
    }

    public static JSONObject b(Context r100) {
        if (f503643b != null) goto L5;
        SharedPreferences r101 = a(r100);
        if (r101 == null) goto L15;
        String r102 = r101.getString("deeplink_setting_data", "");     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r102) == true) goto L15;
        f503643b = new JSONObject(r102);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        if (f503643b != null) goto L18;
        f503643b = new JSONObject();
    L18:
        return f503643b;
    L5:
        return f503643b;
    }
}
