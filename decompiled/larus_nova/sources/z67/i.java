package z67;

import android.os.Build;
import android.text.TextUtils;
import com.larus.push.impl.BDPushConfiguration;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import org.json.JSONException;
import org.json.JSONObject;
import v67.r;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f570524a;

    public static void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (r101 != null) goto L44;
        r101 = new JSONObject();
    L44:
        r101.put("is_new_user", com.bytedance.push.c.O.E);     // Catch: JSONException -> L12
        r101.put("brand", Build.BRAND);     // Catch: JSONException -> L12
        r101.put("rom_version", com.bytedance.push.utils.j.f267081c);     // Catch: JSONException -> L12
        if (com.bytedance.push.utils.j.h() == false) goto L7;
        String r104 = RomUtils.OS_HARMONY;
    L8:
        r101.put("os_detail_type", r104);     // Catch: JSONException -> L12
        String r105 = com.bytedance.push.utils.j.b();     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r101.put("extra_rom_version", r105);     // Catch: JSONException -> L12
    L14:
        com.bytedance.push.utils.f.b("Monitor", "serviceName=" + r100 + ", category=" + r101 + ", metric=" + r102 + ", extraLog=" + r103);
        if (f570524a != null) goto L17;
        com.bytedance.push.c.O.getClass();
    L17:
        c r106 = f570524a;
        if (r106 == null) goto L22;
        if (r106 != null) goto L21;
        com.bytedance.push.c.O.getClass();
    L21:
        ((com.larus.push.impl.a) f570524a).getClass();
        BDPushConfiguration.c(r100, r101, r102, r103);
    L23:
        r r107 = (r) rgc.b.a(r.class);
        JSONObject r108 = null;
        JSONObject r109 = new JSONObject(r101.toString());     // Catch: Throwable -> L26
    L27:
        if (r102 != null) goto L42;
    L28:
        JSONObject r110 = null;
    L30:
        if (r103 != null) goto L38;
    L34:
        r107.monitorEvent(r100, r109, r110, r108);
        return;
    L38:
        r108 = new JSONObject(r103.toString());     // Catch: Throwable -> L37
        goto L34
    L42:
        r110 = new JSONObject(r102.toString());     // Catch: Throwable -> L36
    L26:
        r109 = null;
        goto L27
    L22:
        com.bytedance.push.utils.f.i("Monitor", "host monitor impl is null when send event = " + r100 + " ,it will be report by sdk monitor");
        goto L23
    L7:
        r104 = "android";
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
