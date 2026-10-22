package com.larus.avlink.model;

import b49.h;
import com.larus.avlink.e.DoraImageEvent;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import z98.d;

/* JADX INFO: loaded from: classes25.dex */
public final class a {
    public Integer A;
    public Long B;
    public int C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public String H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f293421J;
    public boolean K;
    public int L;
    public final Map<DoraImageEvent, d> M;
    public DoraImageEvent N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f293422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f293423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f293424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f293425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f293426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f293427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f293428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f293429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f293430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f293431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f293432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<byte[]> f293433l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f293434m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f293435n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f293436o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f293437p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f293438q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f293439r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f293440s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Long f293441t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Long f293442u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Long f293443v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Long f293444w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f293445x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Map<String, ? extends Object> f293446y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f293447z;

    public a() {
        this(null, 0, 0, 0, 0, null, null, null, -1, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f293422a, r101.f293422a) == true) goto L12;
        return false;
    L12:
        if (this.f293423b == r101.f293423b) goto L15;
        return false;
    L15:
        if (this.f293424c == r101.f293424c) goto L18;
        return false;
    L18:
        if (this.f293425d == r101.f293425d) goto L21;
        return false;
    L21:
        if (this.f293426e == r101.f293426e) goto L24;
        return false;
    L24:
        if (this.f293427f == r101.f293427f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f293428g, r101.f293428g) == true) goto L30;
        return false;
    L30:
        if (this.f293429h == r101.f293429h) goto L33;
        return false;
    L33:
        if (this.f293430i == r101.f293430i) goto L36;
        return false;
    L36:
        if (this.f293431j == r101.f293431j) goto L39;
        return false;
    L39:
        if (this.f293432k == r101.f293432k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f293433l, r101.f293433l) == true) goto L45;
        return false;
    L45:
        if (this.f293434m == r101.f293434m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f293435n, r101.f293435n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f293436o, r101.f293436o) == true) goto L54;
        return false;
    L54:
        if (this.f293437p == r101.f293437p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f293438q, r101.f293438q) == true) goto L60;
        return false;
    L60:
        if (this.f293439r == r101.f293439r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f293440s, r101.f293440s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f293441t, r101.f293441t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f293442u, r101.f293442u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f293443v, r101.f293443v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f293444w, r101.f293444w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f293445x, r101.f293445x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f293446y, r101.f293446y) == true) goto L84;
        return false;
    L84:
        if (this.f293447z == r101.f293447z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L93;
        return false;
    L93:
        if (this.C == r101.C) goto L96;
        return false;
    L96:
        if (this.D == r101.D) goto L99;
        return false;
    L99:
        if (this.E == r101.E) goto L102;
        return false;
    L102:
        if (this.F == r101.F) goto L105;
        return false;
    L105:
        if (this.G == r101.G) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r101.H) == true) goto L111;
        return false;
    L111:
        if (this.I == r101.I) goto L114;
        return false;
    L114:
        if (this.f293421J == r101.f293421J) goto L117;
        return false;
    L117:
        if (this.K == r101.K) goto L120;
        return false;
    L120:
        if (this.L == r101.L) goto L122;
        return false;
    L122:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f293422a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((((((r102 * 31) + this.f293423b) * 31) + this.f293424c) * 31) + this.f293425d) * 31) + this.f293426e) * 31) + this.f293427f) * 31;
        String r104 = this.f293428g;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f293429h) * 31;
        long r107 = this.f293430i;
        int r108 = (((((((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f293431j) * 31) + this.f293432k) * 31) + this.f293433l.hashCode()) * 31) + this.f293434m) * 31;
        Integer r109 = this.f293435n;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        Long r112 = this.f293436o;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        int r115 = 1231;
        if (this.f293437p == false) goto L21;
        int r116 = 1231;
    L22:
        int r117 = (r114 + r116) * 31;
        Boolean r118 = this.f293438q;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (((((r117 + r119) * 31) + this.f293439r) * 31) + this.f293440s.hashCode()) * 31;
        Long r121 = this.f293441t;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        Long r124 = this.f293442u;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        Long r127 = this.f293443v;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        Long r130 = this.f293444w;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f293445x;
        if (r133 != null) goto L45;
        int r134 = 0;
    L46:
        int r135 = (r132 + r134) * 31;
        Map<String, ? extends Object> r136 = this.f293446y;
        if (r136 != null) goto L49;
        int r137 = 0;
    L50:
        int r138 = (r135 + r137) * 31;
        if (this.f293447z == false) goto L53;
        int r139 = 1231;
    L54:
        int r140 = (r138 + r139) * 31;
        Integer r141 = this.A;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        Long r144 = this.B;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (((((((((r143 + r145) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F) * 31;
        if (this.G == false) goto L65;
        int r147 = 1231;
    L66:
        int r148 = (r146 + r147) * 31;
        String r149 = this.H;
        if (r149 == null) goto L70;
        r101 = r149.hashCode();
    L70:
        int r150 = (r148 + r101) * 31;
        if (this.I == false) goto L73;
        int r151 = 1231;
    L74:
        int r152 = (r150 + r151) * 31;
        if (this.f293421J == false) goto L77;
        int r153 = 1231;
    L78:
        int r154 = (r152 + r153) * 31;
        if (this.K == true) goto L83;
        r115 = 1237;
    L83:
        return ((r154 + r115) * 31) + this.L;
    L77:
        r153 = 1237;
        goto L78
    L73:
        r151 = 1237;
        goto L74
    L65:
        r147 = 1237;
        goto L66
    L61:
        r145 = r144.hashCode();
        goto L62
    L57:
        r142 = r141.hashCode();
        goto L58
    L53:
        r139 = 1237;
        goto L54
    L49:
        r137 = r136.hashCode();
        goto L50
    L45:
        r134 = r133.hashCode();
        goto L46
    L41:
        r131 = r130.hashCode();
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = 1237;
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final List<h> a() {
        Integer r100 = this.f293422a;
        if (r100 == null) goto L24;
        int r101 = r100.intValue();
        List r102 = CollectionsKt.filterNotNull(this.f293433l);
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r111 = r102.iterator();
    L6:
        if (r111.hasNext() == false) goto L22;
        byte[] r103 = (byte[]) r111.next();
        int r104 = this.f293423b;
        int r105 = this.f293424c;
        int r106 = this.D;
        ServerSide.a r107 = ServerSide.Companion;
        Integer r108 = Integer.valueOf(this.f293429h);
        r107.getClass();
        if (r108 == null) goto L13;
        int r109 = 1;
        if (r108.intValue() != 1) goto L13;
    L17:
        int r112 = this.C;
        int r113 = this.f293434m;
        Long r114 = this.f293436o;
        if (r114 == null) goto L20;
        long r115 = r114.longValue();
    L21:
        r110.add(new h(r101, r103, r104, r105, r106, r109, r112, r113, r115));
        goto L6
    L20:
        r115 = 0;
    L13:
        if (r108 == null) goto L16;
        r108.intValue();
    L16:
        r109 = 0;
        goto L17
    L22:
        return r110;
    L24:
        return CollectionsKt.emptyList();
    }

    public final String toString() {
        return "DoraPicModel(imageUUid=" + this.f293422a + ", width=" + this.f293423b + ", height=" + this.f293424c + ", qualityValue=" + this.f293425d + ", definitionValue=" + this.f293426e + ", isLiveAI=" + this.f293427f + ", localImageId=" + this.f293428g + ", serverSide=" + this.f293429h + ", size=" + this.f293430i + ", wkrId=" + this.f293431j + ", imageCount=" + this.f293432k + ", imageMode=" + this.f293434m + ", intentMode=" + this.f293435n + ", imageCreateTime=" + this.f293436o + ", hasOcr=" + this.f293437p + ", ocrDetectionRes=" + this.f293438q + ", imageUploadChannel=" + this.f293439r + ", imageUploadId='" + this.f293440s + "', ocrStartTime=" + this.f293441t + ", ocrTransmitFinishTime=" + this.f293442u + ", ocrUploadStartTime=" + this.f293443v + ", ocrUploadFinishTime=" + this.f293444w + ", ocrData=" + this.f293445x + ", ocrUploaded=" + this.f293447z + ", ocrStatus=" + this.A + ", ocrDuration=" + this.B + ", linkType=" + this.C + ", format=" + this.D + ", cameraOutputStrategy=" + this.E + ", ocrTextLines=" + this.F + ", hasSendImage=" + this.G + ", messageId=" + this.H + ", ledBlocked=" + this.I + ", asrEnd=" + this.f293421J + ", blockedConsumed=" + this.K + ", currentState=" + this.N + ", imageEventState=" + this.M + ')';
    }

    public final Long b(DoraImageEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        d r101 = this.M.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r101.f571058b);
    }

    public final void c(DoraImageEvent r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        FLogger.f375446a.i("DoraPicModel", "updateImageState: event is " + r100 + ", success is " + r101 + ", timeStamp is " + r102);
        this.M.put(r100, new d(r101, r102));
        if (r100.compareTo(this.N) <= 0) goto L6;
        this.N = r100;
        return;
    }

    public a(Integer r110, int r111, int r112, int r210, int r211, Integer r212, Long r213, String r214, int r215, int r216) {
        if ((r215 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r215 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r215 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r215 & 128) == 0) goto L17;
        int r103 = 1;
    L19:
        if ((r215 & 2048) == 0) goto L21;
        CopyOnWriteArrayList r104 = new CopyOnWriteArrayList();
    L23:
        if ((r215 & 4096) == 0) goto L25;
        int r113 = 0;
    L27:
        if ((r215 & 8192) == 0) goto L29;
        Integer r114 = null;
    L31:
        if ((262144 & r215) == 0) goto L33;
        String r115 = "";
    L35:
        if ((r215 & 524288) == 0) goto L37;
        Long r105 = null;
    L39:
        if ((r216 & 2) == 0) goto L41;
        String r116 = null;
    L42:
        Intrinsics.checkNotNullParameter(r104, "data");
        Intrinsics.checkNotNullParameter(r115, "imageUploadId");
        this.f293422a = r100;
        this.f293423b = r101;
        this.f293424c = r102;
        this.f293425d = 0;
        this.f293426e = 0;
        this.f293427f = 0;
        this.f293428g = null;
        this.f293429h = r103;
        this.f293430i = 0;
        this.f293431j = 0;
        this.f293432k = 0;
        this.f293433l = r104;
        this.f293434m = r113;
        this.f293435n = r114;
        this.f293436o = null;
        this.f293437p = false;
        this.f293438q = null;
        this.f293439r = 0;
        this.f293440s = r115;
        this.f293441t = r105;
        this.f293442u = null;
        this.f293443v = null;
        this.f293444w = null;
        this.f293445x = null;
        this.f293446y = null;
        this.f293447z = false;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = false;
        this.H = r116;
        this.I = false;
        this.f293421J = false;
        this.K = false;
        this.L = 0;
        this.M = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(DoraImageEvent.TAKE_PHOTO_CMD_SEND, null), TuplesKt.to(DoraImageEvent.IMAGE_TAKE_START, null), TuplesKt.to(DoraImageEvent.IMAGE_TRANS_START, null), TuplesKt.to(DoraImageEvent.IMAGE_TRANS_FINISH, null), TuplesKt.to(DoraImageEvent.IMAGE_UPLOAD_START, null), TuplesKt.to(DoraImageEvent.IMAGE_UPLOAD_FINISH, null)});
        this.N = DoraImageEvent.UNKNOWN;
        return;
    L41:
        r116 = r214;
        goto L42
    L37:
        r105 = r213;
        goto L39
    L33:
        r115 = null;
        goto L35
    L29:
        r114 = r212;
        goto L31
    L25:
        r113 = r211;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
