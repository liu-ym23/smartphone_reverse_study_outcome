package l78;

import c68.b;
import m58.h;
import m58.w;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f507815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f507816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f507817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f507818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f507819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f507820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f507821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile int f507822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile int f507823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile long f507824j;

    static {
        f507820f = "";
        f507821g = "";
    }

    public static long a() {
        if (f507822h > 0) goto L5;
    L11:
        return 0;
    L5:
        if (f507822h != f507823i) goto L11;
        int r100 = b.f22600a;
        b.d("FlowTtsLagTraceHelper", "[onAudioData] stuck happens. stuckCount: " + f507818d + ", chunkStartCount: " + f507822h + ", lastChunkFinishTime: " + f507824j);
        f507818d = f507818d + 1;
        long r101 = System.currentTimeMillis() - f507824j;
        f507817c = f507817c + r101;
        int r102 = f507819e;
        w r103 = h.f512135f;
        if (r103 == null) goto L9;
        int r104 = r103.o();
    L10:
        f507819e = r102 + r104;
        return r101;
    L9:
        r104 = 0;
        goto L10
    }
}
