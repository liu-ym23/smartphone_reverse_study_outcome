package com.larus.common_ui.venus;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w19.c;
import w19.d;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010E\u001a\u00020FH\u0002JN\u0010G\u001a\u00020F2\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010\u0017\u001a\u00020\u00072\b\b\u0003\u0010\u0018\u001a\u00020\u00072\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0003\u0010H\u001a\u00020\u0007H\u0007J\u0018\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0015J\b\u0010L\u001a\u00020FH\u0003J0\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020\u00162\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007H\u0014J\u000e\u0010S\u001a\u00020F2\u0006\u0010T\u001a\u00020UJ\u0006\u0010V\u001a\u00020UJ\u0016\u0010W\u001a\u00020F2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J\u0010\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020ZH\u0014J\b\u0010[\u001a\u00020FH\u0003J\n\u0010\\\u001a\u0004\u0018\u00010]H\u0002J\b\u0010^\u001a\u00020_H\u0002J\u0018\u0010`\u001a\u00020\u00162\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010)\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010)\u001a\u0004\bA\u0010BR\u000e\u0010D\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/larus/common_ui/venus/ShapeButton;", "Landroidx/appcompat/widget/AppCompatButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shapeMode", "fillColor", "pressedColor", "strokeColor", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokeWidth", "cornerRadius", "cornerPosition", "activeEnable", "", "startColor", "endColor", "shadowDx", "shadowDy", "shadowBlurRadius", "shapeShadowColor", "excludeDx", "excludeLeft", "excludeTop", "excludeRight", "excludeBottom", "orientation", "drawablePosition", "normalGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getNormalGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "normalGradientDrawable$delegate", "Lkotlin/Lazy;", "shadowRoundRectDrawable", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "getShadowRoundRectDrawable", "()Lcom/larus/common_ui/venus/ShadowRoundRectDrawable;", "shadowRoundRectDrawable$delegate", "shadowGradientLayer", "Landroid/graphics/drawable/LayerDrawable;", "getShadowGradientLayer", "()Landroid/graphics/drawable/LayerDrawable;", "shadowGradientLayer$delegate", "contentWidth", "", "contentHeight", "hasChangeContext", "touchAdd", "touchAddBottom", "touchAddLeft", "touchAddRight", "touchAddTop", "touchRect", "Landroid/graphics/Rect;", "touchDelegateCustom", "Landroid/view/TouchDelegate;", "getTouchDelegateCustom", "()Landroid/view/TouchDelegate;", "touchDelegateCustom$delegate", "centerText", "initShadowParam", "", "modifyAttribute", "textColor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateBackground", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "updateShadowParam", "shadowParam", "Lcom/larus/common_ui/venus/ShadowRoundRectDrawable$Params;", "getShadowParam", "updateBgColor", "onDraw", "canvas", "Landroid/graphics/Canvas;", "changeTintContextWrapperToActivity", "getActivity", "Landroid/app/Activity;", "getCornerRadiusByPosition", "", "containsFlag", "flagSet", ForwardDependency$ForwardLocation.FLAG, "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShapeButton extends AppCompatButton {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f327847z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f327848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f327849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f327850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f327851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f327852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f327853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f327854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f327855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f327856i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f327857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f327858k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f327859l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f327860m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f327861n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f327862o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f327863p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f327864q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f327865r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f327866s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f327867t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f327868u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f327869v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f327870w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f327871x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f327872y;

    public ShapeButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShapeButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final float[] getCornerRadiusByPosition() {
        float[] r100 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float r101 = this.f327853f;
        int r102 = this.f327854g;
        boolean r103 = true;
        if ((1 | r102) != r102) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        r100[0] = r101;
        r100[1] = r101;
    L9:
        if ((2 | r102) != r102) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L15;
        r100[2] = r101;
        r100[3] = r101;
    L15:
        if ((4 | r102) != r102) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r100[4] = r101;
        r100[5] = r101;
    L21:
        if ((8 | r102) == r102) goto L24;
        r103 = false;
    L24:
        if (r103 == false) goto L26;
        r100[6] = r101;
        r100[7] = r101;
    L26:
        return r100;
    L17:
        r106 = false;
        goto L18
    L11:
        r105 = false;
        goto L12
    L5:
        r104 = false;
        goto L6
    }

    private final GradientDrawable getNormalGradientDrawable() {
        return (GradientDrawable) this.f327861n.getValue();
    }

    private final LayerDrawable getShadowGradientLayer() {
        return (LayerDrawable) this.f327863p.getValue();
    }

    private final a getShadowRoundRectDrawable() {
        return (a) this.f327862o.getValue();
    }

    private final TouchDelegate getTouchDelegateCustom() {
        return (TouchDelegate) this.f327871x.getValue();
    }

    private final Activity getActivity() {
        Context r100 = getContext();
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        if ((r100 instanceof Activity) == true) goto L8;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L8:
        return (Activity) r100;
    L10:
        return null;
    }

    public final a.C4189a getShadowParam() {
        return getShadowRoundRectDrawable().f327952a;
    }

    public final int getStrokeColor() {
        return this.f327851d;
    }

    public static LayerDrawable a(ShapeButton r100) {
        return new LayerDrawable(new Drawable[]{r100.getShadowRoundRectDrawable(), r100.getNormalGradientDrawable()});
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        boolean r101 = true;
        if (this.f327864q <= 0.0f) goto L9;
        int r102 = this.f327860m;
        if (r102 == 0) goto L7;
        if (r102 != 2) goto L9;
    L7:
        r100.save();
        r100.translate((getWidth() - this.f327864q) / 2, 0.0f);
    L21:
        super.onDraw(r100);
        if (r101 == false) goto L25;
        r100.restore();
        return;
    L25:
        return;
    L9:
        if (this.f327865r <= 0.0f) goto L16;
        int r103 = this.f327860m;
        if (r103 != 1) goto L13;
    L14:
        r100.save();
        r100.translate(0.0f, (getHeight() - this.f327865r) / 2);
        goto L21
    L13:
        if (r103 == 3) goto L14;
    L16:
        if (this.f327858k > 0) goto L18;
    L20:
        r101 = false;
        goto L21
    L18:
        if (this.f327855h == true) goto L20;
        r100.save();
        float r104 = 2;
        r100.translate(((-(getPaddingLeft() - getShadowRoundRectDrawable().f327953b)) + (getPaddingRight() - getShadowRoundRectDrawable().f327954c)) / r104, (((-(getPaddingTop() - getShadowRoundRectDrawable().f327955d)) + getPaddingBottom()) - getShadowRoundRectDrawable().f327956e) / r104);
        goto L21
    }

    public final void setStrokeColor(int r100) {
        this.f327851d = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        float[] r102 = getCornerRadiusByPosition();
        GradientDrawable r103 = getNormalGradientDrawable();
        int r104 = this.f327856i;
        if (r104 == (-1)) goto L5;
    L8:
        r103.setColors(new int[]{r104, this.f327857j});
        switch(this.f327859l) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L19;
        };
    L11:
        r103.setOrientation(GradientDrawable.Orientation.TL_BR);
        goto L19
    L12:
        r103.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        goto L19
    L13:
        r103.setOrientation(GradientDrawable.Orientation.BL_TR);
        goto L19
    L14:
        r103.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        goto L19
    L15:
        r103.setOrientation(GradientDrawable.Orientation.BR_TL);
        goto L19
    L16:
        r103.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        goto L19
    L17:
        r103.setOrientation(GradientDrawable.Orientation.TR_BL);
        goto L19
    L18:
        r103.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
    L19:
        int r105 = this.f327848a;
        if (r105 == 0) goto L29;
        if (r105 == 1) goto L28;
        if (r105 != 2) goto L24;
        r103.setShape(2);
    L31:
        if (this.f327854g != (-1)) goto L33;
        r103.setCornerRadius(this.f327853f);
    L34:
        int r106 = this.f327851d;
        if (r106 == 0) goto L38;
        r103.setStroke(this.f327852e, r106);
    L38:
        if (this.f327855h == false) goto L41;
        Drawable r107 = new RippleDrawable(ColorStateList.valueOf(this.f327850c), getNormalGradientDrawable(), null);
    L49:
        setBackground(r107);
        return;
    L41:
        if (this.f327858k <= 0) goto L48;
        a.C4189a r108 = getShadowRoundRectDrawable().f327952a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r108.f327960a = r102;
        getShadowRoundRectDrawable().b(r108);
        getShadowRoundRectDrawable().a(0, getShadowGradientLayer());
        getShadowRoundRectDrawable().a(1, getShadowGradientLayer());
        if (Build.VERSION.SDK_INT < 28) goto L45;
    L47:
        r107 = getShadowGradientLayer();
        goto L49
    L45:
        if (getShadowRoundRectDrawable().getPaint() == null) goto L47;
        setLayerType(1, getPaint());
        goto L47
    L48:
        r107 = getNormalGradientDrawable();
        goto L49
    L33:
        r103.setCornerRadii(r102);
        goto L34
    L24:
        if (r105 != 3) goto L31;
        r103.setShape(3);
        goto L31
    L28:
        r103.setShape(1);
        goto L31
    L29:
        r103.setShape(0);
        goto L31
    L5:
        if (this.f327857j != (-1)) goto L8;
        int r109 = this.f327849b;
        r103.setColors(new int[]{r109, r109});
        goto L19
    }

    public ShapeButton(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f327860m = -1;
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        this.f327861n = LazyKt.lazy(r100, new w19.a());
        this.f327862o = LazyKt.lazy(r100, new w19.b());
        this.f327863p = LazyKt.lazy(r100, new c(this));
        this.f327871x = LazyKt.lazy(r100, new d(this));
        this.f327872y = true;
        TypedArray r101 = r110.obtainStyledAttributes(r111, new int[]{R.attr.larus_sb_activeEnable, R.attr.larus_sb_centerText, R.attr.larus_sb_cornerPosition, R.attr.larus_sb_cornerRadius, R.attr.larus_sb_drawablePosition, R.attr.larus_sb_endColor, R.attr.larus_sb_exclude_bottom, R.attr.larus_sb_exclude_dx, R.attr.larus_sb_exclude_left, R.attr.larus_sb_exclude_right, R.attr.larus_sb_exclude_top, R.attr.larus_sb_fillColor, R.attr.larus_sb_orientation, R.attr.larus_sb_pressedColor, R.attr.larus_sb_shadow_blur_radius, R.attr.larus_sb_shadow_color, R.attr.larus_sb_shadow_dx, R.attr.larus_sb_shadow_dy, R.attr.larus_sb_shapeMode, R.attr.larus_sb_startColor, R.attr.larus_sb_strokeColor, R.attr.larus_sb_strokeWidth, R.attr.larus_sb_touchAdd, R.attr.larus_sb_touchAddBottom, R.attr.larus_sb_touchAddLeft, R.attr.larus_sb_touchAddRight, R.attr.larus_sb_touchAddTop});
        this.f327848a = r101.getInt(18, 0);
        int r102 = r101.getColor(11, -1);
        this.f327849b = r102;
        this.f327850c = r101.getColor(13, -10066330);
        this.f327851d = r101.getColor(20, 0);
        this.f327852e = r101.getDimensionPixelOffset(21, 0);
        this.f327853f = r101.getDimensionPixelSize(3, 0);
        this.f327854g = r101.getInt(2, -1);
        this.f327855h = r101.getBoolean(0, false);
        this.f327860m = r101.getInt(4, -1);
        this.f327856i = r101.getColor(19, -1);
        this.f327857j = r101.getColor(5, -1);
        this.f327859l = r101.getColor(12, 0);
        int r103 = r101.getDimensionPixelSize(22, 0);
        int r104 = r101.getDimensionPixelSize(23, r103);
        this.f327866s = r104;
        int r105 = r101.getDimensionPixelSize(24, r103);
        this.f327867t = r105;
        int r106 = r101.getDimensionPixelSize(25, r103);
        this.f327868u = r106;
        int r107 = r101.getDimensionPixelSize(26, r103);
        this.f327869v = r107;
        this.f327872y = r101.getBoolean(1, true);
        int r108 = r101.getColor(15, 0);
        boolean r109 = r101.getBoolean(7, false);
        boolean r113 = r101.getBoolean(8, false);
        boolean r114 = r101.getBoolean(10, false);
        boolean r115 = r101.getBoolean(9, false);
        boolean r116 = r101.getBoolean(6, false);
        int r117 = r101.getDimensionPixelSize(16, 0);
        int r118 = r101.getDimensionPixelSize(17, 0);
        int r119 = r101.getDimensionPixelSize(14, 0);
        this.f327858k = r119;
        if (r104 <= 0) goto L8;
        if (r105 <= 0) goto L8;
        if (r106 <= 0) goto L8;
        if (r107 <= 0) goto L8;
        this.f327870w = new Rect();
    L8:
        a.C4189a r120 = getShadowRoundRectDrawable().f327952a;
        r120.f327962c = r117;
        r120.f327963d = r118;
        r120.f327966g = r108;
        r120.f327961b = r102;
        r120.f327964e = r119;
        r120.f327965f = r109;
        r120.f327967h = r113;
        r120.f327968i = r114;
        r120.f327969j = r115;
        r120.f327970k = r116;
        r101.recycle();
    }

    public /* synthetic */ ShapeButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        super.onLayout(r110, r111, r112, r113, r114);
        if (this.f327860m <= (-1)) goto L17;
        getCompoundDrawables();
        Drawable r100 = getCompoundDrawables()[this.f327860m];
        if (r100 == null) goto L17;
        int r101 = getCompoundDrawablePadding();
        int r102 = this.f327860m;
        if (r102 == 0) goto L15;
        if (r102 != 1) goto L10;
    L14:
        int r103 = r100.getIntrinsicHeight();
        Paint.FontMetrics r104 = getPaint().getFontMetrics();
        float r105 = (float) Math.ceil(((double) r104.descent) - ((double) r104.ascent));
        this.f327865r = (((r105 * getLineCount()) + ((getLineCount() - 1) * getLineSpacingExtra())) + r103) + r101;
        setPadding(0, 0, 0, (int) (getHeight() - this.f327865r));
        goto L17
    L10:
        if (r102 == 2) goto L15;
        if (r102 == 3) goto L14;
    L15:
        this.f327864q = (getPaint().measureText(getText().toString()) + r100.getIntrinsicWidth()) + r101;
        setPadding(0, 0, (int) (getWidth() - this.f327864q), 0);
    L17:
        if (this.f327872y == false) goto L20;
        setGravity(17);
    L20:
        if (this.f327855h == false) goto L22;
        setClickable(true);
    L22:
        if (r110 == false) goto L27;
        Rect r115 = this.f327870w;
        if (r115 == null) goto L28;
        r115.left = r111 - this.f327867t;
        r115.top = r112 - this.f327869v;
        r115.right = r113 + this.f327868u;
        r115.bottom = r114 + this.f327866s;
        Object r116 = getParent();
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type android.view.View");
        ((View) r116).setTouchDelegate(getTouchDelegateCustom());
        return;
    L28:
        return;
    }
}
