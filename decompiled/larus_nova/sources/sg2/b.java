package sg2;

import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f541770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f541772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TraceTimeMetricV2 f541773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f541774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f541775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f541776g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f541770a, r101.f541770a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f541771b, r101.f541771b) == true) goto L10;
        return false;
    L10:
        if (this.f541772c == r101.f541772c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f541773d, r101.f541773d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f541774e, r101.f541774e) == true) goto L16;
        return false;
    L16:
        if (this.f541775f == r101.f541775f) goto L18;
        return false;
    L18:
        if (this.f541776g == r101.f541776g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r100 = this.f541770a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f541771b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f541772c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        TraceTimeMetricV2 r109 = this.f541773d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f541774e;
        if (r112 == null) goto L17;
        r101 = r112.hashCode();
    L17:
        int r113 = (r111 + r101) * 31;
        boolean r114 = this.f541775f;
        ?? r115 = r114;
        if (r114 == false) goto L20;
        r115 = 1;
    L20:
        int r116 = (r113 + r115) * 31;
        long r117 = this.f541776g;
        return r116 + ((int) (r117 ^ (r117 >>> 32)));
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BaseLiveMessageCommon(messageId=" + this.f541770a + ", contentType=" + this.f541771b + ", logicClock=" + this.f541772c + ", traceTimeMetric=" + this.f541773d + ", targetRoomId=" + this.f541774e + ", isFromVirtualChannel=" + this.f541775f + ", decodeTimestamp=" + this.f541776g + ")";
    }

    public b(String r100, String r101, long r102, TraceTimeMetricV2 r103, String r104, boolean r105, long r106) {
        this.f541770a = r100;
        this.f541771b = r101;
        this.f541772c = r102;
        this.f541773d = r103;
        this.f541774e = r104;
        this.f541775f = r105;
        this.f541776g = r106;
    }
}
