package ws3;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f561031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f561032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f561033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f561034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f561035e;

    @Override // java.lang.Comparable
    public final int compareTo(Object r100) {
        long r101 = this.f561033c;
        long r102 = ((m) r100).f561033c;
        if (r101 != r102) goto L7;
        return 0;
    L7:
        if (r101 <= r102) goto L10;
        return 1;
    L10:
        return -1;
    }

    public m(String r100, long r101, String r102) {
        this.f561031a = r100;
        this.f561033c = r101;
        this.f561035e = System.currentTimeMillis();
        this.f561034d = 1;
        this.f561032b = r102;
    }
}
