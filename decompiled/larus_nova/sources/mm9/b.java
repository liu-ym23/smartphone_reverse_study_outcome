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

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f514498b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f514499a;

    public b(NovaApplication r100) {
        this.f514499a = b(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static JSONObject b(NovaApplication r100) {
        if (r100 != null) goto L32;
    L7:
        Context r101 = (Context) InitContext.f254569d.get("base");     // Catch: Throwable -> L29
    L8:
        if (r101 == null) goto L12;
        ApplicationInfo r102 = r101.getApplicationInfo();     // Catch: Throwable -> L29
        if (r102 == null) goto L12;
        String r103 = r102.sourceDir;     // Catch: Throwable -> L29
    L13:
        String r104 = ApkUtil.b(r103);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r104) == false) goto L17;
        FLogger.f375446a.d("ApkProperties", "apk channel info is null");     // Catch: Throwable -> L29
        return null;
    L17:
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(JSONObjectProtectorUtils.getString(r105, "meta_umeng_channel")) == true) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == true) goto L27;
        return null;
    L27:
        FLogger.f375446a.d("ApkProperties", r105.toString());     // Catch: Throwable -> L29
        return r105;
    L24:
        r106 = false;
        goto L25
    L22:
        th = move-exception;
        FLogger.f375446a.d("ApkProperties", Log.getStackTraceString(th));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        FLogger.f375446a.d("ApkProperties", Log.getStackTraceString(th));
        return null;
    L12:
        r103 = null;
        goto L13
    L32:
        if (r100.getBaseContext() == null) goto L7;
        r101 = r100.getBaseContext();     // Catch: Throwable -> L29
        goto L8
    }

    public final String a(String r100) {
        Object r101 = null;
        JSONObject r102 = this.f514499a;     // Catch: Exception -> L11
        if (r102 == null) goto L6;
        Object r103 = r102.get("meta_umeng_channel");     // Catch: Exception -> L11
    L7:
        FLogger r104 = FLogger.f375446a;     // Catch: Exception -> L11
        if (r104.isDebug() == false) goto L10;
        r104.d("TtProperties", "meta_umeng_channel = ".concat(String.valueOf(r103)));     // Catch: Exception -> L11
    L10:
        r101 = r103;
        goto L13
    L6:
        r103 = null;
    L13:
        if ((r101 instanceof String) == true) goto L16;
        return r100;
    L16:
        return (String) r101;
    }
}
