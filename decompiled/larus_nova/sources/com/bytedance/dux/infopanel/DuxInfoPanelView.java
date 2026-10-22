package com.bytedance.dux.infopanel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.x.d;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.text.DuxTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import em4.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/dux/infopanel/DuxInfoPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "colorRes", "", "setBackgroundColorRes", "setTitleColor", "setDescColor", "Landroid/widget/ImageView;", "getTopBannerView", "getTopImgView", "resId", "setInsetTopImg", "setUnInsetImg", "Landroid/view/ViewGroup;", "getCustomContainer", GXTemplateKey.FLEXBOX_PADDING, "setContentContainerHorizontalPadding", "", "title", d.f25925o, "height", "setTitleLineHeight", "Lcom/bytedance/dux/text/DuxTextView$TextSpec;", "spec", "setTitleTextSpec", SocialConstants.PARAM_APP_DESC, "setDesc", "setDescTextSpec", "setScrollableDesc", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxInfoPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f205227i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f205228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f205229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f205230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f205231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DuxTextView f205232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DuxTextView f205233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NestedScrollView f205234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ul4.a f205235h;

    public static final class a {
    }

    public DuxInfoPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DuxInfoPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    static {
        DuxComponent r100 = DuxComponent.DIALOG;
    }

    public final ImageView getTopBannerView() {
        this.f205228a.setPadding(0, 0, 0, 0);
        return this.f205231d;
    }

    public final ImageView getTopImgView() {
        ViewGroup r100 = this.f205228a;
        Resources r101 = Resources.getSystem();
        r100.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 32, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()))), 0, 0);
        return this.f205231d;
    }

    public final ViewGroup getCustomContainer() {
        return this.f205230c;
    }

    public final void setBackgroundColorRes(int r100) {
        setBackgroundColor(ContextCompat.getColor(getContext(), r100));
    }

    public final void setContentContainerHorizontalPadding(int r100) {
        this.f205229b.setPadding(r100, getTopPaddingOffset(), r100, getBottomPaddingOffset());
    }

    public final void setDesc(CharSequence r100) {
        if (r100 != null) goto L4;
        n.e(this.f205233f);
        ViewGroup.LayoutParams r101 = this.f205233f.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r101).topMargin = 0;
        return;
    L4:
        this.f205233f.setText(r100);
        n.f(this.f205233f);
    }

    public final void setDescColor(int r100) {
        this.f205233f.setTextColor(ContextCompat.getColor(getContext(), r100));
    }

    public final void setDescTextSpec(DuxTextView.TextSpec r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        this.f205233f.setTextSpec(r100);
    }

    public final void setInsetTopImg(int r100) {
        getTopBannerView().setImageResource(r100);
    }

    public final void setScrollableDesc(CharSequence r100) {
        setDesc(r100);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f205235h);
    }

    public final void setTitle(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f205232e.setText(r100);
    }

    public final void setTitleColor(int r100) {
        this.f205232e.setTextColor(ContextCompat.getColor(getContext(), r100));
    }

    public final void setTitleLineHeight(int r100) {
        this.f205232e.setLineHeight(r100);
    }

    public final void setTitleTextSpec(DuxTextView.TextSpec r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        this.f205232e.setTextSpec(r100);
    }

    public final void setUnInsetImg(int r100) {
        getTopImgView().setImageResource(r100);
    }

    public DuxInfoPanelView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setMinimumHeight(0);
        ViewGroup.inflate(r100, R.layout.dux_info_panel_frame, this);
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(-1, -2);
        setMinHeight(0);
        setLayoutParams(r103);
        this.f205228a = (ViewGroup) findViewById(R.id.header_container);
        this.f205229b = (ViewGroup) findViewById(R.id.content_container);
        this.f205234g = (NestedScrollView) findViewById(R.id.desc_container);
        this.f205230c = (ViewGroup) findViewById(R.id.custom_container);
        this.f205231d = (ImageView) findViewById(R.id.iv_illustration);
        this.f205232e = (DuxTextView) findViewById(R.id.tv_title);
        DuxTextView r104 = (DuxTextView) findViewById(R.id.tv_desc);
        r104.setLineHeight(MathKt.roundToInt(((double) r104.getTextSize()) * 1.4d));
        this.f205233f = r104;
        this.f205235h = new ul4.a(this, r100);
    }
}
