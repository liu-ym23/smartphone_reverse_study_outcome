package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
final class PlatformTrackerServiceEvent {
    final PlatformTrackerField[] category;
    final PlatformTrackerField[] extra;
    final PlatformTrackerField[] metric;
    final String purpose;
    final String serviceName;

    private static PlatformTrackerField[] safeFields(PlatformTrackerField[] r0) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return new PlatformTrackerField[0];
    }

    public PlatformTrackerServiceEvent(String r1, PlatformTrackerField[] r2, PlatformTrackerField[] r3, PlatformTrackerField[] r4, String r5) {
        this.serviceName = r1;
        this.metric = safeFields(r2);
        this.category = safeFields(r3);
        this.extra = safeFields(r4);
        this.purpose = r5;
    }
}
