package yt3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pu3.a;
import xu3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends a {
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final double i;
    public final JSONArray j;
    public final JSONArray k;
    public final JSONArray l;
    public JSONArray m;
    public int n;

    public final String f() {
        return UploadTypeInf.DISK;
    }

    public final boolean isValid() {
        return true;
    }

    public final JSONObject b() {
        JSONObject r1 = new JSONObject();
        JSONArray r2 = this.j;     // Catch: Exception -> L38
        if (r2 == null) goto L6;
        r1.put("top_usage", r2);     // Catch: Exception -> L38
    L6:
        JSONArray r3 = this.k;     // Catch: Exception -> L38
        if (r3 == null) goto L9;
        r1.put("exception_folders", r3);     // Catch: Exception -> L38
    L9:
        JSONArray r4 = this.l;     // Catch: Exception -> L38
        if (r4 == null) goto L13;
        r1.put("outdated_files", r4);     // Catch: Exception -> L38
    L13:
        if (this.m == null) goto L36;
        int r5 = 0;
        int r6 = r1.toString().getBytes("UTF-8").length;     // Catch: Exception -> L17
    L19:
        this.n = (262144 - r6) - 12288;     // Catch: Exception -> L38
        JSONArray r7 = this.m;     // Catch: Exception -> L38
        if (r7 != null) goto L23;
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L38
    L35:
        this.m = r0;     // Catch: Exception -> L38
        r1.put("disk_info", r0);     // Catch: Exception -> L38
        goto L36
    L23:
        int r8 = 102400;
    L43:
        long r9 = r7.toString().getBytes("UTF-8").length;     // Catch: Exception -> L26
    L29:
        if (r9 <= this.n) goto L34;
        if (r5 > 10) goto L34;
        r7 = g(r7, r8);     // Catch: JSONException -> L37 Exception -> L38
    L33:
        r8 = r8 * 2;
        r5 = r5 + 1;
    L34:
        r0 = r7;
    L26:
        r9 = 0;
    L17:
        r6 = 0;
    L36:
        return r1;
    }

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("scene", ou3.a.a().e());     // Catch: Throwable -> L4
        r0.put("process_name", du3.a.e());     // Catch: Throwable -> L4
        r0.put("is_front", false);     // Catch: Throwable -> L4
        r0.put("is_main_process", du3.a.o());     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    public final JSONObject d() {
        JSONObject r0 = new JSONObject();
        long r1 = this.b;     // Catch: Exception -> L28
        if (r1 <= 0) goto L6;
        r0.put("data", r1);     // Catch: Exception -> L28
    L6:
        long r2 = this.c;     // Catch: Exception -> L28
        if (r2 <= 0) goto L9;
        r0.put("cache", r2);     // Catch: Exception -> L28
    L9:
        long r3 = this.d;     // Catch: Exception -> L28
        if (r3 <= 0) goto L12;
        r0.put("total", r3);     // Catch: Exception -> L28
    L12:
        long r4 = this.e;     // Catch: Exception -> L28
        if (r4 <= 0) goto L15;
        r0.put("rom_free", r4);     // Catch: Exception -> L28
    L15:
        long r5 = this.f;     // Catch: Exception -> L28
        if (r5 <= 0) goto L18;
        r0.put("app_usage", r5);     // Catch: Exception -> L28
    L18:
        long r6 = this.g;     // Catch: Exception -> L28
        if (r6 <= 0) goto L21;
        r0.put("total_capacity", r6);     // Catch: Exception -> L28
    L21:
        long r7 = this.h;     // Catch: Exception -> L28
        if (r7 <= 0) goto L24;
        r0.put("free_capacity", r7);     // Catch: Exception -> L28
    L24:
        double r8 = this.i;     // Catch: Exception -> L28
        if (r8 <= 0.0d) goto L27;
        r0.put("app_occupied_rate", r8);     // Catch: Exception -> L28
    L27:
        return r0;
    }

    public final JSONObject e() {
        JSONObject r0 = ou3.a.a().b();
        d.a(r0, ou3.a.a().d());     // Catch: Exception -> L5
    L4:
        return r0;
    }

    public static JSONArray g(JSONArray r8, int r9) throws JSONException {
        JSONArray r0 = new JSONArray();
        int r1 = 0;
    L4:
        if (r1 >= r8.length()) goto L16;
        JSONObject r2 = JSONArrayProtectorUtils.getJSONObject(r8, r1);
        if (JSONObjectProtectorUtils.getLong(r2, "size") < r9) goto L15;
        JSONArray r4 = r2.optJSONArray("next_disk");
        if (r4 == null) goto L14;
        JSONArray r5 = g(r4, r9);
        if (r5.length() <= 0) goto L13;
        r2.put("next_disk", r5);
        goto L14
    L13:
        r2.remove("next_disk");
    L14:
        r0.put(r2);
    L15:
        r1 = r1 + 1;
        goto L4
    L16:
        return r0;
    }

    public b(long r4, long r6, long r8, long r10, long r12, long r14, long r16, double r18, JSONArray r20, JSONArray r21, JSONArray r22, JSONArray r23) {
        this.n = 262144;
        this.b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r10;
        this.f = r12;
        this.g = r14;
        this.h = r16;
        this.i = r18;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r23;
    }
}
