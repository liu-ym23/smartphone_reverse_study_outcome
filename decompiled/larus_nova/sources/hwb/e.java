package hwb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatHostType;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatLifecycleState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f487459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingFloatHostType f487460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmRecordingFloatLifecycleState f487461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f487462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmRecordingUILaunchMode f487463f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f487458a, r101.f487458a) == true) goto L12;
        return false;
    L12:
        if (this.f487459b == r101.f487459b) goto L15;
        return false;
    L15:
        if (this.f487460c == r101.f487460c) goto L18;
        return false;
    L18:
        if (this.f487461d == r101.f487461d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f487462e, r101.f487462e) == true) goto L24;
        return false;
    L24:
        if (this.f487463f == r101.f487463f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f487458a.hashCode() * 31;
        if (this.f487459b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((((r100 + r101) * 31) + this.f487460c.hashCode()) * 31) + this.f487461d.hashCode()) * 31) + this.f487462e.hashCode()) * 31) + this.f487463f.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingFloatSessionState(recordingId=" + this.f487458a + ", visible=" + this.f487459b + ", hostType=" + this.f487460c + ", lifecycleState=" + this.f487461d + ", layoutState=" + this.f487462e + ", uiLaunchMode=" + this.f487463f + ')';
    }

    public static e a(e r100, boolean r110, MmRecordingFloatLifecycleState r111, d r112, int r113) {
        MmRecordingUILaunchMode r101 = null;
        if ((r113 & 1) == 0) goto L5;
        String r102 = r100.f487458a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r110 = r100.f487459b;
    L9:
        boolean r103 = r110;
        if ((r113 & 4) == 0) goto L12;
        MmRecordingFloatHostType r104 = r100.f487460c;
    L14:
        if ((r113 & 8) == 0) goto L16;
        r111 = r100.f487461d;
    L16:
        MmRecordingFloatLifecycleState r105 = r111;
        if ((r113 & 16) == 0) goto L19;
        r112 = r100.f487462e;
    L19:
        d r106 = r112;
        if ((r113 & 32) == 0) goto L22;
        r101 = r100.f487463f;
    L22:
        MmRecordingUILaunchMode r107 = r101;
        Intrinsics.checkNotNullParameter(r102, "recordingId");
        Intrinsics.checkNotNullParameter(r104, "hostType");
        Intrinsics.checkNotNullParameter(r105, "lifecycleState");
        Intrinsics.checkNotNullParameter(r106, "layoutState");
        Intrinsics.checkNotNullParameter(r107, "uiLaunchMode");
        return new e(r102, r103, r104, r105, r106, r107);
    L12:
        r104 = null;
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    public e(String r100, boolean r101, MmRecordingFloatHostType r102, MmRecordingFloatLifecycleState r103, d r104, MmRecordingUILaunchMode r105) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r102, "hostType");
        Intrinsics.checkNotNullParameter(r103, "lifecycleState");
        Intrinsics.checkNotNullParameter(r104, "layoutState");
        Intrinsics.checkNotNullParameter(r105, "uiLaunchMode");
        this.f487458a = r100;
        this.f487459b = r101;
        this.f487460c = r102;
        this.f487461d = r103;
        this.f487462e = r104;
        this.f487463f = r105;
    }
}
