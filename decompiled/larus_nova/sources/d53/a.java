package d53;

import android.widget.TextView;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.utils.g;
import com.bytedance.android.shopping.widget.PriceView;
import com.larus.nova.R;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f466977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriceView f466978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C5637a f466979c;

    /* JADX INFO: renamed from: d53.a$a, reason: collision with other inner class name */
    public static final class C5637a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f466980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PriceView f466981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f466982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ActivityVO f466983d;

        public C5637a() {
        }
    }

    public final void c() {
        ActivityVO r100 = this.f466979c.f466983d;
        if (r100 != null) goto L5;
        return;
    L5:
        Long r101 = r100.getMinPrice();
        Long r102 = r100.getMaxPrice();
        Long r103 = r100.getOriginMinPrice();
        Long r104 = r100.getOriginMaxPrice();
        r100.getMarketPrice();
        PromotionDiscountPrice r105 = r100.getDiscountPrice();
        PromotionDiscountPrice r106 = r100.getGroupDiscountPrice();
        long r107 = 0;
        if (this.f466979c.f466982c == true) goto L48;
        if (b(new Long[]{r103, r104}) == false) goto L19;
        PriceView r108 = this.f466978b;
        if (r108 == null) goto L15;
        int r109 = g.f187081a;
        if (r103 == null) goto L14;
        r107 = r103.longValue();
    L14:
        r108.setPriceText(g.d(r107));
    L15:
        PriceView r110 = this.f466978b;
        if (r110 == null) goto L84;
        r110.setExtraText(ag4.a.d(R.string.commerce_tip_price_append_text));
        return;
    L84:
        return;
    L19:
        if (a(r105, r103) == false) goto L41;
        TextView r111 = this.f466977a;
        if (r111 == null) goto L23;
        r111.setText("券后");
    L23:
        PriceView r112 = this.f466978b;
        if (r112 == null) goto L29;
        int r113 = g.f187081a;
        Long r114 = r105.getMinPrice();
        if (r114 == null) goto L28;
        r107 = r114.longValue();
    L28:
        r112.setPriceText(g.d(r107));
    L29:
        Long r115 = r105.getMinPrice();
        if (r115 == null) goto L86;
        long r116 = r115.longValue();
        if (r105.getMaxPrice() == null) goto L87;
        Long r117 = r105.getMaxPrice();
        if (r117 != null) goto L37;
    L38:
        PriceView r118 = this.f466978b;
        if (r118 == null) goto L89;
        r118.setExtraText(ag4.a.d(R.string.commerce_tip_price_append_text));
        return;
    L89:
        return;
    L37:
        if (r117.longValue() != r116) goto L38;
        return;
    L87:
        return;
    L86:
        return;
    L41:
        PriceView r119 = this.f466978b;
        if (r119 == null) goto L91;
        int r120 = g.f187081a;
        if (r103 == null) goto L46;
        r107 = r103.longValue();
    L46:
        r119.setPriceText(g.d(r107));
        return;
    L91:
        return;
    L48:
        if (b(new Long[]{r101, r102}) == false) goto L59;
        PriceView r121 = this.f466978b;
        if (r121 == null) goto L56;
        int r122 = g.f187081a;
        if (r101 == null) goto L54;
        long r123 = r101.longValue();
    L55:
        r121.setPriceText(g.d(r123));
        goto L56
    L54:
        r123 = 0;
    L56:
        PriceView r124 = this.f466978b;
        if (r124 == null) goto L67;
        r124.setExtraText(ag4.a.d(R.string.commerce_tip_price_append_text));
    L67:
        if (a(r106, r101) == false) goto L77;
        TextView r125 = this.f466977a;
        if (r125 == null) goto L71;
        r125.setText("券后");
    L71:
        PriceView r126 = this.f466978b;
        if (r126 == null) goto L93;
        int r127 = g.f187081a;
        Long r128 = r106.getMinPrice();
        if (r128 == null) goto L76;
        r107 = r128.longValue();
    L76:
        r126.setPriceText(g.d(r107));
        return;
    L93:
        return;
    L77:
        PriceView r129 = this.f466978b;
        if (r129 == null) goto L95;
        int r130 = g.f187081a;
        if (r101 == null) goto L82;
        r107 = r101.longValue();
    L82:
        r129.setPriceText(g.d(r107));
        return;
    L95:
        return;
    L59:
        PriceView r131 = this.f466978b;
        if (r131 == null) goto L67;
        int r132 = g.f187081a;
        if (r101 == null) goto L64;
        long r133 = r101.longValue();
    L65:
        r131.setPriceText(g.d(r133));
        goto L67
    L64:
        r133 = 0;
        goto L65
    }

    public a(C5637a r100) {
        this.f466979c = r100;
        this.f466977a = r100.f466980a;
        this.f466978b = r100.f466981b;
    }

    public static boolean b(Long... r100) {
        if (ArraysKt.filterNotNull(r100).size() < 2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L18;
        Long r102 = r100[0];
        if (r102 == null) goto L17;
        long r103 = r102.longValue();
        Long r104 = r100[1];
        if (r104 == null) goto L15;
        if (r103 == r104.longValue()) goto L18;
        return true;
    L15:
        throw new IllegalStateException("Required value was null.".toString());
    L17:
        throw new IllegalStateException("Required value was null.".toString());
    L18:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public static boolean a(PromotionDiscountPrice r100, Long r101) {
        if (r100 == null) goto L4;
        Long r102 = r100.getMinPrice();
    L5:
        if (r102 == null) goto L15;
        long r103 = r102.longValue();
        if (r101 == null) goto L9;
        long r104 = r101.longValue();
    L11:
        if (r103 >= r104) goto L15;
        if (r102.longValue() <= 0) goto L15;
        return true;
    L9:
        r104 = 0;
    L15:
        return false;
    L4:
        r102 = null;
        goto L5
    }
}
