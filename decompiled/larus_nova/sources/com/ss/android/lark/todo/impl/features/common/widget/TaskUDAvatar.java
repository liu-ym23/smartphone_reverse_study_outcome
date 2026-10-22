package com.ss.android.lark.todo.impl.features.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 A2\u00020\u0001:\u0002@AB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010*\u001a\u00020+2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0014J(\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0014J\u0018\u00106\u001a\u00020+2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0002J\b\u00107\u001a\u00020+H\u0014J\r\u00108\u001a\u000209H\u0000¢\u0006\u0002\b:J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0014J\u0012\u0010>\u001a\u00020+2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\b\u0010?\u001a\u00020\"H\u0002R$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b$\u0010%R$\u0010&\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/widget/TaskUDAvatar;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "borderStyle", "getBorderStyle", "()I", "setBorderStyle", "(I)V", "borderColor", "getBorderColor", "setBorderColor", "borderWidth", "", "getBorderWidth", "()Ljava/lang/Float;", "setBorderWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "borderPaint", "Landroid/graphics/Paint;", "cornerRadius", "isDrawBorderDelegate", "", "softwareClipCornerRadius", "getSoftwareClipCornerRadius", "()F", "avatarSize", "getAvatarSize", "setAvatarSize", "avatarSizeInPixel", "init", "", "ta", "Landroid/content/res/TypedArray;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "updateOutline", "onAvatarSizeChanged", "drawBorderDelegate", "Landroid/widget/FrameLayout;", "drawBorderDelegate$todo_productionChinaRelease", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawBorder", "shouldDrawBorder", "AvatarOutlineProvider", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TaskUDAvatar extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f442486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f442487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f442488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f442489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f442490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f442491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f442492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f442493h;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f442494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f442495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f442496c;

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r101 == null) goto L5;
            r101.setRoundRect(0, 0, this.f442494a, this.f442495b, this.f442496c);
            return;
        }

        public a(int r100, int r101, float r102) {
            this.f442494a = r100;
            this.f442495b = r101;
            this.f442496c = r102;
        }
    }

    public static final class b {
    }

    static {
    }

    public final float getSoftwareClipCornerRadius() {
        if (this.f442486a == 0) goto L6;
        float r100 = this.f442490e;
        if (r100 < 0.0f) goto L6;
        return r100;
    L6:
        return -1.0f;
    }

    public void onAvatarSizeChanged() {
        int r100 = this.f442492g;
        if (r100 == (-5)) goto L13;
        if (r100 == (-4)) goto L12;
        if (r100 == (-3)) goto L11;
        if (r100 == (-2)) goto L10;
        if (r100 == (-1)) goto L9;
        float r101 = r100;
    L14:
        this.f442493h = (int) r101;
        int r102 = this.f442492g;
        if (r102 == (-5)) goto L26;
        if (r102 == (-4)) goto L25;
        if (r102 == (-3)) goto L24;
        if (r102 != (-2)) goto L20;
        float r103 = UIHelper.sp2px(10.0f);
    L27:
        this.f442490e = r103;
        return;
    L20:
        if (r102 == (-1)) goto L22;
        r103 = UIHelper.sp2px(12.0f);
        goto L27
    L22:
        r103 = UIHelper.sp2px(12.0f);
        goto L27
    L24:
        r103 = UIHelper.sp2px(8.0f);
        goto L27
    L25:
        r103 = UIHelper.sp2px(4.0f);
        goto L27
    L26:
        r103 = UIHelper.sp2px(6.0f);
        goto L27
    L9:
        r101 = UIHelper.sp2px(48.0f);
        goto L14
    L10:
        r101 = UIHelper.sp2px(40.0f);
        goto L14
    L11:
        r101 = UIHelper.sp2px(32.0f);
        goto L14
    L12:
        r101 = UIHelper.sp2px(20.0f);
        goto L14
    L13:
        r101 = UIHelper.sp2px(24.0f);
        goto L14
    }

    public final int getAvatarSize() {
        return this.f442492g;
    }

    public final int getBorderColor() {
        return this.f442487b;
    }

    public final int getBorderStyle() {
        return this.f442486a;
    }

    public final Float getBorderWidth() {
        return this.f442488c;
    }

    public TaskUDAvatar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f442491f == false) goto L5;
    L13:
        boolean r101 = false;
    L14:
        if (r101 == false) goto L56;
        Paint r102 = this.f442489d;
        if (r102 == null) goto L23;
        Float r103 = this.f442488c;
        if (r103 == null) goto L21;
        float r104 = r103.floatValue();
    L22:
        r102.setStrokeWidth(r104);
        goto L23
    L21:
        r104 = 0.0f;
    L23:
        Float r105 = this.f442488c;
        if (r105 == null) goto L26;
        float r106 = r105.floatValue();
    L28:
        if (r106 <= 0.0f) goto L50;
        Paint r107 = this.f442489d;
        if (r107 == null) goto L32;
        r107.setColor(this.f442487b);
    L32:
        Float r108 = this.f442488c;
        if (r108 == null) goto L35;
        float r109 = r108.floatValue();
    L36:
        float r110 = r109 / 3;
        float r111 = getWidth() / 2.0f;
        float r112 = getHeight() / 2.0f;
        if (this.f442486a != 0) goto L42;
        float r113 = Math.min(r111, r112) - r110;
        Paint r114 = this.f442489d;
        if (r114 == null) goto L51;
        if (r100 == null) goto L52;
        r100.drawCircle(r111, r112, r113, r114);
        return;
    L52:
        return;
    L51:
        return;
    L42:
        RectF r115 = new RectF(r110, r110, getWidth() - r110, getHeight() - r110);
        float r116 = this.f442490e;
        if (r116 >= 0.0f) goto L45;
        r116 = Math.min(r111, r112) - r110;
    L45:
        Paint r117 = this.f442489d;
        if (r117 == null) goto L54;
        if (r100 == null) goto L55;
        r100.drawRoundRect(r115, r116, r116, r117);
        return;
    L55:
        return;
    L54:
        return;
    L35:
        r109 = 0.0f;
        goto L36
    L50:
        return;
    L26:
        r106 = 0.0f;
        goto L28
    L56:
        return;
    L5:
        if (this.f442487b == 0) goto L13;
        Float r118 = this.f442488c;
        if (r118 == null) goto L9;
        float r119 = r118.floatValue();
    L11:
        if (r119 <= 0.0f) goto L13;
        r101 = true;
        goto L14
    L9:
        r119 = 0.0f;
        goto L11
    }

    public final void setAvatarSize(int r100) {
        this.f442492g = r100;
        onAvatarSizeChanged();
    }

    public final void setBorderColor(int r100) {
        this.f442487b = r100;
    }

    public final void setBorderStyle(int r100) {
        this.f442486a = r100;
        updateOutline(getWidth(), getHeight());
    }

    public final void setBorderWidth(Float r100) {
        this.f442488c = r100;
    }

    public TaskUDAvatar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = this.f442493h;
        setMeasuredDimension(r102, r102);
    }

    public final void updateOutline(int r100, int r101) {
        if (r100 == 0) goto L12;
        if (r101 != 0) goto L6;
        return;
    L6:
        if (this.f442486a == 0) goto L9;
        float r102 = this.f442490e;
        if (r102 < 0.0f) goto L9;
    L10:
        setOutlineProvider(new a(r100, r101, r102));
        return;
    L9:
        r102 = Math.min(r100, r101) / 2.0f;
        goto L10
    }

    public TaskUDAvatar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f442492g = -1;
        init(r101, r102, 0);
    }

    public void init(AttributeSet r100, int r101, int r102) {
        Paint r103 = new Paint();
        this.f442489d = r103;
        r103.setStyle(Paint.Style.STROKE);
        r103.setAntiAlias(true);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        boolean r104 = false;
        TypedArray r105 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_avatar_background, R.attr.ud_avatar_borderColor, R.attr.ud_avatar_borderStyle, R.attr.ud_avatar_borderWidth, R.attr.ud_avatar_cornerRadius, R.attr.ud_avatar_size, R.attr.ud_avatar_text, R.attr.ud_avatar_textColor, R.attr.ud_avatar_textSize}, r101, 0);
        this.f442490e = r105.getDimensionPixelSize(4, -1);
        int r106 = r105.getDimensionPixelSize(3, -1);
        if (r106 <= 0) goto L5;
        this.f442488c = Float.valueOf(r106);
    L5:
        this.f442487b = r105.getColor(1, 0);
        setBorderStyle(r105.getInt(2, 0));
        int r107 = r105.getType(5);
        if (r107 != 5) goto L9;
        setAvatarSize(r105.getDimensionPixelSize(5, 0));
    L15:
        r105.recycle();
        setClipToOutline(true);
        return;
    L9:
        if (16 <= r107) goto L11;
    L13:
        if (r104 == false) goto L15;
        setAvatarSize(r105.getInt(5, -1));
        goto L15
    L11:
        if (r107 >= 32) goto L13;
        r104 = true;
        goto L13
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        updateOutline(r100, r101);
    }
}
