package fi3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof g) == false) goto L6;
        ((g) r2).getClass();
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
