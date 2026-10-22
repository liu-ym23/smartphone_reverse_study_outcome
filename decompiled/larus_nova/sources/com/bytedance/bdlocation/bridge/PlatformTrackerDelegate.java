package com.bytedance.bdlocation.bridge;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes10.dex */
public interface PlatformTrackerDelegate {
    Executor callbackExecutor();

    boolean isEnabled(String r100);

    void trackData(TrackerDataEvent r100, TrackerTrackOptions r101);

    void trackService(TrackerServiceEvent r100, TrackerTrackOptions r101);
}
