package com.bytedance.crash.entity;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.general.a;
import com.bytedance.crash.monitor.c;
import com.bytedance.crash.monitor.f;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Header {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f203194c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f203195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f203196b;

    public Header() {
        this.f203196b = -1;
        this.f203195a = new JSONObject();
    }

    public static Header b(f r100, long r101, CrashType r110, int r111) {
        Header r102 = new Header();
        a.g(r102.f203195a, r101);
        j.h(r102.f203195a, "device_id", r100.d("0"));
        j.h(r102.f203195a, "user_id", Long.valueOf(r100.g()));
        j.h(r102.f203195a, "channel", r100.b());
        j.h(r102.f203195a, "mp_params", null);
        int r103 = CastIntegerProtector.parseInt(r100.a());     // Catch: Throwable -> L5
    L6:
        j.h(r102.f203195a, "aid", Integer.valueOf(r103));
        c r104 = r100.h();
        String r105 = r104.f203273d;
        if (r105 == null) goto L9;
        j.h(r102.f203195a, "app_version", r105);
    L9:
        long r106 = r104.f203270a;
        if (r106 == 0) goto L12;
        j.h(r102.f203195a, "version_code", Long.valueOf(r106));
    L12:
        long r107 = r104.f203271b;
        if (r107 == 0) goto L15;
        j.h(r102.f203195a, "update_version_code", Long.valueOf(r107));
    L15:
        long r108 = r104.f203272c;
        if (r108 == 0) goto L18;
        j.h(r102.f203195a, "manifest_version_code", Long.valueOf(r108));
    L18:
        Map<String, Object> r109 = r100.c();
        if (r109 == null) goto L26;
        Iterator<String> r112 = r109.keySet().iterator();
    L22:
        if (r112.hasNext() == false) goto L26;
        String r113 = r112.next();
        if (r109.get(r113) == null) goto L22;
        j.h(r102.f203195a, r113, r109.get(r113));
    L26:
        r102.d(r101, r110, r111, null);
        return r102;
    L5:
        r103 = 4444;
        goto L6
    }

    public static Header c(com.bytedance.crash.monitor.a r100, long r101, CrashType r110, int r111) {
        Header r102 = new Header();
        a.g(r102.f203195a, r101);
        JSONObject r103 = r102.f203195a;
        if (r103.has("device_id") == true) goto L6;
        j.h(r103, "device_id", r100.d("0"));
    L6:
        if (r103.has("channel") == true) goto L25;
        j.h(r103, "channel", r100.l(r101));
    L25:
        int r104 = CastIntegerProtector.parseInt(r100.a());     // Catch: Throwable -> L10
    L11:
        j.h(r103, "aid", Integer.valueOf(r104));
        c r105 = r100.n(r101);
        String r106 = r105.f203273d;
        if (r106 == null) goto L14;
        j.h(r103, "app_version", r106);
    L14:
        long r107 = r105.f203270a;
        if (r107 == 0) goto L17;
        j.h(r103, "version_code", Long.valueOf(r107));
    L17:
        long r108 = r105.f203271b;
        if (r108 == 0) goto L20;
        j.h(r103, "update_version_code", Long.valueOf(r108));
    L20:
        long r109 = r105.f203272c;
        if (r109 == 0) goto L23;
        j.h(r103, "manifest_version_code", Long.valueOf(r109));
    L23:
        r102.d(r101, r110, r111, null);
        return r102;
    L10:
        r104 = 4444;
        goto L11
    }

    public final void d(long r100, CrashType r101, int r102, File r103) {
        JSONObject r104 = this.f203195a;
        a r105 = a.a();
        if (r105 != null) goto L5;
    L16:
        JSONObject r106 = this.f203195a;
        a r107 = a.a();
        if (r107 == null) goto L19;
        r107.c().putTo(r106);
    L19:
        this.f203196b = a.d();
        j.h(this.f203195a, "crash_type", r101.getName());
        j.h(this.f203195a, "unique_key", PerfLog.EVENT_PRE + this.f203195a.optString("device_id") + "_" + r100 + "_" + r102 + "_" + r101.getName());
        LocaleInfo.putTo(this.f203195a, r103);
        return;
    L5:
        if (r105.f203204d != null) goto L15;
        monitor-enter(r105);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r105.f203204d != null) goto L10;
        r105.f203204d = RomInfo.get(r105.f203201a);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r105);     // Catch: Throwable -> L12
    L15:
        r105.f203204d.putTo(r104);
        goto L16
    }

    public static Header a(com.bytedance.crash.monitor.a r110, long r111, long r210, CrashType r211, int r212, File r213) {
        Header r100 = new Header();
        a.g(r100.f203195a, r111);
        JSONObject r101 = r100.f203195a;
        String r102 = r110.f203275m.e(r210);
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = "0";
    L5:
        j.h(r101, "device_id", r102);
        j.h(r100.f203195a, "user_id", Long.valueOf(r110.f203275m.g(r210)));
        j.h(r100.f203195a, "channel", r110.l(r210));
        j.h(r100.f203195a, "mp_params", null);
        int r103 = CastIntegerProtector.parseInt(r110.f203275m.b(r210));     // Catch: Throwable -> L8
    L9:
        j.h(r100.f203195a, "aid", Integer.valueOf(r103));
        JSONObject r104 = r100.f203195a;
        String r105 = g.f(new PolarisFileWrapper(r213, "version.json"));
        if (r105 != null) goto L46;
    L13:
        boolean r106 = false;
    L15:
        if (r106 == true) goto L48;
        long r112 = r100.f203195a.optLong("last_update_time");
        if (r112 > 0) goto L21;
    L29:
        c r107 = r110.n(r210);
        if (r107 != null) goto L32;
    L36:
        j.h(r100.f203195a, "version_type", "app_info");
    L37:
        if (r213 == null) goto L41;
        JSONObject r108 = r100.f203195a;
        String r109 = g.f(new PolarisFileWrapper(r213, "common_params.json"));
        if (r109 == null) goto L41;
        j.d(r108, new JSONObject(r109));     // Catch: Throwable -> L43
    L41:
        r100.d(r210, r211, r212, r213);
        return r100;
    L32:
        if (r107.f203270a == 0) goto L36;
        String r113 = r107.f203273d;
        if (r113 == null) goto L36;
        j.h(r100.f203195a, "app_version", r113);
        j.h(r100.f203195a, "update_version_code", Long.valueOf(r107.f203271b));
        j.h(r100.f203195a, "version_code", Long.valueOf(r107.f203270a));
        j.h(r100.f203195a, "manifest_version_code", Long.valueOf(r107.f203272c));
        j.h(r100.f203195a, "version_type", "crash_time");
        goto L37
    L21:
        if (r111 <= r112) goto L29;
        c r114 = r110.r(r112);
        if (r114 == null) goto L29;
        if (r114.f203270a == 0) goto L29;
        String r115 = r114.f203273d;
        if (r115 == null) goto L29;
        j.h(r100.f203195a, "app_version", r115);
        j.h(r100.f203195a, "update_version_code", Long.valueOf(r114.f203271b));
        j.h(r100.f203195a, "version_code", Long.valueOf(r114.f203270a));
        j.h(r100.f203195a, "manifest_version_code", Long.valueOf(r114.f203272c));
        j.h(r100.f203195a, "version_type", "last_update_time");
        goto L37
    L48:
        JSONObject r116 = r100.f203195a;     // Catch: Throwable -> L44
        j.h(r116, "init_version_name", r116.opt("version_name"));     // Catch: Throwable -> L44
        JSONObject r117 = r100.f203195a;     // Catch: Throwable -> L44
        j.h(r117, "init_update_version_code", r117.opt("update_version_code"));     // Catch: Throwable -> L44
    L17:
        j.h(r100.f203195a, "version_type", "crash_dump");
        goto L37
    L46:
        JSONObject r118 = new JSONObject(r105);     // Catch: Throwable -> L45
        j.d(r104, r118);     // Catch: Throwable -> L45
        p.b(r118);     // Catch: Throwable -> L45
        r106 = true;
    L8:
        r103 = 4444;
        goto L9
    }
}
