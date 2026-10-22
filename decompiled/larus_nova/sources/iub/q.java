package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingState f495870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmRecordingState f495871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MmRecordingSource f495872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f495873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f495874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MmRecordingError f495875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f495876i;

    public q() {
        MmRecordingSource r100 = null;
        this(r100, false, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f495868a, r101.f495868a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495869b, r101.f495869b) == true) goto L15;
        return false;
    L15:
        if (this.f495870c == r101.f495870c) goto L18;
        return false;
    L18:
        if (this.f495871d == r101.f495871d) goto L21;
        return false;
    L21:
        if (this.f495872e == r101.f495872e) goto L24;
        return false;
    L24:
        if (this.f495873f == r101.f495873f) goto L27;
        return false;
    L27:
        if (this.f495874g == r101.f495874g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f495875h, r101.f495875h) == true) goto L33;
        return false;
    L33:
        if (this.f495876i == r101.f495876i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f495868a.hashCode() * 31) + this.f495869b.hashCode()) * 31) + this.f495870c.hashCode()) * 31) + this.f495871d.hashCode()) * 31;
        MmRecordingSource r101 = this.f495872e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f495873f == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f495874g == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        MmRecordingError r110 = this.f495875h;
        if (r110 == null) goto L18;
        r102 = r110.hashCode();
    L18:
        int r111 = (r109 + r102) * 31;
        if (this.f495876i == true) goto L23;
        r105 = 1237;
    L23:
        return r111 + r105;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingSessionInfo(recordingId=" + this.f495868a + ", minutesToken=" + this.f495869b + ", currentState=" + this.f495870c + ", lastState=" + this.f495871d + ", source=" + this.f495872e + ", isRealtimeRecording=" + this.f495873f + ", isActive=" + this.f495874g + ", error=" + this.f495875h + ", isAllRecordingFinished=" + this.f495876i + ')';
    }

    public /* synthetic */ q(MmRecordingSource r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r112 & 4) == 0) goto L13;
        MmRecordingState r102 = MmRecordingState.IDLE;
    L15:
        if ((r112 & 8) == 0) goto L17;
        MmRecordingState r103 = MmRecordingState.IDLE;
    L19:
        if ((r112 & 16) == 0) goto L21;
        MmRecordingSource r104 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        boolean r105 = false;
    L26:
        this(r100, r101, r102, r103, r104, r105, false, null, false);
        return;
    L25:
        r105 = r111;
        goto L26
    L21:
        r104 = r110;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public q(String r100, String r101, MmRecordingState r102, MmRecordingState r103, MmRecordingSource r104, boolean r105, boolean r106, MmRecordingError r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "minutesToken");
        Intrinsics.checkNotNullParameter(r102, "currentState");
        Intrinsics.checkNotNullParameter(r103, "lastState");
        this.f495868a = r100;
        this.f495869b = r101;
        this.f495870c = r102;
        this.f495871d = r103;
        this.f495872e = r104;
        this.f495873f = r105;
        this.f495874g = r106;
        this.f495875h = r107;
        this.f495876i = r110;
    }
}
