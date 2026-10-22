package com.ss.android.ugc.tools.view.style;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002IJB'\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\b\b\u0002\u0010F\u001a\u00020\u0017¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010=\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001bR\u0014\u0010A\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u001b¨\u0006K"}, d2 = {"Lcom/ss/android/ugc/tools/view/style/StyleSwitch;", "Landroid/view/View;", "Lcom/ss/android/ugc/tools/view/style/StyleSwitch$c;", "mOnCheckedChangeListener", "", "setOnCheckedChangeListener", "", "isChecked", "setChecked", "setCheckedWithoutAnimator", "enableTouch", "setEnableTouch", "", "position", "setThumbPosition", "Landroid/graphics/drawable/Drawable;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/graphics/drawable/Drawable;", "getThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "thumbDrawable", "", "d", "I", "getTrackPadding", "()I", "setTrackPadding", "(I)V", "trackPadding", "e", "getTrackRadius", "setTrackRadius", "trackRadius", "Landroid/graphics/Rect;", "f", "Landroid/graphics/Rect;", "getThumbRect", "()Landroid/graphics/Rect;", "setThumbRect", "(Landroid/graphics/Rect;)V", "thumbRect", "Landroid/content/res/ColorStateList;", RXScreenCaptureService.KEY_INDEX, "Landroid/content/res/ColorStateList;", "getTrackTintList", "()Landroid/content/res/ColorStateList;", "setTrackTintList", "(Landroid/content/res/ColorStateList;)V", "trackTintList", "Landroid/animation/ObjectAnimator;", ce.f26395j, "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mPositionAnimator", "getTargetCheckedState", "()Z", "targetCheckedState", "getThumbOffset", "thumbOffset", "getThumbScrollRange", "thumbScrollRange", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class StyleSwitch extends View {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f454939s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f454940t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f454941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f454942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f454943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f454944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f454945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect f454946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f454947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f454948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ColorStateList f454949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObjectAnimator f454950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f454951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f454952l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f454953m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final VelocityTracker f454954n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f454955o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f454956p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f454957q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f454958r;

    public static final class a extends Property<StyleSwitch, Float> {
        public a(Class r100) {
            super(r100, "thumbPos");
        }

        @Override // android.util.Property
        public final Float get(StyleSwitch r100) {
            StyleSwitch r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "styleSwitch");
            return Float.valueOf(r101.f454942b);
        }

        @Override // android.util.Property
        public final void set(StyleSwitch r100, Float r101) {
            StyleSwitch r102 = r100;
            float r103 = r101.floatValue();
            Intrinsics.checkNotNullParameter(r102, "styleSwitch");
            r102.setThumbPosition(r103);
        }
    }

    public static final class b {
    }

    public interface c {
    }

    public StyleSwitch(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StyleSwitch(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setOnCheckedChangeListener(c r100) {
    }

    static {
        f454939s = new int[]{R.attr.switch_state_checked};
        f454940t = new a(Float.TYPE);
    }

    private final boolean getTargetCheckedState() {
        if (this.f454942b <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbOffset() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        float r100 = 1 - this.f454942b;
    L7:
        return (int) ((r100 * getThumbScrollRange()) + 0.5f);
    L5:
        r100 = this.f454942b;
        goto L7
    }

    private final int getThumbScrollRange() {
        return getMeasuredWidth() - this.f454943c;
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.f454950j;
    }

    public final Drawable getThumbDrawable() {
        return this.f454941a;
    }

    public final Rect getThumbRect() {
        return this.f454946f;
    }

    public final int getTrackPadding() {
        return this.f454944d;
    }

    public final int getTrackRadius() {
        return this.f454945e;
    }

    public final ColorStateList getTrackTintList() {
        return this.f454949i;
    }

    @Override // android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f454948h == false) goto L5;
        View.mergeDrawableStates(r101, f454939s);
    L5:
        return r101;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int[] r101 = getDrawableState();
        ColorStateList r102 = this.f454949i;
        if (r102 == null) goto L5;
        Paint r103 = this.f454951k;
        Intrinsics.checkNotNull(r102);
        r103.setColor(r102.getColorForState(r101, -65536));
    L5:
        RectF r104 = this.f454947g;
        r104.left = 0.0f;
        r104.right = getMeasuredWidth();
        RectF r105 = this.f454947g;
        r105.top = this.f454944d;
        r105.bottom = getMeasuredHeight() - this.f454944d;
        RectF r106 = this.f454947g;
        int r107 = this.f454945e;
        r100.drawRoundRect(r106, r107, r107, this.f454951k);
        this.f454946f.left = getThumbOffset();
        Rect r108 = this.f454946f;
        r108.right = r108.left + this.f454943c;
        Drawable r109 = this.f454941a;
        if (r109 == null) goto L9;
        Intrinsics.checkNotNull(r109);
        r109.setBounds(this.f454946f);
        Drawable r110 = this.f454941a;
        Intrinsics.checkNotNull(r110);
        r110.setState(r101);
        Drawable r111 = this.f454941a;
        Intrinsics.checkNotNull(r111);
        r111.draw(r100);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f454958r == true) goto L5;
        return false;
    L5:
        this.f454954n.addMovement(r100);
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L8;
        float r102 = r100.getX();
        float r103 = r100.getY();
        if (isEnabled() == false) goto L74;
        this.f454955o = 1;
        this.f454956p = r102;
        this.f454957q = r103;
    L74:
        return true;
    L8:
        if (r101 == 1) goto L44;
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L44;
    L12:
        int r104 = this.f454955o;
        if (r104 == 1) goto L37;
        if (r104 != 2) goto L74;
        float r105 = r100.getX();
        int r106 = getThumbScrollRange();
        float r107 = r105 - this.f454956p;
        float r108 = 1.0f;
        if (r106 == 0) goto L20;
        float r109 = r107 / r106;
    L24:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L26;
        r109 = -r109;
    L26:
        float r110 = this.f454942b;
        float r111 = r109 + r110;
        if (r111 >= 0.0f) goto L30;
        r108 = 0.0f;
    L34:
        if (r108 == r110) goto L36;
        this.f454956p = r105;
        setThumbPosition(r108);
    L36:
        return true;
    L30:
        if (r111 > 1.0f) goto L34;
        r108 = r111;
        goto L34
    L20:
        if (r107 <= 0) goto L22;
        r109 = 1.0f;
        goto L24
    L22:
        r109 = -1;
        goto L24
    L37:
        float r112 = r100.getX();
        float r113 = r100.getY();
        if (Math.abs(r112 - this.f454956p) <= this.f454952l) goto L40;
    L41:
        this.f454955o = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f454956p = r112;
        this.f454957q = r113;
        return true;
    L40:
        if (Math.abs(r113 - this.f454957q) <= this.f454952l) goto L74;
    L44:
        if (this.f454955o != 2) goto L70;
        this.f454955o = 0;
        if (r100.getAction() == 1) goto L48;
    L50:
        boolean r114 = false;
    L51:
        boolean r115 = this.f454948h;
        if (r114 == false) goto L65;
        this.f454954n.computeCurrentVelocity(1000);
        float r116 = this.f454954n.getXVelocity();
        if (Math.abs(r116) > this.f454953m) goto L56;
        boolean r117 = getTargetCheckedState();
    L66:
        if (r117 == r115) goto L68;
        playSoundEffect(0);
    L68:
        setChecked(r117);
        MotionEvent r118 = MotionEvent.obtain(r100);
        r118.setAction(3);
        super.onTouchEvent(r118);
        r118.recycle();
        super.onTouchEvent(r100);
        return true;
    L56:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L61;
        if (r116 < 0) goto L62;
    L63:
        r117 = false;
    L62:
        r117 = true;
        goto L66
    L61:
        if (r116 <= 0) goto L63;
    L65:
        r117 = r115;
        goto L66
    L48:
        if (isEnabled() == false) goto L50;
        r114 = true;
        goto L51
    L70:
        this.f454955o = 0;
        this.f454954n.clear();
        goto L74
    }

    public final void setChecked(boolean r100) {
        if (this.f454948h == r100) goto L5;
        this.f454948h = r100;
    L5:
        refreshDrawableState();
        float r101 = 1.0f;
        if (getWindowToken() != null) goto L8;
    L21:
        ObjectAnimator r102 = this.f454950j;
        if (r102 == null) goto L24;
        Intrinsics.checkNotNull(r102);
        r102.cancel();
    L24:
        if (r100 == true) goto L27;
        r101 = 0;
    L27:
        setThumbPosition(r101);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L21;
        if (r100 == true) goto L12;
        r101 = 0;
    L12:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, f454940t, new float[]{r101});
        this.f454950j = r103;
        if (r103 == null) goto L15;
        r103.setDuration(250);
    L15:
        ObjectAnimator r104 = this.f454950j;
        if (r104 == null) goto L18;
        r104.setAutoCancel(true);
    L18:
        ObjectAnimator r105 = this.f454950j;
        if (r105 == null) goto L29;
        r105.start();
        return;
    }

    public final void setCheckedWithoutAnimator(boolean r100) {
        if (this.f454948h == r100) goto L5;
        this.f454948h = r100;
    L5:
        refreshDrawableState();
        ObjectAnimator r101 = this.f454950j;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r101.cancel();
    L8:
        if (r100 == false) goto L10;
        float r102 = 1.0f;
    L11:
        setThumbPosition(r102);
        return;
    L10:
        r102 = 0;
        goto L11
    }

    public final void setEnableTouch(boolean r100) {
        this.f454958r = r100;
    }

    public final void setMPositionAnimator(ObjectAnimator r100) {
        this.f454950j = r100;
    }

    public final void setThumbDrawable(Drawable r100) {
        this.f454941a = r100;
    }

    public final void setThumbPosition(float r100) {
        this.f454942b = r100;
        invalidate();
    }

    public final void setThumbRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454946f = r100;
    }

    public final void setTrackPadding(int r100) {
        this.f454944d = r100;
    }

    public final void setTrackRadius(int r100) {
        this.f454945e = r100;
    }

    public final void setTrackTintList(ColorStateList r100) {
        this.f454949i = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        Drawable r102 = this.f454941a;
        if (r102 != null) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        Intrinsics.checkNotNull(r102);
        int r103 = r102.getIntrinsicWidth();
        Drawable r104 = this.f454941a;
        Intrinsics.checkNotNull(r104);
        int r105 = r104.getIntrinsicHeight();
        Rect r106 = this.f454946f;
        r106.left = 0;
        r106.top = 0;
        r106.right = r103;
        this.f454943c = r103;
        r106.bottom = r105;
        Drawable r107 = this.f454941a;
        Intrinsics.checkNotNull(r107);
        r107.setBounds(this.f454946f);
        int r108 = View.MeasureSpec.getMode(r100);
        int r109 = View.MeasureSpec.getSize(r100);
        if (r108 != 1073741824) goto L9;
        setMeasuredDimension(r109, r105);
        return;
    L9:
        setMeasuredDimension(r103 * 2, r105);
    }

    public StyleSwitch(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f454951k = r103;
        this.f454954n = VelocityTracker.obtain();
        this.f454958r = true;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.tools_thumb, R.attr.tools_track_padding, R.attr.tools_track_radius, R.attr.tools_track_tint});
        this.f454941a = r104.getDrawable(0);
        this.f454949i = r104.getColorStateList(3);
        this.f454944d = r104.getDimensionPixelOffset(1, 0);
        this.f454945e = r104.getDimensionPixelOffset(2, 0);
        r104.recycle();
        r103.setAntiAlias(true);
        this.f454946f = new Rect();
        this.f454947g = new RectF();
        ViewConfiguration r105 = ViewConfiguration.get(r100);
        this.f454952l = r105.getScaledTouchSlop();
        this.f454953m = r105.getScaledMinimumFlingVelocity();
    }

    public /* synthetic */ StyleSwitch(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
