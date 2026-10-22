package com.larus.amap.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/amap/model/FlowNaviInfo;", "", "pathRetainTime", "", "pathRetainDistance", "<init>", "(II)V", "getPathRetainTime", "()I", "getPathRetainDistance", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowNaviInfo {
    private final int pathRetainDistance;
    private final int pathRetainTime;

    public static /* synthetic */ FlowNaviInfo copy$default(FlowNaviInfo r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.pathRetainTime;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.pathRetainDistance;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.pathRetainTime;
    }

    public final int component2() {
        return this.pathRetainDistance;
    }

    public final FlowNaviInfo copy(int r100, int r101) {
        return new FlowNaviInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowNaviInfo) == true) goto L8;
        return false;
    L8:
        FlowNaviInfo r101 = (FlowNaviInfo) r100;
        if (this.pathRetainTime == r101.pathRetainTime) goto L12;
        return false;
    L12:
        if (this.pathRetainDistance == r101.pathRetainDistance) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.pathRetainTime * 31) + this.pathRetainDistance;
    }

    public String toString() {
        return "FlowNaviInfo(pathRetainTime=" + this.pathRetainTime + ", pathRetainDistance=" + this.pathRetainDistance + ')';
    }

    public final int getPathRetainDistance() {
        return this.pathRetainDistance;
    }

    public final int getPathRetainTime() {
        return this.pathRetainTime;
    }

    public FlowNaviInfo(int r100, int r101) {
        this.pathRetainTime = r100;
        this.pathRetainDistance = r101;
    }
}
