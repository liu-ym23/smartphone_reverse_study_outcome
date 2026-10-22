package com.bytedance.bdlocation.bridge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TrackerServiceEvent {
    public final Map<String, TrackerValue> category;
    public final Map<String, TrackerValue> extra;
    public final Map<String, TrackerMetricValue> metric;
    public final String purpose;
    public final String serviceName;

    private static <K, V> Map<K, V> copyMap(Map<K, V> r1) {
        if (r1 == null) goto L9;
        if (r1.isEmpty() == true) goto L9;
        return Collections.unmodifiableMap(new LinkedHashMap(r1));
    L9:
        return Collections.emptyMap();
    }

    public TrackerServiceEvent(String r2, Map<String, TrackerMetricValue> r3, Map<String, TrackerValue> r4, Map<String, TrackerValue> r5, String r6) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        this.serviceName = r2;
        this.metric = copyMap(r3);
        this.category = copyMap(r4);
        this.extra = copyMap(r5);
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        this.purpose = r6;
    }
}
