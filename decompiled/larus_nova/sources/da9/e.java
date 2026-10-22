package da9;

import com.larus.flow.capture.model.QualityPreference;
import com.ss.android.ttvecamera.TECameraUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QualityPreference f467727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f467728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f467729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f467730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f467731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f467732f;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f467727a == r101.f467727a) goto L12;
        return false;
    L12:
        if (this.f467728b == r101.f467728b) goto L15;
        return false;
    L15:
        if (this.f467729c == r101.f467729c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f467730d, r101.f467730d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f467731e, r101.f467731e) == true) goto L24;
        return false;
    L24:
        if (this.f467732f == r101.f467732f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f467727a.hashCode() * 31) + this.f467728b) * 31) + this.f467729c) * 31) + this.f467730d.hashCode()) * 31) + this.f467731e.hashCode()) * 31;
        if (this.f467732f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ScreenSharePolicy(qualityPreference=" + this.f467727a + ", minFps=" + this.f467728b + ", maxFps=" + this.f467729c + ", minResolution=" + this.f467730d + ", maxResolution=" + this.f467731e + ", enablePrivacyMask=" + this.f467732f + ')';
    }

    public e(int r100) {
        QualityPreference r101 = QualityPreference.CLEAR;
        c r102 = new c("540p", 540, 960);
        c r103 = new c("1080p", 1080, TECameraUtils.CAPTURE_NORMAL);
        Intrinsics.checkNotNullParameter(r101, "qualityPreference");
        Intrinsics.checkNotNullParameter(r102, "minResolution");
        Intrinsics.checkNotNullParameter(r103, "maxResolution");
        this.f467727a = r101;
        this.f467728b = 15;
        this.f467729c = 30;
        this.f467730d = r102;
        this.f467731e = r103;
        this.f467732f = false;
    }
}
