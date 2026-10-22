package com.larksuite.component.universe_design.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0007J\r\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0007J&\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019J\n\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$J\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\r2\b\b\u0001\u0010&\u001a\u00020\u0007J\"\u0010'\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larksuite/component/universe_design/button/UDButton;", "Landroidx/appcompat/widget/AppCompatButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRoundBg", "Lcom/larksuite/component/universe_design/drawable/UDRoundDrawable;", "setBackgroundColor", "", "color", "colors", "Landroid/content/res/ColorStateList;", "setStrokeData", "width", "setStrokeColor", "setStrokeWidth", "getStrokeWidth", "()Ljava/lang/Integer;", "setCornerRadius", "radius", "", "getCornerRadius", "setCornerRadii", "radiusTopLeft", "radiusTopRight", "radiusBottomLeft", "radiusBottomRight", "getCornerRadii", "", "setRadiusAdjustBounds", "isRadiusAdjustBounds", "", "applyStyle", "styleRes", "createRoundDrawableFromAttributeSet", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDButton extends AppCompatButton {
    public static final int $stable = 8;
    private t08.a mRoundBg;

    public UDButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public UDButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final float[] getCornerRadii() {
        return this.mRoundBg.getCornerRadii();
    }

    public final float getCornerRadius() {
        return this.mRoundBg.getCornerRadius();
    }

    public final Integer getStrokeWidth() {
        return Integer.valueOf(this.mRoundBg.f544129c);
    }

    public final boolean isRadiusAdjustBounds() {
        return this.mRoundBg.f544130d;
    }

    public final void applyStyle(int r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(null, new int[]{R.attr.textAppearance, R.attr.ellipsize, R.attr.gravity, R.attr.paddingLeft, R.attr.paddingRight, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginRight, R.attr.minWidth, R.attr.maxLines, com.larus.nova.R.attr.ud_backgroundColor, com.larus.nova.R.attr.ud_isRadiusAdjustBounds, com.larus.nova.R.attr.ud_radius, com.larus.nova.R.attr.ud_radiusBottomLeft, com.larus.nova.R.attr.ud_radiusBottomRight, com.larus.nova.R.attr.ud_radiusTopLeft, com.larus.nova.R.attr.ud_radiusTopRight, com.larus.nova.R.attr.ud_strokeColor, com.larus.nova.R.attr.ud_strokeWidth}, 0, r100);
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 != null) goto L5;
        r102 = new ViewGroup.MarginLayoutParams(0, 0);
    L5:
        r102.width = r101.getLayoutDimension(5, r102.width);
        r102.height = r101.getLayoutDimension(6, r102.height);
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        r103.leftMargin = r101.getDimensionPixelSize(7, r103.leftMargin);
        r103.rightMargin = r101.getDimensionPixelSize(8, r103.rightMargin);
    L8:
        setLayoutParams(r102);
        setPadding(r101.getDimensionPixelSize(3, getPaddingLeft()), getPaddingTop(), r101.getDimensionPixelSize(4, getPaddingRight()), getPaddingBottom());
        setMinWidth(r101.getDimensionPixelSize(9, getMinWidth()));
        setMaxLines(r101.getInt(10, getMaxLines()));
        int r104 = 2;
        setGravity(r101.getInt(2, getGravity()));
        TextUtils.TruncateAt[] r105 = TextUtils.TruncateAt.values();
        TextUtils.TruncateAt r106 = getEllipsize();
        if (r106 == null) goto L11;
        r104 = r106.ordinal();
    L11:
        setEllipsize(r105[r101.getInt(1, r104)]);
        int r107 = r101.getResourceId(0, -1);
        if (r107 <= 0) goto L14;
        setTextAppearance(getContext(), r107);
    L14:
        int r108 = r101.getInt(13, 0);
        if (r108 < 0) goto L17;
        UDRadius.Companion.getClass();
        setCornerRadius(UDRadius.a.a(r108).getRadiusSize(getContext()));
    L17:
        setRadiusAdjustBounds(r101.getBoolean(12, false));
        r101.recycle();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        t08.a r101 = this.mRoundBg;
        ColorStateList r102 = ColorStateList.valueOf(r100);
        r101.f544127a = r102;
        r101.setColor(r102);
    }

    public final void setCornerRadius(float r100) {
        this.mRoundBg.setCornerRadius(r100);
    }

    public final void setRadiusAdjustBounds(boolean r100) {
        t08.a r101 = this.mRoundBg;
        if (r101.f544130d == r100) goto L10;
        r101.f544130d = r100;
        if (r100 == false) goto L8;
        r101.setCornerRadius(Math.min(r101.getBounds().width(), r101.getBounds().height()) / 2);
    L8:
        r101.invalidateSelf();
        return;
    }

    public final void setStrokeColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        t08.a r101 = this.mRoundBg;
        int r102 = r101.f544129c;
        r101.f544129c = r102;
        r101.f544128b = r100;
        r101.setStroke(r102, r100);
    }

    public final void setStrokeWidth(int r100) {
        t08.a r101 = this.mRoundBg;
        ColorStateList r102 = r101.f544128b;
        r101.f544129c = r100;
        r101.f544128b = r102;
        r101.setStroke(r100, r102);
    }

    public final void setBackgroundColor(ColorStateList r100) {
        t08.a r101 = this.mRoundBg;
        r101.f544127a = r100;
        r101.setColor(r100);
    }

    public final void setStrokeColor(int r100) {
        setStrokeColor(ColorStateList.valueOf(r100));
    }

    public final void setStrokeData(int r100, ColorStateList r101) {
        t08.a r102 = this.mRoundBg;
        r102.f544129c = r100;
        r102.f544128b = r101;
        r102.setStroke(r100, r101);
    }

    public UDButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        t08.a r103 = createRoundDrawableFromAttributeSet(r100, r101, r102);
        this.mRoundBg = r103;
        setBackground(r103);
    }

    private final t08.a createRoundDrawableFromAttributeSet(Context r110, AttributeSet r111, int r112) {
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.textAppearance, R.attr.ellipsize, R.attr.gravity, R.attr.paddingLeft, R.attr.paddingRight, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginRight, R.attr.minWidth, R.attr.maxLines, com.larus.nova.R.attr.ud_backgroundColor, com.larus.nova.R.attr.ud_isRadiusAdjustBounds, com.larus.nova.R.attr.ud_radius, com.larus.nova.R.attr.ud_radiusBottomLeft, com.larus.nova.R.attr.ud_radiusBottomRight, com.larus.nova.R.attr.ud_radiusTopLeft, com.larus.nova.R.attr.ud_radiusTopRight, com.larus.nova.R.attr.ud_strokeColor, com.larus.nova.R.attr.ud_strokeWidth}, r112, 0);
        ColorStateList r100 = r113.getColorStateList(11);
        ColorStateList r101 = r113.getColorStateList(18);
        int r102 = r113.getDimensionPixelSize(19, 0);
        boolean r103 = r113.getBoolean(12, false);
        int r114 = r113.getInt(13, 0);
        if (r114 < 0) goto L5;
        UDRadius.Companion.getClass();
        int r115 = UDRadius.a.a(r114).getRadiusSize(r110);
    L6:
        int r104 = r113.getDimensionPixelSize(16, 0);
        int r105 = r113.getDimensionPixelSize(17, 0);
        int r106 = r113.getDimensionPixelSize(14, 0);
        int r107 = r113.getDimensionPixelSize(15, 0);
        r113.recycle();
        int r116 = t08.a.f544126e;
        return t08.a.C7675a.a(r100, r102, r101, r104, r105, r106, r107, r103, r115);
    L5:
        r115 = r114;
        goto L6
    }

    public final void setCornerRadii(float r100, float r101, float r102, float r103) {
        this.mRoundBg.setCornerRadii(new float[]{r100, r100, r101, r101, r103, r103, r102, r102});
    }

    public /* synthetic */ UDButton(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
