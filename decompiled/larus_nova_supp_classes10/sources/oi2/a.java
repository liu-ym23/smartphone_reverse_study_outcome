package oi2;

import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.model.playback.ProductIndex;
import com.bytedance.android.ec.model.playback.ReplayCard;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final ExplainPlaybackRequest a;
    public final int b;
    public final List<ProductIndex> c;
    public final List<String> d;
    public final List<ReplayCard> e;
    public final long f;
    public final String g;
    public final Boolean h;
    public final String i;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L24;
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
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
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        ExplainPlaybackRequest r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        List<ProductIndex> r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<ReplayCard> r10 = this.e;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        long r13 = this.f;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        String r15 = this.g;
        if (r15 == null) goto L21;
        int r16 = r15.hashCode();
    L22:
        int r17 = (r14 + r16) * 31;
        Boolean r18 = this.h;
        if (r18 == null) goto L25;
        int r19 = r18.hashCode();
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.i;
        if (r21 == null) goto L30;
        r1 = r21.hashCode();
    L30:
        return r20 + r1;
    L25:
        r19 = 0;
        goto L26
    L21:
        r16 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECReplayScrollProductCardRequestParams(explainPlaybackRequest=" + this.a + ", pageSize=" + this.b + ", promotionIdsWithIndex=" + this.c + ", promotionIDs=" + this.d + ", firstReplayCards=" + this.e + ", serverTime=" + this.f + ", replayType=" + this.g + ", isFromLive=" + this.h + ", targetEntranceInfo=" + this.i + ")";
    }

    public a(ExplainPlaybackRequest r1, int r2, List<ProductIndex> r3, List<String> r4, List<ReplayCard> r5, long r6, String r8, Boolean r9, String r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
