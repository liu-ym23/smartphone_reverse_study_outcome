package d00;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f466171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f466172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f466173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f466174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f466175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f466176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f466177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f466178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f466179i;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f466171a, r101.f466171a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f466172b, r101.f466172b) == true) goto L10;
        return false;
    L10:
        if (this.f466173c == r101.f466173c) goto L12;
        return false;
    L12:
        if (this.f466174d == r101.f466174d) goto L14;
        return false;
    L14:
        if (this.f466175e == r101.f466175e) goto L16;
        return false;
    L16:
        if (this.f466176f == r101.f466176f) goto L18;
        return false;
    L18:
        if (this.f466177g == r101.f466177g) goto L20;
        return false;
    L20:
        if (this.f466178h == r101.f466178h) goto L22;
        return false;
    L22:
        if (this.f466179i == r101.f466179i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final int hashCode() {
        String r100 = this.f466171a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f466172b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (((((((r103 + r101) * 31) + this.f466173c) * 31) + this.f466174d) * 31) + this.f466175e) * 31;
        long r106 = this.f466176f;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f466177g;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        boolean r110 = this.f466178h;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L12;
        r112 = 1;
    L12:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f466179i;
        if (r114 == true) goto L17;
        r111 = r114;
    L17:
        return r113 + r111;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameLiveTraceParam(traceId='" + this.f466171a + "', roomId='" + this.f466172b + "', liveSource=" + this.f466173c + ", retryState=" + this.f466174d + ", reconnectState=" + this.f466175e + ", pushStreamTimestamp=" + this.f466176f + ", enterLiveFragmentTimestamp=" + this.f466177g + ", savedStateFromFragment=" + this.f466178h + ", savedStateFromActivity=" + this.f466179i + ')';
    }

    public d(int r100) {
        Intrinsics.checkNotNullParameter("", "traceId");
        Intrinsics.checkNotNullParameter("", "roomId");
        this.f466171a = "";
        this.f466172b = "";
        this.f466173c = 0;
        this.f466174d = 0;
        this.f466175e = 0;
        this.f466176f = 0;
        this.f466177g = 0;
        this.f466178h = false;
        this.f466179i = false;
    }

    public static long a(long r100) {
        if (r100 != 0) goto L6;
        return r100;
    L6:
        return System.currentTimeMillis() - r100;
    }
}
