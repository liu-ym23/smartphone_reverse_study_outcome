package com.larksuite.component.ud.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.larksuite.component.ud.radius.UDRadius;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\rH\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/ud/button/UDButton;", "Landroidx/appcompat/widget/AppCompatButton;", "", "color", "", "setBackgroundColor", "Landroid/content/res/ColorStateList;", "colors", "setStrokeColor", "width", "setStrokeWidth", "getStrokeWidth", "()Ljava/lang/Integer;", "", "radius", "setCornerRadius", "getCornerRadius", "", "getCornerRadii", "", "isRadiusAdjustBounds", "setRadiusAdjustBounds", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chameleon-base_release"}, k = 1, mv = {1, 7, 1})
public class UDButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nz7.a f284033a;

    public UDButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UDButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float[] getCornerRadii() {
        return this.f284033a.getCornerRadii();
    }

    public final float getCornerRadius() {
        return this.f284033a.getCornerRadius();
    }

    public final Integer getStrokeWidth() {
        return Integer.valueOf(this.f284033a.f521550c);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        nz7.a r101 = this.f284033a;
        ColorStateList r102 = ColorStateList.valueOf(r100);
        r101.f521548a = r102;
        r101.setColor(r102);
    }

    public final void setCornerRadius(float r100) {
        this.f284033a.setCornerRadius(r100);
    }

    public final void setRadiusAdjustBounds(boolean r100) {
        nz7.a r101 = this.f284033a;
        if (r101.f521551d == r100) goto L10;
        r101.f521551d = r100;
        if (r100 == false) goto L8;
        r101.setCornerRadius(Math.min(r101.getBounds().width(), r101.getBounds().height()) / 2);
    L8:
        r101.invalidateSelf();
        return;
    }

    public final void setStrokeColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        nz7.a r101 = this.f284033a;
        int r102 = r101.f521550c;
        r101.f521550c = r102;
        r101.f521549b = r100;
        r101.setStroke(r102, r100);
    }

    public final void setStrokeWidth(int r100) {
        nz7.a r101 = this.f284033a;
        ColorStateList r102 = r101.f521549b;
        r101.f521550c = r100;
        r101.f521549b = r102;
        r101.setStroke(r100, r102);
    }

    public final void setBackgroundColor(ColorStateList r100) {
        nz7.a r101 = this.f284033a;
        r101.f521548a = r100;
        r101.setColor(r100);
    }

    public final void setStrokeColor(int r100) {
        setStrokeColor(ColorStateList.valueOf(r100));
    }

    public UDButton(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        boolean r101 = false;
        TypedArray r112 = r100.obtainStyledAttributes(r110, new int[]{R.attr.textAppearance, R.attr.ellipsize, R.attr.gravity, R.attr.paddingLeft, R.attr.paddingRight, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginRight, R.attr.minWidth, R.attr.maxLines, com.larus.nova.R.attr.ud_backgroundColor, com.larus.nova.R.attr.ud_isRadiusAdjustBounds, com.larus.nova.R.attr.ud_radius, com.larus.nova.R.attr.ud_radiusBottomLeft, com.larus.nova.R.attr.ud_radiusBottomRight, com.larus.nova.R.attr.ud_radiusTopLeft, com.larus.nova.R.attr.ud_radiusTopRight, com.larus.nova.R.attr.ud_strokeColor, com.larus.nova.R.attr.ud_strokeWidth}, r111, 0);
        ColorStateList r113 = r112.getColorStateList(11);
        ColorStateList r102 = r112.getColorStateList(18);
        int r103 = r112.getDimensionPixelSize(19, 0);
        boolean r104 = r112.getBoolean(12, false);
        int r105 = r112.getInt(13, 0);
        if (r105 < 0) goto L17;
        UDRadius.Companion.getClass();
        switch(r105) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        UDRadius r106 = UDRadius.ROUND;
    L16:
        r105 = r106.getRadiusSize(r100);
        goto L17
    L9:
        r106 = UDRadius.XXL;
        goto L16
    L10:
        r106 = UDRadius.XL;
        goto L16
    L11:
        r106 = UDRadius.L;
        goto L16
    L12:
        r106 = UDRadius.M;
        goto L16
    L13:
        r106 = UDRadius.S;
        goto L16
    L14:
        r106 = UDRadius.XS;
        goto L16
    L15:
        r106 = UDRadius.NONE;
        goto L16
    L7:
        throw new IllegalArgumentException("no radius for value " + r105 + '!');
    L17:
        int r107 = r112.getDimensionPixelSize(16, 0);
        int r108 = r112.getDimensionPixelSize(17, 0);
        int r109 = r112.getDimensionPixelSize(14, 0);
        int r114 = r112.getDimensionPixelSize(15, 0);
        r112.recycle();
        nz7.a r115 = new nz7.a();
        r115.f521548a = r113;
        r115.setColor(r113);
        r115.f521550c = r103;
        r115.f521549b = r102;
        r115.setStroke(r103, r102);
        if (r107 > 0) goto L27;
        if (r108 > 0) goto L27;
        if (r109 > 0) goto L27;
        if (r114 > 0) goto L27;
        r115.setCornerRadius(r105);
        if (r105 > 0) goto L28;
        r101 = r104;
    L28:
        r115.f521551d = r101;
        this.f284033a = r115;
        setBackground(r115);
        return;
    L27:
        float r116 = r107;
        float r117 = r108;
        float r118 = r114;
        float r119 = r109;
        r115.setCornerRadii(new float[]{r116, r116, r117, r117, r118, r118, r119, r119});
        goto L28
    }

    public /* synthetic */ UDButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
