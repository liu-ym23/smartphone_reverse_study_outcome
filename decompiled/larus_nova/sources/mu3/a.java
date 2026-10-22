package mu3;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import qu3.c;
import xu3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends pu3.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f515730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f515731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f515732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f515733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f515734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f515735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f515736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f515737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f515738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f515739k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f515740l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final double f515741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f515742n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f515743o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<Object, Object> f515744p;

    @Override // pu3.a
    public final String f() {
        return "memory";
    }

    @Override // nu3.c
    public final boolean isValid() {
        return true;
    }

    @Override // pu3.a
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L8
        r100.put("scene", ou3.a.a().e());     // Catch: Throwable -> L8
        r100.put("process_name", du3.a.e());     // Catch: Throwable -> L8
        if (this.f515734f == true) goto L5;
        boolean r101 = true;
    L6:
        r100.put("is_front", r101);     // Catch: Throwable -> L8
        r100.put(LocationMonitorConst.IS_MAIN_PROCESS, du3.a.o());     // Catch: Throwable -> L8
        return r100;
    L5:
        r101 = false;
    L8:
        return null;
    }

    @Override // pu3.a
    public final JSONObject d() {
        JSONObject r100 = new JSONObject();
        r100.put("gc_count", this.f515730b);     // Catch: JSONException -> L18
        r100.put("gc_time", this.f515731c);     // Catch: JSONException -> L18
        r100.put("block_gc_count", this.f515732d);     // Catch: JSONException -> L18
        r100.put("block_gc_time", this.f515733e);     // Catch: JSONException -> L18
        if (this.f515734f == false) goto L6;
        r100.put("dalvik_pss_background", this.f515738j);     // Catch: JSONException -> L18
        r100.put("native_pss_background", this.f515735g);     // Catch: JSONException -> L18
        r100.put("total_pss_background", this.f515736h);     // Catch: JSONException -> L18
        r100.put("java_heap_background", this.f515737i);     // Catch: JSONException -> L18
        r100.put("java_heap_background_used_rate", this.f515741m);     // Catch: JSONException -> L18
        r100.put("vm_size_background", this.f515740l);     // Catch: JSONException -> L18
        r100.put("graphics_background", this.f515739k);     // Catch: JSONException -> L18
    L8:
        if (this.f515742n == false) goto L24;
        r100.put("reach_top_java", 1);     // Catch: JSONException -> L18
    L24:
        Map<Object, Object> r101 = this.f515744p;     // Catch: Exception -> L21
        if (r101 == null) goto L20;
        Iterator<Map.Entry<Object, Object>> r102 = r101.entrySet().iterator();     // Catch: Exception -> L21
    L15:
        if (r102.hasNext() == false) goto L20;
        Map.Entry<Object, Object> r103 = r102.next();     // Catch: Exception -> L21
        r100.put((String) r103.getKey(), CastLongProtector.parseLong((String) r103.getValue()));     // Catch: Exception -> L21
    L20:
        return r100;
    L6:
        r100.put("dalvik_pss_foreground", this.f515738j);     // Catch: JSONException -> L18
        r100.put("native_pss_foreground", this.f515735g);     // Catch: JSONException -> L18
        r100.put("total_pss_foreground", this.f515736h);     // Catch: JSONException -> L18
        r100.put("java_heap_foreground", this.f515737i);     // Catch: JSONException -> L18
        r100.put("java_heap_foreground_used_rate", this.f515741m);     // Catch: JSONException -> L18
        r100.put("vm_size_foreground", this.f515740l);     // Catch: JSONException -> L18
        r100.put("graphics_foreground", this.f515739k);     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public final ju3.a g() {
        ju3.a r100 = new ju3.a();
        r100.f500468a = this.f515730b;
        r100.f500469b = this.f515731c;
        r100.f500470c = this.f515732d;
        r100.f500471d = this.f515733e;
        r100.f500472e = this.f515734f;
        r100.f500473f = this.f515735g;
        r100.f500474g = this.f515736h;
        r100.f500475h = this.f515737i;
        r100.f500476i = this.f515738j;
        r100.f500477j = this.f515739k;
        r100.f500478k = this.f515740l;
        r100.f500479l = this.f515742n;
        return r100;
    }

    public final String toString() {
        return "MemoryPerfMonitorable{gcCount=" + this.f515730b + ", gcTime=" + this.f515731c + ", blockingGcCount=" + this.f515732d + ", blockingGcTime=" + this.f515733e + ", background=" + this.f515734f + ", nativePss=" + this.f515735g + ", totalPss=" + this.f515736h + ", javaUsedMemory=" + this.f515737i + ", dalvikUsedSize=" + this.f515738j + ", graphics=" + this.f515739k + ", vmSize=" + this.f515740l + ", javaUsedMemoryRate=" + this.f515741m + ", isMemoryReachTop=" + this.f515742n + '}';
    }

    @Override // pu3.a
    public final JSONObject e() {
        JSONObject r100 = ou3.a.a().b();
        if (this.f515743o == true) goto L14;
    L6:
        ru3.a r101 = (ru3.a) c.a(ru3.a.class);
        if (r101 != null) goto L12;
    L9:
        return r100;
    L12:
        d.a(r100, r101.getDeviceInfo());     // Catch: Exception -> L11
        goto L9
    L14:
        d.a(r100, ou3.a.a().d());     // Catch: Exception -> L10
        goto L6
    }

    public a(long r100, long r101, long r102, long r110, boolean r111, long r112, long r113, long r114, long r115, long r210, long r211, double r212, boolean r213, boolean r214) {
        this.f515730b = r100;
        this.f515731c = r101;
        this.f515732d = r102;
        this.f515733e = r110;
        this.f515734f = r111;
        this.f515735g = r112;
        this.f515736h = r113;
        this.f515737i = r114;
        this.f515738j = r115;
        this.f515739k = r210;
        this.f515740l = r211;
        this.f515741m = r212;
        this.f515742n = r213;
        this.f515743o = r214;
    }
}
