package com.bytedance.locallife.poi.poidetail.container.component.view.dcd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.dito.baseview.RoundLinearLayout;
import com.bytedance.locallife.model.poi.resp.PoiDcdProductItem;
import com.bytedance.locallife.model.poi.resp.PoiProduct;
import com.bytedance.locallife.model.poi.resp.PoiProductInfo;
import com.bytedance.locallife.poi.poidetail.container.mob.PoiMobHelper;
import com.bytedance.locallife.poi.poidetail.container.mob.h;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0002R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u001a\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001d\u001a\n \u0016*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\t¨\u0006&"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/component/view/dcd/PoiExpDcdProductWidget;", "Lcom/bytedance/locallife/dito/baseview/RoundLinearLayout;", "Lcom/bytedance/locallife/poi/poidetail/container/component/view/dcd/ScrollToOpenLayout$b;", "", "getSize", "Lcom/bytedance/dux/text/DuxTextView;", "b", "Lkotlin/Lazy;", "getMTitle", "()Lcom/bytedance/dux/text/DuxTextView;", "mTitle", "Landroidx/recyclerview/widget/RecyclerView;", "c", "getMProductList", "()Landroidx/recyclerview/widget/RecyclerView;", "mProductList", "Landroid/widget/ImageView;", "d", "getMArrow", "()Landroid/widget/ImageView;", "mArrow", "Lcom/bytedance/locallife/poi/poidetail/container/component/view/dcd/ScrollToOpenLayout;", "kotlin.jvm.PlatformType", "e", "getScrollToOpen", "()Lcom/bytedance/locallife/poi/poidetail/container/component/view/dcd/ScrollToOpenLayout;", "scrollToOpen", "f", "getTextView3", "textView3", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiExpDcdProductWidget extends RoundLinearLayout implements ScrollToOpenLayout.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f263800j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f263801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f263802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f263803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f263804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f263805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f263806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PoiDcdProductItem f263807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PoiBundle f263808i;

    public static final class a {
    }

    static {
    }

    public PoiExpDcdProductWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiExpDcdProductWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final ImageView getMArrow() {
        return (ImageView) this.f263803d.getValue();
    }

    private final RecyclerView getMProductList() {
        return (RecyclerView) this.f263802c.getValue();
    }

    private final DuxTextView getMTitle() {
        return (DuxTextView) this.f263801b.getValue();
    }

    private final ScrollToOpenLayout getScrollToOpen() {
        return (ScrollToOpenLayout) this.f263804e.getValue();
    }

    private final int getSize() {
        PoiDcdProductItem r100 = this.f263807h;
        if (r100 == null) goto L9;
        PoiProductInfo r101 = r100.productInfo;
        if (r101 == null) goto L9;
        List<PoiProduct> r102 = r101.products;
        if (r102 == null) goto L9;
        return r102.size();
    L9:
        return 0;
    }

    private final DuxTextView getTextView3() {
        return (DuxTextView) this.f263805f.getValue();
    }

    @Override // com.bytedance.locallife.poi.poidetail.container.component.view.dcd.ScrollToOpenLayout.b
    public final void a() {
        if (this.f263807h == null) goto L6;
        d("slide_left");
        return;
    }

    public final void d(String r110) {
        PoiBundle r100 = this.f263808i;
        if (r100 == null) goto L37;
        PoiDcdProductItem r101 = this.f263807h;
        if (r101 == null) goto L38;
        PoiProductInfo r102 = r101.productInfo;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.isMoreUrlEmpty() == true) goto L40;
        String r103 = null;
        if (r100.isFromLive == false) goto L23;
        mq6.c r104 = new mq6.c();
        mq6.a r111 = mq6.c.a.f514894a;
        r104.g("page_type", "half_screen");
        r104.g("anchor_id", r100.anchorId);
        r104.g("room_id", r100.roomId);
        PoiDcdProductItem r112 = this.f263807h;
        if (r112 == null) goto L18;
        PoiProductInfo r113 = r112.productInfo;
        if (r113 == null) goto L18;
        String r114 = r113.supplierId;
        if (r114 == null) goto L18;
    L19:
        r104.g("supplier_id", r114);
        r104.g("enter_from", "live");
        r104.g("enter_method", r110);
        r104.g("poi_id", r100.poiId);
        r104.g("content_type", "home_stay");
        PoiBundle r115 = this.f263808i;
        if (r115 == null) goto L22;
        r103 = r115.awemeid;
    L22:
        r104.g("video_id", r103);
        PoiMobHelper.c(r100, "project_click_more", r104);
    L35:
        int r116 = com.bytedance.locallife.poi.poidetail.container.component.view.dcd.a.f263819a;
        com.bytedance.locallife.poi.poidetail.container.component.view.dcd.a.a(getContext(), r102.getMoreUrl());
        return;
    L18:
        r114 = "";
        goto L19
    L23:
        mq6.c r105 = new mq6.c();
        mq6.a r117 = mq6.c.a.f514894a;
        r105.g("enter_from", "poi_page");
        r105.g("enter_method", r110);
        PoiDcdProductItem r118 = this.f263807h;
        if (r118 == null) goto L26;
        String r119 = r118.poiId;
    L27:
        r105.g("poi_id", r119);
        PoiDcdProductItem r120 = this.f263807h;
        if (r120 == null) goto L30;
        String r121 = r120.getSpSource();
    L31:
        r105.g("content_type", r121);
        PoiBundle r122 = this.f263808i;
        if (r122 == null) goto L34;
        r103 = r122.awemeid;
    L34:
        r105.g("video_id", r103);
        PoiMobHelper.c(r100, "project_click_more", r105);
        goto L35
    L30:
        r121 = null;
        goto L31
    L26:
        r119 = null;
        goto L27
    L40:
        return;
    L38:
        return;
    }

    public final void c(PoiDcdProductItem r100, final PoiBundle r101) {
        if (this.f263807h == null) goto L5;
        return;
    L5:
        this.f263808i = r101;
        this.f263807h = r100;
        PoiProductInfo r102 = r100.productInfo;
        if (r102 == null) goto L20;
        getMTitle().setText(r102.title);
        if (CollectionUtils.isEmpty(r102.products) == true) goto L16;
        boolean r103 = !r102.isMoreUrlEmpty();
        int r104 = r102.getSize();
        if (r103 == true) goto L12;
    L14:
        getScrollToOpen().setOnScrollToEndListener(null);
        getTextView3().setText(getContext().getString(R.string.no_more));
    L15:
        PoiExpProductAdapter r105 = new PoiExpProductAdapter(r102, r101);
        LinearLayoutManager r106 = new LinearLayoutManager(getContext());
        r106.setOrientation(0);
        getMProductList().addItemDecoration(new PoiExpDcdProductWidget$bind$2$1());
        getMProductList().addOnScrollListener(new PoiExpDcdProductWidget$bind$2$2(this, r101));
        getMProductList().setLayoutManager(r106);
        getMProductList().setAdapter(r105);
        goto L16
    L12:
        if (r104 < 5) goto L14;
        getScrollToOpen().setOnScrollToEndListener(this);
        getTextView3().setText(getContext().getString(R.string.feed_guide_title));
    L16:
        ImageView r107 = getMArrow();
        r107.setOnClickListener(new d(r107, this));
        DuxTextView r108 = getMTitle();
        if (r108 == null) goto L21;
        h.a(r108, 15.0f);
        return;
    L21:
        return;
    }

    public PoiExpDcdProductWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.saas_poi_item_exp_follow_poi_product_info, this);
        setBackgroundColor(ContextCompat.getColor(r100, R.color.POIBgPrimary));
        this.f263801b = LazyKt.lazy(new PoiExpDcdProductWidget$mTitle$2(this));
        this.f263802c = LazyKt.lazy(new PoiExpDcdProductWidget$mProductList$2(this));
        this.f263803d = LazyKt.lazy(new PoiExpDcdProductWidget$mArrow$2(this));
        this.f263804e = LazyKt.lazy(new PoiExpDcdProductWidget$scrollToOpen$2(this));
        this.f263805f = LazyKt.lazy(new PoiExpDcdProductWidget$textView3$2(this));
    }

    public /* synthetic */ PoiExpDcdProductWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
