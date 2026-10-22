package com.ss.android.vesdk;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class FluencyTrackingData {
    public boolean enableDetail;
    public long endTime;
    public ArrayList<FluencyFrameDetail> frameDetails;
    private final int[] lagLevelCounts;
    private final long[] lagLevelDuration;
    public long startTime;
    public int totalFrames;
    public int totalLagCount;
    public long totalLagDuration;

    public String toString() {
        return "FluencyTrackingData{startTime=" + this.startTime + ", endTime=" + this.endTime + ", totalFrames=" + this.totalFrames + ", totalLagCount=" + this.totalLagCount + ", totalLagDuration=" + this.totalLagDuration + ", lagLevelCounts=" + Arrays.toString(this.lagLevelCounts) + ", lagLevelDuration=" + Arrays.toString(this.lagLevelDuration) + ", enableDetail=" + this.enableDetail + ", frameDetails=" + this.frameDetails + '}';
    }

    public FluencyTrackingData() {
        this.lagLevelCounts = new int[8];
        this.lagLevelDuration = new long[8];
    }

    public ArrayList<FluencyFrameDetail> getFrameDetails() {
        return this.frameDetails;
    }

    public int[] getLagLevelCounts() {
        return this.lagLevelCounts;
    }

    public long[] getLagLevelDuration() {
        return this.lagLevelDuration;
    }

    public int getTotalFrames() {
        return this.totalFrames;
    }

    public int getTotalLagCount() {
        return this.totalLagCount;
    }

    public long getTotalLagDuration() {
        return this.totalLagDuration;
    }

    public int getLagCountByLevel(int r100) {
        if (r100 >= 0) goto L4;
        return 0;
    L4:
        if (r100 < 8) goto L6;
        return 0;
    L6:
        return this.lagLevelCounts[r100];
    }

    public long getLagDurationByLevel(int r100) {
        if (r100 >= 0) goto L4;
        return 0;
    L4:
        if (r100 < 8) goto L6;
        return 0;
    L6:
        return this.lagLevelDuration[r100];
    }
}
