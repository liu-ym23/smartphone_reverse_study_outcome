package hga;

import com.obric.assistant.spi.audio.WakeupAudioCaptureTriggerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f485039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WakeupAudioCaptureTriggerType f485040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f485041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f485042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f485043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f485044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f485045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f485046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f485047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f485048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f485049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f485050l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f485051m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f485052n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f485053o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f485054p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f485055q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f485056r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f485057s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f485058t;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f485039a == r101.f485039a) goto L12;
        return false;
    L12:
        if (this.f485040b == r101.f485040b) goto L15;
        return false;
    L15:
        if (this.f485041c == r101.f485041c) goto L18;
        return false;
    L18:
        if (this.f485042d == r101.f485042d) goto L21;
        return false;
    L21:
        if (this.f485043e == r101.f485043e) goto L24;
        return false;
    L24:
        if (this.f485044f == r101.f485044f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f485045g, r101.f485045g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f485046h, r101.f485046h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f485047i, r101.f485047i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f485048j, r101.f485048j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f485049k, r101.f485049k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f485050l, r101.f485050l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f485051m, r101.f485051m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f485052n, r101.f485052n) == true) goto L51;
        return false;
    L51:
        if (this.f485053o == r101.f485053o) goto L54;
        return false;
    L54:
        if (Float.compare(this.f485054p, r101.f485054p) == 0) goto L57;
        return false;
    L57:
        if (Float.compare(this.f485055q, r101.f485055q) == 0) goto L60;
        return false;
    L60:
        if (this.f485056r == r101.f485056r) goto L63;
        return false;
    L63:
        if (this.f485057s == r101.f485057s) goto L66;
        return false;
    L66:
        if (this.f485058t == r101.f485058t) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f485039a;
        int r101 = ((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f485040b.hashCode()) * 31) + this.f485041c) * 31) + this.f485042d) * 31;
        long r102 = this.f485043e;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f485044f;
        int r105 = (((((((((((((((((((((((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f485045g.hashCode()) * 31) + this.f485046h.hashCode()) * 31) + this.f485047i.hashCode()) * 31) + this.f485048j.hashCode()) * 31) + this.f485049k.hashCode()) * 31) + this.f485050l.hashCode()) * 31) + this.f485051m.hashCode()) * 31) + this.f485052n.hashCode()) * 31) + this.f485053o) * 31) + Float.floatToIntBits(this.f485054p)) * 31) + Float.floatToIntBits(this.f485055q)) * 31) + this.f485056r) * 31;
        int r106 = 1231;
        if (this.f485057s == false) goto L5;
        int r107 = 1231;
    L6:
        int r108 = (r105 + r107) * 31;
        if (this.f485058t == true) goto L11;
        r106 = 1237;
    L11:
        return r108 + r106;
    L5:
        r107 = 1237;
        goto L6
    }

    public final String toString() {
        return "WakeupAudioCaptureTrigger(triggerTimeMs=" + this.f485039a + ", triggerType=" + this.f485040b + ", sessionId=" + this.f485041c + ", wakeupId=" + this.f485042d + ", interactionAudioStartTimeMs=" + this.f485043e + ", mainProcessReceivedTimeMs=" + this.f485044f + ", rawUid=" + d.a(this.f485045g) + ", uid=" + d.a(this.f485046h) + ", did=" + d.a(this.f485047i) + ", osDid=" + d.a(this.f485048j) + ", confidence=" + this.f485055q + ", ohrHand=" + this.f485056r + ", firstWakeupAfterBoot=" + this.f485057s + ", firstWakeupAfterVoiceprintRecord=" + this.f485058t + ')';
    }

    public f(long r210, WakeupAudioCaptureTriggerType r211, int r212, long r213, long r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, int r410, float r411, float r412, int r413, boolean r414, boolean r415, int r416) {
        if ((r416 & 4) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r416 & 8) == 0) goto L9;
        int r101 = 0;
    L10:
        long r102 = 0;
        if ((r416 & 16) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r416 & 32) != 0) goto L19;
        r102 = r310;
    L19:
        if ((r416 & 64) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r416 & 128) == 0) goto L25;
        String r110 = "";
    L27:
        if ((r416 & 256) == 0) goto L29;
        String r111 = "";
    L31:
        if ((r416 & 512) == 0) goto L33;
        String r112 = "";
    L35:
        if ((r416 & 1024) == 0) goto L37;
        String r113 = "";
    L39:
        if ((r416 & 2048) == 0) goto L41;
        String r105 = "";
    L43:
        if ((r416 & 4096) == 0) goto L45;
        String r114 = "";
    L46:
        long r214 = r102;
        if ((r416 & 8192) == 0) goto L49;
        String r106 = "";
    L51:
        if ((r416 & 16384) == 0) goto L53;
        int r107 = 0;
    L55:
        if ((r416 & 32768) == 0) goto L57;
        float r115 = 0.0f;
    L59:
        if ((r416 & 65536) == 0) goto L61;
        float r215 = 0.0f;
    L63:
        if ((r416 & 131072) == 0) goto L65;
        int r216 = 0;
    L67:
        if ((r416 & 262144) == 0) goto L69;
        boolean r217 = false;
    L71:
        if ((r416 & 524288) == 0) goto L73;
        boolean r116 = false;
    L74:
        Intrinsics.checkNotNullParameter(r211, "triggerType");
        Intrinsics.checkNotNullParameter(r104, "rawUid");
        Intrinsics.checkNotNullParameter(r110, "uid");
        Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r112, "osDid");
        Intrinsics.checkNotNullParameter(r113, "firstEngineVersion");
        Intrinsics.checkNotNullParameter(r105, "kwsModelMd5");
        Intrinsics.checkNotNullParameter(r114, "sidModelMd5");
        Intrinsics.checkNotNullParameter(r106, "groupId");
        this.f485039a = r210;
        this.f485040b = r211;
        this.f485041c = r100;
        this.f485042d = r101;
        this.f485043e = r103;
        this.f485044f = r214;
        this.f485045g = r104;
        this.f485046h = r110;
        this.f485047i = r111;
        this.f485048j = r112;
        this.f485049k = r113;
        this.f485050l = r105;
        this.f485051m = r114;
        this.f485052n = r106;
        this.f485053o = r107;
        this.f485054p = r115;
        this.f485055q = r215;
        this.f485056r = r216;
        this.f485057s = r217;
        this.f485058t = r116;
        return;
    L73:
        r116 = r415;
        goto L74
    L69:
        r217 = r414;
        goto L71
    L65:
        r216 = r413;
        goto L67
    L61:
        r215 = r412;
        goto L63
    L57:
        r115 = r411;
        goto L59
    L53:
        r107 = r410;
        goto L55
    L49:
        r106 = r318;
        goto L51
    L45:
        r114 = r317;
        goto L46
    L41:
        r105 = r316;
        goto L43
    L37:
        r113 = r315;
        goto L39
    L33:
        r112 = r314;
        goto L35
    L29:
        r111 = r313;
        goto L31
    L25:
        r110 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L13:
        r103 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L10
    L5:
        r100 = 0;
        goto L7
    }
}
