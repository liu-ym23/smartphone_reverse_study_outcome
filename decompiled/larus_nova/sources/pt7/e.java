package pt7;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        ((e) r100).getClass();
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "MultiNetStateBridge(preState=0, curState=0)";
    }
}
