package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class MultiLinkStats {
    public LinkIndex linkIndex;
    public int rttAvg;
    public int rttMax;
    public int rttMin;

    public MultiLinkStats(LinkIndex r100, int r101, int r102, int r103) {
        this.linkIndex = r100;
        this.rttMin = r101;
        this.rttMax = r102;
        this.rttAvg = r103;
    }

    private static MultiLinkStats create(int r100, int r101, int r102, int r103) {
        return new MultiLinkStats(LinkIndex.fromId(r100), r101, r102, r103);
    }
}
