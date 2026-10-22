package com.bytedance.ies.dmt.ui.widget.setting.checkable;

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
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public class DmtSettingSwitch extends View {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f248457u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f248458v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f248459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f248460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f248461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f248462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f248463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect f248464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f248465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f248466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ColorStateList f248467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObjectAnimator f248468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f248469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f248470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f248471m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final VelocityTracker f248472n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f248473o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f248474p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f248475q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f248476r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f248477s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f248478t;

    public class a extends Property<DmtSettingSwitch, Float> {
        public a(Class r100) {
            super(r100, "thumbPos");
        }

        @Override // android.util.Property
        public final Float get(DmtSettingSwitch r100) {
            return Float.valueOf(r100.f248460b);
        }

        @Override // android.util.Property
        public final void set(DmtSettingSwitch r100, Float r101) {
            r100.setThumbPosition(r101.floatValue());
        }
    }

    public interface b {
    }

    static {
        f248457u = new int[]{R.attr.switch_state_checked};
        f248458v = new a(Float.class);
    }

    public void setOnCheckedChangeListener(b r100) {
    }

    private boolean getTargetCheckedState() {
        if (this.f248460b <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private int getThumbOffset() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        float r100 = 1.0f - this.f248460b;
    L7:
        return (int) ((r100 * getThumbScrollRange()) + 0.5f);
    L5:
        r100 = this.f248460b;
        goto L7
    }

    private int getThumbScrollRange() {
        return getMeasuredWidth() - this.f248461c;
    }

    public Drawable getThumbDrawable() {
        return this.f248459a;
    }

    public Rect getThumbRect() {
        return this.f248464f;
    }

    public int getTrackPadding() {
        return this.f248462d;
    }

    public int getTrackRadius() {
        return this.f248463e;
    }

    public ColorStateList getTrackTintList() {
        return this.f248467i;
    }

    public DmtSettingSwitch(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f248466h == false) goto L5;
        View.mergeDrawableStates(r101, f248457u);
    L5:
        return r101;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int[] r101 = getDrawableState();
        ColorStateList r102 = this.f248467i;
        if (r102 == null) goto L5;
        this.f248469k.setColor(r102.getColorForState(r101, -65536));
    L5:
        RectF r103 = this.f248465g;
        r103.left = 0.0f;
        r103.right = getMeasuredWidth();
        RectF r104 = this.f248465g;
        r104.top = this.f248462d;
        r104.bottom = getMeasuredHeight() - this.f248462d;
        RectF r105 = this.f248465g;
        int r106 = this.f248463e;
        r100.drawRoundRect(r105, r106, r106, this.f248469k);
        this.f248464f.left = getThumbOffset();
        Rect r107 = this.f248464f;
        r107.right = r107.left + this.f248461c;
        Drawable r108 = this.f248459a;
        if (r108 == null) goto L9;
        r108.setBounds(r107);
        this.f248459a.setState(r101);
        this.f248459a.draw(r100);
        return;
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r100) {
        super.onPopulateAccessibilityEvent(r100);
        if (this.f248466h == false) goto L5;
        String r101 = this.f248476r;
    L6:
        if (r101 == null) goto L9;
        r100.getText().add(r101);
        return;
    L9:
        return;
    L5:
        r101 = this.f248477s;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f248478t == true) goto L5;
        return false;
    L5:
        this.f248472n.addMovement(r100);
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L71;
        float r102 = 0.0f;
        if (r101 == 1) goto L44;
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L44;
    L74:
        return true;
    L12:
        int r103 = this.f248473o;
        if (r103 == 1) goto L37;
        if (r103 != 2) goto L74;
        float r104 = r100.getX();
        int r105 = getThumbScrollRange();
        float r106 = r104 - this.f248474p;
        if (r105 == 0) goto L20;
        float r107 = r106 / r105;
    L24:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L26;
        r107 = -r107;
    L26:
        float r108 = this.f248460b;
        float r109 = r107 + r108;
        if (r109 < 0.0f) goto L34;
        if (r109 <= 1.0f) goto L32;
        r102 = 1.0f;
        goto L34
    L32:
        r102 = r109;
    L34:
        if (r102 == r108) goto L36;
        this.f248474p = r104;
        setThumbPosition(r102);
    L36:
        return true;
    L20:
        if (r106 <= 0.0f) goto L22;
        r107 = 1.0f;
        goto L24
    L22:
        r107 = -1.0f;
        goto L24
    L37:
        float r110 = r100.getX();
        float r111 = r100.getY();
        if (Math.abs(r110 - this.f248474p) <= this.f248470l) goto L40;
    L41:
        this.f248473o = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f248474p = r110;
        this.f248475q = r111;
        return true;
    L40:
        if (Math.abs(r111 - this.f248475q) <= this.f248470l) goto L74;
    L44:
        if (this.f248473o != 2) goto L70;
        this.f248473o = 0;
        if (r100.getAction() == 1) goto L48;
    L50:
        boolean r112 = false;
    L51:
        boolean r113 = this.f248466h;
        if (r112 == false) goto L65;
        this.f248472n.computeCurrentVelocity(1000);
        float r114 = this.f248472n.getXVelocity();
        if (Math.abs(r114) > this.f248471m) goto L56;
        boolean r115 = getTargetCheckedState();
    L66:
        if (r115 == r113) goto L68;
        playSoundEffect(0);
    L68:
        setChecked(r115);
        MotionEvent r116 = MotionEvent.obtain(r100);
        r116.setAction(3);
        super.onTouchEvent(r116);
        r116.recycle();
        super.onTouchEvent(r100);
        return true;
    L56:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L61;
        if (r114 < 0.0f) goto L62;
    L63:
        r115 = false;
    L62:
        r115 = true;
        goto L66
    L61:
        if (r114 <= 0.0f) goto L63;
    L65:
        r115 = r113;
        goto L66
    L48:
        if (isEnabled() == false) goto L50;
        r112 = true;
        goto L51
    L70:
        this.f248473o = 0;
        this.f248472n.clear();
        goto L74
    L71:
        float r117 = r100.getX();
        float r118 = r100.getY();
        if (isEnabled() == false) goto L74;
        this.f248473o = 1;
        this.f248474p = r117;
        this.f248475q = r118;
        goto L74
    }

    public void setChecked(boolean r100) {
        if (this.f248466h == r100) goto L5;
        this.f248466h = r100;
    L5:
        refreshDrawableState();
        float r101 = 0.0f;
        if (getWindowToken() != null) goto L8;
    L12:
        ObjectAnimator r102 = this.f248468j;
        if (r102 == null) goto L15;
        r102.cancel();
    L15:
        if (r100 == false) goto L17;
        r101 = 1.0f;
    L17:
        setThumbPosition(r101);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L12;
        if (r100 == false) goto L11;
        r101 = 1.0f;
    L11:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, f248458v, new float[]{r101});
        this.f248468j = r103;
        r103.setDuration(250);
        this.f248468j.setAutoCancel(true);
        this.f248468j.start();
    }

    public void setCheckedWithoutAnimator(boolean r100) {
        if (this.f248466h == r100) goto L5;
        this.f248466h = r100;
    L5:
        refreshDrawableState();
        ObjectAnimator r101 = this.f248468j;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        if (r100 == false) goto L10;
        float r102 = 1.0f;
    L11:
        setThumbPosition(r102);
        return;
    L10:
        r102 = 0.0f;
        goto L11
    }

    public void setEnableTouch(boolean r100) {
        this.f248478t = r100;
    }

    public void setThumbDrawable(Drawable r100) {
        this.f248459a = r100;
    }

    public void setThumbPosition(float r100) {
        this.f248460b = r100;
        invalidate();
    }

    public void setThumbRect(Rect r100) {
        this.f248464f = r100;
    }

    public void setTrackPadding(int r100) {
        this.f248462d = r100;
    }

    public void setTrackRadius(int r100) {
        this.f248463e = r100;
    }

    public void setTrackTintList(ColorStateList r100) {
        this.f248467i = r100;
    }

    public DmtSettingSwitch(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        Drawable r102 = this.f248459a;
        if (r102 != null) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        int r103 = r102.getIntrinsicWidth();
        int r104 = this.f248459a.getIntrinsicHeight();
        Rect r105 = this.f248464f;
        r105.left = 0;
        r105.top = 0;
        r105.right = r103;
        this.f248461c = r103;
        r105.bottom = r104;
        this.f248459a.setBounds(r105);
        int r106 = View.MeasureSpec.getMode(r100);
        int r107 = View.MeasureSpec.getSize(r100);
        if (r106 != 1073741824) goto L9;
        setMeasuredDimension(r107, r104);
        return;
    L9:
        setMeasuredDimension(r103 * 2, r104);
    }

    public DmtSettingSwitch(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f248466h = false;
        Paint r103 = new Paint();
        this.f248469k = r103;
        this.f248472n = VelocityTracker.obtain();
        this.f248478t = true;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.thumb, R.attr.track_padding, R.attr.track_radius, R.attr.track_tint});
        this.f248459a = r104.getDrawable(0);
        this.f248467i = r104.getColorStateList(3);
        this.f248462d = r104.getDimensionPixelOffset(1, 0);
        this.f248463e = r104.getDimensionPixelOffset(2, 0);
        this.f248476r = r100.getString(R.string.content_description_button_on);
        this.f248477s = r100.getString(R.string.content_description_button_off);
        r104.recycle();
        r103.setAntiAlias(true);
        this.f248464f = new Rect();
        this.f248465g = new RectF();
        ViewConfiguration r105 = ViewConfiguration.get(r100);
        this.f248470l = r105.getScaledTouchSlop();
        this.f248471m = r105.getScaledMinimumFlingVelocity();
    }
}
