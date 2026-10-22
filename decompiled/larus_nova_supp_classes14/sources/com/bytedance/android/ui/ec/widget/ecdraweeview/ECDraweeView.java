package com.bytedance.android.ui.ec.widget.ecdraweeview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 Q2\u00020\u0001:\u0001QB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0018\u0010B\u001a\u00020?2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0012\u0010E\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0012\u0010F\u001a\u00020?2\b\u0010G\u001a\u0004\u0018\u00010AH\u0016J&\u0010)\u001a\u00020?2\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u0018J\u001a\u0010L\u001a\u00020?2\u0006\u0010M\u001a\u00020\u00072\n\b\u0002\u0010N\u001a\u0004\u0018\u00010OJ\b\u0010P\u001a\u00020?H\u0002R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R$\u00104\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR$\u00107\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\u0015\u0010:\u001a\u00020\u0007*\u00020;8G¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006R"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "Lcom/facebook/drawee/view/GenericDraweeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "adjustMode", "getAdjustMode", "()I", "setAdjustMode", "(I)V", "autoPlayAnimation", "", "getAutoPlayAnimation", "()Z", "setAutoPlayAnimation", "(Z)V", "borderColor", "getBorderColor", "setBorderColor", "", "borderWidth", "getBorderWidth", "()F", "setBorderWidth", "(F)V", "bottomLeftCornerRadius", "getBottomLeftCornerRadius", "setBottomLeftCornerRadius", "bottomRightCornerRadius", "getBottomRightCornerRadius", "setBottomRightCornerRadius", "controllerListener", "Lcom/facebook/drawee/controller/ControllerListener;", "", "cornerRadius", "getCornerRadius", "setCornerRadius", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "getImageInfo", "()Lcom/facebook/imagepipeline/image/ImageInfo;", "setImageInfo", "(Lcom/facebook/imagepipeline/image/ImageInfo;)V", "roundingParams", "Lcom/facebook/drawee/generic/RoundingParams;", "getRoundingParams", "()Lcom/facebook/drawee/generic/RoundingParams;", "topLeftCornerRadius", "getTopLeftCornerRadius", "setTopLeftCornerRadius", "topRightCornerRadius", "getTopRightCornerRadius", "setTopRightCornerRadius", "dp", "", "getDp", "(Ljava/lang/Number;)I", "addControllerListener", "", "controller", "Lcom/facebook/drawee/interfaces/DraweeController;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeControllerListener", "setController", "draweeController", "topLeftRadius", "topRightRadius", "bottomRightRadius", "bottomLeftRadius", "setPlaceholderImage", "resourceId", "scaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "update", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECDraweeView extends GenericDraweeView {
    public static final Companion Companion = null;
    public static final int HEIGHT_SELF_ADJUST = 2;
    public static final int NONE = 0;
    public static final int ROUND = 2000;
    public static final int SELF_ADJUST_1X_TO_DP = 31;
    public static final int SELF_ADJUST_2X_TO_DP = 32;
    public static final int SELF_ADJUST_3X_TO_DP = 33;
    public static final int SELF_ADJUST_PIXEL = 30;
    public static final int SQUARE = 1000;
    public static final int WIDTH_SELF_ADJUST = 1;
    private int adjustMode;
    private boolean autoPlayAnimation;
    private int borderColor;
    private float borderWidth;
    private float bottomLeftCornerRadius;
    private float bottomRightCornerRadius;
    private final ControllerListener<Object> controllerListener;
    private float cornerRadius;
    private ImageInfo imageInfo;
    private final RoundingParams roundingParams;
    private float topLeftCornerRadius;
    private float topRightCornerRadius;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView$Companion;", "", "()V", "HEIGHT_SELF_ADJUST", "", "NONE", "ROUND", "SELF_ADJUST_1X_TO_DP", "SELF_ADJUST_2X_TO_DP", "SELF_ADJUST_3X_TO_DP", "SELF_ADJUST_PIXEL", "SQUARE", "WIDTH_SELF_ADJUST", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ECDraweeView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ECDraweeView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void update() {
        float r0 = this.borderWidth;
        if (r0 <= 0) goto L5;
        this.roundingParams.setBorderWidth(r0);
    L5:
        int r1 = this.borderColor;
        if (r1 == (-1)) goto L8;
        this.roundingParams.setBorderColor(r1);
    L8:
        this.roundingParams.setCornersRadii(this.topLeftCornerRadius, this.topRightCornerRadius, this.bottomRightCornerRadius, this.bottomLeftCornerRadius);
        invalidate();
    }

    public final int getAdjustMode() {
        return this.adjustMode;
    }

    public final boolean getAutoPlayAnimation() {
        return this.autoPlayAnimation;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final float getBottomLeftCornerRadius() {
        return this.bottomLeftCornerRadius;
    }

    public final float getBottomRightCornerRadius() {
        return this.bottomRightCornerRadius;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final ImageInfo getImageInfo() {
        return this.imageInfo;
    }

    public final RoundingParams getRoundingParams() {
        return this.roundingParams;
    }

    public final float getTopLeftCornerRadius() {
        return this.topLeftCornerRadius;
    }

    public final float getTopRightCornerRadius() {
        return this.topRightCornerRadius;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_ecdraweeview_ECDraweeView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private final void addControllerListener(DraweeController r2) {
        if ((r2 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r2).addControllerListener(this.controllerListener);
        return;
    }

    private final void removeControllerListener(DraweeController r2) {
        if ((r2 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r2).removeControllerListener(this.controllerListener);
        return;
    }

    public final int getDp(Number r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$dp");
        return (int) TypedValue.applyDimension(1, r3.floatValue(), INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_ecdraweeview_ECDraweeView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAdjustMode(int r2) {
        this.adjustMode = r2;
        if (r2 != 2000) goto L6;
        this.roundingParams.setRoundAsCircle(true);
    L6:
        requestLayout();
    }

    public final void setAutoPlayAnimation(boolean r1) {
        this.autoPlayAnimation = r1;
    }

    public final void setBorderColor(int r1) {
        this.borderColor = r1;
        update();
    }

    public final void setBorderWidth(float r1) {
        this.borderWidth = r1;
        update();
    }

    public final void setBottomLeftCornerRadius(float r1) {
        this.bottomLeftCornerRadius = r1;
        update();
    }

    public final void setBottomRightCornerRadius(float r1) {
        this.bottomRightCornerRadius = r1;
        update();
    }

    public void setController(DraweeController r2) {
        this.imageInfo = null;
        removeControllerListener(getController());
        addControllerListener(r2);
        super/*com.facebook.drawee.view.DraweeView*/.setController(r2);
    }

    public final void setCornerRadius(float r1) {
        setTopLeftCornerRadius(r1);
        setTopRightCornerRadius(r1);
        setBottomRightCornerRadius(r1);
        setBottomLeftCornerRadius(r1);
        this.cornerRadius = r1;
        update();
    }

    public final void setImageInfo(ImageInfo r1) {
        this.imageInfo = r1;
    }

    public final void setTopLeftCornerRadius(float r1) {
        this.topLeftCornerRadius = r1;
        update();
    }

    public final void setTopRightCornerRadius(float r1) {
        this.topRightCornerRadius = r1;
        update();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r5, int r6) {
        super/*com.facebook.drawee.view.DraweeView*/.onMeasure(r5, r6);
        ImageInfo r7 = this.imageInfo;
        if (r7 != null) goto L6;
        return;
    L6:
        if (this.adjustMode == 0) goto L29;
        int r8 = getMeasuredWidth();
        int r0 = getMeasuredHeight();
        int r1 = this.adjustMode;
        if (r1 == 1) goto L25;
        if (r1 == 2) goto L22;
        if (r1 == 1000) goto L20;
        switch(r1) {
            case 30: goto L18;
            case 31: goto L17;
            case 32: goto L16;
            case 33: goto L15;
            default: goto L27;
        };
    L15:
        float r2 = 3;
        int r9 = getDp(Float.valueOf(r7.getHeight() / r2));
        int r10 = getDp(Float.valueOf(r7.getWidth() / r2));
    L19:
        r0 = r9;
        r8 = r10;
        goto L27
    L16:
        float r3 = 2;
        r9 = getDp(Float.valueOf(r7.getHeight() / r3));
        r10 = getDp(Float.valueOf(r7.getWidth() / r3));
        goto L19
    L17:
        r9 = getDp(Integer.valueOf(r7.getHeight()));
        r10 = getDp(Integer.valueOf(r7.getWidth()));
        goto L19
    L18:
        r9 = r7.getHeight();
        r10 = r7.getWidth();
    L27:
        setMeasuredDimension(r8, r0);
        return;
    L20:
        r0 = r8;
        goto L27
    L22:
        if (r7.getWidth() == 0) goto L27;
        r0 = (int) ((r7.getHeight() * (r8 / r7.getWidth())) + 0.5f);
        goto L27
    L25:
        if (r7.getHeight() == 0) goto L27;
        r8 = (int) ((r7.getWidth() * (r0 / r7.getHeight())) + 0.5f);
        goto L27
    }

    public final void setPlaceholderImage(int r2, ScalingUtils.ScaleType r3) {
        getHierarchy().setPlaceholderImage(r2, r3);
    }

    public ECDraweeView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.borderColor = -1;
        RoundingParams r0 = new RoundingParams();
        this.roundingParams = r0;
        getHierarchy().setRoundingParams(r0);
        getHierarchy().setFadeDuration(0);
        if (r4 == null) goto L5;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130968873, 2130969028, 2130969032, 2130969044, 2130969048, 2130969639, 2130972373, 2130974619, 2130974622});
        setAdjustMode(r6.getInt(6, 0));
        this.autoPlayAnimation = r6.getBoolean(0, false);
        setCornerRadius(r6.getDimension(5, 0.0f));
        setTopLeftCornerRadius(r6.getDimension(5, this.cornerRadius));
        setTopRightCornerRadius(r6.getDimension(5, this.cornerRadius));
        setBottomRightCornerRadius(r6.getDimension(5, this.cornerRadius));
        setBottomLeftCornerRadius(r6.getDimension(5, this.cornerRadius));
        setBorderWidth(r6.getDimension(2, 0.0f));
        setBorderColor(r6.getColor(1, -1));
        r6.recycle();
    L5:
        this.controllerListener = new ECDraweeView$controllerListener$1(this);
    }

    public final void setCornerRadius(float r1, float r2, float r3, float r4) {
        setTopLeftCornerRadius(r1);
        setTopRightCornerRadius(r2);
        setBottomRightCornerRadius(r3);
        setBottomLeftCornerRadius(r4);
    }

    public /* synthetic */ ECDraweeView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static /* synthetic */ void setPlaceholderImage$default(ECDraweeView r0, int r1, ScalingUtils.ScaleType r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = ScalingUtils.ScaleType.CENTER_INSIDE;
    L6:
        r0.setPlaceholderImage(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPlaceholderImage");
    }
}
