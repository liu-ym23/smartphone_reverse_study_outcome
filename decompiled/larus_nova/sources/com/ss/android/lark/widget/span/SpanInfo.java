package com.ss.android.lark.widget.span;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class SpanInfo implements Comparable<SpanInfo>, Serializable {
    public int end;
    public boolean isGlobalSpanInfo;
    public int start;
    public String text;
    public int type;

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.start), Integer.valueOf(this.end), Integer.valueOf(this.type), this.text});
    }

    public String toString() {
        return "start:" + this.start + ", end:" + this.end + ", type:" + this.type + ", text:" + this.text;
    }

    public SpanInfo() {
        this.isGlobalSpanInfo = false;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SpanInfo r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = this.start;
        int r102 = r100.start;
        if (r101 >= r102) goto L9;
        return -1;
    L9:
        if (r101 != r102) goto L32;
        boolean r103 = this instanceof PrefixInfo;
        if (r103 == true) goto L13;
    L15:
        if (r103 == false) goto L17;
    L19:
        if (r103 == false) goto L21;
        return 0;
    L21:
        int r104 = this.end;
        int r105 = r100.end;
        if (r104 >= r105) goto L24;
        return -1;
    L24:
        if (r104 != r105) goto L32;
        if (r100.type != 4) goto L29;
        return -1;
    L29:
        if (this.type != 4) goto L34;
        return 1;
    L34:
        return 0;
    L17:
        if ((r100 instanceof PrefixInfo) == false) goto L19;
        return 1;
    L13:
        if ((r100 instanceof PrefixInfo) == true) goto L15;
        return -1;
    L32:
        return 1;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpanInfo) == true) goto L8;
        return false;
    L8:
        SpanInfo r101 = (SpanInfo) r100;
        if (this.start == r101.start) goto L11;
    L17:
        return false;
    L11:
        if (this.end != r101.end) goto L17;
        if (this.type != r101.type) goto L17;
        if (Objects.equals(this.text, r101.text) == false) goto L17;
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(SpanInfo r100) {
        return compareTo2(r100);
    }
}
