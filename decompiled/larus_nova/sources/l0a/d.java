package l0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f506896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f506897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UserCreation f506898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f506902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f506903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f506904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f506905j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f506896a == r101.f506896a) goto L12;
        return false;
    L12:
        if (this.f506897b == r101.f506897b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506898c, r101.f506898c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506899d, r101.f506899d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506900e, r101.f506900e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506901f, r101.f506901f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f506902g, r101.f506902g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f506903h, r101.f506903h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f506904i, r101.f506904i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f506905j, r101.f506905j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f506896a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f506897b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        UserCreation r104 = this.f506898c;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f506899d;
        if (r108 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f506900e;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f506901f;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f506902g;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f506903h;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f506904i;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f506905j;
        if (r126 == null) goto L43;
        r105 = r126.hashCode();
    L43:
        return r125 + r105;
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
    L17:
        r109 = r108.hashCode();
        goto L18
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MobLikeActionParamsKmp(currentlyLiked=" + this.f506896a + ", doubleTap=" + this.f506897b + ", creation=" + this.f506898c + ", botId=" + this.f506899d + ", aiCreationRecommendFrom=" + this.f506900e + ", currentPage=" + this.f506901f + ", previousPage=" + this.f506902g + ", chatType=" + this.f506903h + ", conversationId=" + this.f506904i + ", templateShowEnterMethod=" + this.f506905j + ')';
    }

    public d(boolean r100, UserCreation r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108) {
        this.f506896a = r100;
        this.f506897b = false;
        this.f506898c = r101;
        this.f506899d = r102;
        this.f506900e = r103;
        this.f506901f = r104;
        this.f506902g = r105;
        this.f506903h = r106;
        this.f506904i = r107;
        this.f506905j = r108;
    }
}
