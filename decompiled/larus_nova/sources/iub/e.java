package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmParticipantTypeData;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmSubtitleSpeakerTypeData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmParticipantTypeData f495819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmSubtitleSpeakerTypeData f495820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f495821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f495822f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f495817a, r101.f495817a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495818b, r101.f495818b) == true) goto L15;
        return false;
    L15:
        if (this.f495819c == r101.f495819c) goto L18;
        return false;
    L18:
        if (this.f495820d == r101.f495820d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495821e, r101.f495821e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f495822f, r101.f495822f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f495817a.hashCode() * 31) + this.f495818b.hashCode()) * 31) + this.f495819c.hashCode()) * 31) + this.f495820d.hashCode()) * 31) + this.f495821e.hashCode()) * 31) + this.f495822f.hashCode();
    }

    public final String toString() {
        return "MmDisplaySpeakerData(userId=" + this.f495817a + ", deviceId=" + this.f495818b + ", participantType=" + this.f495819c + ", speakerType=" + this.f495820d + ", name=" + this.f495821e + ", avatar=" + this.f495822f + ')';
    }

    public e() {
        this("", "", MmParticipantTypeData.UNKNOWN, MmSubtitleSpeakerTypeData.UNKNOWN, "", new d(null, null, null, null, 15));
    }

    public e(String r100, String r101, MmParticipantTypeData r102, MmSubtitleSpeakerTypeData r103, String r104, d r105) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        Intrinsics.checkNotNullParameter(r102, "participantType");
        Intrinsics.checkNotNullParameter(r103, "speakerType");
        Intrinsics.checkNotNullParameter(r104, "name");
        Intrinsics.checkNotNullParameter(r105, "avatar");
        this.f495817a = r100;
        this.f495818b = r101;
        this.f495819c = r102;
        this.f495820d = r103;
        this.f495821e = r104;
        this.f495822f = r105;
    }
}
