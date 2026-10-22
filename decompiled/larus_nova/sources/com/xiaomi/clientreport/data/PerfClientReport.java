package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.logger.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class PerfClientReport extends a {
    private static final long DEFAULT_VALUE = -1;
    public int code;
    public long perfCounts;
    public long perfLatencies;

    @Override // com.xiaomi.clientreport.data.a
    public JSONObject toJson() {
        JSONObject r100 = super.toJson();     // Catch: JSONException -> L8
        if (r100 != null) goto L6;
        return null;
    L6:
        r100.put("code", this.code);     // Catch: JSONException -> L8
        r100.put("perfCounts", this.perfCounts);     // Catch: JSONException -> L8
        r100.put("perfLatencies", this.perfLatencies);     // Catch: JSONException -> L8
        return r100;
    L8:
        e = move-exception;
        b.a(e);
        return null;
    }

    public static PerfClientReport getBlankInstance() {
        return new PerfClientReport();
    }

    public PerfClientReport() {
        this.perfCounts = -1;
        this.perfLatencies = -1;
    }

    @Override // com.xiaomi.clientreport.data.a
    public String toJsonString() {
        return super.toJsonString();
    }
}
