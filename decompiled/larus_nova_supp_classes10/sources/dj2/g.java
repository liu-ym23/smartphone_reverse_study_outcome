package dj2;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public final int a;
    public final ECUIPromotion b;
    public final com.bytedance.android.livesdk.livecommerce.playback.interaction.a c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L12;
        g r4 = (g) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        ECUIPromotion r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        com.bytedance.android.livesdk.livecommerce.playback.interaction.a r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractionEntity(position=" + this.a + ", uiPromotion=" + this.b + ", response=" + this.c + ")";
    }

    public g(int r1, ECUIPromotion r2, com.bytedance.android.livesdk.livecommerce.playback.interaction.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
