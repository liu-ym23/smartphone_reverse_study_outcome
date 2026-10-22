package com.obric.oui.common.style;

import android.R;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.StateSet;
import android.view.animation.LinearInterpolator;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b=\u0010>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J@\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010JH\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0014R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001aR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001aR\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001aR\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001aR\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001aR\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001aR\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u001aR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/obric/oui/common/style/OStateGradientDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "", "toColor", "", "animate", "", "updateSolidColor", "updateStrokeColor", "normal", "pressed", "selected", "checked", "hover", "disabled", "setSolidColors", "Landroid/content/res/ColorStateList;", "colorStateList", "width", "setStrokeConfigs", "endAnimation", "isStateful", "", "stateSet", "onStateChange", "normalSolidColor", "I", "pressedSolidColor", "selectedSolidColor", "checkedSolidColor", "hoverSolidColor", "disabledSolidColor", "normalStrokeColor", "pressedStrokeColor", "selectedStrokeColor", "checkedStrokeColor", "hoverStrokeColor", "disabledStrokeColor", "strokeWidth", "targetSolidColor", "targetStrokeColor", "animatedSolidColor", "animatedStrokeColor", "Landroid/animation/ValueAnimator;", "colorAnimator", "Landroid/animation/ValueAnimator;", "strokeAnimator", "", "animDuration", "J", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "Landroid/view/animation/LinearInterpolator;", "animInterpolator", "Landroid/view/animation/LinearInterpolator;", "getAnimInterpolator", "()Landroid/view/animation/LinearInterpolator;", "setAnimInterpolator", "(Landroid/view/animation/LinearInterpolator;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OStateGradientDrawable extends GradientDrawable {
    public static final a Companion = null;
    private static final int[] STATE_CHECKED = null;
    private static final int[] STATE_DISABLED = null;
    private static final int[] STATE_HOVERED = null;
    private static final int[] STATE_NORMAL = null;
    private static final int[] STATE_PRESSED = null;
    private static final int[] STATE_SELECTED = null;
    private long animDuration;
    private LinearInterpolator animInterpolator;
    private int animatedSolidColor;
    private int animatedStrokeColor;
    private int checkedSolidColor;
    private int checkedStrokeColor;
    private ValueAnimator colorAnimator;
    private int disabledSolidColor;
    private int disabledStrokeColor;
    private int hoverSolidColor;
    private int hoverStrokeColor;
    private int normalSolidColor;
    private int normalStrokeColor;
    private int pressedSolidColor;
    private int pressedStrokeColor;
    private int selectedSolidColor;
    private int selectedStrokeColor;
    private ValueAnimator strokeAnimator;
    private int strokeWidth;
    private int targetSolidColor;
    private int targetStrokeColor;

    public static final class a {
        public a() {
        }
    }

    public static /* synthetic */ void a(OStateGradientDrawable r100, ValueAnimator r101) {
        m8582updateSolidColor$lambda1$lambda0(r100, r101);
    }

    public static /* synthetic */ void b(OStateGradientDrawable r100, ValueAnimator r101) {
        m8583updateStrokeColor$lambda3$lambda2(r100, r101);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    static {
        Companion = new a();
        STATE_PRESSED = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        STATE_SELECTED = new int[]{R.attr.state_selected, R.attr.state_enabled};
        STATE_CHECKED = new int[]{R.attr.state_checked, R.attr.state_enabled};
        STATE_HOVERED = new int[]{R.attr.state_hovered, R.attr.state_enabled};
        STATE_DISABLED = new int[]{-16842910};
        STATE_NORMAL = new int[]{R.attr.state_enabled};
    }

    public final void endAnimation() {
        ValueAnimator r100 = this.colorAnimator;
        if (r100 == null) goto L6;
        r100.end();
    L6:
        this.colorAnimator = null;
        ValueAnimator r101 = this.strokeAnimator;
        if (r101 == null) goto L10;
        r101.end();
    L10:
        this.strokeAnimator = null;
    }

    public OStateGradientDrawable() {
        this.animDuration = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2.getDuration();
        this.animInterpolator = new LinearInterpolator();
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    public final LinearInterpolator getAnimInterpolator() {
        return this.animInterpolator;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r110) {
        Intrinsics.checkNotNullParameter(r110, "stateSet");
        if (StateSet.stateSetMatches(new int[]{R.attr.state_enabled}, r110) == true) goto L6;
        int r100 = this.disabledSolidColor;
    L18:
        int r101 = this.targetSolidColor;
        if (r100 == r101) goto L26;
        int r102 = this.normalSolidColor;
        if (r100 != r102) goto L24;
        if (r101 == r102) goto L24;
        boolean r103 = true;
    L25:
        updateSolidColor(r100, r103);
        this.targetSolidColor = r100;
        boolean r104 = true;
    L28:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_enabled}, r110) == true) goto L31;
        int r105 = this.disabledStrokeColor;
    L43:
        int r106 = this.targetStrokeColor;
        if (r105 == r106) goto L51;
        int r107 = this.normalStrokeColor;
        if (r105 != r107) goto L49;
        if (r106 == r107) goto L49;
        boolean r108 = true;
    L50:
        updateStrokeColor(r105, r108);
        this.targetStrokeColor = r105;
        r104 = true;
    L49:
        r108 = false;
    L51:
        if (r104 == false) goto L53;
        return true;
    L53:
        if (super.onStateChange(r110) == true) goto L58;
        return false;
    L58:
        return true;
    L31:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_pressed}, r110) == false) goto L34;
        r105 = this.pressedStrokeColor;
        goto L43
    L34:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_selected}, r110) == false) goto L37;
        r105 = this.selectedStrokeColor;
        goto L43
    L37:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_checked}, r110) == false) goto L40;
        r105 = this.checkedStrokeColor;
        goto L43
    L40:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_hovered}, r110) == false) goto L42;
        r105 = this.hoverStrokeColor;
        goto L43
    L42:
        r105 = this.normalStrokeColor;
    L24:
        r103 = false;
        goto L25
    L26:
        r104 = false;
        goto L28
    L6:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_pressed}, r110) == false) goto L9;
        r100 = this.pressedSolidColor;
        goto L18
    L9:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_selected}, r110) == false) goto L12;
        r100 = this.selectedSolidColor;
        goto L18
    L12:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_checked}, r110) == false) goto L15;
        r100 = this.checkedSolidColor;
        goto L18
    L15:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_hovered}, r110) == false) goto L17;
        r100 = this.hoverSolidColor;
        goto L18
    L17:
        r100 = this.normalSolidColor;
        goto L18
    }

    public final void setAnimDuration(long r100) {
        this.animDuration = r100;
    }

    public final void setAnimInterpolator(LinearInterpolator r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.animInterpolator = r100;
    }

    public final void setSolidColors(ColorStateList r110) {
        Intrinsics.checkNotNullParameter(r110, "colorStateList");
        int r100 = r110.getColorForState(STATE_NORMAL, r110.getDefaultColor());
        int r101 = r110.getColorForState(STATE_PRESSED, r100);
        setSolidColors(r100, r101, r110.getColorForState(STATE_SELECTED, r100), r110.getColorForState(STATE_CHECKED, r100), r110.getColorForState(STATE_HOVERED, r101), r110.getColorForState(STATE_DISABLED, r100));
    }

    private final void updateSolidColor(int r100, boolean r101) {
        ValueAnimator r102 = this.colorAnimator;
        if (r102 == null) goto L6;
        r102.cancel();
    L6:
        if (r101 == false) goto L8;
        int r103 = this.animatedSolidColor;
        ValueAnimator r104 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r103), Integer.valueOf(r100)});
        r104.setDuration(getAnimDuration());
        r104.setInterpolator(getAnimInterpolator());
        r104.addUpdateListener(new d(this));
        r104.start();
        this.colorAnimator = r104;
        return;
    L8:
        this.colorAnimator = null;
        this.animatedSolidColor = r100;
        setColor(r100);
    }

    /* JADX INFO: renamed from: updateSolidColor$lambda-1$lambda-0, reason: not valid java name */
    private static final void m8582updateSolidColor$lambda1$lambda0(OStateGradientDrawable r100, ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r101, "animator");
        Object r102 = r101.getAnimatedValue();
        if (r102 == null) goto L7;
        int r103 = ((Integer) r102).intValue();
        r100.animatedSolidColor = r103;
        r100.setColor(r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void updateStrokeColor(int r100, boolean r101) {
        ValueAnimator r102 = this.strokeAnimator;
        if (r102 == null) goto L6;
        r102.cancel();
    L6:
        if (r101 == false) goto L8;
        int r103 = this.animatedStrokeColor;
        ValueAnimator r104 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r103), Integer.valueOf(r100)});
        r104.setDuration(getAnimDuration());
        r104.setInterpolator(getAnimInterpolator());
        r104.addUpdateListener(new c(this));
        r104.start();
        this.strokeAnimator = r104;
        return;
    L8:
        this.strokeAnimator = null;
        this.animatedStrokeColor = r100;
        setStroke(this.strokeWidth, r100);
    }

    /* JADX INFO: renamed from: updateStrokeColor$lambda-3$lambda-2, reason: not valid java name */
    private static final void m8583updateStrokeColor$lambda3$lambda2(OStateGradientDrawable r100, ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r101, "animator");
        Object r102 = r101.getAnimatedValue();
        if (r102 == null) goto L7;
        int r103 = ((Integer) r102).intValue();
        r100.animatedStrokeColor = r103;
        r100.setStroke(r100.strokeWidth, r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void setStrokeConfigs(int r110, ColorStateList r111) {
        Intrinsics.checkNotNullParameter(r111, "colorStateList");
        int r100 = r111.getColorForState(STATE_NORMAL, r111.getDefaultColor());
        setStrokeConfigs(r110, r100, r111.getColorForState(STATE_PRESSED, r100), r111.getColorForState(STATE_SELECTED, r100), r111.getColorForState(STATE_CHECKED, r100), r111.getColorForState(STATE_HOVERED, r100), r111.getColorForState(STATE_DISABLED, r100));
    }

    public final void setSolidColors(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.normalSolidColor = r100;
        this.pressedSolidColor = r101;
        this.selectedSolidColor = r102;
        this.checkedSolidColor = r103;
        this.hoverSolidColor = r104;
        this.disabledSolidColor = r105;
        this.targetSolidColor = r100;
        this.animatedSolidColor = r100;
        ValueAnimator r106 = this.colorAnimator;
        if (r106 == null) goto L6;
        r106.cancel();
    L6:
        setColor(r100);
    }

    public final void setStrokeConfigs(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        this.strokeWidth = r100;
        this.normalStrokeColor = r101;
        this.pressedStrokeColor = r102;
        this.selectedStrokeColor = r103;
        this.checkedStrokeColor = r104;
        this.hoverStrokeColor = r105;
        this.disabledStrokeColor = r106;
        this.targetStrokeColor = r101;
        this.animatedStrokeColor = r101;
        ValueAnimator r107 = this.strokeAnimator;
        if (r107 == null) goto L6;
        r107.cancel();
    L6:
        setStroke(r100, r101);
    }

    public static /* synthetic */ void setSolidColors$default(OStateGradientDrawable r100, int r101, int r102, int r110, int r111, int r112, int r113, int r114, Object r115) {
        if ((r114 & 2) == 0) goto L5;
        int r103 = r101;
    L7:
        if ((r114 & 4) == 0) goto L9;
        int r104 = r101;
    L11:
        if ((r114 & 8) == 0) goto L13;
        int r105 = r101;
    L15:
        if ((r114 & 16) == 0) goto L17;
        int r106 = r101;
    L19:
        if ((r114 & 32) == 0) goto L21;
        int r107 = r101;
    L22:
        r100.setSolidColors(r101, r103, r104, r105, r106, r107);
        return;
    L21:
        r107 = r113;
        goto L22
    L17:
        r106 = r112;
        goto L19
    L13:
        r105 = r111;
        goto L15
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r102;
        goto L7
    }

    public static /* synthetic */ void setStrokeConfigs$default(OStateGradientDrawable r100, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, Object r118) {
        if ((r117 & 4) == 0) goto L5;
        int r101 = r111;
    L7:
        if ((r117 & 8) == 0) goto L9;
        int r102 = r111;
    L11:
        if ((r117 & 16) == 0) goto L13;
        int r103 = r111;
    L15:
        if ((r117 & 32) == 0) goto L17;
        int r104 = r111;
    L19:
        if ((r117 & 64) == 0) goto L21;
        int r105 = r111;
    L22:
        r100.setStrokeConfigs(r110, r111, r101, r102, r103, r104, r105);
        return;
    L21:
        r105 = r116;
        goto L22
    L17:
        r104 = r115;
        goto L19
    L13:
        r103 = r114;
        goto L15
    L9:
        r102 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }
}
