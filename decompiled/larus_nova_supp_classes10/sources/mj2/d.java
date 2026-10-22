package mj2;

import com.bytedance.android.ec.model.promotion.ECUIPromotionLiveListConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public final boolean a;
    public final List<String> b;
    public final ql.d c;
    public final String d;
    public final ECUIPromotionLiveListConfig e;
    public final g f;

    public d() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L18;
        d r4 = (d) r3;
        if (this.a == r4.a) goto L8;
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
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<String> r3 = this.b;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        ql.d r7 = this.c;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        ECUIPromotionLiveListConfig r13 = this.e;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        g r16 = this.f;
        if (r16 == null) goto L25;
        r4 = r16.hashCode();
    L25:
        return r15 + r4;
    L20:
        r14 = 0;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "LivePromotionListItemExtraInfo(hasAuthorShopInfo=" + this.a + ", promotionListHeaderLabelNames=" + this.b + ", listLevelState=" + this.c + ", authorSellScore=" + this.d + ", config=" + this.e + ", smartProductInfoLogData=" + this.f + ")";
    }

    public /* synthetic */ d(int r8) {
        this(true, null, null, null, null, null);
    }

    public d(boolean r1, List<String> r2, ql.d r3, String r4, ECUIPromotionLiveListConfig r5, g r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
