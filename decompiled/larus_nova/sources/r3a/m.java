package r3a;

import com.larus.im.internal.delegate.w;
import com.larus.im.service.audio.AudioSessionType;
import com.obric.sva.sdk.utils.InteractConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f535937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f535938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f535939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f535940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f535941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f535942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f535943g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f535944h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f535945i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AudioSessionType f535946j;

    public m() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f535937a == r101.f535937a) goto L12;
        return false;
    L12:
        if (this.f535938b == r101.f535938b) goto L15;
        return false;
    L15:
        if (this.f535939c == r101.f535939c) goto L18;
        return false;
    L18:
        if (this.f535940d == r101.f535940d) goto L21;
        return false;
    L21:
        if (this.f535941e == r101.f535941e) goto L24;
        return false;
    L24:
        if (this.f535942f == r101.f535942f) goto L27;
        return false;
    L27:
        if (Float.compare(this.f535943g, r101.f535943g) == 0) goto L30;
        return false;
    L30:
        if (this.f535944h == r101.f535944h) goto L33;
        return false;
    L33:
        if (this.f535945i == r101.f535945i) goto L36;
        return false;
    L36:
        if (this.f535946j == r101.f535946j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f535937a * 31) + this.f535938b) * 31) + this.f535939c) * 31;
        int r101 = 1231;
        if (this.f535940d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f535941e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f535942f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((r105 + r106) * 31) + Float.floatToIntBits(this.f535943g)) * 31;
        if (this.f535944h == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f535945i == true) goto L23;
        r101 = 1237;
    L23:
        return ((r109 + r101) * 31) + this.f535946j.hashCode();
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
        return "RealtimeCameraConfig(previewWidth=" + this.f535937a + ", previewHeight=" + this.f535938b + ", fps=" + this.f535939c + ", isFrontCamera=" + this.f535940d + ", enableAntiShake=" + this.f535941e + ", enableVideoAntiShake=" + this.f535942f + ", defaultZoomRatio=" + this.f535943g + ", enableFallback=" + this.f535944h + ", enablePreviewingFallback=" + this.f535945i + ", sessionType=" + this.f535946j + ')';
    }

    public m(int r110) {
        this(w.n().f348432a, w.n().f348433b, w.n().f348434c, false, false, false, 1.0f, true, true, AudioSessionType.RTC);
    }

    public m(int r100, int r101, int r102, boolean r103, boolean r104, boolean r105, float r106, boolean r107, boolean r110, AudioSessionType r111) {
        Intrinsics.checkNotNullParameter(r111, InteractConst.WAKEUP_SESSION_TYPE);
        this.f535937a = r100;
        this.f535938b = r101;
        this.f535939c = r102;
        this.f535940d = r103;
        this.f535941e = r104;
        this.f535942f = r105;
        this.f535943g = r106;
        this.f535944h = r107;
        this.f535945i = r110;
        this.f535946j = r111;
    }
}
