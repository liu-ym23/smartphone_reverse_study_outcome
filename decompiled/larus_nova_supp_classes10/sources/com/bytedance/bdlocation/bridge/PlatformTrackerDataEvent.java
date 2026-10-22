package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
final class PlatformTrackerDataEvent {
    final PlatformTrackerField[] data;
    final String logType;
    final String purpose;

    public PlatformTrackerDataEvent(String r1, PlatformTrackerField[] r2, String r3) {
        this.logType = r1;
        if (r2 != null) goto L5;
        r2 = new PlatformTrackerField[0];
    L5:
        this.data = r2;
        this.purpose = r3;
    }
}
