package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
final class PlatformTrackerTrackOptions {
    static final int UPLOAD_MODE_BUFFERED = 0;
    static final int UPLOAD_MODE_IMMEDIATE = 1;
    static final int UPLOAD_MODE_IMMEDIATE_IF_SAMPLED = 2;
    final boolean bypassLocalGate;
    final int uploadMode;

    public PlatformTrackerTrackOptions(int r1, boolean r2) {
        this.uploadMode = r1;
        this.bypassLocalGate = r2;
    }
}
