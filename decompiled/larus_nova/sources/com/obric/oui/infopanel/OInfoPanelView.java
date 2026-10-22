package com.obric.oui.infopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.alipay.sdk.m.x.d;
import com.larus.nova.R;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/infopanel/OInfoPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/ImageView;", "getTopBannerView", "getTopImgView", "", "resId", "", "setInsetTopImg", "setUnInsetImg", "Landroid/view/ViewGroup;", "getCustomContainer", "", "title", d.f25925o, SocialConstants.PARAM_APP_DESC, "setDesc", "setScrollableDesc", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OInfoPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f401272i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f401273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f401274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f401275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f401276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OTextView f401277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OTextView f401278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NestedScrollView f401279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f401280h;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OInfoPanelView f401281a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            OInfoPanelView r100 = this.f401281a;
            int r101 = OInfoPanelView.f401272i;
            r100.getClass();
        }

        public a(OInfoPanelView r100, Context r101) {
            this.f401281a = r100;
        }
    }

    public final ImageView getTopBannerView() {
        this.f401273a.setPadding(0, 0, 0, 0);
        if (this.f401274b.getLayoutParams() == null) goto L10;
        ViewGroup r100 = this.f401274b;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L8;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        r102.setMargins(r102.leftMargin, pla.d.n(this, 24), r102.rightMargin, r102.bottomMargin);
        r100.setLayoutParams(r102);
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L10:
        return this.f401276d;
    }

    public final ImageView getTopImgView() {
        this.f401273a.setPadding(0, pla.d.n(this, 32), 0, 0);
        if (this.f401274b.getLayoutParams() == null) goto L10;
        ViewGroup r100 = this.f401274b;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L8;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        r102.setMargins(r102.leftMargin, pla.d.n(this, 16), r102.rightMargin, r102.bottomMargin);
        r100.setLayoutParams(r102);
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L10:
        return this.f401276d;
    }

    public final ViewGroup getCustomContainer() {
        return this.f401275c;
    }

    public OInfoPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setDesc(CharSequence r100) {
        if (r100 != null) goto L8;
        j.e(this.f401278f);
        ViewGroup.LayoutParams r101 = this.f401278f.getLayoutParams();
        if (r101 == null) goto L7;
        ((ViewGroup.MarginLayoutParams) r101).topMargin = 0;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L8:
        this.f401278f.setText(r100);
        j.f(this.f401278f);
    }

    public final void setInsetTopImg(int r100) {
        getTopBannerView().setImageResource(r100);
    }

    public final void setScrollableDesc(CharSequence r100) {
        setDesc(r100);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f401280h);
    }

    public final void setTitle(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f401277e.setText(r100);
    }

    public final void setUnInsetImg(int r100) {
        getTopImgView().setImageResource(r100);
    }

    public OInfoPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setMinimumHeight(pla.d.n(this, 290));
        ViewGroup.inflate(r100, R.layout.o_info_panel_frame, this);
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(-1, -2);
        setMinHeight(pla.d.n(this, 290));
        setLayoutParams(r102);
        this.f401273a = (ViewGroup) findViewById(R.id.header_container);
        this.f401274b = (ViewGroup) findViewById(R.id.content_container);
        this.f401279g = (NestedScrollView) findViewById(R.id.desc_container);
        this.f401275c = (ViewGroup) findViewById(R.id.custom_container);
        this.f401276d = (ImageView) findViewById(R.id.iv_illustration);
        this.f401277e = (OTextView) findViewById(R.id.tv_title);
        OTextView r103 = (OTextView) findViewById(R.id.tv_desc);
        r103.setLineHeight(MathKt.roundToInt(((double) r103.getTextSize()) * 1.4d));
        this.f401278f = r103;
        this.f401280h = new a(this, r100);
    }
}
