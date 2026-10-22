package pea;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f528756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f528757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f528758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f528759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f528760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f528761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f528762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f528763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f528764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f528765l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f528766m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f528767n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f528768o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f528769p;

    public e() {
        this(null, null, false, null, null, 65535);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f528754a == r101.f528754a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528755b, r101.f528755b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528756c, r101.f528756c) == true) goto L18;
        return false;
    L18:
        if (this.f528757d == r101.f528757d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528758e, r101.f528758e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528759f, r101.f528759f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f528760g, r101.f528760g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f528761h, r101.f528761h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f528762i, r101.f528762i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f528763j, r101.f528763j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f528764k, r101.f528764k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f528765l, r101.f528765l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f528766m, r101.f528766m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f528767n, r101.f528767n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f528768o, r101.f528768o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f528769p, r101.f528769p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f528754a * 31;
        String r101 = this.f528755b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Intent r105 = this.f528756c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f528757d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        String r110 = this.f528758e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f528759f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f528760g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f528761h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f528762i;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f528763j;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f528764k;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f528765l;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.f528766m;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.f528767n;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f528768o;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Boolean r143 = this.f528769p;
        if (r143 == null) goto L63;
        r102 = r143.hashCode();
    L63:
        return r142 + r102;
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ExpandedButtonActionInfo(actionParamType=" + this.f528754a + ", action=" + this.f528755b + ", intent=" + this.f528756c + ", clickWithCollapse=" + this.f528757d + ", actionTitle=" + this.f528758e + ", actionTitleColor=" + this.f528759f + ", actionTitleColorDark=" + this.f528760g + ", actionBgColor=" + this.f528761h + ", actionBgColorDark=" + this.f528762i + ", actionBgPressColor=" + this.f528763j + ", actionBgPressColorDark=" + this.f528764k + ", actionIcon=" + this.f528765l + ", actionIconResId=" + this.f528766m + ", actionIntentType=" + this.f528767n + ", actionIntent=" + this.f528768o + ", dismissKeyguard=" + this.f528769p + ')';
    }

    public e(String r100, Intent r101, boolean r102, String r103, Boolean r104, int r110) {
        if ((r110 & 1) == 0) goto L5;
        int r105 = 1;
    L7:
        if ((r110 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r110 & 4) == 0) goto L13;
        r101 = null;
    L13:
        if ((r110 & 8) == 0) goto L16;
        r102 = false;
    L16:
        if ((r110 & 16) == 0) goto L19;
        r103 = null;
    L19:
        if ((r110 & 8192) == 0) goto L21;
        Integer r106 = 2;
    L23:
        if ((r110 & 32768) == 0) goto L25;
        r104 = null;
    L25:
        this.f528754a = r105;
        this.f528755b = r100;
        this.f528756c = r101;
        this.f528757d = r102;
        this.f528758e = r103;
        this.f528759f = null;
        this.f528760g = null;
        this.f528761h = null;
        this.f528762i = null;
        this.f528763j = null;
        this.f528764k = null;
        this.f528765l = null;
        this.f528766m = null;
        this.f528767n = r106;
        this.f528768o = null;
        this.f528769p = r104;
        return;
    L21:
        r106 = null;
        goto L23
    L5:
        r105 = 0;
        goto L7
    }
}
