package hga;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f485060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f485061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f485062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f485063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f485064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f485065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f485066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f485067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f485068j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f485069k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f485070l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f485071m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f485072n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f485073o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f485074p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f485075q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f485076r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f485077s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f485078t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f485079u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f485080v;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f485059a == r101.f485059a) goto L12;
        return false;
    L12:
        if (this.f485060b == r101.f485060b) goto L15;
        return false;
    L15:
        if (this.f485061c == r101.f485061c) goto L18;
        return false;
    L18:
        if (this.f485062d == r101.f485062d) goto L21;
        return false;
    L21:
        if (this.f485063e == r101.f485063e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f485064f, r101.f485064f) == true) goto L27;
        return false;
    L27:
        if (this.f485065g == r101.f485065g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f485066h, r101.f485066h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f485067i, r101.f485067i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f485068j, r101.f485068j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f485069k, r101.f485069k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f485070l, r101.f485070l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f485071m, r101.f485071m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f485072n, r101.f485072n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f485073o, r101.f485073o) == true) goto L54;
        return false;
    L54:
        if (this.f485074p == r101.f485074p) goto L57;
        return false;
    L57:
        if (Float.compare(this.f485075q, r101.f485075q) == 0) goto L60;
        return false;
    L60:
        if (Float.compare(this.f485076r, r101.f485076r) == 0) goto L63;
        return false;
    L63:
        if (this.f485077s == r101.f485077s) goto L66;
        return false;
    L66:
        if (this.f485078t == r101.f485078t) goto L69;
        return false;
    L69:
        if (this.f485079u == r101.f485079u) goto L72;
        return false;
    L72:
        if (this.f485080v == r101.f485080v) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f485059a * 31;
        long r101 = this.f485060b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f485061c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f485062d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f485063e;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + Arrays.hashCode(this.f485064f)) * 31;
        long r109 = this.f485065g;
        int r110 = (((((((((((((((((((((((((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.f485066h.hashCode()) * 31) + this.f485067i.hashCode()) * 31) + this.f485068j.hashCode()) * 31) + this.f485069k.hashCode()) * 31) + this.f485070l.hashCode()) * 31) + this.f485071m.hashCode()) * 31) + this.f485072n.hashCode()) * 31) + this.f485073o.hashCode()) * 31) + this.f485074p) * 31) + Float.floatToIntBits(this.f485075q)) * 31) + Float.floatToIntBits(this.f485076r)) * 31) + this.f485077s) * 31;
        int r111 = 1231;
        if (this.f485078t == false) goto L5;
        int r112 = 1231;
    L6:
        int r113 = (r110 + r112) * 31;
        if (this.f485079u == false) goto L9;
        int r114 = 1231;
    L10:
        int r115 = (r113 + r114) * 31;
        if (this.f485080v == true) goto L15;
        r111 = 1237;
    L15:
        return r115 + r111;
    L9:
        r114 = 1237;
        goto L10
    L5:
        r112 = 1237;
        goto L6
    }

    public final String toString() {
        return "WakeupTruthUploadData(wakeupId=" + this.f485059a + ", triggerTimeMs=" + this.f485060b + ", captureAnchorTimeMs=" + this.f485061c + ", uploadStartTimeMs=" + this.f485062d + ", uploadEndTimeMs=" + this.f485063e + ", audioBytes=" + this.f485064f.length + ", audioDurationMs=" + this.f485065g + ", rawUid=" + d.a(this.f485070l) + ", uid=" + d.a(this.f485071m) + ", did=" + d.a(this.f485072n) + ", osDid=" + d.a(this.f485073o) + ", confidence=" + this.f485076r + ", ohrHand=" + this.f485077s + ", pocketMode=" + this.f485078t + ", firstWakeupAfterBoot=" + this.f485079u + ", firstWakeupAfterVoiceprintRecord=" + this.f485080v + ')';
    }

    public g(int r110, long r111, long r112, long r113, long r210, byte[] r211, long r212, String r213, String r214, String r215, String r216, String r217, String r310, String r311, String r312, int r313, float r314, float r315, int r316, boolean r317, boolean r318, boolean r319) {
        Intrinsics.checkNotNullParameter(r211, "audioData");
        Intrinsics.checkNotNullParameter(r213, "firstEngineVersion");
        Intrinsics.checkNotNullParameter(r214, "kwsModelMd5");
        Intrinsics.checkNotNullParameter(r215, "sidModelMd5");
        Intrinsics.checkNotNullParameter(r216, "groupId");
        Intrinsics.checkNotNullParameter(r217, "rawUid");
        Intrinsics.checkNotNullParameter(r310, "uid");
        Intrinsics.checkNotNullParameter(r311, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r312, "osDid");
        this.f485059a = r110;
        this.f485060b = r111;
        this.f485061c = r112;
        this.f485062d = r113;
        this.f485063e = r210;
        this.f485064f = r211;
        this.f485065g = r212;
        this.f485066h = r213;
        this.f485067i = r214;
        this.f485068j = r215;
        this.f485069k = r216;
        this.f485070l = r217;
        this.f485071m = r310;
        this.f485072n = r311;
        this.f485073o = r312;
        this.f485074p = r313;
        this.f485075q = r314;
        this.f485076r = r315;
        this.f485077s = r316;
        this.f485078t = r317;
        this.f485079u = r318;
        this.f485080v = r319;
    }
}
