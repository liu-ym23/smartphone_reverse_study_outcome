package cs3;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f465171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f465172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f465173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StackTraceElement[] f465174d;

    public b() {
    }

    public final String a() {
        StringBuilder r100 = new StringBuilder();
        int r101 = 9;
    L4:
        if (r101 >= this.f465174d.length) goto L7;
        r100.append("\tat ");
        r100.append(this.f465174d[r101].toString());
        r100.append("\n");
        r101 = r101 + 1;
        goto L4
    L7:
        return r100.toString();
    }
}
