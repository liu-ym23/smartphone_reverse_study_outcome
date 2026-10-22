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
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.locallife.ability.model.AbilityEnum;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.cube.api.model.PublishEvent;
import com.bytedance.locallife.cube.api.model.PublishEventKt;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.dito.utils.ApplicationUtil;
import com.bytedance.locallife.dito.utils.DitoExtKt;
import com.bytedance.locallife.host.share.CollectExtraParams;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.pdp.container.GoodsDetailBizContainerFragment;
import com.bytedance.locallife.pdp.container.GoodsDetailPage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.bmhome.share.panel.ShareChannel;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J%\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/locallife/pdp/view/MenuGoodsHeaderView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lyw6/k;", "", "getTitleTabStr", "", "visible", "", "setTitleVisible", "getSessionChangedWhenBindData", "isSelected", "setCollectButtonSelected", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", BaseSwitches.V, "getSearchBtnClickHandler", "Lcom/bytedance/locallife/cube/api/model/PublishEvent;", "event", "onPublishEvent", "getLifeHomepageFreshType", "Landroid/animation/ObjectAnimator;", "L1", "Lkotlin/Lazy;", "getMAnimator", "()Landroid/animation/ObjectAnimator;", "mAnimator", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class MenuGoodsHeaderView extends BaseDitoView<yw6.k> {
    public static final /* synthetic */ int Q1 = 0;
    public LinearLayout A;
    public TabLayout B;
    public DuxTextView C;
    public SimpleDraweeView D;
    public SimpleDraweeView E;
    public SimpleDraweeView F;
    public SimpleDraweeView G;
    public final boolean G1;
    public TabLayout H;
    public boolean H0;
    public boolean H1;
    public final GoodsDetailPage I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final com.bytedance.locallife.pdp.container.view.a f261834J;
    public final Uri K;
    public String L;
    public boolean L0;
    public final Lazy L1;
    public String M;
    public final w M1;
    public int N;
    public float O;
    public final Set<String> P;
    public int P0;
    public final e0 P1;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public int U;
    public String V;
    public int V0;
    public String W;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public String f261835b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f261836g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f261837h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f261838k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public TabLayout f261839k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f261840p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public s f261841p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f261842v1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f261843x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f261844y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final boolean f261845y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f261846z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuGoodsHeaderView f261847a;

        public b(MenuGoodsHeaderView r100) {
            this.f261847a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f261847a.getDataCenter().f().setValue(Boolean.TRUE);
        }
    }

    public static final class c implements LifeAccessibilityUtil.AccessibilityDelegateCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f261848a = null;

        static {
            f261848a = new c();
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
        public final /* synthetic */ Function1 f261849a;

        public d(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f261849a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r100) {
            this.f261849a.invoke(r100);
        }
    }

    public static final class e implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuGoodsHeaderView f261850a;

        public e(MenuGoodsHeaderView r100) {
            this.f261850a = r100;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(TabLayout.Tab r100) {
            onTabSelected(r100);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(TabLayout.Tab r110) {
            MenuGoodsHeaderView r100 = this.f261850a;
            if (r100.f261837h1 == false) goto L19;
            com.bytedance.locallife.pdp.container.view.a r101 = r100.f261834J;
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
            this.f261850a.f261836g1 = true;
            Pair[] r104 = new Pair[3];
            r104[0] = TuplesKt.to("eventName", "top_model");
            r104[1] = TuplesKt.to("offset", 8);
            Pair[] r105 = new Pair[2];
            r105[0] = TuplesKt.to(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, this.f261850a.I.getTraceSessionId());
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
            this.f261850a.f261837h1 = true;
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

    private final ObjectAnimator getMAnimator() {
        return (ObjectAnimator) this.L1.getValue();
    }

    private final Function1<View, Unit> getSearchBtnClickHandler() {
        return new AnonymousClass1(this);
    }

    private final boolean getSessionChangedWhenBindData() {
        String r100 = this.I.getTraceSessionId();
        boolean r101 = !Intrinsics.areEqual(r100, this.f261835b1);
        this.f261835b1 = r100;
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
        this.f261842v1 = DitoExtKt.e(getModel());
        if (r100 == true) goto L11;
        if (r101 == true) goto L11;
    L12:
        getDataCenter().Y().observe(this, this.P1);
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
        this.W = r107;
        Object r108 = getDitoViewModel().B.get("enterprise_tab_extra");
        if ((r108 instanceof String) == false) goto L34;
        String r109 = (String) r108;
    L35:
        this.f261838k0 = r109;
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
        this.L = r115;
        this.M = r114.l();
    L63:
        if (r100 == true) goto L67;
        if (r101 == true) goto L67;
        boolean r116 = false;
    L69:
        if (r116 == false) goto L134;
        boolean r117 = this.T;
        String r118 = this.L;
        if (Intrinsics.areEqual(r118, "2") == false) goto L73;
        boolean r119 = true;
    L75:
        if (r119 == false) goto L90;
        this.T = true;
        TabLayout r120 = this.H;
        if (r120 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title_tab_layout");
        r120 = null;
    L79:
        r120.setVisibility(8);
        if (Intrinsics.areEqual("1", this.L) == false) goto L84;
        s r121 = this.f261841p1;
        if (r121 == null) goto L87;
        r121.a(getContext(), this.W, this.f261834J.b().get("poi_id"), getLifeHomepageFreshType(), getSearchBtnClickHandler());
    L87:
        TabLayout r122 = this.B;
        if (r122 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_full_title_tab_layout");
    L99:
        r122 = null;
    L100:
        this.f261839k1 = r122;
        if (r117 == this.T) goto L103;
        int r123 = com.bytedance.locallife.pdp.container.g0.f261152a;
        this.U = com.bytedance.locallife.pdp.container.g0.a.c(this.I.getFragment().getContext(), this.T, false);
    L103:
        yw6.k r124 = getModel();
        if (r124 == null) goto L108;
        yw6.u r125 = r124.c();
        if (r125 == null) goto L108;
        String r126 = r125.o();
    L110:
        if (Intrinsics.areEqual(r126, "1") == false) goto L117;
        DuxTextView r127 = this.C;
        if (r127 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title");
        r127 = null;
    L114:
        r127.setVisibility(8);
        TabLayout r128 = this.f261839k1;
        if (r128 == null) goto L134;
        r128.setVisibility(0);
        this.P.clear();
        o0();
        goto L134
    L117:
        DuxTextView r129 = this.C;
        if (r129 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title");
        r129 = null;
    L120:
        r129.setVisibility(0);
        DuxTextView r130 = this.C;
        if (r130 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title");
        r130 = null;
    L123:
        yw6.k r131 = getModel();
        if (r131 == null) goto L130;
        yw6.u r132 = r131.c();
        if (r132 == null) goto L130;
        String r133 = r132.n();
        if (r133 == null) goto L130;
        r103 = r133;
    L130:
        r130.setText(r103);
        TabLayout r134 = this.f261839k1;
        if (r134 == null) goto L134;
        r134.setVisibility(8);
    L108:
        r126 = null;
        goto L110
    L84:
        s r135 = this.f261841p1;
        if (r135 == null) goto L87;
        r135.d();
        goto L87
    L90:
        this.T = false;
        TabLayout r136 = this.B;
        if (r136 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_full_title_tab_layout");
        r136 = null;
    L93:
        r136.setVisibility(8);
        s r137 = this.f261841p1;
        if (r137 == null) goto L96;
        r137.d();
    L96:
        r122 = this.H;
        if (r122 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_title_tab_layout");
        goto L99
    L73:
        r119 = Intrinsics.areEqual(r118, "1");
    L134:
        SimpleDraweeView r138 = this.D;
        if (r138 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r138 = null;
    L137:
        yw6.k r139 = getModel();
        if (r139 == null) goto L146;
        yw6.u r140 = r139.c();
        if (r140 == null) goto L146;
        yw6.s r141 = r140.q();
        if (r141 == null) goto L146;
        yw6.r r142 = r141.d();
        if (r142 == null) goto L146;
        String r143 = r142.b();
    L148:
        if (this.H0 == false) goto L150;
        int r144 = R.drawable.ic_s_s_arrowbackward_outlined;
    L151:
        k0(r138, r143, r144);
        if (com.bytedance.locallife.pdp.settings.l0.e() == false) goto L159;
        SimpleDraweeView r145 = this.D;
        if (r145 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r145 = null;
    L156:
        ViewTreeObserver r146 = r145.getViewTreeObserver();
        if (r146 == null) goto L159;
        r146.addOnPreDrawListener(new v(this));
    L159:
        SimpleDraweeView r147 = this.G;
        if (r147 != null) goto L162;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r147 = null;
    L162:
        yw6.k r148 = getModel();
        if (r148 == null) goto L171;
        yw6.u r149 = r148.c();
        if (r149 == null) goto L171;
        yw6.s r150 = r149.q();
        if (r150 == null) goto L171;
        yw6.r r151 = r150.d();
        if (r151 == null) goto L171;
        String r152 = r151.e();
    L172:
        k0(r147, r152, R.drawable.ic_s_s_arrowupright_outlined_20);
        SimpleDraweeView r153 = this.E;
        if (r153 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r153 = null;
    L175:
        yw6.k r154 = getModel();
        if (r154 == null) goto L184;
        yw6.u r155 = r154.c();
        if (r155 == null) goto L184;
        yw6.s r156 = r155.q();
        if (r156 == null) goto L184;
        yw6.r r157 = r156.d();
        if (r157 == null) goto L184;
        String r158 = r157.d();
    L185:
        k0(r153, r158, R.drawable.ic_s_s_magnifier_outlined);
        SimpleDraweeView r159 = this.F;
        if (r159 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r159 = null;
    L188:
        yw6.k r160 = getModel();
        if (r160 == null) goto L197;
        yw6.u r161 = r160.c();
        if (r161 == null) goto L197;
        yw6.s r162 = r161.q();
        if (r162 == null) goto L197;
        yw6.r r163 = r162.d();
        if (r163 == null) goto L197;
        String r164 = r163.c();
    L198:
        k0(r159, r164, R.drawable.poi_detail_collect_icon);
        if (Intrinsics.areEqual(this.I.ab().getTitleBarFloat().getValue(), Boolean.TRUE) == false) goto L201;
    L247:
        i0();
        if (r112 != null) goto L250;
        return;
    L250:
        Iterator<com.bytedance.locallife.host.share.a> r165 = r112.iterator();
    L252:
        if (r165.hasNext() == false) goto L304;
        com.bytedance.locallife.host.share.a r166 = r165.next();
        if (TextUtils.equals(r166.getType(), "share") == true) goto L256;
        if (TextUtils.equals(r166.getType(), "search") == true) goto L271;
        if (TextUtils.equals(r166.getType(), ShareChannel.COLLECT) == false) goto L252;
        if (this.f261845y1 == false) goto L289;
        CollectExtraParams r167 = r166.b();
        if (r167 != null) goto L296;
    L298:
        boolean r168 = false;
    L299:
        setCollectButtonSelected(r168);
        SimpleDraweeView r169 = this.F;
        if (r169 != null) goto L302;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r169 = null;
    L302:
        r169.setOnClickListener(new y(this));
        EventCenter.registerJsEventSubscriber("delivery_goods_detail_collect_button_intent_result", this.M1);
        goto L252
    L296:
        if (r167.isCollected() != 1) goto L298;
        r168 = true;
        goto L299
    L289:
        SimpleDraweeView r170 = this.F;
        if (r170 != null) goto L292;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r170 = null;
    L292:
        r170.setVisibility(8);
        goto L252
    L271:
        if (Intrinsics.areEqual(r166.k(), "0") == true) goto L252;
        if (this.H1 == false) goto L274;
        SimpleDraweeView r171 = this.E;
        if (r171 != null) goto L281;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r171 = null;
    L281:
        r171.setVisibility(0);
        SimpleDraweeView r172 = this.E;
        if (r172 != null) goto L284;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r172 = null;
    L284:
        r172.setOnClickListener(new d(getSearchBtnClickHandler()));
        goto L252
    L274:
        SimpleDraweeView r173 = this.E;
        if (r173 != null) goto L277;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r173 = null;
    L277:
        r173.setVisibility(8);
        goto L252
    L256:
        if (this.G1 == false) goto L257;
        SimpleDraweeView r174 = this.G;
        if (r174 != null) goto L264;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r174 = null;
    L264:
        r174.setVisibility(0);
        SimpleDraweeView r175 = this.G;
        if (r175 != null) goto L267;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r175 = null;
    L267:
        r175.setOnClickListener(new z(this, r166));
        goto L252
    L257:
        SimpleDraweeView r176 = this.G;
        if (r176 != null) goto L260;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r176 = null;
    L260:
        r176.setVisibility(8);
        goto L252
    L304:
        if (this.H0 == false) goto L306;
    L314:
        SimpleDraweeView r177 = this.D;
        if (r177 != null) goto L317;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        SimpleDraweeView r178 = null;
    L318:
        LifeAccessibilityUtil.setAccessibilityDelegate(r178, c.f261848a);
        return;
    L317:
        r178 = r177;
        goto L318
    L306:
        if (this.f261840p0 == false) goto L314;
        f0(this.P0);
        yw6.k r179 = getModel();
        if (r179 == null) goto L312;
        yw6.u r180 = r179.c();
        if (r180 == null) goto L312;
        List<com.bytedance.locallife.host.share.a> r181 = r180.c();
    L313:
        c0(r181, this.P0);
    L312:
        r181 = null;
        goto L313
    L201:
        if (this.H0 == false) goto L204;
    L210:
        float r182 = 1.0f;
    L211:
        setAlpha(r182);
        setTitleVisible(true);
        n0();
        SimpleDraweeView r183 = this.D;
        if (r183 != null) goto L214;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r183 = null;
    L214:
        Drawable r184 = r183.getDrawable();
        if (r184 == null) goto L217;
        DrawableCompat.setTint(r184, ColorProtector.parseColor("#161823"));
    L217:
        SimpleDraweeView r185 = this.E;
        if (r185 != null) goto L220;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r185 = null;
    L220:
        Drawable r186 = r185.getDrawable();
        if (r186 == null) goto L223;
        DrawableCompat.setTint(r186, ColorProtector.parseColor("#161823"));
    L223:
        SimpleDraweeView r187 = this.G;
        if (r187 != null) goto L226;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r187 = null;
    L226:
        Drawable r188 = r187.getDrawable();
        if (r188 == null) goto L229;
        DrawableCompat.setTint(r188, ColorProtector.parseColor("#161823"));
    L229:
        SimpleDraweeView r189 = this.F;
        if (r189 != null) goto L232;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r189 = null;
    L232:
        Drawable r190 = r189.getDrawable();
        if (r190 == null) goto L243;
        SimpleDraweeView r191 = this.F;
        if (r191 != null) goto L238;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r191 = null;
    L238:
        if ((!r191.isSelected()) == true) goto L241;
        r190 = null;
    L241:
        if (r190 == null) goto L243;
        DrawableCompat.setTint(r190, ColorProtector.parseColor("#161823"));
    L243:
        LinearLayout r192 = this.A;
        if (r192 != null) goto L246;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        r192 = null;
    L246:
        r192.setBackgroundColor(this.V0);
        goto L247
    L204:
        if (this.f261840p0 == false) goto L210;
        int r193 = this.P0;
        if (r193 == 6) goto L210;
        if (r193 == 7) goto L210;
        r182 = 0.0f;
    L197:
        r164 = null;
    L184:
        r158 = null;
    L171:
        r152 = null;
        goto L172
    L150:
        r144 = R.drawable.ic_s_s_xmark_outlined;
    L146:
        r143 = null;
    L67:
        r116 = true;
        goto L69
    L50:
        ArrayList r194 = new ArrayList();
        Iterator<T> r195 = r112.iterator();
    L52:
        if (r195.hasNext() == false) goto L56;
        Object r196 = r195.next();
        if (Intrinsics.areEqual(((com.bytedance.locallife.host.share.a) r196).getType(), "search") == false) goto L52;
        r194.add(r196);
        goto L52
    L56:
        r114 = (com.bytedance.locallife.host.share.a) CollectionsKt.getOrNull(r194, 0);
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
        if (Intrinsics.areEqual(this.V, r105) == true) goto L27;
        this.V = r105;
        this.V0 = ColorProtector.parseColor("#" + r105.substring(r105.length() - 2, r105.length()) + r105.subSequence(1, r105.length() - 2));
        if (this.H0 == false) goto L27;
        m0();
    L18:
        r105 = "";
    L11:
        this.Q = false;
        this.S = false;
        this.R = false;
        goto L12
    L5:
        if (this.f261842v1 == false) goto L7;
        r101 = true;
        goto L8
    }

    public final void g0() {
        if (this.Q == false) goto L5;
        return;
    L5:
        this.Q = true;
        this.f261834J.a("project_detail_nav_bar_show", MapsKt.mapOf(TuplesKt.to("bar_name", getTitleTabStr())));
    }

    public final String getLifeHomepageFreshType() {
        Map<String, String> r100 = this.f261834J.b();
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

    public final void i0() {
        Boolean r100 = this.I.ab().getTitleBarFloat().getValue();
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == true) goto L5;
        yw6.k r102 = getModel();
        if (r102 == null) goto L161;
        yw6.u r103 = r102.c();
        if (r103 == null) goto L161;
        yw6.s r104 = r103.q();
        if (r104 == null) goto L161;
        Integer r105 = r104.c();
        if (r105 == null) goto L161;
        float r106 = xo6.b.a(r105.intValue());
    L163:
        if (this.O < r106) goto L204;
        j0();
        SimpleDraweeView r107 = this.D;
        if (r107 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r107 = null;
    L167:
        yw6.k r108 = getModel();
        if (r108 == null) goto L176;
        yw6.u r109 = r108.c();
        if (r109 == null) goto L176;
        yw6.s r110 = r109.q();
        if (r110 == null) goto L176;
        yw6.r r111 = r110.a();
        if (r111 == null) goto L176;
        String r112 = r111.b();
    L177:
        int r113 = ColorProtector.parseColor("#161823");
        Boolean r114 = Boolean.FALSE;
        l0(r107, r112, R.drawable.ic_s_s_xmark_outlined, r113, r114);
        d0(true, false);
        SimpleDraweeView r115 = this.G;
        if (r115 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r115 = null;
    L180:
        yw6.k r116 = getModel();
        if (r116 == null) goto L189;
        yw6.u r117 = r116.c();
        if (r117 == null) goto L189;
        yw6.s r118 = r117.q();
        if (r118 == null) goto L189;
        yw6.r r119 = r118.a();
        if (r119 == null) goto L189;
        String r120 = r119.e();
    L190:
        l0(r115, r120, R.drawable.ic_s_s_arrowupright_outlined_20, ColorProtector.parseColor("#161823"), r114);
        SimpleDraweeView r121 = this.F;
        if (r121 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r121 = null;
    L193:
        yw6.k r122 = getModel();
        if (r122 == null) goto L202;
        yw6.u r123 = r122.c();
        if (r123 == null) goto L202;
        yw6.s r124 = r123.q();
        if (r124 == null) goto L202;
        yw6.r r125 = r124.a();
        if (r125 == null) goto L202;
        String r126 = r125.c();
    L203:
        l0(r121, r126, R.drawable.poi_detail_collect_icon, ColorProtector.parseColor("#161823"), r101);
    L244:
        LinearLayout r127 = this.A;
        if (r127 != null) goto L247;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        r127 = null;
    L247:
        r127.setBackgroundColor(this.V0);
        yw6.k r128 = getModel();
        if (r128 == null) goto L252;
        yw6.u r129 = r128.c();
        if (r129 == null) goto L252;
        String r130 = r129.o();
    L254:
        if (Intrinsics.areEqual(r130, "1") == false) goto L272;
        TabLayout r131 = this.f261839k1;
        if (r131 != null) goto L259;
    L263:
        TabLayout r132 = this.f261839k1;
        if (r132 == null) goto L266;
        float r133 = r132.getAlpha();
    L268:
        if (r133 <= 0.0f) goto L273;
        g0();
        return;
    L273:
        return;
    L266:
        r133 = 0.0f;
        goto L268
    L259:
        if (Intrinsics.areEqual(this.L, "1") == false) goto L261;
        float r134 = 1.0f;
    L262:
        r131.setAlpha(r134);
        goto L263
    L261:
        r134 = Math.min(1.0f, Math.max(0.0f, this.O - xo6.b.a(60)) / xo6.b.a(60));
        goto L262
    L272:
        return;
    L252:
        r130 = null;
    L202:
        r126 = null;
    L189:
        r120 = null;
    L176:
        r112 = null;
        goto L177
    L204:
        n0();
        SimpleDraweeView r135 = this.D;
        if (r135 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r135 = null;
    L207:
        yw6.k r136 = getModel();
        if (r136 == null) goto L216;
        yw6.u r137 = r136.c();
        if (r137 == null) goto L216;
        yw6.s r138 = r137.q();
        if (r138 == null) goto L216;
        yw6.r r139 = r138.d();
        if (r139 == null) goto L216;
        String r140 = r139.b();
    L217:
        int r141 = ColorProtector.parseColor("#161823");
        Boolean r142 = Boolean.FALSE;
        l0(r135, r140, R.drawable.ic_s_s_xmark_outlined, r141, r142);
        d0(false, false);
        SimpleDraweeView r143 = this.G;
        if (r143 != null) goto L220;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r143 = null;
    L220:
        yw6.k r144 = getModel();
        if (r144 == null) goto L229;
        yw6.u r145 = r144.c();
        if (r145 == null) goto L229;
        yw6.s r146 = r145.q();
        if (r146 == null) goto L229;
        yw6.r r147 = r146.d();
        if (r147 == null) goto L229;
        String r148 = r147.e();
    L230:
        l0(r143, r148, R.drawable.ic_s_s_arrowupright_outlined_20, ColorProtector.parseColor("#161823"), r142);
        SimpleDraweeView r149 = this.F;
        if (r149 != null) goto L233;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r149 = null;
    L233:
        yw6.k r150 = getModel();
        if (r150 == null) goto L242;
        yw6.u r151 = r150.c();
        if (r151 == null) goto L242;
        yw6.s r152 = r151.q();
        if (r152 == null) goto L242;
        yw6.r r153 = r152.d();
        if (r153 == null) goto L242;
        String r154 = r153.c();
    L243:
        l0(r149, r154, R.drawable.poi_detail_collect_icon, ColorProtector.parseColor("#161823"), r101);
    L242:
        r154 = null;
    L229:
        r148 = null;
    L216:
        r140 = null;
    L161:
        r106 = xo6.b.a(30);
        goto L163
    L5:
        if (this.H0 == false) goto L7;
        float r155 = 1.0f;
    L8:
        setAlpha(r155);
        if (getAlpha() > 0.0f) goto L11;
        int r156 = 4;
    L12:
        setVisibility(r156);
        yw6.k r157 = getModel();
        if (r157 == null) goto L21;
        yw6.u r158 = r157.c();
        if (r158 == null) goto L21;
        yw6.s r159 = r158.q();
        if (r159 == null) goto L21;
        Integer r160 = r159.b();
        if (r160 == null) goto L21;
        float r161 = xo6.b.a(r160.intValue());
    L22:
        yw6.k r162 = getModel();
        if (r162 == null) goto L31;
        yw6.u r163 = r162.c();
        if (r163 == null) goto L31;
        yw6.s r164 = r163.q();
        if (r164 == null) goto L31;
        Integer r165 = r164.c();
        if (r165 == null) goto L31;
        float r166 = xo6.b.a(r165.intValue());
    L33:
        if (this.O < r166) goto L91;
        yw6.k r167 = getModel();
        if (r167 == null) goto L39;
        yw6.u r168 = r167.c();
        if (r168 == null) goto L39;
        String r169 = r168.o();
    L41:
        if (Intrinsics.areEqual(r169, "1") == false) goto L43;
        g0();
    L43:
        setTitleVisible(true);
        this.f261843x1 = false;
        j0();
        SimpleDraweeView r170 = this.D;
        if (r170 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r170 = null;
    L46:
        yw6.k r171 = getModel();
        if (r171 == null) goto L55;
        yw6.u r172 = r171.c();
        if (r172 == null) goto L55;
        yw6.s r173 = r172.q();
        if (r173 == null) goto L55;
        yw6.r r174 = r173.a();
        if (r174 == null) goto L55;
        String r175 = r174.b();
    L56:
        int r176 = ColorProtector.parseColor("#161823");
        Boolean r177 = Boolean.FALSE;
        l0(r170, r175, R.drawable.ic_s_s_xmark_outlined, r176, r177);
        d0(true, true);
        SimpleDraweeView r178 = this.G;
        if (r178 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r178 = null;
    L59:
        yw6.k r179 = getModel();
        if (r179 == null) goto L68;
        yw6.u r180 = r179.c();
        if (r180 == null) goto L68;
        yw6.s r181 = r180.q();
        if (r181 == null) goto L68;
        yw6.r r182 = r181.a();
        if (r182 == null) goto L68;
        String r183 = r182.e();
    L69:
        l0(r178, r183, R.drawable.ic_s_s_arrowupright_outlined_20, ColorProtector.parseColor("#161823"), r177);
        SimpleDraweeView r184 = this.F;
        if (r184 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r184 = null;
    L72:
        yw6.k r185 = getModel();
        if (r185 == null) goto L81;
        yw6.u r186 = r185.c();
        if (r186 == null) goto L81;
        yw6.s r187 = r186.q();
        if (r187 == null) goto L81;
        yw6.r r188 = r187.a();
        if (r188 == null) goto L81;
        String r189 = r188.c();
    L82:
        l0(r184, r189, R.drawable.poi_detail_collect_icon, ColorProtector.parseColor("#161823"), r101);
        LinearLayout r190 = this.A;
        if (r190 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        LinearLayout r191 = null;
    L87:
        if (r161 > r166) goto L89;
        int r192 = this.V0;
    L90:
        r191.setBackgroundColor(r192);
        return;
    L89:
        r192 = qx6.a.a((this.O - (r166 / r161)) - r166, this.V0);
        goto L90
    L85:
        r191 = r190;
    L81:
        r189 = null;
    L68:
        r183 = null;
    L55:
        r175 = null;
    L39:
        r169 = null;
        goto L41
    L91:
        setTitleVisible(false);
        this.f261843x1 = true;
        yw6.k r193 = getModel();
        if (r193 == null) goto L105;
        yw6.u r194 = r193.c();
        if (r194 == null) goto L105;
        yw6.s r195 = r194.q();
        if (r195 == null) goto L105;
        yw6.r r196 = r195.d();
        if (r196 == null) goto L105;
        String r197 = r196.a();
        if (r197 == null) goto L105;
        LinearLayout r198 = this.A;
        if (r198 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        r198 = null;
    L104:
        r198.setBackgroundColor(ColorProtector.parseColor(r197));
        Unit r199 = Unit.INSTANCE;
    L106:
        if (r199 != null) goto L111;
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.poi_bg_trade_goods_header));
        LinearLayout r200 = this.A;
        if (r200 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("goods_header_container");
        r200 = null;
    L110:
        r200.setBackgroundColor(qx6.a.a(Math.min(1.0f * r161, this.O) / r161, this.V0));
    L111:
        d0(false, true);
        SimpleDraweeView r201 = this.D;
        if (r201 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r201 = null;
    L114:
        yw6.k r202 = getModel();
        if (r202 == null) goto L123;
        yw6.u r203 = r202.c();
        if (r203 == null) goto L123;
        yw6.s r204 = r203.q();
        if (r204 == null) goto L123;
        yw6.r r205 = r204.d();
        if (r205 == null) goto L123;
        String r206 = r205.b();
    L124:
        int r207 = ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT);
        Boolean r208 = Boolean.FALSE;
        l0(r201, r206, R.drawable.ic_s_s_xmark_outlined, r207, r208);
        SimpleDraweeView r209 = this.G;
        if (r209 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r209 = null;
    L127:
        yw6.k r210 = getModel();
        if (r210 == null) goto L136;
        yw6.u r211 = r210.c();
        if (r211 == null) goto L136;
        yw6.s r212 = r211.q();
        if (r212 == null) goto L136;
        yw6.r r213 = r212.d();
        if (r213 == null) goto L136;
        String r214 = r213.e();
    L137:
        l0(r209, r214, R.drawable.ic_s_s_arrowupright_outlined_20, ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT), r208);
        SimpleDraweeView r215 = this.F;
        if (r215 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r215 = null;
    L140:
        yw6.k r216 = getModel();
        if (r216 == null) goto L149;
        yw6.u r217 = r216.c();
        if (r217 == null) goto L149;
        yw6.s r218 = r217.q();
        if (r218 == null) goto L149;
        yw6.r r219 = r218.d();
        if (r219 == null) goto L149;
        String r220 = r219.c();
    L150:
        l0(r215, r220, R.drawable.poi_detail_collect_icon, ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT), r101);
        return;
    L149:
        r220 = null;
    L136:
        r214 = null;
    L123:
        r206 = null;
    L105:
        r199 = null;
    L31:
        r166 = xo6.b.a(30);
    L21:
        r161 = xo6.b.a(60);
        goto L22
    L11:
        r156 = 0;
        goto L12
    L7:
        r155 = (xo6.b.a(60) - (Math.min((int) xo6.b.a(60), Math.max(this.N, 0)) * 1.0f)) / xo6.b.a(60);
        goto L8
    }

    public final void o0() {
        TabLayout r100 = this.f261839k1;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllTabs();
        r100.setTabGravity(!this.T ? 1 : 0);
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
        if (this.P.contains(r108.a()) == true) goto L32;
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
        View r121 = LayoutInflater.from(this.I.getFragment().getContext()).inflate(R.layout.saas_poi_goods_detail_title_tab_view, this, false);
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
        RecyclerView r126 = this.I.Ok();
        if (r126 == null) goto L61;
        r126.setOnScrollListener(new MenuGoodsHeaderView$setTitleTabLayout$2(this, r113));
    L61:
        TabLayout r127 = this.f261839k1;
        if (r127 == null) goto L64;
        r127.setOnTabSelectedListener(new e(this));
    L64:
        RecyclerView r128 = this.I.Ok();
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
        getDataCenter().Y().removeObserver(this.P1);
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
        this.V0 = ColorProtector.parseColor(r104);
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
        this.V0 = ColorProtector.parseColor(r104);
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
        boolean r100 = false;
        if (this.H1 == false) goto L13;
        List<String> r101 = HostServiceUtilsKt.e0().a();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        this.H1 = false;
        goto L13
    L7:
        if (r101.isEmpty() == true) goto L10;
        r102 = false;
    L13:
        vn6.b.b(this);
        ht6.a r103 = this.I.fU();
        if (r103 != null) goto L53;
    L19:
        addView(LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_trade_menu_product_header, this, false));
        this.f261844y = findViewById(R.id.goods_detail_search_bar);
        this.f261846z = findViewById(R.id.status_bar);
        this.A = (LinearLayout) findViewById(R.id.goods_header_container);
        this.B = (TabLayout) findViewById(R.id.goods_detail_full_title_tab_layout);
        this.C = (DuxTextView) findViewById(R.id.goods_detail_title);
        this.D = (SimpleDraweeView) findViewById(R.id.trade_product_detail_back);
        this.E = (SimpleDraweeView) findViewById(R.id.trade_product_search);
        this.F = (SimpleDraweeView) findViewById(R.id.trade_product_collect);
        this.G = (SimpleDraweeView) findViewById(R.id.trade_product_share);
        this.H = (TabLayout) findViewById(R.id.goods_detail_title_tab_layout);
        View r104 = this.f261844y;
        View r105 = null;
        if (r104 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("goods_detail_search_bar");
        r104 = null;
    L22:
        this.f261841p1 = new s(r104);
        View r106 = this.f261846z;
        if (r106 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("status_bar");
        r106 = null;
    L25:
        r106.getLayoutParams().height = j56.a.b(getContext());
        SimpleDraweeView r107 = this.D;
        if (r107 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_detail_back");
        r107 = null;
    L28:
        r107.setOnClickListener(new x(this));
        Object r108 = getDitoViewModel().B.get("hide_nav_bar");
        if ((r108 instanceof String) == false) goto L31;
        String r109 = (String) r108;
    L32:
        this.f261840p0 = TextUtils.equals(r109, "1");
        Object r110 = getDitoViewModel().A.get("view_screen_include_full_in_popup");
        if ((r110 instanceof Boolean) == false) goto L35;
        Boolean r111 = (Boolean) r110;
    L36:
        if (r111 == null) goto L38;
        r100 = r111.booleanValue();
    L38:
        this.L0 = r100;
        Object r112 = getDitoViewModel().A.get("view_screen_is_full");
        if ((r112 instanceof Boolean) == false) goto L41;
        Boolean r113 = (Boolean) r112;
    L42:
        if (r113 == null) goto L44;
        boolean r114 = r113.booleanValue();
    L45:
        this.H0 = r114;
        this.I.ab().getTitleBarFloat().observe(this, new a0(this));
        DitoDataCenter r115 = getDataCenter();
        int r116 = DitoDataCenter.f258004d;
        r115.a0("dialog_state_event", 1).observe(this, new b0(this));
        getDataCenter().a0("dialog_top_event", 1).observe(this, new c0(this));
        getDataCenter().a0("share_im_dialog_close_event", 1).observe(this, new d0(this));
        if (this.L0 == false) goto L55;
        View r117 = this.f261846z;
        if (r117 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("status_bar");
    L51:
        r105.getLayoutParams().height = (int) xo6.b.a(6);
        return;
    L50:
        r105 = r117;
        goto L51
    L55:
        return;
    L44:
        r114 = true;
        goto L45
    L41:
        r113 = null;
        goto L42
    L35:
        r111 = null;
        goto L36
    L31:
        r109 = null;
        goto L32
    L53:
        r103.getView();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        HostServiceUtilsKt.c().b(e);
        goto L19
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onDestroy() {
        super.onDestroy();
        vn6.b.c(this);
        if ((getContext() instanceof Activity) == false) goto L5;
        Context r100 = getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");
        ImmersionBar.with((Activity) r100).destroy();
    L5:
        EventCenter.unregisterJsEventSubscriber("delivery_goods_detail_collect_button_intent_result", this.M1);
    }

    public static final /* synthetic */ ObjectAnimator a0(MenuGoodsHeaderView r100) {
        return r100.getMAnimator();
    }

    private final void setCollectButtonSelected(boolean r100) {
        SimpleDraweeView r101 = this.F;
        SimpleDraweeView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r101 = null;
    L5:
        r101.setSelected(r100);
        SimpleDraweeView r103 = this.F;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r103 = null;
    L8:
        r103.setVisibility(0);
        SimpleDraweeView r104 = this.F;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r104 = null;
    L12:
        if (r104.isSelected() == false) goto L15;
        int r105 = ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED);
    L18:
        SimpleDraweeView r106 = this.F;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
    L22:
        Drawable r107 = r102.getDrawable();
        if (r107 == null) goto L26;
        DrawableCompat.setTint(r107, r105);
        return;
    L26:
        return;
    L21:
        r102 = r106;
        goto L22
    L15:
        if (this.f261843x1 == false) goto L17;
        r105 = ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT);
        goto L18
    L17:
        r105 = ColorProtector.parseColor("#161823");
        goto L18
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
        View r105 = this.f261839k1;
    L14:
        if (r105 == null) goto L30;
        if (r100 == true) goto L18;
    L27:
        int r106 = 4;
    L28:
        r105.setVisibility(r106);
        return;
    L18:
        if (Intrinsics.areEqual(this.I.ab().getTitleBarFloat().getValue(), Boolean.TRUE) == true) goto L26;
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
        r105 = this.C;
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
        if (this.R == false) goto L7;
        return;
    L7:
        this.R = true;
    L12:
        s r101 = this.f261841p1;
        if (r101 == null) goto L15;
        int r102 = s.f261944f;
        r101.c(null);
    L15:
        com.bytedance.locallife.pdp.container.view.a r103 = this.f261834J;
        Pair[] r104 = new Pair[2];
        r104[0] = TuplesKt.to("enter_from", "product_page");
        if (r100 == false) goto L18;
        String r105 = "product_page_search_icon";
    L19:
        r104[1] = TuplesKt.to(ECFindSimilarConfig.ENTER_FROM_SECOND, r105);
        Map<String, String> r106 = MapsKt.mutableMapOf(r104);
        String r107 = this.W;
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
        if (this.S == false) goto L11;
        return;
    L11:
        this.S = true;
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
        if (Intrinsics.areEqual(r103, this.I.getTraceSessionId()) == true) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r100.name(), "goods_detail_card_network_finish") == false) goto L30;
        Map<String, Object> r104 = r100.params();
        if (r104 == null) goto L14;
        Object r105 = r104.get("result");
    L16:
        if (Intrinsics.areEqual(r105, "no_data") == false) goto L18;
    L19:
        Set<String> r106 = this.P;
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

    public MenuGoodsHeaderView(Context r100, ww6.i r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bizContext");
        super(r100, null, 0);
        GoodsDetailBizContainerFragment r102 = r101.D90();
        this.I = r102;
        this.f261834J = new com.bytedance.locallife.pdp.container.view.a(r101);
        this.K = r101.getInfo().f261064k0;
        this.L = "0";
        this.N = 1000;
        this.P = new LinkedHashSet();
        int r103 = com.bytedance.locallife.pdp.container.g0.f261152a;
        r102.getClass();
        this.U = com.bytedance.locallife.pdp.container.g0.a.c(r102.getContext(), this.T, false);
        this.f261840p0 = true;
        this.H0 = true;
        this.V0 = -1;
        this.f261837h1 = true;
        this.f261845y1 = HostServiceUtilsKt.h().b(AbilityEnum.COLLECT_SERVICE);
        this.G1 = HostServiceUtilsKt.h().b(AbilityEnum.SHARE_SERVICE);
        this.H1 = HostServiceUtilsKt.h().b(AbilityEnum.SEARCH_SERVICE);
        this.L1 = LazyKt.lazy(new MenuGoodsHeaderView$mAnimator$2(this));
        this.M1 = new w(this);
        this.P1 = new e0(this);
    }

    public static final /* synthetic */ void b0(MenuGoodsHeaderView r100, boolean r101) {
        r100.setCollectButtonSelected(r101);
    }

    public final void c0(List<com.bytedance.locallife.host.share.a> r110, int r111) {
        SimpleDraweeView r100 = this.G;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        r100 = null;
    L5:
        r100.setVisibility(8);
        SimpleDraweeView r101 = this.E;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r101 = null;
    L8:
        r101.setVisibility(8);
        SimpleDraweeView r102 = this.F;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
        r102 = null;
    L11:
        r102.setVisibility(8);
        if (r110 != null) goto L14;
        return;
    L14:
        Iterator<com.bytedance.locallife.host.share.a> r112 = r110.iterator();
    L16:
        if (r112.hasNext() == false) goto L61;
        com.bytedance.locallife.host.share.a r103 = r112.next();
        if (r103 == null) goto L50;
        String r104 = r103.getType();
        if (r104 == null) goto L50;
        int r105 = r104.hashCode();
        if (r105 == (-906336856)) goto L42;
        if (r105 == 109400031) goto L36;
        if (r105 != 949444906) goto L50;
        if (r104.equals(ShareChannel.COLLECT) == false) goto L50;
        SimpleDraweeView r106 = this.F;
        if (r106 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_collect");
    L51:
        if (r106 == null) goto L16;
        if (Intrinsics.areEqual(this.I.ab().getTitleBarFloat().getValue(), Boolean.TRUE) == true) goto L54;
        if (r111 == 6) goto L60;
        if (r111 == 7) goto L60;
        r106.setVisibility(8);
    L60:
        r106.setVisibility(0);
        goto L16
    L54:
        r106.setVisibility(0);
        goto L16
    L36:
        if (r104.equals("share") == false) goto L50;
        r106 = this.G;
        if (r106 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_share");
        goto L50
    L42:
        if (r104.equals("search") == false) goto L50;
        if (Intrinsics.areEqual(r103.k(), "0") == true) goto L50;
        r106 = this.E;
        if (r106 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
    L50:
        r106 = null;
        goto L51
    }

    public final void d0(boolean r100, boolean r101) {
        String r102 = this.L;
        if (Intrinsics.areEqual(r102, "2") == false) goto L8;
        s r103 = this.f261841p1;
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
        s r106 = this.f261841p1;
        if (r106 == null) goto L33;
        r106.b();
    L33:
        SimpleDraweeView r107 = this.E;
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
        SimpleDraweeView r108 = this.E;
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
        s r111 = this.f261841p1;
        if (r111 == null) goto L25;
        r111.f261945a.setVisibility(0);
    L25:
        h0(false);
        return;
    L40:
        return;
    L26:
        s r112 = this.f261841p1;
        if (r112 == null) goto L29;
        r112.b();
    L29:
        p0(false, r101);
    }

    public final void p0(boolean r100, boolean r101) {
        if (getAlpha() <= 0.0f) goto L5;
        h0(true);
    L5:
        SimpleDraweeView r102 = this.E;
        String r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("trade_product_search");
        r102 = null;
    L8:
        r102.setVisibility(0);
        SimpleDraweeView r104 = this.E;
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
        l0(r104, r103, R.drawable.ic_s_s_magnifier_outlined, r109, Boolean.FALSE);
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
        if (this.f261836g1 == false) goto L5;
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
        if (Intrinsics.areEqual(this.I.ab().getTitleBarFloat().getValue(), Boolean.TRUE) == false) goto L47;
        BaseDitoView r104 = null;
        int r105 = 1;
    L25:
        if (r105 >= 6) goto L45;
        View r106 = r101.findViewByPosition(r103 + r105);
        if (r106 == null) goto L44;
        if (r106.getTop() > this.U) goto L45;
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
        this.f261837h1 = false;
        TabLayout r116 = this.f261839k1;
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

    public static void l0(SimpleDraweeView r100, String r101, int r102, int r103, Boolean r104) {
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == true) goto L5;
    L7:
        if (r101 == null) goto L9;
        df6.u r105 = df6.q.e(r101);
        r105.f468295u = r100;
        r105.f468286l = r102;
        r105.c();
        return;
    L9:
        Drawable r106 = r100.getDrawable();
        if (r106 == null) goto L14;
        DrawableCompat.setTint(r106, r103);
        return;
    L14:
        return;
    L5:
        if (r100.isSelected() == false) goto L7;
    }
}
