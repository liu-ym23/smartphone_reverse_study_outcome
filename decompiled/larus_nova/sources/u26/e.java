package u26;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f548486b;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{\"code\": ");
        r100.append(this.f548486b);
        r100.append(",\"msg\": ");
        String r101 = this.f548485a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append(", \"templateLoadFrom\": unknown, \"templateFilePath\":");
        r100.append("");
        r100.append(' ');
        return r100.toString();
    }

    public e(String r100, int r101) {
        this.f548485a = r100;
        this.f548486b = r101;
    }
}
