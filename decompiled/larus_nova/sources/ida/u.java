package ida;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.ss.android.cert.manager.constants.EventConstant;
import hda.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class u extends com.obric.assistant.cocreationreview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleKey f489434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f489436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f489437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f489438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f489439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f489440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f489441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f489442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f489443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f489444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e1 f489445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f489446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f489447o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f489433a, r101.f489433a) == true) goto L12;
        return false;
    L12:
        if (this.f489434b == r101.f489434b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489435c, r101.f489435c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489436d, r101.f489436d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489437e, r101.f489437e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489438f, r101.f489438f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f489439g, r101.f489439g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f489440h, r101.f489440h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f489441i, r101.f489441i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f489442j, r101.f489442j) == true) goto L39;
        return false;
    L39:
        if (this.f489443k == r101.f489443k) goto L42;
        return false;
    L42:
        if (this.f489444l == r101.f489444l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f489445m, r101.f489445m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f489446n, r101.f489446n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f489447o, r101.f489447o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f489433a.hashCode() * 31) + this.f489434b.hashCode()) * 31) + this.f489435c.hashCode()) * 31) + this.f489436d.hashCode()) * 31;
        String r101 = this.f489437e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f489438f.hashCode()) * 31) + this.f489439g.hashCode()) * 31;
        String r105 = this.f489440h;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f489441i;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f489442j;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        int r114 = 1231;
        if (this.f489443k == false) goto L21;
        int r115 = 1231;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f489444l == true) goto L26;
        r114 = 1237;
    L26:
        int r117 = (((((r116 + r114) * 31) + this.f489445m.hashCode()) * 31) + this.f489446n.hashCode()) * 31;
        String r118 = this.f489447o;
        if (r118 == null) goto L31;
        r102 = r118.hashCode();
    L31:
        return r117 + r102;
    L21:
        r115 = 1237;
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioMemoryUsageRecord(id=" + this.f489433a + ", module=" + this.f489434b + ", heardAt=" + this.f489435c + ", audioDomain=" + this.f489436d + ", audioScenario=" + this.f489437e + ", audioTitle=" + this.f489438f + ", audioSummary=" + this.f489439g + ", audioFileName=" + this.f489440h + ", audioTranscriptText=" + this.f489441i + ", audioTranscriptContentUrl=" + this.f489442j + ", usesChunkedTranscript=" + this.f489443k + ", hasLegacyOriginalRecording=" + this.f489444l + ", uiModel=" + this.f489445m + ", payload=" + this.f489446n + ", traceJson=" + this.f489447o + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.f489433a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.f489434b;
    }

    public u(String r110, ModuleKey r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, boolean r210, boolean r211, e1 r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r112, "heardAt");
        Intrinsics.checkNotNullParameter("环境人声", "audioDomain");
        Intrinsics.checkNotNullParameter(r114, "audioTitle");
        Intrinsics.checkNotNullParameter(r115, "audioSummary");
        Intrinsics.checkNotNullParameter(r212, "uiModel");
        Intrinsics.checkNotNullParameter(r213, WsConstants.KEY_PAYLOAD);
        this.f489433a = r110;
        this.f489434b = r111;
        this.f489435c = r112;
        this.f489436d = "环境人声";
        this.f489437e = r113;
        this.f489438f = r114;
        this.f489439g = r115;
        this.f489440h = r116;
        this.f489441i = r117;
        this.f489442j = r118;
        this.f489443k = r210;
        this.f489444l = r211;
        this.f489445m = r212;
        this.f489446n = r213;
        this.f489447o = r214;
    }
}
