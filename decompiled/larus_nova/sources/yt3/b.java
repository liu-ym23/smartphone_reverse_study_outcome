package yt3;

import androidx.camera.video.AudioStats;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xu3.d;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends pu3.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f569051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f569052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f569053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f569054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f569055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f569056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f569057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final double f569058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONArray f569059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JSONArray f569060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONArray f569061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONArray f569062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f569063n;

    @Override // pu3.a
    public final String f() {
        return UploadTypeInf.DISK;
    }

    @Override // nu3.c
    public final boolean isValid() {
        return true;
    }

    @Override // pu3.a
    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        JSONArray r101 = this.f569059j;     // Catch: Exception -> L38
        if (r101 == null) goto L6;
        r100.put("top_usage", r101);     // Catch: Exception -> L38
    L6:
        JSONArray r102 = this.f569060k;     // Catch: Exception -> L38
        if (r102 == null) goto L9;
        r100.put("exception_folders", r102);     // Catch: Exception -> L38
    L9:
        JSONArray r103 = this.f569061l;     // Catch: Exception -> L38
        if (r103 == null) goto L13;
        r100.put("outdated_files", r103);     // Catch: Exception -> L38
    L13:
        if (this.f569062m == null) goto L36;
        int r104 = 0;
        int r105 = r100.toString().getBytes("UTF-8").length;     // Catch: Exception -> L17
    L19:
        this.f569063n = (262144 - r105) - 12288;     // Catch: Exception -> L38
        JSONArray r106 = this.f569062m;     // Catch: Exception -> L38
        if (r106 != null) goto L23;
        JSONArray r107 = new JSONArray();     // Catch: Exception -> L38
    L35:
        this.f569062m = r107;     // Catch: Exception -> L38
        r100.put("disk_info", r107);     // Catch: Exception -> L38
        goto L36
    L23:
        int r108 = 102400;
    L43:
        long r109 = r106.toString().getBytes("UTF-8").length;     // Catch: Exception -> L26
    L29:
        if (r109 <= this.f569063n) goto L34;
        if (r104 > 10) goto L34;
        r106 = g(r106, r108);     // Catch: JSONException -> L37 Exception -> L38
    L33:
        r108 = r108 * 2;
        r104 = r104 + 1;
    L34:
        r107 = r106;
    L26:
        r109 = 0;
    L17:
        r105 = 0;
    L36:
        return r100;
    }

    @Override // pu3.a
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
        r100.put("scene", ou3.a.a().e());     // Catch: Throwable -> L4
        r100.put("process_name", du3.a.e());     // Catch: Throwable -> L4
        r100.put("is_front", false);     // Catch: Throwable -> L4
        r100.put(LocationMonitorConst.IS_MAIN_PROCESS, du3.a.o());     // Catch: Throwable -> L4
        return r100;
    L4:
        return null;
    }

    @Override // pu3.a
    public final JSONObject d() {
        JSONObject r100 = new JSONObject();
        long r101 = this.f569051b;     // Catch: Exception -> L28
        if (r101 <= 0) goto L6;
        r100.put("data", r101);     // Catch: Exception -> L28
    L6:
        long r102 = this.f569052c;     // Catch: Exception -> L28
        if (r102 <= 0) goto L9;
        r100.put("cache", r102);     // Catch: Exception -> L28
    L9:
        long r103 = this.f569053d;     // Catch: Exception -> L28
        if (r103 <= 0) goto L12;
        r100.put("total", r103);     // Catch: Exception -> L28
    L12:
        long r104 = this.f569054e;     // Catch: Exception -> L28
        if (r104 <= 0) goto L15;
        r100.put("rom_free", r104);     // Catch: Exception -> L28
    L15:
        long r105 = this.f569055f;     // Catch: Exception -> L28
        if (r105 <= 0) goto L18;
        r100.put("app_usage", r105);     // Catch: Exception -> L28
    L18:
        long r106 = this.f569056g;     // Catch: Exception -> L28
        if (r106 <= 0) goto L21;
        r100.put("total_capacity", r106);     // Catch: Exception -> L28
    L21:
        long r107 = this.f569057h;     // Catch: Exception -> L28
        if (r107 <= 0) goto L24;
        r100.put("free_capacity", r107);     // Catch: Exception -> L28
    L24:
        double r108 = this.f569058i;     // Catch: Exception -> L28
        if (r108 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L27;
        r100.put("app_occupied_rate", r108);     // Catch: Exception -> L28
    L27:
        return r100;
    }

    @Override // pu3.a
    public final JSONObject e() {
        JSONObject r100 = ou3.a.a().b();
        d.a(r100, ou3.a.a().d());     // Catch: Exception -> L5
    L4:
        return r100;
    }

    public static JSONArray g(JSONArray r100, int r101) throws JSONException {
        JSONArray r102 = new JSONArray();
        int r103 = 0;
    L4:
        if (r103 >= r100.length()) goto L16;
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r100, r103);
        if (JSONObjectProtectorUtils.getLong(r104, "size") < r101) goto L15;
        JSONArray r105 = r104.optJSONArray("next_disk");
        if (r105 == null) goto L14;
        JSONArray r106 = g(r105, r101);
        if (r106.length() <= 0) goto L13;
        r104.put("next_disk", r106);
        goto L14
    L13:
        r104.remove("next_disk");
    L14:
        r102.put(r104);
    L15:
        r103 = r103 + 1;
        goto L4
    L16:
        return r102;
    }

    public b(long r100, long r101, long r102, long r110, long r111, long r112, long r113, double r114, JSONArray r210, JSONArray r211, JSONArray r212, JSONArray r213) {
        this.f569063n = 262144;
        this.f569051b = r100;
        this.f569052c = r101;
        this.f569053d = r102;
        this.f569054e = r110;
        this.f569055f = r111;
        this.f569056g = r112;
        this.f569057h = r113;
        this.f569058i = r114;
        this.f569059j = r210;
        this.f569060k = r211;
        this.f569061l = r212;
        this.f569062m = r213;
    }
}
