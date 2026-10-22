package zk3;

import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.shopping.threed.repository.dto.BasicComponent;
import com.bytedance.android.shopping.threed.repository.dto.BuyButtonComponent;
import com.bytedance.android.shopping.threed.repository.dto.NameComponent;
import com.bytedance.android.shopping.threed.repository.dto.TrackComponent;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final List<BuyButtonComponent> a;
    public final NameComponent b;
    public final BasicComponent c;
    public final TrackComponent d;
    public final List<PromotionDiscountLabel> e;
    public final Map<String, String> f;

    public a() {
        this(null, null, 63);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
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
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<BuyButtonComponent> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        NameComponent r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        BasicComponent r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        TrackComponent r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<PromotionDiscountLabel> r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.f;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
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
        return "ButtonCombinedComponent(buyButtonComponent=" + this.a + ", nameComponent=" + this.b + ", basicComponent=" + this.c + ", trackComponent=" + this.d + ", discountComponent=" + this.e + ", productParams=" + this.f + ")";
    }

    public a(List r3, Map r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 32) == 0) goto L8;
        r4 = MapsKt.emptyMap();
    L8:
        Intrinsics.checkNotNullParameter(r4, "productParams");
        this.a = r3;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = r4;
    }
}
