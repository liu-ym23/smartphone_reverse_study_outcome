package com.larus.kmp.voice_setting.voice.list.row;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceAvatarFallback f353687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f353688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f353689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VoiceAddButtonState f353690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f353691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f353692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f353693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f353694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f353695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f353696l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final VoiceStatusTone f353697m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f353698n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final VoicePermissionBadge f353699o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f353700p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f353701q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f353702r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final VoiceSelectionState f353703s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f353704t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final VoicePlayIndicatorPlacement f353705u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f353706v;

    public u() {
        this(false, 4194303);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f353685a, r101.f353685a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353686b, r101.f353686b) == true) goto L15;
        return false;
    L15:
        if (this.f353687c == r101.f353687c) goto L18;
        return false;
    L18:
        if (this.f353688d == r101.f353688d) goto L21;
        return false;
    L21:
        if (this.f353689e == r101.f353689e) goto L24;
        return false;
    L24:
        if (this.f353690f == r101.f353690f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f353691g, r101.f353691g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f353692h, r101.f353692h) == true) goto L33;
        return false;
    L33:
        if (this.f353693i == r101.f353693i) goto L36;
        return false;
    L36:
        if (this.f353694j == r101.f353694j) goto L39;
        return false;
    L39:
        if (this.f353695k == r101.f353695k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f353696l, r101.f353696l) == true) goto L45;
        return false;
    L45:
        if (this.f353697m == r101.f353697m) goto L48;
        return false;
    L48:
        if (this.f353698n == r101.f353698n) goto L51;
        return false;
    L51:
        if (this.f353699o == r101.f353699o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f353700p, r101.f353700p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f353701q, r101.f353701q) == true) goto L60;
        return false;
    L60:
        if (this.f353702r == r101.f353702r) goto L63;
        return false;
    L63:
        if (this.f353703s == r101.f353703s) goto L66;
        return false;
    L66:
        if (this.f353704t == r101.f353704t) goto L69;
        return false;
    L69:
        if (this.f353705u == r101.f353705u) goto L72;
        return false;
    L72:
        if (this.f353706v == r101.f353706v) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f353685a.hashCode() * 31) + this.f353686b.hashCode()) * 31) + this.f353687c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f353688d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f353689e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((((r103 + r104) * 31) + this.f353690f.hashCode()) * 31) + this.f353691g.hashCode()) * 31) + this.f353692h.hashCode()) * 31;
        if (this.f353693i == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f353694j == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f353695k == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (((((r109 + r110) * 31) + this.f353696l.hashCode()) * 31) + this.f353697m.hashCode()) * 31;
        if (this.f353698n == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (((((((r111 + r112) * 31) + this.f353699o.hashCode()) * 31) + this.f353700p.hashCode()) * 31) + this.f353701q.hashCode()) * 31;
        if (this.f353702r == false) goto L29;
        int r114 = 1231;
    L30:
        int r115 = (((r113 + r114) * 31) + this.f353703s.hashCode()) * 31;
        if (this.f353704t == false) goto L33;
        int r116 = 1231;
    L34:
        int r117 = (((r115 + r116) * 31) + this.f353705u.hashCode()) * 31;
        if (this.f353706v == true) goto L39;
        r101 = 1237;
    L39:
        return r117 + r101;
    L33:
        r116 = 1237;
        goto L34
    L29:
        r114 = 1237;
        goto L30
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PublicVoiceItemUiState(voiceName=" + this.f353685a + ", avatarUrl=" + this.f353686b + ", avatarFallback=" + this.f353687c + ", showAvatar=" + this.f353688d + ", showMoreButton=" + this.f353689e + ", addButtonState=" + this.f353690f + ", bestMatchLabelText=" + this.f353691g + ", labelItems=" + this.f353692h + ", showReviewArea=" + this.f353693i + ", showStatusErrorIcon=" + this.f353694j + ", showStatusLoading=" + this.f353695k + ", statusText=" + this.f353696l + ", statusTone=" + this.f353697m + ", showCreateArea=" + this.f353698n + ", permissionBadge=" + this.f353699o + ", permissionText=" + this.f353700p + ", dateText=" + this.f353701q + ", showSelectionControls=" + this.f353702r + ", selectionState=" + this.f353703s + ", showPlayingIndicator=" + this.f353704t + ", playIndicatorPlacement=" + this.f353705u + ", dividerVisible=" + this.f353706v + ')';
    }

    public /* synthetic */ u(boolean r210, int r211) {
        VoicePlayIndicatorPlacement r100 = null;
        if ((r211 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r211 & 4) == 0) goto L13;
        VoiceAvatarFallback r103 = VoiceAvatarFallback.DEFAULT;
    L15:
        if ((r211 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r211 & 32) == 0) goto L21;
        VoiceAddButtonState r110 = VoiceAddButtonState.HIDDEN;
    L23:
        if ((r211 & 64) == 0) goto L25;
        String r111 = "";
    L27:
        if ((r211 & 128) == 0) goto L29;
        List r112 = CollectionsKt.emptyList();
    L31:
        if ((r211 & 2048) == 0) goto L33;
        String r113 = "";
    L35:
        if ((r211 & 4096) == 0) goto L37;
        VoiceStatusTone r114 = VoiceStatusTone.DANGER;
    L39:
        if ((r211 & 16384) == 0) goto L41;
        VoicePermissionBadge r115 = VoicePermissionBadge.NONE;
    L43:
        if ((32768 & r211) == 0) goto L45;
        String r212 = "";
    L47:
        if ((65536 & r211) == 0) goto L49;
        String r213 = "";
    L51:
        if ((262144 & r211) == 0) goto L53;
        VoiceSelectionState r214 = VoiceSelectionState.UNSELECTED;
    L55:
        if ((1048576 & r211) == 0) goto L57;
        r100 = VoicePlayIndicatorPlacement.NONE;
    L57:
        VoicePlayIndicatorPlacement r215 = r100;
        if ((r211 & 2097152) == 0) goto L60;
        boolean r216 = false;
    L61:
        this(r101, r102, r103, r104, false, r110, r111, r112, false, false, false, r113, r114, false, r115, r212, r213, false, r214, false, r215, r216);
        return;
    L60:
        r216 = r210;
        goto L61
    L53:
        r214 = null;
        goto L55
    L49:
        r213 = null;
        goto L51
    L45:
        r212 = null;
        goto L47
    L41:
        r115 = null;
        goto L43
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = null;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r111 = null;
        goto L27
    L21:
        r110 = null;
        goto L23
    L17:
        r104 = false;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public u(String r110, String r111, VoiceAvatarFallback r112, boolean r113, boolean r210, VoiceAddButtonState r211, String r212, List<String> r213, boolean r214, boolean r215, boolean r216, String r217, VoiceStatusTone r218, boolean r219, VoicePermissionBadge r310, String r311, String r312, boolean r313, VoiceSelectionState r314, boolean r315, VoicePlayIndicatorPlacement r316, boolean r317) {
        Intrinsics.checkNotNullParameter(r110, "voiceName");
        Intrinsics.checkNotNullParameter(r111, "avatarUrl");
        Intrinsics.checkNotNullParameter(r112, "avatarFallback");
        Intrinsics.checkNotNullParameter(r211, "addButtonState");
        Intrinsics.checkNotNullParameter(r212, "bestMatchLabelText");
        Intrinsics.checkNotNullParameter(r213, "labelItems");
        Intrinsics.checkNotNullParameter(r217, "statusText");
        Intrinsics.checkNotNullParameter(r218, "statusTone");
        Intrinsics.checkNotNullParameter(r310, "permissionBadge");
        Intrinsics.checkNotNullParameter(r311, "permissionText");
        Intrinsics.checkNotNullParameter(r312, "dateText");
        Intrinsics.checkNotNullParameter(r314, "selectionState");
        Intrinsics.checkNotNullParameter(r316, "playIndicatorPlacement");
        this.f353685a = r110;
        this.f353686b = r111;
        this.f353687c = r112;
        this.f353688d = r113;
        this.f353689e = r210;
        this.f353690f = r211;
        this.f353691g = r212;
        this.f353692h = r213;
        this.f353693i = r214;
        this.f353694j = r215;
        this.f353695k = r216;
        this.f353696l = r217;
        this.f353697m = r218;
        this.f353698n = r219;
        this.f353699o = r310;
        this.f353700p = r311;
        this.f353701q = r312;
        this.f353702r = r313;
        this.f353703s = r314;
        this.f353704t = r315;
        this.f353705u = r316;
        this.f353706v = r317;
    }
}
