package ovb;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f526983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f526984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f526985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a f526986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmRecordingCommonParam f526987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f526988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f526989h;

    public b() {
        this(null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f526982a, r101.f526982a) == true) goto L12;
        return false;
    L12:
        if (this.f526983b == r101.f526983b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f526984c, r101.f526984c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f526985d, r101.f526985d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f526986e, r101.f526986e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f526987f, r101.f526987f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f526988g, r101.f526988g) == true) goto L30;
        return false;
    L30:
        if (this.f526989h == r101.f526989h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f526982a.hashCode() * 31;
        long r101 = this.f526983b;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f526984c.hashCode()) * 31) + this.f526985d.hashCode()) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r103 = this.f526986e;
        if (r103 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (((((r102 + r104) * 31) + this.f526987f.hashCode()) * 31) + this.f526988g.hashCode()) * 31;
        if (this.f526989h == false) goto L9;
        int r106 = 1231;
    L11:
        return r105 + r106;
    L9:
        r106 = 1237;
        goto L11
    L5:
        r104 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingData(meetingId=" + this.f526982a + ", meetingStartTime=" + this.f526983b + ", recordingId=" + this.f526984c + ", minutesToken=" + this.f526985d + ", mmRtcConfigData=" + this.f526986e + ", trackerCommonParams=" + this.f526987f + ", sessionKey=" + this.f526988g + ", meetingIdBound=" + this.f526989h + ')';
    }

    public /* synthetic */ b(MmRecordingCommonParam r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r211 & 4) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r211 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r211 & 32) == 0) goto L17;
        MmRecordingCommonParam r110 = new MmRecordingCommonParam(null, null, false, null, null, null, null, null, null, null, null, 2047, null);
    L19:
        if ((r211 & 64) == 0) goto L21;
        String r111 = "";
    L22:
        this(r100, 0, r101, r102, null, r110, r111, false);
        return;
    L21:
        r111 = null;
        goto L22
    L17:
        r110 = r210;
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

    public b(String r100, long r101, String r102, String r103, com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r104, MmRecordingCommonParam r105, String r106, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "recordingId");
        Intrinsics.checkNotNullParameter(r103, "minutesToken");
        Intrinsics.checkNotNullParameter(r105, "trackerCommonParams");
        Intrinsics.checkNotNullParameter(r106, "sessionKey");
        this.f526982a = r100;
        this.f526983b = r101;
        this.f526984c = r102;
        this.f526985d = r103;
        this.f526986e = r104;
        this.f526987f = r105;
        this.f526988g = r106;
        this.f526989h = r110;
    }

    public static b a(b r110, String r111, long r112, String r113, String r114, MmRecordingCommonParam r115, String r116, boolean r117, int r118) {
        if ((r118 & 1) == 0) goto L5;
        String r100 = r110.f526982a;
    L7:
        if ((r118 & 2) == 0) goto L9;
        long r101 = r110.f526983b;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r102 = r110.f526984c;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r103 = r110.f526985d;
    L19:
        if ((r118 & 16) == 0) goto L21;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r104 = r110.f526986e;
    L23:
        if ((r118 & 32) == 0) goto L25;
        MmRecordingCommonParam r105 = r110.f526987f;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r106 = r110.f526988g;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r107 = r110.f526989h;
    L34:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "recordingId");
        Intrinsics.checkNotNullParameter(r103, "minutesToken");
        Intrinsics.checkNotNullParameter(r105, "trackerCommonParams");
        Intrinsics.checkNotNullParameter(r106, "sessionKey");
        return new b(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r117;
        goto L34
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
