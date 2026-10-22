package sg2;

import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final String a;
    public final String b;
    public final long c;
    public final TraceTimeMetricV2 d;
    public final String e;
    public final boolean f;
    public final long g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L20;
        b r7 = (b) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L31;
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
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.c;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        TraceTimeMetricV2 r9 = this.d;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.e;
        if (r12 == null) goto L17;
        r1 = r12.hashCode();
    L17:
        int r13 = (r11 + r1) * 31;
        boolean r14 = this.f;
        ?? r15 = r14;
        if (r14 == false) goto L20;
        r15 = 1;
    L20:
        int r16 = (r13 + r15) * 31;
        long r17 = this.g;
        return r16 + ((int) (r17 ^ (r17 >>> 32)));
    L13:
        r10 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "BaseLiveMessageCommon(messageId=" + this.a + ", contentType=" + this.b + ", logicClock=" + this.c + ", traceTimeMetric=" + this.d + ", targetRoomId=" + this.e + ", isFromVirtualChannel=" + this.f + ", decodeTimestamp=" + this.g + ")";
    }

    public b(String r1, String r2, long r3, TraceTimeMetricV2 r5, String r6, boolean r7, long r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
