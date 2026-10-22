package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageBottomData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageDynamicOpenRegion;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.Toggle;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mj2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements com.bytedance.android.ec.core.arch.state.b {
    public final List<PromotionCategory> a;
    public final Integer b;
    public final String c;
    public final ECPromotionList.r d;
    public final LivePromotionPageBottomData e;
    public final ECPromotionList.o f;
    public final h<PageListLoadStatus> g;
    public final String h;
    public final Toggle i;
    public final LivePromotionPageDynamicOpenRegion j;
    public final boolean k;
    public final int l;

    public c() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L30;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r4.k) goto L28;
        return false;
    L28:
        if (this.l == r4.l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        List<PromotionCategory> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECPromotionList.r r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        LivePromotionPageBottomData r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ECPromotionList.o r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        h<PageListLoadStatus> r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Toggle r25 = this.i;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        LivePromotionPageDynamicOpenRegion r28 = this.j;
        if (r28 == null) goto L41;
        r1 = r28.hashCode();
    L41:
        int r29 = (r27 + r1) * 31;
        boolean r30 = this.k;
        ?? r31 = r30;
        if (r30 == false) goto L45;
        r31 = 1;
    L45:
        return ((r29 + r31) * 31) + this.l;
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
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
        return "LivePromotionListState(categoryInfo=" + this.a + ", categoryStyle=" + this.b + ", categorySkinType=" + this.c + ", promotionBackground=" + this.d + ", bottomData=" + this.e + ", listBannerInfo=" + this.f + ", loadInitialStatus=" + this.g + ", listBackgroundColor=" + this.h + ", toggle=" + this.i + ", openRegion=" + this.j + ", showProductCardStyle=" + this.k + ", headerAreaMarginBottom=" + this.l + ")";
    }

    public /* synthetic */ c(int r14) {
        this(null, null, null, null, null, null, null, null, null, null, false, 0);
    }

    public c(List<PromotionCategory> r1, Integer r2, String r3, ECPromotionList.r r4, LivePromotionPageBottomData r5, ECPromotionList.o r6, h<PageListLoadStatus> r7, String r8, Toggle r9, LivePromotionPageDynamicOpenRegion r10, boolean r11, int r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }

    public static c a(c r13, List r14, Integer r15, String r16, ECPromotionList.r r17, ECPromotionList.o r18, h r19, String r20, Toggle r21, LivePromotionPageDynamicOpenRegion r22, boolean r23, int r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        List r2 = r13.a;
    L7:
        if ((r25 & 2) == 0) goto L9;
        Integer r3 = r13.b;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r4 = r13.c;
    L15:
        if ((r25 & 8) == 0) goto L17;
        ECPromotionList.r r5 = r13.d;
    L19:
        if ((r25 & 16) == 0) goto L21;
        LivePromotionPageBottomData r6 = r13.e;
    L23:
        if ((r25 & 32) == 0) goto L25;
        ECPromotionList.o r7 = r13.f;
    L27:
        if ((r25 & 64) == 0) goto L29;
        h r8 = r13.g;
    L31:
        if ((r25 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        String r9 = r13.h;
    L35:
        if ((r25 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        Toggle r10 = r13.i;
    L39:
        if ((r25 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        LivePromotionPageDynamicOpenRegion r11 = r13.j;
    L43:
        if ((r25 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        boolean r12 = r13.k;
    L47:
        if ((r25 & 2048) == 0) goto L49;
        int r1 = r13.l;
    L50:
        r13.getClass();
        return new c(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r24;
        goto L50
    L45:
        r12 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = null;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }
}
