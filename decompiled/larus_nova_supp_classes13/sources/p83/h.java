package p83;

import kotlin.jvm.internal.Intrinsics;
import n83.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public static final /* synthetic */ int w = 0;
    public final boolean a;
    public final m b;
    public final Integer c;
    public final boolean d;
    public final String e;
    public final String f;
    public final JSONObject g;
    public final JSONObject h;
    public final Integer i;
    public final Integer j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final Boolean p;
    public final String q;
    public final JSONObject r;
    public final Boolean s;
    public final String t;
    public final Long u;
    public final Long v;

    public static final class a {
        public static h a(String r18, JSONObject r19, JSONObject r20, String r21, Integer r22) {
            Intrinsics.checkNotNullParameter(r18, "followStatus");
            Intrinsics.checkNotNullParameter(r19, "entranceInfo");
            Intrinsics.checkNotNullParameter(r20, "v3EventAdditions");
            return new h(false, null, null, false, r21, r18, r19, r20, r22, null, null, null, null, null, null, 16776718);
        }
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L4;
        return true;
    L4:
        if ((r4 instanceof h) == false) goto L54;
        h r5 = (h) r4;
        if (this.a == r5.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r5.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r5.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r5.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r5.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r5.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r5.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r5.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r5.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r5.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r5.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(null, null) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.l, r5.l) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.m, r5.m) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.n, r5.n) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.o, r5.o) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.p, r5.p) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.q, r5.q) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(null, null) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.r, r5.r) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.s, r5.s) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.t, r5.t) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.u, r5.u) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.v, r5.v) == true) goto L82;
        return false;
    L82:
        return true;
    L54:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v71 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        m r4 = this.b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        Integer r8 = this.c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        boolean r11 = this.d;
        if (r11 == true) goto L17;
        r1 = r11;
    L17:
        int r12 = (r10 + r1) * 31;
        String r13 = this.e;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L24;
        int r17 = r16.hashCode();
    L25:
        int r18 = (r15 + r17) * 31;
        JSONObject r19 = this.g;
        if (r19 == null) goto L28;
        int r20 = r19.hashCode();
    L29:
        int r21 = (r18 + r20) * 31;
        JSONObject r22 = this.h;
        if (r22 == null) goto L32;
        int r23 = r22.hashCode();
    L33:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.i;
        if (r25 == null) goto L36;
        int r26 = r25.hashCode();
    L37:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.j;
        if (r28 == null) goto L40;
        int r29 = r28.hashCode();
    L41:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 == null) goto L44;
        int r32 = r31.hashCode();
    L45:
        int r33 = (((r30 + r32) * 31) + 0) * 31;
        String r34 = this.l;
        if (r34 == null) goto L48;
        int r35 = r34.hashCode();
    L49:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 == null) goto L52;
        int r38 = r37.hashCode();
    L53:
        int r39 = (r36 + r38) * 31;
        String r40 = this.n;
        if (r40 == null) goto L56;
        int r41 = r40.hashCode();
    L57:
        int r42 = (r39 + r41) * 31;
        String r43 = this.o;
        if (r43 == null) goto L60;
        int r44 = r43.hashCode();
    L61:
        int r45 = (r42 + r44) * 31;
        Boolean r46 = this.p;
        if (r46 == null) goto L64;
        int r47 = r46.hashCode();
    L65:
        int r48 = (r45 + r47) * 31;
        String r49 = this.q;
        if (r49 == null) goto L68;
        int r50 = r49.hashCode();
    L69:
        int r51 = (((r48 + r50) * 31) + 0) * 31;
        JSONObject r52 = this.r;
        if (r52 == null) goto L72;
        int r53 = r52.hashCode();
    L73:
        int r54 = (r51 + r53) * 31;
        Boolean r55 = this.s;
        if (r55 == null) goto L76;
        int r56 = r55.hashCode();
    L77:
        int r57 = (r54 + r56) * 31;
        String r58 = this.t;
        if (r58 == null) goto L80;
        int r59 = r58.hashCode();
    L81:
        int r60 = (r57 + r59) * 31;
        Long r61 = this.u;
        if (r61 == null) goto L84;
        int r62 = r61.hashCode();
    L85:
        int r63 = (r60 + r62) * 31;
        Long r64 = this.v;
        if (r64 == null) goto L89;
        r5 = r64.hashCode();
    L89:
        return r63 + r5;
    L84:
        r62 = 0;
        goto L85
    L80:
        r59 = 0;
        goto L81
    L76:
        r56 = 0;
        goto L77
    L72:
        r53 = 0;
        goto L73
    L68:
        r50 = 0;
        goto L69
    L64:
        r47 = 0;
        goto L65
    L60:
        r44 = 0;
        goto L61
    L56:
        r41 = 0;
        goto L57
    L52:
        r38 = 0;
        goto L53
    L48:
        r35 = 0;
        goto L49
    L44:
        r32 = 0;
        goto L45
    L40:
        r29 = 0;
        goto L41
    L36:
        r26 = 0;
        goto L37
    L32:
        r23 = 0;
        goto L33
    L28:
        r20 = 0;
        goto L29
    L24:
        r17 = 0;
        goto L25
    L20:
        r14 = 0;
        goto L21
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "PdpCustomizableParams(activityWillFinish=" + this.a + ", videoZoomController=" + this.b + ", fullMode=" + this.c + ", isPreload=" + this.d + ", liveWindowRoomId=" + this.e + ", followStatus=" + this.f + ", entranceInfo=" + this.g + ", v3EventAdditions=" + this.h + ", heightPercent=" + this.i + ", pdpHalf2026HeightType=" + this.j + ", enterFrom=" + this.k + ", pdpTransitionDepend=null, coverImgUrl=" + this.l + ", covImageUri=" + this.m + ", fractionListenerId=" + this.n + ", sceneTransitionData=" + this.o + ", clientCacheDisable=" + this.p + ", sourceBtmToken=" + this.q + ", interceptor=null, adParams=" + this.r + ", fromSchemaConvert=" + this.s + ", codeSource=" + this.t + ", startTs=" + this.u + ", schemaConvertDuration=" + this.v + ")";
    }

    public /* synthetic */ h(boolean r27, m r28, Integer r29, boolean r30, String r31, String r32, JSONObject r33, JSONObject r34, Integer r35, String r36, JSONObject r37, Boolean r38, String r39, Long r40, Long r41, int r42) {
        if ((r42 & 2) == 0) goto L5;
        m r5 = null;
    L7:
        if ((r42 & 4) == 0) goto L9;
        Integer r6 = null;
    L11:
        if ((r42 & 8) == 0) goto L13;
        boolean r7 = false;
    L15:
        if ((r42 & 16) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r42 & 32) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r42 & 64) == 0) goto L25;
        JSONObject r10 = null;
    L27:
        if ((r42 & 128) == 0) goto L29;
        JSONObject r11 = null;
    L31:
        if ((r42 & 256) == 0) goto L33;
        Integer r12 = null;
    L35:
        if ((131072 & r42) == 0) goto L37;
        String r20 = null;
    L39:
        if ((524288 & r42) == 0) goto L41;
        JSONObject r21 = null;
    L43:
        if ((1048576 & r42) == 0) goto L45;
        Boolean r22 = Boolean.FALSE;
    L47:
        if ((2097152 & r42) == 0) goto L49;
        String r23 = null;
    L51:
        if ((4194304 & r42) == 0) goto L53;
        Long r24 = null;
    L55:
        if ((r42 & 8388608) == 0) goto L57;
        Long r25 = null;
    L58:
        this(r27, r5, r6, r7, r8, r9, r10, r11, r12, null, null, null, null, null, null, null, r20, r21, r22, r23, r24, r25);
        return;
    L57:
        r25 = r41;
        goto L58
    L53:
        r24 = r40;
        goto L55
    L49:
        r23 = r39;
        goto L51
    L45:
        r22 = r38;
        goto L47
    L41:
        r21 = r37;
        goto L43
    L37:
        r20 = r36;
        goto L39
    L33:
        r12 = r35;
        goto L35
    L29:
        r11 = r34;
        goto L31
    L25:
        r10 = r33;
        goto L27
    L21:
        r9 = r32;
        goto L23
    L17:
        r8 = r31;
        goto L19
    L13:
        r7 = r30;
        goto L15
    L9:
        r6 = r29;
        goto L11
    L5:
        r5 = r28;
        goto L7
    }

    public h(boolean r3, m r4, Integer r5, boolean r6, String r7, String r8, JSONObject r9, JSONObject r10, Integer r11, Integer r12, String r13, String r14, String r15, String r16, String r17, Boolean r18, String r19, JSONObject r20, Boolean r21, String r22, Long r23, Long r24) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
    }
}
