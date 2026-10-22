package i0a;

import com.larus.platform.api.creation.UserCreation;
import com.larus.ugc.feed.api.model.CreationFeedTrackParamsKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CreationFeedTrackParamsKmp f487898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f487899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UserCreation f487900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f487901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f487902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f487903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f487904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f487905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f487906i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f487907j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f487908k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f487898a, r101.f487898a) == true) goto L12;
        return false;
    L12:
        if (this.f487899b == r101.f487899b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f487900c, r101.f487900c) == true) goto L18;
        return false;
    L18:
        if (this.f487901d == r101.f487901d) goto L21;
        return false;
    L21:
        if (this.f487902e == r101.f487902e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f487903f, r101.f487903f) == true) goto L27;
        return false;
    L27:
        if (this.f487904g == r101.f487904g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f487905h, r101.f487905h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f487906i, r101.f487906i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f487907j, r101.f487907j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f487908k, r101.f487908k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f487898a.hashCode() * 31;
        int r101 = 1231;
        if (this.f487899b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        UserCreation r104 = this.f487900c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        if (this.f487901d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.f487902e == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        Integer r112 = this.f487903f;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        if (this.f487904g == true) goto L26;
        r101 = 1237;
    L26:
        int r115 = (r114 + r101) * 31;
        String r116 = this.f487905h;
        if (r116 != null) goto L29;
        int r117 = 0;
    L30:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f487906i;
        if (r119 != null) goto L33;
        int r120 = 0;
    L34:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f487907j;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f487908k;
        if (r125 == null) goto L43;
        r105 = r125.hashCode();
    L43:
        return r124 + r105;
    L37:
        r123 = r122.hashCode();
        goto L38
    L33:
        r120 = r119.hashCode();
        goto L34
    L29:
        r117 = r116.hashCode();
        goto L30
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationDetailBottomToolsInitParamsKmp(trackParams=" + this.f487898a + ", ignoreTplInfo=" + this.f487899b + ", userCreation=" + this.f487900c + ", isFromAnchor=" + this.f487901d + ", openNewChatPageOnSend=" + this.f487902e + ", creationDoSameLandingType=" + this.f487903f + ", isSendFromDetail=" + this.f487904g + ", refImgUrl=" + this.f487905h + ", refFaceNum=" + this.f487906i + ", refWidth=" + this.f487907j + ", refHeight=" + this.f487908k + ')';
    }

    public a(CreationFeedTrackParamsKmp r100, UserCreation r101, boolean r102, Integer r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "trackParams");
        this.f487898a = r100;
        this.f487899b = false;
        this.f487900c = r101;
        this.f487901d = false;
        this.f487902e = r102;
        this.f487903f = r103;
        this.f487904g = r104;
        this.f487905h = null;
        this.f487906i = null;
        this.f487907j = null;
        this.f487908k = null;
    }
}
