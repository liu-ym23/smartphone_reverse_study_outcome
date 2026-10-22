package com.bytedance.ee.bear.bitable.card.view.cell.rating;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableMetaModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import gp4.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class a extends zp4.a<NumberModel> implements RatingItemsAdapter.a, b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f208004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f208005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f208006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InnerRecyclerView f208007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RatingItemsAdapter f208008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f208009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public NumberModel f208010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f208011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f208012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zp4.b f208013k;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.rating.a$a, reason: collision with other inner class name */
    public final class C3003a extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f208014a;

        public C3003a(int r100) {
            this.f208014a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            super.getItemOffsets(r100, r101, r102, r103);
            int r104 = this.f208014a;
            r100.top = r104;
            r100.bottom = r104;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
    public final /* synthetic */ void a() {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.RatingItemsAdapter.a
    public final void c() {
        zp4.b r100 = this.f208013k;
        if (r100 == null) goto L6;
        r100.e1();
        return;
    }

    public final void d() {
        b r100 = this.f208009g;
        if (r100 == null) goto L9;
        Dialog r101 = r100.f208019e;
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(r101.isShowing());
    L8:
        boolean r103 = Intrinsics.areEqual(r102, Boolean.TRUE);
    L10:
        if (r103 == false) goto L15;
        b r104 = this.f208009g;
        if (r104 == null) goto L16;
        r104.dismiss();
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r102 = null;
        goto L8
    L9:
        r103 = false;
        goto L10
    }

    public void e() {
        FrameLayout r100 = this.f573185a;
        if (r100 == null) goto L21;
        LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_cell_rating_item_content, r100);
        this.f208007e = (InnerRecyclerView) r100.findViewById(R.id.rating_items_recycler);
        RatingItemsAdapter r101 = new RatingItemsAdapter(r100.getContext(), this.f208004b);
        this.f208008f = r101;
        r101.f207999j = this;
        InnerRecyclerView r102 = this.f208007e;
        if (r102 == null) goto L7;
        r102.setLayoutManager(new LinearLayoutManager(r100.getContext()));
    L7:
        InnerRecyclerView r103 = this.f208007e;
        if (r103 == null) goto L10;
        r103.setAdapter(this.f208008f);
    L10:
        InnerRecyclerView r104 = this.f208007e;
        if (r104 == null) goto L13;
        r104.addItemDecoration(new C3003a(n.d(3)));
    L13:
        InnerRecyclerView r105 = this.f208007e;
        if (r105 == null) goto L16;
        r105.t(135.0f);
    L16:
        Context r106 = r100.getContext();
        h r107 = this.f208005c;
        if (r107 == null) goto L19;
        BitableAnalytic r108 = r107.q0();
    L20:
        b r109 = new b(r106, r108);
        r109.f208022h = this;
        this.f208009g = r109;
        return;
    L19:
        r108 = null;
        goto L20
    L21:
        tt5.a.d(this.f208006d, "can not initView empty container");
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
    public final mr4.a o() {
        h r100 = this.f208005c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.o();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
    public final void onDismiss() {
        zp4.b r100 = this.f208013k;
        if (r100 == null) goto L6;
        r100.w1();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
    public final String getTitle() {
        return this.f208012j;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.rating.b.a
    public final void b(Integer r100) {
        zp4.b r101 = this.f208013k;
        if (r101 == null) goto L5;
        r101.u1(r100);
    L5:
        h r102 = this.f208005c;
        if (r102 == null) goto L11;
        BitableAnalytic r103 = r102.q0();
        if (r103 == null) goto L12;
        String r104 = this.f208011i;
        HashMap r105 = new HashMap();
        r105.put("click", "mark_content_change");
        r105.put("mark_type", r104);
        r103.t("ccm_bitable_rating_cell_edit_click", r105);
        return;
    L12:
        return;
    }

    public final void g(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = -1;
    L5:
        FrameLayout r102 = this.f573185a;
        FrameLayout r103 = null;
        if (r102 == null) goto L8;
        ViewParent r104 = r102.getParent();
    L10:
        if ((r104 instanceof FrameLayout) == false) goto L12;
        r103 = (FrameLayout) r104;
    L12:
        if (r103 == null) goto L16;
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
        if (r105 == null) goto L16;
        r105.width = r101;
    L16:
        FrameLayout r106 = this.f573185a;
        if (r106 == null) goto L22;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L23;
        r107.width = r101;
        return;
    L23:
        return;
    L22:
        return;
    L8:
        r104 = null;
        goto L10
    L4:
        r101 = -2;
        goto L5
    }

    public a(boolean r100, h r101) {
        this.f208004b = r100;
        this.f208005c = r101;
        this.f208006d = "RatingBaseCellViewHolde";
    }

    public void f(dp4.a<List<NumberModel>> r110, int r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (this.f208007e == null) goto L121;
        fp4.g r100 = r110.f469587a;
        if (r100 == null) goto L122;
        boolean r101 = r100 instanceof com.bytedance.ee.bear.bitable.card.model.stmodel.field.b;
        boolean r102 = false;
        int r103 = 5;
        int r104 = 1;
        String r105 = ScoreTags.SCORE_TYPE_STAR;
        if (r101 == false) goto L71;
        TableMetaModel.FieldBean r106 = ((com.bytedance.ee.bear.bitable.card.model.stmodel.field.b) r100).f207149n;
        if (r106 == null) goto L123;
        FieldProperty r107 = r106.property;
        if (r107 == null) goto L124;
        Double r108 = r107.getMin();
        if (r108 == null) goto L16;
        int r109 = (int) r108.doubleValue();
    L17:
        Double r112 = r107.getMax();
        if (r112 == null) goto L20;
        int r113 = (int) r112.doubleValue();
    L21:
        RatingItemsAdapter r114 = this.f208008f;
        if (r114 == null) goto L118;
        FieldConfigMetaModel.NumberSymbol r115 = r107.getRating();
        if (r115 == null) goto L27;
        String r116 = r115.getSymbol();
        if (r116 == null) goto L27;
    L28:
        Intrinsics.checkNotNullParameter(r116, "iconId");
        r114.f207993d = r116;
        r114.f207994e = r113;
        r114.f207995f = r109;
        r114.f207997h = false;
    L27:
        r116 = ScoreTags.SCORE_TYPE_STAR;
    L118:
        List<NumberModel> r117 = r110.f469598l;     // Catch: Exception -> L31
    L33:
        if (this.f208004b == false) goto L48;
        if (r117 != null) goto L36;
    L38:
        boolean r118 = false;
    L39:
        if (r118 == true) goto L46;
        int r119 = (r113 - r109) + 1;
        if (r111 <= 0) goto L45;
        if (r119 <= 0) goto L45;
        if ((r119 * n.d(24)) > r111) goto L45;
    L47:
        g(r102);
    L45:
        r102 = true;
        goto L47
    L46:
        r102 = r118;
        goto L47
    L36:
        if (r117.size() <= 1) goto L38;
        r118 = true;
    L48:
        RatingItemsAdapter r120 = this.f208008f;
        if (r120 == null) goto L56;
        r120.f207998i = r102;
        if (r117 == null) goto L55;
        List<NumberModel> r121 = r117;
        if ((!r121.isEmpty()) == false) goto L55;
        r120.f207996g.clear();
        r120.f207996g.addAll(r121);
    L55:
        r120.notifyDataSetChanged();
    L56:
        FieldConfigMetaModel.NumberSymbol r122 = r107.getRating();
        if (r122 == null) goto L62;
        String r123 = r122.getSymbol();
        if (r123 == null) goto L62;
        r105 = r123;
    L62:
        Double r124 = r107.getMin();
        if (r124 == null) goto L65;
        r104 = (int) r124.doubleValue();
    L65:
        Double r125 = r107.getMax();
        if (r125 == null) goto L68;
        r103 = (int) r125.doubleValue();
    L68:
        b r126 = this.f208009g;
        if (r126 == null) goto L125;
        r126.c(r105, Integer.valueOf(r104), Integer.valueOf(r103));
        return;
    L125:
        return;
    L31:
        r117 = new ArrayList();
        goto L33
    L20:
        r113 = 5;
        goto L21
    L16:
        r109 = 1;
        goto L17
    L124:
        return;
    L123:
        return;
    L71:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.model.stmodel.field.NumberField");
        fp4.f r127 = (fp4.f) r100;
        Double r128 = r127.f478250o;
        if (r128 == null) goto L74;
        int r129 = (int) r128.doubleValue();
    L75:
        Double r130 = r127.f478251p;
        if (r130 == null) goto L78;
        int r131 = (int) r130.doubleValue();
    L79:
        String r132 = r127.f478253r;
        this.f208011i = r132;
        this.f208012j = r127.f478256c;
        if (r132 != null) goto L82;
        r132 = ScoreTags.SCORE_TYPE_STAR;
    L82:
        b r133 = this.f208009g;
        if (r133 == null) goto L85;
        r133.c(r132, Integer.valueOf(r129), Integer.valueOf(r131));
    L85:
        RatingItemsAdapter r134 = this.f208008f;
        if (r134 == null) goto L99;
        String r135 = r127.f478253r;
        if (r135 == null) goto L91;
        r105 = r135;
    L91:
        Double r136 = r127.f478251p;
        if (r136 == null) goto L94;
        int r137 = (int) r136.doubleValue();
    L95:
        Double r138 = r127.f478250o;
        if (r138 == null) goto L98;
        r103 = (int) r138.doubleValue();
    L98:
        Intrinsics.checkNotNullParameter(r105, "iconId");
        r134.f207993d = r105;
        r134.f207994e = r137;
        r134.f207995f = r103;
        r134.f207997h = true;
        goto L99
    L94:
        r137 = 1;
    L99:
        this.f208010h = (NumberModel) r110.a(NumberModel.class);
        if (this.f208004b == false) goto L108;
        int r139 = (r131 - r129) + 1;
        if (r111 <= 0) goto L106;
        if (r139 <= 0) goto L106;
        if ((r139 * n.d(24)) > r111) goto L106;
    L107:
        g(r102);
    L106:
        r102 = true;
    L108:
        b r140 = this.f208009g;
        if (r140 == null) goto L111;
        r140.update(this.f208010h);
    L111:
        RatingItemsAdapter r141 = this.f208008f;
        if (r141 == null) goto L127;
        NumberModel r142 = this.f208010h;
        r141.f207998i = r102;
        r141.f207996g.clear();
        if (r142 == null) goto L116;
        r141.f207996g.add(r142);
    L116:
        r141.notifyDataSetChanged();
        return;
    L127:
        return;
    L78:
        r131 = 5;
        goto L79
    L74:
        r129 = 1;
        goto L75
    L122:
        return;
    }
}
