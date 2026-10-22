package com.bytedance.ee.plugin.common.ttpdfreader;

import java.util.Objects;

/* JADX INFO: loaded from: classes19.dex */
public class Range {
    public long begin;
    public long end;

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.begin), Long.valueOf(this.end)});
    }

    public String toString() {
        return "Range{begin=" + this.begin + ", end=" + this.end + '}';
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Range) == true) goto L8;
        return false;
    L8:
        Range r101 = (Range) r100;
        if (r101.begin <= this.begin) goto L11;
    L13:
        return false;
    L11:
        if (r101.end < this.end) goto L13;
        return true;
    }

    public Range(long r100, long r101) {
        this.begin = r100;
        this.end = r101;
    }
}
