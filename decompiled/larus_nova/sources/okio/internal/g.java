package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.b0;

/* JADX INFO: loaded from: classes42.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f524050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f524051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f524052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f524053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f524054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f524055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f524056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f524057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f524058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f524059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f524060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f524061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f524062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f524063n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f524064o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Integer f524065p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<b0> f524066q;

    public /* synthetic */ g(b0 r210, boolean r211, String r212, long r213, long r214, long r310, int r311, long r312, int r313, int r314, Long r315, Long r316, Long r410, int r411) {
        if ((r411 & 2) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r411 & 4) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r411 & 8) == 0) goto L13;
        long r102 = -1;
    L15:
        if ((r411 & 16) == 0) goto L17;
        long r103 = -1;
    L19:
        if ((r411 & 32) == 0) goto L21;
        long r110 = -1;
    L23:
        if ((r411 & 64) == 0) goto L25;
        int r104 = -1;
    L27:
        if ((r411 & 128) == 0) goto L29;
        long r111 = -1;
    L31:
        if ((r411 & 256) == 0) goto L33;
        int r112 = -1;
    L35:
        if ((r411 & 512) == 0) goto L37;
        int r113 = -1;
    L39:
        if ((r411 & 1024) == 0) goto L41;
        Long r114 = null;
    L43:
        if ((r411 & 2048) == 0) goto L45;
        Long r115 = null;
    L47:
        if ((r411 & 4096) == 0) goto L49;
        Long r116 = null;
    L50:
        this(r210, r100, r101, r102, r103, r110, r104, r111, r112, r113, r114, r115, r116, null, null, null);
        return;
    L49:
        r116 = r410;
        goto L50
    L45:
        r115 = r316;
        goto L47
    L41:
        r114 = r315;
        goto L43
    L37:
        r113 = r314;
        goto L39
    L33:
        r112 = r313;
        goto L35
    L29:
        r111 = r312;
        goto L31
    L25:
        r104 = r311;
        goto L27
    L21:
        r110 = r310;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public g(b0 r100, boolean r101, String r102, long r103, long r110, long r111, int r112, long r113, int r114, int r115, Long r116, Long r210, Long r211, Integer r212, Integer r213, Integer r214) {
        Intrinsics.checkNotNullParameter(r100, "canonicalPath");
        Intrinsics.checkNotNullParameter(r102, "comment");
        this.f524050a = r100;
        this.f524051b = r101;
        this.f524052c = r102;
        this.f524053d = r103;
        this.f524054e = r110;
        this.f524055f = r111;
        this.f524056g = r112;
        this.f524057h = r113;
        this.f524058i = r114;
        this.f524059j = r115;
        this.f524060k = r116;
        this.f524061l = r210;
        this.f524062m = r211;
        this.f524063n = r212;
        this.f524064o = r213;
        this.f524065p = r214;
        this.f524066q = new ArrayList();
    }
}
