package com.bytedance.ee.bear.bitable.card.view.cell.rating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;
import com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.RatingBarModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002@AB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0007J\u0010\u0010-\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0007J \u0010/\u001a\u00020(2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001022\b\b\u0002\u0010\u0018\u001a\u00020\u0007J\u0006\u00103\u001a\u00020(J\u001c\u00104\u001a\u00060\u0002R\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0011H\u0016J\u001c\u00108\u001a\u00020(2\n\u00109\u001a\u00060\u0002R\u00020\u00002\u0006\u0010:\u001a\u00020\u0011H\u0016J\b\u0010;\u001a\u00020\u0011H\u0016J\b\u0010<\u001a\u00020\u0011H\u0002J\u0018\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006B"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/rating/RatingItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/rating/RatingItemsAdapter$RatingItemViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar$OnStarSizeUpdateListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isPageRecord", "", "<init>", "(Landroid/content/Context;Z)V", "getContext", "()Landroid/content/Context;", "()Z", "TAG", "", "mRatingIconId", "mMaxRating", "", "mMinRating", "mRatingList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/NumberModel;", "Lkotlin/collections/ArrayList;", "mIsEditMode", "needFullWidth", "mOnRatingClickListener", "Lcom/bytedance/ee/bear/bitable/card/view/cell/rating/RatingItemsAdapter$OnRatingClickListener;", "mRatingStarSizeInfo", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/RatingStarSizeInfo;", "useCardRatingBar", "getUseCardRatingBar", "setUseCardRatingBar", "(Z)V", "cardRatingBarCreator", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/creator/RatingBarCreator;", "getCardRatingBarCreator", "()Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/creator/RatingBarCreator;", "setCardRatingBarCreator", "(Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/creator/RatingBarCreator;)V", "setRatingIconInfo", "", "iconId", "maxRating", "minRating", "isEditMode", "setRatingClickListener", "onRatingClickListener", "setRating", "rating", "ratings", "", "clearData", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getItemCountInner", "onStarSizeChange", "starSize", GXTemplateKey.FLEXBOX_PADDING, "RatingItemViewHolder", "OnRatingClickListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RatingItemsAdapter extends RecyclerView.Adapter<RatingItemViewHolder> implements BTRatingBar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f207990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f207991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f207992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f207993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f207994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f207995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<NumberModel> f207996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f207997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f207998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f207999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final sr4.e f208000k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f208001l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p f208002m;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/rating/RatingItemsAdapter$RatingItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/rating/RatingItemsAdapter;Landroid/view/View;)V", "ratingBar", "Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar;", "kotlin.jvm.PlatformType", "getRatingBar", "()Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar;", "setRatingBar", "(Lcom/bytedance/ee/bear/bitable/common/widgets/rating/BTRatingBar;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class RatingItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BTRatingBar f208003a;

        public RatingItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f208003a = (BTRatingBar) r100.findViewById(R.id.cell_rating);
        }
    }

    public interface a {
        void c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f207997h == false) goto L6;
    L7:
        return 1;
    L6:
        if (this.f207996g.isEmpty() == true) goto L7;
        return this.f207996g.size();
    }

    public final Context getContext() {
        return this.f207990a;
    }

    public RatingItemsAdapter(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f207990a = r100;
        this.f207991b = r101;
        this.f207992c = "RatingItemsAdapter";
        this.f207993d = "";
        this.f207994e = 5;
        this.f207995f = 1;
        this.f207996g = new ArrayList();
        this.f208000k = new sr4.e(20, 4, null);
        this.f208002m = new p(new iv4.b(false, 0.0f, 0, 0, 15));
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar.b
    public final void O0(int r100, int r101) {
        sr4.e r102 = this.f208000k;
        if (r102 == null) goto L5;
        r102.f543227a = r100;
    L5:
        if (r102 == null) goto L8;
        r102.f543228b = r101;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        RatingItemViewHolder r112 = (RatingItemViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        Integer r100 = null;
        if (this.f208001l == false) goto L18;
        if (this.f207996g.isEmpty() == false) goto L7;
        NumberModel r113 = null;
    L8:
        p r101 = this.f208002m;
        BTRatingBar r102 = r112.f208003a;
        if (r113 == null) goto L13;
        Double r103 = r113.getNumberValue();
        if (r103 == null) goto L13;
        r100 = Integer.valueOf((int) r103.doubleValue());
    L13:
        int r104 = this.f207994e;
        int r105 = this.f207995f;
        String r106 = this.f207993d;
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        RatingBarModel r107 = new RatingBarModel(r100, r104, r105, r106);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "kitView");
        Intrinsics.checkNotNullParameter(r107, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r101.f216184e.f543227a = 16;
        r101.h(r102, r107);
        r112.itemView.setOnClickListener(new f(this, r113));
        return;
    L7:
        r113 = (NumberModel) ListProtector.get(this.f207996g, r111);
        goto L8
    L18:
        if (this.f207996g.isEmpty() == false) goto L20;
        NumberModel r114 = null;
    L21:
        boolean r108 = this.f207991b;
        if (r108 == false) goto L24;
        boolean r109 = this.f207998i;
    L26:
        if (r108 == false) goto L33;
        ViewGroup.LayoutParams r115 = r112.f208003a.getLayoutParams();
        if ((r115 instanceof LinearLayout.LayoutParams) == false) goto L30;
        LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) r115;
    L31:
        if (r116 == null) goto L33;
        r116.leftMargin = 0;
        goto L33
    L30:
        r116 = null;
    L33:
        tt5.a.b(this.f207992c, "onBindViewHolder");
        String r117 = this.f207993d;
        if (r117 == null) goto L68;
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r118 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        if (com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.c(r117) == false) goto L50;
        ArrayList r119 = new ArrayList();
        int r120 = this.f207995f;
        int r121 = this.f207994e;
        if (r120 > r121) goto L44;
    L39:
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r122 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.c r123 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.b(String.valueOf(r120));
        if (r123 == null) goto L42;
        r119.add(r123);
    L42:
        if (r120 == r121) goto L44;
        r120 = r120 + 1;
    L44:
        BTRatingBar r124 = r112.f208003a;
        BTRatingBar.a r125 = new BTRatingBar.a();
        if (r114 == null) goto L49;
        Double r126 = r114.getNumberValue();
        if (r126 == null) goto L49;
        r100 = Integer.valueOf((int) r126.doubleValue());
    L49:
        r125.f210048e = r100;
        r125.f210047d = Integer.valueOf(this.f207995f);
        r125.f210046c = Integer.valueOf(this.f207994e);
        r125.f210052i = true;
        r125.f210049f = Boolean.FALSE;
        r125.f210053j = r119;
        r125.f210050g = true;
        r125.f210054k = Boolean.valueOf(r109);
        r125.f210051h = this.f208000k;
        r124.setRatingBarInfo(r125);
    L64:
        r112.f208003a.setRatingStarSizeUpdateListener(this);
        r112.itemView.setOnClickListener(new g(this, r114));
        return;
    L50:
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.b r127 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.a(this.f207993d);
        BTRatingBar r128 = r112.f208003a;
        BTRatingBar.a r129 = new BTRatingBar.a();
        if (r114 == null) goto L55;
        Double r130 = r114.getNumberValue();
        if (r130 == null) goto L55;
        Integer r131 = Integer.valueOf((int) r130.doubleValue());
    L56:
        r129.f210048e = r131;
        r129.f210046c = Integer.valueOf(this.f207994e);
        r129.f210047d = Integer.valueOf(this.f207995f);
        if (r127 == null) goto L59;
        Integer r132 = Integer.valueOf(r127.f210057a);
    L60:
        r129.f210044a = r132;
        if (r127 == null) goto L63;
        r100 = Integer.valueOf(r127.f210058b);
    L63:
        r129.f210045b = r100;
        r129.f210052i = false;
        r129.f210049f = Boolean.FALSE;
        r129.f210050g = true;
        r129.f210054k = Boolean.valueOf(r109);
        r129.f210051h = this.f208000k;
        r128.setRatingBarInfo(r129);
        goto L64
    L59:
        r132 = null;
    L55:
        r131 = null;
        goto L56
    L68:
        return;
    L24:
        r109 = true;
        goto L26
    L20:
        r114 = (NumberModel) ListProtector.get(this.f207996g, r111);
        goto L21
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (this.f208001l == false) goto L6;
        View r102 = this.f208002m.b(this.f207990a, r100);
        r102.setId(R.id.cell_rating);
        return new RatingItemViewHolder(r102);
    L6:
        return new RatingItemViewHolder(LayoutInflater.from(this.f207990a).inflate(R.layout.bitable_cell_rating_item_inner_content, r100, false));
    }
}
