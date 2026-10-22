package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public final IntroAuctionAtmosphereState a;
    public IntroAtmosphere b;
    public int c;
    public int d;
    public IntroProduct e;
    public ECPromotionAuctionInfo f;
    public String g;
    public String h;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L20;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (this.c == r4.c) goto L10;
        return false;
    L10:
        if (this.d == r4.d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        IntroAtmosphere r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + this.c) * 31) + this.d) * 31;
        IntroProduct r4 = this.e;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECPromotionAuctionInfo r7 = this.f;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.g;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.h;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "IntroAtmosphereModel(introAtmosphere=" + this.b + ", productType=" + this.c + ", industryType=" + this.d + ", product=" + this.e + ", auctionInfo=" + this.f + ", roomId=" + this.g + ", roomUniqueKey=" + this.h + ")";
    }

    public e() {
        Intrinsics.checkNotNullParameter("", "roomId");
        Intrinsics.checkNotNullParameter("", "roomUniqueKey");
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = null;
        this.g = "";
        this.h = "";
        this.a = new IntroAuctionAtmosphereState();
    }
}
