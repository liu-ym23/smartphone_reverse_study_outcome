package com.bytedance.ee.bear.document.statistics;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class SendEventData implements Serializable {
    public static final int DOC_OPEN_STAGE_END = 3;
    public static final int DOC_OPEN_STAGE_START = 2;
    public static final int DOC_VISIBLE_EVENT_TYPE = 1;
    public Map<String, String> data;
    public String editionId;
    public int event_type;
    public boolean isVersion;

    public SendEventData() {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("SendEventData{event_type=");
        r100.append(this.event_type);
        r100.append(", data=");
        Map<String, String> r101 = this.data;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append("isVersion=");
        r100.append(this.isVersion);
        r100.append("editionId=");
        r100.append(this.editionId);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }
}
