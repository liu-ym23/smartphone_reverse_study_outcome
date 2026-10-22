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

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<BuyButtonComponent> f572608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NameComponent f572609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BasicComponent f572610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TrackComponent f572611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<PromotionDiscountLabel> f572612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f572613f;

    public a() {
        this(null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f572608a, r101.f572608a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f572609b, r101.f572609b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f572610c, r101.f572610c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572611d, r101.f572611d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f572612e, r101.f572612e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f572613f, r101.f572613f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<BuyButtonComponent> r100 = this.f572608a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        NameComponent r104 = this.f572609b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        BasicComponent r107 = this.f572610c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TrackComponent r110 = this.f572611d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<PromotionDiscountLabel> r113 = this.f572612e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.f572613f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
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
        return "ButtonCombinedComponent(buyButtonComponent=" + this.f572608a + ", nameComponent=" + this.f572609b + ", basicComponent=" + this.f572610c + ", trackComponent=" + this.f572611d + ", discountComponent=" + this.f572612e + ", productParams=" + this.f572613f + ")";
    }

    public a(List r100, Map r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 32) == 0) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        Intrinsics.checkNotNullParameter(r101, "productParams");
        this.f572608a = r100;
        this.f572609b = null;
        this.f572610c = null;
        this.f572611d = null;
        this.f572612e = null;
        this.f572613f = r101;
    }
}
