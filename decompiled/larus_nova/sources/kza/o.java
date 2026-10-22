package kza;

import com.ss.android.lark.biz.officesdk.im.mediapreview.OpenFeishuGalleryPermissionState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f506790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f506791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f506792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f506793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f506794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f506795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t f506796g;

    public o() {
        this(0, false, false, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f506790a == r101.f506790a) goto L12;
        return false;
    L12:
        if (this.f506791b == r101.f506791b) goto L15;
        return false;
    L15:
        if (this.f506792c == r101.f506792c) goto L18;
        return false;
    L18:
        if (this.f506793d == r101.f506793d) goto L21;
        return false;
    L21:
        if (this.f506794e == r101.f506794e) goto L24;
        return false;
    L24:
        if (this.f506795f == r101.f506795f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f506796g, r101.f506796g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f506790a * 31;
        int r101 = 1231;
        if (this.f506791b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f506792c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f506793d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f506794e == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f506795f == true) goto L22;
        r101 = 1237;
    L22:
        int r110 = (r109 + r101) * 31;
        t r111 = this.f506796g;
        if (r111 != null) goto L25;
        int r112 = 0;
    L27:
        return r110 + r112;
    L25:
        r112 = r111.hashCode();
        goto L27
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
        return "OpenFeishuGallerySecurityContext(receiveAuthorizationStateValue=" + this.f506790a + ", hasReceivePermission=" + this.f506791b + ", isResourceCleaned=" + this.f506792c + ", isCSAMDeleted=" + this.f506793d + ", isKnownRiskFile=" + this.f506794e + ", isShareDisabled=" + this.f506795f + ", mediaSecurityRequest=" + this.f506796g + ')';
    }

    public o(int r100, boolean r101, boolean r102, t r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = OpenFeishuGalleryPermissionState.NORMAL_STATE.getValue();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 64) == 0) goto L14;
        r103 = null;
    L14:
        this.f506790a = r100;
        this.f506791b = r101;
        this.f506792c = r102;
        this.f506793d = false;
        this.f506794e = false;
        this.f506795f = false;
        this.f506796g = r103;
    }
}
