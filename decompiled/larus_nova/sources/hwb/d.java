package hwb;

import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatSide;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f487451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingFloatSide f487452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f487453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f487454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f487455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f487456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f487457g;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f487451a == r101.f487451a) goto L12;
        return false;
    L12:
        if (this.f487452b == r101.f487452b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f487453c, r101.f487453c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f487454d, r101.f487454d) == true) goto L21;
        return false;
    L21:
        if (this.f487455e == r101.f487455e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f487456f, r101.f487456f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f487457g, r101.f487457g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f487451a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f487452b.hashCode()) * 31;
        Integer r103 = this.f487453c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Integer r107 = this.f487454d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f487455e == true) goto L18;
        r100 = 1237;
    L18:
        int r110 = (r109 + r100) * 31;
        Integer r111 = this.f487456f;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f487457g;
        if (r114 == null) goto L27;
        r104 = r114.hashCode();
    L27:
        return r113 + r104;
    L21:
        r112 = r111.hashCode();
        goto L22
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingFloatLayoutState(expanded=" + this.f487451a + ", side=" + this.f487452b + ", x=" + this.f487453c + ", y=" + this.f487454d + ", autoHideEnabled=" + this.f487455e + ", expandedX=" + this.f487456f + ", expandedY=" + this.f487457g + ')';
    }

    public /* synthetic */ d(int r100) {
        this(true, MmRecordingFloatSide.RIGHT, null, null, true, null, null);
    }

    public d(boolean r100, MmRecordingFloatSide r101, Integer r102, Integer r103, boolean r104, Integer r105, Integer r106) {
        Intrinsics.checkNotNullParameter(r101, "side");
        this.f487451a = r100;
        this.f487452b = r101;
        this.f487453c = r102;
        this.f487454d = r103;
        this.f487455e = r104;
        this.f487456f = r105;
        this.f487457g = r106;
    }
}
