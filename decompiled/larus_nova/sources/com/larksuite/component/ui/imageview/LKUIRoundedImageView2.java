package com.larksuite.component.ui.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0014J\u0010\u00102\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\u000bJ\u0010\u00105\u001a\u00020.2\b\b\u0001\u00106\u001a\u00020\rJ\u000e\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020\rJ\u0010\u00109\u001a\u00020.2\b\b\u0001\u0010:\u001a\u00020\rJ\u000e\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020\rJ\u0010\u0010=\u001a\u00020.2\b\b\u0001\u0010>\u001a\u00020\u0007J\u0010\u0010?\u001a\u00020.2\b\u0010@\u001a\u0004\u0018\u00010\u0011J\b\u0010A\u001a\u00020.H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0017\u001a\u0004\b(\u0010\u001bR\u001b\u0010*\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0017\u001a\u0004\b+\u0010 ¨\u0006B"}, d2 = {"Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIsOval", "", "mRadius", "", "mBorderWidth", "mBorderColor", "mBorderDrawable", "Landroid/graphics/drawable/Drawable;", "mBoardPaint", "Landroid/graphics/Paint;", "getMBoardPaint", "()Landroid/graphics/Paint;", "mBoardPaint$delegate", "Lkotlin/Lazy;", "mBorderPath", "Landroid/graphics/Path;", "getMBorderPath", "()Landroid/graphics/Path;", "mBorderPath$delegate", "mBordRectF", "Landroid/graphics/RectF;", "getMBordRectF", "()Landroid/graphics/RectF;", "mBordRectF$delegate", "softwareRoundClipEnabled", "getSoftwareRoundClipEnabled", "()Z", "setSoftwareRoundClipEnabled", "(Z)V", "mClipPath", "getMClipPath", "mClipPath$delegate", "mClipRectF", "getMClipRectF", "mClipRectF$delegate", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onDraw", "drawBorderIfNeed", "setOval", "isOval", "setRadius", "radius", "setRadiusInDp", "radiusInDp", "setBorderWidth", "width", "setBorderWidthInDp", "widthInDp", "setBorderColor", "borderColor", "setBorderDrawable", "drawable", "setClipOutlineIfNeed", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LKUIRoundedImageView2 extends AppCompatImageView {
    private final Lazy mBoardPaint$delegate;
    private final Lazy mBordRectF$delegate;
    private int mBorderColor;
    private Drawable mBorderDrawable;
    private final Lazy mBorderPath$delegate;
    private float mBorderWidth;
    private final Lazy mClipPath$delegate;
    private final Lazy mClipRectF$delegate;
    private boolean mIsOval;
    private float mRadius;
    private boolean softwareRoundClipEnabled;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUIRoundedImageView2 f284167a;

        public a(LKUIRoundedImageView2 r100) {
            this.f284167a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r110) {
            if (LKUIRoundedImageView2.access$getMIsOval$p(this.f284167a) == false) goto L6;
            if (r110 == null) goto L9;
            r110.setOval(0, 0, this.f284167a.getWidth(), this.f284167a.getHeight());
            return;
        L9:
            return;
        L6:
            if (r110 == null) goto L11;
            r110.setRoundRect(0, 0, this.f284167a.getWidth(), this.f284167a.getHeight(), LKUIRoundedImageView2.access$getMRadius$p(this.f284167a));
            return;
        }
    }

    public LKUIRoundedImageView2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public LKUIRoundedImageView2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final Paint getMBoardPaint() {
        return (Paint) this.mBoardPaint$delegate.getValue();
    }

    private final RectF getMBordRectF() {
        return (RectF) this.mBordRectF$delegate.getValue();
    }

    private final Path getMBorderPath() {
        return (Path) this.mBorderPath$delegate.getValue();
    }

    private final Path getMClipPath() {
        return (Path) this.mClipPath$delegate.getValue();
    }

    private final RectF getMClipRectF() {
        return (RectF) this.mClipRectF$delegate.getValue();
    }

    private final void setClipOutlineIfNeed() {
        if (this.mIsOval == false) goto L5;
    L11:
        setOutlineProvider(new a(this));
        setClipToOutline(true);
    L12:
        invalidate();
        return;
    L5:
        if (this.mRadius != 0.0f) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L11;
        setClipToOutline(false);
        setOutlineProvider(null);
        goto L12
    L7:
        r100 = false;
        goto L8
    }

    public final boolean getSoftwareRoundClipEnabled() {
        return this.softwareRoundClipEnabled;
    }

    public static final /* synthetic */ boolean access$getMIsOval$p(LKUIRoundedImageView2 r100) {
        return r100.mIsOval;
    }

    public static final /* synthetic */ float access$getMRadius$p(LKUIRoundedImageView2 r100) {
        return r100.mRadius;
    }

    private final void drawBorderIfNeed(Canvas r100) {
        Drawable r101 = this.mBorderDrawable;
        if (r101 == null) goto L10;
        if (r101 == null) goto L6;
        r101.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    L6:
        Drawable r102 = this.mBorderDrawable;
        if (r102 == null) goto L23;
        r102.draw(r100);
        return;
    L23:
        return;
    L10:
        float r103 = this.mBorderWidth;
        if (r103 != 0.0f) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        return;
    L16:
        float r105 = (r103 * 1.0f) / 2;
        getMBordRectF().set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        getMBordRectF().inset(r105, r105);
        getMBoardPaint().setColor(this.mBorderColor);
        getMBoardPaint().setStrokeWidth(this.mBorderWidth);
        Path r106 = getMBorderPath();
        r106.reset();
        if (this.mIsOval == false) goto L19;
        r106.addOval(getMBordRectF(), Path.Direction.CW);
    L20:
        if (r100 == null) goto L24;
        r100.drawPath(r106, getMBoardPaint());
        return;
    L24:
        return;
    L19:
        RectF r107 = getMBordRectF();
        float r108 = this.mRadius;
        r106.addRoundRect(r107, r108, r108, Path.Direction.CW);
        goto L20
    L13:
        r104 = false;
        goto L14
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.softwareRoundClipEnabled == true) goto L5;
    L16:
        super.draw(r100);
        return;
    L5:
        if (this.mIsOval == false) goto L7;
    L11:
        int r101 = r100.save();
        getMClipRectF().set(0.0f, 0.0f, getWidth(), getHeight());
        getMClipPath().reset();
        if (this.mIsOval == false) goto L14;
        getMClipPath().addOval(getMClipRectF(), Path.Direction.CW);
    L15:
        r100.clipPath(getMClipPath());
        super.draw(r100);
        r100.restoreToCount(r101);
        return;
    L14:
        Path r102 = getMClipPath();
        RectF r103 = getMClipRectF();
        float r104 = this.mRadius;
        r102.addRoundRect(r103, r104, r104, Path.Direction.CW);
        goto L15
    L7:
        if (this.mRadius != 0.0f) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L16;
    L9:
        r105 = false;
        goto L10
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        drawBorderIfNeed(r100);
    }

    public final void setBorderColor(int r100) {
        this.mBorderColor = r100;
        invalidate();
    }

    public final void setBorderDrawable(Drawable r100) {
        this.mBorderDrawable = r100;
        invalidate();
    }

    public final void setBorderWidth(float r100) {
        this.mBorderWidth = r100;
        invalidate();
    }

    public final void setBorderWidthInDp(float r100) {
        setBorderWidth(j08.b.a(getContext(), r100));
    }

    public final void setOval(boolean r100) {
        this.mIsOval = r100;
        setClipOutlineIfNeed();
    }

    public final void setRadius(float r100) {
        this.mRadius = r100;
        setClipOutlineIfNeed();
    }

    public final void setRadiusInDp(float r100) {
        setRadius(j08.b.a(getContext(), r100));
    }

    public final void setSoftwareRoundClipEnabled(boolean r100) {
        this.softwareRoundClipEnabled = r100;
    }

    public LKUIRoundedImageView2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.border_color, R.attr.border_drawable, R.attr.border_width, R.attr.oval, R.attr.radius}, 0, 0);
        float r104 = r103.getDimension(4, 0.0f);
        boolean r105 = r103.getBoolean(3, false);
        float r106 = r103.getDimension(2, 0.0f);
        int r107 = r103.getColor(0, ContextCompat.getColor(r100, R.color.lkui_N200));
        Drawable r108 = r103.getDrawable(1);
        r103.recycle();
        setRadius(r104);
        setOval(r105);
        setBorderWidth(r106);
        setBorderColor(r107);
        setBorderDrawable(r108);
        this.mBoardPaint$delegate = LazyKt.lazy(LKUIRoundedImageView2$mBoardPaint$2.INSTANCE);
        this.mBorderPath$delegate = LazyKt.lazy(LKUIRoundedImageView2$mBorderPath$2.INSTANCE);
        this.mBordRectF$delegate = LazyKt.lazy(LKUIRoundedImageView2$mBordRectF$2.INSTANCE);
        this.mClipPath$delegate = LazyKt.lazy(LKUIRoundedImageView2$mClipPath$2.INSTANCE);
        this.mClipRectF$delegate = LazyKt.lazy(LKUIRoundedImageView2$mClipRectF$2.INSTANCE);
    }

    public /* synthetic */ LKUIRoundedImageView2(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
