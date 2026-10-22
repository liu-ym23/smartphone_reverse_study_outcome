package d58;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f467063d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f467064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f467065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f467066c;

    /* JADX INFO: renamed from: d58.a$a, reason: collision with other inner class name */
    public static final class C5639a {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f467064a == r101.f467064a) goto L12;
        return false;
    L12:
        if (this.f467065b == r101.f467065b) goto L15;
        return false;
    L15:
        if (this.f467066c == r101.f467066c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f467064a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f467065b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f467066c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "AsrDurationConfig(handsfreeMaxMs=" + this.f467064a + ", longPressMaxMs=" + this.f467065b + ", longPressMinMs=" + this.f467066c + ')';
    }

    static {
        f467063d = new a(0);
    }

    public /* synthetic */ a(int r100) {
        this(0, 0, 500);
    }

    public a(long r100, long r101, long r102) {
        this.f467064a = r100;
        this.f467065b = r101;
        this.f467066c = r102;
    }
}
