package com.bytedance.bdlocation.bridge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TrackerDataEvent {
    public final Map<String, TrackerValue> data;
    public final String logType;
    public final String purpose;

    public TrackerDataEvent(String r2, Map<String, TrackerValue> r3, String r4) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        this.logType = r2;
        if (r3 != null) goto L8;
    L11:
        this.data = Collections.emptyMap();
    L12:
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        this.purpose = r4;
        return;
    L8:
        if (r3.isEmpty() == true) goto L11;
        this.data = Collections.unmodifiableMap(new LinkedHashMap(r3));
        goto L12
    }
}
