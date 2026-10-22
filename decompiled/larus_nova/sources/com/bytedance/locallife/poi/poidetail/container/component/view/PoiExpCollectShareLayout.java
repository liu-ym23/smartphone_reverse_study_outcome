package com.bytedance.locallife.poi.poidetail.container.component.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.dito.baseview.RoundFrameLayout;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.poi.experiment.PoiBigFontExperiment;
import com.bytedance.locallife.poi.poidetail.container.mob.h;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/component/view/PoiExpCollectShareLayout;", "Lcom/bytedance/locallife/dito/baseview/RoundFrameLayout;", "", GXTemplateKey.FLEXBOX_PADDING, "", "setCardPadding", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoViewModel;", "m", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoViewModel;", "getViewModel", "()Lcom/bytedance/locallife/dito/core/viewmodel/DitoViewModel;", "setViewModel", "(Lcom/bytedance/locallife/dito/core/viewmodel/DitoViewModel;)V", "viewModel", "Lcom/bytedance/locallife/biz/mob/a;", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/locallife/biz/mob/a;", "getEtKit", "()Lcom/bytedance/locallife/biz/mob/a;", "setEtKit", "(Lcom/bytedance/locallife/biz/mob/a;)V", "etKit", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiExpCollectShareLayout extends RoundFrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f263770p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f263771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f263772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DuxTextView f263773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f263774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f263775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f263776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f263777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f263778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f263779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DitoViewModel f263780m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.locallife.biz.mob.a f263781n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f263782o;

    public static final class a {
    }

    static {
    }

    public PoiExpCollectShareLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, null, 14);
    }

    public PoiExpCollectShareLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, null, 12);
    }

    public PoiExpCollectShareLayout(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, null, 8);
    }

    public final com.bytedance.locallife.biz.mob.a getEtKit() {
        return this.f263781n;
    }

    public final DitoViewModel getViewModel() {
        return this.f263780m;
    }

    public final void setCardPadding(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.FLEXBOX_PADDING);
        View r101 = this.f263771d;
        if (r101 == null) goto L6;
        float r102 = r100[0];
        Resources r103 = Resources.getSystem();
        int r104 = MathKt.roundToInt(TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        float r105 = r100[1];
        Resources r106 = Resources.getSystem();
        int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, r105, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics())));
        float r108 = r100[2];
        Resources r109 = Resources.getSystem();
        int r110 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics())));
        float r111 = r100[3];
        Resources r112 = Resources.getSystem();
        r101.setPadding(r104, r107, r110, MathKt.roundToInt(TypedValue.applyDimension(1, r111, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()))));
        return;
    }

    public final void setEtKit(com.bytedance.locallife.biz.mob.a r100) {
        this.f263781n = r100;
    }

    public final void setViewModel(DitoViewModel r100) {
        this.f263780m = r100;
    }

    public PoiExpCollectShareLayout(Context r100, AttributeSet r101, int r102, sy6.b r103, int r104) {
        View r105 = null;
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r103 == null) goto L14;
        View r106 = r103.a(r100, R.layout.saas_poi_item_exp_collect_share, this);
    L15:
        if (r106 == null) goto L17;
        View r107 = r106.findViewById(R.id.container);
    L18:
        this.f263771d = r107;
        if (r106 == null) goto L21;
        View r108 = r106.findViewById(R.id.title_container);
    L22:
        this.f263772e = r108;
        if (r106 == null) goto L25;
        DuxTextView r109 = (DuxTextView) r106.findViewById(R.id.poi_collect_share_title);
    L26:
        this.f263773f = r109;
        if (r106 == null) goto L29;
        DuxTextView r110 = (DuxTextView) r106.findViewById(R.id.share_button_text);
    L30:
        if (r110 == null) goto L32;
        h.a(r110, 15.0f);
    L32:
        if (r106 == null) goto L34;
        View r111 = r106.findViewById(R.id.close_image_view);
    L35:
        this.f263774g = r111;
        if (r106 == null) goto L38;
        View r112 = r106.findViewById(R.id.avatar_container);
    L39:
        this.f263775h = r112;
        if (r106 == null) goto L42;
        View r113 = r106.findViewById(R.id.one_avatar_container);
    L43:
        this.f263776i = r113;
        if (r106 == null) goto L46;
        View r114 = r106.findViewById(R.id.two_avatar_container);
    L47:
        this.f263777j = r114;
        if (r106 == null) goto L50;
        View r115 = r106.findViewById(R.id.three_avatar_container);
    L51:
        this.f263778k = r115;
        if (r106 == null) goto L54;
        r105 = r106.findViewById(R.id.share_button);
    L54:
        this.f263779l = r105;
        if (PoiBigFontExperiment.a() == false) goto L58;
        if (r105 == null) goto L58;
        com.bytedance.dux.largefont.a.a(r105, 165, 36);
    L58:
        addView(r106);
        return;
    L50:
        r115 = null;
        goto L51
    L46:
        r114 = null;
        goto L47
    L42:
        r113 = null;
        goto L43
    L38:
        r112 = null;
        goto L39
    L34:
        r111 = null;
        goto L35
    L29:
        r110 = null;
        goto L30
    L25:
        r109 = null;
        goto L26
    L21:
        r108 = null;
        goto L22
    L17:
        r107 = null;
        goto L18
    L14:
        r106 = null;
        goto L15
    }
}
