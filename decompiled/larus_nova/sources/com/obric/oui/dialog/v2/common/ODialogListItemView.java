package com.obric.oui.dialog.v2.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0016R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010:\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u00106¨\u0006A"}, d2 = {"Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "str", "", d.f25925o, "setSubtitle", "Landroid/view/View;", "view", "setTrailingView", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImageView", "", "enabled", "setEnabled", "selected", "setSelected", "Lcom/obric/oui/layout/OUILinearLayout;", "h", "Lcom/obric/oui/layout/OUILinearLayout;", "getListItemRoot", "()Lcom/obric/oui/layout/OUILinearLayout;", "setListItemRoot", "(Lcom/obric/oui/layout/OUILinearLayout;)V", "listItemRoot", "Landroid/widget/FrameLayout;", RXScreenCaptureService.KEY_INDEX, "Landroid/widget/FrameLayout;", "getLeadingContainer", "()Landroid/widget/FrameLayout;", "setLeadingContainer", "(Landroid/widget/FrameLayout;)V", "leadingContainer", ce.f26395j, "getTrailingContainer", "setTrailingContainer", "trailingContainer", "Landroid/widget/TextView;", ce.f26396k, "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "titleView", "l", "getSubtitleView", "setSubtitleView", "subtitleView", "", OfficeSDKRequestTag.KEY_NEW_USER, "Lkotlin/Lazy;", "getLineColor", "()I", "lineColor", "o", "getLineHeight", "lineHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class ODialogListItemView extends OUIFrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f400773p = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OUILinearLayout f400774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f400775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f400776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f400777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f400778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f400779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f400780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f400781o;

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public final boolean S() {
        return true;
    }

    private final int getLineColor() {
        return ((Number) this.f400780n.getValue()).intValue();
    }

    private final int getLineHeight() {
        return ((Number) this.f400781o.getValue()).intValue();
    }

    public final FrameLayout getLeadingContainer() {
        FrameLayout r100 = this.f400775i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("leadingContainer");
        return null;
    }

    public final OUILinearLayout getListItemRoot() {
        OUILinearLayout r100 = this.f400774h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("listItemRoot");
        return null;
    }

    public final TextView getSubtitleView() {
        TextView r100 = this.f400778l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        return null;
    }

    public final TextView getTitleView() {
        TextView r100 = this.f400777k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    }

    public final FrameLayout getTrailingContainer() {
        FrameLayout r100 = this.f400776j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingContainer");
        return null;
    }

    public ODialogListItemView(Context r100) {
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

    public final void e(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = getListItemRoot().getPaddingLeft() + getLeadingContainer().getMeasuredWidth();
        int r102 = getLineHeight();
        int r103 = getLineColor();
        this.f401297b.H(r101, r102, r103);
        return;
    L4:
        int r104 = getListItemRoot().getPaddingLeft();
        int r105 = getLineColor();
        this.f401297b.H(r104, 0, r105);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        getListItemRoot().setEnabled(r100);
    }

    public final void setLeadingContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400775i = r100;
    }

    public final void setListItemRoot(OUILinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400774h = r100;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        getListItemRoot().getAlphaHelper().Y4(this, r100);
    }

    public final void setSubtitle(CharSequence r100) {
        TextView r101 = getSubtitleView();
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        j.e(r101);
        return;
    L11:
        r101.setText(r100);
        j.f(r101);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void setSubtitleView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400778l = r100;
    }

    public final void setTitle(CharSequence r100) {
        TextView r101 = getTitleView();
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        j.e(r101);
        return;
    L11:
        r101.setText(r100);
        j.f(r101);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void setTitleView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400777k = r100;
    }

    public final void setTrailingContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400776j = r100;
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
        Intrinsics.checkNotNullParameter(r100, "view");
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, -2);
        r101.gravity = 17;
        d(getTrailingContainer(), r100, r101);
    }

    public ODialogListItemView(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0, 12);
        this.f400780n = LazyKt.lazy(new ODialogListItemView$lineColor$2(r100));
        this.f400781o = LazyKt.lazy(new ODialogListItemView$lineHeight$2(this));
        LayoutInflater.from(r100).inflate(R.layout.o_dialog_listitem_view, this);
        setListItemRoot((OUILinearLayout) findViewById(R.id.list_item_root));
        OUILinearLayout r102 = getListItemRoot();
        r102.setRadius(pla.d.n(r102, 12));
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, -1);
        r103.topMargin = pla.d.n(r102, 2);
        r103.bottomMargin = pla.d.n(r102, 2);
        r102.setLayoutParams(r103);
        r102.setChangeAlphaWhenPress(true);
        setTitleView((TextView) findViewById(R.id.list_item_title));
        setSubtitleView((TextView) findViewById(R.id.list_item_subtitle));
        setLeadingContainer((FrameLayout) findViewById(R.id.list_leading_element));
        setTrailingContainer((FrameLayout) findViewById(R.id.list_trailing_element));
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
    }

    public final void d(ViewGroup r100, View r101, ViewGroup.LayoutParams r102) {
        if (r101 == null) goto L12;
        if (r100 == null) goto L6;
        j.f(r100);
    L6:
        if (r100 == null) goto L9;
        r100.removeAllViews();
    L9:
        if (r100 == null) goto L17;
        r100.addView(r101, r102);
        return;
    L17:
        return;
    L12:
        if (r100 == null) goto L18;
        j.e(r100);
        return;
    }
}
