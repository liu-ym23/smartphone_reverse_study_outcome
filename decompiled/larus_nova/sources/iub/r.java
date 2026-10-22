package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingState f495878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingState f495879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmRecordingError f495880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f495881e;

    public r() {
        this(null, null, null, false, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f495877a, r101.f495877a) == true) goto L12;
        return false;
    L12:
        if (this.f495878b == r101.f495878b) goto L15;
        return false;
    L15:
        if (this.f495879c == r101.f495879c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495880d, r101.f495880d) == true) goto L21;
        return false;
    L21:
        if (this.f495881e == r101.f495881e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f495877a.hashCode() * 31) + this.f495878b.hashCode()) * 31) + this.f495879c.hashCode()) * 31;
        MmRecordingError r101 = this.f495880d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f495881e == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingStateData(recordingId=" + this.f495877a + ", currentState=" + this.f495878b + ", lastState=" + this.f495879c + ", error=" + this.f495880d + ", isAllRecordingFinished=" + this.f495881e + ')';
    }

    public r(String r100, MmRecordingState r101, MmRecordingState r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = MmRecordingState.IDLE;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = MmRecordingState.IDLE;
    L12:
        if ((r104 & 16) == 0) goto L14;
        r103 = false;
    L14:
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "currentState");
        Intrinsics.checkNotNullParameter(r102, "lastState");
        this.f495877a = r100;
        this.f495878b = r101;
        this.f495879c = r102;
        this.f495880d = null;
        this.f495881e = r103;
    }
}
