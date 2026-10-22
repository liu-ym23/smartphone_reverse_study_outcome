package eh9;

import com.larus.kmp.voice_setting.voice.list.row.VoicePlayIndicatorPlacement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f472682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f472683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f472684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f472685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f472686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f472687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f472688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final VoicePlayIndicatorPlacement f472689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f472690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f472691j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f472692k;

    public c() {
        this(false, false, false, null, null, null, false, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f472682a == r101.f472682a) goto L12;
        return false;
    L12:
        if (this.f472683b == r101.f472683b) goto L15;
        return false;
    L15:
        if (this.f472684c == r101.f472684c) goto L18;
        return false;
    L18:
        if (this.f472685d == r101.f472685d) goto L21;
        return false;
    L21:
        if (this.f472686e == r101.f472686e) goto L24;
        return false;
    L24:
        if (this.f472687f == r101.f472687f) goto L27;
        return false;
    L27:
        if (this.f472688g == r101.f472688g) goto L30;
        return false;
    L30:
        if (this.f472689h == r101.f472689h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f472690i, r101.f472690i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f472691j, r101.f472691j) == true) goto L39;
        return false;
    L39:
        if (this.f472692k == r101.f472692k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f472682a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f472683b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f472684c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f472685d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f472686e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f472687f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f472688g == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (((((((r112 + r113) * 31) + this.f472689h.hashCode()) * 31) + this.f472690i.hashCode()) * 31) + this.f472691j.hashCode()) * 31;
        if (this.f472692k == true) goto L35;
        r100 = 1237;
    L35:
        return r114 + r100;
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PublicVoiceRowRenderConfig(allowOwnedMoreButton=" + this.f472682a + ", showTagList=" + this.f472683b + ", showHotBadge=" + this.f472684c + ", showSelectionControls=" + this.f472685d + ", canUseAddButton=" + this.f472686e + ", canAddMixVoice=" + this.f472687f + ", hideAddWhenCannotMix=" + this.f472688g + ", playIndicatorPlacement=" + this.f472689h + ", bestMatchLabelText=" + this.f472690i + ", privatePermissionText=" + this.f472691j + ", dividerVisible=" + this.f472692k + ')';
    }

    public /* synthetic */ c(boolean r110, boolean r111, boolean r112, VoicePlayIndicatorPlacement r113, String r210, String r211, boolean r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r213 & 4) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r213 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r213 & 128) == 0) goto L17;
        VoicePlayIndicatorPlacement r114 = VoicePlayIndicatorPlacement.NONE;
    L19:
        if ((r213 & 256) == 0) goto L21;
        String r115 = "";
    L23:
        if ((r213 & 512) == 0) goto L25;
        String r116 = "";
    L27:
        if ((r213 & 1024) == 0) goto L29;
        boolean r117 = false;
    L30:
        this(r100, false, r101, r102, false, false, false, r114, r115, r116, r117);
        return;
    L29:
        r117 = r212;
        goto L30
    L25:
        r116 = r211;
        goto L27
    L21:
        r115 = r210;
        goto L23
    L17:
        r114 = r113;
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

    public c(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, VoicePlayIndicatorPlacement r107, String r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r107, "playIndicatorPlacement");
        Intrinsics.checkNotNullParameter(r110, "bestMatchLabelText");
        Intrinsics.checkNotNullParameter(r111, "privatePermissionText");
        this.f472682a = r100;
        this.f472683b = r101;
        this.f472684c = r102;
        this.f472685d = r103;
        this.f472686e = r104;
        this.f472687f = r105;
        this.f472688g = r106;
        this.f472689h = r107;
        this.f472690i = r110;
        this.f472691j = r111;
        this.f472692k = r112;
    }
}
