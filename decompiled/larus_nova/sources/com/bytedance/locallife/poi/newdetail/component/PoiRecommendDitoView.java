package com.bytedance.locallife.poi.newdetail.component;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.baseview.RoundLinearLayout;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.bytedance.locallife.model.poi.resp.SimplePoiInfoStruct;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiRecommendDitoView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/dito/model/a;", "Lat6/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiRecommendDitoView extends BaseDitoView<com.bytedance.locallife.dito.model.a> implements at6.c {
    public RelativeLayout A;
    public LinearLayout B;
    public RoundLinearLayout C;
    public AppCompatImageView D;
    public final Map<String, PoiRecommendDitoItemView> E;
    public int F;
    public List<SimplePoiInfoStruct> G;
    public PoiBundle H;
    public PoiDetail I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public com.bytedance.locallife.poi.newdetail.e f263124J;
    public final Set<String> K;
    public boolean L;
    public final at6.b M;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public DuxTextView f263125y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public DuxTextView f263126z;

    public static final class a {
    }

    static {
    }

    public PoiRecommendDitoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiRecommendDitoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // at6.c
    public final void OZ() {
        Intrinsics.checkNotNullParameter(null, "event");
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        super.P();
        if (this.L == false) goto L9;
        this.L = false;
        PoiBundle r100 = this.H;
        if (r100 == null) goto L10;
        oy6.a.f527136a.getClass();
        qt6.b r101 = HostServiceUtilsKt.S();
        r101.h();
        ((oy6.a) r101.create("https://life-service-open.scsjsd.com", oy6.a.class)).a(r100.poiId, 0, 3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h0(this));
        return;
    L10:
        return;
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        Object r100 = getDitoViewModel().A.get("poi_bundle");
        RoundLinearLayout r101 = null;
        if ((r100 instanceof PoiBundle) == false) goto L5;
        PoiBundle r102 = (PoiBundle) r100;
    L6:
        this.H = r102;
        Object r103 = getDitoViewModel().A.get("poi_detail");
        if ((r103 instanceof PoiDetail) == false) goto L9;
        PoiDetail r104 = (PoiDetail) r103;
    L10:
        this.I = r104;
        Object r105 = getDitoViewModel().A.get("card_style");
        if ((r105 instanceof com.bytedance.locallife.poi.newdetail.e) == false) goto L13;
        com.bytedance.locallife.poi.newdetail.e r106 = (com.bytedance.locallife.poi.newdetail.e) r105;
    L14:
        this.f263124J = r106;
        Object r107 = getDitoViewModel().A.get("inflater_manager");
        if ((r107 instanceof sy6.b) == false) goto L17;
        sy6.b r108 = (sy6.b) r107;
    L18:
        if (r108 == null) goto L20;
        View r109 = r108.a(getContext(), R.layout.saas_poi_component_collect_recommend, this);
    L21:
        int r110 = com.bytedance.locallife.poi.newdetail.e.f263241d;
        int[] r111 = com.bytedance.locallife.poi.newdetail.e.a.a(this.f263124J);
        int[] r112 = com.bytedance.locallife.poi.newdetail.e.a.b(this.f263124J);
        int r113 = com.bytedance.locallife.poi.newdetail.e.a.c(this.f263124J);
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-1, -2);
        r114.setMargins(MathKt.roundToInt(TypedValue.applyDimension(1, r111[0], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r111[1], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r111[2], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r111[3], a0(Resources.getSystem()))));
        addView(r109, r114);
        this.f263125y = (DuxTextView) findViewById(R.id.tv_guess_u_wanna_go);
        this.C = (RoundLinearLayout) findViewById(R.id.poi_component_container);
        this.A = (RelativeLayout) findViewById(R.id.poi_ll_collect_recommend);
        this.B = (LinearLayout) findViewById(R.id.poi_collect_recommend_list);
        this.D = (AppCompatImageView) findViewById(R.id.poi_collect_recommend_back);
        this.f263126z = (DuxTextView) findViewById(R.id.poi_collect_recommend_title);
        RelativeLayout r115 = this.A;
        if (r115 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("poi_ll_collect_recommend");
        r115 = null;
    L24:
        r115.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r112[0], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r112[1], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r112[2], a0(Resources.getSystem()))), 0);
        DuxTextView r116 = this.f263125y;
        if (r116 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("tv_guess_u_wanna_go");
        r116 = null;
    L27:
        r116.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r112[0], a0(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r112[0], a0(Resources.getSystem()))), 0);
        LinearLayout r117 = this.B;
        if (r117 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("poi_collect_recommend_list");
        r117 = null;
    L30:
        r117.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r112[0], a0(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r112[2], a0(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r112[3] - 8, a0(Resources.getSystem()))));
        RoundLinearLayout r118 = this.C;
        if (r118 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("poi_component_container");
    L34:
        r101.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r113, a0(Resources.getSystem()))));
        this.M.b(this);
        return;
    L33:
        r101 = r118;
        goto L34
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
        this.M.a(this);
    }

    public static DisplayMetrics a0(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // at6.c
    public final void Pd(String r100, JSONObject r101) {
        at6.c.a.a(r100, r101);
    }

    public PoiRecommendDitoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.E = new LinkedHashMap();
        this.K = new LinkedHashSet();
        this.L = true;
        this.M = HostServiceUtilsKt.x();
    }

    public /* synthetic */ PoiRecommendDitoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
