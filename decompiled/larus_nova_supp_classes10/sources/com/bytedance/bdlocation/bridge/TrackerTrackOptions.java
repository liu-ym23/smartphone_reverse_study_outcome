package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TrackerTrackOptions {
    public static final int UPLOAD_MODE_BUFFERED = 0;
    public static final int UPLOAD_MODE_IMMEDIATE = 1;
    public static final int UPLOAD_MODE_IMMEDIATE_IF_SAMPLED = 2;
    public final boolean bypassLocalGate;
    public final int uploadMode;

    public TrackerTrackOptions(int r1, boolean r2) {
        this.uploadMode = r1;
        this.bypassLocalGate = r2;
    }
}
