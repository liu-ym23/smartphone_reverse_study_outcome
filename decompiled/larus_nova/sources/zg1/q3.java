package zg1;

/* JADX INFO: loaded from: classes7.dex */
public final class q3 {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q3) == false) goto L6;
        ((q3) r100).getClass();
        return true;
    L6:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "WidgetVisibilityChangeEvent(visible=false)";
    }
}
