package oi2;

import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.model.playback.ProductIndex;
import com.bytedance.android.ec.model.playback.ReplayCard;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExplainPlaybackRequest f523361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f523362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ProductIndex> f523363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f523364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ReplayCard> f523365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f523366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f523367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f523368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f523369i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f523361a, r101.f523361a) == true) goto L8;
        return false;
    L8:
        if (this.f523362b == r101.f523362b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f523363c, r101.f523363c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f523364d, r101.f523364d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f523365e, r101.f523365e) == true) goto L16;
        return false;
    L16:
        if (this.f523366f == r101.f523366f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f523367g, r101.f523367g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f523368h, r101.f523368h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f523369i, r101.f523369i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        ExplainPlaybackRequest r100 = this.f523361a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f523362b) * 31;
        List<ProductIndex> r104 = this.f523363c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f523364d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<ReplayCard> r110 = this.f523365e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f523366f;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        String r115 = this.f523367g;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        Boolean r118 = this.f523368h;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f523369i;
        if (r121 == null) goto L30;
        r101 = r121.hashCode();
    L30:
        return r120 + r101;
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECReplayScrollProductCardRequestParams(explainPlaybackRequest=" + this.f523361a + ", pageSize=" + this.f523362b + ", promotionIdsWithIndex=" + this.f523363c + ", promotionIDs=" + this.f523364d + ", firstReplayCards=" + this.f523365e + ", serverTime=" + this.f523366f + ", replayType=" + this.f523367g + ", isFromLive=" + this.f523368h + ", targetEntranceInfo=" + this.f523369i + ")";
    }

    public a(ExplainPlaybackRequest r100, int r101, List<ProductIndex> r102, List<String> r103, List<ReplayCard> r104, long r105, String r106, Boolean r107, String r110) {
        this.f523361a = r100;
        this.f523362b = r101;
        this.f523363c = r102;
        this.f523364d = r103;
        this.f523365e = r104;
        this.f523366f = r105;
        this.f523367g = r106;
        this.f523368h = r107;
        this.f523369i = r110;
    }
}
