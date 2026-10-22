package com.relax;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public interface TimingTracker {
    void onFirstFMP();

    void onPerformanceEvent(HashMap<String, Object> r100);

    void onReportTimingSetup(ByteBuffer r100);

    void onReportTimingUpdate(ByteBuffer r100, ByteBuffer r101, String r102);
}
