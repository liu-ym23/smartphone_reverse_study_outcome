package eub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingSource f474171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f474172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f474173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f474174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f474175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f474176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f474177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f474178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f474179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f474180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f474181l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f474170a, r101.f474170a) == true) goto L12;
        return false;
    L12:
        if (this.f474171b == r101.f474171b) goto L15;
        return false;
    L15:
        if (this.f474172c == r101.f474172c) goto L18;
        return false;
    L18:
        if (this.f474173d == r101.f474173d) goto L21;
        return false;
    L21:
        if (this.f474174e == r101.f474174e) goto L24;
        return false;
    L24:
        if (this.f474175f == r101.f474175f) goto L27;
        return false;
    L27:
        if (this.f474176g == r101.f474176g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f474177h, r101.f474177h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f474178i, r101.f474178i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f474179j, r101.f474179j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f474180k, r101.f474180k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f474181l, r101.f474181l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f474170a.hashCode() * 31) + this.f474171b.hashCode()) * 31) + this.f474172c) * 31) + this.f474173d) * 31) + this.f474174e) * 31) + this.f474175f) * 31;
        long r101 = this.f474176g;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f474177h.hashCode()) * 31;
        String r103 = this.f474178i;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f474179j;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f474180k;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f474181l;
        if (r113 == null) goto L19;
        r104 = r113.hashCode();
    L19:
        return r112 + r104;
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRawOpusUploadParam(rawOpusPath=" + this.f474170a + ", source=" + this.f474171b + ", channels=" + this.f474172c + ", sampleRate=" + this.f474173d + ", bitrateBps=" + this.f474174e + ", frameMs=" + this.f474175f + ", durationMs=" + this.f474176g + ", recordUuid=" + this.f474177h + ", realtimeRecordingStartMs=" + this.f474178i + ", realtimeRecordingStopMs=" + this.f474179j + ", startTimeZoneOffset=" + this.f474180k + ", doubaoBizInfo=" + this.f474181l + ')';
    }

    public h(String r100, MmRecordingSource r101, int r102, int r103, int r104, int r105, long r106, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "rawOpusPath");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter("", "recordUuid");
        this.f474170a = r100;
        this.f474171b = r101;
        this.f474172c = r102;
        this.f474173d = r103;
        this.f474174e = r104;
        this.f474175f = r105;
        this.f474176g = r106;
        this.f474177h = "";
        this.f474178i = r110;
        this.f474179j = r111;
        this.f474180k = r112;
        this.f474181l = r113;
    }
}
