package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmParticipantTypeData;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmSubtitleSpeakerTypeData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmParticipantTypeData f495900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmSubtitleSpeakerTypeData f495901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f495902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f495903f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f495898a, r101.f495898a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495899b, r101.f495899b) == true) goto L15;
        return false;
    L15:
        if (this.f495900c == r101.f495900c) goto L18;
        return false;
    L18:
        if (this.f495901d == r101.f495901d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495902e, r101.f495902e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f495903f, r101.f495903f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f495898a.hashCode() * 31) + this.f495899b.hashCode()) * 31) + this.f495900c.hashCode()) * 31) + this.f495901d.hashCode()) * 31;
        String r101 = this.f495902e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f495903f;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmSubtitleSpeakerData(userId=" + this.f495898a + ", deviceId=" + this.f495899b + ", participantType=" + this.f495900c + ", speakerType=" + this.f495901d + ", name=" + this.f495902e + ", avatarKey=" + this.f495903f + ')';
    }

    public y() {
        this("", "", MmParticipantTypeData.UNKNOWN, MmSubtitleSpeakerTypeData.UNKNOWN, null, null);
    }

    public y(String r100, String r101, MmParticipantTypeData r102, MmSubtitleSpeakerTypeData r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        Intrinsics.checkNotNullParameter(r102, "participantType");
        Intrinsics.checkNotNullParameter(r103, "speakerType");
        this.f495898a = r100;
        this.f495899b = r101;
        this.f495900c = r102;
        this.f495901d = r103;
        this.f495902e = r104;
        this.f495903f = r105;
    }
}
