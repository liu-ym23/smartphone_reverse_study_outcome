package mm9;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.lego.init.util.InitContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.nova.NovaApplication;
import com.larus.utils.ApkUtil;
import com.larus.utils.logger.FLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static b b;
    public final JSONObject a;

    public b(NovaApplication r1) {
        this.a = b(r1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static JSONObject b(NovaApplication r4) {
        if (r4 != null) goto L32;
    L7:
        Context r5 = (Context) InitContext.d.get("base");     // Catch: Throwable -> L29
    L8:
        if (r5 == null) goto L12;
        ApplicationInfo r6 = r5.getApplicationInfo();     // Catch: Throwable -> L29
        if (r6 == null) goto L12;
        String r7 = r6.sourceDir;     // Catch: Throwable -> L29
    L13:
        String r8 = ApkUtil.b(r7);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r8) == false) goto L17;
        FLogger.a.d("ApkProperties", "apk channel info is null");     // Catch: Throwable -> L29
        return null;
    L17:
        JSONObject r2 = new JSONObject(r8);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(JSONObjectProtectorUtils.getString(r2, "meta_umeng_channel")) == true) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == true) goto L27;
        return null;
    L27:
        FLogger.a.d("ApkProperties", r2.toString());     // Catch: Throwable -> L29
        return r2;
    L24:
        r9 = false;
        goto L25
    L22:
        th = move-exception;
        FLogger.a.d("ApkProperties", Log.getStackTraceString(th));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        FLogger.a.d("ApkProperties", Log.getStackTraceString(th));
        return null;
    L12:
        r7 = null;
        goto L13
    L32:
        if (r4.getBaseContext() == null) goto L7;
        r5 = r4.getBaseContext();     // Catch: Throwable -> L29
        goto L8
    }

    public final String a(String r7) {
        Object r2 = null;
        JSONObject r3 = this.a;     // Catch: Exception -> L11
        if (r3 == null) goto L6;
        Object r1 = r3.get("meta_umeng_channel");     // Catch: Exception -> L11
    L7:
        FLogger r4 = FLogger.a;     // Catch: Exception -> L11
        if (r4.isDebug() == false) goto L10;
        r4.d("TtProperties", "meta_umeng_channel = ".concat(String.valueOf(r1)));     // Catch: Exception -> L11
    L10:
        r2 = r1;
        goto L13
    L6:
        r1 = null;
    L13:
        if ((r2 instanceof String) == true) goto L16;
        return r7;
    L16:
        return (String) r2;
    }
}
