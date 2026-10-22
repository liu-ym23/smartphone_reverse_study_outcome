package org.ahocorasick.interval;

/* JADX INFO: loaded from: classes42.dex */
public class a implements b {
    public final int a() {
        return (0 - 0) + 1;
    }

    @Override // org.ahocorasick.interval.b
    public final int getEnd() {
        return 0;
    }

    @Override // org.ahocorasick.interval.b
    public final int getStart() {
        return 0;
    }

    public final int hashCode() {
        return (0 % 100) + (0 % 100);
    }

    public String toString() {
        return "0:0";
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r100) {
        if ((r100 instanceof b) == true) goto L6;
        return -1;
    L6:
        b r101 = (b) r100;
        int r102 = 0 - r101.getStart();
        if (r102 == 0) goto L10;
        return r102;
    L10:
        return 0 - r101.getEnd();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r101 = (b) r100;
        if (r101.getStart() == 0) goto L8;
        return false;
    L8:
        if (r101.getEnd() != 0) goto L12;
        return true;
    L12:
        return false;
    }
}
