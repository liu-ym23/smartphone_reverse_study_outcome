package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xbc.b;
import y9c.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_setting/settingitem/CustomSettingItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLeftTV", "Landroid/widget/FrameLayout;", "mRightIndicatorIV", "Landroid/widget/ImageView;", "mRightIndicatorTipTV", "Landroid/widget/TextView;", "mRightDrawableIV", "initAttrs", "", "initView", "setText", "textView", "title", "", "setDrawable", "view", "drawable", "Landroid/graphics/drawable/Drawable;", "setContent", "Landroid/view/View;", "setRightDrawable", "setRightIndicatorDrawable", "setRightText", "rightText", "Companion", "widget-biz-setting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomSettingItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f461046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f461047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f461048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f461049d;

    public static final class a {
    }

    static {
    }

    public CustomSettingItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomSettingItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setContent(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f461046a.removeAllViews();
        this.f461046a.addView(r100);
    }

    public final void setRightDrawable(Drawable r100) {
        ImageView r101 = this.f461049d;
        if (r100 != null) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        if (r100 == null) goto L10;
        r101.setImageDrawable(r100);
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void setRightIndicatorDrawable(Drawable r100) {
        ImageView r101 = this.f461047b;
        if (r100 != null) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        if (r100 == null) goto L10;
        r101.setImageDrawable(r100);
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void setRightText(String r100) {
        TextView r101 = this.f461048c;
        r101.setText(r100);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public CustomSettingItemView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        FrameLayout r100 = new FrameLayout(r210);
        r100.setId(R.id.setting_item_left_text);
        this.f461046a = r100;
        ImageView r101 = new ImageView(r210);
        r101.setId(R.id.setting_item_right_icon);
        r101.setImageTintList(r210.getResources().getColorStateList(R.color.icon_n3));
        r101.setImageDrawable(UDIconUtils.getIconDrawable(r210, R.drawable.ud_icon_right_outlined, d.c(r210, R.color.icon_n3)));
        this.f461047b = r101;
        TextView r102 = new TextView(r210);
        r102.setMaxWidth(UIHelper.dp2px(120.0f));
        r102.setId(R.id.setting_item_right_text);
        r102.setTextSize(14);
        r102.setTextColor(r210.getResources().getColorStateList(R.color.text_placeholder));
        r102.setLines(1);
        r102.setEllipsize(TextUtils.TruncateAt.END);
        this.f461048c = r102;
        ImageView r103 = new ImageView(r210);
        r103.setId(R.id.setting_item_right_drawable);
        this.f461049d = r103;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setMinHeight(UIHelper.dp2px(54.0f));
        ConstraintLayout.LayoutParams r110 = b.b(0.0f, -2.0f, 16, 0, 16, 0);
        r110.topToTop = 0;
        r110.bottomToBottom = 0;
        r110.startToStart = 0;
        r110.endToStart = R.id.setting_item_right_drawable;
        r110.horizontalWeight = 1.0f;
        r110.horizontalChainStyle = 2;
        addView(r100, r110);
        ConstraintLayout.LayoutParams r111 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r111.topToTop = 0;
        r111.bottomToBottom = 0;
        r111.startToEnd = R.id.setting_item_left_text;
        r111.endToStart = R.id.setting_item_right_text;
        addView(r103, r111);
        ConstraintLayout.LayoutParams r104 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        r104.startToEnd = R.id.setting_item_right_drawable;
        r104.endToStart = R.id.setting_item_right_icon;
        addView(r102, r104);
        ConstraintLayout.LayoutParams r105 = b.b(16.0f, 16.0f, 0, 0, 16, 0);
        r105.topToTop = 0;
        r105.bottomToBottom = 0;
        r105.startToEnd = R.id.setting_item_right_text;
        r105.endToEnd = 0;
        addView(r101, r105);
        if (r211 == null) goto L6;
        TypedArray r106 = r210.obtainStyledAttributes(r211, new int[]{R.attr.bottom_desc, R.attr.button_color, R.attr.button_text, R.attr.containerType, R.attr.divider_bottom_visible, R.attr.divider_top_visible, R.attr.end_indicator, R.attr.end_indicator_drawable, R.attr.end_indicator_text, R.attr.indicator_text, R.attr.margin_top, R.attr.upper_desc});
        setRightIndicatorDrawable(r106.getDrawable(6));
        setRightDrawable(r106.getDrawable(7));
        setRightText(r106.getString(8));
        r106.recycle();
        return;
    }

    public /* synthetic */ CustomSettingItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
