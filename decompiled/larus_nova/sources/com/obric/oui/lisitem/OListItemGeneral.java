package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\"\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010m\u001a\u00020l\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010n¢\u0006\u0004\bp\u0010qJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020*8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010F\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010>8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER.\u0010J\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010>8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010A\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER.\u0010Q\u001a\u0004\u0018\u00010\n2\b\u0010?\u001a\u0004\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR.\u0010U\u001a\u0004\u0018\u00010\n2\b\u0010?\u001a\u0004\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010L\u001a\u0004\bS\u0010N\"\u0004\bT\u0010PR*\u0010\\\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R*\u0010`\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010W\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R*\u0010h\u001a\u00020a2\u0006\u0010?\u001a\u00020a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR*\u0010i\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010W\u001a\u0004\bj\u0010Y\"\u0004\bk\u0010[¨\u0006r"}, d2 = {"Lcom/obric/oui/lisitem/OListItemGeneral;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "enabled", "", "setAlpha", "Landroid/view/View;", "view", "setLeadingView", "setTrailingView", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImageView", "", "getContentDefaultOneChildWidth", "selected", "setSelected", "setEnabled", "Landroid/widget/FrameLayout;", "h", "Landroid/widget/FrameLayout;", "getMLeadingElement", "()Landroid/widget/FrameLayout;", "setMLeadingElement", "(Landroid/widget/FrameLayout;)V", "mLeadingElement", RXScreenCaptureService.KEY_INDEX, "getMTrailingElement", "setMTrailingElement", "mTrailingElement", ce.f26395j, "getMContentElement", "setMContentElement", "mContentElement", "Landroid/widget/ImageView;", ce.f26396k, "Landroid/widget/ImageView;", "getMIvContent", "()Landroid/widget/ImageView;", "setMIvContent", "(Landroid/widget/ImageView;)V", "mIvContent", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvTitle", "m", "getMTvSubtitle", "setMTvSubtitle", "mTvSubtitle", "Landroidx/constraintlayout/widget/ConstraintLayout;", OfficeSDKRequestTag.KEY_NEW_USER, "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMClContent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMClContent", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mClContent", "", "value", "o", "Ljava/lang/CharSequence;", "getTitleString", "()Ljava/lang/CharSequence;", "setTitleString", "(Ljava/lang/CharSequence;)V", "titleString", "p", "getSubTitleString", "setSubTitleString", "subTitleString", "q", "Landroid/graphics/drawable/Drawable;", "getContentImage", "()Landroid/graphics/drawable/Drawable;", "setContentImage", "(Landroid/graphics/drawable/Drawable;)V", "contentImage", "r", "getTrailingImage", "setTrailingImage", "trailingImage", "s", "Z", "getShowPreDefineBackground", "()Z", "setShowPreDefineBackground", "(Z)V", "showPreDefineBackground", "t", "getShowDivider", "setShowDivider", "showDivider", "", "u", FaceService.girlLabel, "getMContentElementWidth", "()F", "setMContentElementWidth", "(F)V", "mContentElementWidth", "showBackground", "getShowBackground", "setShowBackground", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OListItemGeneral extends OUIFrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f401355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f401356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f401357j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f401358k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f401359l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f401360m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConstraintLayout f401361n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f401362o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f401363p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f401364q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f401365r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f401366s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f401367t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f401368u;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f401369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f401370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OListItemGeneral f401371c;

        public a(View r100, boolean r101, OListItemGeneral r102) {
            this.f401369a = r100;
            this.f401370b = r101;
            this.f401371c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (this.f401370b == false) goto L5;
            OListItemGeneral r100 = this.f401371c;     // Catch: Throwable -> L7
            int r101 = r100.getMClContent().getLeft();     // Catch: Throwable -> L7
            int r102 = pla.d.l(this.f401371c, 0.6d);     // Catch: Throwable -> L7
            int r103 = this.f401371c.getResources().getColor(R.color.oui_line_2);     // Catch: Throwable -> L7
            r100.f401297b.H(r101, r102, r103);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            OListItemGeneral r104 = this.f401371c;     // Catch: Throwable -> L7
            int r105 = r104.getMClContent().getLeft();     // Catch: Throwable -> L7
            r104.f401297b.H(r105, 0, R.color.oui_line_2);     // Catch: Throwable -> L7
            goto L12
        }
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public final boolean S() {
        return true;
    }

    public final ConstraintLayout getMClContent() {
        ConstraintLayout r100 = this.f401361n;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mClContent");
        return null;
    }

    public final FrameLayout getMContentElement() {
        FrameLayout r100 = this.f401357j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mContentElement");
        return null;
    }

    public final ImageView getMIvContent() {
        ImageView r100 = this.f401358k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mIvContent");
        return null;
    }

    public final FrameLayout getMLeadingElement() {
        FrameLayout r100 = this.f401355h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeadingElement");
        return null;
    }

    public final FrameLayout getMTrailingElement() {
        FrameLayout r100 = this.f401356i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTrailingElement");
        return null;
    }

    public final TextView getMTvSubtitle() {
        TextView r100 = this.f401360m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTvSubtitle");
        return null;
    }

    public final TextView getMTvTitle() {
        TextView r100 = this.f401359l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        return null;
    }

    public void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_general, this);
    }

    public final void f() {
        FrameLayout r100 = getMContentElement();
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r101 = r100.getChildCount();
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L9;
        int r104 = r103 + 1;
        if (r100.getChildAt(r103).getVisibility() == 0) goto L7;
        r103 = r104;
        goto L4
    L7:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        com.obric.oui.indicator.d.c(getMContentElement(), getContentDefaultOneChildWidth());
    L14:
        if (this.f401368u != 0.0f) goto L16;
        r102 = true;
    L16:
        if (r102 == true) goto L21;
        com.obric.oui.indicator.d.c(getMContentElement(), (int) this.f401368u);
        return;
    L21:
        return;
    L12:
        com.obric.oui.indicator.d.c(getMContentElement(), MathKt.roundToInt(getResources().getDimension(R.dimen.oui_listitem_content_width_empty)));
        goto L14
    L9:
        r105 = false;
        goto L10
    }

    public int getContentDefaultOneChildWidth() {
        return MathKt.roundToInt(getResources().getDimension(R.dimen.oui_listitem_content_width_middle));
    }

    public final Drawable getContentImage() {
        return this.f401364q;
    }

    public final float getMContentElementWidth() {
        return this.f401368u;
    }

    public final boolean getShowBackground() {
        return this.f401366s;
    }

    public final boolean getShowDivider() {
        return this.f401367t;
    }

    public final boolean getShowPreDefineBackground() {
        return this.f401366s;
    }

    public final CharSequence getSubTitleString() {
        return this.f401363p;
    }

    public final CharSequence getTitleString() {
        return this.f401362o;
    }

    public final Drawable getTrailingImage() {
        return this.f401365r;
    }

    public OListItemGeneral(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    public final void setAlpha(boolean r100) {
        if (r100 == true) goto L4;
        float r101 = 0.3f;
    L5:
        setAlpha(r101);
        return;
    L4:
        r101 = 1.0f;
        goto L5
    }

    public final void setContentImage(Drawable r100) {
        this.f401364q = r100;
        if (r100 == null) goto L5;
        getMIvContent().setImageDrawable(this.f401364q);
        getMIvContent().setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        f();
        return;
    L5:
        getMIvContent().setVisibility(8);
        goto L6
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    public final void setLeadingView(View r100) {
        if (r100 == null) goto L5;
        e(getMLeadingElement(), r100, null);
        return;
    }

    public final void setMClContent(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401361n = r100;
    }

    public final void setMContentElement(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401357j = r100;
    }

    public final void setMContentElementWidth(float r100) {
        this.f401368u = r100;
        if (r100 != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        com.obric.oui.indicator.d.c(getMContentElement(), (int) r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setMIvContent(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401358k = r100;
    }

    public final void setMLeadingElement(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401355h = r100;
    }

    public final void setMTrailingElement(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401356i = r100;
    }

    public final void setMTvSubtitle(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401360m = r100;
    }

    public final void setMTvTitle(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401359l = r100;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        getAlphaHelper().Y4(this, r100);
    }

    public final void setShowBackground(boolean r100) {
        setShowPreDefineBackground(r100);
    }

    public final void setShowDivider(boolean r100) {
        this.f401367t = r100;
        OneShotPreDrawListener.add(this, new a(this, r100, this));
    }

    public final void setShowPreDefineBackground(boolean r100) {
        this.f401366s = r100;
        if (getBackground() != null) goto L9;
        ColorDrawable r101 = null;
        if (r100 == false) goto L7;
        r101 = new ColorDrawable(getResources().getColor(R.color.oui_fill_list_item_card, null));
    L7:
        setBackground(r101);
        return;
    }

    public final void setSubTitleString(CharSequence r100) {
        this.f401363p = r100;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        j.e(getMTvSubtitle());
        return;
    L5:
        j.f(getMTvSubtitle());
        getMTvSubtitle().setText(this.f401363p);
    }

    public final void setTitleString(CharSequence r100) {
        this.f401362o = r100;
        getMTvTitle().setText(r100);
    }

    public final void setTrailingImage(Drawable r100) {
        this.f401365r = r100;
        setTrailingImageView(r100);
    }

    public final void setTrailingImageView(Drawable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ImageView r101 = new ImageView(getContext());
        r101.setImageDrawable(r100);
        setTrailingView(r101);
    }

    public final void setTrailingView(View r100) {
        if (r100 == null) goto L5;
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, -2);
        r101.gravity = 8388629;
        e(getMTrailingElement(), r100, r101);
        return;
    }

    public OListItemGeneral(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0, 12);
        d();
        ViewParent r102 = (ViewGroup) findViewById(R.id.ll_root);
        int r103 = vma.c.f556351a;
        if (r102 != null) goto L6;
    L8:
        r102 = null;
    L9:
        com.obric.oui.common.style.a r104 = (com.obric.oui.common.style.a) r102;
        if (r104 == null) goto L13;
        r104.setChangeAlphaWhenPress(false);
    L13:
        setMLeadingElement((FrameLayout) findViewById(R.id.fl_leading_element));
        setMTrailingElement((FrameLayout) findViewById(R.id.fl_trailing_element));
        setMContentElement((FrameLayout) findViewById(R.id.fl_content_element));
        setMIvContent((ImageView) findViewById(R.id.iv_content_img));
        setMClContent((ConstraintLayout) findViewById(R.id.cl_content_container));
        setMTvTitle((TextView) findViewById(R.id.tv_content_title));
        setMTvSubtitle((TextView) findViewById(R.id.tv_content_subtitle));
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_list_item_content_image, R.attr.oui_list_item_content_width, R.attr.oui_list_item_show_background, R.attr.oui_list_item_show_divider, R.attr.oui_list_item_subtitle, R.attr.oui_list_item_title, R.attr.oui_list_item_trailing_image, R.attr.oui_list_item_trailing_text});
        setTitleString(r105.getString(5));
        setSubTitleString(r105.getString(4));
        setTrailingImage(r105.getDrawable(6));
        setContentImage(r105.getDrawable(0));
        setShowPreDefineBackground(r105.getBoolean(2, true));
        setShowDivider(r105.getBoolean(3, false));
        setMContentElementWidth(r105.getDimension(1, 0.0f));
        r105.recycle();
        setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r102 instanceof com.obric.oui.common.style.a) == false) goto L8;
        goto L8
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public final void e(ViewGroup r100, View r101, ViewGroup.LayoutParams r102) {
        if (r101 == null) goto L16;
        if (r100 == null) goto L6;
        j.f(r100);
    L6:
        if (r100 == null) goto L9;
        r100.removeAllViews();
    L9:
        if (r102 != null) goto L13;
        if (r100 == null) goto L22;
        r100.addView(r101);
        return;
    L22:
        return;
    L13:
        if (r100 == null) goto L23;
        r100.addView(r101, r102);
        return;
    L23:
        return;
    L16:
        if (r100 == null) goto L24;
        j.e(r100);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        setShowDivider(this.f401367t);
    }
}
