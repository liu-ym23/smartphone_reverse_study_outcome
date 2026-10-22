package com.bytedance.bdlocation.bridge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class TrackerDataEvent {
    public final Map<String, TrackerValue> data;
    public final String logType;
    public final String purpose;

    public TrackerDataEvent(String r100, Map<String, TrackerValue> r101, String r102) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.logType = r100;
        if (r101 != null) goto L8;
    L11:
        this.data = Collections.emptyMap();
    L12:
        if (r102 != null) goto L14;
        r102 = "";
    L14:
        this.purpose = r102;
        return;
    L8:
        if (r101.isEmpty() == true) goto L11;
        this.data = Collections.unmodifiableMap(new LinkedHashMap(r101));
        goto L12
    }
}
