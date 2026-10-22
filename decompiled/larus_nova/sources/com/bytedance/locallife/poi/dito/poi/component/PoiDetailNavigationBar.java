package com.bytedance.locallife.poi.dito.poi.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.mob.EventType;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.bytedance.locallife.model.poi.resp.PoiDistanceModel;
import com.bytedance.locallife.model.poi.resp.PoiServerAbmap;
import com.bytedance.locallife.model.poi.resp.PoiStruct;
import com.bytedance.locallife.model.poi.resp.ShareInfo;
import com.bytedance.locallife.poi.newdetail.component.PoiQuickPageNavigationBar;
import com.bytedance.locallife.poi.newdetail.widget.lynx.PoiSimpleLynxView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.event.PoiNavBackClickEvent;
import com.ss.android.ugc.aweme.poi.event.PoiNaviMoreEvent;
import com.ss.android.ugc.aweme.poi.event.PoiNaviShareEvent;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0010H\u0007¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/component/PoiDetailNavigationBar;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/poi/dito/poi/component/f;", "", "isBlack", "", "setHeaderIconColor", "Lmq6/c;", "getPOIShareMobParamsBuilder", "Lcom/ss/android/ugc/aweme/poi/event/PoiNaviShareEvent;", "event", "onEvent", "Lcom/ss/android/ugc/aweme/poi/event/PoiNaviMoreEvent;", "Lty6/d;", "sendEvent", "onPopupEvent", "Lcom/ss/android/ugc/aweme/poi/event/PoiNavBackClickEvent;", "onBackBtnClickEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDetailNavigationBar extends BaseDitoView<f> {
    public int A;
    public int B;
    public final int C;
    public Boolean D;
    public Boolean E;
    public Boolean F;
    public final int G;
    public PoiDetail H;
    public PoiBundle I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f262430J;
    public View K;
    public View L;
    public View M;
    public LinearLayout N;
    public AppCompatImageView O;
    public PoiSimpleLynxView P;
    public FrameLayout Q;
    public int R;
    public boolean S;
    public boolean T;
    public String U;
    public boolean V;
    public boolean W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f262431k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f262432p0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f262433y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f262434z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f262435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiDetailNavigationBar f262436b;

        public b(AppCompatImageView r100, PoiDetailNavigationBar r101) {
            this.f262435a = r100;
            this.f262436b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.locallife.common.utils.g.a(this.f262435a) == false) goto L5;
            return;
        L5:
            this.f262436b.getDataCenter().f().setValue(Boolean.TRUE);
            this.f262436b.T = true;
        }
    }

    static {
    }

    private final mq6.c getPOIShareMobParamsBuilder() {
        int r100 = com.bytedance.locallife.biz.btm.b.f256555a;
        mq6.c r101 = new mq6.c();
        mq6.a r102 = mq6.c.a.f514894a;
        r101.g("enter_from", "poi_page");
        PoiBundle r103 = this.I;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.previousEnterFrom;
    L6:
        r101.g("previous_enter_from", r105);
        PoiBundle r106 = this.I;
        if (r106 == null) goto L9;
        String r107 = r106.backendType;
    L10:
        r101.g("poi_backend_type", r107);
        PoiBundle r108 = this.I;
        if (r108 == null) goto L13;
        String r109 = r108.poiId;
    L14:
        r101.g("poi_id", r109);
        PoiBundle r110 = this.I;
        if (r110 == null) goto L17;
        String r111 = r110.poiType;
    L18:
        r101.g("poi_type", r111);
        PoiBundle r112 = this.I;
        if (r112 == null) goto L21;
        String r113 = r112.awemeid;
    L22:
        r101.g("group_id", r113);
        PoiBundle r114 = this.I;
        if (r114 == null) goto L25;
        String r115 = r114.authorId;
    L26:
        r101.g("author_id", r115);
        PoiBundle r116 = this.I;
        if (r116 == null) goto L29;
        String r117 = r116.serviceType;
    L30:
        String r118 = "";
        if (r117 != null) goto L33;
        r117 = "";
    L33:
        r101.g("service_type", r117);
        PoiBundle r119 = this.I;
        if (r119 == null) goto L36;
        String r120 = r119.enterId;
    L37:
        r101.g("poi_enter_id", r120);
        PoiBundle r121 = this.I;
        if (r121 == null) goto L40;
        String r122 = r121.from;
    L41:
        r101.g("poi_enter_page", r122);
        PoiBundle r123 = this.I;
        if (r123 == null) goto L44;
        String r124 = r123.from;
    L45:
        r101.g("previous_page", r124);
        kt6.f r125 = HostServiceUtilsKt.s();
        PoiBundle r126 = this.I;
        if (r126 == null) goto L48;
        String r127 = r126.cityCode;
    L50:
        if (r125.b(r127) == false) goto L52;
        String r128 = "1";
    L53:
        r101.g("poi_device_samecity", r128);
        PoiBundle r129 = this.I;
        if (r129 == null) goto L58;
        HashMap<String, String> r130 = r129.adParams;
        if (r130 == null) goto L58;
        String r131 = r130.get("creative_id");
    L59:
        r101.g("cid", r131);
        PoiBundle r132 = this.I;
        if (r132 == null) goto L64;
        HashMap<String, String> r133 = r132.adParams;
        if (r133 == null) goto L64;
        String r134 = r133.get("log_extra");
    L65:
        r101.g("log_extra", r134);
        PoiBundle r135 = this.I;
        if (r135 == null) goto L70;
        HashMap<String, String> r136 = r135.adParams;
        if (r136 == null) goto L70;
        String r137 = r136.get("is_other_channel");
    L71:
        r101.g("is_other_channel", r137);
        int r138 = com.bytedance.locallife.poi.dito.util.j.f262559a;
        PoiDetail r139 = this.H;
        if (r139 == null) goto L78;
        PoiStruct r140 = r139.poiStruct;
        if (r140 == null) goto L78;
        ShareInfo r141 = r140.shareInfo;
        if (r141 == null) goto L78;
        String r142 = r141.getLifeShareExt();
    L79:
        PoiBundle r143 = this.I;
        if (r143 == null) goto L82;
        String r144 = r143.from;
    L83:
        if (r144 != null) goto L85;
        r144 = "";
    L85:
        if (r143 == null) goto L87;
        r104 = r143.enterMethod;
    L87:
        if (r104 == null) goto L90;
        r118 = r104;
    L90:
        boolean r145 = false;
        Map r146 = MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", "poi_page"), TuplesKt.to("poi_enter_page", r144), TuplesKt.to(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r118)});
        if (r142 == null) goto L111;
        if (r146 != null) goto L95;
    L96:
        r145 = true;
    L97:
        if (r145 == true) goto L111;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L105
        JSONObject r148 = new JSONObject(r142);     // Catch: Throwable -> L105
        Iterator r149 = r146.entrySet().iterator();     // Catch: Throwable -> L105
    L101:
        if (r149.hasNext() == false) goto L103;
        Map.Entry r150 = (Map.Entry) r149.next();     // Catch: Throwable -> L105
        r148.put((String) r150.getKey(), r150.getValue());     // Catch: Throwable -> L105
        goto L101
    L103:
        Object r151 = Result.m9449constructorimpl(r148.toString());     // Catch: Throwable -> L105
    L107:
        Object r152 = r142;
        if (Result.m9452exceptionOrNullimpl(r151) != null) goto L110;
        r152 = r151;
    L110:
        r142 = (String) r152;
    L105:
        th = move-exception;
        Result.Companion r153 = Result.Companion;
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L107
    L95:
        if (r146.isEmpty() == false) goto L97;
    L111:
        if (r142 == null) goto L113;
        r101.d("life_share_ext", r142);
    L113:
        com.bytedance.locallife.biz.btm.b.C3644b.c(r101, this, "c20487.d4629");
        return r101;
    L82:
        r144 = null;
    L78:
        r142 = null;
    L70:
        r137 = null;
    L64:
        r134 = null;
    L58:
        r131 = null;
        goto L59
    L52:
        r128 = "0";
        goto L53
    L48:
        r127 = null;
        goto L50
    L44:
        r124 = null;
        goto L45
    L40:
        r122 = null;
        goto L41
    L36:
        r120 = null;
        goto L37
    L29:
        r117 = null;
        goto L30
    L25:
        r115 = null;
        goto L26
    L21:
        r113 = null;
        goto L22
    L17:
        r111 = null;
        goto L18
    L13:
        r109 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        super.P();
        if (this.f262432p0 == false) goto L5;
        return;
    L5:
        com.bytedance.locallife.poi.perf.timing.a.c("bind导航栏", new Pair[0]);
        Object r100 = getDitoViewModel().A.get("poi_bundle");
        String r101 = null;
        if ((r100 instanceof PoiBundle) == false) goto L8;
        PoiBundle r102 = (PoiBundle) r100;
    L9:
        this.I = r102;
        int r103 = PoiQuickPageNavigationBar.H0;
        Schedulers.computation().scheduleDirect(new com.bytedance.locallife.poi.newdetail.component.w(r102));
        Object r104 = getDitoViewModel().A.get("poi_detail");
        if ((r104 instanceof PoiDetail) == false) goto L12;
        PoiDetail r105 = (PoiDetail) r104;
    L13:
        this.H = r105;
        Object r106 = getDitoViewModel().A.get("poi_detail_str");
        if ((r106 instanceof String) == false) goto L16;
        String r107 = (String) r106;
    L17:
        this.f262430J = r107;
        PoiBundle r108 = this.I;
        if (r108 == null) goto L20;
        PoiImageUrlModel r109 = r108.firstHeadImg;
    L21:
        if (r109 != null) goto L48;
        f r110 = getModel();
        if (r110 == null) goto L27;
        fy6.e r111 = r110.c();
        if (r111 == null) goto L27;
        fy6.g r112 = r111.e();
    L28:
        PoiBundle r113 = this.I;
        if (r113 == null) goto L48;
        if (r112 == null) goto L36;
        fy6.f r114 = r112.a();
        if (r114 == null) goto L36;
        PoiImageUrlModel r115 = r114.b();
        if (r115 == null) goto L36;
    L47:
        r113.firstHeadImg = r115;
    L36:
        if (r112 == null) goto L40;
        fy6.f r116 = r112.a();
        if (r116 == null) goto L40;
        r115 = r116.c();
    L41:
        if (r115 != null) goto L47;
        if (r112 == null) goto L46;
        fy6.f r117 = r112.a();
        if (r117 == null) goto L46;
        r115 = r117.a();
    L46:
        r115 = null;
    L40:
        r115 = null;
    L27:
        r112 = null;
    L48:
        PoiDetail r118 = this.H;
        if (r118 == null) goto L55;
        PoiServerAbmap r119 = r118.abMap;
        if (r119 == null) goto L55;
        if (r119.getHeaderPhotoStyle() != 1) goto L55;
        boolean r120 = true;
    L57:
        if (r120 == false) goto L59;
        this.S = true;
        this.R = 4;
    L66:
        f r121 = getModel();
        if (r121 == null) goto L71;
        fy6.e r122 = r121.c();
        if (r122 == null) goto L71;
        PoiDistanceModel r123 = r122.c();
    L72:
        if (r123 == null) goto L101;
        f r124 = getModel();
        if (r124 == null) goto L78;
        fy6.e r125 = r124.c();
        if (r125 == null) goto L78;
        PoiDistanceModel r126 = r125.b();
    L79:
        if (r126 == null) goto L101;
        this.f262433y = true;
        f r127 = getModel();
        if (r127 == null) goto L87;
        fy6.e r128 = r127.c();
        if (r128 == null) goto L87;
        PoiDistanceModel r129 = r128.c();
        if (r129 == null) goto L87;
        com.bytedance.locallife.poi.newdetail.h r130 = com.bytedance.locallife.poi.newdetail.h.f263262a;
        this.f262434z = com.bytedance.locallife.poi.newdetail.h.c(r129, getContext());
    L87:
        f r131 = getModel();
        if (r131 == null) goto L94;
        fy6.e r132 = r131.c();
        if (r132 == null) goto L94;
        PoiDistanceModel r133 = r132.b();
        if (r133 == null) goto L94;
        com.bytedance.locallife.poi.newdetail.h r134 = com.bytedance.locallife.poi.newdetail.h.f263262a;
        this.A = com.bytedance.locallife.poi.newdetail.h.c(r133, getContext());
    L94:
        f r135 = getModel();
        if (r135 == null) goto L101;
        fy6.e r136 = r135.c();
        if (r136 == null) goto L101;
        PoiDistanceModel r137 = r136.d();
        if (r137 == null) goto L101;
        com.bytedance.locallife.poi.newdetail.h r138 = com.bytedance.locallife.poi.newdetail.h.f263262a;
        this.B = com.bytedance.locallife.poi.newdetail.h.c(r137, getContext());
    L78:
        r126 = null;
    L101:
        final Ref.ObjectRef r139 = new Ref.ObjectRef();
        f r140 = getModel();     // Catch: Exception -> L114
        if (r140 == null) goto L111;
        fy6.e r141 = r140.c();     // Catch: Exception -> L114
        if (r141 == null) goto L111;
        JsonObject r142 = r141.a();     // Catch: Exception -> L114
        if (r142 == null) goto L111;
        JsonElement r143 = r142.get(SendClosePdpEventParam.KEY_LYNX_URL);     // Catch: Exception -> L114
        if (r143 == null) goto L111;
        T r144 = r143.getAsString();     // Catch: Exception -> L114
    L112:
        r139.element = r144;     // Catch: Exception -> L114
    L116:
        LinearLayout r145 = this.N;
        if (r145 == null) goto L120;
        r145.setVisibility(0);
    L120:
        this.O = (AppCompatImageView) findViewById(R.id.poi_detail_navigation_back);
        this.P = (PoiSimpleLynxView) findViewById(R.id.poi_detail_navigation_lynx);
        this.Q = (FrameLayout) findViewById(R.id.nav_title_bar);
        AppCompatImageView r146 = this.O;
        if (r146 == null) goto L125;
        ViewTreeObserver r147 = r146.getViewTreeObserver();
        if (r147 == null) goto L125;
        r147.addOnPreDrawListener(new c(r146, this));
    L125:
        Drawable r148 = ContextCompat.getDrawable(getContext(), R.drawable.ic_s_s_arrowleft_outlined_20);
        if (r148 == null) goto L130;
        Drawable r149 = DrawableCompat.wrap(r148).mutate();
        AppCompatImageView r150 = this.O;
        if (r150 == null) goto L130;
        r150.setImageDrawable(r149);
    L130:
        AppCompatImageView r151 = this.O;
        if (r151 == null) goto L134;
        r151.setContentDescription(getContext().getString(R.string.poi_back_description));
    L134:
        AppCompatImageView r152 = this.O;
        if (r152 == null) goto L137;
        r152.setOnClickListener(new b(r152, this));
    L137:
        f r153 = getModel();
        if (r153 == null) goto L142;
        fy6.e r154 = r153.c();
        if (r154 == null) goto L142;
        JsonObject r155 = r154.a();
    L144:
        if (r155 == null) goto L146;
        JsonElement r156 = r155.get("should_hide_native_back_btn");
    L148:
        if (d0(r156) == false) goto L153;
        AppCompatImageView r157 = this.O;
        if (r157 == null) goto L153;
        r157.setVisibility(8);
    L153:
        if (r155 == null) goto L155;
        JsonElement r158 = r155.get("should_hide_status_bar");
    L157:
        if (d0(r158) == false) goto L176;
        View r159 = this.L;
        if (r159 == null) goto L162;
        r159.setVisibility(8);
    L162:
        FrameLayout r160 = this.Q;
        if (r160 == null) goto L165;
        ViewGroup.LayoutParams r161 = r160.getLayoutParams();
    L166:
        if (r161 != null) goto L168;
    L174:
        this.W = true;
        goto L176
    L168:
        if (this.f262431k0 != 0) goto L170;
        this.f262431k0 = r161.height + this.G;
    L170:
        r161.height = this.f262431k0;
        FrameLayout r162 = this.Q;
        if (r162 == null) goto L174;
        r162.setLayoutParams(r161);
        goto L174
    L165:
        r161 = null;
    L176:
        if (r155 != null) goto L178;
    L180:
        boolean r163 = false;
    L182:
        if (r163 == false) goto L204;
        boolean r164 = d0(r155.get("enable_alpha_change"));
        this.V = r164;
        if (r164 == true) goto L204;
        View r165 = this.M;
        if (r165 == null) goto L189;
        r165.setVisibility(0);
    L189:
        View r166 = this.M;
        if (r166 == null) goto L194;
        r166.setAlpha(1.0f);
    L194:
        if (this.W == true) goto L204;
        View r167 = this.L;
        if (r167 == null) goto L199;
        r167.setVisibility(0);
    L199:
        View r168 = this.L;
        if (r168 == null) goto L204;
        r168.setAlpha(1.0f);
    L204:
        if (r155 != null) goto L206;
    L208:
        boolean r169 = false;
    L209:
        if (r169 == true) goto L277;
    L235:
        int r170 = com.bytedance.locallife.poi.dito.util.g.f262556a;
        DitoViewModel r171 = getDitoViewModel();
        f r172 = getModel();
        if (r172 == null) goto L238;
        r101 = r172.f258493b.f258222b;
    L238:
        com.bytedance.locallife.poi.dito.util.g.a(r171, r101, new PoiDetailNavigationBar$onBindData$6(this, r139));
        int r173 = this.R;
        if (r173 < 4) goto L256;
        f0(false, true);
        a0(0.0f, true);
        int r174 = this.R;
        if (r174 == 1) goto L246;
        if (r174 == 2) goto L246;
        if (r174 == 4) goto L246;
        boolean r175 = false;
    L247:
        if (r175 == false) goto L275;
        AppCompatImageView r176 = this.O;
        if (r176 == null) goto L251;
        int r177 = this.C;
        r176.setPadding(r177, r177, r177, r177);
    L251:
        AppCompatImageView r178 = this.O;
        if (r178 == null) goto L275;
        r178.setBackground(b0(this));
    L275:
        this.f262432p0 = true;
        com.bytedance.locallife.poi.perf.timing.a.a("bind导航栏", new Pair[0]);
        return;
    L246:
        r175 = true;
        goto L247
    L256:
        if (r173 != 3) goto L258;
        f0(true, true);
        a0(1.0f, true);
        goto L275
    L258:
        if (r173 < 1) goto L274;
        f0(false, true);
        int r179 = this.R;
        if (r179 == 1) goto L265;
        if (r179 == 2) goto L265;
        if (r179 == 4) goto L265;
        boolean r180 = false;
    L266:
        if (r180 == false) goto L275;
        AppCompatImageView r181 = this.O;
        if (r181 == null) goto L270;
        int r182 = this.C;
        r181.setPadding(r182, r182, r182, r182);
    L270:
        AppCompatImageView r183 = this.O;
        if (r183 == null) goto L275;
        r183.setBackground(b0(this));
    L265:
        r180 = true;
        goto L266
    L274:
        f0(false, true);
        goto L275
    L277:
        Result.Companion r184 = Result.Companion;     // Catch: Throwable -> L225
        JsonElement r185 = r155.get("background_color");     // Catch: Throwable -> L225
        if (r185 == null) goto L213;
        String r186 = r185.getAsString();     // Catch: Throwable -> L225
    L215:
        if (r186 != null) goto L217;
    L219:
        boolean r187 = false;
    L220:
        if (r187 == false) goto L222;
        int r188 = Color.parseColor("#" + r186.subSequence(7, 9) + r186.subSequence(1, 7));     // Catch: Throwable -> L225
    L223:
        Object r189 = Result.m9449constructorimpl(Integer.valueOf(r188));     // Catch: Throwable -> L225
    L228:
        if (Result.m9456isSuccessimpl(r189) == false) goto L235;
        int r190 = ((Number) r189).intValue();
        View r191 = this.L;
        if (r191 == null) goto L232;
        r191.setBackgroundColor(r190);
    L232:
        View r192 = this.M;
        if (r192 == null) goto L235;
        r192.setBackgroundColor(r190);
        goto L235
    L222:
        r188 = Color.parseColor(r186);     // Catch: Throwable -> L225
        goto L223
    L217:
        if (r186.length() != 9) goto L219;
        r187 = true;
        goto L220
    L213:
        r186 = null;
    L225:
        th = move-exception;
        Result.Companion r193 = Result.Companion;
        r189 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L228
    L206:
        if (r155.has("background_color") != true) goto L208;
        r169 = true;
        goto L209
    L178:
        if (r155.has("enable_alpha_change") != true) goto L180;
        r163 = true;
        goto L182
    L155:
        r158 = null;
        goto L157
    L146:
        r156 = null;
    L142:
        r155 = null;
    L111:
        r144 = 0;
    L114:
        e = move-exception;
        HostServiceUtilsKt.c().a(e);
    L71:
        r123 = null;
        goto L72
    L59:
        PoiDetail r194 = this.H;
        if (r194 == null) goto L64;
        PoiServerAbmap r195 = r194.abMap;
        if (r195 == null) goto L64;
        int r196 = r195.getPoiDetailHeadOptV2();
    L65:
        this.R = r196;
    L64:
        r196 = 0;
    L55:
        r120 = false;
        goto L57
    L20:
        r109 = null;
        goto L21
    L16:
        r107 = null;
        goto L17
    L12:
        r105 = null;
        goto L13
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        Object r100 = getDitoViewModel().A.get("inflater_manager");
        ViewGroup.LayoutParams r101 = null;
        if ((r100 instanceof sy6.b) == false) goto L5;
        sy6.b r102 = (sy6.b) r100;
    L6:
        if (r102 == null) goto L8;
        View r103 = r102.a(getContext(), R.layout.saas_poi_detail_navigation_bar, this);
    L9:
        if (r103 == null) goto L11;
        View r104 = r103.findViewById(R.id.poi_header_share_stub);
    L12:
        this.K = r104;
        if (r103 == null) goto L15;
        View r105 = r103.findViewById(R.id.poi_navigation_status_bar);
    L16:
        this.L = r105;
        if (r103 == null) goto L19;
        View r106 = r103.findViewById(R.id.poi_navigation_bar_bg);
    L20:
        this.M = r106;
        if (r103 == null) goto L23;
        LinearLayout r107 = (LinearLayout) r103.findViewById(R.id.poi_navigation_lynx_bar);
    L24:
        this.N = r107;
        Object r108 = getDitoViewModel().A.get("skin_style");
        if ((r108 instanceof com.bytedance.locallife.poi.newdetail.k) == false) goto L27;
        com.bytedance.locallife.poi.newdetail.k r109 = (com.bytedance.locallife.poi.newdetail.k) r108;
    L28:
        if (r109 == null) goto L32;
        com.bytedance.locallife.poi.newdetail.c r110 = r109.f263276c;
        if (r110 == null) goto L32;
        String r111 = r110.a();
    L34:
        if (TextUtils.isEmpty(r111) == false) goto L36;
        int r112 = ContextCompat.getColor(getContext(), R.color.POIBgPrimary);
    L43:
        View r113 = this.L;
        if (r113 == null) goto L46;
        r113.setBackgroundColor(r112);
    L46:
        View r114 = this.M;
        if (r114 == null) goto L49;
        r114.setBackgroundColor(r112);
    L49:
        View r115 = this.L;
        if (r115 == null) goto L52;
        r101 = r115.getLayoutParams();
    L52:
        if (r101 == null) goto L57;
        r101.height = this.G;
        View r116 = this.L;
        if (r116 == null) goto L57;
        r116.setLayoutParams(r101);
    L57:
        addView(r103);
        getDataCenter().v().observe(this, new d(this));
        getDataCenter().S().observe(this, new e(this));
        vn6.b.a(new ty6.c());
        vn6.b.b(this);
        return;
    L36:
        int r117 = com.bytedance.locallife.poi.dito.util.a.f262546a;
        if (r109 == null) goto L41;
        com.bytedance.locallife.poi.newdetail.c r118 = r109.f263276c;
        if (r118 == null) goto L41;
        String r119 = r118.a();
    L42:
        r112 = com.bytedance.locallife.poi.dito.util.a.a(r119);
    L41:
        r119 = null;
    L32:
        r111 = null;
        goto L34
    L27:
        r109 = null;
        goto L28
    L23:
        r107 = null;
        goto L24
    L19:
        r106 = null;
        goto L20
    L15:
        r105 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
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
        if (this.T == true) goto L6;
    L8:
        PoiSimpleLynxView r100 = this.P;
        if (r100 == null) goto L11;
        r100.h();
    L11:
        vn6.b.c(this);
        return;
    L6:
        if (TextUtils.isEmpty(this.U) == true) goto L8;
        yt6.a r101 = HostServiceUtilsKt.a0();
        Context r102 = getContext();
        String r103 = this.U;
        Intrinsics.checkNotNull(r103);
        r101.d(r102, r103).a();
        goto L8
    }

    public static Drawable b0(final PoiDetailNavigationBar r100) {
        final com.bytedance.locallife.dito.utils.w.a r101 = com.bytedance.locallife.dito.utils.w.a.f258724b;
        r100.getClass();
        final float r102 = 0.0f;
        final int r103 = R.color.SDSecondary;
        return com.bytedance.locallife.dito.utils.o.a(new PoiDetailNavigationBar$getRoundBgDrawable$1(r101, r102, r100, r103));
    }

    private final void setHeaderIconColor(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = "#161823";
    L6:
        if (Intrinsics.areEqual(this.F, Boolean.valueOf(r100)) == false) goto L8;
        return;
    L8:
        this.F = Boolean.valueOf(r100);
        AppCompatImageView r102 = this.O;
        if (r102 == null) goto L14;
        Drawable r103 = r102.getDrawable();
        if (r103 == null) goto L15;
        DrawableCompat.setTint(r103, com.bytedance.locallife.poi.dito.util.a.a(r101));
        return;
    L15:
        return;
    L14:
        return;
    L4:
        r101 = "#F0FFFFFF";
        goto L6
    }

    public final void c0(boolean r100) {
        if (this.R == 3) goto L5;
    L9:
        this.D = Boolean.valueOf(r100);
        int r101 = this.R;
        if (r101 != 1) goto L12;
    L17:
        boolean r102 = true;
    L18:
        if (r102 == false) goto L34;
        if (r100 == false) goto L27;
        f0(true, false);
        int r103 = (int) UIUtils.dip2Px(getContext(), 4.0f);
        AppCompatImageView r104 = this.O;
        if (r104 == null) goto L23;
        r104.setPadding(r103, r103, r103, r103);
    L23:
        AppCompatImageView r105 = this.O;
        if (r105 == null) goto L41;
        r105.setBackground(null);
        return;
    L41:
        return;
    L27:
        f0(false, false);
        AppCompatImageView r106 = this.O;
        if (r106 == null) goto L30;
        int r107 = this.C;
        r106.setPadding(r107, r107, r107, r107);
    L30:
        AppCompatImageView r108 = this.O;
        if (r108 == null) goto L42;
        r108.setBackground(b0(this));
        return;
    L42:
        return;
    L34:
        if (r100 == false) goto L36;
        f0(true, false);
        return;
    L36:
        f0(false, false);
        return;
    L12:
        if (r101 == 2) goto L17;
        if (r101 == 4) goto L17;
        r102 = false;
        goto L18
    L5:
        if (this.f262433y == true) goto L9;
        if (Intrinsics.areEqual(Boolean.valueOf(r100), this.D) == false) goto L9;
    }

    public final boolean d0(JsonElement r100) {
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
        PoiBundle r101 = this.I;
        if (r101 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r100.f451344a, r101.sessionId) == true) goto L8;
        return;
    L8:
        getDataCenter().f().setValue(Boolean.TRUE);
        this.T = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiNaviShareEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        String r100 = r110.f451345a;
        PoiBundle r101 = this.I;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.sessionId;
    L7:
        if (TextUtils.equals(r100, r103) == false) goto L86;
        Activity r104 = com.bytedance.locallife.poi.newdetail.t.a(this);
        PoiDetail r105 = this.H;
        if (r105 == null) goto L11;
        PoiStruct r106 = r105.poiStruct;
    L12:
        if (r106 == null) goto L56;
        if (r104 == null) goto L56;
        String r107 = this.f262430J;
        if (r107 == null) goto L18;
        HostServiceUtilsKt.h0().c(r104, r107, this.I);
    L18:
        int r108 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r109 = new mq6.c();
        mq6.a r111 = mq6.c.a.f514894a;
        r109.g("label", "poi_page");
        PoiBundle r112 = this.I;
        if (r112 == null) goto L21;
        String r113 = r112.poiId;
    L22:
        r109.g("poi_id", r113);
        com.bytedance.locallife.biz.mob.a.C3646a.c("click_share_button", r109.f514893a);
        JSONObject r114 = r110.f451346b;
        boolean r115 = false;
        if (r114 != null) goto L25;
    L27:
        if (r115 == true) goto L53;
        mq6.c r116 = getPOIShareMobParamsBuilder();
        com.bytedance.locallife.biz.mob.a.C3646a.a(r116, EventType.CLICK);
        Gson r117 = com.bytedance.locallife.biz.common.utils.b.f256637a;
        JSONObject r118 = r110.f451346b;
        if (r118 == null) goto L31;
        String r119 = r118.optString(ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS);
    L32:
        LinkedHashMap r120 = new LinkedHashMap();
        if (r119 == null) goto L48;
        Type r121 = new com.bytedance.locallife.biz.common.utils.a().getType();
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L46
        Iterator r123 = MapsKt.toMap((Map) com.bytedance.locallife.biz.common.utils.b.f256637a.fromJson(r119, r121)).entrySet().iterator();     // Catch: Throwable -> L46
    L38:
        if (r123.hasNext() == false) goto L44;
        Map.Entry r124 = (Map.Entry) r123.next();     // Catch: Throwable -> L46
        Object r125 = r124.getValue();     // Catch: Throwable -> L46
        if ((r125 instanceof String) == false) goto L42;
        String r126 = (String) r125;     // Catch: Throwable -> L46
    L43:
        r120.put(r124.getKey(), r126);     // Catch: Throwable -> L46
        goto L38
    L42:
        r126 = com.bytedance.locallife.biz.common.utils.b.f256637a.toJson(r125);     // Catch: Throwable -> L46
        goto L43
    L44:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L48:
        Intrinsics.checkNotNullParameter(r116, "<this>");
        Intrinsics.checkNotNullParameter(r120, "map");
        Iterator r128 = r120.entrySet().iterator();
    L50:
        if (r128.hasNext() == false) goto L52;
        Map.Entry r129 = (Map.Entry) r128.next();
        r116.d((String) r129.getKey(), (String) r129.getValue());
        goto L50
    L52:
        xy6.a.a(this, "click_share_poi_button", r116.f514893a);
        goto L53
    L31:
        r119 = null;
    L53:
        int r130 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r131 = getPOIShareMobParamsBuilder();
        com.bytedance.locallife.biz.mob.a.C3646a.a(r131, EventType.CLICK);
        xy6.a.a(this, "life_share_show", r131.f514893a);
        HostServiceUtilsKt.m0().a();
        ps6.b r132 = HostServiceUtilsKt.j().a();
        if (r132 == null) goto L56;
        getContext();
        r132.d();
        goto L56
    L25:
        if (r114.optBoolean("disable_native_click_track", false) != true) goto L27;
        r115 = true;
        goto L27
    L21:
        r113 = null;
    L56:
        ps6.b r133 = HostServiceUtilsKt.j().a();
        if (r133 == null) goto L87;
        PoiBundle r134 = this.I;
        if (r134 == null) goto L63;
        HashMap<String, String> r135 = r134.adParams;
        if (r135 == null) goto L63;
        String r136 = r135.get("creative_id");
    L64:
        PoiBundle r137 = this.I;
        if (r137 == null) goto L69;
        HashMap<String, String> r138 = r137.adParams;
        if (r138 == null) goto L69;
        String r139 = r138.get("log_extra");
    L69:
        PoiBundle r140 = this.I;
        if (r140 == null) goto L74;
        HashMap<String, String> r141 = r140.adParams;
        if (r141 == null) goto L74;
        String r142 = r141.get("group_id");
    L75:
        PoiBundle r143 = this.I;
        if (r143 == null) goto L78;
        r102 = r143.adExtraData;
    L78:
        r133.a("poi_share_click", "poi_share", r136, r142, r102);
        return;
    L74:
        r142 = null;
    L63:
        r136 = null;
        goto L64
    L87:
        return;
    L11:
        r106 = null;
        goto L12
    L86:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onPopupEvent(ty6.d r100) {
        Intrinsics.checkNotNullParameter(r100, "sendEvent");
        if (Intrinsics.areEqual(r100.f547987a, "poi_moreview_collect_popup_send") == false) goto L6;
        vn6.b.a(new ty6.b());
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(PoiNaviMoreEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        throw null;
    }

    public final void a0(float r100, boolean r101) {
        if (this.V == true) goto L6;
        return;
    L6:
        if (this.R != 3) goto L12;
        if (r101 == true) goto L12;
        if (this.f262433y == true) goto L12;
        return;
    L12:
        if (r100 != 0.0f) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L34;
        View r103 = this.M;
        if (r103 == null) goto L20;
        r103.setAlpha(r100);
    L20:
        View r104 = this.M;
        if (r104 == null) goto L25;
        r104.setVisibility(4);
    L25:
        if (this.W == true) goto L53;
        View r105 = this.L;
        if (r105 == null) goto L30;
        r105.setAlpha(r100);
    L30:
        View r106 = this.L;
        if (r106 == null) goto L56;
        r106.setVisibility(4);
        return;
    L56:
        return;
    L53:
        return;
    L34:
        View r107 = this.M;
        if (r107 == null) goto L38;
        r107.setAlpha(r100);
    L38:
        View r108 = this.M;
        if (r108 == null) goto L43;
        r108.setVisibility(0);
    L43:
        if (this.W == true) goto L55;
        View r109 = this.L;
        if (r109 == null) goto L48;
        r109.setAlpha(r100);
    L48:
        View r110 = this.L;
        if (r110 == null) goto L57;
        r110.setVisibility(0);
        return;
    L57:
        return;
    L55:
        return;
    L14:
        r102 = false;
        goto L15
    }

    public final void f0(boolean r100, boolean r101) {
        int r102 = this.R;
        if (r102 > 2) goto L5;
    L9:
        setHeaderIconColor(r100);
        if (Intrinsics.areEqual(this.E, Boolean.valueOf(r100)) == true) goto L18;
        this.E = Boolean.valueOf(r100);
        Activity r103 = com.bytedance.locallife.poi.newdetail.t.a(this);
        if (r103 == null) goto L17;
        ImmersionBar.with(r103).statusBarDarkFont(r100).init();
        DitoDataCenter r104 = getDataCenter();
        int r105 = DitoDataCenter.f258004d;
        MutableLiveData<JSONObject> r106 = r104.a0("status_bar_font_dark", 1);
        JSONObject r107 = new JSONObject();
        r107.put("status_bar_font_dark", r100);
        r106.setValue(r107);
        return;
    L17:
        return;
    L18:
        return;
    L5:
        if (r102 == 4) goto L9;
        if (this.S == true) goto L9;
        if (r101 == true) goto L9;
    }

    public PoiDetailNavigationBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        com.bytedance.locallife.poi.newdetail.h r103 = com.bytedance.locallife.poi.newdetail.h.f263262a;
        int r104 = com.bytedance.locallife.poi.newdetail.h.i(r100);
        this.A = r104;
        this.B = r104 / 2;
        UIUtils.dip2Px(r100, 32.0f);
        this.C = (int) UIUtils.dip2Px(r100, 6.0f);
        this.G = UIUtils.getStatusBarHeight(r100);
        this.V = true;
    }
}
