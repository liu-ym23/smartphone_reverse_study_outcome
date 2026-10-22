package com.larus.bmhome.resource.access;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f313733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceInputType f313734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ResourceMediaType f313735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f313736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f313737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f313738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f313739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f313740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f313741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f313742k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f313743l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f313744m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f313745n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f313746o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f313747p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Boolean f313748q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Long f313749r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Long f313750s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<String, String> f313751t;

    public t() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f313732a, r101.f313732a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313733b, r101.f313733b) == true) goto L15;
        return false;
    L15:
        if (this.f313734c == r101.f313734c) goto L18;
        return false;
    L18:
        if (this.f313735d == r101.f313735d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313736e, r101.f313736e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f313737f, r101.f313737f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f313738g, r101.f313738g) == true) goto L30;
        return false;
    L30:
        if (this.f313739h == r101.f313739h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f313740i, r101.f313740i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f313741j, r101.f313741j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f313742k, r101.f313742k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f313743l, r101.f313743l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f313744m, r101.f313744m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f313745n, r101.f313745n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f313746o, r101.f313746o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f313747p, r101.f313747p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f313748q, r101.f313748q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f313749r, r101.f313749r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f313750s, r101.f313750s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f313751t, r101.f313751t) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f313732a.hashCode() * 31) + this.f313733b.hashCode()) * 31) + this.f313734c.hashCode()) * 31) + this.f313735d.hashCode()) * 31) + this.f313736e.hashCode()) * 31) + this.f313737f.hashCode()) * 31) + this.f313738g.hashCode()) * 31;
        long r101 = this.f313739h;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f313740i.hashCode()) * 31;
        String r103 = this.f313741j;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f313742k;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f313743l;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f313744m;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f313745n;
        if (r116 != null) goto L21;
        int r117 = 0;
    L22:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f313746o;
        if (r119 != null) goto L25;
        int r120 = 0;
    L26:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f313747p;
        if (r122 != null) goto L29;
        int r123 = 0;
    L30:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f313748q;
        if (r125 != null) goto L33;
        int r126 = 0;
    L34:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.f313749r;
        if (r128 != null) goto L37;
        int r129 = 0;
    L38:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.f313750s;
        if (r131 == null) goto L43;
        r104 = r131.hashCode();
    L43:
        return ((r130 + r104) * 31) + this.f313751t.hashCode();
    L37:
        r129 = r128.hashCode();
        goto L38
    L33:
        r126 = r125.hashCode();
        goto L34
    L29:
        r123 = r122.hashCode();
        goto L30
    L25:
        r120 = r119.hashCode();
        goto L26
    L21:
        r117 = r116.hashCode();
        goto L22
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceAccessObserveEvent(taskId=" + this.f313732a + ", scene=" + this.f313733b + ", resourceInputType=" + this.f313734c + ", mediaType=" + this.f313735d + ", fileIdentifier=" + this.f313736e + ", nodeKey=" + this.f313737f + ", stage=" + this.f313738g + ", costMs=" + this.f313739h + ", result=" + this.f313740i + ", errorCode=" + this.f313741j + ", policyVersion=" + this.f313742k + ", routeDecision=" + this.f313743l + ", routeReason=" + this.f313744m + ", cacheHit=" + this.f313745n + ", sdkRoute=" + this.f313746o + ", remoteResolve=" + this.f313747p + ", isTaskReused=" + this.f313748q + ", waitCostMs=" + this.f313749r + ", estimatedSavedMs=" + this.f313750s + ", attributes=" + this.f313751t + ')';
    }

    public t(String r210, x r211, ResourceInputType r212, ResourceMediaType r213, String r214, String r215, String r216, long r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, Boolean r410, Long r411, Long r412, Map r413, int r414) {
        if ((r414 & 512) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r414 & 1024) == 0) goto L9;
        String r111 = null;
    L11:
        if ((r414 & 2048) == 0) goto L13;
        String r112 = null;
    L15:
        if ((r414 & 4096) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r414 & 8192) == 0) goto L21;
        String r114 = null;
    L23:
        if ((r414 & 16384) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r414 & 32768) == 0) goto L29;
        String r116 = null;
    L31:
        if ((r414 & 65536) == 0) goto L33;
        Boolean r117 = null;
    L35:
        if ((r414 & 131072) == 0) goto L37;
        Long r217 = null;
    L39:
        if ((r414 & 262144) == 0) goto L41;
        Long r218 = null;
    L43:
        if ((r414 & 524288) == 0) goto L45;
        Map r100 = MapsKt.emptyMap();
    L46:
        Intrinsics.checkNotNullParameter(r210, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r211, "scene");
        Intrinsics.checkNotNullParameter(r212, "resourceInputType");
        Intrinsics.checkNotNullParameter(r213, "mediaType");
        Intrinsics.checkNotNullParameter(r214, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r215, "nodeKey");
        Intrinsics.checkNotNullParameter(r216, "stage");
        Intrinsics.checkNotNullParameter(r311, "result");
        Intrinsics.checkNotNullParameter(r100, "attributes");
        this.f313732a = r210;
        this.f313733b = r211;
        this.f313734c = r212;
        this.f313735d = r213;
        this.f313736e = r214;
        this.f313737f = r215;
        this.f313738g = r216;
        this.f313739h = r310;
        this.f313740i = r311;
        this.f313741j = r110;
        this.f313742k = r111;
        this.f313743l = r112;
        this.f313744m = r113;
        this.f313745n = r114;
        this.f313746o = r115;
        this.f313747p = r116;
        this.f313748q = r117;
        this.f313749r = r217;
        this.f313750s = r218;
        this.f313751t = r100;
        return;
    L45:
        r100 = r413;
        goto L46
    L41:
        r218 = r412;
        goto L43
    L37:
        r217 = r411;
        goto L39
    L33:
        r117 = r410;
        goto L35
    L29:
        r116 = r318;
        goto L31
    L25:
        r115 = r317;
        goto L27
    L21:
        r114 = r316;
        goto L23
    L17:
        r113 = r315;
        goto L19
    L13:
        r112 = r314;
        goto L15
    L9:
        r111 = r313;
        goto L11
    L5:
        r110 = r312;
        goto L7
    }
}
