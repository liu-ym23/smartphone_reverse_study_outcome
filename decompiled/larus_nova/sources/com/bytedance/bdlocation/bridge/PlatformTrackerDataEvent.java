package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
final class PlatformTrackerDataEvent {
    final PlatformTrackerField[] data;
    final String logType;
    final String purpose;

    public PlatformTrackerDataEvent(String r100, PlatformTrackerField[] r101, String r102) {
        this.logType = r100;
        if (r101 != null) goto L5;
        r101 = new PlatformTrackerField[0];
    L5:
        this.data = r101;
        this.purpose = r102;
    }
}
