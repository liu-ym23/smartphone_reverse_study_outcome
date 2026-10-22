package com.bytedance.bdlocation.bridge;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface PlatformTrackerDelegate {
    Executor callbackExecutor();

    boolean isEnabled(String r1);

    void trackData(TrackerDataEvent r1, TrackerTrackOptions r2);

    void trackService(TrackerServiceEvent r1, TrackerTrackOptions r2);
}
