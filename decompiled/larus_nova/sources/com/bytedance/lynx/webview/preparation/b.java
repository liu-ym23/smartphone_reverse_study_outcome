package com.bytedance.lynx.webview.preparation;

import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<PrepareInfoNG.PreparePhase, PrepareInfoNG.PreparePhase> f265415l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PrepareInfoNG f265416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f265417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f265418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PrepareInfoNG.PreparePhase f265419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PrepareInfoNG.PreparePhase f265420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f265421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f265422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<PrepareInfoNG.PreparePhase, Long> f265423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<PrepareInfoNG.PreparePhase, Long> f265424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f265425j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f265426k;

    static {
        HashMap r100 = new HashMap();
        f265415l = r100;
        PrepareInfoNG.PreparePhase r101 = PrepareInfoNG.PreparePhase.NOT_STARTED;
        PrepareInfoNG.PreparePhase r102 = PrepareInfoNG.PreparePhase.DOWNLOADED;
        r100.put(r101, r102);
        PrepareInfoNG.PreparePhase r103 = PrepareInfoNG.PreparePhase.DECOMPRESSED;
        r100.put(r102, r103);
        r100.put(r103, PrepareInfoNG.PreparePhase.COMPILED);
    }

    public b(PrepareInfoNG r100) {
        this.f265423h = new HashMap();
        this.f265424i = new HashMap();
        this.f265421f = System.currentTimeMillis();
        this.f265417b = r100.f475074a;
        this.f265418c = r100.f475075b;
        PrepareInfoNG.PreparePhase r101 = r100.f();
        this.f265419d = r101;
        this.f265420e = r101;
        this.f265425j = false;
        this.f265416a = r100;
    }

    public final long a(PrepareInfoNG.PreparePhase r100) {
        Long r101 = (Long) ((HashMap) this.f265423h).get(r100);
        Long r102 = (Long) ((HashMap) this.f265424i).get(r100);
        if (r101 == null) goto L7;
        if (r102 != null) goto L6;
        return -1;
    L6:
        return r102.longValue() - r101.longValue();
    L7:
        return -1;
    }

    public final void b(boolean r100) {
        this.f265425j = r100;
        this.f265422g = System.currentTimeMillis();
        JSONObject r101 = new JSONObject();
        HashMap r102 = new HashMap();
        r101.put("upto_so", this.f265417b);     // Catch: JSONException -> L12
        r101.put("core_md5", this.f265418c);     // Catch: JSONException -> L12
        r101.put("target_phase", this.f265416a.f265401i.name());     // Catch: JSONException -> L12
        r101.put("delay_millis", this.f265416a.f265397e);     // Catch: JSONException -> L12
        r101.put("without_post", this.f265416a.f265398f);     // Catch: JSONException -> L12
        r101.put("is_active", this.f265416a.f265399g);     // Catch: JSONException -> L12
        r101.put("escaped", this.f265416a.f265400h);     // Catch: JSONException -> L12
        r101.put("retry_count", this.f265416a.f265402j);     // Catch: JSONException -> L12
        r101.put("start_phase", this.f265419d.name());     // Catch: JSONException -> L12
        r101.put("reached_phase", this.f265420e.name());     // Catch: JSONException -> L12
        r101.put("is_completed", this.f265425j);     // Catch: JSONException -> L12
        long r103 = this.f265422g;     // Catch: JSONException -> L12
        if (r103 > 0) goto L7;
        r103 = System.currentTimeMillis();     // Catch: JSONException -> L12
    L7:
        r101.put("total_duration", r103 - this.f265421f);     // Catch: JSONException -> L12
        r101.put("download_duration", a(PrepareInfoNG.PreparePhase.DOWNLOADED));     // Catch: JSONException -> L12
        r101.put("decompress_duration", a(PrepareInfoNG.PreparePhase.DECOMPRESSED));     // Catch: JSONException -> L12
        r101.put("compile_duration", a(PrepareInfoNG.PreparePhase.COMPILED));     // Catch: JSONException -> L12
        r101.put("error", this.f265416a.f265403k);     // Catch: JSONException -> L12
        r101.put("has_changed_last_modified", this.f265426k);     // Catch: JSONException -> L12
        Iterator<String> r104 = r101.keys();     // Catch: JSONException -> L12
    L8:
        if (r104.hasNext() == false) goto L14;
        String r105 = r104.next();     // Catch: JSONException -> L12
        r102.put(r105, r101.get(r105));     // Catch: JSONException -> L12
    L14:
        r.a("[PrepareNG] Tracker data: " + r102);
        EventStatistics.d("ttweb_prepare_pv", r102, new HashMap());
        return;
    L12:
        e = move-exception;
        r.c("[PrepareNG] Error generating performance data. Error: ", e);
        goto L14
    }
}
