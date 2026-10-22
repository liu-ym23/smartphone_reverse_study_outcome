package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
final class PlatformTrackerServiceEvent {
    final PlatformTrackerField[] category;
    final PlatformTrackerField[] extra;
    final PlatformTrackerField[] metric;
    final String purpose;
    final String serviceName;

    private static PlatformTrackerField[] safeFields(PlatformTrackerField[] r100) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        return new PlatformTrackerField[0];
    }

    public PlatformTrackerServiceEvent(String r100, PlatformTrackerField[] r101, PlatformTrackerField[] r102, PlatformTrackerField[] r103, String r104) {
        this.serviceName = r100;
        this.metric = safeFields(r101);
        this.category = safeFields(r102);
        this.extra = safeFields(r103);
        this.purpose = r104;
    }
}
