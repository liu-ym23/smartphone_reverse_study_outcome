package com.bytedance.locallife.poi.newdetail.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.mob.EventType;
import com.bytedance.locallife.biz.widget.SimpleLynxView;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.bytedance.locallife.model.poi.resp.PoiDistanceModel;
import com.bytedance.locallife.model.poi.resp.PoiExtension;
import com.bytedance.locallife.model.poi.resp.PoiServerAbmap;
import com.bytedance.locallife.model.poi.resp.PoiStruct;
import com.bytedance.locallife.model.poi.resp.ShareInfo;
import com.bytedance.locallife.poi.newdetail.widget.lynx.PoiSimpleLynxView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.event.PoiNavBackClickEvent;
import com.ss.android.ugc.aweme.poi.event.PoiNaviMoreEvent;
import com.ss.android.ugc.aweme.poi.event.PoiNaviShareEvent;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB%\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000bH\u0007R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiQuickPageNavigationBar;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/poi/newdetail/component/v;", "", "isBlack", "", "setHeaderIconColor", "Lcom/ss/android/ugc/aweme/poi/event/PoiNaviShareEvent;", "event", "onEvent", "Lcom/ss/android/ugc/aweme/poi/event/PoiNaviMoreEvent;", "Lcom/ss/android/ugc/aweme/poi/event/PoiNavBackClickEvent;", "onBackBtnClickEvent", "", ExifInterface.LONGITUDE_WEST, "Ljava/lang/String;", "getPageLayoutStyle", "()Ljava/lang/String;", "setPageLayoutStyle", "(Ljava/lang/String;)V", "pageLayoutStyle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiQuickPageNavigationBar extends BaseDitoView<v> {
    public static final /* synthetic */ int H0 = 0;
    public PoiDetail A;
    public PoiBundle B;
    public String C;
    public View D;
    public boolean E;
    public View F;
    public View G;
    public AppCompatImageView H;
    public PoiSimpleLynxView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public FrameLayout f263096J;
    public boolean K;
    public boolean L;
    public int M;
    public boolean N;
    public Boolean O;
    public boolean P;
    public int Q;
    public int R;
    public Function1<? super Integer, Unit> S;
    public boolean T;
    public boolean U;
    public int V;
    public String W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f263097k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f263098p0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public py6.a f263099y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f263100z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f263101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiQuickPageNavigationBar f263102b;

        public b(AppCompatImageView r100, PoiQuickPageNavigationBar r101) {
            this.f263101a = r100;
            this.f263102b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.locallife.common.utils.g.a(this.f263101a) == false) goto L5;
            return;
        L5:
            this.f263102b.getDataCenter().f().setValue(Boolean.TRUE);
        }
    }

    public static final class c implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f263103a;

        public c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f263103a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f263103a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        int r100 = com.bytedance.locallife.poi.dito.util.g.f262556a;
        DitoViewModel r101 = getDitoViewModel();
        v r102 = getModel();
        if (r102 == null) goto L5;
        String r103 = r102.f258493b.f258222b;
    L6:
        com.bytedance.locallife.poi.dito.util.g.a(r101, r103, new PoiQuickPageNavigationBar$onBindData$1(this));
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void d0() {
        View r100 = this.F;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
    L6:
        FrameLayout r101 = this.f263096J;
        if (r101 == null) goto L9;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L10:
        if (r102 != null) goto L12;
    L18:
        this.U = true;
        return;
    L12:
        if (this.V != 0) goto L14;
        this.V = r102.height + this.f263100z;
    L14:
        r102.height = this.V;
        FrameLayout r103 = this.f263096J;
        if (r103 == null) goto L18;
        r103.setLayoutParams(r102);
        goto L18
    L9:
        r102 = null;
        goto L10
    }

    public final void f0() {
        int r100 = (int) UIUtils.dip2Px(getContext(), 6.0f);
        AppCompatImageView r101 = this.H;
        if (r101 == null) goto L5;
        r101.setPadding(r100, r100, r100, r100);
    L5:
        AppCompatImageView r102 = this.H;
        if (r102 == null) goto L10;
        r102.setBackground(b0(this));
        return;
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        com.bytedance.locallife.poi.newdetail.h.f263262a.j();
        Object r100 = getDitoViewModel().A.get("poi_bundle");
        ViewGroup.LayoutParams r101 = null;
        if ((r100 instanceof PoiBundle) == false) goto L5;
        PoiBundle r102 = (PoiBundle) r100;
    L6:
        this.B = r102;
        Schedulers.computation().scheduleDirect(new w(r102));
        Object r103 = getDitoViewModel().A.get("poi_detail");
        if ((r103 instanceof PoiDetail) == false) goto L9;
        PoiDetail r104 = (PoiDetail) r103;
    L10:
        this.A = r104;
        Object r105 = getDitoViewModel().A.get("poi_detail_str");
        if ((r105 instanceof String) == false) goto L13;
        String r106 = (String) r105;
    L14:
        this.C = r106;
        Object r107 = getDitoViewModel().A.get("inflater_manager");
        if ((r107 instanceof sy6.b) == false) goto L17;
        sy6.b r108 = (sy6.b) r107;
    L18:
        if (r108 == null) goto L20;
        View r109 = r108.a(getContext(), R.layout.saas_poi_detail_new_page_header, this);
    L22:
        if (getDitoViewModel().B.containsKey("poi_status_bar_transparent") == false) goto L24;
        this.f263097k0 = Intrinsics.areEqual(getDitoViewModel().B.get("poi_status_bar_transparent"), "1");
    L24:
        if (r109 == null) goto L26;
        View r110 = r109.findViewById(R.id.poi_header_share_stub);
    L27:
        this.D = r110;
        if (r109 == null) goto L30;
        View r111 = r109.findViewById(R.id.poi_header_status_bar);
    L31:
        this.F = r111;
        if (r109 == null) goto L34;
        View r112 = r109.findViewById(R.id.poi_header_bar_bg);
    L35:
        this.G = r112;
        if (r109 == null) goto L38;
        AppCompatImageView r113 = (AppCompatImageView) r109.findViewById(R.id.poi_quick_navigation_back);
    L39:
        this.H = r113;
        if (r109 == null) goto L42;
        PoiSimpleLynxView r114 = (PoiSimpleLynxView) r109.findViewById(R.id.poi_quick_navigation_lynx);
    L43:
        this.I = r114;
        if (r109 == null) goto L46;
        FrameLayout r115 = (FrameLayout) r109.findViewById(R.id.nav_title_bar);
    L47:
        this.f263096J = r115;
        AppCompatImageView r116 = this.H;
        if (r116 == null) goto L50;
        r116.setOnClickListener(new b(r116, this));
    L50:
        Object r117 = getDitoViewModel().A.get("skin_style");
        if ((r117 instanceof com.bytedance.locallife.poi.newdetail.k) == false) goto L53;
        com.bytedance.locallife.poi.newdetail.k r118 = (com.bytedance.locallife.poi.newdetail.k) r117;
    L54:
        if (r118 == null) goto L58;
        com.bytedance.locallife.poi.newdetail.c r119 = r118.f263276c;
        if (r119 == null) goto L58;
        String r120 = r119.a();
    L60:
        if (TextUtils.isEmpty(r120) == false) goto L62;
        int r121 = ContextCompat.getColor(getContext(), R.color.POIBgPrimary);
    L69:
        View r122 = this.F;
        if (r122 == null) goto L72;
        r122.setBackgroundColor(r121);
    L72:
        View r123 = this.G;
        if (r123 == null) goto L75;
        r123.setBackgroundColor(r121);
    L75:
        View r124 = this.F;
        if (r124 == null) goto L78;
        r101 = r124.getLayoutParams();
    L78:
        if (r101 == null) goto L83;
        r101.height = this.f263100z;
        View r125 = this.F;
        if (r125 == null) goto L83;
        r125.setLayoutParams(r101);
    L83:
        addView(r109);
        setVisibility(4);
        getDataCenter().v().observe(this, new x(this));
        getDataCenter().T().observe(this, new y(this));
        getDataCenter().S().observe(this, new z(this));
        getDataCenter().a0("event_change_configuration", 1).observe(this, new a0(this));
        getDitoViewModel().f258041g.a0("poi_container_corner", 1).observe(this, new b0(this));
        this.S = new PoiQuickPageNavigationBar$observePageInteract$6(this);
        vn6.b.b(this);
        return;
    L62:
        int r126 = com.bytedance.locallife.poi.dito.util.a.f262546a;
        if (r118 == null) goto L67;
        com.bytedance.locallife.poi.newdetail.c r127 = r118.f263276c;
        if (r127 == null) goto L67;
        String r128 = r127.a();
    L68:
        r121 = com.bytedance.locallife.poi.dito.util.a.a(r128);
    L67:
        r128 = null;
    L58:
        r120 = null;
        goto L60
    L53:
        r118 = null;
        goto L54
    L46:
        r115 = null;
        goto L47
    L42:
        r114 = null;
        goto L43
    L38:
        r113 = null;
        goto L39
    L34:
        r112 = null;
        goto L35
    L30:
        r111 = null;
        goto L31
    L26:
        r110 = null;
        goto L27
    L20:
        r109 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onDestroy() {
        super.onDestroy();
        PoiSimpleLynxView r100 = this.I;
        if (r100 == null) goto L6;
        r100.h();
    L6:
        if (getDitoViewModel().B.containsKey("poi_exit_dark_status_bar") == true) goto L8;
    L13:
        vn6.b.c(this);
        return;
    L8:
        if (Intrinsics.areEqual(getDitoViewModel().B.get("poi_exit_dark_status_bar"), "0") == false) goto L11;
        j0(false, true);
        goto L13
    L11:
        if (Intrinsics.areEqual(getDitoViewModel().B.get("poi_exit_dark_status_bar"), "1") == false) goto L13;
        j0(true, true);
        goto L13
    }

    public final String getPageLayoutStyle() {
        return this.W;
    }

    public static final void a0(PoiQuickPageNavigationBar r110) {
        super.P();
        if (r110.f263098p0 == true) goto L189;
        PoiDetail r100 = r110.A;
        boolean r101 = false;
        if (r100 == null) goto L10;
        PoiServerAbmap r102 = r100.abMap;
        if (r102 == null) goto L10;
        int r103 = r102.getPoiDetailHeadOptV2();
    L11:
        r110.M = r103;
        v r104 = r110.getModel();
        String r105 = null;
        if (r104 == null) goto L16;
        ry6.c r106 = r104.c();
        if (r106 == null) goto L16;
        PoiDistanceModel r107 = r106.f();
    L17:
        if (r107 == null) goto L20;
        py6.a r108 = new com.bytedance.locallife.poi.newdetail.category.defaults.a(r110);
    L23:
        r110.f263099y = r108;
        r108.a(r110.getModel());
        com.bytedance.locallife.dito.data.u r109 = r110.getDataCenter().v().getValue();
        if (r109 == null) goto L185;
        py6.a r111 = r110.f263099y;
        if (r111 == null) goto L185;
        r111.c(r109);
    L185:
        v r112 = r110.getModel();     // Catch: Exception -> L40
        if (r112 == null) goto L38;
        ry6.c r113 = r112.c();     // Catch: Exception -> L40
        if (r113 == null) goto L38;
        JsonObject r114 = r113.a();     // Catch: Exception -> L40
        if (r114 == null) goto L38;
        JsonElement r115 = r114.get(SendClosePdpEventParam.KEY_LYNX_URL);     // Catch: Exception -> L40
        if (r115 == null) goto L38;
        String r116 = r115.getAsString();     // Catch: Exception -> L40
    L39:
        String r117 = r116;
    L42:
        int r118 = r110.M;
        if (r118 == 0) goto L45;
        if (r118 == 1) goto L45;
    L63:
        PoiSimpleLynxView r119 = r110.I;
        if (r119 == null) goto L66;
        r119.l(r110, true);
    L66:
        PoiSimpleLynxView r120 = r110.I;
        String r121 = "";
        if (r120 == null) goto L88;
        v r122 = r110.getModel();
        if (r122 == null) goto L75;
        ry6.c r123 = r122.c();
        if (r123 == null) goto L75;
        JsonObject r124 = r123.a();
        if (r124 == null) goto L75;
        String r125 = r124.toString();
    L76:
        PoiBundle r126 = r110.B;
        if (r126 == null) goto L79;
        String r127 = r126.sessionId;
    L80:
        Pair[] r128 = new Pair[2];
        String r129 = r110.getDitoViewModel().f258060z.get("dito_trace_session_id");
        if (r129 != null) goto L83;
        r129 = "";
    L83:
        r128[0] = TuplesKt.to(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, r129);
        r128[1] = TuplesKt.to("font_scale", String.valueOf(HostServiceUtilsKt.z().getCurrentFontScale()));
        Map r130 = MapsKt.mapOf(r128);
        py6.a r131 = r110.f263099y;
        if (r131 == null) goto L86;
        com.bytedance.locallife.biz.widget.a r132 = r131.b();
    L87:
        SimpleLynxView.b(r120, r117, r125, r127, r130, r132);
        goto L88
    L86:
        r132 = null;
        goto L87
    L79:
        r127 = null;
    L75:
        r125 = null;
    L88:
        v r133 = r110.getModel();
        if (r133 == null) goto L93;
        ry6.c r134 = r133.c();
        if (r134 == null) goto L93;
        JsonObject r135 = r134.a();
    L95:
        if (r135 == null) goto L97;
        JsonElement r136 = r135.get("should_hide_native_back_btn");
    L99:
        if (r110.i0(r136) == false) goto L104;
        AppCompatImageView r137 = r110.H;
        if (r137 == null) goto L104;
        r137.setVisibility(8);
    L104:
        if (r135 == null) goto L106;
        JsonElement r138 = r135.get("should_hide_status_bar");
    L108:
        if (r110.i0(r138) == false) goto L111;
        r110.d0();
    L111:
        if (r135 != null) goto L113;
    L115:
        boolean r139 = false;
    L116:
        if (r139 == false) goto L139;
        boolean r140 = r110.i0(r135.get("enable_alpha_change"));
        r110.T = r140;
        if (r140 == true) goto L139;
        if (r110.U == true) goto L129;
        View r141 = r110.F;
        if (r141 == null) goto L125;
        r141.setVisibility(0);
    L125:
        View r142 = r110.F;
        if (r142 == null) goto L129;
        r142.setAlpha(1.0f);
    L129:
        View r143 = r110.G;
        if (r143 == null) goto L133;
        r143.setVisibility(0);
    L133:
        View r144 = r110.G;
        if (r144 == null) goto L137;
        r144.setAlpha(1.0f);
    L137:
        r110.setVisibility(0);
        r110.setAlpha(1.0f);
    L139:
        if (r135 != null) goto L141;
    L143:
        boolean r145 = false;
    L144:
        if (r145 == false) goto L170;
        Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L159
        JsonElement r147 = r135.get("background_color");     // Catch: Throwable -> L159
        if (r147 == null) goto L149;
        r105 = r147.getAsString();     // Catch: Throwable -> L159
    L149:
        if (r105 != null) goto L151;
    L153:
        boolean r148 = false;
    L154:
        if (r148 == false) goto L156;
        int r149 = Color.parseColor("#" + r105.subSequence(7, 9) + r105.subSequence(1, 7));     // Catch: Throwable -> L159
    L157:
        Object r150 = Result.m9449constructorimpl(Integer.valueOf(r149));     // Catch: Throwable -> L159
    L162:
        if (Result.m9456isSuccessimpl(r150) == false) goto L170;
        int r151 = ((Number) r150).intValue();
        View r152 = r110.F;
        if (r152 == null) goto L166;
        r152.setBackgroundColor(r151);
    L166:
        View r153 = r110.G;
        if (r153 == null) goto L170;
        r153.setBackgroundColor(r151);
        goto L170
    L156:
        r149 = Color.parseColor(r105);     // Catch: Throwable -> L159
        goto L157
    L151:
        if (r105.length() != 9) goto L153;
        r148 = true;
    L159:
        th = move-exception;
        Result.Companion r154 = Result.Companion;
        r150 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L170:
        if (r135 != null) goto L172;
    L174:
        if (r101 == false) goto L183;
        JsonElement r155 = r135.get("poi_page_layout_style");
        if (r155 == null) goto L181;
        if (r155.isJsonPrimitive() == false) goto L181;
        r121 = r155.getAsString();
    L181:
        if (Intrinsics.areEqual(r121, "1") == false) goto L183;
        r110.W = "1";
        r110.d0();
        r110.setTranslationY(-r110.f263100z);
    L183:
        r110.f263098p0 = true;
        return;
    L172:
        if (r135.has("poi_page_layout_style") != true) goto L174;
        r101 = true;
        goto L174
    L141:
        if (r135.has("background_color") != true) goto L143;
        r145 = true;
        goto L144
    L113:
        if (r135.has("enable_alpha_change") != true) goto L115;
        r139 = true;
        goto L116
    L106:
        r138 = null;
        goto L108
    L97:
        r136 = null;
    L93:
        r135 = null;
    L45:
        PoiDetail r156 = r110.A;
        if (r156 == null) goto L48;
        PoiExtension r157 = r156.poiExtension;
    L49:
        if (r157 == null) goto L63;
        List<PoiPhoto> r158 = r157.photos;
        if (r158 != null) goto L53;
    L56:
        boolean r159 = true;
    L57:
        if (r159 == false) goto L63;
        int r160 = r110.M;
        if (r160 != 0) goto L61;
        r110.K = true;
        r110.L = true;
        r110.setHeaderIconColor(true);
        r110.j0(true, false);
        goto L63
    L61:
        if (r160 != 1) goto L63;
        r110.K = true;
        r110.j0(true, false);
        goto L63
    L53:
        if (r158.isEmpty() == true) goto L56;
        r159 = false;
        goto L57
    L48:
        r157 = null;
    L38:
        r116 = null;
    L40:
        e = move-exception;
        HostServiceUtilsKt.c().a(e);
        r117 = null;
        goto L42
    L20:
        if (r110.M != 4) goto L22;
        r108 = new qy6.b(r110);
        goto L23
    L22:
        r108 = new com.bytedance.locallife.poi.newdetail.category.defaults.a(r110);
    L16:
        r107 = null;
    L10:
        r103 = 0;
        goto L11
    }

    public static Drawable b0(final PoiQuickPageNavigationBar r100) {
        final com.bytedance.locallife.dito.utils.w.a r101 = com.bytedance.locallife.dito.utils.w.a.f258724b;
        r100.getClass();
        final float r102 = 0.0f;
        final int r103 = R.color.SDSecondary;
        return com.bytedance.locallife.dito.utils.o.a(new PoiQuickPageNavigationBar$getRoundBgDrawable$1(r101, r102, r100, r103));
    }

    public final void c0(float r100) {
        if (this.T == true) goto L6;
        return;
    L6:
        if (r100 != 0.0f) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L21;
        if (this.U == true) goto L16;
        View r102 = this.F;
        if (r102 == null) goto L16;
        r102.setVisibility(4);
    L16:
        View r103 = this.G;
        if (r103 == null) goto L39;
        r103.setVisibility(4);
    L39:
        if (this.M == 3) goto L42;
        com.bytedance.locallife.dito.common.view.a.a(this, r100);
        return;
    L42:
        return;
    L21:
        if (this.U == true) goto L30;
        View r104 = this.F;
        if (r104 == null) goto L26;
        r104.setVisibility(0);
    L26:
        View r105 = this.F;
        if (r105 == null) goto L30;
        r105.setAlpha(r100);
    L30:
        View r106 = this.G;
        if (r106 == null) goto L34;
        r106.setVisibility(0);
    L34:
        View r107 = this.G;
        if (r107 == null) goto L39;
        r107.setAlpha(r100);
        goto L39
    L8:
        r101 = false;
        goto L9
    }

    public final void g0(boolean r100) {
        if (r100 == true) goto L4;
    L13:
        if (r100 == false) goto L15;
        return;
    L15:
        if (this.E == false) goto L27;
        int r101 = (int) UIUtils.dip2Px(getContext(), 6.0f);
        AppCompatImageView r102 = this.H;
        if (r102 == null) goto L19;
        r102.setPadding(r101, r101, r101, r101);
    L19:
        AppCompatImageView r103 = this.H;
        if (r103 == null) goto L23;
        r103.setBackground(b0(this));
    L23:
        this.E = !this.E;
        return;
    L27:
        return;
    L4:
        if (this.E == true) goto L13;
        int r104 = (int) UIUtils.dip2Px(getContext(), 4.0f);
        AppCompatImageView r105 = this.H;
        if (r105 == null) goto L8;
        r105.setPadding(r104, r104, r104, r104);
    L8:
        AppCompatImageView r106 = this.H;
        if (r106 == null) goto L12;
        r106.setBackground(null);
    L12:
        this.E = !this.E;
    }

    public final void h0(float r100) {
        if (this.T == true) goto L6;
        return;
    L6:
        if (r100 != 0.0f) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        setVisibility(4);
        return;
    L11:
        setVisibility(0);
        setAlpha(r100);
        return;
    L8:
        r101 = false;
        goto L9
    }

    public final boolean i0(JsonElement r100) {
        if (r100 == null) goto L13;
        if (r100.isJsonPrimitive() == false) goto L14;
        if (r100.getAsBoolean() == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    L13:
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onBackBtnClickEvent(PoiNavBackClickEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        PoiBundle r101 = this.B;
        if (r101 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r100.f451344a, r101.sessionId) == true) goto L8;
        return;
    L8:
        getDataCenter().f().setValue(Boolean.TRUE);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiNaviShareEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        String r111 = r110.f451345a;
        PoiBundle r100 = this.B;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.sessionId;
    L7:
        if (TextUtils.equals(r111, r102) == false) goto L127;
        Activity r112 = com.bytedance.locallife.poi.newdetail.t.a(this);
        PoiDetail r103 = this.A;
        if (r103 == null) goto L11;
        PoiStruct r104 = r103.poiStruct;
    L13:
        if (r104 == null) goto L103;
        if (r112 == null) goto L103;
        String r105 = this.C;
        if (r105 == null) goto L19;
        HostServiceUtilsKt.h0().c(r112, r105, this.B);
    L19:
        int r113 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r114 = new mq6.c();
        mq6.a r106 = mq6.c.a.f514894a;
        r114.g("label", "poi_page");
        PoiBundle r107 = this.B;
        if (r107 == null) goto L22;
        String r108 = r107.poiId;
    L23:
        r114.g("poi_id", r108);
        com.bytedance.locallife.biz.mob.a.C3646a.c("click_share_button", r114.f514893a);
        int r115 = com.bytedance.locallife.biz.btm.b.f256555a;
        mq6.c r116 = new mq6.c();
        r116.g("enter_from", "poi_page");
        PoiBundle r109 = this.B;
        if (r109 == null) goto L26;
        String r117 = r109.previousEnterFrom;
    L27:
        r116.g("previous_enter_from", r117);
        PoiBundle r118 = this.B;
        if (r118 == null) goto L30;
        String r119 = r118.backendType;
    L31:
        r116.g("poi_backend_type", r119);
        PoiBundle r120 = this.B;
        if (r120 == null) goto L34;
        String r121 = r120.poiId;
    L35:
        r116.g("poi_id", r121);
        PoiBundle r122 = this.B;
        if (r122 == null) goto L38;
        String r123 = r122.poiType;
    L39:
        r116.g("poi_type", r123);
        PoiBundle r124 = this.B;
        if (r124 == null) goto L42;
        String r125 = r124.awemeid;
    L43:
        r116.g("group_id", r125);
        PoiBundle r126 = this.B;
        if (r126 == null) goto L46;
        String r127 = r126.authorId;
    L47:
        r116.g("author_id", r127);
        PoiBundle r128 = this.B;
        if (r128 == null) goto L50;
        String r129 = r128.serviceType;
    L51:
        if (r129 != null) goto L53;
        r129 = "";
    L53:
        r116.g("service_type", r129);
        PoiBundle r130 = this.B;
        if (r130 == null) goto L56;
        String r131 = r130.enterId;
    L57:
        r116.g("poi_enter_id", r131);
        PoiBundle r132 = this.B;
        if (r132 == null) goto L60;
        String r133 = r132.from;
    L61:
        r116.g("poi_enter_page", r133);
        PoiBundle r134 = this.B;
        if (r134 == null) goto L64;
        String r135 = r134.from;
    L65:
        r116.g("previous_page", r135);
        r116.g("enter_method", DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);
        PoiBundle r136 = this.B;
        if (r136 == null) goto L70;
        HashMap<String, String> r137 = r136.adParams;
        if (r137 == null) goto L70;
        String r138 = r137.get("creative_id");
    L71:
        r116.g("cid", r138);
        PoiBundle r139 = this.B;
        if (r139 == null) goto L76;
        HashMap<String, String> r140 = r139.adParams;
        if (r140 == null) goto L76;
        String r141 = r140.get("log_extra");
    L77:
        r116.g("log_extra", r141);
        PoiBundle r142 = this.B;
        if (r142 == null) goto L82;
        HashMap<String, String> r143 = r142.adParams;
        if (r143 == null) goto L82;
        String r144 = r143.get("is_other_channel");
    L83:
        r116.g("is_other_channel", r144);
        kt6.f r145 = HostServiceUtilsKt.s();
        PoiBundle r146 = this.B;
        if (r146 == null) goto L86;
        String r147 = r146.cityCode;
    L88:
        if (r145.b(r147) == false) goto L90;
        String r148 = "1";
    L91:
        r116.g("poi_device_samecity", r148);
        PoiDetail r149 = this.A;
        if (r149 == null) goto L100;
        PoiStruct r150 = r149.poiStruct;
        if (r150 == null) goto L100;
        ShareInfo r151 = r150.shareInfo;
        if (r151 == null) goto L100;
        String r152 = r151.getLifeShareExt();
        if (r152 == null) goto L100;
        r116.d("life_share_ext", r152);
    L100:
        Unit r153 = Unit.INSTANCE;
        com.bytedance.locallife.biz.btm.b.C3644b.c(r116, this, "c20487.d4629");
        com.bytedance.locallife.biz.mob.a.C3646a.a(r116, EventType.CLICK);
        xy6.a.a(this, "click_share_poi_button", r116.f514893a);
        HostServiceUtilsKt.m0().a();
        ps6.b r154 = HostServiceUtilsKt.j().a();
        if (r154 == null) goto L103;
        getContext();
        r154.d();
        goto L103
    L90:
        r148 = "0";
        goto L91
    L86:
        r147 = null;
    L82:
        r144 = null;
    L76:
        r141 = null;
    L70:
        r138 = null;
        goto L71
    L64:
        r135 = null;
        goto L65
    L60:
        r133 = null;
        goto L61
    L56:
        r131 = null;
        goto L57
    L50:
        r129 = null;
        goto L51
    L46:
        r127 = null;
        goto L47
    L42:
        r125 = null;
        goto L43
    L38:
        r123 = null;
        goto L39
    L34:
        r121 = null;
        goto L35
    L30:
        r119 = null;
        goto L31
    L26:
        r117 = null;
        goto L27
    L22:
        r108 = null;
    L103:
        ps6.b r155 = HostServiceUtilsKt.j().a();
        if (r155 == null) goto L128;
        PoiBundle r156 = this.B;
        if (r156 == null) goto L110;
        HashMap<String, String> r157 = r156.adParams;
        if (r157 == null) goto L110;
        String r158 = r157.get("creative_id");
    L111:
        PoiBundle r159 = this.B;
        if (r159 == null) goto L116;
        HashMap<String, String> r160 = r159.adParams;
        if (r160 == null) goto L116;
        String r161 = r160.get("log_extra");
    L116:
        PoiBundle r162 = this.B;
        if (r162 == null) goto L121;
        HashMap<String, String> r163 = r162.adParams;
        if (r163 == null) goto L121;
        String r164 = r163.get("group_id");
    L122:
        PoiBundle r165 = this.B;
        if (r165 == null) goto L125;
        r101 = r165.adExtraData;
    L125:
        r155.a("poi_share_click", "poi_share", r158, r164, r101);
        return;
    L121:
        r164 = null;
    L110:
        r158 = null;
        goto L111
    L128:
        return;
    L11:
        r104 = null;
        goto L13
    L127:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void setHeaderIconColor(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = "#161823";
    L5:
        int r102 = com.bytedance.locallife.poi.dito.util.a.a(r101);
        if (Intrinsics.areEqual(this.O, Boolean.valueOf(r100)) == false) goto L9;
        return;
    L9:
        if (this.L == false) goto L12;
        if (r100 == true) goto L12;
        return;
    L12:
        AppCompatImageView r103 = this.H;
        if (r103 == null) goto L18;
        Drawable r104 = r103.getDrawable();
        if (r104 == null) goto L19;
        this.O = Boolean.valueOf(r100);
        DrawableCompat.setTint(r104, r102);
        return;
    L19:
        return;
    L18:
        return;
    L4:
        r101 = "#F0FFFFFF";
        goto L5
    }

    public final void setPageLayoutStyle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.W = r100;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiNaviMoreEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        throw null;
    }

    public final void j0(boolean r100, boolean r101) {
        if (this.N != r100) goto L5;
        return;
    L5:
        if (r101 == false) goto L7;
    L10:
        this.N = r100;
        Activity r102 = com.bytedance.locallife.poi.newdetail.t.a(this);
        if (r102 != null) goto L13;
        return;
    L13:
        if (this.f263097k0 == false) goto L15;
        ImmersionBar.with(r102).statusBarDarkFont(r100).transparentStatusBar().init();
    L16:
        DitoDataCenter r103 = getDataCenter();
        int r104 = DitoDataCenter.f258004d;
        MutableLiveData<JSONObject> r105 = r103.a0("status_bar_font_dark", 1);
        JSONObject r106 = new JSONObject();
        r106.put("status_bar_font_dark", r100);
        r106.put("status_bar_transparent", this.f263097k0);
        r105.setValue(r106);
        return;
    L15:
        ImmersionBar.with(r102).statusBarDarkFont(r100).init();
        goto L16
    L7:
        if (this.K == false) goto L10;
        if (r100 == true) goto L10;
    }

    public PoiQuickPageNavigationBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263100z = UIUtils.getStatusBarHeight(r100);
        this.T = true;
        this.W = "0";
    }
}
