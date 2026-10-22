package com.bytedance.ee.bear.document.render.node.perf;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        StringBuilder r0 = new StringBuilder("SendEventData{event_type=");
        r0.append(this.event_type);
        r0.append(", data=");
        Map<String, String> r1 = this.data;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        r0.append(r2);
        r0.append("isVersion=");
        r0.append(this.isVersion);
        r0.append("editionId=");
        r0.append(this.editionId);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = "";
        goto L6
    }
}
