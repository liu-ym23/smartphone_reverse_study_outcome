package com.bytedance.locallife.poi.newdetail.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.ability.model.AbilityEnum;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.widget.SimpleLynxView;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.interact.AbstractInteractBehavior;
import com.bytedance.locallife.dito.interact.CustomBottomBehavior;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.bytedance.locallife.model.poi.resp.PoiExtension;
import com.bytedance.locallife.model.poi.resp.PoiServerAbmap;
import com.bytedance.locallife.poi.dito.poi.ui.HeaderImageMaskView;
import com.bytedance.locallife.poi.newdetail.category.defaults.PoiDefaultQuickBgController;
import com.bytedance.locallife.poi.newdetail.widget.PoiDetailBgView;
import com.bytedance.locallife.poi.newdetail.widget.contentplayer.PoiContentPlayerView;
import com.bytedance.locallife.poi.newdetail.widget.lynx.PoiSimpleLynxView;
import com.bytedance.locallife.poi.newdetail.widget.trip.TripPoiHeadWidget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.poi.event.PoiClickHeaderInfoEvent;
import com.ss.android.ugc.aweme.poi.event.PoiClickNaviBlankEvent;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import com.ss.android.ugc.aweme.poi.model.HeadVideoStrict;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B%\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0011H\u0007¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiQuickPageBackgroundView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/poi/newdetail/component/u;", "Lat6/c;", "Lcom/bytedance/locallife/model/poi/resp/PoiExtension;", "poiExtension", "", "setHeadBgBanners", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/d;", "getPoiContentPlayerCallback", "", "state", "setBackgroundCornerAccordingState", "(Ljava/lang/Integer;)V", "Lcom/ss/android/ugc/aweme/poi/event/PoiClickHeaderInfoEvent;", "event", "onEvent", "Lcom/ss/android/ugc/aweme/poi/event/PoiClickNaviBlankEvent;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiQuickPageBackgroundView extends BaseDitoView<u> implements at6.c {

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final /* synthetic */ int f263079k1 = 0;
    public PoiBundle A;
    public String B;
    public boolean C;
    public boolean D;
    public boolean E;
    public FrameLayout F;
    public TripPoiHeadWidget G;
    public PoiSimpleLynxView H;
    public Function1<? super Integer, Unit> H0;
    public FrameLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public SmartImageView f263080J;
    public HeaderImageMaskView K;
    public PoiDetailBgView L;
    public JSONObject L0;
    public PoiContentPlayerView M;
    public boolean N;
    public int O;
    public boolean P;
    public final b P0;
    public boolean Q;
    public int R;
    public int S;
    public boolean T;
    public boolean U;
    public int V;
    public final at6.b V0;
    public int W;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f263081b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f263082g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f263083h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f263084k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f263085p0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public py6.a f263086y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PoiDetail f263087z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiQuickPageBackgroundView f263088a;

        public b(PoiQuickPageBackgroundView r100) {
            this.f263088a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            PoiBundle r102 = this.f263088a.A;
            if (r102 == null) goto L5;
            String r103 = r102.poiId;
        L7:
            if (TextUtils.equals(r103, r101.optString("poi_id")) == false) goto L10;
            this.f263088a.L0 = r101;
            return;
        L10:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class c extends com.bytedance.locallife.poi.newdetail.component.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PoiQuickPageBackgroundView f263089e;

        @Override // com.bytedance.locallife.poi.newdetail.widget.contentplayer.d
        public final void a() {
            PoiQuickPageBackgroundView.f0(this.f263089e, 1, "slide", k(), 0, false, false, PoiQuickPageBackgroundView.a0(this.f263089e), null, null, Boolean.TRUE, 16256);
        }

        public c(PoiQuickPageBackgroundView r100) {
            this.f263089e = r100;
        }

        @Override // com.bytedance.locallife.poi.newdetail.component.a, com.bytedance.locallife.poi.newdetail.widget.contentplayer.d
        public final void b(com.bytedance.locallife.poi.newdetail.widget.contentplayer.i r110) {
            Intrinsics.checkNotNullParameter(r110, "tagItem");
            super.b(r110);
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r100 = r110.b();
            String r101 = null;
            if (r100 == null) goto L5;
            String r111 = r100.e();
        L6:
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r112 = r110.b();
            if (r112 == null) goto L9;
            r101 = r112.a();
        L9:
            String r113 = r101;
            JSONObject r102 = k();
            if (r113 == null) goto L12;
            boolean r103 = true;
        L13:
            PoiQuickPageBackgroundView.f0(this.f263089e, 1, "click_photo", r102, 0, false, r103, PoiQuickPageBackgroundView.a0(this.f263089e), r113, r111, Boolean.TRUE, 15616);
            return;
        L12:
            r103 = false;
            goto L13
        L5:
            r111 = null;
            goto L6
        }

        @Override // com.bytedance.locallife.poi.newdetail.component.a, com.bytedance.locallife.poi.newdetail.widget.contentplayer.d
        public final void j(int r110, List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r111) {
            Intrinsics.checkNotNullParameter(r111, "tabList");
            super.j(r110, r111);
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r100 = ((com.bytedance.locallife.poi.newdetail.widget.contentplayer.i) ListProtector.get(r111, r110)).b();
            String r101 = null;
            if (r100 == null) goto L5;
            String r112 = r100.e();
        L6:
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r102 = ((com.bytedance.locallife.poi.newdetail.widget.contentplayer.i) ListProtector.get(r111, r110)).b();
            if (r102 == null) goto L9;
            r101 = r102.a();
        L9:
            String r113 = r101;
            JSONObject r103 = k();
            if (r113 == null) goto L12;
            boolean r114 = true;
        L13:
            PoiQuickPageBackgroundView.f0(this.f263089e, 1, "click_arrow", r103, 0, false, r114, PoiQuickPageBackgroundView.a0(this.f263089e), r113, r112, Boolean.TRUE, 15616);
            return;
        L12:
            r114 = false;
            goto L13
        L5:
            r112 = null;
            goto L6
        }
    }

    public static final class d<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiQuickPageBackgroundView f263090a;

        public d(PoiQuickPageBackgroundView r100) {
            this.f263090a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            JSONObject r111 = (JSONObject) r110;
            PoiQuickPageBackgroundView r100 = this.f263090a;
            PoiQuickPageBackgroundView.f0(r100, r100.S, "click_photo", null, 0, false, false, null, null, null, null, 32764);
        }
    }

    public static final class e<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiQuickPageBackgroundView f263091a;

        public e(PoiQuickPageBackgroundView r100) {
            this.f263091a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            String r111 = ((JSONObject) r110).optString("node_tag");
            u r100 = this.f263091a.getModel();
            if (r100 == null) goto L5;
            String r101 = r100.f258493b.f258222b;
        L7:
            if (Intrinsics.areEqual(r111, r101) == false) goto L10;
            PoiQuickPageBackgroundView r102 = this.f263091a;
            PoiQuickPageBackgroundView.f0(r102, r102.S, "click_photo", null, 0, false, false, null, null, null, null, 32764);
            return;
        L10:
            return;
        L5:
            r101 = null;
            goto L7
        }
    }

    public static final class f<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiQuickPageBackgroundView f263092a;

        public f(PoiQuickPageBackgroundView r100) {
            this.f263092a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.locallife.dito.data.t r101 = (com.bytedance.locallife.dito.data.t) r100;
            TripPoiHeadWidget r102 = this.f263092a.G;
            if (r102 == null) goto L5;
            r102.e();
        L5:
            PoiContentPlayerView r103 = this.f263092a.M;
            if (r103 == null) goto L9;
            r103.d();
            return;
        }
    }

    public static final class g<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiQuickPageBackgroundView f263093a;

        public g(PoiQuickPageBackgroundView r100) {
            this.f263093a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.locallife.dito.data.t r101 = (com.bytedance.locallife.dito.data.t) r100;
            TripPoiHeadWidget r102 = this.f263093a.G;
            if (r102 == null) goto L5;
            r102.d();
        L5:
            PoiContentPlayerView r103 = this.f263093a.M;
            if (r103 == null) goto L9;
            r103.c();
            return;
        }
    }

    public static final class h implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f263094a;

        public h(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f263094a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f263094a.invoke(r100);
        }
    }

    public static final class i implements com.bytedance.locallife.biz.utils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiQuickPageBackgroundView f263095a;

        public i(PoiQuickPageBackgroundView r100) {
            this.f263095a = r100;
        }

        @Override // com.bytedance.locallife.biz.utils.b
        public final void a(AccessibilityNodeInfoCompat r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            r100.setClassName(Button.class.getName());
            r100.setContentDescription(this.f263095a.getContext().getResources().getString(R.string.poi_detail_header));
        }
    }

    static {
    }

    @Override // at6.c
    public final void OZ() {
        Intrinsics.checkNotNullParameter(null, "event");
    }

    private final com.bytedance.locallife.poi.newdetail.widget.contentplayer.d getPoiContentPlayerCallback() {
        c r100 = new c(this);
        r100.f263129c = this.E;
        r100.f263127a = this.A;
        r100.f263128b = getDataCenter();
        return r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        super.P();
        PoiDetail r100 = this.f263087z;
        boolean r101 = false;
        if (r100 == null) goto L7;
        PoiServerAbmap r102 = r100.abMap;
        if (r102 == null) goto L7;
        int r103 = r102.getPoiDetailHeadOptV2();
    L8:
        this.O = r103;
        PoiDetail r104 = this.f263087z;
        if (r104 == null) goto L15;
        PoiServerAbmap r105 = r104.abMap;
        if (r105 == null) goto L15;
        if (r105.getHeaderPhotoStyle() != 1) goto L15;
        boolean r106 = true;
    L16:
        this.P = r106;
        int r107 = this.O;
        if (r107 > 1) goto L19;
        int r108 = 1;
    L22:
        this.R = r108;
        PoiDetail r109 = this.f263087z;
        if (r109 == null) goto L27;
        PoiServerAbmap r110 = r109.abMap;
        if (r110 == null) goto L27;
        int r111 = r110.getJumpAlbumPageMode();
    L28:
        this.S = r111;
        u r112 = getModel();
        if (r112 == null) goto L35;
        t r113 = r112.c();
        if (r113 == null) goto L35;
        if (r113.n() == true) goto L35;
        boolean r114 = true;
    L36:
        if (r114 == false) goto L39;
        this.N = false;
    L39:
        if (this.O != 4) goto L41;
        py6.a r115 = new qy6.a(this);
    L42:
        this.f263086y = r115;
        r115.a(getModel());
        com.bytedance.locallife.dito.data.u r116 = getDataCenter().v().getValue();
        if (r116 == null) goto L47;
        py6.a r117 = this.f263086y;
        if (r117 == null) goto L47;
        r117.c(r116);
    L47:
        PoiBundle r118 = this.A;
        String r119 = null;
        Integer r120 = null;
        r120 = null;
        if (r118 == null) goto L53;
        String r121 = r118.sessionId;
        if (r121 == null) goto L53;
        HostServiceUtilsKt.f0().c(r121, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("favourite_75_full_flag", "75"), TuplesKt.to("now_75_full_flag", "75")}), null);
    L53:
        if (this.N == true) goto L59;
        FrameLayout r122 = this.F;
        if (r122 == null) goto L251;
        r122.setVisibility(4);
        return;
    L251:
        return;
    L59:
        u r123 = getModel();
        if (r123 == null) goto L66;
        t r124 = r123.c();
        if (r124 == null) goto L66;
        if (r124.q() != true) goto L66;
        boolean r125 = true;
    L67:
        this.f263083h1 = r125;
        if (r125 == false) goto L146;
        PoiContentPlayerView r126 = this.M;
        if (r126 == null) goto L73;
        r126.setVisibility(0);
    L73:
        int r127 = (UIUtils.getScreenWidth(getContext()) / 2) - ((int) UIUtils.dip2Px(getContext(), 12.0f));
        AbstractInteractBehavior<? extends View> r128 = getDitoViewModel().f258035a.Da0();
        if ((r128 instanceof CustomBottomBehavior) == false) goto L76;
        CustomBottomBehavior r129 = (CustomBottomBehavior) r128;
    L77:
        if (r129 != null) goto L79;
        int r130 = r127;
        int r131 = 0;
    L92:
        PoiDetailBgView r132 = this.L;
        if (r132 == null) goto L96;
        r132.setVisibility(0);
    L96:
        PoiContentPlayerView r133 = this.M;
        if (r133 == null) goto L100;
        r133.setVisibility(0);
    L100:
        PoiContentPlayerView r134 = this.M;
        if (r134 == null) goto L132;
        u r135 = getModel();
        if (r135 == null) goto L108;
        t r136 = r135.c();
        if (r136 == null) goto L108;
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r137 = r136.b();
        if (r137 == null) goto L108;
    L109:
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r138 = r137;
        u r139 = getModel();
        if (r139 == null) goto L115;
        t r140 = r139.c();
        if (r140 == null) goto L115;
        List<AlbumTabListModel> r141 = r140.h();
        if (r141 == null) goto L115;
    L116:
        List<AlbumTabListModel> r142 = r141;
        PoiBundle r143 = this.A;
        if (r143 == null) goto L119;
        String r144 = r143.enterId;
    L120:
        if (r143 == null) goto L122;
        String r145 = r143.sessionId;
    L123:
        if (r145 != null) goto L125;
        r145 = "";
    L125:
        String r146 = r145;
        u r147 = getModel();
        if (r147 == null) goto L130;
        t r148 = r147.c();
        if (r148 == null) goto L130;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r149 = r148.c();
    L131:
        r134.h(this, true, r130, r131, r138, r142, r144, r146, r149, getPoiContentPlayerCallback());
    L130:
        r149 = null;
        goto L131
    L122:
        r145 = null;
        goto L123
    L119:
        r144 = null;
    L115:
        r141 = CollectionsKt.emptyList();
    L108:
        r137 = CollectionsKt.emptyList();
    L132:
        TripPoiHeadWidget r150 = this.G;
        if (r150 == null) goto L136;
        r150.setVisibility(8);
    L136:
        PoiSimpleLynxView r151 = this.H;
        if (r151 == null) goto L140;
        r151.setVisibility(8);
    L140:
        FrameLayout r152 = this.I;
        if (r152 == null) goto L144;
        r152.setVisibility(8);
    L144:
        this.f263081b1 = true;
        DitoDataCenter r153 = getDitoViewModel().f258041g;
        int r154 = DitoDataCenter.f258004d;
        r153.a0("poi_use_content_player", 1).setValue(new JSONObject());
        return;
    L79:
        if (g0() == false) goto L81;
        int r155 = r129.R;
    L82:
        boolean r156 = r129.V;
        r131 = -1;
        if (r156 == false) goto L85;
        int r157 = r129.U;
    L86:
        if (r157 <= 0) goto L89;
        if (r156 == false) goto L90;
        r131 = r129.U;
    L90:
        r130 = r155;
        goto L92
    L89:
        r131 = r155;
        goto L90
    L85:
        r157 = -1;
        goto L86
    L81:
        r155 = r129.f258397o;
        goto L82
    L76:
        r129 = null;
        goto L77
    L146:
        u r158 = getModel();
        if (r158 == null) goto L156;
        t r159 = r158.c();
        if (r159 == null) goto L156;
        Integer r160 = r159.p();
        if (r160 == null) goto L156;
        if (r160.intValue() != 1) goto L156;
        boolean r161 = true;
    L157:
        if (r161 == false) goto L241;
        PoiSimpleLynxView r162 = this.H;
        if (r162 == null) goto L162;
        r162.setVisibility(4);
    L162:
        FrameLayout r163 = this.I;
        if (r163 == null) goto L166;
        r163.setVisibility(4);
    L166:
        TripPoiHeadWidget r164 = this.G;
        if (r164 == null) goto L170;
        r164.setVisibility(0);
    L170:
        int r165 = (UIUtils.getScreenWidth(getContext()) / 2) - ((int) UIUtils.dip2Px(getContext(), 12.0f));
        AbstractInteractBehavior<? extends View> r166 = getDitoViewModel().f258035a.Da0();
        if ((r166 instanceof CustomBottomBehavior) == false) goto L173;
        CustomBottomBehavior r167 = (CustomBottomBehavior) r166;
    L174:
        if (r167 != null) goto L176;
    L179:
        int r168 = r165;
        PoiDetail r169 = this.f263087z;
        if (r169 == null) goto L184;
        PoiExtension r170 = r169.poiExtension;
        if (r170 == null) goto L184;
        List<PoiPhoto> r171 = r170.photos;
    L185:
        if (r169 == null) goto L189;
        PoiExtension r172 = r169.poiExtension;
        if (r172 == null) goto L189;
        int r173 = r172.picTotalCount;
    L190:
        if (r171 != null) goto L192;
    L196:
        TripPoiHeadWidget r174 = this.G;
        if (r174 == null) goto L203;
        PoiBundle r175 = this.A;
        if (r175 == null) goto L201;
        String r176 = r175.enterId;
    L202:
        r174.setPoiEnterId(r176);
        goto L203
    L201:
        r176 = null;
    L203:
        TripPoiHeadWidget r177 = this.G;
        if (r177 == null) goto L215;
        u r178 = getModel();
        if (r178 == null) goto L213;
        t r179 = r178.c();
        if (r179 == null) goto L213;
        Boolean r180 = r179.e();
        if (r180 == null) goto L213;
        boolean r181 = r180.booleanValue();
    L214:
        r177.setHeadImageTagOpt(r181);
    L213:
        r181 = false;
    L215:
        TripPoiHeadWidget r182 = this.G;
        if (r182 == null) goto L226;
        u r183 = getModel();
        if (r183 == null) goto L225;
        t r184 = r183.c();
        if (r184 == null) goto L225;
        Boolean r185 = r184.m();
        if (r185 == null) goto L225;
        r101 = r185.booleanValue();
    L225:
        r182.setShowAlbumText(r101);
    L226:
        TripPoiHeadWidget r186 = this.G;
        if (r186 == null) goto L240;
        Integer r187 = Integer.valueOf(r173);
        PoiDetail r188 = this.f263087z;
        if (r188 == null) goto L233;
        PoiExtension r189 = r188.poiExtension;
        if (r189 == null) goto L233;
        HeadVideoStrict r190 = r189.headVideo;
    L234:
        u r191 = getModel();
        if (r191 == null) goto L239;
        t r192 = r191.c();
        if (r192 == null) goto L239;
        r120 = r192.k();
    L239:
        Integer r210 = r120;
        n r193 = new n(this, r173);
        o r194 = new o(this, r173);
        PoiBundle r195 = this.A;
        int r196 = TripPoiHeadWidget.V0;
        r186.h(true, r168, 0, r171, r187, r190, r210, null, r193, r194, r195);
    L233:
        r190 = null;
    L240:
        this.f263081b1 = true;
    L249:
        setBackgroundCornerAccordingState(getDataCenter().S().getValue());
        return;
    L192:
        if ((!r171.isEmpty()) == false) goto L196;
        if (((PoiPhoto) ListProtector.get(r171, 0)).mediaType != 1) goto L196;
        this.E = true;
    L189:
        r173 = 0;
    L184:
        r171 = null;
        goto L185
    L176:
        if (g0() == false) goto L178;
        r165 = r167.R;
        goto L179
    L178:
        r165 = r167.f258397o;
        goto L179
    L173:
        r167 = null;
        goto L174
    L241:
        PoiDetail r197 = this.f263087z;
        if (r197 == null) goto L244;
        PoiExtension r198 = r197.poiExtension;
    L245:
        setHeadBgBanners(r198);
        int r199 = com.bytedance.locallife.poi.dito.util.g.f262556a;
        DitoViewModel r200 = getDitoViewModel();
        u r201 = getModel();
        if (r201 == null) goto L248;
        r119 = r201.f258493b.f258222b;
    L248:
        com.bytedance.locallife.poi.dito.util.g.a(r200, r119, new PoiQuickPageBackgroundView$onBindData$3(this));
        goto L249
    L244:
        r198 = null;
    L156:
        r161 = false;
    L66:
        r125 = false;
        goto L67
    L41:
        r115 = new PoiDefaultQuickBgController(this, this.N);
    L35:
        r114 = false;
    L27:
        r111 = 0;
        goto L28
    L19:
        if (r107 != 2) goto L21;
        r108 = 2;
        goto L22
    L21:
        r108 = 3;
    L15:
        r106 = false;
    L7:
        r103 = 0;
        goto L8
    }

    public final boolean g0() {
        u r100 = getModel();
        if (r100 == null) goto L7;
        t r101 = r100.c();
        if (r101 == null) goto L7;
        String r102 = r101.j();
    L9:
        return Intrinsics.areEqual(r102, "1");
    L7:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        com.bytedance.locallife.poi.newdetail.t.b(this);
        Object r100 = getDitoViewModel().A.get("inflater_manager");
        com.bytedance.locallife.poi.newdetail.e r101 = null;
        if ((r100 instanceof sy6.b) == false) goto L5;
        sy6.b r102 = (sy6.b) r100;
    L6:
        if (r102 == null) goto L8;
        View r103 = r102.a(getContext(), R.layout.saas_poi_detail_head_bg, this);
    L9:
        addView(r103);
        if (r103 == null) goto L12;
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.poi_detail_head_container);
    L13:
        this.F = r104;
        if (r103 == null) goto L16;
        PoiSimpleLynxView r105 = (PoiSimpleLynxView) r103.findViewById(R.id.poi_detail_lynx_head_image);
    L17:
        this.H = r105;
        if (r103 == null) goto L20;
        TripPoiHeadWidget r106 = (TripPoiHeadWidget) r103.findViewById(R.id.poi_quick_page_trip_head_image);
    L21:
        this.G = r106;
        if (r103 == null) goto L24;
        FrameLayout r107 = (FrameLayout) r103.findViewById(R.id.poi_detail_native_head_image);
    L25:
        this.I = r107;
        if (r103 == null) goto L28;
        SmartImageView r108 = (SmartImageView) r103.findViewById(R.id.poi_detail_head_image);
    L29:
        this.f263080J = r108;
        if (r103 == null) goto L32;
        HeaderImageMaskView r109 = (HeaderImageMaskView) r103.findViewById(R.id.poi_detail_head_mask);
    L33:
        this.K = r109;
        if (r103 == null) goto L36;
        PoiDetailBgView r110 = (PoiDetailBgView) r103.findViewById(R.id.poi_detail_content_bg);
    L37:
        this.L = r110;
        if (r103 == null) goto L40;
        PoiContentPlayerView r111 = (PoiContentPlayerView) r103.findViewById(R.id.poi_content_player_view);
    L41:
        this.M = r111;
        FrameLayout r112 = this.F;
        if (r112 == null) goto L45;
        r112.setVisibility(4);
    L45:
        Object r113 = getDitoViewModel().A.get("poi_bundle");
        if ((r113 instanceof PoiBundle) == false) goto L48;
        PoiBundle r114 = (PoiBundle) r113;
    L49:
        this.A = r114;
        Object r115 = getDitoViewModel().A.get("poi_detail");
        if ((r115 instanceof PoiDetail) == false) goto L52;
        PoiDetail r116 = (PoiDetail) r115;
    L53:
        this.f263087z = r116;
        Object r117 = getDitoViewModel().A.get("poi_detail_str");
        if ((r117 instanceof String) == false) goto L56;
        String r118 = (String) r117;
    L57:
        this.B = r118;
        Object r119 = getDitoViewModel().A.get("card_style");
        if ((r119 instanceof com.bytedance.locallife.poi.newdetail.e) == false) goto L60;
        r101 = (com.bytedance.locallife.poi.newdetail.e) r119;
    L60:
        PoiDetailBgView r120 = this.L;
        if (r120 == null) goto L71;
        if (r101 == null) goto L64;
        int r121 = r101.f263244c;
    L66:
        if (r120.f263306c == true) goto L71;
        r120.f263306c = true;
        if (r121 < 0) goto L70;
        r120.f263308e = (int) UIUtils.dip2Px(r120.getContext(), r121);
    L70:
        r120.invalidate();
        goto L71
    L64:
        r121 = 0;
    L71:
        vn6.b.b(this);
        getDataCenter().a0("click_header_image", 1).observe(this, new d(this));
        getDataCenter().a0("click_placeholder_trans", 1).observe(this, new e(this));
        getDataCenter().a0("poi_bottom_bar_service_button_info", 1).observe(this, this.P0);
        getDataCenter().n0().observe(this, new f(this));
        getDataCenter().m0().observe(this, new g(this));
        getDataCenter().v().observe(this, new r(this));
        getDataCenter().S().observe(this, new s(this));
        DitoDataCenter r122 = getDataCenter();
        int r123 = DitoDataCenter.f258004d;
        r122.a0("event_change_configuration", 1).observe(this, new q(this));
        this.H0 = new PoiQuickPageBackgroundView$registerConfigurationChange$2(this);
        this.V0.b(this);
        return;
    L56:
        r118 = null;
        goto L57
    L52:
        r116 = null;
        goto L53
    L48:
        r114 = null;
        goto L49
    L40:
        r111 = null;
        goto L41
    L36:
        r110 = null;
        goto L37
    L32:
        r109 = null;
        goto L33
    L28:
        r108 = null;
        goto L29
    L24:
        r107 = null;
        goto L25
    L20:
        r106 = null;
        goto L21
    L16:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onDestroy() {
        super.onDestroy();
        if (this.C == false) goto L7;
        PoiSimpleLynxView r100 = this.H;
        if (r100 == null) goto L7;
        r100.h();
    L7:
        vn6.b.c(this);
        this.V0.a(this);
    }

    public static final JSONObject a0(PoiQuickPageBackgroundView r100) {
        JSONObject r101 = r100.L0;
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        u r102 = r100.getModel();
        if (r102 == null) goto L16;
        t r103 = r102.c();
        if (r103 == null) goto L16;
        JsonObject r104 = r103.a();
        if (r104 == null) goto L16;
        Iterator<T> r105 = r104.entrySet().iterator();     // Catch: Exception -> L17
    L13:
        if (r105.hasNext() == false) goto L16;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Exception -> L17
        r101.put((String) r106.getKey(), tv5.a.c((JsonElement) r106.getValue()));     // Catch: Exception -> L17
    L16:
        return r101;
    }

    public static final void b0(PoiQuickPageBackgroundView r110) {
        u r100 = r110.getModel();
        PoiExtension r101 = null;
        com.bytedance.locallife.biz.widget.a r102 = null;
        if (r100 == null) goto L7;
        t r103 = r100.c();
        if (r103 == null) goto L7;
        String r104 = r103.g();
    L9:
        if (TextUtils.isEmpty(r104) == true) goto L48;
        r110.C = true;
        PoiSimpleLynxView r105 = r110.H;
        if (r105 == null) goto L14;
        r105.setVisibility(0);
    L14:
        FrameLayout r106 = r110.I;
        if (r106 == null) goto L18;
        r106.setVisibility(4);
    L18:
        TripPoiHeadWidget r107 = r110.G;
        if (r107 == null) goto L22;
        r107.setVisibility(4);
    L22:
        PoiSimpleLynxView r108 = r110.H;
        if (r108 == null) goto L25;
        r108.l(r110, true);
    L25:
        PoiSimpleLynxView r109 = r110.H;
        if (r109 == null) goto L67;
        u r111 = r110.getModel();
        String r112 = "";
        if (r111 == null) goto L35;
        t r113 = r111.c();
        if (r113 == null) goto L35;
        JsonObject r114 = r113.f();
        if (r114 == null) goto L35;
        String r115 = r114.toString();
        if (r115 == null) goto L35;
    L36:
        PoiBundle r116 = r110.A;
        if (r116 == null) goto L39;
        String r117 = r116.sessionId;
    L40:
        Pair[] r118 = new Pair[2];
        String r119 = r110.getDitoViewModel().f258060z.get("dito_trace_session_id");
        if (r119 == null) goto L44;
        r112 = r119;
    L44:
        r118[0] = TuplesKt.to(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, r112);
        r118[1] = TuplesKt.to("font_scale", String.valueOf(HostServiceUtilsKt.z().getCurrentFontScale()));
        Map r120 = MapsKt.mapOf(r118);
        py6.a r121 = r110.f263086y;
        if (r121 == null) goto L47;
        r102 = r121.b();
    L47:
        SimpleLynxView.b(r109, r104, r115, r117, r120, r102);
        return;
    L39:
        r117 = null;
    L35:
        r115 = "";
        goto L36
    L67:
        return;
    L48:
        PoiSimpleLynxView r122 = r110.H;
        if (r122 == null) goto L52;
        r122.setVisibility(4);
    L52:
        FrameLayout r123 = r110.I;
        if (r123 == null) goto L56;
        r123.setVisibility(0);
    L56:
        TripPoiHeadWidget r124 = r110.G;
        if (r124 == null) goto L60;
        r124.setVisibility(4);
    L60:
        PoiDetail r125 = r110.f263087z;
        if (r125 == null) goto L63;
        r101 = r125.poiExtension;
    L63:
        r110.setHeadBgBanners(r101);
        FrameLayout r126 = r110.F;
        if (r126 == null) goto L69;
        r126.setOnClickListener(new p(r126, r110));
        return;
    L69:
        return;
    L7:
        r104 = null;
        goto L9
    }

    private final void setBackgroundCornerAccordingState(Integer r100) {
        if (g0() == false) goto L32;
        u r101 = getModel();
        int r102 = 0;
        if (r101 == null) goto L9;
        t r103 = r101.c();
        if (r103 == null) goto L9;
        boolean r104 = Intrinsics.areEqual(r103.i(), Boolean.TRUE);
    L10:
        if (r104 == false) goto L33;
        if (r100 != null) goto L15;
    L16:
        if (r100 != null) goto L19;
    L21:
        int r105 = 20;
    L24:
        if (this.E == true) goto L28;
        r102 = r105;
    L28:
        if (this.f263082g1 != r102) goto L30;
        return;
    L30:
        this.f263082g1 = r102;
        setOutlineProvider(new cz6.a(em4.g.c(this.f263082g1)));
        setClipToOutline(true);
        DitoDataCenter r106 = getDitoViewModel().f258041g;
        int r107 = DitoDataCenter.f258004d;
        MutableLiveData<JSONObject> r108 = r106.a0("poi_container_corner", 1);
        JSONObject r109 = new JSONObject();
        r109.put("corner_dp", r102);
        r108.setValue(r109);
        invalidate();
        return;
    L19:
        if (r100.intValue() != 6) goto L21;
    L22:
        r105 = 0;
        goto L24
    L15:
        if (r100.intValue() == 7) goto L22;
    L33:
        return;
    L9:
        r104 = false;
        goto L10
    }

    private final void setHeadBgBanners(PoiExtension r100) {
        if (r100 == null) goto L4;
        List<PoiPhoto> r101 = r100.photos;
    L5:
        List<PoiPhoto> r102 = r101;
        boolean r103 = true;
        if (r102 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L27;
        rp6.a.b(this.f263080J, "https://lf3-static.bytednsdoc.com/obj/eden-cn/nulojubfbvs/native/header_bg_recommend_enhance_light.png", -1, -1);
        u r105 = getModel();
        if (r105 == null) goto L20;
        t r106 = r105.c();
        if (r106 == null) goto L20;
        if (r106.getType() != 0) goto L20;
    L21:
        if (r103 == false) goto L32;
        HeaderImageMaskView r107 = this.K;
        if (r107 == null) goto L33;
        r107.setVisibility(4);
        return;
    L33:
        return;
    L32:
        return;
    L20:
        r103 = false;
        goto L21
    L27:
        df6.u r108 = df6.q.c(new ef6.a(((PoiPhoto) ListProtector.get(r101, 0)).picMedium.getUrlList()));
        r108.f468277c = getContext();
        r108.b("poi_head_image");
        r108.f468294t = this.f263080J;
        r108.c();
        SmartImageView r109 = this.f263080J;
        i r110 = new i(this);
        if (r109 == null) goto L34;
        ViewCompat.setAccessibilityDelegate(r109, new com.bytedance.locallife.biz.utils.a(r110));
        return;
    L34:
        return;
    L8:
        if (r102.isEmpty() == true) goto L11;
        r104 = false;
        goto L12
    L4:
        r101 = null;
        goto L5
    }

    public final void k0(boolean r100) {
        this.T = r100;
        DitoDataCenter r101 = getDataCenter();
        int r102 = DitoDataCenter.f258004d;
        MutableLiveData<JSONObject> r103 = r101.a0("poiHeadShowPics", 1);
        JSONObject r104 = new JSONObject();
        r104.put("show_pics", r100);
        r103.setValue(r104);
    }

    public final void l0(int r100) {
        Integer r101 = getDataCenter().Q().getValue();
        if (r101 != null) goto L5;
        r101 = Integer.valueOf(com.bytedance.locallife.poi.newdetail.h.f263262a.b());
    L5:
        int r102 = r101.intValue();
        int r103 = r100 - this.f263084k0;
        this.f263084k0 = r100;
        Integer r104 = getDataCenter().P().getValue();
        if (r104 != null) goto L8;
        r104 = 0;
    L8:
        int r105 = r104.intValue();
        if (r105 > 0) goto L11;
        return;
    L11:
        if (r103 >= 0) goto L19;
        if (r100 >= r105) goto L19;
        if (this.T == true) goto L19;
        if (this.V != 4) goto L19;
        k0(true);
        return;
    L19:
        if (r103 <= 0) goto L27;
        if (r100 <= r102) goto L27;
        if (this.T == false) goto L27;
        int r106 = this.W;
        if (r106 == 2) goto L26;
        if (r106 != 3) goto L27;
    L26:
        k0(false);
        return;
    L27:
        if (r103 >= 0) goto L34;
        if (r100 >= r105) goto L34;
        if (this.T == true) goto L34;
        if (this.W != 3) goto L34;
        k0(true);
        return;
    L34:
        if (r100 < r102) goto L36;
        return;
    L36:
        if (this.T == true) goto L44;
        k0(true);
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiClickHeaderInfoEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        PoiBundle r100 = this.A;
        if (r100 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r110.f451330b, r100.sessionId) == false) goto L9;
        d0(r110.f451331c, "click_top_pic", r110.f451332d, r110.f451329a, false, r110.f451333e, r110.f451334f, r110.f451338j, r110.f451335g, r110.f451336h, r110.f451337i, r110.f451339k, r110.f451340l, r110.f451341m, r110.f451342n);
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiClickNaviBlankEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.A != null) goto L6;
        return;
    L6:
        throw null;
    }

    public static final /* synthetic */ void c0(PoiQuickPageBackgroundView r100, Integer r101) {
        r100.setBackgroundCornerAccordingState(r101);
    }

    @Override // at6.c
    public final void Pd(String r100, JSONObject r101) {
        at6.c.a.a(r100, r101);
    }

    public PoiQuickPageBackgroundView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.N = true;
        this.V = 5;
        this.W = 5;
        this.f263084k0 = 3000;
        this.P0 = new b(this);
        this.V0 = HostServiceUtilsKt.x();
    }

    public static /* synthetic */ void i0(PoiQuickPageBackgroundView r100, String r101, String r110, int r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r112 & 4) == 0) goto L8;
        String r102 = null;
    L10:
        if ((r112 & 16) == 0) goto L12;
        int r103 = 0;
    L13:
        r100.h0("poi_pic_operation", r101, r102, null, r103, 0, null);
        return;
    L12:
        r103 = r111;
        goto L13
    L8:
        r102 = r110;
        goto L10
    }

    public final void h0(String r110, String r111, String r112, PoiPhoto r113, int r114, int r115, Map<String, String> r116) {
        PoiBundle r100 = this.A;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.enterBy75Page != true) goto L7;
    L8:
        if (r101 == false) goto L10;
        String r102 = "75";
    L11:
        j0(r110, r102, r111, r112, r113, r114, r115, r116);
        return;
    L10:
        r102 = "full";
    L7:
        r101 = false;
        goto L8
    }

    public final void j0(String r100, String r101, String r102, String r110, PoiPhoto r111, int r112, int r113, Map<String, String> r114) {
        int r103 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r104 = new mq6.c();
        mq6.a r105 = mq6.c.a.f514894a;
        r104.g("enter_from", "poi_page");
        PoiBundle r106 = this.A;
        String r107 = null;
        if (r106 == null) goto L5;
        String r108 = r106.backendType;
    L6:
        r104.g("poi_backend_type", r108);
        PoiBundle r109 = this.A;
        if (r109 == null) goto L9;
        String r115 = r109.poiId;
    L10:
        r104.g("poi_id", r115);
        kt6.f r116 = HostServiceUtilsKt.s();
        PoiBundle r117 = this.A;
        if (r117 == null) goto L13;
        String r118 = r117.cityCode;
    L14:
        boolean r119 = r116.b(r118);
        String r120 = "1";
        if (r119 == false) goto L17;
        String r121 = "1";
    L18:
        r104.g("poi_device_samecity", r121);
        PoiBundle r122 = this.A;
        if (r122 == null) goto L21;
        String r123 = r122.enterId;
    L22:
        r104.g("poi_enter_id", r123);
        r104.g("enter_method", r102);
        PoiBundle r124 = this.A;
        if (r124 == null) goto L25;
        String r125 = r124.enterMethod;
    L26:
        r104.g(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r125);
        r104.g("section_type", r110);
        if (r111 == null) goto L29;
        String r126 = r111.tabName;
    L30:
        r104.g(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r126);
        PoiBundle r127 = this.A;
        if (r127 == null) goto L33;
        String r128 = r127.from;
    L34:
        r104.g("poi_enter_page", r128);
        r104.a("poi_pic_mode", this.R);
        r104.g("75_full_flag", r101);
        if (r111 == null) goto L38;
        Float r129 = r111.picScore;
        if (r129 == null) goto L38;
    L39:
        r104.g("pic_score", String.valueOf(r129.floatValue()));
        Object r130 = "";
        if (r111 == null) goto L43;
        String r131 = r111.picSource;
        if (r131 == null) goto L43;
    L44:
        r104.g("pic_source", r131);
        r104.g("pic_cnt", String.valueOf(r112));
        r104.g("pic_location", String.valueOf(r113));
        PoiDetail r132 = this.f263087z;
        if (r132 == null) goto L54;
        PoiExtension r133 = r132.poiExtension;
        if (r133 == null) goto L54;
        HeadVideoStrict r134 = r133.headVideo;
        if (r134 == null) goto L54;
        Integer r135 = r134.getUserCnt();
        if (r135 == null) goto L54;
        String r136 = r135.toString();
        if (r136 == null) goto L54;
    L55:
        r104.g("check_in_nums", r136);
        PoiDetail r137 = this.f263087z;
        if (r137 == null) goto L62;
        PoiExtension r138 = r137.poiExtension;
        if (r138 == null) goto L62;
        HeadVideoStrict r139 = r138.headVideo;
        if (r139 == null) goto L62;
        String r140 = r139.getEntryDesc();
    L63:
        if (r140 != null) goto L65;
    L68:
        boolean r141 = true;
    L69:
        if (r141 == false) goto L71;
        r120 = "0";
    L71:
        r104.g("is_check_in_video", r120);
        if (r114 == null) goto L79;
        Set<Map.Entry<String, String>> r142 = r114.entrySet();
        if (r142 == null) goto L79;
        Iterator<T> r143 = r142.iterator();
    L77:
        if (r143.hasNext() == false) goto L79;
        Map.Entry r144 = (Map.Entry) r143.next();
        r104.d((String) r144.getKey(), (String) r144.getValue());
    L79:
        r104.d("product_id", "");
        if (r111 == null) goto L86;
        PoiImageUrlModel r145 = r111.picMedium;
        if (r145 == null) goto L86;
        List<String> r146 = r145.getUrlList();
        if (r146 == null) goto L86;
        r107 = (String) CollectionsKt.firstOrNull(r146);
    L86:
        r104.d("uri", r107);
        r104.d("module_location", "top_collection");
        FrameLayout r147 = this.I;
        if (r147 == null) goto L89;
        Object r148 = Integer.valueOf(r147.getHeight());
    L90:
        r104.c("pic_length", r148);
        FrameLayout r149 = this.I;
        if (r149 == null) goto L93;
        r130 = Integer.valueOf(r149.getWidth());
    L93:
        r104.c("pic_width", r130);
        Unit r150 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c(r100, r104.f514893a);
        return;
    L89:
        r148 = "";
        goto L90
    L65:
        if (r140.length() == 0) goto L68;
        r141 = false;
    L62:
        r140 = null;
    L54:
        r136 = "";
    L43:
        r131 = "";
    L38:
        r129 = Float.valueOf(0.0f);
        goto L39
    L33:
        r128 = null;
        goto L34
    L29:
        r126 = null;
        goto L30
    L25:
        r125 = null;
        goto L26
    L21:
        r123 = null;
        goto L22
    L17:
        r121 = "0";
        goto L18
    L13:
        r118 = null;
        goto L14
    L9:
        r115 = null;
        goto L10
    L5:
        r108 = null;
        goto L6
    }

    public static /* synthetic */ void f0(PoiQuickPageBackgroundView r110, int r210, String r211, JSONObject r212, int r213, boolean r214, boolean r215, JSONObject r216, String r217, String r218, Boolean r219, int r310) {
        Boolean r100 = null;
        if ((r310 & 4) == 0) goto L5;
        JSONObject r101 = null;
    L7:
        if ((r310 & 8) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r310 & 16) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r310 & 32) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r310 & 64) == 0) goto L21;
        JSONObject r111 = null;
    L23:
        if ((r310 & 128) == 0) goto L25;
        String r112 = null;
    L27:
        if ((r310 & 256) == 0) goto L29;
        Boolean r113 = Boolean.FALSE;
    L31:
        if ((r310 & 512) == 0) goto L33;
        String r114 = "photo";
    L35:
        if ((r310 & 1024) == 0) goto L37;
        Boolean r115 = Boolean.FALSE;
    L39:
        if ((r310 & 4096) == 0) goto L41;
        Boolean r116 = Boolean.FALSE;
    L43:
        if ((r310 & 8192) == 0) goto L45;
        r100 = Boolean.FALSE;
    L45:
        Boolean r117 = r100;
        if ((r310 & 16384) == 0) goto L48;
        Boolean r118 = Boolean.FALSE;
    L49:
        r110.d0(r210, r211, r101, r102, r103, r104, r111, r112, r113, r114, r115, null, r116, r117, r118);
        return;
    L48:
        r118 = r219;
        goto L49
    L41:
        r116 = null;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r114 = r218;
        goto L35
    L29:
        r113 = null;
        goto L31
    L25:
        r112 = r217;
        goto L27
    L21:
        r111 = r216;
        goto L23
    L17:
        r104 = r215;
        goto L19
    L13:
        r103 = r214;
        goto L15
    L9:
        r102 = r213;
        goto L11
    L5:
        r101 = r212;
        goto L7
    }

    public final void d0(int r210, String r211, JSONObject r212, int r213, boolean r214, boolean r215, JSONObject r216, String r217, Boolean r218, String r219, Boolean r310, List<AlbumTabListModel> r311, Boolean r312, Boolean r313, Boolean r314) {
        boolean r100 = HostServiceUtilsKt.y0();
        boolean r101 = HostServiceUtilsKt.h().b(AbilityEnum.ALBUM_SERVICE);
        if (r100 == false) goto L6;
        if (r101 == true) goto L6;
        return;
    L6:
        String r102 = null;
        if (r311 != null) goto L14;
        u r103 = getModel();
        if (r103 == null) goto L13;
        t r104 = r103.c();
        if (r104 == null) goto L13;
        List<AlbumTabListModel> r110 = r104.h();
    L15:
        PoiBundle r105 = this.A;
        if (r105 != null) goto L18;
        return;
    L18:
        HashMap<String, String> r106 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("75_full_flag", "75"), TuplesKt.to("enter_from", "poi_page"), TuplesKt.to("enter_method", r211), TuplesKt.to("poi_pic_mode", String.valueOf(this.R))});
        if (r212 == null) goto L27;
        Iterator<String> r107 = r212.keys();
        if (r107 == null) goto L27;
    L23:
        if (r107.hasNext() == false) goto L27;
        String r108 = r107.next();
        String r109 = r212.optString(r108);
        if (com.bytedance.locallife.dito.utils.j.i(r109) == false) goto L23;
        r106.put(r108, r109);
    L27:
        com.bytedance.locallife.host.photo.b r111 = HostServiceUtilsKt.W();
        String r112 = this.B;
        if (r216 == null) goto L30;
        r102 = r216.toString();
    L30:
        String r113 = r102;
        u r114 = getModel();
        if (r114 == null) goto L37;
        t r115 = r114.c();
        if (r115 == null) goto L37;
        Boolean r116 = r115.o();
        if (r116 == null) goto L37;
        boolean r117 = r116.booleanValue();
    L38:
        if (r117 == true) goto L45;
        if (r310 == null) goto L41;
        boolean r118 = r310.booleanValue();
    L42:
        if (r118 == true) goto L45;
        boolean r119 = false;
    L46:
        if (r218 == null) goto L48;
        boolean r120 = r218.booleanValue();
    L49:
        if (r219 != null) goto L51;
        String r121 = "photo";
    L52:
        r111.O(this, r105, r112, r210, r213, r214, r106, r215, r113, r217, r119, r120, r121, r110, r312, r313, r314, null);
        return;
    L51:
        r121 = r219;
        goto L52
    L48:
        r120 = false;
        goto L49
    L41:
        r118 = false;
    L45:
        r119 = true;
    L37:
        r117 = false;
    L13:
        r110 = null;
        goto L15
    L14:
        r110 = r311;
        goto L15
    }
}
