package r21;

import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.t5;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f535714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f535716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<IBattleRivalTag> f535717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f535718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f535719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f535720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f535721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<t5> f535722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f535723j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f535724k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f535725l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Long> f535726m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f535727n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Boolean f535728o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Boolean f535729p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Boolean f535730q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Runnable f535731r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f535732s;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L44;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f535714a, r101.f535714a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f535715b, r101.f535715b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f535716c, r101.f535716c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535717d, r101.f535717d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f535718e, r101.f535718e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f535719f, r101.f535719f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f535720g, r101.f535720g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f535721h, r101.f535721h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f535722i, r101.f535722i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f535723j, r101.f535723j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f535724k, r101.f535724k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f535725l, r101.f535725l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f535726m, r101.f535726m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f535727n, r101.f535727n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f535728o, r101.f535728o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f535729p, r101.f535729p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f535730q, r101.f535730q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f535731r, r101.f535731r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f535732s, r101.f535732s) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    public final int hashCode() {
        k r100 = this.f535714a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f535715b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f535716c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<IBattleRivalTag> r110 = this.f535717d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f535718e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f535719f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.f535720g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f535721h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<t5> r125 = this.f535722i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f535723j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.f535724k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.f535725l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Map<String, Long> r137 = this.f535726m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f535727n;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Boolean r143 = this.f535728o;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Boolean r146 = this.f535729p;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.f535730q;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        Runnable r152 = this.f535731r;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.f535732s;
        if (r155 == null) goto L78;
        r101 = r155.hashCode();
    L78:
        return r154 + r101;
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorLinkUserUiState(avatarThumb=" + this.f535714a + ", nickName=" + this.f535715b + ", gender=" + this.f535716c + ", battleRivalTags=" + this.f535717d + ", inviteType=" + this.f535718e + ", userCount=" + this.f535719f + ", followCount=" + this.f535720g + ", pannelOpt=" + this.f535721h + ", linkedUserInfos=" + this.f535722i + ", roomInVoteMode=" + this.f535723j + ", roomInBreakThrough=" + this.f535724k + ", roomInPkMode=" + this.f535725l + ", linkMap=" + this.f535726m + ", linkText=" + this.f535727n + ", inApplicantList=" + this.f535728o + ", inInviteeList=" + this.f535729p + ", fromBanner=" + this.f535730q + ", inviteOrApplyHandler=" + this.f535731r + ", roomStatusDesc=" + this.f535732s + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(k r100, String r101, Integer r102, List<? extends IBattleRivalTag> r103, Integer r104, Integer r105, Long r106, Boolean r110, List<? extends t5> r111, Boolean r112, Boolean r113, Boolean r114, Map<String, Long> r115, String r116, Boolean r117, Boolean r118, Boolean r119, Runnable r210, String r211) {
        this.f535714a = r100;
        this.f535715b = r101;
        this.f535716c = r102;
        this.f535717d = r103;
        this.f535718e = r104;
        this.f535719f = r105;
        this.f535720g = r106;
        this.f535721h = r110;
        this.f535722i = r111;
        this.f535723j = r112;
        this.f535724k = r113;
        this.f535725l = r114;
        this.f535726m = r115;
        this.f535727n = r116;
        this.f535728o = r117;
        this.f535729p = r118;
        this.f535730q = r119;
        this.f535731r = r210;
        this.f535732s = r211;
    }
}
