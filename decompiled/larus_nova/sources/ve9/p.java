package ve9;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f554510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f554511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f554512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f554513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f554514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f554515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f554516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f554517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f554518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f554519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f554520l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f554521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f554522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f554523o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f554524p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f554525q;

    public p() {
        this(null, null, false, 0, 0, null, null, 0.0f, 0, null, null, false, null, null, null, null, 131071);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f554509a, r101.f554509a) == true) goto L12;
        return false;
    L12:
        if (this.f554510b == r101.f554510b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554511c, r101.f554511c) == true) goto L18;
        return false;
    L18:
        if (this.f554512d == r101.f554512d) goto L21;
        return false;
    L21:
        if (this.f554513e == r101.f554513e) goto L24;
        return false;
    L24:
        if (this.f554514f == r101.f554514f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f554515g, r101.f554515g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f554516h, r101.f554516h) == true) goto L33;
        return false;
    L33:
        if (Float.compare(this.f554517i, r101.f554517i) == 0) goto L36;
        return false;
    L36:
        if (this.f554518j == r101.f554518j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f554519k, r101.f554519k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f554520l, r101.f554520l) == true) goto L45;
        return false;
    L45:
        if (this.f554521m == r101.f554521m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f554522n, r101.f554522n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f554523o, r101.f554523o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f554524p, r101.f554524p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f554525q, r101.f554525q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f554509a.hashCode() * 31) + this.f554510b) * 31) + this.f554511c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f554512d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((((((((((r100 + r102) * 31) + this.f554513e) * 31) + this.f554514f) * 31) + this.f554515g.hashCode()) * 31) + this.f554516h.hashCode()) * 31) + Float.floatToIntBits(this.f554517i)) * 31) + this.f554518j) * 31) + this.f554519k.hashCode()) * 31) + this.f554520l.hashCode()) * 31;
        if (this.f554521m == true) goto L11;
        r101 = 1237;
    L11:
        return ((((((((r103 + r101) * 31) + this.f554522n.hashCode()) * 31) + this.f554523o.hashCode()) * 31) + this.f554524p.hashCode()) * 31) + this.f554525q.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "TtsConfig(format=" + this.f554509a + ", channel=" + this.f554510b + ", styleName=" + this.f554511c + ", enableNetTransportCompress=" + this.f554512d + ", bitRate=" + this.f554513e + ", sampleRate=" + this.f554514f + ", audioMetrics=" + this.f554515g + ", deviceAIData=" + this.f554516h + ", targetLufs=" + this.f554517i + ", loudNormAlgoType=" + this.f554518j + ", loudnessAudioDumpPath=" + this.f554519k + ", extra=" + this.f554520l + ", enablePlayer=" + this.f554521m + ", siSrcLanguage=" + this.f554522n + ", siDstLanguage=" + this.f554523o + ", siScene=" + this.f554524p + ", needSpeakerClone=" + this.f554525q + ')';
    }

    public /* synthetic */ p(String r210, String r211, boolean r212, int r213, int r214, String r215, String r216, float r217, int r218, String r310, String r311, boolean r312, String r313, String r314, String r315, String r316, int r317) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = "pcm";
    L7:
        if ((r317 & 2) == 0) goto L9;
        int r101 = 1;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = "zh_female_sophie_conversation_wvae_bigtts";
    L15:
        if ((r317 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r317 & 16) == 0) goto L21;
        int r104 = 32000;
    L23:
        if ((r317 & 32) == 0) goto L25;
        int r105 = 24000;
    L27:
        if ((r317 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r317 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r317 & 256) == 0) goto L37;
        float r111 = 0.0f;
    L39:
        if ((r317 & 512) == 0) goto L41;
        int r112 = 0;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r317 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r317 & 4096) == 0) goto L53;
        boolean r115 = false;
    L55:
        if ((r317 & 8192) == 0) goto L57;
        String r116 = "zh";
    L59:
        if ((r317 & 16384) == 0) goto L61;
        String r117 = "en";
    L63:
        if ((32768 & r317) == 0) goto L65;
        String r118 = "FaceToFace";
    L67:
        if ((r317 & 65536) == 0) goto L69;
        String r119 = "";
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
        return;
    L69:
        r119 = r316;
        goto L70
    L65:
        r118 = r315;
        goto L67
    L61:
        r117 = r314;
        goto L63
    L57:
        r116 = r313;
        goto L59
    L53:
        r115 = r312;
        goto L55
    L49:
        r114 = r311;
        goto L51
    L45:
        r113 = r310;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r110 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public p(String r110, int r111, String r112, boolean r113, int r114, int r115, String r116, String r210, float r211, int r212, String r213, String r214, boolean r215, String r216, String r217, String r218, String r219) {
        Intrinsics.checkNotNullParameter(r110, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r112, "styleName");
        Intrinsics.checkNotNullParameter(r116, "audioMetrics");
        Intrinsics.checkNotNullParameter(r210, "deviceAIData");
        Intrinsics.checkNotNullParameter(r213, "loudnessAudioDumpPath");
        Intrinsics.checkNotNullParameter(r214, "extra");
        Intrinsics.checkNotNullParameter(r216, "siSrcLanguage");
        Intrinsics.checkNotNullParameter(r217, "siDstLanguage");
        Intrinsics.checkNotNullParameter(r218, "siScene");
        Intrinsics.checkNotNullParameter(r219, "needSpeakerClone");
        this.f554509a = r110;
        this.f554510b = r111;
        this.f554511c = r112;
        this.f554512d = r113;
        this.f554513e = r114;
        this.f554514f = r115;
        this.f554515g = r116;
        this.f554516h = r210;
        this.f554517i = r211;
        this.f554518j = r212;
        this.f554519k = r213;
        this.f554520l = r214;
        this.f554521m = r215;
        this.f554522n = r216;
        this.f554523o = r217;
        this.f554524p = r218;
        this.f554525q = r219;
    }
}
