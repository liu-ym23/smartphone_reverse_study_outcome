package com.bytedance.sysoptimizer.anr;

/* JADX INFO: loaded from: classes3.dex */
public class ResourceUsage {
    public long idRss;
    public long majFlt;
    public long minFlt;
    public long nivcsw;
    public long nvcsw;
    public long pss;
    public long readSizeMB;
    public long recordTimestamp;
    public long rss;
    public long stm;
    public long sysTimeSec;
    public long sysTimeUsec;
    public String threadState;
    public long userTimeSec;
    public long userTimeUsec;
    public long utm;
    public long writeSizeMB;

    public ResourceUsage() {
    }

    public String toString() {
        return "UsageInfo{userTimeSec=" + this.userTimeSec + ", userTimeUsec=" + this.userTimeUsec + ", sysTimeSec=" + this.sysTimeSec + ", sysTimeUsec=" + this.sysTimeUsec + ", rss=" + this.rss + ", idRss=" + this.idRss + ", minFlt=" + this.minFlt + ", majFlt=" + this.majFlt + ", readSizeMB=" + this.readSizeMB + ", writeSizeMB=" + this.writeSizeMB + ", nvcsw=" + this.nvcsw + ", nivcsw=" + this.nivcsw + ", recordTimestamp=" + this.recordTimestamp + '}';
    }
}
