package fi3;

/* JADX INFO: loaded from: classes13.dex */
public final class g {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L6;
        ((g) r100).getClass();
        return true;
    L6:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "CloseActionParams(isForSplit=false)";
    }
}
