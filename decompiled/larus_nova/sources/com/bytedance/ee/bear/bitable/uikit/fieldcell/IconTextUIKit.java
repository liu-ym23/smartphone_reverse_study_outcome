package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u001f\u0010\u0019\u001a\u00020\u00122\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u001f\u0010\u001f\u001a\u00020\u00122\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001eJ\u0010\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"J\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\"J\u000e\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconTextUIKit;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attri", "Landroid/util/AttributeSet;", "styleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "leftIconIV", "Landroidx/appcompat/widget/AppCompatImageView;", "rightIconIV", "contentTv", "Landroid/widget/TextView;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setLeftIconVisible", "visible", "", "setRightIconVisible", "setRightIcon", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "iconRes", "iconTintColor", "(ILjava/lang/Integer;)V", "setLeftIcon", "setContent", "content", "", "getContentTv", "getRightIcon", "getLeftIcon", "setContentColor", "textColor", "setContextSize", "fontSize", "", "setContentBold", "isBold", "setContextMaxLines", "maxLines", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconTextUIKit extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f216144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f216145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f216146c;

    public final TextView getContentTv() {
        return this.f216146c;
    }

    public final AppCompatImageView getLeftIcon() {
        return this.f216144a;
    }

    public final AppCompatImageView getRightIcon() {
        return this.f216145b;
    }

    public IconTextUIKit(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setContent(String r100) {
        this.f216146c.setText(r100);
    }

    public final void setContentBold(boolean r100) {
        if (r100 == false) goto L4;
        TextView r101 = this.f216146c;
        int r102 = h18.e.f483540a;
        r101.setTypeface(h18.e.b(getContext(), 1));
        return;
    L4:
        TextView r103 = this.f216146c;
        int r104 = h18.e.f483540a;
        r103.setTypeface(h18.e.b(getContext(), 0));
    }

    public final void setContentColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "textColor");
        this.f216146c.setTextColor(ColorUtils.h(r100));
    }

    public final void setContextMaxLines(int r100) {
        this.f216146c.setMaxLines(r100);
    }

    public final void setContextSize(float r100) {
        this.f216146c.setTextSize(r100);
    }

    public final void setLeftIcon(Icon r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        com.bytedance.ee.bear.bitable.panel.e.n(this.f216144a, r100);
    }

    public final void setLeftIconVisible(boolean r100) {
        AppCompatImageView r101 = this.f216144a;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setRightIcon(Icon r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        com.bytedance.ee.bear.bitable.panel.e.n(this.f216145b, r100);
    }

    public final void setRightIconVisible(boolean r100) {
        AppCompatImageView r101 = this.f216145b;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setContentColor(int r100) {
        this.f216146c.setTextColor(r100);
    }

    public IconTextUIKit(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        super.onMeasure(r100, r110);
        int r101 = View.MeasureSpec.getSize(r100);
        if (this.f216145b.getVisibility() != 0) goto L23;
        int r102 = this.f216146c.getMeasuredWidth() + this.f216145b.getMeasuredWidth();
        ViewGroup.LayoutParams r103 = this.f216145b.getLayoutParams();
        ViewGroup.MarginLayoutParams r104 = null;
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r103;
    L8:
        int r106 = 0;
        if (r105 == null) goto L11;
        int r107 = r105.leftMargin;
    L12:
        int r108 = r102 + r107;
        if (this.f216144a.getVisibility() != 0) goto L20;
        int r109 = this.f216144a.getMeasuredWidth();
        ViewGroup.LayoutParams r111 = this.f216144a.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r104 = (ViewGroup.MarginLayoutParams) r111;
    L17:
        if (r104 == null) goto L19;
        r106 = r104.rightMargin;
    L19:
        r108 = r108 + (r109 + r106);
    L20:
        if (r108 <= r101) goto L24;
        measureChildWithMargins(this.f216146c, r100, r108 - this.f216146c.getMeasuredWidth(), r110, 0);
        return;
    L24:
        return;
    L11:
        r107 = 0;
        goto L12
    L7:
        r105 = null;
        goto L8
    }

    public IconTextUIKit(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.bitable_icon_text_uikit_layout, this, true);
        setGravity(16);
        setOrientation(0);
        this.f216144a = (AppCompatImageView) findViewById(R.id.leftIcon);
        this.f216145b = (AppCompatImageView) findViewById(R.id.rightIcon);
        this.f216146c = (TextView) findViewById(R.id.content);
    }
}
