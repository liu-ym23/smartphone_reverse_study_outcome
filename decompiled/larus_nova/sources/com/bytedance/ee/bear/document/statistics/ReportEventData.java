package com.bytedance.ee.bear.document.statistics;

import com.alipay.sdk.m.u.i;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class ReportEventData implements Serializable {
    public Map<String, Object> data;
    public String event_name;
    public boolean noPrefix;

    public ReportEventData() {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("{ event_name = ");
        r100.append(this.event_name);
        r100.append(", noPrefix = ");
        r100.append(this.noPrefix);
        r100.append(", data = ");
        Map<String, Object> r101 = this.data;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append(i.f25855d);
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }
}
