package l0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserCreation f506879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f506881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f506882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f506885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f506886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f506887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f506888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f506889k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f506890l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f506891m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f506892n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f506893o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f506894p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f506895q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f506879a, r101.f506879a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506880b, r101.f506880b) == true) goto L15;
        return false;
    L15:
        if (this.f506881c == r101.f506881c) goto L18;
        return false;
    L18:
        if (this.f506882d == r101.f506882d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506883e, r101.f506883e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506884f, r101.f506884f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f506885g, r101.f506885g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f506886h, r101.f506886h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f506887i, r101.f506887i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f506888j, r101.f506888j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f506889k, r101.f506889k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f506890l, r101.f506890l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f506891m, r101.f506891m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f506892n, r101.f506892n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f506893o, r101.f506893o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f506894p, r101.f506894p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f506895q, r101.f506895q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        UserCreation r100 = this.f506879a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f506880b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f506881c == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f506882d == true) goto L18;
        r107 = 1237;
    L18:
        int r110 = (r109 + r107) * 31;
        String r111 = this.f506883e;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f506884f;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f506885g;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f506886h;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f506887i;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f506888j;
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        int r128 = (r125 + r127) * 31;
        Integer r129 = this.f506889k;
        if (r129 != null) goto L45;
        int r130 = 0;
    L46:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f506890l;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f506891m;
        if (r135 != null) goto L53;
        int r136 = 0;
    L54:
        int r137 = (r134 + r136) * 31;
        String r138 = this.f506892n;
        if (r138 != null) goto L57;
        int r139 = 0;
    L58:
        int r140 = (r137 + r139) * 31;
        String r141 = this.f506893o;
        if (r141 != null) goto L61;
        int r142 = 0;
    L62:
        int r143 = (r140 + r142) * 31;
        String r144 = this.f506894p;
        if (r144 != null) goto L65;
        int r145 = 0;
    L66:
        int r146 = (r143 + r145) * 31;
        String r147 = this.f506895q;
        if (r147 == null) goto L71;
        r101 = r147.hashCode();
    L71:
        return r146 + r101;
    L65:
        r145 = r144.hashCode();
        goto L66
    L61:
        r142 = r141.hashCode();
        goto L62
    L57:
        r139 = r138.hashCode();
        goto L58
    L53:
        r136 = r135.hashCode();
        goto L54
    L49:
        r133 = r132.hashCode();
        goto L50
    L45:
        r130 = r129.hashCode();
        goto L46
    L41:
        r127 = r126.hashCode();
        goto L42
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MobDoSameParamsKmp(creation=" + this.f506879a + ", enterFrom=" + this.f506880b + ", isFromCaption=" + this.f506881c + ", ignoreTplInfo=" + this.f506882d + ", botId=" + this.f506883e + ", aiCreationRecommendFrom=" + this.f506884f + ", currentPage=" + this.f506885g + ", previousPage=" + this.f506886h + ", chatType=" + this.f506887i + ", conversationId=" + this.f506888j + ", actionBarTemplateId=" + this.f506889k + ", enterMethod=" + this.f506890l + ", promptType=" + this.f506891m + ", promptFrom=" + this.f506892n + ", visualSize=" + this.f506893o + ", anchorCreationId=" + this.f506894p + ", douyinGid=" + this.f506895q + ')';
    }

    public c(UserCreation r100, boolean r101, boolean r102, String r103, String r104, String r105, String r106, String r110, String r111, Integer r112, String r113, String r114, String r115, String r116, String r117, String r118) {
        this.f506879a = r100;
        this.f506880b = null;
        this.f506881c = r101;
        this.f506882d = r102;
        this.f506883e = r103;
        this.f506884f = r104;
        this.f506885g = r105;
        this.f506886h = r106;
        this.f506887i = r110;
        this.f506888j = r111;
        this.f506889k = r112;
        this.f506890l = r113;
        this.f506891m = r114;
        this.f506892n = r115;
        this.f506893o = r116;
        this.f506894p = r117;
        this.f506895q = r118;
    }
}
