package com.bytedance.bdlocation.bridge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class TrackerServiceEvent {
    public final Map<String, TrackerValue> category;
    public final Map<String, TrackerValue> extra;
    public final Map<String, TrackerMetricValue> metric;
    public final String purpose;
    public final String serviceName;

    private static <K, V> Map<K, V> copyMap(Map<K, V> r100) {
        if (r100 == null) goto L9;
        if (r100.isEmpty() == true) goto L9;
        return Collections.unmodifiableMap(new LinkedHashMap(r100));
    L9:
        return Collections.emptyMap();
    }

    public TrackerServiceEvent(String r100, Map<String, TrackerMetricValue> r101, Map<String, TrackerValue> r102, Map<String, TrackerValue> r103, String r104) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.serviceName = r100;
        this.metric = copyMap(r101);
        this.category = copyMap(r102);
        this.extra = copyMap(r103);
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        this.purpose = r104;
    }
}
