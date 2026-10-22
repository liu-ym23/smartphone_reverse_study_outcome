package do9;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f469506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f469507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f469508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f469509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f469510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f469511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f469512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f469513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f469514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmRecordingSource f469515j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f469506a, r101.f469506a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f469507b, r101.f469507b) == true) goto L15;
        return false;
    L15:
        if (this.f469508c == r101.f469508c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f469509d, r101.f469509d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f469510e, r101.f469510e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f469511f, r101.f469511f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f469512g, r101.f469512g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f469513h, r101.f469513h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f469514i, r101.f469514i) == true) goto L36;
        return false;
    L36:
        if (this.f469515j == r101.f469515j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f469506a.hashCode() * 31;
        String r101 = this.f469507b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.f469508c;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        Long r106 = this.f469509d;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.f469510e;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        Long r112 = this.f469511f;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        Long r115 = this.f469512g;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        Long r118 = this.f469513h;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f469514i;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        MmRecordingSource r124 = this.f469515j;
        if (r124 == null) goto L35;
        r102 = r124.hashCode();
    L35:
        return r123 + r102;
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecordingPerfSession(conversationId=" + this.f469506a + ", cardMessageId=" + this.f469507b + ", clickTs=" + this.f469508c + ", cardShownTs=" + this.f469509d + ", sdkStartCallTs=" + this.f469510e + ", sdkStartSuccessTs=" + this.f469511f + ", recordingPageShownTs=" + this.f469512g + ", firstSubtitleTs=" + this.f469513h + ", recordingId=" + this.f469514i + ", source=" + this.f469515j + ')';
    }

    public b(String r100, long r101, MmRecordingSource r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f469506a = r100;
        this.f469507b = null;
        this.f469508c = r101;
        this.f469509d = null;
        this.f469510e = null;
        this.f469511f = null;
        this.f469512g = null;
        this.f469513h = null;
        this.f469514i = null;
        this.f469515j = r102;
    }
}
