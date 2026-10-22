package dj2;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f468895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUIPromotion f468896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.playback.interaction.a f468897c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (this.f468895a == r101.f468895a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468896b, r101.f468896b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468897c, r101.f468897c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f468895a * 31;
        ECUIPromotion r101 = this.f468896b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        com.bytedance.android.livesdk.livecommerce.playback.interaction.a r105 = this.f468897c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractionEntity(position=" + this.f468895a + ", uiPromotion=" + this.f468896b + ", response=" + this.f468897c + ")";
    }

    public g(int r100, ECUIPromotion r101, com.bytedance.android.livesdk.livecommerce.playback.interaction.a r102) {
        this.f468895a = r100;
        this.f468896b = r101;
        this.f468897c = r102;
    }
}
