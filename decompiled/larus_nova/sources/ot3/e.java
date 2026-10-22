package ot3;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f526668a = -1;

    public static long a() {
        if (f526668a != (-1)) goto L6;
        long r100 = du3.a.k();
        f526668a = (r100 << 16) | ((long) Process.myPid());
    L6:
        return f526668a;
    }

    public static JSONObject b(a r100) {
        if (r100 != null) goto L31;
        return null;
    L31:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L30
        JSONObject r102 = r100.f526659z;     // Catch: Exception -> L30
        if (r102 == null) goto L8;
        r101 = xu3.d.a(r101, r102);     // Catch: Exception -> L30
    L8:
        JSONObject r103 = r100.f526658y;     // Catch: Exception -> L30
        if (r103 == null) goto L11;
        r101 = xu3.d.a(r101, r103);     // Catch: Exception -> L30
    L11:
        r101.put("version_code", r100.f526640g);     // Catch: Exception -> L30
        r101.put("version_name", r100.f526641h);     // Catch: Exception -> L30
        r101.put("manifest_version_code", r100.f526639f);     // Catch: Exception -> L30
        r101.put("update_version_code", r100.f526637d);     // Catch: Exception -> L30
        r101.put("app_version", r100.f526638e);     // Catch: Exception -> L30
        r101.put("os", r100.f526643j);     // Catch: Exception -> L30
        r101.put("device_platform", r100.f526644k);     // Catch: Exception -> L30
        r101.put("os_version", r100.f526645l);     // Catch: Exception -> L30
        r101.put("os_api", r100.f526646m);     // Catch: Exception -> L30
        r101.put("device_model", r100.f526647n);     // Catch: Exception -> L30
        r101.put("device_brand", r100.f526648o);     // Catch: Exception -> L30
        r101.put("device_manufacturer", r100.f526649p);     // Catch: Exception -> L30
        r101.put("process_name", r100.f526650q);     // Catch: Exception -> L30
        r101.put(WsConstants.KEY_SESSION_ID, r100.f526651r);     // Catch: Exception -> L30
        r101.put("rom_version", r100.f526652s);     // Catch: Exception -> L30
        r101.put("package", r100.f526653t);     // Catch: Exception -> L30
        r101.put(MonitorConstants.EXTRA_MONITOR_VERSION, r100.f526654u);     // Catch: Exception -> L30
        r101.put("channel", r100.f526636c);     // Catch: Exception -> L30
        r101.put("aid", r100.f526634a);     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r100.f526635b) == true) goto L14;
        r101.put("device_id", r100.f526635b);     // Catch: Exception -> L30
    L14:
        r101.put("uid", r100.f526655v);     // Catch: Exception -> L30
        r101.put("phone_startup_time", r100.f526656w);     // Catch: Exception -> L30
        r101.put("release_build", r100.f526642i);     // Catch: Exception -> L30
        long r104 = r100.C;     // Catch: Exception -> L30
        if (r104 == (-1)) goto L18;
        r101.put("config_time", String.valueOf(r104));     // Catch: Exception -> L30
    L18:
        if (TextUtils.isEmpty(r100.f526657x) == true) goto L20;
        r101.put("verify_info", r100.f526657x);     // Catch: Exception -> L30
    L20:
        r101.put("current_update_version_code", r100.B);     // Catch: Exception -> L30
        long r105 = r100.D;     // Catch: Exception -> L30
        if (r105 == (-1)) goto L23;
        r101.put("ntp_time", r105);     // Catch: Exception -> L30
    L23:
        long r106 = r100.E;     // Catch: Exception -> L30
        if (r106 == (-1)) goto L26;
        r101.put("ntp_offset", r106);     // Catch: Exception -> L30
    L26:
        JSONObject r107 = r100.A;     // Catch: Exception -> L30
        if (r107 == null) goto L29;
        r101.put("filters", r107);     // Catch: Exception -> L30
    L29:
        return r101;
    L30:
        return null;
    }
}
