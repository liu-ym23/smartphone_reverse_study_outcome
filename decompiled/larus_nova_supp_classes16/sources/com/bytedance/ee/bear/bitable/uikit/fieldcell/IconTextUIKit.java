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
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.ui.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u001f\u0010\u0019\u001a\u00020\u00122\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u001f\u0010\u001f\u001a\u00020\u00122\b\b\u0001\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001eJ\u0010\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"J\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\"J\u000e\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconTextUIKit;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attri", "Landroid/util/AttributeSet;", "styleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "leftIconIV", "Landroidx/appcompat/widget/AppCompatImageView;", "rightIconIV", "contentTv", "Landroid/widget/TextView;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setLeftIconVisible", "visible", "", "setRightIconVisible", "setRightIcon", CustomHeaderConfig.Menu.Style.ICON_STYLE, "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "iconRes", "iconTintColor", "(ILjava/lang/Integer;)V", "setLeftIcon", "setContent", "content", "", "getContentTv", "getRightIcon", "getLeftIcon", "setContentColor", "textColor", "setContextSize", "fontSize", "", "setContentBold", "isBold", "setContextMaxLines", "maxLines", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconTextUIKit extends LinearLayout {
    public final AppCompatImageView a;
    public final AppCompatImageView b;
    public final TextView c;

    public final TextView getContentTv() {
        return this.c;
    }

    public final AppCompatImageView getLeftIcon() {
        return this.a;
    }

    public final AppCompatImageView getRightIcon() {
        return this.b;
    }

    public IconTextUIKit(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setContent(String r2) {
        this.c.setText(r2);
    }

    public final void setContentBold(boolean r3) {
        if (r3 == false) goto L4;
        TextView r4 = this.c;
        int r0 = h18.e.a;
        r4.setTypeface(h18.e.b(getContext(), 1));
        return;
    L4:
        TextView r5 = this.c;
        int r1 = h18.e.a;
        r5.setTypeface(h18.e.b(getContext(), 0));
    }

    public final void setContentColor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "textColor");
        this.c.setTextColor(ColorUtils.h(r2));
    }

    public final void setContextMaxLines(int r2) {
        this.c.setMaxLines(r2);
    }

    public final void setContextSize(float r2) {
        this.c.setTextSize(r2);
    }

    public final void setLeftIcon(Icon r2) {
        Intrinsics.checkNotNullParameter(r2, CustomHeaderConfig.Menu.Style.ICON_STYLE);
        com.bytedance.ee.bear.bitable.panel.e.n(this.a, r2);
    }

    public final void setLeftIconVisible(boolean r2) {
        AppCompatImageView r0 = this.a;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setRightIcon(Icon r2) {
        Intrinsics.checkNotNullParameter(r2, CustomHeaderConfig.Menu.Style.ICON_STYLE);
        com.bytedance.ee.bear.bitable.panel.e.n(this.b, r2);
    }

    public final void setRightIconVisible(boolean r2) {
        AppCompatImageView r0 = this.b;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setContentColor(int r2) {
        this.c.setTextColor(r2);
    }

    public IconTextUIKit(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r9, int r10) {
        super.onMeasure(r9, r10);
        int r0 = View.MeasureSpec.getSize(r9);
        if (this.b.getVisibility() != 0) goto L23;
        int r1 = this.c.getMeasuredWidth() + this.b.getMeasuredWidth();
        ViewGroup.LayoutParams r2 = this.b.getLayoutParams();
        ViewGroup.MarginLayoutParams r4 = null;
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L8:
        int r5 = 0;
        if (r3 == null) goto L11;
        int r6 = r3.leftMargin;
    L12:
        int r7 = r1 + r6;
        if (this.a.getVisibility() != 0) goto L20;
        int r8 = this.a.getMeasuredWidth();
        ViewGroup.LayoutParams r11 = this.a.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r4 = (ViewGroup.MarginLayoutParams) r11;
    L17:
        if (r4 == null) goto L19;
        r5 = r4.rightMargin;
    L19:
        r7 = r7 + (r8 + r5);
    L20:
        if (r7 <= r0) goto L24;
        measureChildWithMargins(this.c, r9, r7 - this.c.getMeasuredWidth(), r10, 0);
        return;
    L24:
        return;
    L11:
        r6 = 0;
        goto L12
    L7:
        r3 = null;
        goto L8
    }

    public IconTextUIKit(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131559033, this, true);
        setGravity(16);
        setOrientation(0);
        this.a = findViewById(2131377698);
        this.b = findViewById(2131384507);
        this.c = (TextView) findViewById(2131367794);
    }
}
