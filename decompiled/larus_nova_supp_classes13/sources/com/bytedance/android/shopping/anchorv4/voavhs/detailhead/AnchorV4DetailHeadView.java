package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3CommonBannerView;
import com.bytedance.android.shopping.anchorv3.repository.dto.AttrItem;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesComponent;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesSkusStruct;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailTagCard;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormat;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormatGroup;
import com.bytedance.android.shopping.anchorv3.repository.dto.SkuSubProductsStruct;
import com.bytedance.android.shopping.anchorv3.utils.c0;
import com.bytedance.android.shopping.anchorv3.view.AnchorV4QualificationNewDesignView;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.buynow.data.model.TTPayCode;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.commerce.uikit.flowlayout.TagFlowLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u00013\u0018\u00002\u00020\u0001:\u0001\u0007B)\b\u0007\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR#\u0010\u0010\u001a\n \u0006*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0015\u001a\n \u0006*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u001a\u001a\n \u0006*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001f\u001a\n \u0006*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\u001eR#\u0010$\u001a\n \u0006*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\"\u0010#R#\u0010)\u001a\n \u0006*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b'\u0010(R#\u0010,\u001a\n \u0006*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\b\u001a\u0004\b+\u0010(R#\u0010/\u001a\n \u0006*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b.\u0010(R#\u00102\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\b\u001a\u0004\b1\u0010\nR\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\b\u001a\u0004\b5\u00106¨\u0006@"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailHeadView;", "Landroid/widget/RelativeLayout;", "", "", "getShowParamsList", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getRootView", "()Landroid/widget/LinearLayout;", "rootView", "Landroid/widget/FrameLayout;", "b", "getHeaderContainer", "()Landroid/widget/FrameLayout;", "headerContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "getTagCardView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "tagCardView", "Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", "d", "getExpandableLayoutContainer", "()Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", "expandableLayoutContainer", "Landroid/widget/TextView;", "e", "getGoodDetailTitle", "()Landroid/widget/TextView;", "goodDetailTitle", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4;", "f", "getExpandableLayout", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4;", "expandableLayout", "Landroid/view/View;", "g", "getExpandableLayoutArea", "()Landroid/view/View;", "expandableLayoutArea", "h", "getCombineDetailContentView", "combineDetailContentView", "i", "getCombineDetailContentOptView", "combineDetailContentOptView", "l", "getLlBannerItems", "llBannerItems", "com/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2$a", "w", "getUpdateCombineProductTabJsEventSubscriber", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2$a;", "updateCombineProductTabJsEventSubscriber", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailHeadView extends RelativeLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public TabLayout j;
    public AutoHeightViewPager k;
    public final Lazy l;
    public String m;
    public t n;
    public d o;
    public final List<u> p;
    public AnchorV3CommonBannerView q;
    public ArrayList<AnchorV4DetailSkuVO> r;
    public final int s;
    public final int t;
    public boolean u;
    public boolean v;
    public final Lazy w;

    public static final class a {
    }

    static {
    }

    public AnchorV4DetailHeadView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4DetailHeadView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final View getCombineDetailContentOptView() {
        return (View) this.i.getValue();
    }

    private final View getCombineDetailContentView() {
        return (View) this.h.getValue();
    }

    private final ExpandableLinearLayoutV4 getExpandableLayout() {
        return (ExpandableLinearLayoutV4) this.f.getValue();
    }

    private final View getExpandableLayoutArea() {
        return (View) this.g.getValue();
    }

    private final RoundedLinearLayout getExpandableLayoutContainer() {
        return (RoundedLinearLayout) this.d.getValue();
    }

    private final TextView getGoodDetailTitle() {
        return (TextView) this.e.getValue();
    }

    private final FrameLayout getHeaderContainer() {
        return (FrameLayout) this.b.getValue();
    }

    private final LinearLayout getLlBannerItems() {
        return (LinearLayout) this.l.getValue();
    }

    private final LinearLayout getRootView() {
        return (LinearLayout) this.a.getValue();
    }

    private final SimpleDraweeView getTagCardView() {
        return (SimpleDraweeView) this.c.getValue();
    }

    private final AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2.a getUpdateCombineProductTabJsEventSubscriber() {
        return (AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2.a) this.w.getValue();
    }

    private final List<String> getShowParamsList() {
        ArrayList r0 = new ArrayList();
        d r1 = this.o;
        if (r1 == null) goto L17;
        List<ProductFormatGroup> r2 = r1.c;
        if (r2 == null) goto L17;
        Iterator<T> r3 = r2.iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L17;
        List r5 = ((ProductFormatGroup) r3.next()).getProductFormat();
        if (r5 == null) goto L8;
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L8;
        ProductFormat r7 = (ProductFormat) r6.next();
        if (r4 >= getExpandableLayout().getMaxItemCount()) goto L13;
        r4 = r4 + 1;
        r0.add(r7.getName());
    L17:
        return r0;
    }

    public final void e() {
        List<String> r1 = getShowParamsList();
        int r2 = r1.size();
        t r3 = this.n;
        String r7 = "1";
        if (r3 == null) goto L33;
        d r15 = this.o;
        if (r15 == null) goto L12;
        List<ProductFormatGroup> r16 = r15.c;
        if (r16 == null) goto L12;
        if ((!r16.isEmpty()) != true) goto L12;
        if (com.bytedance.android.shopping.anchorv4.log.g.a(getExpandableLayout()) == false) goto L12;
    L22:
        boolean r17 = true;
    L24:
        if (r17 == false) goto L26;
        t r18 = r3;
    L27:
        if (r18 == null) goto L33;
        Pair[] r4 = new Pair[4];
        r4[0] = TuplesKt.to("params_cnt", Integer.valueOf(r2));
        if (r2 >= 5) goto L31;
        Object r19 = "0";
    L32:
        r4[1] = TuplesKt.to("is_fold", r19);
        r4[2] = TuplesKt.to("params_list", CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null));
        r4[3] = TuplesKt.to("btm", "a1.b8094.c747297.0");
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r18, "show_product_feature", MapsKt.mapOf(r4), false, "pdp_module_show", null, null, null, 228);
        goto L33
    L31:
        r19 = "1";
        goto L32
    L26:
        r18 = null;
    L12:
        d r110 = this.o;
        if (r110 == null) goto L23;
        DetailCombinePropertiesComponent r111 = r110.f;
        if (r111 == null) goto L23;
        List r112 = r111.getSkus();
        if (r112 == null) goto L23;
        if ((!r112.isEmpty()) != true) goto L23;
        if (com.bytedance.android.shopping.anchorv4.log.g.a(this.k) == true) goto L22;
    L23:
        r17 = false;
    L33:
        t r5 = this.n;
        if (r5 == null) goto L48;
        ExpandableLinearLayoutV4 r9 = getExpandableLayout();
        boolean r11 = this.u;
        r9.h = r11;
        View r10 = r9.c(r11);
        if (r10 == null) goto L38;
        boolean r12 = com.bytedance.android.shopping.anchorv4.log.g.a(r10);
    L39:
        if (r12 == false) goto L41;
        t r113 = r5;
    L42:
        if (r113 == null) goto L48;
        Pair[] r6 = new Pair[3];
        r6[0] = TuplesKt.to("params_cnt", Integer.valueOf(r2));
        if (r2 >= 5) goto L46;
        Object r13 = "0";
    L47:
        r6[1] = TuplesKt.to("is_fold", r13);
        r6[2] = TuplesKt.to("params_list", CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r113, "show_product_feature_unfold", MapsKt.mapOf(r6), false, null, null, null, "show_product_feature_unfold", TTPayCode.TT_CJ_PAY_ANTI_FRAUD_CANCELED);
        goto L48
    L46:
        r13 = "1";
        goto L47
    L41:
        r113 = null;
        goto L42
    L38:
        r12 = false;
    L48:
        t r8 = this.n;
        if (r8 == null) goto L63;
        ExpandableLinearLayoutV4 r14 = getExpandableLayout();
        boolean r114 = this.u;
        r14.h = r114;
        View r20 = r14.c(r114);
        if (r20 == null) goto L53;
        boolean r21 = com.bytedance.android.shopping.anchorv4.log.g.a(r20);
    L54:
        if (r21 == false) goto L56;
        t r115 = r8;
    L57:
        if (r115 == null) goto L63;
        Pair[] r22 = new Pair[3];
        r22[0] = TuplesKt.to("params_cnt", Integer.valueOf(r2));
        if (r2 >= 5) goto L61;
        Object r23 = "0";
    L62:
        r22[1] = TuplesKt.to("is_fold", r23);
        r22[2] = TuplesKt.to("params_list", CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r115, "pdp_module_show", MapsKt.mapOf(r22), false, null, null, null, "pdp_module_show_product_feature_show", TTPayCode.TT_CJ_PAY_ANTI_FRAUD_CANCELED);
        goto L63
    L61:
        r23 = "1";
        goto L62
    L56:
        r115 = null;
        goto L57
    L53:
        r21 = false;
    L63:
        Iterator r24 = ((ArrayList) this.p).iterator();
    L65:
        if (r24.hasNext() == false) goto L86;
        u r25 = (u) r24.next();
        t r116 = this.n;
        if (r116 != null) goto L69;
    L74:
        t r117 = this.n;
        if (r117 == null) goto L65;
        if (com.bytedance.android.shopping.anchorv4.log.g.a(r25.a()) == false) goto L79;
        t r118 = r117;
    L80:
        if (r118 == null) goto L65;
        Pair[] r119 = new Pair[3];
        TextView r120 = r25.a();
        if (r120 == null) goto L84;
        CharSequence r121 = r120.getText();
    L85:
        r119[0] = TuplesKt.to("label_name", r121);
        r119[1] = TuplesKt.to("shop_id", this.m);
        r119[2] = TuplesKt.to("character_type", r25.b());
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r118, "info_explanation_entrance_show", MapsKt.mapOf(r119), false, null, null, null, null, 244);
        goto L65
    L84:
        r121 = null;
        goto L85
    L79:
        r118 = null;
        goto L80
    L69:
        if (com.bytedance.android.shopping.anchorv4.log.g.a(r25.c()) == false) goto L71;
        t r122 = r116;
    L72:
        if (r122 == null) goto L74;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r122, "brand_logo_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("shop_id", this.m), TuplesKt.to("character_type", r25.b())}), false, null, null, null, null, 244);
        goto L74
    L71:
        r122 = null;
        goto L72
    L86:
        String r26 = com.bytedance.android.shopping.extensions.j.c(2131894093);
        t r27 = this.n;
        if (r27 != null) goto L89;
    L94:
        d r28 = this.o;
        if (r28 == null) goto L119;
        DetailCombinePropertiesComponent r29 = r28.f;
        if (r29 == null) goto L119;
        List r30 = r29.getSkus();
        if (r30 == null) goto L119;
        if (r30.size() > 1) goto L103;
    L105:
        boolean r31 = false;
    L106:
        if (r31 == true) goto L109;
        r30 = null;
    L109:
        if (r30 == null) goto L119;
        if (((DetailCombinePropertiesSkusStruct) CollectionsKt.getOrNull(r30, 0)) == null) goto L119;
        int r32 = b.a;
        t r123 = this.n;
        d r33 = this.o;
        if (r33 == null) goto L115;
        DetailCombinePropertiesComponent r34 = r33.f;
    L116:
        String r35 = b.b(r34);
        Intrinsics.checkNotNullParameter(r35, "tabType");
        if (r123 == null) goto L119;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r123, "product_feature_tab_show", MapsKt.mapOf(TuplesKt.to("tab_type", r35)), false, null, null, null, null, 244);
        goto L119
    L115:
        r34 = null;
        goto L116
    L103:
        if (com.bytedance.android.shopping.anchorv4.log.g.a(this.j) == false) goto L105;
        r31 = true;
    L119:
        ViewPager r36 = this.k;
        if (r36 != null) goto L122;
        return;
    L122:
        if (r36.getVisibility() != 0) goto L212;
        AutoHeightViewPager r37 = this.k;
        if (r37 == null) goto L209;
        PagerAdapter r38 = r37.getAdapter();
        if ((r38 instanceof AnchorV4DetailCombinePropertyPagerAdapter) == true) goto L129;
        r38 = null;
    L129:
        AnchorV4DetailCombinePropertyPagerAdapter r39 = (AnchorV4DetailCombinePropertyPagerAdapter) r38;
        if (r39 == null) goto L210;
        Fragment r40 = r39.getItem(r37.getCurrentItem());
        if ((r40 instanceof AnchorV4DetailSkuPropertiesFragment) == true) goto L134;
        r40 = null;
    L134:
        AnchorV4DetailSkuPropertiesFragment r41 = (AnchorV4DetailSkuPropertiesFragment) r40;
        if (r41 == null) goto L211;
        ExpandableLinearLayoutV4 r42 = r41.j;
        if (r42 == null) goto L159;
        boolean r43 = r41.S90();
        r42.h = r43;
        View r44 = r42.c(r43);
        if (r44 == null) goto L141;
        boolean r45 = com.bytedance.android.shopping.anchorv4.log.g.a(r44);
    L142:
        if (r45 == false) goto L159;
        AnchorV4DetailSkuVO r46 = r41.k.getVo();
        if (r46 == null) goto L146;
        boolean r47 = r46.getShowBottomView();
    L147:
        int r48 = b.a;
        t r124 = r41.k.getViewModel();
        AnchorV4DetailSkuVO r49 = r41.k.getVo();
        if (r49 == null) goto L152;
        List<AnchorV4SubProduct> r50 = r49.getSubProducts();
        if (r50 == null) goto L152;
        int r51 = r50.size();
    L153:
        if (r124 == null) goto L159;
        Pair[] r125 = new Pair[2];
        r125[0] = TuplesKt.to("params_cnt", Integer.valueOf(r51));
        if (r47 == true) goto L158;
        r7 = "0";
    L158:
        r125[1] = TuplesKt.to("is_fold", r7);
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r124, "show_product_feature_unfold", MapsKt.mapOf(r125), false, null, null, null, "show_product_feature_unfold", TTPayCode.TT_CJ_PAY_ANTI_FRAUD_CANCELED);
    L152:
        r51 = 0;
        goto L153
    L146:
        r47 = false;
        goto L147
    L141:
        r45 = false;
    L159:
        Iterator r52 = ((ArrayList) r41.l).iterator();
    L161:
        if (r52.hasNext() == false) goto L213;
        u r53 = (u) r52.next();
        t r54 = r41.k.getViewModel();
        if (r54 != null) goto L165;
    L176:
        t r55 = r41.k.getViewModel();
        if (r55 == null) goto L161;
        if (com.bytedance.android.shopping.anchorv4.log.g.a(r53.a()) == false) goto L181;
        t r126 = r55;
    L182:
        if (r126 == null) goto L161;
        Pair[] r56 = new Pair[2];
        TextView r57 = r53.a();
        if (r57 == null) goto L186;
        CharSequence r58 = r57.getText();
    L187:
        r56[0] = TuplesKt.to("label_name", r58);
        t r59 = r41.k.getViewModel();
        if (r59 == null) goto L192;
        CommonMeta r60 = r59.a();
        if (r60 == null) goto L192;
        String r61 = r60.getShopId();
    L193:
        r56[1] = TuplesKt.to("shop_id", r61);
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r126, "info_explanation_entrance_show", MapsKt.mapOf(r56), false, null, null, null, null, 244);
    L192:
        r61 = null;
        goto L193
    L186:
        r58 = null;
        goto L187
    L181:
        r126 = null;
        goto L182
    L165:
        if (com.bytedance.android.shopping.anchorv4.log.g.a(r53.c()) == false) goto L167;
        t r127 = r54;
    L168:
        if (r127 == null) goto L176;
        t r62 = r41.k.getViewModel();
        if (r62 == null) goto L174;
        CommonMeta r63 = r62.a();
        if (r63 == null) goto L174;
        String r64 = r63.getShopId();
    L175:
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r127, "brand_logo_show", MapsKt.mapOf(TuplesKt.to("shop_id", r64)), false, null, null, null, null, 244);
    L174:
        r64 = null;
        goto L175
    L167:
        r127 = null;
        goto L168
    L213:
        return;
    L211:
        return;
    L210:
        return;
    L209:
        return;
    L212:
        return;
    L89:
        if (com.bytedance.android.shopping.anchorv4.log.g.a(this.q) == false) goto L91;
        t r128 = r27;
    L92:
        if (r128 == null) goto L94;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r128, "info_explanation_entrance_show", MapsKt.mapOf(TuplesKt.to("label_name", r26)), false, null, null, null, null, 244);
        goto L94
    L91:
        r128 = null;
        goto L92
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d r0 = this.o;
        if (r0 == null) goto L14;
        DetailCombinePropertiesComponent r1 = r0.f;
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r1, "$this$getSkusCount");
        List r2 = r1.getSkus();
        if (r2 == null) goto L9;
        int r3 = r2.size();
    L11:
        if (Integer.valueOf(r3).intValue() <= 1) goto L16;
        ECLiveHybridUtil.m("SKU_TAG_CHANGE_IN_PRODUCT_PARAMS_SUPERNATANT", getUpdateCombineProductTabJsEventSubscriber());
        return;
    L16:
        return;
    L9:
        r3 = 0;
        goto L11
    L15:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ECLiveHybridUtil.p("SKU_TAG_CHANGE_IN_PRODUCT_PARAMS_SUPERNATANT", getUpdateCombineProductTabJsEventSubscriber());
    }

    public static final /* synthetic */ ExpandableLinearLayoutV4 a(AnchorV4DetailHeadView r0) {
        return r0.getExpandableLayout();
    }

    public static final /* synthetic */ LinearLayout b(AnchorV4DetailHeadView r0) {
        return r0.getRootView();
    }

    public static final void c(AnchorV4DetailHeadView r11) {
        r11.getClass();
        Activity r1 = ECAppInfoService.e.getCurrentActivity();
        if (r1 == null) goto L30;
        d r0 = r11.o;
        if (r0 == null) goto L30;
        String r2 = r0.g;
        if (r2 == null) goto L30;
        int r3 = c.a;
        t r4 = r11.n;
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter("", "activeId");
        Intrinsics.checkNotNullParameter(r1, "context");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L25
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Throwable -> L25
        r6.put("active_id", "");     // Catch: Throwable -> L25
        if (r4 == null) goto L16;
        CommonMeta r7 = r4.a();     // Catch: Throwable -> L25
        if (r7 == null) goto L16;
        String r8 = r7.getPromotionId();     // Catch: Throwable -> L25
        if (r8 == null) goto L16;
        r6.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r8);     // Catch: Throwable -> L25
    L16:
        if (r4 == null) goto L20;
        CommonMeta r9 = r4.a();     // Catch: Throwable -> L25
        if (r9 == null) goto L20;
        LinkedHashMap r10 = new LinkedHashMap();     // Catch: Throwable -> L25
        int r12 = com.bytedance.android.shopping.anchorv4.containers.b.a;     // Catch: Throwable -> L25
        r10.put("track_params", com.bytedance.android.shopping.anchorv4.containers.b.a(r9, r4.b()).toString());     // Catch: Throwable -> L25
        r6.put("mega_object", r10.toString());     // Catch: Throwable -> L25
    L20:
        String r13 = p0.b(r2, r6);     // Catch: Throwable -> L25
        if (r13 != null) goto L23;
        r13 = r2;
    L23:
        ECLiveHybridUtil.k(r1, r13, false, false, false, null, 252);     // Catch: Throwable -> L25
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L30;
        ECExceptionMonitor.e(r15);
    L25:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L30:
        List<String> r17 = r11.getShowParamsList();
        int r18 = r17.size();
        int r19 = b.a;
        b.a(r11.n, r18, true, CollectionsKt.joinToString$default(r17, ",", null, null, 0, null, null, 62, null));
    }

    public AnchorV4DetailHeadView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        if (r1 == null) goto L5;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r1).aU(2131560485, this, true);
    L5:
        this.a = LazyKt.lazy(new AnchorV4DetailHeadView$rootView$2(this));
        this.b = LazyKt.lazy(new AnchorV4DetailHeadView$headerContainer$2(this));
        this.c = LazyKt.lazy(new AnchorV4DetailHeadView$tagCardView$2(this));
        this.d = LazyKt.lazy(new AnchorV4DetailHeadView$expandableLayoutContainer$2(this));
        this.e = LazyKt.lazy(new AnchorV4DetailHeadView$goodDetailTitle$2(this));
        this.f = LazyKt.lazy(new AnchorV4DetailHeadView$expandableLayout$2(this));
        this.g = LazyKt.lazy(new AnchorV4DetailHeadView$expandableLayoutArea$2(this));
        this.h = LazyKt.lazy(new AnchorV4DetailHeadView$combineDetailContentView$2(this));
        this.i = LazyKt.lazy(new AnchorV4DetailHeadView$combineDetailContentOptView$2(this));
        this.l = LazyKt.lazy(new AnchorV4DetailHeadView$llBannerItems$2(this));
        this.p = new ArrayList();
        this.r = new ArrayList();
        this.s = 154;
        this.t = 22;
        this.w = LazyKt.lazy(new AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2(this));
    }

    public final void d(d r26, String r27, t r28) {
        Intrinsics.checkNotNullParameter(r26, "detailHeadVO");
        Intrinsics.checkNotNullParameter(r28, "anchorV4VM");
        if (this.o == null) goto L5;
        return;
    L5:
        this.m = r27;
        this.n = r28;
        boolean r9 = false;
        if (r28 == null) goto L16;
        CommonMeta r1 = r28.a();
        if (r1 == null) goto L16;
        float r2 = h73.a.f(r1);
        if (Intrinsics.areEqual(r1.getNeedEnlarged(), Boolean.TRUE) == false) goto L16;
        if (this.v == true) goto L16;
        if (r2 <= 0) goto L16;
        this.v = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new k(r2, this));
    L16:
        CommonMeta r0 = r28.a();
        if (r0 == null) goto L19;
        Boolean r3 = Boolean.valueOf(r0.getEnablePDPOptimize());
    L20:
        boolean r4 = com.bytedance.android.shopping.extensions.k.i(r3);
        this.u = r4;
        if (r4 == false) goto L44;
        this.j = findViewById(2131367220);
        this.k = (AutoHeightViewPager) findViewById(2131367222);
        FrameLayout r5 = getHeaderContainer();
        if (r5 == null) goto L25;
        r5.setPadding(0, vf4.a.b(4), 0, vf4.a.b(8));
    L25:
        RoundedLinearLayout r6 = getExpandableLayoutContainer();
        if (r6 == null) goto L28;
        r6.setRadius(vf4.a.b(12));
    L28:
        TextView r7 = getGoodDetailTitle();
        if (r7 == null) goto L36;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == true) goto L33;
        r8 = null;
    L33:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r8;
        if (r10 == null) goto L36;
        r10.leftMargin = vf4.a.b(12);
        r10.bottomMargin = vf4.a.b(11);
        r7.setLayoutParams(r10);
    L36:
        View r11 = getExpandableLayoutArea();
        if (r11 == null) goto L67;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == true) goto L41;
        r12 = null;
    L41:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 == null) goto L67;
        r13.bottomMargin = vf4.a.b(16);
        r11.setLayoutParams(r13);
    L67:
        if (this.u == false) goto L80;
        SimpleDraweeView r14 = new SimpleDraweeView(getContext());
        r14.setBackgroundResource(2131231261);
        if (ECAppInfoService.e.f() == false) goto L71;
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(vf4.a.b(Double.valueOf(((double) this.s) * 1.13d)), vf4.a.b(Double.valueOf(((double) this.t) * 1.13d)));
    L72:
        r15.gravity = 1;
        t r16 = this.n;
        if (r16 == null) goto L79;
        Control r17 = r16.c();
        if (r17 == null) goto L79;
        if (r17.getDetailControl() != true) goto L79;
        getHeaderContainer().setVisibility(0);
        getHeaderContainer().addView(r14, r15);
    L87:
        DetailTagCard r18 = r26.h;
        if (r18 == null) goto L102;
        ECUrlModel r19 = r18.getTagImage();
        if (r19 == null) goto L102;
        float r20 = r19.getWidth() / r19.getHeight();
        SimpleDraweeView r21 = getTagCardView();
        if (r21 == null) goto L94;
        ViewGroup.LayoutParams r22 = getTagCardView().getLayoutParams();
        r22.width = UIUtils.getScreenWidth(r21.getContext()) - vf4.a.b(16);
        r22.height = (int) ((UIUtils.getScreenWidth(r21.getContext()) - vf4.a.b(16)) / r20);
        r21.setLayoutParams(r22);
        y.a(r21, r19);
        r21.setOnClickListener(new j(r21, this, r26));
    L94:
        t r110 = this.n;
        if (r110 == null) goto L97;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r110, "wuyou_service_info_card_show", null, false, null, null, null, null, 246);
    L97:
        SimpleDraweeView r23 = getTagCardView();
        if (r23 == null) goto L100;
        r23.setVisibility(0);
        Unit r24 = Unit.INSTANCE;
    L101:
        if (r24 == null) goto L102;
    L105:
        boolean r25 = this.u;
        this.o = r26;
        Intrinsics.checkNotNullParameter(r26, "$this$hasProduct");
        if ((!r26.c.isEmpty()) == false) goto L108;
        boolean r29 = true;
    L114:
        View r30 = getExpandableLayoutArea();
        if (r30 == null) goto L120;
        if (r29 == true) goto L118;
        int r31 = 8;
    L119:
        r30.setVisibility(r31);
        goto L120
    L118:
        r31 = 0;
    L120:
        ((ArrayList) this.p).clear();
        if (r29 == false) goto L346;
        DetailCombinePropertiesComponent r32 = r26.f;
        if (r32 == null) goto L128;
        Intrinsics.checkNotNullParameter(r32, "$this$getSkusCount");
        List r33 = r32.getSkus();
        if (r33 == null) goto L128;
        int r34 = r33.size();
    L129:
        if (r34 <= 0) goto L287;
        if (r25 == false) goto L137;
        View r35 = getCombineDetailContentView();
        if (r35 == null) goto L134;
        r35.setVisibility(8);
    L134:
        View r36 = getCombineDetailContentOptView();
        if (r36 == null) goto L143;
        r36.setVisibility(0);
    L143:
        TabLayout r37 = this.j;
        if (r37 == null) goto L149;
        if (r34 <= 1) goto L147;
        int r38 = 0;
    L148:
        r37.setVisibility(r38);
        goto L149
    L147:
        r38 = 8;
    L149:
        ViewPager r39 = this.k;
        if (r39 == null) goto L152;
        r39.setVisibility(0);
    L152:
        ExpandableLinearLayoutV4 r40 = getExpandableLayout();
        if (r40 == null) goto L155;
        r40.setVisibility(8);
    L155:
        t r41 = this.n;
        if (r41 == null) goto L158;
        FragmentManager r42 = r41.h();
    L159:
        ArrayList<AnchorV4DetailSkuVO> r43 = new ArrayList();
        if (r34 < 0) goto L228;
        int r44 = 0;
    L162:
        Intrinsics.checkNotNullParameter(r26, "$this$trans2DetailSkuVO");
        DetailCombinePropertiesComponent r45 = r26.f;
        if (r45 == null) goto L165;
        List r46 = r45.getSkus();
    L166:
        if (r46 == null) goto L223;
        List r47 = r26.f.getSkus();
        if (r47 != null) goto L170;
    L173:
        boolean r48 = true;
    L174:
        if (r48 == true) goto L223;
        if (r44 >= r26.f.getSkus().size()) goto L223;
        DetailCombinePropertiesSkusStruct r49 = (DetailCombinePropertiesSkusStruct) ListProtector.get(r26.f.getSkus(), r44);
        List r111 = r49.getSubProducts();
        String r112 = r49.getId();
        ArrayList r113 = new ArrayList();
        if (r111 == null) goto L191;
        Iterator r114 = r111.iterator();
    L182:
        if (r114.hasNext() == false) goto L191;
        SkuSubProductsStruct r115 = (SkuSubProductsStruct) r114.next();
        String r116 = r115.getProductId();
        if (r116 == null) goto L182;
        HashMap r117 = r26.f.getProducts();
        if (r117 == null) goto L188;
        ProductFormatGroup r118 = (ProductFormatGroup) r117.get(r116);
    L189:
        r113.add(new AnchorV4SubProduct(r115.getCombiningNum(), r116, r118));
        goto L182
    L188:
        r118 = null;
    L191:
        DetailCombinePropertiesComponent r119 = r26.f;
        if (r119 == null) goto L194;
        String r120 = r119.getJumpUrl();
    L195:
        String r121 = r49.getName();
        ECUrlModel r122 = r49.getPic();
        DetailCombinePropertiesComponent r50 = r26.f;
        Intrinsics.checkNotNullParameter(r50, "$this$showMoreBottomView");
        List r123 = r50.getSkus();
        if (r123 == null) goto L221;
        Iterator r124 = r123.iterator();
    L199:
        if (r124.hasNext() == false) goto L221;
        DetailCombinePropertiesSkusStruct r125 = (DetailCombinePropertiesSkusStruct) r124.next();
        List r126 = r125.getSubProducts();
        if (r126 == null) goto L203;
        int r127 = r126.size();
    L204:
        if (1 < r127) goto L220;
        List r128 = r125.getSubProducts();
        if (r128 == null) goto L199;
        SkuSubProductsStruct r129 = (SkuSubProductsStruct) ListProtector.get(r128, 0);
        if (r129 == null) goto L199;
        HashMap r130 = r50.getProducts();
        if (r130 == null) goto L199;
        ProductFormatGroup r131 = (ProductFormatGroup) r130.get(r129.getProductId());
        if (r131 == null) goto L199;
        List r132 = r131.getProductFormat();
        if (r132 == null) goto L217;
        int r133 = r132.size();
    L219:
        if (5 >= r133) goto L199;
    L217:
        r133 = 0;
    L220:
        boolean r134 = true;
    L222:
        AnchorV4DetailSkuVO r135 = new AnchorV4DetailSkuVO(r120, r112, r121, r122, r134, r113);
    L224:
        if (r135 == null) goto L226;
        r43.add(r135);
    L226:
        if (r44 == r34) goto L228;
        r44 = r44 + 1;
        goto L162
    L203:
        r127 = 0;
    L221:
        r134 = false;
        goto L222
    L194:
        r120 = null;
        goto L195
    L170:
        if (r47.isEmpty() == true) goto L173;
        r48 = false;
    L223:
        r135 = null;
        goto L224
    L165:
        r46 = null;
    L228:
        this.r = r43;
        ArrayList r51 = new ArrayList();
        Iterator<AnchorV4DetailSkuVO> r52 = r43.iterator();
        int r53 = 0;
    L230:
        if (r52.hasNext() == false) goto L233;
        AnchorV4DetailSkuVO r136 = r52.next();
        int r137 = AnchorV4DetailSkuPropertiesFragment.o;
        int r138 = r53 + 1;
        DetailSkuPropertiesFragmentParams r139 = new DetailSkuPropertiesFragmentParams(r53, r136, this.n);
        Intrinsics.checkNotNullParameter(r139, "skuparams");
        AnchorV4DetailSkuPropertiesFragment r54 = new AnchorV4DetailSkuPropertiesFragment();
        r54.k = r139;
        r51.add(r54);
        r53 = r138;
        goto L230
    L233:
        if (r43.size() <= 1) goto L237;
        TabLayout r55 = this.j;
        if (r55 == null) goto L237;
        r55.setupWithViewPager(this.k);
    L237:
        if (r42 == null) goto L239;
        AnchorV4DetailCombinePropertyPagerAdapter r56 = new AnchorV4DetailCombinePropertyPagerAdapter(r43, r51, r42);
    L240:
        AutoHeightViewPager r57 = this.k;
        if (r57 == null) goto L243;
        PagerAdapter r58 = r57.getAdapter();
    L244:
        if (r58 != null) goto L246;
    L248:
        AutoHeightViewPager r59 = this.k;
        if (r59 == null) goto L252;
        r59.setAdapter(r56);
    L252:
        if (r43.size() <= 1) goto L286;
        int r60 = r43.size();
        if (r60 < 0) goto L286;
        int r61 = 0;
    L256:
        TabLayout r62 = this.j;
        if (r62 == null) goto L259;
        TabLayout.Tab r63 = r62.getTabAt(r61);
    L260:
        if (r63 == null) goto L284;
        AnchorV4DetailSkuVO r64 = (AnchorV4DetailSkuVO) ListProtector.get(r43, r61);
        if (r64.getPic() != null) goto L276;
        AppCompatTextView r140 = new AnchorV4DetailTextTabView(getContext(), null, 0);
        r140.setText(r64.getName());
        if (r25 == false) goto L266;
        int r65 = 2131234372;
    L267:
        r140.setBackgroundResource(r65);
        if (r25 == false) goto L270;
        ColorStateList r66 = r140.getResources().getColorStateList(2131101712);
    L271:
        r140.setTextColor(r66);
        r140.setTextSize(13.0f);
        if (r25 == false) goto L274;
        int r67 = c0.a(8.0d);
    L275:
        r140.setPadding(r67, 0, r67, 0);
    L277:
        if (r61 != 0) goto L279;
        r140.setSelected(true);
    L279:
        r63.setCustomView(r140);
        ViewParent r68 = r140.getParent();
        if (r68 == null) goto L283;
        ((ViewGroup) r68).setOnClickListener(new e(this, r43, r63));
        goto L284
    L283:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L274:
        r67 = c0.a(12.0d);
        goto L275
    L270:
        r66 = r140.getResources().getColorStateList(2131101711);
        goto L271
    L266:
        r65 = 2131234371;
        goto L267
    L276:
        r140 = new AnchorV4DetailIconTextTabView(getContext(), null, 0);
        r140.a(r64.getName(), r64.getPic(), r25);
    L284:
        if (r61 == r60) goto L286;
        r61 = r61 + 1;
        goto L256
    L259:
        r63 = null;
    L286:
        Looper.myQueue().addIdleHandler(new g(this));
        goto L346
    L246:
        if (getParent() != null) goto L248;
        post(new f(this, r56));
        goto L252
    L243:
        r58 = null;
        goto L244
    L239:
        r56 = null;
        goto L240
    L158:
        r42 = null;
        goto L159
    L137:
        View r69 = getCombineDetailContentView();
        if (r69 == null) goto L140;
        r69.setVisibility(0);
    L140:
        View r70 = getCombineDetailContentOptView();
        if (r70 == null) goto L143;
        r70.setVisibility(8);
        goto L143
    L287:
        List<ProductFormatGroup> r141 = r26.c;
        ExpandableLinearLayoutV4 r71 = getExpandableLayout();
        if (r71 == null) goto L290;
        r71.setVisibility(0);
    L290:
        View r72 = getCombineDetailContentView();
        if (r72 == null) goto L293;
        r72.setVisibility(8);
    L293:
        View r73 = getCombineDetailContentOptView();
        if (r73 == null) goto L296;
        r73.setVisibility(8);
    L296:
        TabLayout r74 = this.j;
        if (r74 == null) goto L299;
        r74.setVisibility(8);
    L299:
        ViewPager r75 = this.k;
        if (r75 == null) goto L303;
        r75.setVisibility(8);
    L303:
        if (getExpandableLayout().getChildCount() <= 0) goto L305;
        getExpandableLayout().removeAllViews();
    L305:
        Iterator r142 = r141.iterator();
        int r76 = 0;
    L307:
        if (r142.hasNext() == false) goto L345;
        List r77 = ((ProductFormatGroup) r142.next()).getProductFormat();
        if (r77 == null) goto L343;
        List r78 = r77;
        ArrayList r143 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r78, 10));
        Iterator r144 = r78.iterator();
    L312:
        if (r144.hasNext() == false) goto L337;
        ProductFormat r79 = (ProductFormat) r144.next();
        if (r76 <= getExpandableLayout().getMaxItemCount()) goto L316;
        r142 = r142;
        r144 = r144;
        View r145 = null;
    L334:
        r143.add(r145);
        r142 = r142;
        r144 = r144;
        r9 = false;
        goto L312
    L316:
        int r146 = r76 + 1;
        ShoppingAsyncInflater.a r80 = ShoppingAsyncInflater.e;
        Context r81 = getContext();
        r80.getClass();
        View r82 = ShoppingAsyncInflater.a.a(r81).aU(2131560497, this, r9);
        Ref.ObjectRef r84 = new Ref.ObjectRef();
        String r85 = "";
        r84.element = "";
        ((TextView) r82.findViewById(2131391606)).setText(r79.getName());
        r84.element = ((String) r84.element) + r79.getName();
        TagFlowLayout r147 = r82.findViewById(2131388106);
        AnchorV4QualificationNewDesignView r86 = r82.findViewById(2131383521);
        m r87 = new m(this);
        int r148 = AnchorV4QualificationNewDesignView.m;
        if (Intrinsics.areEqual(r79.getNewDesign(), Boolean.TRUE) == false) goto L330;
        wg.a.h(r86, true);
        wg.a.h(r147, false);
        AttrItem r149 = (AttrItem) CollectionsKt.getOrNull(r79.getMessage(), 0);
        if (r149 == null) goto L321;
        String r88 = r149.getDesc();
    L322:
        if (r88 == null) goto L325;
        r85 = r88;
    L325:
        r86.d(r85, r79, this.m, r87);
        r84.element = ((String) r84.element) + r86.getCurrentContentDescription();
        ((ArrayList) this.p).add(r86);
        ViewGroup.LayoutParams r89 = ((TextView) r82.findViewById(2131391606)).getLayoutParams();
        if (r89 == null) goto L329;
        ((LinearLayout.LayoutParams) r89).gravity = 16;
        Ref.ObjectRef r90 = r84;
        View r150 = r82;
    L333:
        r150.setContentDescription((String) r90.element);
        r145 = r150;
        r76 = r146;
        goto L334
    L329:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L321:
        r88 = null;
        goto L322
    L330:
        wg.a.h(r147, true);
        wg.a.h(r86, false);
        r150 = r82;
        r147.setTagAdapter(new l(this, r79, r87, r84, r79.getMessage()));
        ViewGroup.LayoutParams r91 = ((TextView) r150.findViewById(2131391606)).getLayoutParams();
        if (r91 == null) goto L336;
        ((LinearLayout.LayoutParams) r91).gravity = 48;
        r90 = r84;
        goto L333
    L336:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L337:
        Iterator r210 = r142;
        Iterator r92 = r143.iterator();
    L339:
        if (r92.hasNext() == false) goto L344;
        View r94 = (View) r92.next();
        if (r94 == null) goto L339;
        getExpandableLayout().a(r94);
    L344:
        r142 = r210;
        r9 = false;
        goto L307
    L343:
        r210 = r142;
        goto L344
    L345:
        getExpandableLayout().post(new h(this));
        getExpandableLayout().setStateChangeListener(new i(this, r141));
    L128:
        r34 = 0;
    L346:
        boolean r95 = this.u;
        v63.b r96 = r26.e;
        if (r96 == null) goto L351;
        List r97 = r96.a();
        if (r97 == null) goto L351;
        Boolean r151 = Boolean.valueOf(!r97.isEmpty());
    L353:
        if (Intrinsics.areEqual(r151, Boolean.FALSE) == false) goto L355;
        getLlBannerItems().setVisibility(8);
        return;
    L355:
        getLlBannerItems().setVisibility(0);
        v63.b r98 = r26.e;
        if (r98 == null) goto L425;
        List r99 = r98.a();
        if (r99 == null) goto L426;
        Iterator r100 = r99.iterator();
        int r101 = 0;
    L361:
        if (r100.hasNext() == false) goto L427;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L365;
        CollectionsKt.throwIndexOverflow();
    L365:
        final PromotionProductBannerStruct r152 = (PromotionProductBannerStruct) r102;
        if (r152 != null) goto L368;
        ViewGroup.LayoutParams r104 = null;
        View r153 = null;
    L376:
        getLlBannerItems().addView(r153);
        if (r153 == null) goto L388;
        ViewGroup.LayoutParams r105 = r153.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L381;
        r105 = r104;
    L381:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r106 == null) goto L388;
        if (r101 != 0) goto L386;
        r106.topMargin = vf4.a.b(4);
    L386:
        r106.bottomMargin = vf4.a.b(8);
        r153.setLayoutParams(r106);
    L388:
        r101 = r103;
        goto L361
    L368:
        r104 = null;
        View r107 = new AnchorV3CommonBannerView(getContext(), null, 6, 0);
        AnchorV4DetailHeadView$generateBannerView$onClick$1 r108 = AnchorV4DetailHeadView$generateBannerView$onClick$1.INSTANCE;
        Integer r154 = r152.getBannerType();
        if (r154 != null) goto L372;
    L374:
        Function1<String, Unit> r155 = r108;
    L375:
        AnchorV3CommonBannerView.b(r107, r152, r155, false, 0, r95, 24);
        r153 = r107;
        goto L376
    L372:
        if (r154.intValue() != 32) goto L374;
        this.q = r107;
        final String r109 = com.bytedance.android.shopping.extensions.j.c(2131894093);
        r155 = new AnchorV4DetailHeadView$generateBannerView$1(this, r152, r109);
        goto L375
    L427:
        return;
    L426:
        return;
    L425:
        return;
    L351:
        r151 = null;
        goto L353
    L108:
        DetailCombinePropertiesComponent r156 = r26.f;
        if (r156 == null) goto L113;
        List r157 = r156.getSkus();
        if (r157 == null) goto L113;
        r29 = !r157.isEmpty();
    L113:
        r29 = false;
        goto L114
    L100:
        r24 = null;
    L102:
        SimpleDraweeView r158 = getTagCardView();
        if (r158 == null) goto L105;
        r158.setVisibility(8);
        Unit r159 = Unit.INSTANCE;
    L79:
        getHeaderContainer().setVisibility(8);
        goto L87
    L71:
        r15 = new FrameLayout.LayoutParams(vf4.a.b(Integer.valueOf(this.s)), vf4.a.b(Integer.valueOf(this.t)));
        goto L72
    L80:
        ECUrlModel r160 = r26.b;
        if (r160 == null) goto L87;
        View r161 = new SimpleDraweeView(getContext());
        y.a(r161, r160);
        if (ECAppInfoService.e.f() == false) goto L85;
        FrameLayout.LayoutParams r162 = new FrameLayout.LayoutParams(vf4.a.b(Double.valueOf(((double) r160.getWidth()) * 1.13d)), vf4.a.b(Double.valueOf(((double) r160.getHeight()) * 1.13d)));
    L86:
        r162.gravity = 1;
        getHeaderContainer().addView(r161, r162);
        goto L87
    L85:
        r162 = new FrameLayout.LayoutParams(vf4.a.b(Integer.valueOf(r160.getWidth())), vf4.a.b(Integer.valueOf(r160.getHeight())));
        goto L86
    L44:
        this.j = findViewById(2131367219);
        this.k = (AutoHeightViewPager) findViewById(2131367221);
        FrameLayout r163 = getHeaderContainer();
        if (r163 == null) goto L47;
        r163.setPadding(0, vf4.a.b(8), 0, vf4.a.b(8));
    L47:
        RoundedLinearLayout r164 = getExpandableLayoutContainer();
        if (r164 == null) goto L50;
        r164.setRadius(vf4.a.b(8));
    L50:
        TextView r165 = getGoodDetailTitle();
        if (r165 == null) goto L58;
        ViewGroup.LayoutParams r166 = r165.getLayoutParams();
        if ((r166 instanceof ViewGroup.MarginLayoutParams) == true) goto L55;
        r166 = null;
    L55:
        ViewGroup.MarginLayoutParams r167 = (ViewGroup.MarginLayoutParams) r166;
        if (r167 == null) goto L58;
        r167.leftMargin = vf4.a.b(16);
        r167.bottomMargin = vf4.a.b(6);
        r165.setLayoutParams(r167);
    L58:
        View r168 = getExpandableLayoutArea();
        if (r168 == null) goto L67;
        ViewGroup.LayoutParams r169 = r168.getLayoutParams();
        if ((r169 instanceof ViewGroup.MarginLayoutParams) == true) goto L63;
        r169 = null;
    L63:
        ViewGroup.MarginLayoutParams r170 = (ViewGroup.MarginLayoutParams) r169;
        if (r170 == null) goto L67;
        r170.bottomMargin = vf4.a.b(12);
        r168.setLayoutParams(r170);
        goto L67
    L19:
        r3 = null;
        goto L20
    }

    public /* synthetic */ AnchorV4DetailHeadView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
