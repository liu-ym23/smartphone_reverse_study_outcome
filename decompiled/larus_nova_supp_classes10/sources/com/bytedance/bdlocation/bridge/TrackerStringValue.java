package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TrackerStringValue extends TrackerValue {
    public final String value;

    public TrackerStringValue(String r1) {
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this.value = r1;
    }
}
