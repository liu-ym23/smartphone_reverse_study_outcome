package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class b1 {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b1) == false) goto L6;
        ((b1) r100).getClass();
        return true;
    L6:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "LiveAnchorAccessibilityOnEvent(on=false)";
    }
}
