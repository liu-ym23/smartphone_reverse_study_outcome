package gq4;

import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;
import com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class q extends com.bytedance.ee.bear.bitable.card.view.cell.rating.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f482167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BTRatingBar f482168m;

    public static final class a implements sr4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f482169a;

        public a(q r100) {
            this.f482169a = r100;
        }

        @Override // sr4.c
        public final void b(Integer r100) {
            zp4.b r101 = this.f482169a.f208013k;
            if (r101 == null) goto L6;
            r101.u1(r100);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.a
    public final void e() {
        FrameLayout r100 = this.f573185a;
        if (r100 == null) goto L8;
        LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_cell_rating_form_edit_item_content, r100);
        BTRatingBar r101 = (BTRatingBar) r100.findViewById(R.id.form_edit_rating);
        this.f482168m = r101;
        if (r101 == null) goto L9;
        r101.setRatingChangeListener(new a(this));
        return;
    L9:
        return;
    }

    public q(gp4.h r100) {
        super(false, r100);
        this.f482167l = "FormRatingCellViewHolde";
    }

    public static sr4.e h(int r100) {
        if (r100 > 5) goto L6;
        return new sr4.e(27, 14, 1);
    L6:
        if (r100 > 8) goto L9;
        return new sr4.e(27, 12, 1);
    L9:
        return new sr4.e(20, 6, 1);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.a
    public final void f(dp4.a<List<NumberModel>> r100, int r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        fp4.g r111 = r100.f469587a;
        if ((r111 instanceof fp4.f) == false) goto L48;
        fp4.f r112 = (fp4.f) r111;
        Double r101 = r112.f478250o;
        if (r101 == null) goto L9;
        int r102 = (int) r101.doubleValue();
    L10:
        Double r103 = r112.f478251p;
        if (r103 == null) goto L13;
        int r104 = (int) r103.doubleValue();
    L14:
        String r113 = r112.f478253r;
        NumberModel r105 = (NumberModel) r100.a(NumberModel.class);
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r106 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        Integer r107 = null;
        if (com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.c(r113) == false) goto L32;
        ArrayList r114 = new ArrayList();
        if (r102 > r104) goto L24;
        int r108 = r102;
    L19:
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r109 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.c r115 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.b(String.valueOf(r108));
        if (r115 == null) goto L22;
        r114.add(r115);
    L22:
        if (r108 == r104) goto L24;
        r108 = r108 + 1;
    L24:
        BTRatingBar r116 = this.f482168m;
        if (r116 == null) goto L51;
        BTRatingBar.a r117 = new BTRatingBar.a();
        if (r105 == null) goto L31;
        Double r118 = r105.getNumberValue();
        if (r118 == null) goto L31;
        r107 = Integer.valueOf((int) r118.doubleValue());
    L31:
        r117.f210048e = r107;
        r117.f210047d = Integer.valueOf(r102);
        r117.f210046c = Integer.valueOf(r104);
        r117.f210052i = true;
        r117.f210053j = r114;
        r117.f210049f = Boolean.FALSE;
        r117.f210051h = h((r104 - r102) + 1);
        r116.setRatingBarInfo(r117);
        return;
    L51:
        return;
    L32:
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.b r119 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.a(r113);
        BTRatingBar r120 = this.f482168m;
        if (r120 == null) goto L53;
        BTRatingBar.a r121 = new BTRatingBar.a();
        if (r105 == null) goto L39;
        Double r122 = r105.getNumberValue();
        if (r122 == null) goto L39;
        Integer r123 = Integer.valueOf((int) r122.doubleValue());
    L40:
        r121.f210048e = r123;
        r121.f210047d = Integer.valueOf(r102);
        r121.f210046c = Integer.valueOf(r104);
        r121.f210052i = false;
        r121.f210049f = Boolean.TRUE;
        if (r119 == null) goto L43;
        Integer r124 = Integer.valueOf(r119.f210057a);
    L44:
        r121.f210044a = r124;
        if (r119 == null) goto L47;
        r107 = Integer.valueOf(r119.f210058b);
    L47:
        r121.f210045b = r107;
        r121.f210051h = h((r104 - r102) + 1);
        r120.setRatingBarInfo(r121);
        return;
    L43:
        r124 = null;
    L39:
        r123 = null;
        goto L40
    L53:
        return;
    L13:
        r104 = 5;
        goto L14
    L9:
        r102 = 1;
        goto L10
    L48:
        tt5.a.d(this.f482167l, "can not setData with none NumberField data");
    }
}
