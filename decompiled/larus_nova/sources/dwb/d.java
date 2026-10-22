package dwb;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingTopSlotMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingTopSlotMode f470403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f470404b;

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
        if (this.f470403a == r101.f470403a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470404b, r101.f470404b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f470403a.hashCode() * 31;
        Integer r101 = this.f470404b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmRecordingSlotsLayoutPolicy(topMode=" + this.f470403a + ", contentTopInsetPx=" + this.f470404b + ')';
    }

    public d(int r100) {
        MmRecordingTopSlotMode r101 = MmRecordingTopSlotMode.OCCUPY;
        Intrinsics.checkNotNullParameter(r101, "topMode");
        this.f470403a = r101;
        this.f470404b = null;
    }
}
