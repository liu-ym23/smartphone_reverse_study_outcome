package com.larksuite.component.universe_design.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 >2\u00020\u0001:\u0002=>B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010'\u001a\u00020(2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0014J(\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0014J\u0018\u00103\u001a\u00020(2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0002J\b\u00104\u001a\u00020(H\u0014J\r\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:H\u0014J\u0012\u0010;\u001a\u00020(2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010<\u001a\u00020\"H\u0002R$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larksuite/component/universe_design/image/UDAvatar;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "borderStyle", "getBorderStyle", "()I", "setBorderStyle", "(I)V", "borderColor", "getBorderColor", "setBorderColor", "borderWidth", "", "getBorderWidth", "()Ljava/lang/Float;", "setBorderWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "borderPaint", "Landroid/graphics/Paint;", "cornerRadius", "isDrawBorderDelegate", "", "avatarSize", "getAvatarSize", "setAvatarSize", "avatarSizeInPixel", "init", "", "ta", "Landroid/content/res/TypedArray;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "updateOutline", "onAvatarSizeChanged", "drawBorderDelegate", "Landroid/widget/FrameLayout;", "drawBorderDelegate$universe_ui_avatar_release", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawBorder", "shouldDrawBorder", "AvatarOutlineProvider", "Companion", "universe-ui-avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDAvatar extends AppCompatImageView {
    public static final int AVATAR_EXTRA_SMALL = -5;
    public static final int AVATAR_LARGE = -1;
    public static final int AVATAR_MIDDLE = -2;
    public static final int AVATAR_MINI = -4;
    public static final int AVATAR_SMALL = -3;
    public static final int BORDER_CIRCLE = 0;
    public static final int BORDER_RECTANGULAR = 1;
    public static final b Companion = null;
    private int avatarSize;
    private int avatarSizeInPixel;
    private int borderColor;
    private Paint borderPaint;
    private int borderStyle;
    private Float borderWidth;
    private float cornerRadius;
    private boolean isDrawBorderDelegate;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f285048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f285049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f285050c;

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r101 == null) goto L5;
            r101.setRoundRect(0, 0, this.f285048a, this.f285049b, this.f285050c);
            return;
        }

        public a(int r100, int r101, float r102) {
            this.f285048a = r100;
            this.f285049b = r101;
            this.f285050c = r102;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    private final boolean shouldDrawBorder() {
        if (this.isDrawBorderDelegate == false) goto L5;
    L13:
        return false;
    L5:
        if (this.borderColor == 0) goto L13;
        Float r100 = this.borderWidth;
        if (r100 == null) goto L9;
        float r101 = r100.floatValue();
    L11:
        if (r101 <= 0.0f) goto L13;
        return true;
    L9:
        r101 = 0.0f;
        goto L11
    }

    public final FrameLayout drawBorderDelegate$universe_ui_avatar_release() {
        if (this.isDrawBorderDelegate == true) goto L14;
        this.isDrawBorderDelegate = true;
        FrameLayout r100 = new FrameLayout(getContext());
        GradientDrawable r101 = new GradientDrawable();
        Float r102 = this.borderWidth;
        if (r102 == null) goto L7;
        int r103 = (int) r102.floatValue();
    L8:
        r101.setStroke(r103, this.borderColor);
        r101.setCornerRadius(this.avatarSizeInPixel / 2.0f);
        r100.setBackground(r101);
        Float r104 = this.borderWidth;
        if (r104 == null) goto L11;
        int r105 = (int) r104.floatValue();
    L12:
        int r106 = r105 - 0;
        r100.setPadding(r106, r106, r106, r106);
        r100.addView(this, new FrameLayout.LayoutParams(-2, -2));
        this.avatarSizeInPixel -= r106;
        return r100;
    L11:
        r105 = 0;
        goto L12
    L7:
        r103 = 0;
        goto L8
    L14:
        ViewParent r107 = getParent();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.widget.FrameLayout");
        return (FrameLayout) r107;
    }

    public void onAvatarSizeChanged() {
        int r100 = this.avatarSize;
        if (r100 == (-5)) goto L13;
        if (r100 == (-4)) goto L12;
        if (r100 == (-3)) goto L11;
        if (r100 == (-2)) goto L10;
        if (r100 == (-1)) goto L9;
        float r101 = r100;
    L14:
        this.avatarSizeInPixel = (int) r101;
        int r102 = this.avatarSize;
        if (r102 == (-5)) goto L26;
        if (r102 == (-4)) goto L25;
        if (r102 == (-3)) goto L24;
        if (r102 != (-2)) goto L20;
        float r103 = d.c(getContext(), R.dimen.ud_avatar_rectangular_corner_radius_middle);
    L27:
        this.cornerRadius = r103;
        return;
    L20:
        if (r102 == (-1)) goto L22;
        r103 = d.c(getContext(), R.dimen.ud_avatar_rectangular_corner_radius_large);
        goto L27
    L22:
        r103 = d.c(getContext(), R.dimen.ud_avatar_rectangular_corner_radius_large);
        goto L27
    L24:
        r103 = d.c(getContext(), R.dimen.ud_avatar_rectangular_corner_radius_small);
        goto L27
    L25:
        r103 = d.c(getContext(), R.dimen.ud_avatar_rectangular_corner_radius_mini);
        goto L27
    L26:
        r103 = d.c(getContext(), R.dimen.ud_avatar_rectangular_corner_radius_extra_small);
        goto L27
    L9:
        r101 = d.c(getContext(), R.dimen.ud_avatar_size_large);
        goto L14
    L10:
        r101 = d.c(getContext(), R.dimen.ud_avatar_size_middle);
        goto L14
    L11:
        r101 = d.c(getContext(), R.dimen.ud_avatar_size_small);
        goto L14
    L12:
        r101 = d.c(getContext(), R.dimen.ud_avatar_size_mini);
        goto L14
    L13:
        r101 = d.c(getContext(), R.dimen.ud_avatar_size_extra_small);
        goto L14
    }

    public final int getAvatarSize() {
        return this.avatarSize;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderStyle() {
        return this.borderStyle;
    }

    public final Float getBorderWidth() {
        return this.borderWidth;
    }

    public UDAvatar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void drawBorder(Canvas r100) {
        if (shouldDrawBorder() == true) goto L5;
        return;
    L5:
        Paint r101 = this.borderPaint;
        if (r101 == null) goto L12;
        Float r102 = this.borderWidth;
        if (r102 == null) goto L10;
        float r103 = r102.floatValue();
    L11:
        r101.setStrokeWidth(r103);
        goto L12
    L10:
        r103 = 0.0f;
    L12:
        Float r104 = this.borderWidth;
        if (r104 == null) goto L15;
        float r105 = r104.floatValue();
    L17:
        if (r105 <= 0.0f) goto L39;
        Paint r106 = this.borderPaint;
        if (r106 == null) goto L21;
        r106.setColor(this.borderColor);
    L21:
        Float r107 = this.borderWidth;
        if (r107 == null) goto L24;
        float r108 = r107.floatValue();
    L25:
        float r109 = r108 / 3;
        float r110 = getWidth() / 2.0f;
        float r111 = getHeight() / 2.0f;
        if (this.borderStyle != 0) goto L31;
        float r112 = Math.min(r110, r111) - r109;
        Paint r113 = this.borderPaint;
        if (r113 == null) goto L40;
        if (r100 == null) goto L41;
        r100.drawCircle(r110, r111, r112, r113);
        return;
    L41:
        return;
    L40:
        return;
    L31:
        RectF r114 = new RectF(r109, r109, getWidth() - r109, getHeight() - r109);
        float r115 = this.cornerRadius;
        if (r115 >= 0.0f) goto L34;
        r115 = Math.min(r110, r111) - r109;
    L34:
        Paint r116 = this.borderPaint;
        if (r116 == null) goto L43;
        if (r100 == null) goto L44;
        r100.drawRoundRect(r114, r115, r115, r116);
        return;
    L44:
        return;
    L43:
        return;
    L24:
        r108 = 0.0f;
        goto L25
    L39:
        return;
    L15:
        r105 = 0.0f;
        goto L17
    }

    private final void init(TypedArray r100) {
        this.cornerRadius = r100.getDimensionPixelSize(4, -1);
        int r101 = r100.getDimensionPixelSize(3, -1);
        if (r101 <= 0) goto L5;
        this.borderWidth = Float.valueOf(r101);
    L5:
        boolean r102 = true;
        this.borderColor = r100.getColor(1, 0);
        setBorderStyle(r100.getInt(2, 0));
        int r103 = r100.getType(5);
        if (r103 != 5) goto L9;
        setAvatarSize(r100.getDimensionPixelSize(5, 0));
        return;
    L9:
        if (16 <= r103) goto L11;
    L13:
        r102 = false;
    L14:
        if (r102 == false) goto L18;
        setAvatarSize(r100.getInt(5, -1));
        return;
    L18:
        return;
    L11:
        if (r103 >= 32) goto L13;
        goto L13
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        drawBorder(r100);
    }

    public final void setAvatarSize(int r100) {
        this.avatarSize = r100;
        onAvatarSizeChanged();
    }

    public final void setBorderColor(int r100) {
        this.borderColor = r100;
    }

    public final void setBorderStyle(int r100) {
        this.borderStyle = r100;
        updateOutline(getWidth(), getHeight());
    }

    public final void setBorderWidth(Float r100) {
        this.borderWidth = r100;
    }

    public UDAvatar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    private final void updateOutline(int r100, int r101) {
        if (r100 == 0) goto L12;
        if (r101 != 0) goto L6;
        return;
    L6:
        if (this.borderStyle == 0) goto L9;
        float r102 = this.cornerRadius;
        if (r102 < 0.0f) goto L9;
    L10:
        setOutlineProvider(new a(r100, r101, r102));
        return;
    L9:
        r102 = Math.min(r100, r101) / 2.0f;
        goto L10
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = this.avatarSizeInPixel;
        setMeasuredDimension(r102, r102);
    }

    public UDAvatar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 0);
    }

    public void init(AttributeSet r100, int r101, int r102) {
        Paint r103 = new Paint();
        this.borderPaint = r103;
        r103.setStyle(Paint.Style.STROKE);
        r103.setAntiAlias(true);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        TypedArray r104 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_avatar_background, R.attr.ud_avatar_borderColor, R.attr.ud_avatar_borderStyle, R.attr.ud_avatar_borderWidth, R.attr.ud_avatar_cornerRadius, R.attr.ud_avatar_size, R.attr.ud_avatar_text, R.attr.ud_avatar_textColor, R.attr.ud_avatar_textSize}, r101, r102);
        init(r104);
        r104.recycle();
        setClipToOutline(true);
    }

    public UDAvatar(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.avatarSize = -1;
        init(r101, r102, r103);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        updateOutline(r100, r101);
    }
}
