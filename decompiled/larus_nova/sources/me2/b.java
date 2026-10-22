package me2;

import com.bytedance.android.live.ktv.common.model.bean.ChallengeChangeType;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.CloseChallengeType;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f513460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f513461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChallengeChangeType f513462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f513463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f513464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f513465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f513466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f513467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CloseChallengeType f513468i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (this.f513460a == r101.f513460a) goto L8;
        return false;
    L8:
        if (this.f513461b == r101.f513461b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f513462c, r101.f513462c) == true) goto L12;
        return false;
    L12:
        if (this.f513463d == r101.f513463d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f513464e, r101.f513464e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f513465f, r101.f513465f) == true) goto L18;
        return false;
    L18:
        if (this.f513466g == r101.f513466g) goto L20;
        return false;
    L20:
        if (this.f513467h == r101.f513467h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f513468i, r101.f513468i) == true) goto L37;
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
        long r100 = this.f513460a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f513461b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        ChallengeChangeType r104 = this.f513462c;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        long r107 = this.f513463d;
        int r108 = (((r103 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f513464e;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f513465f;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (((r111 + r113) * 31) + this.f513466g) * 31;
        boolean r115 = this.f513467h;
        ?? r116 = r115;
        if (r115 == false) goto L17;
        r116 = 1;
    L17:
        int r117 = (r114 + r116) * 31;
        CloseChallengeType r118 = this.f513468i;
        if (r118 == null) goto L21;
        r105 = r118.hashCode();
    L21:
        return r117 + r105;
    L13:
        r113 = 0;
        goto L14
    L9:
        r110 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenVideoChallengeOrder(score=" + this.f513460a + ", duration=" + this.f513461b + ", changeType=" + this.f513462c + ", switchStatus=" + this.f513463d + ", fromPage=" + this.f513464e + ", openSource=" + this.f513465f + ", challengeType=" + this.f513466g + ", isAuto=" + this.f513467h + ", closeChallengeType=" + this.f513468i + ")";
    }

    public /* synthetic */ b(long r110, long r111, ChallengeChangeType r210, long r211, String r212, String r213, int r214, int r215) {
        CloseChallengeType r100 = null;
        if ((r215 & 32) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r215 & 64) == 0) goto L9;
        int r113 = KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue();
    L11:
        if ((r215 & 128) == 0) goto L13;
        boolean r114 = true;
    L15:
        if ((r215 & 256) == 0) goto L17;
        r100 = CloseChallengeType.UNKNOWN;
    L17:
        this(r110, r111, r210, r211, r212, r112, r113, r114, r100);
        return;
    L13:
        r114 = false;
        goto L15
    L9:
        r113 = r214;
        goto L11
    L5:
        r112 = r213;
        goto L7
    }

    public b(long r100, long r101, ChallengeChangeType r102, long r103, String r104, String r110, int r111, boolean r112, CloseChallengeType r113) {
        Intrinsics.checkNotNullParameter(r102, "changeType");
        Intrinsics.checkNotNullParameter(r113, "closeChallengeType");
        this.f513460a = r100;
        this.f513461b = r101;
        this.f513462c = r102;
        this.f513463d = r103;
        this.f513464e = r104;
        this.f513465f = r110;
        this.f513466g = r111;
        this.f513467h = r112;
        this.f513468i = r113;
    }
}
