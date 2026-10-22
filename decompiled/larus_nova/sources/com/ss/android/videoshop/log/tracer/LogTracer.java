package com.ss.android.videoshop.log.tracer;

import android.text.TextUtils;
import android.util.Pair;
import bjc.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tic.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LogTracer extends Enum<LogTracer> {
    public static final LogTracer INS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogTracer[] f455983a = null;
    private int maxTraceCount;
    private Map<a, LinkedList<b>> traceMap;

    static {
        LogTracer r100 = new LogTracer();
        INS = r100;
        f455983a = new LogTracer[]{r100};
    }

    public LogTracer() {
        super("INS", 0);
        this.traceMap = new HashMap();
        this.maxTraceCount = 100;
    }

    public static LogTracer[] values() {
        return (LogTracer[]) f455983a.clone();
    }

    public static LogTracer valueOf(String r100) {
        return (LogTracer) r27.a.a(LogTracer.class, r100);
    }

    public JSONObject getTracesJson(a r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
        Pair r102 = null;
    L15:
        if (r102 != null) goto L45;
    L20:
        List<b> r103 = removeTraceList(r100);
        if (r103 == null) goto L44;
        if (r103.isEmpty() == true) goto L44;
        JSONArray r104 = new JSONArray();
        Iterator<b> r105 = r103.iterator();     // Catch: JSONException -> L41
    L28:
        if (r105.hasNext() == false) goto L39;
        b r106 = r105.next();     // Catch: JSONException -> L41
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L41
        r107.put("pathId", r106.f19276a);     // Catch: JSONException -> L41
        r107.put("id", r106.f19277b);     // Catch: JSONException -> L41
        r107.put("timestamp", r106.f19278c);     // Catch: JSONException -> L41
        r107.put("level", r106.f19279d);     // Catch: JSONException -> L41
        r107.put("errCode", 0);     // Catch: JSONException -> L41
        Map<String, String> r108 = r106.f19280e;     // Catch: JSONException -> L41
        if (r108 == null) goto L38;
        HashMap r109 = (HashMap) r108;     // Catch: JSONException -> L41
        if (r109.isEmpty() == true) goto L38;
        JSONArray r110 = new JSONArray();     // Catch: JSONException -> L41
        Iterator r111 = r109.entrySet().iterator();     // Catch: JSONException -> L41
    L35:
        if (r111.hasNext() == false) goto L37;
        Map.Entry r112 = (Map.Entry) r111.next();     // Catch: JSONException -> L41
        JSONObject r113 = new JSONObject();     // Catch: JSONException -> L41
        r113.put((String) r112.getKey(), r112.getValue());     // Catch: JSONException -> L41
        r110.put(r113);     // Catch: JSONException -> L41
        goto L35
    L37:
        r107.put("data", r110);     // Catch: JSONException -> L41
    L38:
        r104.put(r107);     // Catch: JSONException -> L41
        goto L28
    L39:
        r101.put("traces", r104);     // Catch: JSONException -> L41
        return r101;
    L41:
        e = move-exception;
        e.printStackTrace();
        return r101;
    L44:
        return null;
    L45:
        r101.put((String) r102.first, r102.second);     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L5:
        if (r100.f546366d == null) goto L8;
        r102 = new Pair("video_model", r100.f546363a);
        goto L15
    L8:
        if (TextUtils.isEmpty(r100.f546368f) == true) goto L11;
        r102 = new Pair("local_url", r100.f546368f);
        goto L15
    L11:
        if (TextUtils.isEmpty(r100.f546367e) == true) goto L13;
        r102 = new Pair("video_url", r100.f546367e);
        goto L15
    L13:
        r102 = new Pair("vid", r100.f546363a);
        goto L15
    }

    public List<b> removeTraceList(a r100) {
        LinkedList<b> r101 = this.traceMap.remove(r100);
        if (r101 == null) goto L5;
        StringBuilder r102 = new StringBuilder("removeTraceList title:null map.size:");
        r100.getClass();
        r102.append(this.traceMap.size());
        ajc.b.a("LogTracer", r102.toString());
    L5:
        return r101;
    }

    public void setMaxTraceCount(int r100) {
        this.maxTraceCount = r100;
    }

    public void addTrace(a r100, b r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L16;
        LinkedList<b> r102 = this.traceMap.get(r100);
        if (r102 != null) goto L9;
        LinkedList<b> r103 = new LinkedList();
        this.traceMap.put(r100, r103);
        r103.add(r101);
        ajc.b.a("LogTracer", "addTrace title:null trace:" + r101.f19277b + " map.size:" + this.traceMap.size());
        return;
    L9:
        if (this.maxTraceCount >= r102.size()) goto L11;
        r102.removeFirst();
        r102.add(r101);
        return;
    L11:
        r102.add(r101);
        return;
    L16:
        return;
    }
}
