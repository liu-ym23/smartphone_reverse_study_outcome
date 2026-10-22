package hwb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gwb.d f487440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingUILaunchMode f487441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gwb.a f487442d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f487439a, r101.f487439a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487440b, r101.f487440b) == true) goto L15;
        return false;
    L15:
        if (this.f487441c == r101.f487441c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f487442d, r101.f487442d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f487439a.hashCode() * 31) + this.f487440b.hashCode()) * 31) + this.f487441c.hashCode()) * 31) + this.f487442d.hashCode();
    }

    public final String toString() {
        return "MmRecordingFloatContentParams(recordingId=" + this.f487439a + ", sessionProvider=" + this.f487440b + ", uiLaunchMode=" + this.f487441c + ", actionHandler=" + this.f487442d + ')';
    }

    public b(String r100, gwb.d r101, MmRecordingUILaunchMode r102, gwb.a r103) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "sessionProvider");
        Intrinsics.checkNotNullParameter(r102, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r103, "actionHandler");
        this.f487439a = r100;
        this.f487440b = r101;
        this.f487441c = r102;
        this.f487442d = r103;
    }
}
