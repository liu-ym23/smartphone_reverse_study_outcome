package dv0;

import com.bytedance.android.live.profit.scoreboard.dto.r;
import com.bytedance.android.livesdk.message.model.k7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f470117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k7 f470118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f470120e;

    public final int hashCode() {
        String r100 = this.f470116a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f470117b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        k7 r105 = this.f470118c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f470119d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        r r111 = this.f470120e;
        if (r111 == null) goto L18;
        r101 = r111.hashCode();
    L18:
        return r110 + r101;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RoundCommonData(miniAppId=" + this.f470116a + ", roundId=" + this.f470117b + ", entranceInfo=" + this.f470118c + ", creatorId=" + this.f470119d + ", extra=" + this.f470120e + ")";
    }

    @Override // dv0.e
    public final k7 getEntranceInfo() {
        return this.f470118c;
    }

    @Override // dv0.e
    public final r getExtra() {
        return this.f470120e;
    }

    @Override // dv0.e
    public final String getMiniAppId() {
        return this.f470116a;
    }

    @Override // dv0.e
    public final long getRoundId() {
        return this.f470117b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f470116a, r101.f470116a) == true) goto L8;
        return false;
    L8:
        if (this.f470117b == r101.f470117b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f470118c, r101.f470118c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470119d, r101.f470119d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f470120e, r101.f470120e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public i(String r100, long r101, k7 r102, String r103, r r104) {
        Intrinsics.checkNotNullParameter(r100, "miniAppId");
        Intrinsics.checkNotNullParameter(r103, "creatorId");
        Intrinsics.checkNotNullParameter(r104, "extra");
        this.f470116a = r100;
        this.f470117b = r101;
        this.f470118c = r102;
        this.f470119d = r103;
        this.f470120e = r104;
    }
}
