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
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class Header {
    public static int c = -1;
    public final JSONObject a;
    public long b;

    public Header() {
        this.b = -1;
        this.a = new JSONObject();
    }

    public static Header b(f r7, long r8, CrashType r10, int r11) {
        Header r6 = new Header();
        a.g(r6.a, r8);
        j.h(r6.a, "device_id", r7.d(MiraMonitor.VALUE_DEFAULT));
        j.h(r6.a, "user_id", Long.valueOf(r7.g()));
        j.h(r6.a, "channel", r7.b());
        j.h(r6.a, "mp_params", null);
        int r0 = CastIntegerProtector.parseInt(r7.a());     // Catch: Throwable -> L5
    L6:
        j.h(r6.a, "aid", Integer.valueOf(r0));
        c r1 = r7.h();
        String r2 = r1.d;
        if (r2 == null) goto L9;
        j.h(r6.a, "app_version", r2);
    L9:
        long r3 = r1.a;
        if (r3 == 0) goto L12;
        j.h(r6.a, "version_code", Long.valueOf(r3));
    L12:
        long r4 = r1.b;
        if (r4 == 0) goto L15;
        j.h(r6.a, "update_version_code", Long.valueOf(r4));
    L15:
        long r5 = r1.c;
        if (r5 == 0) goto L18;
        j.h(r6.a, "manifest_version_code", Long.valueOf(r5));
    L18:
        Map<String, Object> r9 = r7.c();
        if (r9 == null) goto L26;
        Iterator<String> r12 = r9.keySet().iterator();
    L22:
        if (r12.hasNext() == false) goto L26;
        String r13 = r12.next();
        if (r9.get(r13) == null) goto L22;
        j.h(r6.a, r13, r9.get(r13));
    L26:
        r6.d(r8, r10, r11, null);
        return r6;
    L5:
        r0 = 4444;
        goto L6
    }

    public static Header c(com.bytedance.crash.monitor.a r7, long r8, CrashType r10, int r11) {
        Header r6 = new Header();
        a.g(r6.a, r8);
        JSONObject r0 = r6.a;
        if (r0.has("device_id") == true) goto L6;
        j.h(r0, "device_id", r7.d(MiraMonitor.VALUE_DEFAULT));
    L6:
        if (r0.has("channel") == true) goto L25;
        j.h(r0, "channel", r7.l(r8));
    L25:
        int r1 = CastIntegerProtector.parseInt(r7.a());     // Catch: Throwable -> L10
    L11:
        j.h(r0, "aid", Integer.valueOf(r1));
        c r9 = r7.n(r8);
        String r2 = r9.d;
        if (r2 == null) goto L14;
        j.h(r0, "app_version", r2);
    L14:
        long r3 = r9.a;
        if (r3 == 0) goto L17;
        j.h(r0, "version_code", Long.valueOf(r3));
    L17:
        long r4 = r9.b;
        if (r4 == 0) goto L20;
        j.h(r0, "update_version_code", Long.valueOf(r4));
    L20:
        long r5 = r9.c;
        if (r5 == 0) goto L23;
        j.h(r0, "manifest_version_code", Long.valueOf(r5));
    L23:
        r6.d(r8, r10, r11, null);
        return r6;
    L10:
        r1 = 4444;
        goto L11
    }

    public final void d(long r4, CrashType r6, int r7, File r8) {
        JSONObject r0 = this.a;
        a r1 = a.a();
        if (r1 != null) goto L5;
    L16:
        JSONObject r2 = this.a;
        a r3 = a.a();
        if (r3 == null) goto L19;
        r3.c().putTo(r2);
    L19:
        this.b = a.d();
        j.h(this.a, "crash_type", r6.getName());
        j.h(this.a, "unique_key", "android_" + this.a.optString("device_id") + "_" + r4 + "_" + r7 + "_" + r6.getName());
        LocaleInfo.putTo(this.a, r8);
        return;
    L5:
        if (r1.d != null) goto L15;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r1.d != null) goto L10;
        r1.d = RomInfo.get(r1.a);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
    L15:
        r1.d.putTo(r0);
        goto L16
    }

    public static Header a(com.bytedance.crash.monitor.a r18, long r19, long r21, CrashType r23, int r24, File r25) {
        Header r6 = new Header();
        a.g(r6.a, r19);
        JSONObject r7 = r6.a;
        String r8 = r18.m.e(r21);
        if (TextUtils.isEmpty(r8) == false) goto L5;
        r8 = MiraMonitor.VALUE_DEFAULT;
    L5:
        j.h(r7, "device_id", r8);
        j.h(r6.a, "user_id", Long.valueOf(r18.m.g(r21)));
        j.h(r6.a, "channel", r18.l(r21));
        j.h(r6.a, "mp_params", null);
        int r9 = CastIntegerProtector.parseInt(r18.m.b(r21));     // Catch: Throwable -> L8
    L9:
        j.h(r6.a, "aid", Integer.valueOf(r9));
        JSONObject r10 = r6.a;
        String r11 = g.f(new PolarisFileWrapper(r25, "version.json"));
        if (r11 != null) goto L46;
    L13:
        boolean r12 = false;
    L15:
        if (r12 == true) goto L48;
        long r13 = r6.a.optLong("last_update_time");
        if (r13 > 0) goto L21;
    L29:
        c r0 = r18.n(r21);
        if (r0 != null) goto L32;
    L36:
        j.h(r6.a, "version_type", "app_info");
    L37:
        if (r25 == null) goto L41;
        JSONObject r1 = r6.a;
        String r2 = g.f(new PolarisFileWrapper(r25, "common_params.json"));
        if (r2 == null) goto L41;
        j.d(r1, new JSONObject(r2));     // Catch: Throwable -> L43
    L41:
        r6.d(r21, r23, r24, r25);
        return r6;
    L32:
        if (r0.a == 0) goto L36;
        String r3 = r0.d;
        if (r3 == null) goto L36;
        j.h(r6.a, "app_version", r3);
        j.h(r6.a, "update_version_code", Long.valueOf(r0.b));
        j.h(r6.a, "version_code", Long.valueOf(r0.a));
        j.h(r6.a, "manifest_version_code", Long.valueOf(r0.c));
        j.h(r6.a, "version_type", "crash_time");
        goto L37
    L21:
        if (r19 <= r13) goto L29;
        c r4 = r18.r(r13);
        if (r4 == null) goto L29;
        if (r4.a == 0) goto L29;
        String r5 = r4.d;
        if (r5 == null) goto L29;
        j.h(r6.a, "app_version", r5);
        j.h(r6.a, "update_version_code", Long.valueOf(r4.b));
        j.h(r6.a, "version_code", Long.valueOf(r4.a));
        j.h(r6.a, "manifest_version_code", Long.valueOf(r4.c));
        j.h(r6.a, "version_type", "last_update_time");
        goto L37
    L48:
        JSONObject r14 = r6.a;     // Catch: Throwable -> L44
        j.h(r14, "init_version_name", r14.opt("version_name"));     // Catch: Throwable -> L44
        JSONObject r15 = r6.a;     // Catch: Throwable -> L44
        j.h(r15, "init_update_version_code", r15.opt("update_version_code"));     // Catch: Throwable -> L44
    L17:
        j.h(r6.a, "version_type", "crash_dump");
        goto L37
    L46:
        JSONObject r16 = new JSONObject(r11);     // Catch: Throwable -> L45
        j.d(r10, r16);     // Catch: Throwable -> L45
        p.b(r16);     // Catch: Throwable -> L45
        r12 = true;
    L8:
        r9 = 4444;
        goto L9
    }
}
