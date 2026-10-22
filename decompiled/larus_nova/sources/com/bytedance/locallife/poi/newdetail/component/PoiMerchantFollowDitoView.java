package com.bytedance.locallife.poi.newdetail.component;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.baseview.RoundLinearLayout;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.bytedance.locallife.poi.experiment.PoiBigFontExperiment;
import com.bytedance.locallife.poi.newdetail.widget.CircleImageView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\fB%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiMerchantFollowDitoView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/poi/newdetail/component/j;", "Lat6/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiMerchantFollowDitoView extends BaseDitoView<j> implements at6.c {
    public com.bytedance.locallife.poi.newdetail.e A;
    public boolean B;
    public boolean C;
    public int D;
    public View E;
    public DuxTextView F;
    public AppCompatImageView G;
    public LinearLayout H;
    public CircleImageView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public AppCompatImageView f263067J;
    public DuxTextView K;
    public DuxTextView L;
    public DuxTextView M;
    public final at6.b N;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PoiBundle f263068y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PoiDetail f263069z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f263070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiMerchantFollowDitoView f263071b;

        public b(DuxTextView r100, PoiMerchantFollowDitoView r101) {
            this.f263070a = r100;
            this.f263071b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            if (com.bytedance.locallife.common.utils.g.a(this.f263070a) == false) goto L5;
            return;
        L5:
            List r111 = CollectionsKt.listOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "follow_business"));
            Activity r100 = com.bytedance.locallife.poi.newdetail.t.a(this.f263071b);
            if (r100 == null) goto L12;
            View r101 = this.f263071b.E;
            if (r101 == null) goto L10;
            String r102 = com.bytedance.locallife.biz.btm.c.c(r101, "c915985.d10027", null, false, false, null, 60);
        L11:
            yt6.a r103 = HostServiceUtilsKt.a0();
            ws6.a r104 = HostServiceUtilsKt.t();
            ConcurrentHashMap<String, Object> r105 = this.f263071b.getDitoViewModel().A;
            r104.g0(r111, "aweme://favorite?enter_from=poi_page&enter_method=click_favourite_hint&tab_name=location&source_btm_token=" + r102);
            r103.d(r100, "").a();
            goto L12
        L10:
            r102 = null;
        L12:
            PoiMerchantFollowDitoView.b0(this.f263071b, "click_favourite_hint");
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f263072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiMerchantFollowDitoView f263073b;

        public c(AppCompatImageView r100, PoiMerchantFollowDitoView r101) {
            this.f263072a = r100;
            this.f263073b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.locallife.common.utils.g.a(this.f263072a) == false) goto L5;
            return;
        L5:
            PoiMerchantFollowDitoView.b0(this.f263073b, "close_poi_bar");
            PoiMerchantFollowDitoView r101 = this.f263073b;
            r101.getClass();
            r101.post(new l(r101));
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f263074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiMerchantFollowDitoView f263075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PoiMerchantFollowData f263076c;

        public d(View r100, PoiMerchantFollowDitoView r101, PoiMerchantFollowData r102) {
            this.f263074a = r100;
            this.f263075b = r101;
            this.f263076c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.locallife.common.utils.g.a(this.f263074a) == false) goto L5;
            return;
        L5:
            PoiMerchantFollowDitoView.b0(this.f263075b, "enter_personal_detail");
            Activity r101 = com.bytedance.locallife.poi.newdetail.t.a(this.f263075b);
            if (r101 == null) goto L16;
            String r102 = this.f263076c.getMerchantPage();
            if (r102 == null) goto L12;
            boolean r103 = true;
            if (com.bytedance.locallife.common.utils.j.a(r102) != true) goto L12;
        L13:
            if (r103 == false) goto L17;
            yt6.a r104 = HostServiceUtilsKt.a0();
            String r105 = this.f263076c.getMerchantPage();
            Intrinsics.checkNotNull(r105);
            r104.d(r101, r105).a();
            return;
        L17:
            return;
        L12:
            r103 = false;
            goto L13
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f263077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiMerchantFollowDitoView f263078b;

        public e(DuxTextView r100, PoiMerchantFollowDitoView r101) {
            this.f263077a = r100;
            this.f263078b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.locallife.common.utils.g.a(this.f263077a) == false) goto L5;
            return;
        L5:
            PoiMerchantFollowDitoView r101 = this.f263078b;
            if (r101.B == true) goto L22;
            PoiMerchantFollowDitoView.b0(r101, "follow");
            PoiMerchantFollowDitoView r102 = this.f263078b;
            r102.B = true;
            j r103 = r102.getModel();
            if (r103 == null) goto L23;
            PoiMerchantFollowData r104 = r103.c();
            if (r104 == null) goto L24;
            String r105 = r104.getMerchantUserid();
            if (r105 == null) goto L25;
            j r106 = r102.getModel();
            if (r106 == null) goto L19;
            PoiMerchantFollowData r107 = r106.c();
            if (r107 == null) goto L19;
            boolean r108 = r107.getFollowed();
        L20:
            qt6.b r109 = HostServiceUtilsKt.S();
            r109.h();
            ((oy6.g) r109.create("https://life-service-open.scsjsd.com", oy6.g.class)).a(r105, !r108, 178, 68, 0, 300087).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r102, r108));
            return;
        L19:
            r108 = 0;
            goto L20
        L25:
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    static {
    }

    @Override // at6.c
    public final void OZ() {
        Intrinsics.checkNotNullParameter(null, "event");
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        super.P();
        getDataCenter().a0("insert_component_type", 1).setValue(new JSONObject().put("insert_component_type", "poi_detail_merchant_follow"));
        boolean r100 = false;
        if (this.C == false) goto L39;
        this.C = false;
        j r101 = getModel();
        if (r101 == null) goto L38;
        PoiMerchantFollowData r102 = r101.c();
        if (r102 == null) goto L38;
        DuxTextView r103 = this.F;
        if (r103 == null) goto L11;
        r103.setOnClickListener(new b(r103, this));
    L11:
        AppCompatImageView r104 = this.G;
        if (r104 == null) goto L14;
        r104.setOnClickListener(new c(r104, this));
    L14:
        LinearLayout r105 = this.H;
        if (r105 == null) goto L17;
        r105.setOnClickListener(new d(r105, this, r102));
    L17:
        rp6.a.a(this.I, r102.getAvatarUrl());
        if (r102.getCertified() == false) goto L23;
        AppCompatImageView r106 = this.f263067J;
        if (r106 == null) goto L27;
        r106.setVisibility(0);
    L27:
        DuxTextView r107 = this.K;
        if (r107 == null) goto L31;
        r107.setText(r102.getName());
    L31:
        DuxTextView r108 = this.L;
        if (r108 == null) goto L35;
        r108.setText(r102.getContent());
    L35:
        d0(r102.getFollowed());
        DuxTextView r109 = this.M;
        if (r109 == null) goto L38;
        r109.setOnClickListener(new e(r109, this));
        goto L38
    L23:
        AppCompatImageView r110 = this.f263067J;
        if (r110 == null) goto L27;
        r110.setVisibility(4);
    L38:
        post(new m(this));
        return;
    L39:
        j r111 = getModel();
        if (r111 == null) goto L44;
        PoiMerchantFollowData r112 = r111.c();
        if (r112 == null) goto L44;
        r100 = r112.getFollowed();
    L44:
        d0(r100);
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        this.N.b(this);
        Object r100 = getDitoViewModel().A.get("poi_bundle");
        Paint r101 = null;
        if ((r100 instanceof PoiBundle) == false) goto L5;
        PoiBundle r102 = (PoiBundle) r100;
    L6:
        this.f263068y = r102;
        Object r103 = getDitoViewModel().A.get("poi_detail");
        if ((r103 instanceof PoiDetail) == false) goto L9;
        PoiDetail r104 = (PoiDetail) r103;
    L10:
        this.f263069z = r104;
        Object r105 = getDitoViewModel().A.get("card_style");
        if ((r105 instanceof com.bytedance.locallife.poi.newdetail.e) == false) goto L13;
        com.bytedance.locallife.poi.newdetail.e r106 = (com.bytedance.locallife.poi.newdetail.e) r105;
    L14:
        this.A = r106;
        Object r107 = getDitoViewModel().A.get("inflater_manager");
        if ((r107 instanceof sy6.b) == false) goto L17;
        sy6.b r108 = (sy6.b) r107;
    L18:
        if (r108 == null) goto L20;
        View r109 = r108.a(getContext(), R.layout.saas_poi_component_merchant_follow, this);
    L21:
        this.E = r109;
        if (r109 == null) goto L24;
        DuxTextView r110 = (DuxTextView) r109.findViewById(R.id.poi_merchant_follow_tip);
    L25:
        this.F = r110;
        View r111 = this.E;
        if (r111 == null) goto L28;
        AppCompatImageView r112 = (AppCompatImageView) r111.findViewById(R.id.poi_merchant_follow_close);
    L29:
        this.G = r112;
        View r113 = this.E;
        if (r113 == null) goto L32;
        LinearLayout r114 = (LinearLayout) r113.findViewById(R.id.poi_merchant_follow_info);
    L33:
        this.H = r114;
        View r115 = this.E;
        if (r115 == null) goto L36;
        CircleImageView r116 = (CircleImageView) r115.findViewById(R.id.poi_merchant_follow_avatar);
    L37:
        this.I = r116;
        View r117 = this.E;
        if (r117 == null) goto L40;
        AppCompatImageView r118 = (AppCompatImageView) r117.findViewById(R.id.poi_merchant_follow_certified);
    L41:
        this.f263067J = r118;
        View r119 = this.E;
        if (r119 == null) goto L44;
        DuxTextView r120 = (DuxTextView) r119.findViewById(R.id.poi_merchant_follow_name);
    L45:
        this.K = r120;
        View r121 = this.E;
        if (r121 == null) goto L48;
        DuxTextView r122 = (DuxTextView) r121.findViewById(R.id.poi_merchant_follow_intro);
    L49:
        this.L = r122;
        View r123 = this.E;
        if (r123 == null) goto L52;
        DuxTextView r124 = (DuxTextView) r123.findViewById(R.id.poi_merchant_follow_button);
    L53:
        this.M = r124;
        int r125 = com.bytedance.locallife.poi.newdetail.e.f263241d;
        int[] r126 = com.bytedance.locallife.poi.newdetail.e.a.a(this.A);
        int[] r127 = com.bytedance.locallife.poi.newdetail.e.a.b(this.A);
        int r128 = com.bytedance.locallife.poi.newdetail.e.a.c(this.A);
        FrameLayout.LayoutParams r129 = new FrameLayout.LayoutParams(-1, -2);
        r129.setMargins(MathKt.roundToInt(TypedValue.applyDimension(1, r126[0], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r126[1], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r126[2], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r126[3], a0(Resources.getSystem()))));
        addView(this.E, r129);
        View r130 = this.E;
        if (r130 == null) goto L56;
        r130.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r127[0], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r127[1], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r127[2], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r127[3], a0(Resources.getSystem()))));
    L56:
        View r131 = this.E;
        if ((r131 instanceof RoundLinearLayout) == false) goto L59;
        RoundLinearLayout r132 = (RoundLinearLayout) r131;
    L60:
        if (r132 == null) goto L62;
        r132.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r128, a0(Resources.getSystem()))));
    L62:
        DuxTextView r133 = this.F;
        if (r133 == null) goto L65;
        Paint r134 = r133.getPaint();
    L66:
        c0(r134);
        DuxTextView r135 = this.K;
        if (r135 == null) goto L69;
        Paint r136 = r135.getPaint();
    L70:
        c0(r136);
        DuxTextView r137 = this.M;
        if (r137 == null) goto L73;
        r101 = r137.getPaint();
    L73:
        c0(r101);
        DuxTextView r138 = this.F;
        if (r138 == null) goto L76;
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r138, 12.0f);
    L76:
        DuxTextView r139 = this.K;
        if (r139 == null) goto L79;
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r139, 14.0f);
    L79:
        DuxTextView r140 = this.L;
        if (r140 == null) goto L82;
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r140, 12.0f);
    L82:
        DuxTextView r141 = this.M;
        if (r141 == null) goto L86;
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r141, 14.0f);
    L86:
        if (PoiBigFontExperiment.a() == false) goto L91;
        DuxTextView r142 = this.M;
        if (r142 == null) goto L92;
        com.bytedance.dux.largefont.a.a(r142, 64, 28);
        return;
    L92:
        return;
    L91:
        return;
    L69:
        r136 = null;
        goto L70
    L65:
        r134 = null;
        goto L66
    L59:
        r132 = null;
        goto L60
    L52:
        r124 = null;
        goto L53
    L48:
        r122 = null;
        goto L49
    L44:
        r120 = null;
        goto L45
    L40:
        r118 = null;
        goto L41
    L36:
        r116 = null;
        goto L37
    L32:
        r114 = null;
        goto L33
    L28:
        r112 = null;
        goto L29
    L24:
        r110 = null;
        goto L25
    L20:
        r109 = null;
        goto L21
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
        this.N.a(this);
    }

    public static DisplayMetrics a0(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void c0(Paint r100) {
        if (Build.VERSION.SDK_INT < 28) goto L14;
        if (r100 == null) goto L15;
        Typeface r101 = r100.getTypeface();
        Typeface r102 = r100.getTypeface();
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        r100.setTypeface(Typeface.create(r101, 500, r103));
        return;
    L9:
        if (r102.getStyle() != 2) goto L11;
        r103 = true;
        goto L12
    L15:
        return;
    }

    public final void d0(boolean r100) {
        DuxTextView r101 = this.M;
        if (r101 == null) goto L9;
        if (r100 == false) goto L7;
        Drawable r102 = com.bytedance.locallife.dito.utils.o.a(new PoiMerchantFollowDitoView$getRoundBgDrawable$1(this));
    L8:
        r101.setBackground(r102);
        goto L9
    L7:
        r102 = com.bytedance.locallife.dito.utils.o.a(new PoiMerchantFollowDitoView$getRoundBgDrawable$2(this));
    L9:
        CharSequence r103 = null;
        if (r100 == false) goto L21;
        DuxTextView r104 = this.M;
        if (r104 == null) goto L18;
        Context r105 = getContext();
        if (r105 == null) goto L17;
        r103 = r105.getText(R.string.poi_detail_merchant_followed);
    L17:
        r104.setText(r103);
    L18:
        DuxTextView r106 = this.M;
        if (r106 == null) goto L32;
        r106.setTextColor(ContextCompat.getColor(getContext(), R.color.POIPrimary2));
        return;
    L32:
        return;
    L21:
        DuxTextView r107 = this.M;
        if (r107 == null) goto L28;
        Context r108 = getContext();
        if (r108 == null) goto L27;
        r103 = r108.getText(R.string.poi_detail_merchant_follow);
    L27:
        r107.setText(r103);
    L28:
        DuxTextView r109 = this.M;
        if (r109 == null) goto L34;
        r109.setTextColor(ContextCompat.getColor(getContext(), R.color.POIBgPrimary));
        return;
    }

    public static final void b0(PoiMerchantFollowDitoView r100, String r101) {
        r100.getClass();
        int r102 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r103 = new mq6.c();
        mq6.a r104 = mq6.c.a.f514894a;
        r103.g("enter_from", "poi_page");
        r103.g("enter_method", DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);
        PoiBundle r105 = r100.f263068y;
        String r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.from;
    L6:
        r103.g("poi_enter_page", r107);
        PoiBundle r108 = r100.f263068y;
        if (r108 == null) goto L9;
        String r109 = r108.enterMethod;
    L10:
        r103.g(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r109);
        PoiBundle r110 = r100.f263068y;
        if (r110 == null) goto L13;
        String r111 = r110.sessionId;
    L14:
        r103.g("poi_enter_id", r111);
        PoiDetail r112 = r100.f263069z;
        if (r112 == null) goto L17;
        String r113 = r112.getBackendType();
    L18:
        r103.g("poi_backend_type", r113);
        PoiDetail r114 = r100.f263069z;
        if (r114 == null) goto L21;
        String r115 = r114.getPoiId();
    L22:
        r103.g("poi_id", r115);
        j r116 = r100.getModel();
        if (r116 == null) goto L27;
        PoiMerchantFollowData r117 = r116.c();
        if (r117 == null) goto L27;
        String r118 = r117.getMerchantUserid();
    L28:
        r103.g("merchant_user_id", r118);
        j r119 = r100.getModel();
        if (r119 == null) goto L33;
        PoiMerchantFollowData r120 = r119.c();
        if (r120 == null) goto L33;
        String r121 = r120.getMerchantUserid();
    L34:
        r103.g(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r121);
        j r122 = r100.getModel();
        if (r122 == null) goto L39;
        PoiMerchantFollowData r123 = r122.c();
        if (r123 == null) goto L39;
        r106 = r123.getMerchantAccountId();
    L39:
        r103.g("account_id", r106);
        r103.g(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "follow_type");
        com.bytedance.locallife.biz.mob.a.C3646a.c(r101, r103.f514893a);
        return;
    L33:
        r121 = null;
    L27:
        r118 = null;
        goto L28
    L21:
        r115 = null;
        goto L22
    L17:
        r113 = null;
        goto L18
    L13:
        r111 = null;
        goto L14
    L9:
        r109 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }

    @Override // at6.c
    public final void Pd(String r100, JSONObject r101) {
        at6.c.a.a(r100, r101);
    }

    public PoiMerchantFollowDitoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.C = true;
        this.N = HostServiceUtilsKt.x();
    }
}
