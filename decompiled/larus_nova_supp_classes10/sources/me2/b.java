package me2;

import com.bytedance.android.live.ktv.common.model.bean.ChallengeChangeType;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.CloseChallengeType;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final long a;
    public final long b;
    public final ChallengeChangeType c;
    public final long d;
    public final String e;
    public final String f;
    public final int g;
    public final boolean h;
    public final CloseChallengeType i;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L24;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        ChallengeChangeType r4 = this.c;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        long r7 = this.d;
        int r8 = (((r2 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.e;
        if (r9 == null) goto L9;
        int r10 = r9.hashCode();
    L10:
        int r11 = (r8 + r10) * 31;
        String r12 = this.f;
        if (r12 == null) goto L13;
        int r13 = r12.hashCode();
    L14:
        int r14 = (((r11 + r13) * 31) + this.g) * 31;
        boolean r15 = this.h;
        ?? r16 = r15;
        if (r15 == false) goto L17;
        r16 = 1;
    L17:
        int r17 = (r14 + r16) * 31;
        CloseChallengeType r18 = this.i;
        if (r18 == null) goto L21;
        r5 = r18.hashCode();
    L21:
        return r17 + r5;
    L13:
        r13 = 0;
        goto L14
    L9:
        r10 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenVideoChallengeOrder(score=" + this.a + ", duration=" + this.b + ", changeType=" + this.c + ", switchStatus=" + this.d + ", fromPage=" + this.e + ", openSource=" + this.f + ", challengeType=" + this.g + ", isAuto=" + this.h + ", closeChallengeType=" + this.i + ")";
    }

    public /* synthetic */ b(long r17, long r19, ChallengeChangeType r21, long r22, String r24, String r25, int r26, int r27) {
        CloseChallengeType r2 = null;
        if ((r27 & 32) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r27 & 64) == 0) goto L9;
        int r13 = KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue();
    L11:
        if ((r27 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L13;
        boolean r14 = true;
    L15:
        if ((r27 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L17;
        r2 = CloseChallengeType.UNKNOWN;
    L17:
        this(r17, r19, r21, r22, r24, r12, r13, r14, r2);
        return;
    L13:
        r14 = false;
        goto L15
    L9:
        r13 = r26;
        goto L11
    L5:
        r12 = r25;
        goto L7
    }

    public b(long r2, long r4, ChallengeChangeType r6, long r7, String r9, String r10, int r11, boolean r12, CloseChallengeType r13) {
        Intrinsics.checkNotNullParameter(r6, "changeType");
        Intrinsics.checkNotNullParameter(r13, "closeChallengeType");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
    }
}
