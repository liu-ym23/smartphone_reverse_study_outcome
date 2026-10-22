package com.bytedance.locallife.pdp.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.LifeAccessibilityUtil;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.cube.api.model.PublishEvent;
import com.bytedance.locallife.cube.api.model.PublishEventKt;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.dito.utils.ApplicationUtil;
import com.bytedance.locallife.dito.utils.DitoExtKt;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.pdp.container.GoodsDetailBizContainerFragment;
import com.bytedance.locallife.pdp.container.GoodsDetailPage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J%\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\nH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0007R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/pdp/view/OldGoodsHeaderView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lyw6/k;", "", "getTitleTabStr", "", "visible", "", "setTitleVisible", "getSessionChangedWhenBindData", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", BaseSwitches.V, "getSearchOnClickHandler", "getLifeHomepageFreshType", "Lcom/bytedance/locallife/cube/api/model/PublishEvent;", "event", "onPublishEvent", "Landroid/animation/ObjectAnimator;", "v1", "Lkotlin/Lazy;", "getMAnimator", "()Landroid/animation/ObjectAnimator;", "mAnimator", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class OldGoodsHeaderView extends BaseDitoView<yw6.k> {

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final /* synthetic */ int f261881y1 = 0;
    public SimpleDraweeView A;
    public SimpleDraweeView B;
    public LinearLayout C;
    public TabLayout D;
    public TabLayout E;
    public DuxTextView F;
    public SimpleDraweeView G;
    public final GoodsDetailPage H;
    public boolean H0;
    public final com.bytedance.locallife.pdp.container.view.a I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Uri f261882J;
    public String K;
    public String L;
    public int L0;
    public int M;
    public float N;
    public final Set<String> O;
    public boolean P;
    public int P0;
    public boolean Q;
    public boolean R;
    public boolean S;
    public int T;
    public String U;
    public String V;
    public String V0;
    public String W;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f261883b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f261884g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public TabLayout f261885h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f261886k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public s f261887k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f261888p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f261889p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final Lazy f261890v1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public final p0 f261891x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f261892y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f261893z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OldGoodsHeaderView f261894a;

        public b(OldGoodsHeaderView r100) {
            this.f261894a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f261894a.getDataCenter().f().setValue(Boolean.TRUE);
        }
    }

    public static final class c implements LifeAccessibilityUtil.AccessibilityDelegateCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f261895a = null;

        static {
            f261895a = new c();
        }

        public c() {
        }

        @Override // androidx.core.app.LifeAccessibilityUtil.AccessibilityDelegateCallBack
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            Intrinsics.checkNotNullParameter(r101, "info");
            r101.setClassName(Button.class.getName());
            r101.setContentDescription(ApplicationUtil.a().getString(R.string.back));
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f261896a;

        public d(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f261896a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r100) {
            this.f261896a.invoke(r100);
        }
    }

    public static final class e implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OldGoodsHeaderView f261897a;

        public e(OldGoodsHeaderView r100) {
            this.f261897a = r100;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(TabLayout.Tab r100) {
            onTabSelected(r100);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(TabLayout.Tab r110) {
            OldGoodsHeaderView r100 = this.f261897a;
            if (r100.f261884g1 == false) goto L19;
            com.bytedance.locallife.pdp.container.view.a r101 = r100.I;
            if (r110 == null) goto L7;
            Object r102 = r110.getTag();
        L9:
            if ((r102 instanceof String) == false) goto L11;
            String r103 = (String) r102;
        L12:
            if (r103 != null) goto L14;
            r103 = "";
        L14:
            r101.a("project_detail_nav_bar_click", MapsKt.mapOf(TuplesKt.to("click_type", r103)));
            this.f261897a.f261883b1 = true;
            Pair[] r104 = new Pair[3];
            r104[0] = TuplesKt.to("eventName", "top_model");
            r104[1] = TuplesKt.to("offset", 8);
            Pair[] r105 = new Pair[2];
            r105[0] = TuplesKt.to(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, this.f261897a.H.getTraceSessionId());
            if (r110 == null) goto L17;
            Object r106 = r110.getTag();
        L18:
            r105[1] = TuplesKt.to("component_name", r106);
            r104[2] = TuplesKt.to("params", MapsKt.hashMapOf(r105));
            vn6.b.a(new PublishEvent(MapsKt.hashMapOf(r104)));
            goto L19
        L17:
            r106 = null;
            goto L18
        L11:
            r103 = null;
            goto L12
        L7:
            r102 = null;
        L19:
            if (r110 == null) goto L25;
            View r111 = r110.getCustomView();
            if (r111 == null) goto L25;
            TextView r112 = (TextView) r111.findViewById(R.id.tab);
            if (r112 == null) goto L25;
            r112.setTextColor(ColorProtector.parseColor("#161823"));
            r112.setTypeface(null, 1);
        L25:
            this.f261897a.f261884g1 = true;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(TabLayout.Tab r100) {
            if (r100 == null) goto L9;
            View r101 = r100.getCustomView();
            if (r101 == null) goto L10;
            TextView r102 = (TextView) r101.findViewById(R.id.tab);
            if (r102 == null) goto L11;
            r102.setTextColor(ColorProtector.parseColor("#66161823"));
            r102.setTypeface(null, 0);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    static {
    }

    private final String getLifeHomepageFreshType() {
        Map<String, String> r100 = this.I.b();
        String r101 = r100.get("poi_enter_page");
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        String r104 = r100.get("enter_from");
    L11:
        HostServiceUtilsKt.R().t();
        if ("".length() > 0) goto L15;
        r102 = false;
    L15:
        if (r102 == false) goto L17;
        return "";
    L17:
        String r105 = r100.get(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO);
        if (r105 == null) goto L27;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L21
        return new JSONObject(r105).optString("life_homepage_fresh_type");
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        return null;
    L27:
        return null;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    private final ObjectAnimator getMAnimator() {
        return (ObjectAnimator) this.f261890v1.getValue();
    }

    private final Function1<View, Unit> getSearchOnClickHandler() {
        return new AnonymousClass1(this);
    }

    private final boolean getSessionChangedWhenBindData() {
        String r100 = this.H.getTraceSessionId();
        boolean r101 = !Intrinsics.areEqual(r100, this.V0);
        this.V0 = r100;
        return r101;
    }

    private final String getTitleTabStr() {
        StringBuilder r100 = new StringBuilder();
        yw6.k r101 = getModel();
        if (r101 == null) goto L24;
        yw6.u r102 = r101.c();
        if (r102 == null) goto L24;
        List<yw6.p> r103 = r102.p();
        if (r103 == null) goto L24;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L24;
        yw6.p r105 = (yw6.p) r104.next();
        if (r100.length() <= 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L17;
        r100.append(',');
    L17:
        if (r105 == null) goto L19;
        String r107 = r105.a();
    L21:
        if (com.bytedance.locallife.common.utils.j.a(r107) == false) goto L10;
        r100.append(r107);
        goto L10
    L19:
        r107 = null;
        goto L21
    L14:
        r106 = false;
    L24:
        return r100.toString();
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        super.P();
        boolean r100 = getSessionChangedWhenBindData();
        if (DitoExtKt.e(getModel()) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        this.f261889p1 = DitoExtKt.e(getModel());
        if (r100 == true) goto L11;
        if (r101 == true) goto L11;
    L12:
        getDataCenter().Y().observe(this, this.f261891x1);
        yw6.k r102 = getModel();
        String r103 = "";
        if (r102 == null) goto L18;
        yw6.u r104 = r102.c();
        if (r104 == null) goto L18;
        String r105 = r104.b();
        if (r105 == null) goto L18;
    L20:
        if (r105.length() > 1) goto L22;
    L27:
        Object r106 = getDitoViewModel().B.get("activity_id");
        if ((r106 instanceof String) == false) goto L30;
        String r107 = (String) r106;
    L31:
        this.V = r107;
        Object r108 = getDitoViewModel().B.get("enterprise_tab_extra");
        if ((r108 instanceof String) == false) goto L34;
        String r109 = (String) r108;
    L35:
        this.W = r109;
        yw6.k r110 = getModel();
        if (r110 == null) goto L38;
        yw6.u r111 = r110.c();
    L39:
        if (r111 == null) goto L41;
        List<com.bytedance.locallife.host.share.a> r112 = r111.c();
    L42:
        if (r112 != null) goto L44;
    L46:
        boolean r113 = false;
    L48:
        if (r113 == true) goto L50;
        com.bytedance.locallife.host.share.a r114 = null;
    L58:
        if (r114 == null) goto L63;
        String r115 = r114.k();
        if (r115 != null) goto L62;
        r115 = "0";
    L62:
        this.K = r115;
        this.L = r114.l();
    L63:
        if (r100 == true) goto L67;
        if (r101 == true) goto L67;
        boolean r116 = false;
    L68:
        if (r116 == false) goto L133;
        boolean r117 = this.S;
        String r118 = this.K;
        if (Intrinsics.areEqual(r118, "2") == false) goto L72;
        boolean r119 = true;
    L74:
        if (r119 == false) goto L89;
        this.S = true;
        TabLayout r120 = this.E;
        if (r120 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title_tab_layout");
        r120 = null;
    L78:
        r120.setVisibility(8);
        if (Intrinsics.areEqual("1", this.K) == false) goto L83;
        s r121 = this.f261887k1;
        if (r121 == null) goto L86;
        r121.a(getContext(), this.V, this.I.b().get("poi_id"), getLifeHomepageFreshType(), getSearchOnClickHandler());
    L86:
        TabLayout r122 = this.D;
        if (r122 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_full_title_tab_layout");
    L98:
        r122 = null;
    L99:
        this.f261885h1 = r122;
        if (r117 == this.S) goto L102;
        int r123 = com.bytedance.locallife.pdp.container.g0.f261152a;
        this.T = com.bytedance.locallife.pdp.container.g0.a.c(this.H.getFragment().getContext(), this.S, false);
    L102:
        yw6.k r124 = getModel();
        if (r124 == null) goto L107;
        yw6.u r125 = r124.c();
        if (r125 == null) goto L107;
        String r126 = r125.o();
    L109:
        if (Intrinsics.areEqual(r126, "1") == false) goto L116;
        DuxTextView r127 = this.F;
        if (r127 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title");
        r127 = null;
    L113:
        r127.setVisibility(8);
        TabLayout r128 = this.f261885h1;
        if (r128 == null) goto L133;
        r128.setVisibility(0);
        this.O.clear();
        o0();
        goto L133
    L116:
        DuxTextView r129 = this.F;
        if (r129 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title");
        r129 = null;
    L119:
        r129.setVisibility(0);
        DuxTextView r130 = this.F;
        if (r130 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title");
        r130 = null;
    L122:
        yw6.k r131 = getModel();
        if (r131 == null) goto L129;
        yw6.u r132 = r131.c();
        if (r132 == null) goto L129;
        String r133 = r132.n();
        if (r133 == null) goto L129;
        r103 = r133;
    L129:
        r130.setText(r103);
        TabLayout r134 = this.f261885h1;
        if (r134 == null) goto L133;
        r134.setVisibility(8);
    L107:
        r126 = null;
        goto L109
    L83:
        s r135 = this.f261887k1;
        if (r135 == null) goto L86;
        r135.d();
        goto L86
    L89:
        this.S = false;
        TabLayout r136 = this.D;
        if (r136 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_full_title_tab_layout");
        r136 = null;
    L92:
        r136.setVisibility(8);
        s r137 = this.f261887k1;
        if (r137 == null) goto L95;
        r137.d();
    L95:
        r122 = this.E;
        if (r122 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title_tab_layout");
        goto L98
    L72:
        r119 = Intrinsics.areEqual(r118, "1");
    L133:
        SimpleDraweeView r138 = this.A;
        if (r138 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r138 = null;
    L136:
        yw6.k r139 = getModel();
        if (r139 == null) goto L145;
        yw6.u r140 = r139.c();
        if (r140 == null) goto L145;
        yw6.s r141 = r140.q();
        if (r141 == null) goto L145;
        yw6.r r142 = r141.d();
        if (r142 == null) goto L145;
        String r143 = r142.b();
    L147:
        if (this.f261888p0 == false) goto L149;
        int r144 = R.drawable.ic_s_s_arrowbackward_outlined;
    L150:
        k0(r138, r143, r144);
        if (com.bytedance.locallife.pdp.settings.l0.e() == false) goto L158;
        SimpleDraweeView r145 = this.A;
        if (r145 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r145 = null;
    L155:
        ViewTreeObserver r146 = r145.getViewTreeObserver();
        if (r146 == null) goto L158;
        r146.addOnPreDrawListener(new i0(this));
    L158:
        SimpleDraweeView r147 = this.G;
        if (r147 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r147 = null;
    L161:
        yw6.k r148 = getModel();
        if (r148 == null) goto L170;
        yw6.u r149 = r148.c();
        if (r149 == null) goto L170;
        yw6.s r150 = r149.q();
        if (r150 == null) goto L170;
        yw6.r r151 = r150.d();
        if (r151 == null) goto L170;
        String r152 = r151.e();
    L171:
        k0(r147, r152, R.drawable.ic_s_s_arrowupright_outlined_20);
        SimpleDraweeView r153 = this.B;
        if (r153 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r153 = null;
    L174:
        yw6.k r154 = getModel();
        if (r154 == null) goto L183;
        yw6.u r155 = r154.c();
        if (r155 == null) goto L183;
        yw6.s r156 = r155.q();
        if (r156 == null) goto L183;
        yw6.r r157 = r156.d();
        if (r157 == null) goto L183;
        String r158 = r157.d();
    L184:
        k0(r153, r158, R.drawable.ic_s_s_magnifier_outlined);
        if (Intrinsics.areEqual(this.H.ab().getTitleBarFloat().getValue(), Boolean.TRUE) == false) goto L187;
    L219:
        i0();
        if (r112 != null) goto L222;
        return;
    L222:
        Iterator<com.bytedance.locallife.host.share.a> r159 = r112.iterator();
    L224:
        if (r159.hasNext() == false) goto L246;
        com.bytedance.locallife.host.share.a r160 = r159.next();
        if (TextUtils.equals(r160.getType(), "share") == true) goto L227;
        if (TextUtils.equals(r160.getType(), "search") == false) goto L224;
        if (Intrinsics.areEqual(r160.k(), "0") == true) goto L224;
        SimpleDraweeView r161 = this.B;
        if (r161 != null) goto L241;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r161 = null;
    L241:
        r161.setVisibility(0);
        SimpleDraweeView r162 = this.B;
        if (r162 != null) goto L244;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r162 = null;
    L244:
        r162.setOnClickListener(new d(getSearchOnClickHandler()));
        goto L224
    L227:
        SimpleDraweeView r163 = this.G;
        if (r163 != null) goto L230;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r163 = null;
    L230:
        r163.setVisibility(0);
        SimpleDraweeView r164 = this.G;
        if (r164 != null) goto L233;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r164 = null;
    L233:
        r164.setOnClickListener(new k0(this, r160));
        goto L224
    L246:
        if (this.f261888p0 == false) goto L248;
    L256:
        SimpleDraweeView r165 = this.A;
        if (r165 != null) goto L259;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        SimpleDraweeView r166 = null;
    L260:
        LifeAccessibilityUtil.setAccessibilityDelegate(r166, c.f261895a);
        return;
    L259:
        r166 = r165;
        goto L260
    L248:
        if (this.f261886k0 == false) goto L256;
        f0(this.L0);
        yw6.k r167 = getModel();
        if (r167 == null) goto L254;
        yw6.u r168 = r167.c();
        if (r168 == null) goto L254;
        List<com.bytedance.locallife.host.share.a> r169 = r168.c();
    L255:
        c0(r169, this.L0);
    L254:
        r169 = null;
        goto L255
    L187:
        if (this.f261888p0 == false) goto L190;
    L196:
        float r170 = 1.0f;
    L197:
        setAlpha(r170);
        setTitleVisible(true);
        n0();
        SimpleDraweeView r171 = this.A;
        if (r171 != null) goto L200;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r171 = null;
    L200:
        Drawable r172 = r171.getDrawable();
        if (r172 == null) goto L203;
        DrawableCompat.setTint(r172, ColorProtector.parseColor("#161823"));
    L203:
        SimpleDraweeView r173 = this.B;
        if (r173 != null) goto L206;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r173 = null;
    L206:
        Drawable r174 = r173.getDrawable();
        if (r174 == null) goto L209;
        DrawableCompat.setTint(r174, ColorProtector.parseColor("#161823"));
    L209:
        SimpleDraweeView r175 = this.G;
        if (r175 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r175 = null;
    L212:
        Drawable r176 = r175.getDrawable();
        if (r176 == null) goto L215;
        DrawableCompat.setTint(r176, ColorProtector.parseColor("#161823"));
    L215:
        LinearLayout r177 = this.C;
        if (r177 != null) goto L218;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        r177 = null;
    L218:
        r177.setBackgroundColor(this.P0);
        goto L219
    L190:
        if (this.f261886k0 == false) goto L196;
        int r178 = this.L0;
        if (r178 == 6) goto L196;
        if (r178 == 7) goto L196;
        r170 = 0.0f;
    L183:
        r158 = null;
    L170:
        r152 = null;
        goto L171
    L149:
        r144 = R.drawable.ic_s_s_xmark_outlined;
    L145:
        r143 = null;
    L67:
        r116 = true;
        goto L68
    L50:
        ArrayList r179 = new ArrayList();
        Iterator<T> r180 = r112.iterator();
    L52:
        if (r180.hasNext() == false) goto L56;
        Object r181 = r180.next();
        if (Intrinsics.areEqual(((com.bytedance.locallife.host.share.a) r181).getType(), "search") == false) goto L52;
        r179.add(r181);
        goto L52
    L56:
        r114 = (com.bytedance.locallife.host.share.a) CollectionsKt.getOrNull(r179, 0);
        goto L58
    L44:
        if ((!r112.isEmpty()) != true) goto L46;
        r113 = true;
        goto L48
    L41:
        r112 = null;
        goto L42
    L38:
        r111 = null;
        goto L39
    L34:
        r109 = null;
        goto L35
    L30:
        r107 = null;
        goto L31
    L22:
        if (Intrinsics.areEqual(this.U, r105) == true) goto L27;
        this.U = r105;
        this.P0 = ColorProtector.parseColor("#" + r105.substring(r105.length() - 2, r105.length()) + r105.subSequence(1, r105.length() - 2));
        if (this.f261888p0 == false) goto L27;
        m0();
    L18:
        r105 = "";
    L11:
        this.P = false;
        this.R = false;
        this.Q = false;
        goto L12
    L5:
        if (this.f261889p1 == false) goto L7;
        r101 = true;
        goto L8
    }

    public final void g0() {
        if (this.P == false) goto L5;
        return;
    L5:
        this.P = true;
        this.I.a("project_detail_nav_bar_show", MapsKt.mapOf(TuplesKt.to("bar_name", getTitleTabStr())));
    }

    public final void i0() {
        float r110 = 1.0f;
        if (Intrinsics.areEqual(this.H.ab().getTitleBarFloat().getValue(), Boolean.TRUE) == true) goto L5;
        yw6.k r100 = getModel();
        if (r100 == null) goto L134;
        yw6.u r101 = r100.c();
        if (r101 == null) goto L134;
        yw6.s r102 = r101.q();
        if (r102 == null) goto L134;
        Integer r103 = r102.c();
        if (r103 == null) goto L134;
        float r104 = xo6.b.a(r103.intValue());
    L136:
        if (this.N < r104) goto L164;
        j0();
        SimpleDraweeView r105 = this.A;
        if (r105 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r105 = null;
    L140:
        yw6.k r106 = getModel();
        if (r106 == null) goto L149;
        yw6.u r107 = r106.c();
        if (r107 == null) goto L149;
        yw6.s r108 = r107.q();
        if (r108 == null) goto L149;
        yw6.r r109 = r108.a();
        if (r109 == null) goto L149;
        String r111 = r109.b();
    L150:
        l0(r105, r111, R.drawable.ic_s_s_xmark_outlined, ColorProtector.parseColor("#161823"));
        d0(true, false);
        SimpleDraweeView r112 = this.G;
        if (r112 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r112 = null;
    L153:
        yw6.k r113 = getModel();
        if (r113 == null) goto L162;
        yw6.u r114 = r113.c();
        if (r114 == null) goto L162;
        yw6.s r115 = r114.q();
        if (r115 == null) goto L162;
        yw6.r r116 = r115.a();
        if (r116 == null) goto L162;
        String r117 = r116.e();
    L163:
        l0(r112, r117, R.drawable.ic_s_s_arrowupright_outlined_20, ColorProtector.parseColor("#161823"));
    L191:
        LinearLayout r118 = this.C;
        if (r118 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        r118 = null;
    L194:
        r118.setBackgroundColor(this.P0);
        yw6.k r119 = getModel();
        if (r119 == null) goto L199;
        yw6.u r120 = r119.c();
        if (r120 == null) goto L199;
        String r121 = r120.o();
    L201:
        if (Intrinsics.areEqual(r121, "1") == false) goto L219;
        TabLayout r122 = this.f261885h1;
        if (r122 != null) goto L206;
    L210:
        TabLayout r123 = this.f261885h1;
        if (r123 == null) goto L213;
        float r124 = r123.getAlpha();
    L215:
        if (r124 <= 0.0f) goto L220;
        g0();
        return;
    L220:
        return;
    L213:
        r124 = 0.0f;
        goto L215
    L206:
        if (Intrinsics.areEqual(this.K, "1") == true) goto L209;
        r110 = Math.min(1.0f, Math.max(0.0f, this.N - xo6.b.a(60)) / xo6.b.a(60));
    L209:
        r122.setAlpha(r110);
        goto L210
    L219:
        return;
    L199:
        r121 = null;
    L162:
        r117 = null;
    L149:
        r111 = null;
        goto L150
    L164:
        n0();
        SimpleDraweeView r125 = this.A;
        if (r125 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r125 = null;
    L167:
        yw6.k r126 = getModel();
        if (r126 == null) goto L176;
        yw6.u r127 = r126.c();
        if (r127 == null) goto L176;
        yw6.s r128 = r127.q();
        if (r128 == null) goto L176;
        yw6.r r129 = r128.d();
        if (r129 == null) goto L176;
        String r130 = r129.b();
    L177:
        l0(r125, r130, R.drawable.ic_s_s_xmark_outlined, ColorProtector.parseColor("#161823"));
        d0(false, false);
        SimpleDraweeView r131 = this.G;
        if (r131 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r131 = null;
    L180:
        yw6.k r132 = getModel();
        if (r132 == null) goto L189;
        yw6.u r133 = r132.c();
        if (r133 == null) goto L189;
        yw6.s r134 = r133.q();
        if (r134 == null) goto L189;
        yw6.r r135 = r134.d();
        if (r135 == null) goto L189;
        String r136 = r135.e();
    L190:
        l0(r131, r136, R.drawable.ic_s_s_arrowupright_outlined_20, ColorProtector.parseColor("#161823"));
    L189:
        r136 = null;
    L176:
        r130 = null;
    L134:
        r104 = xo6.b.a(30);
        goto L136
    L5:
        if (this.f261888p0 == false) goto L7;
        float r137 = 1.0f;
    L8:
        setAlpha(r137);
        if (getAlpha() > 0.0f) goto L11;
        int r138 = 4;
    L12:
        setVisibility(r138);
        yw6.k r139 = getModel();
        if (r139 == null) goto L21;
        yw6.u r140 = r139.c();
        if (r140 == null) goto L21;
        yw6.s r141 = r140.q();
        if (r141 == null) goto L21;
        Integer r142 = r141.b();
        if (r142 == null) goto L21;
        float r143 = xo6.b.a(r142.intValue());
    L22:
        yw6.k r144 = getModel();
        if (r144 == null) goto L31;
        yw6.u r145 = r144.c();
        if (r145 == null) goto L31;
        yw6.s r146 = r145.q();
        if (r146 == null) goto L31;
        Integer r147 = r146.c();
        if (r147 == null) goto L31;
        float r148 = xo6.b.a(r147.intValue());
    L33:
        if (this.N < r148) goto L77;
        yw6.k r149 = getModel();
        if (r149 == null) goto L39;
        yw6.u r150 = r149.c();
        if (r150 == null) goto L39;
        String r151 = r150.o();
    L41:
        if (Intrinsics.areEqual(r151, "1") == false) goto L43;
        g0();
    L43:
        setTitleVisible(true);
        j0();
        SimpleDraweeView r152 = this.A;
        if (r152 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r152 = null;
    L46:
        yw6.k r153 = getModel();
        if (r153 == null) goto L55;
        yw6.u r154 = r153.c();
        if (r154 == null) goto L55;
        yw6.s r155 = r154.q();
        if (r155 == null) goto L55;
        yw6.r r156 = r155.a();
        if (r156 == null) goto L55;
        String r157 = r156.b();
    L56:
        l0(r152, r157, R.drawable.ic_s_s_xmark_outlined, ColorProtector.parseColor("#161823"));
        d0(true, true);
        SimpleDraweeView r158 = this.G;
        if (r158 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r158 = null;
    L59:
        yw6.k r159 = getModel();
        if (r159 == null) goto L68;
        yw6.u r160 = r159.c();
        if (r160 == null) goto L68;
        yw6.s r161 = r160.q();
        if (r161 == null) goto L68;
        yw6.r r162 = r161.a();
        if (r162 == null) goto L68;
        String r163 = r162.e();
    L69:
        l0(r158, r163, R.drawable.ic_s_s_arrowupright_outlined_20, ColorProtector.parseColor("#161823"));
        LinearLayout r164 = this.C;
        if (r164 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        r164 = null;
    L73:
        if (r143 > r148) goto L75;
        int r165 = this.P0;
    L76:
        r164.setBackgroundColor(r165);
        return;
    L75:
        r165 = qx6.a.a((this.N - (r148 / r143)) - r148, this.P0);
    L68:
        r163 = null;
    L55:
        r157 = null;
    L39:
        r151 = null;
        goto L41
    L77:
        setTitleVisible(false);
        yw6.k r166 = getModel();
        if (r166 == null) goto L91;
        yw6.u r167 = r166.c();
        if (r167 == null) goto L91;
        yw6.s r168 = r167.q();
        if (r168 == null) goto L91;
        yw6.r r169 = r168.d();
        if (r169 == null) goto L91;
        String r170 = r169.a();
        if (r170 == null) goto L91;
        LinearLayout r171 = this.C;
        if (r171 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        r171 = null;
    L90:
        r171.setBackgroundColor(ColorProtector.parseColor(r170));
        Unit r172 = Unit.INSTANCE;
    L92:
        if (r172 != null) goto L97;
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.poi_bg_trade_goods_header));
        LinearLayout r173 = this.C;
        if (r173 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        r173 = null;
    L96:
        r173.setBackgroundColor(qx6.a.a(Math.min(1.0f * r143, this.N) / r143, this.P0));
    L97:
        d0(false, true);
        SimpleDraweeView r174 = this.A;
        if (r174 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r174 = null;
    L100:
        yw6.k r175 = getModel();
        if (r175 == null) goto L109;
        yw6.u r176 = r175.c();
        if (r176 == null) goto L109;
        yw6.s r177 = r176.q();
        if (r177 == null) goto L109;
        yw6.r r178 = r177.d();
        if (r178 == null) goto L109;
        String r179 = r178.b();
    L110:
        l0(r174, r179, R.drawable.ic_s_s_xmark_outlined, ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        SimpleDraweeView r180 = this.G;
        if (r180 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r180 = null;
    L113:
        yw6.k r181 = getModel();
        if (r181 == null) goto L122;
        yw6.u r182 = r181.c();
        if (r182 == null) goto L122;
        yw6.s r183 = r182.q();
        if (r183 == null) goto L122;
        yw6.r r184 = r183.d();
        if (r184 == null) goto L122;
        String r185 = r184.e();
    L123:
        l0(r180, r185, R.drawable.ic_s_s_arrowupright_outlined_20, ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        return;
    L122:
        r185 = null;
    L109:
        r179 = null;
    L91:
        r172 = null;
    L31:
        r148 = xo6.b.a(30);
    L21:
        r143 = xo6.b.a(60);
        goto L22
    L11:
        r138 = 0;
        goto L12
    L7:
        r137 = (xo6.b.a(60) - (Math.min((int) xo6.b.a(60), Math.max(this.M, 0)) * 1.0f)) / xo6.b.a(60);
        goto L8
    }

    public final void o0() {
        TabLayout r100 = this.f261885h1;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllTabs();
        r100.setTabGravity(!this.S ? 1 : 0);
        r100.setTabMode(1);
        yw6.k r101 = getModel();
        if (r101 == null) goto L78;
        yw6.u r102 = r101.c();
        if (r102 == null) goto L79;
        List<yw6.p> r103 = r102.p();
        if (r103 == null) goto L80;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L12:
        boolean r106 = false;
        if (r105.hasNext() == false) goto L35;
        Object r107 = r105.next();
        yw6.p r108 = (yw6.p) r107;
        if (r108 == null) goto L21;
        String r109 = r108.b();
        if (r109 == null) goto L21;
        if (com.bytedance.locallife.common.utils.j.a(r109) != true) goto L21;
        boolean r110 = true;
    L22:
        if (r110 == false) goto L32;
        String r111 = r108.a();
        if (r111 != null) goto L26;
    L28:
        boolean r112 = false;
    L29:
        if (r112 == false) goto L32;
        if (this.O.contains(r108.a()) == true) goto L32;
    L33:
        if (r106 == true) goto L12;
        r104.add(r107);
        goto L12
    L26:
        if (com.bytedance.locallife.common.utils.j.a(r111) != true) goto L28;
        r112 = true;
    L32:
        r106 = true;
    L21:
        r110 = false;
        goto L22
    L35:
        final LinkedHashMap r113 = new LinkedHashMap();
        int r114 = r104.size();
        int r115 = 0;
        int r116 = 0;
    L36:
        if (r115 >= r114) goto L58;
        yw6.p r117 = (yw6.p) ListProtector.get(r104, r115);
        if (r117 == null) goto L57;
        String r118 = r117.a();
        if (r118 == null) goto L57;
        String r119 = r117.b();
        if (r119 == null) goto L57;
        TabLayout.Tab r120 = r100.newTab();
        r120.setTag(r118);
        View r121 = LayoutInflater.from(this.H.getFragment().getContext()).inflate(R.layout.saas_poi_goods_detail_title_tab_view, this, false);
        r121.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TextView r122 = (TextView) r121.findViewById(R.id.tab);
        r122.setText(r119);
        if (wo6.a.d(getContext(), kp6.f.b() * 1.0f) >= xo6.b.a(TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG)) goto L48;
        boolean r123 = true;
    L50:
        if (r123 == false) goto L52;
        int r124 = 0;
    L53:
        if (r123 == false) goto L55;
        int r125 = 0;
    L56:
        r122.setPadding(r124, 0, r125, 0);
        r120.setCustomView(r121);
        r100.addTab(r120, false);
        r113.put(r118, Integer.valueOf(r116));
        r116 = r116 + 1;
        goto L57
    L55:
        r125 = (int) xo6.b.a(2);
        goto L56
    L52:
        r124 = (int) xo6.b.a(2);
        goto L53
    L48:
        r123 = false;
    L57:
        r115 = r115 + 1;
        goto L36
    L58:
        RecyclerView r126 = this.H.Ok();
        if (r126 == null) goto L61;
        r126.setOnScrollListener(new OldGoodsHeaderView$setTitleTabLayout$2(this, r113));
    L61:
        TabLayout r127 = this.f261885h1;
        if (r127 == null) goto L64;
        r127.setOnTabSelectedListener(new e(this));
    L64:
        RecyclerView r128 = this.H.Ok();
        if (r128 == null) goto L81;
        q0(r128, r113);
        return;
    L81:
        return;
    L80:
        return;
    L79:
        return;
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void S() {
        super.S();
        getDataCenter().Y().removeObserver(this.f261891x1);
    }

    public final void j0() {
        yw6.k r100 = getModel();
        if (r100 == null) goto L13;
        yw6.u r101 = r100.c();
        if (r101 == null) goto L13;
        yw6.s r102 = r101.q();
        if (r102 == null) goto L13;
        yw6.r r103 = r102.a();
        if (r103 == null) goto L13;
        String r104 = r103.a();
        if (r104 == null) goto L13;
        this.P0 = ColorProtector.parseColor(r104);
        Unit r105 = Unit.INSTANCE;
    L14:
        if (r105 != null) goto L17;
        setBackground(null);
        return;
    L17:
        return;
    L13:
        r105 = null;
        goto L14
    }

    public final void m0() {
        Context r100 = getContext();
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r101 = (Activity) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        ImmersionBar.with(r101).autoDarkModeEnable(false).statusBarColor(R.color.Transparent).statusBarDarkFont(true).fitsSystemWindows(false).init();
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void n0() {
        yw6.k r100 = getModel();
        if (r100 == null) goto L13;
        yw6.u r101 = r100.c();
        if (r101 == null) goto L13;
        yw6.s r102 = r101.q();
        if (r102 == null) goto L13;
        yw6.r r103 = r102.d();
        if (r103 == null) goto L13;
        String r104 = r103.a();
        if (r104 == null) goto L13;
        this.P0 = ColorProtector.parseColor(r104);
        Unit r105 = Unit.INSTANCE;
    L14:
        if (r105 != null) goto L17;
        setBackground(null);
        return;
    L17:
        return;
    L13:
        r105 = null;
        goto L14
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        vn6.b.b(this);
        ht6.a r100 = this.H.fU();
        if (r100 != null) goto L43;
    L8:
        boolean r101 = false;
        addView(LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_trade_product_header_old, this, false));
        this.f261892y = findViewById(R.id.goods_detail_search_bar);
        this.f261893z = findViewById(R.id.status_bar);
        this.A = (SimpleDraweeView) findViewById(R.id.trade_product_detail_back);
        this.B = (SimpleDraweeView) findViewById(R.id.trade_product_search);
        this.C = (LinearLayout) findViewById(R.id.goods_header_container);
        this.D = (TabLayout) findViewById(R.id.goods_detail_full_title_tab_layout);
        this.E = (TabLayout) findViewById(R.id.goods_detail_title_tab_layout);
        this.F = (DuxTextView) findViewById(R.id.goods_detail_title);
        this.G = (SimpleDraweeView) findViewById(R.id.trade_product_share);
        View r102 = this.f261892y;
        View r103 = null;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_search_bar");
        r102 = null;
    L11:
        this.f261887k1 = new s(r102);
        View r104 = this.f261893z;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("status_bar");
        r104 = null;
    L14:
        r104.getLayoutParams().height = j56.a.b(getContext());
        SimpleDraweeView r105 = this.A;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r105 = null;
    L17:
        r105.setOnClickListener(new j0(this));
        Object r106 = getDitoViewModel().B.get("hide_nav_bar");
        if ((r106 instanceof String) == false) goto L20;
        String r107 = (String) r106;
    L21:
        this.f261886k0 = TextUtils.equals(r107, "1");
        Object r108 = getDitoViewModel().A.get("view_screen_include_full_in_popup");
        if ((r108 instanceof Boolean) == false) goto L24;
        Boolean r109 = (Boolean) r108;
    L25:
        if (r109 == null) goto L27;
        r101 = r109.booleanValue();
    L27:
        this.H0 = r101;
        Object r110 = getDitoViewModel().A.get("view_screen_is_full");
        if ((r110 instanceof Boolean) == false) goto L30;
        Boolean r111 = (Boolean) r110;
    L32:
        if (r111 == null) goto L34;
        boolean r112 = r111.booleanValue();
    L35:
        this.f261888p0 = r112;
        this.H.ab().getTitleBarFloat().observe(this, new l0(this));
        DitoDataCenter r113 = getDataCenter();
        int r114 = DitoDataCenter.f258004d;
        r113.a0("dialog_state_event", 1).observe(this, new m0(this));
        getDataCenter().a0("dialog_top_event", 1).observe(this, new n0(this));
        getDataCenter().a0("share_im_dialog_close_event", 1).observe(this, new o0(this));
        if (this.H0 == false) goto L45;
        View r115 = this.f261893z;
        if (r115 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("status_bar");
    L41:
        r103.getLayoutParams().height = (int) xo6.b.a(6);
        return;
    L40:
        r103 = r115;
        goto L41
    L45:
        return;
    L34:
        r112 = true;
        goto L35
    L30:
        r111 = null;
        goto L32
    L24:
        r109 = null;
        goto L25
    L20:
        r107 = null;
        goto L21
    L43:
        r100.getView();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        HostServiceUtilsKt.c().b(e);
        goto L8
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onDestroy() {
        super.onDestroy();
        vn6.b.c(this);
        if ((getContext() instanceof Activity) == false) goto L6;
        Context r100 = getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");
        ImmersionBar.with((Activity) r100).destroy();
        return;
    }

    public static final /* synthetic */ String a0(OldGoodsHeaderView r100) {
        return r100.getLifeHomepageFreshType();
    }

    public static final /* synthetic */ ObjectAnimator b0(OldGoodsHeaderView r100) {
        return r100.getMAnimator();
    }

    private final void setTitleVisible(boolean r100) {
        yw6.k r101 = getModel();
        String r102 = null;
        if (r101 == null) goto L7;
        yw6.u r103 = r101.c();
        if (r103 == null) goto L7;
        String r104 = r103.o();
    L9:
        if (Intrinsics.areEqual(r104, "1") == false) goto L11;
        View r105 = this.f261885h1;
    L14:
        if (r105 == null) goto L30;
        if (r100 == true) goto L18;
    L27:
        int r106 = 4;
    L28:
        r105.setVisibility(r106);
        return;
    L18:
        if (Intrinsics.areEqual(this.H.ab().getTitleBarFloat().getValue(), Boolean.TRUE) == true) goto L26;
        yw6.k r107 = getModel();
        if (r107 == null) goto L25;
        yw6.u r108 = r107.c();
        if (r108 == null) goto L25;
        r102 = r108.o();
    L25:
        if (Intrinsics.areEqual(r102, "1") == false) goto L27;
    L26:
        r106 = 0;
        goto L28
    L30:
        return;
    L11:
        r105 = this.F;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title");
        r105 = null;
    L7:
        r104 = null;
        goto L9
    }

    public final void f0(int r100) {
        if (r100 != 6) goto L5;
    L7:
        setEnabled(false);
        setClickable(false);
        return;
    L5:
        if (r100 == 7) goto L7;
        setEnabled(true);
        setClickable(true);
        setOnClickListener(new b(this));
    }

    public final void h0(boolean r100) {
        if (r100 == false) goto L9;
        if (this.Q == false) goto L7;
        return;
    L7:
        this.Q = true;
    L12:
        s r101 = this.f261887k1;
        if (r101 == null) goto L15;
        int r102 = s.f261944f;
        r101.c(null);
    L15:
        com.bytedance.locallife.pdp.container.view.a r103 = this.I;
        Pair[] r104 = new Pair[2];
        r104[0] = TuplesKt.to("enter_from", "product_page");
        if (r100 == false) goto L18;
        String r105 = "product_page_search_icon";
    L19:
        r104[1] = TuplesKt.to(ECFindSimilarConfig.ENTER_FROM_SECOND, r105);
        Map<String, String> r106 = MapsKt.mutableMapOf(r104);
        String r107 = this.V;
        if (r107 != null) goto L22;
    L24:
        Unit r108 = Unit.INSTANCE;
        r103.a("show_search", r106);
        return;
    L22:
        if (com.bytedance.locallife.common.utils.j.a(r107) == false) goto L24;
        r106.put("spu_id", r107);
        goto L24
    L18:
        r105 = "product_page_search_bar";
        goto L19
    L9:
        if (this.R == false) goto L11;
        return;
    L11:
        this.R = true;
        goto L12
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onPublishEvent(PublishEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Map<String, Object> r101 = r100.params();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = PublishEventKt.getString(r101, LiveLocalLifeRoomInfo.TRACE_SESSION_ID);
    L7:
        if (Intrinsics.areEqual(r103, this.H.getTraceSessionId()) == true) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r100.name(), "goods_detail_card_network_finish") == false) goto L30;
        Map<String, Object> r104 = r100.params();
        if (r104 == null) goto L14;
        Object r105 = r104.get("result");
    L16:
        if (Intrinsics.areEqual(r105, "no_data") == false) goto L18;
    L19:
        Set<String> r106 = this.O;
        Map<String, Object> r107 = r100.params();
        if (r107 == null) goto L22;
        Object r108 = r107.get("tag");
    L24:
        if ((r108 instanceof String) == false) goto L26;
        r102 = (String) r108;
    L26:
        if (r102 != null) goto L28;
        r102 = "";
    L28:
        r106.add(r102);
        o0();
        return;
    L22:
        r108 = null;
        goto L24
    L18:
        if (Intrinsics.areEqual(r105, "error") == true) goto L19;
        return;
    L14:
        r105 = null;
        goto L16
    L30:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public OldGoodsHeaderView(Context r100, ww6.i r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bizContext");
        super(r100, null, 0);
        GoodsDetailBizContainerFragment r102 = r101.D90();
        this.H = r102;
        this.I = new com.bytedance.locallife.pdp.container.view.a(r101);
        this.f261882J = r101.getInfo().f261064k0;
        this.K = "0";
        this.M = 1000;
        this.O = new LinkedHashSet();
        int r103 = com.bytedance.locallife.pdp.container.g0.f261152a;
        r102.getClass();
        this.T = com.bytedance.locallife.pdp.container.g0.a.c(r102.getContext(), this.S, false);
        this.f261886k0 = true;
        this.f261888p0 = true;
        this.P0 = -1;
        this.f261884g1 = true;
        this.f261890v1 = LazyKt.lazy(new OldGoodsHeaderView$mAnimator$2(this));
        this.f261891x1 = new p0(this);
    }

    public final void c0(List<com.bytedance.locallife.host.share.a> r100, int r101) {
        SimpleDraweeView r102 = this.G;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r102 = null;
    L5:
        r102.setVisibility(8);
        SimpleDraweeView r103 = this.B;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r103 = null;
    L8:
        r103.setVisibility(8);
        if (r100 != null) goto L11;
        return;
    L11:
        Iterator<com.bytedance.locallife.host.share.a> r104 = r100.iterator();
    L13:
        if (r104.hasNext() == false) goto L41;
        com.bytedance.locallife.host.share.a r105 = r104.next();
        if (r105 == null) goto L30;
        String r106 = r105.getType();
        if (Intrinsics.areEqual(r106, "share") == false) goto L23;
        SimpleDraweeView r107 = this.G;
        if (r107 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
    L31:
        if (r107 == null) goto L13;
        if (Intrinsics.areEqual(this.H.ab().getTitleBarFloat().getValue(), Boolean.TRUE) == true) goto L34;
        if (r101 == 6) goto L40;
        if (r101 == 7) goto L40;
        r107.setVisibility(8);
    L40:
        r107.setVisibility(0);
        goto L13
    L34:
        r107.setVisibility(0);
        goto L13
    L23:
        if (Intrinsics.areEqual(r106, "search") == false) goto L30;
        if (Intrinsics.areEqual(r105.k(), "0") == true) goto L30;
        r107 = this.B;
        if (r107 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
    L30:
        r107 = null;
        goto L31
    }

    public final void d0(boolean r100, boolean r101) {
        String r102 = this.K;
        if (Intrinsics.areEqual(r102, "2") == false) goto L8;
        s r103 = this.f261887k1;
        if (r103 == null) goto L7;
        r103.b();
    L7:
        p0(r100, r101);
        return;
    L8:
        SimpleDraweeView r104 = null;
        String r105 = null;
        r105 = null;
        if (Intrinsics.areEqual(r102, "1") == true) goto L11;
        s r106 = this.f261887k1;
        if (r106 == null) goto L33;
        r106.b();
    L33:
        SimpleDraweeView r107 = this.B;
        if (r107 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
    L37:
        r104.setVisibility(8);
        return;
    L36:
        r104 = r107;
        goto L37
    L11:
        if (r100 == false) goto L26;
        SimpleDraweeView r108 = this.B;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r108 = null;
    L15:
        r108.setVisibility(8);
        yw6.k r109 = getModel();
        if (r109 == null) goto L21;
        yw6.u r110 = r109.c();
        if (r110 == null) goto L21;
        r105 = r110.o();
    L21:
        if (Intrinsics.areEqual(r105, "1") == false) goto L40;
        s r111 = this.f261887k1;
        if (r111 == null) goto L25;
        r111.f261945a.setVisibility(0);
    L25:
        h0(false);
        return;
    L40:
        return;
    L26:
        s r112 = this.f261887k1;
        if (r112 == null) goto L29;
        r112.b();
    L29:
        p0(false, r101);
    }

    public final void p0(boolean r100, boolean r101) {
        if (getAlpha() <= 0.0f) goto L5;
        h0(true);
    L5:
        SimpleDraweeView r102 = this.B;
        String r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r102 = null;
    L8:
        r102.setVisibility(0);
        SimpleDraweeView r104 = this.B;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r104 = null;
    L11:
        if (r100 == false) goto L21;
        yw6.k r105 = getModel();
        if (r105 == null) goto L31;
        yw6.u r106 = r105.c();
        if (r106 == null) goto L31;
        yw6.s r107 = r106.q();
        if (r107 == null) goto L31;
        yw6.r r108 = r107.a();
        if (r108 == null) goto L31;
        r103 = r108.d();
    L31:
        if (r101 == false) goto L35;
        if (r100 == false) goto L34;
        int r109 = ColorProtector.parseColor("#161823");
    L36:
        l0(r104, r103, R.drawable.ic_s_s_magnifier_outlined, r109);
        return;
    L34:
        r109 = ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT);
        goto L36
    L35:
        r109 = ColorProtector.parseColor("#161823");
        goto L36
    L21:
        yw6.k r110 = getModel();
        if (r110 == null) goto L31;
        yw6.u r111 = r110.c();
        if (r111 == null) goto L31;
        yw6.s r112 = r111.q();
        if (r112 == null) goto L31;
        yw6.r r113 = r112.d();
        if (r113 == null) goto L31;
        r103 = r113.d();
        goto L31
    }

    public final void q0(RecyclerView r100, Map<String, Integer> r110) {
        if (this.f261883b1 == false) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if (r101 != null) goto L8;
        return;
    L8:
        String r102 = null;
        if ((r101 instanceof LinearLayoutManager) == false) goto L12;
        int r103 = ((LinearLayoutManager) r101).findFirstVisibleItemPosition();
    L19:
        if (r103 != (-1)) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(this.H.ab().getTitleBarFloat().getValue(), Boolean.TRUE) == false) goto L47;
        BaseDitoView r104 = null;
        int r105 = 1;
    L25:
        if (r105 >= 6) goto L45;
        View r106 = r101.findViewByPosition(r103 + r105);
        if (r106 == null) goto L44;
        if (r106.getTop() > this.T) goto L45;
        if (r106.getHeight() <= 1) goto L45;
        boolean r107 = com.bytedance.locallife.dito.utils.n.f258708a;
        Iterator r108 = com.bytedance.locallife.dito.utils.n.e(r106).iterator();
    L36:
        if (r108.hasNext() == false) goto L40;
        Object r109 = r108.next();
        if ((((View) r109) instanceof BaseDitoView) == false) goto L36;
    L41:
        View r111 = (View) r109;
        if ((r111 instanceof BaseDitoView) == false) goto L44;
        r104 = (BaseDitoView) r111;
        goto L44
    L40:
        r109 = null;
    L44:
        r105 = r105 + 1;
    L45:
        if (r104 == null) goto L47;
    L64:
        if (r104 != null) goto L66;
        return;
    L66:
        BaseDitoModel r112 = r104.getModel();
        if (r112 == null) goto L71;
        com.bytedance.locallife.dito.data.m r113 = r112.f258493b;
        if (r113 == null) goto L71;
        r102 = r113.f258222b;
    L71:
        Integer r114 = r110.get(r102);
        if (r114 == null) goto L91;
        int r115 = r114.intValue();
        this.f261884g1 = false;
        TabLayout r116 = this.f261885h1;
        if (r116 == null) goto L92;
        TabLayout.Tab r117 = r116.getTabAt(r115);
        if (r117 == null) goto L93;
        r117.select();
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L47:
        View r118 = r101.findViewByPosition(r103);
        if (r118 == null) goto L59;
        boolean r119 = com.bytedance.locallife.dito.utils.n.f258708a;
        List r120 = com.bytedance.locallife.dito.utils.n.e(r118);
        if (r120 == null) goto L59;
        Iterator r121 = r120.iterator();
    L53:
        if (r121.hasNext() == false) goto L57;
        Object r122 = r121.next();
        if ((((View) r122) instanceof BaseDitoView) == false) goto L53;
    L58:
        View r123 = (View) r122;
    L61:
        if ((r123 instanceof BaseDitoView) == false) goto L63;
        r104 = (BaseDitoView) r123;
        goto L64
    L63:
        r104 = null;
        goto L64
    L57:
        r122 = null;
    L59:
        r123 = null;
        goto L61
    L12:
        if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L18;
        int[] r124 = ((StaggeredGridLayoutManager) r101).findFirstVisibleItemPositions(null);
        if (r124 == null) goto L18;
        Integer r125 = ArraysKt.firstOrNull(r124);
        if (r125 == null) goto L18;
        r103 = r125.intValue();
    L18:
        r103 = -1;
        goto L19
    }

    public final void k0(SimpleDraweeView r100, String r101, int r102) {
        if (r101 == null) goto L4;
        df6.u r103 = df6.q.e(r101);
        r103.f468295u = r100;
        r103.f468286l = r102;
        r103.c();
        Unit r104 = Unit.INSTANCE;
    L5:
        if (r104 != null) goto L8;
        r100.setImageDrawable(ContextCompat.getDrawable(getContext(), r102));
        return;
    L8:
        return;
    L4:
        r104 = null;
        goto L5
    }

    public final void l0(SimpleDraweeView r100, String r101, int r102, int r103) {
        if (r101 == null) goto L4;
        df6.u r104 = df6.q.e(r101);
        r104.f468295u = r100;
        r104.f468286l = r102;
        r104.c();
        return;
    L4:
        Drawable r105 = r100.getDrawable();
        if (r105 == null) goto L9;
        DrawableCompat.setTint(r105, r103);
        return;
    }
}
