package com.xiaomi.clientreport.data;

import com.heytap.mcssdk.constant.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class EventClientReport extends a {
    public String eventContent;
    public String eventId;
    public long eventTime;
    public int eventType;

    @Override // com.xiaomi.clientreport.data.a
    public JSONObject toJson() {
        JSONObject r100 = super.toJson();     // Catch: JSONException -> L11
        if (r100 != null) goto L6;
        return null;
    L6:
        r100.put(b.f276361k, this.eventId);     // Catch: JSONException -> L11
        r100.put("eventType", this.eventType);     // Catch: JSONException -> L11
        r100.put("eventTime", this.eventTime);     // Catch: JSONException -> L11
        String r101 = this.eventContent;     // Catch: JSONException -> L11
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        r100.put("eventContent", r101);     // Catch: JSONException -> L11
        return r100;
    L11:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return null;
    }

    public static EventClientReport getBlankInstance() {
        return new EventClientReport();
    }

    @Override // com.xiaomi.clientreport.data.a
    public String toJsonString() {
        return super.toJsonString();
    }

    public EventClientReport() {
    }
}
