package scb;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        ((a) r100).getClass();
        return true;
    }

    public final int hashCode() {
        return (int) 0;
    }

    public final String toString() {
        return "EndpointSecurityFactorReportResult(code=0)";
    }
}
