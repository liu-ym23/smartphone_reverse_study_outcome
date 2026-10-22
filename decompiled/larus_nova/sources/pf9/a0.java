package pf9;

import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f528881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f528882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f528883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f528884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f528885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f528886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f528887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f528888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f528889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f528890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f528891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f528892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f528893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f528894n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.f528881a == r101.f528881a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528882b, r101.f528882b) == true) goto L15;
        return false;
    L15:
        if (this.f528883c == r101.f528883c) goto L18;
        return false;
    L18:
        if (this.f528884d == r101.f528884d) goto L21;
        return false;
    L21:
        if (this.f528885e == r101.f528885e) goto L24;
        return false;
    L24:
        if (this.f528886f == r101.f528886f) goto L27;
        return false;
    L27:
        if (this.f528887g == r101.f528887g) goto L30;
        return false;
    L30:
        if (this.f528888h == r101.f528888h) goto L33;
        return false;
    L33:
        if (this.f528889i == r101.f528889i) goto L36;
        return false;
    L36:
        if (this.f528890j == r101.f528890j) goto L39;
        return false;
    L39:
        if (this.f528891k == r101.f528891k) goto L42;
        return false;
    L42:
        if (this.f528892l == r101.f528892l) goto L45;
        return false;
    L45:
        if (this.f528893m == r101.f528893m) goto L48;
        return false;
    L48:
        if (this.f528894n == r101.f528894n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f528881a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Long r102 = this.f528882b;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r101 + r103) * 31;
        int r105 = 1231;
        if (this.f528883c == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f528884d == false) goto L13;
        int r108 = 1231;
    L14:
        long r109 = this.f528885e;
        int r110 = (((r107 + r108) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f528886f;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f528887g;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        if (this.f528888h == false) goto L17;
        int r115 = 1231;
    L18:
        long r116 = this.f528889i;
        int r117 = (((r114 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.f528890j;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.f528891k;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.f528892l;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        if (this.f528893m == true) goto L22;
        r105 = 1237;
    L22:
        int r124 = (r123 + r105) * 31;
        long r125 = this.f528894n;
        return r124 + ((int) (r125 ^ (r125 >>> 32)));
    L17:
        r115 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowLLMQueryEndEvent(userDuration=" + this.f528881a + ", lastRespCostTime=" + this.f528882b + ", noContent=" + this.f528883c + ", triggerBot=" + this.f528884d + ", comfortWaitTime=" + this.f528885e + ", softVadTimestampMs=" + this.f528886f + ", hardVadTimestampMs=" + this.f528887g + ", isPreQuery=" + this.f528888h + ", prefetchBacktrackTime=" + this.f528889i + ", lastUserAudioTimestampMs=" + this.f528890j + ", clientLastUserAudioTimestampMs=" + this.f528891k + ", answerStartDuration=" + this.f528892l + ", hitPreResp=" + this.f528893m + ", asrDuration=" + this.f528894n + ')';
    }

    public a0(long r100, Long r101, boolean r102, boolean r103, long r104, long r110, long r111, boolean r112, long r113, long r114, long r210, long r211, boolean r212, long r213) {
        this.f528881a = r100;
        this.f528882b = r101;
        this.f528883c = r102;
        this.f528884d = r103;
        this.f528885e = r104;
        this.f528886f = r110;
        this.f528887g = r111;
        this.f528888h = r112;
        this.f528889i = r113;
        this.f528890j = r114;
        this.f528891k = r210;
        this.f528892l = r211;
        this.f528893m = r212;
        this.f528894n = r213;
    }
}
