package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class TrackerTrackOptions {
    public static final int UPLOAD_MODE_BUFFERED = 0;
    public static final int UPLOAD_MODE_IMMEDIATE = 1;
    public static final int UPLOAD_MODE_IMMEDIATE_IF_SAMPLED = 2;
    public final boolean bypassLocalGate;
    public final int uploadMode;

    public TrackerTrackOptions(int r100, boolean r101) {
        this.uploadMode = r100;
        this.bypassLocalGate = r101;
    }
}
