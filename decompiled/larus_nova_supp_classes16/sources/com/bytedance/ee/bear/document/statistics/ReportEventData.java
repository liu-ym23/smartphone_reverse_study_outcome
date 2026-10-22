package com.bytedance.ee.bear.document.statistics;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ReportEventData implements Serializable {
    public Map<String, Object> data;
    public String event_name;
    public boolean noPrefix;

    public ReportEventData() {
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("{ event_name = ");
        r0.append(this.event_name);
        r0.append(", noPrefix = ");
        r0.append(this.noPrefix);
        r0.append(", data = ");
        Map<String, Object> r1 = this.data;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        r0.append(r2);
        r0.append("}");
        return r0.toString();
    L5:
        r2 = "";
        goto L6
    }
}
