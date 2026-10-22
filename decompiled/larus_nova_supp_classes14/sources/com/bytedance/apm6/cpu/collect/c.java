package com.bytedance.apm6.cpu.collect;

import com.bytedance.apm.util.n;
import com.bytedance.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends pu3.a {
    public final CpuCacheItem.CpuDataType b;
    public final aq7.c.a c;
    public final String d;
    public final double e;
    public final double f;
    public final double g;
    public final double h;
    public float i;
    public boolean j;
    public boolean k;
    public final List<n<String, Double>> l;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CpuCacheItem.CpuDataType.values().length];
            a = r0;
            r0[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final boolean isValid() {
        return true;
    }

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L14
        r0.put("process_name", com.bytedance.apm.d.c());     // Catch: Throwable -> L14
        r0.put("is_main_process", com.bytedance.apm.d.k());     // Catch: Throwable -> L14
        r0.put("scene", this.d);     // Catch: Throwable -> L14
        int r1 = a.a[this.b.ordinal()];     // Catch: Throwable -> L14
        if (r1 != 1) goto L6;
        r0.put("data_type", "mix");     // Catch: Throwable -> L14
    L13:
        return r0;
    L6:
        if (r1 != 2) goto L8;
        r0.put("data_type", "back");     // Catch: Throwable -> L14
        goto L13
    L8:
        if (r1 != 3) goto L13;
        r0.put("data_type", "front");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.getLocalizedMessage();
        return null;
    }

    public final JSONObject d() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L35
        List<n<String, Double>> r1 = this.l;     // Catch: Throwable -> L35
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L24;
        Iterator r3 = ((ArrayList) this.l).iterator();     // Catch: Throwable -> L35
    L11:
        if (r3.hasNext() == false) goto L34;
        n r4 = (n) r3.next();     // Catch: Throwable -> L35
        if (r4 == null) goto L11;
        Object r5 = r4.a;     // Catch: Throwable -> L35
        if (r5 == null) goto L11;
        if (((String) r5).isEmpty() == true) goto L11;
        Object r6 = r4.b;     // Catch: Throwable -> L35
        if (r6 == null) goto L11;
        if (((Double) r6).doubleValue() == 0.0d) goto L11;
        r0.put((String) r4.a, r4.b);     // Catch: Throwable -> L35
    L34:
        return r0;
    L24:
        double r7 = this.e;     // Catch: Throwable -> L35
        if (r7 > (-1.0d)) goto L27;
    L29:
        double r8 = this.g;     // Catch: Throwable -> L35
        if (r8 <= (-1.0d)) goto L34;
        if (this.h <= (-1.0d)) goto L34;
        r0.put("app_stat_speed", r8);     // Catch: Throwable -> L35
        r0.put("app_max_stat_speed", this.h);     // Catch: Throwable -> L35
        goto L34
    L27:
        if (this.f <= (-1.0d)) goto L29;
        r0.put("app_usage_rate", r7);     // Catch: Throwable -> L35
        r0.put("app_max_usage_rate", this.f);     // Catch: Throwable -> L35
        goto L29
    L5:
        if (((ArrayList) r1).isEmpty() == true) goto L7;
        r2 = true;
    L35:
        th = move-exception;
        th.getLocalizedMessage();
        return null;
    }

    public final String f() {
        List<n<String, Double>> r0 = this.l;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return "cpu_thread";
    L11:
        return "cpu";
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L7;
        r1 = true;
        goto L8
    }

    public final JSONObject e() {
        JSONObject r0 = ou3.a.a().b();     // Catch: Throwable -> L9
        r0.put("is_auto_sample", this.j);     // Catch: Throwable -> L9
        if (this.c == null) goto L5;
        r0.put("network_type", NetworkUtils.getNetworkTypeFast(com.bytedance.apm.d.getContext()));     // Catch: Throwable -> L9
        r0.put("battery_level", this.c.c);     // Catch: Throwable -> L9
        r0.put("cpu_hardware", this.c.a);     // Catch: Throwable -> L9
        r0.put("is_charging", this.c.b);     // Catch: Throwable -> L9
        r0.put("power_save_mode", this.c.e);     // Catch: Throwable -> L9
        r0.put("thermal_status", this.c.d);     // Catch: Throwable -> L9
        r0.put("battery_thermal", this.c.f);     // Catch: Throwable -> L9
        r0.put("is_normal_sample_state", this.k);     // Catch: Throwable -> L9
    L5:
        float r1 = this.i;     // Catch: Throwable -> L9
        if (r1 <= 0.0f) goto L8;
        r0.put("battery_current", r1);     // Catch: Throwable -> L9
    L8:
        return r0;
    L9:
        th = move-exception;
        th.getLocalizedMessage();
        return null;
    }

    public c(CpuCacheItem.CpuDataType r3, String r4, List<n<String, Double>> r5, aq7.c.a r6) {
        this.e = -1.0d;
        this.f = -1.0d;
        this.g = -1.0d;
        this.h = -1.0d;
        this.i = -1.0f;
        this.j = true;
        this.k = true;
        this.l = new ArrayList(r5);
        this.b = r3;
        this.d = r4;
        this.c = r6;
    }

    public c(CpuCacheItem.CpuDataType r3, String r4, double r5, double r7, double r9, double r11, aq7.c.a r13) {
        this.e = -1.0d;
        this.f = -1.0d;
        this.g = -1.0d;
        this.h = -1.0d;
        this.i = -1.0f;
        this.j = true;
        this.k = true;
        this.b = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r9;
        this.h = r11;
        this.c = r13;
    }
}
