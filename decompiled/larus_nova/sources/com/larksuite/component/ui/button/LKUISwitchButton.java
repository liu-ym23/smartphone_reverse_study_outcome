package com.larksuite.component.ui.button;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes24.dex */
public class LKUISwitchButton extends CompoundButton {
    public static final int[] W = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int[] f284086k0 = null;
    public boolean A;
    public boolean B;
    public ObjectAnimator C;
    public float D;
    public RectF E;
    public float F;
    public float G;
    public float H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f284087J;
    public Paint K;
    public CharSequence L;
    public CharSequence M;
    public TextPaint N;
    public Layout O;
    public Layout P;
    public float Q;
    public float R;
    public float S;
    public boolean T;
    public boolean U;
    public CompoundButton.OnCheckedChangeListener V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f284088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f284089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f284090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f284091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f284092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f284093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f284094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f284095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f284096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f284097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f284098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PointF f284099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f284100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f284101n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f284102o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f284103p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f284104q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f284105r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f284106s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RectF f284107t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RectF f284108u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RectF f284109v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RectF f284110w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RectF f284111x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Paint f284112y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f284113z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f284114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f284115b;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f284114a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
            this.f284115b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100);
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            TextUtils.writeToParcel(this.f284114a, r100, r101);
            TextUtils.writeToParcel(this.f284115b, r100, r101);
        }
    }

    static {
        W = new int[]{R.attr.state_checked, R.attr.state_enabled, R.attr.state_pressed};
        f284086k0 = new int[]{-16842912, R.attr.state_enabled, R.attr.state_pressed};
    }

    public PointF getBackSizeF() {
        return new PointF(this.f284108u.width(), this.f284108u.height());
    }

    public float getThumbHeight() {
        return this.f284099l.y;
    }

    public float getThumbWidth() {
        return this.f284099l.x;
    }

    private boolean getStatusBasedOnPos() {
        if (getProcess() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        float r100 = 0.0f;
        float r101 = getPaddingTop() + Math.max(0.0f, this.f284094g.top);
        float r102 = getPaddingLeft() + Math.max(0.0f, this.f284094g.left);
        if (this.O == null) goto L10;
        if (this.P == null) goto L10;
        RectF r103 = this.f284094g;
        if ((r103.top + r103.bottom) <= 0.0f) goto L10;
        float r104 = ((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.f284099l.y;
        RectF r105 = this.f284094g;
        r101 = r101 + (((r104 - r105.top) - r105.bottom) / 2.0f);
    L10:
        if (this.f284113z == false) goto L12;
        PointF r106 = this.f284099l;
        r106.x = Math.max(r106.x, this.f284088a.getMinimumWidth());
        PointF r107 = this.f284099l;
        r107.y = Math.max(r107.y, this.f284088a.getMinimumHeight());
    L12:
        RectF r108 = this.f284107t;
        PointF r109 = this.f284099l;
        r108.set(r102, r101, r109.x + r102, r109.y + r101);
        float r110 = this.f284107t.left - this.f284094g.left;
        float r111 = this.f284099l.x;
        float r112 = Math.min(0.0f, ((Math.max(this.f284095h * r111, r111 + this.Q) - this.f284107t.width()) - this.Q) / 2.0f);
        float r113 = this.f284107t.height();
        RectF r114 = this.f284094g;
        float r115 = Math.min(0.0f, (((r113 + r114.top) + r114.bottom) - this.R) / 2.0f);
        RectF r116 = this.f284108u;
        float r117 = r110 + r112;
        float r118 = this.f284107t.top;
        RectF r119 = this.f284094g;
        float r120 = (r118 - r119.top) + r115;
        float r121 = r110 + r119.left;
        float r122 = this.f284099l.x;
        float r123 = r121 + Math.max(this.f284095h * r122, r122 + this.Q);
        RectF r124 = this.f284094g;
        r116.set(r117, r120, (r123 + r124.right) - r112, (this.f284107t.bottom + r124.bottom) - r115);
        RectF r125 = this.f284109v;
        RectF r126 = this.f284107t;
        r125.set(r126.left, 0.0f, (this.f284108u.right - this.f284094g.right) - r126.width(), 0.0f);
        this.f284093f = Math.min(Math.min(this.f284108u.width(), this.f284108u.height()) / 2.0f, this.f284093f);
        Drawable r127 = this.f284089b;
        if (r127 == null) goto L16;
        RectF r128 = this.f284108u;
        r127.setBounds((int) r128.left, (int) r128.top, (int) Math.ceil(r128.right), (int) Math.ceil(this.f284108u.bottom));
    L16:
        if (this.O == null) goto L28;
        RectF r129 = this.f284108u;
        float r130 = r129.left + ((((r129.width() - this.f284107t.width()) - this.f284094g.right) - this.O.getWidth()) / 2.0f);
        float r131 = this.f284094g.left;
        if (r131 >= 0.0f) goto L20;
        float r132 = r131 * (-0.5f);
    L21:
        float r133 = r130 + r132;
        if (this.A == false) goto L24;
    L26:
        RectF r134 = this.f284108u;
        float r135 = r134.top + ((r134.height() - this.O.getHeight()) / 2.0f);
        this.f284110w.set(r133, r135, this.O.getWidth() + r133, this.O.getHeight() + r135);
        goto L28
    L24:
        if (this.T == false) goto L26;
        r133 = r133 + (this.f284093f / 4.0f);
        goto L26
    L20:
        r132 = 0.0f;
    L28:
        if (this.P == null) goto L39;
        RectF r136 = this.f284108u;
        float r137 = (r136.right - ((((r136.width() - this.f284107t.width()) - this.f284094g.left) - this.P.getWidth()) / 2.0f)) - this.P.getWidth();
        float r138 = this.f284094g.right;
        if (r138 >= 0.0f) goto L32;
        r100 = 0.5f * r138;
    L32:
        float r139 = r137 + r100;
        if (this.A == false) goto L35;
    L37:
        RectF r140 = this.f284108u;
        float r141 = r140.top + ((r140.height() - this.P.getHeight()) / 2.0f);
        this.f284111x.set(r139, r141, this.P.getWidth() + r139, this.P.getHeight() + r141);
        return;
    L35:
        if (this.T == false) goto L37;
        r139 = r139 - (this.f284093f / 4.0f);
        goto L37
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f284113z == true) goto L7;
        ColorStateList r100 = this.f284091d;
        if (r100 == null) goto L7;
        this.f284100m = r100.getColorForState(getDrawableState(), this.f284100m);
    L8:
        boolean r101 = isChecked();
        int[] r102 = f284086k0;
        int[] r103 = W;
        if (r101 == false) goto L11;
        int[] r104 = r102;
    L12:
        ColorStateList r105 = getTextColors();
        if (r105 == null) goto L16;
        int r106 = r105.getDefaultColor();
        this.f284103p = r105.getColorForState(r103, r106);
        this.f284104q = r105.getColorForState(r102, r106);
    L16:
        if (this.A == true) goto L20;
        ColorStateList r107 = this.f284090c;
        if (r107 == null) goto L20;
        int r108 = r107.getColorForState(getDrawableState(), this.f284101n);
        this.f284101n = r108;
        this.f284102o = this.f284090c.getColorForState(r104, r108);
        return;
    L20:
        Drawable r109 = this.f284089b;
        if ((r109 instanceof StateListDrawable) == true) goto L23;
    L25:
        this.f284106s = null;
    L26:
        setDrawableState(this.f284089b);
        Drawable r110 = this.f284089b;
        if (r110 == null) goto L31;
        this.f284105r = r110.getCurrent().mutate();
        return;
    L31:
        return;
    L23:
        if (this.f284097j == false) goto L25;
        r109.setState(r104);
        this.f284106s = this.f284089b.getCurrent().mutate();
        goto L26
    L11:
        r104 = r103;
    L7:
        setDrawableState(this.f284088a);
        goto L8
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f284114a = this.L;
        r100.f284115b = this.M;
        return r100;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    public long getAnimationDuration() {
        return this.f284096i;
    }

    public ColorStateList getBackColor() {
        return this.f284090c;
    }

    public Drawable getBackDrawable() {
        return this.f284089b;
    }

    public float getBackMeasureRatio() {
        return this.f284095h;
    }

    public float getBackRadius() {
        return this.f284093f;
    }

    public final float getProcess() {
        return this.D;
    }

    public ColorStateList getThumbColor() {
        return this.f284091d;
    }

    public Drawable getThumbDrawable() {
        return this.f284088a;
    }

    public RectF getThumbMargin() {
        return this.f284094g;
    }

    public float getThumbRadius() {
        return this.f284092e;
    }

    public PointF getThumbSizeF() {
        return this.f284099l;
    }

    public int getTintColor() {
        return this.f284098k;
    }

    public LKUISwitchButton(Context r100) {
        this(r100, null, 0);
    }

    private void setDrawableState(Drawable r100) {
        if (r100 == null) goto L5;
        r100.setState(getDrawableState());
        invalidate();
        return;
    }

    public final void a(boolean r100) {
        ObjectAnimator r101 = this.C;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.isRunning() == false) goto L8;
        this.C.cancel();
    L8:
        this.C.setDuration(this.f284096i);
        if (r100 == false) goto L11;
        this.C.setFloatValues(new float[]{this.D, 1.0f});
    L12:
        this.C.start();
        return;
    L11:
        this.C.setFloatValues(new float[]{this.D, 0.0f});
        goto L12
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.A == false) goto L21;
        if (this.f284097j == true) goto L7;
    L19:
        this.f284089b.setAlpha(255);
        this.f284089b.draw(r110);
    L33:
        if (getProcess() <= 0.5d) goto L35;
        Layout r100 = this.O;
    L37:
        if (getProcess() <= 0.5d) goto L39;
        RectF r101 = this.f284110w;
    L41:
        if (r100 == null) goto L55;
        if (r101 == null) goto L55;
        if (getProcess() < 0.75d) goto L47;
        float r102 = (getProcess() * 4.0f) - 3.0f;
    L50:
        int r103 = (int) (r102 * 255.0f);
        if (getProcess() <= 0.5d) goto L53;
        int r104 = this.f284103p;
    L54:
        r100.getPaint().setARGB((Color.alpha(r104) * r103) / 255, Color.red(r104), Color.green(r104), Color.blue(r104));
        r110.save();
        r110.translate(r101.left, r101.top);
        r100.draw(r110);
        r110.restore();
        goto L55
    L53:
        r104 = this.f284104q;
        goto L54
    L47:
        if (getProcess() >= 0.25d) goto L49;
        r102 = 1.0f - (getProcess() * 4.0f);
        goto L50
    L49:
        r102 = 0.0f;
    L55:
        this.E.set(this.f284107t);
        this.E.offset(this.D * this.f284109v.width(), 0.0f);
        if (this.f284113z == false) goto L58;
        Drawable r105 = this.f284088a;
        RectF r106 = this.E;
        r105.setBounds((int) r106.left, (int) r106.top, (int) Math.ceil(r106.right), (int) Math.ceil(this.E.bottom));
        this.f284088a.draw(r110);
    L60:
        if (this.B == false) goto L67;
        this.K.setColor(ColorProtector.parseColor("#AA0000"));
        r110.drawRect(this.f284108u, this.K);
        this.K.setColor(ColorProtector.parseColor("#0000FF"));
        r110.drawRect(this.E, this.K);
        this.K.setColor(ColorProtector.parseColor("#00CC00"));
        if (getProcess() <= 0.5d) goto L64;
        RectF r107 = this.f284110w;
    L65:
        r110.drawRect(r107, this.K);
        return;
    L64:
        r107 = this.f284111x;
        goto L65
    L67:
        return;
    L58:
        this.f284112y.setColor(this.f284100m);
        RectF r108 = this.E;
        float r109 = this.f284092e;
        r110.drawRoundRect(r108, r109, r109, this.f284112y);
        goto L60
    L39:
        r101 = this.f284111x;
        goto L41
    L35:
        r100 = this.P;
        goto L37
    L7:
        if (this.f284105r == null) goto L19;
        if (this.f284106s == null) goto L19;
        if (isChecked() == false) goto L13;
        Drawable r111 = this.f284105r;
    L15:
        if (isChecked() == false) goto L17;
        Drawable r112 = this.f284106s;
    L18:
        int r113 = (int) (getProcess() * 255.0f);
        r111.setAlpha(r113);
        r111.draw(r110);
        r112.setAlpha(255 - r113);
        r112.draw(r110);
        goto L33
    L17:
        r112 = this.f284105r;
        goto L18
    L13:
        r111 = this.f284106s;
        goto L15
    L21:
        if (this.f284097j == true) goto L23;
        this.f284112y.setColor(this.f284101n);
        RectF r114 = this.f284108u;
        float r115 = this.f284093f;
        r110.drawRoundRect(r114, r115, r115, this.f284112y);
        goto L33
    L23:
        if (isChecked() == false) goto L25;
        int r116 = this.f284101n;
    L27:
        if (isChecked() == false) goto L29;
        int r117 = this.f284102o;
    L30:
        int r118 = (int) (getProcess() * 255.0f);
        this.f284112y.setARGB((Color.alpha(r116) * r118) / 255, Color.red(r116), Color.green(r116), Color.blue(r116));
        RectF r119 = this.f284108u;
        float r120 = this.f284093f;
        r110.drawRoundRect(r119, r120, r120, this.f284112y);
        this.f284112y.setARGB((Color.alpha(r117) * (255 - r118)) / 255, Color.red(r117), Color.green(r117), Color.blue(r117));
        RectF r121 = this.f284108u;
        float r122 = this.f284093f;
        r110.drawRoundRect(r121, r122, r122, this.f284112y);
        this.f284112y.setAlpha(255);
        goto L33
    L29:
        r117 = this.f284101n;
        goto L30
    L25:
        r116 = this.f284102o;
        goto L27
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        CharSequence r102 = r101.f284114a;
        CharSequence r103 = r101.f284115b;
        this.L = r102;
        this.M = r103;
        this.O = null;
        this.P = null;
        requestLayout();
        invalidate();
        this.U = true;
        super.onRestoreInstanceState(r101.getSuperState());
        this.U = false;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (isEnabled() == true) goto L5;
    L37:
        return false;
    L5:
        if (isClickable() == false) goto L37;
        if (isFocusable() == false) goto L37;
        int r100 = r110.getAction();
        float r101 = r110.getX() - this.F;
        float r102 = r110.getY() - this.G;
        if (r100 == 0) goto L32;
        if (r100 != 1) goto L13;
    L18:
        setPressed(false);
        boolean r103 = getStatusBasedOnPos();
        long r104 = r110.getEventTime() - r110.getDownTime();
        if (r104 <= 0) goto L36;
        int r111 = this.I;
        if (r101 >= r111) goto L29;
        if (r102 >= r111) goto L29;
        if (r104 >= this.f284087J) goto L29;
        performClick();
    L29:
        if (r103 == isChecked()) goto L31;
        playSoundEffect(0);
        setChecked(r103);
        goto L36
    L31:
        a(r103);
    L36:
        return true;
    L13:
        if (r100 != 2) goto L15;
        float r112 = r110.getX();
        setProcess(getProcess() + ((r112 - this.H) / this.f284109v.width()));
        this.H = r112;
        goto L36
    L15:
        if (r100 == 3) goto L18;
    L32:
        ViewParent r105 = getParent();
        if (r105 == null) goto L35;
        r105.requestDisallowInterceptTouchEvent(true);
    L35:
        this.F = r110.getX();
        this.G = r110.getY();
        this.H = this.F;
        setPressed(true);
        goto L36
    }

    public void setAnimationDuration(long r100) {
        this.f284096i = r100;
    }

    public void setBackColor(ColorStateList r100) {
        this.f284090c = r100;
        if (r100 == null) goto L5;
        setBackDrawable(null);
    L5:
        invalidate();
    }

    public void setBackColorRes(int r100) {
        setBackColor(ContextCompat.getColorStateList(getContext(), r100));
    }

    public void setBackDrawable(Drawable r100) {
        this.f284089b = r100;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        this.A = r101;
        b();
        refreshDrawableState();
        requestLayout();
        invalidate();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setBackDrawableRes(int r100) {
        setBackDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public void setBackMeasureRatio(float r100) {
        this.f284095h = r100;
        requestLayout();
    }

    public void setBackRadius(float r100) {
        this.f284093f = r100;
        if (this.A == true) goto L6;
        invalidate();
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        if (isChecked() == r100) goto L6;
        a(r100);
    L6:
        if (this.U == false) goto L8;
        setCheckedImmediatelyNoEvent(r100);
        return;
    L8:
        super.setChecked(r100);
    }

    public void setCheckedImmediately(boolean r100) {
        super.setChecked(r100);
        ObjectAnimator r101 = this.C;
        if (r101 != null) goto L5;
    L7:
        if (r100 == false) goto L9;
        float r102 = 1.0f;
    L10:
        setProcess(r102);
        invalidate();
        return;
    L9:
        r102 = 0.0f;
        goto L10
    L5:
        if (r101.isRunning() == false) goto L7;
        this.C.cancel();
        goto L7
    }

    public void setCheckedImmediatelyNoEvent(boolean r100) {
        if (this.V != null) goto L5;
        setCheckedImmediately(r100);
        return;
    L5:
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(r100);
        super.setOnCheckedChangeListener(this.V);
    }

    public void setCheckedNoEvent(boolean r100) {
        if (this.V != null) goto L5;
        setChecked(r100);
        return;
    L5:
        super.setOnCheckedChangeListener(null);
        setChecked(r100);
        super.setOnCheckedChangeListener(this.V);
    }

    public void setDrawDebugRect(boolean r100) {
        this.B = r100;
        invalidate();
    }

    public void setFadeBack(boolean r100) {
        this.f284097j = r100;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r100) {
        super.setOnCheckedChangeListener(r100);
        this.V = r100;
    }

    public final void setProcess(float r100) {
        if (r100 <= 1.0f) goto L6;
        r100 = 1.0f;
    L8:
        this.D = r100;
        invalidate();
        return;
    L6:
        if (r100 >= 0.0f) goto L8;
        r100 = 0.0f;
        goto L8
    }

    public void setThumbColor(ColorStateList r100) {
        this.f284091d = r100;
        if (r100 == null) goto L6;
        setThumbDrawable(null);
        return;
    }

    public void setThumbColorRes(int r100) {
        setThumbColor(ContextCompat.getColorStateList(getContext(), r100));
    }

    public void setThumbDrawable(Drawable r100) {
        this.f284088a = r100;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        this.f284113z = r101;
        b();
        refreshDrawableState();
        requestLayout();
        invalidate();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setThumbDrawableRes(int r100) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public void setThumbMargin(RectF r100) {
        if (r100 != null) goto L4;
        this.f284094g.set(0.0f, 0.0f, 0.0f, 0.0f);
        requestLayout();
        return;
    L4:
        float r101 = r100.left;
        float r102 = r100.top;
        float r103 = r100.right;
        float r104 = r100.bottom;
        this.f284094g.set(r101, r102, r103, r104);
        requestLayout();
    }

    public void setThumbRadius(float r100) {
        this.f284092e = r100;
        if (this.f284113z == true) goto L6;
        invalidate();
        return;
    }

    public void setThumbSize(PointF r100) {
        if (r100 != null) goto L4;
        Resources r101 = getResources();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 20.0f;
        this.f284099l.set(r102, r102);
        b();
        requestLayout();
        return;
    L4:
        float r103 = r100.x;
        float r104 = r100.y;
        this.f284099l.set(r103, r104);
        b();
        requestLayout();
    }

    public void setTintColor(int r100) {
        this.f284098k = r100;
        this.f284091d = a.b(r100);
        this.f284090c = a.a(this.f284098k);
        this.A = false;
        this.f284113z = false;
        refreshDrawableState();
        invalidate();
    }

    public LKUISwitchButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (this.O != null) goto L8;
        CharSequence r100 = this.L;
        if (r100 == null) goto L8;
        TextPaint r101 = this.N;
        this.O = new StaticLayout(r100, r101, (int) Math.ceil(Layout.getDesiredWidth(r100, r101)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    L8:
        if (this.P != null) goto L12;
        CharSequence r102 = this.M;
        if (r102 == null) goto L12;
        TextPaint r103 = this.N;
        this.P = new StaticLayout(r102, r103, (int) Math.ceil(Layout.getDesiredWidth(r102, r103)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    L12:
        int r104 = View.MeasureSpec.getSize(r110);
        int r112 = View.MeasureSpec.getMode(r110);
        int r105 = (int) Math.ceil(this.f284099l.x * this.f284095h);
        if (this.A == false) goto L15;
        r105 = Math.max(r105, this.f284089b.getMinimumWidth());
    L15:
        Layout r106 = this.O;
        if (r106 == null) goto L18;
        float r107 = r106.getWidth();
    L19:
        Layout r108 = this.P;
        if (r108 == null) goto L22;
        float r109 = r108.getWidth();
    L24:
        if (r107 == 0.0f) goto L26;
    L29:
        float r113 = Math.max(r107, r109) + (this.S * 2.0f);
        this.Q = r113;
        float r114 = r105;
        float r115 = r114 - this.f284099l.x;
        if (r115 >= r113) goto L32;
        r105 = (int) (r114 + (r113 - r115));
    L32:
        RectF r116 = this.f284094g;
        int r117 = Math.max(r105, (int) Math.ceil((r105 + r116.left) + r116.right));
        int r118 = Math.max(Math.max(r117, (getPaddingLeft() + r117) + getPaddingRight()), getSuggestedMinimumWidth());
        if (r112 != 1073741824) goto L35;
        r118 = Math.max(r118, r104);
    L37:
        int r119 = View.MeasureSpec.getMode(r111);
        int r120 = View.MeasureSpec.getSize(r111);
        float r121 = this.f284099l.y;
        RectF r122 = this.f284094g;
        int r123 = (int) Math.ceil(Math.max(r121, (r122.top + r121) + r122.right));
        Layout r124 = this.O;
        if (r124 == null) goto L40;
        float r125 = r124.getHeight();
    L41:
        Layout r126 = this.P;
        if (r126 == null) goto L44;
        float r127 = r126.getHeight();
    L46:
        if (r125 == 0.0f) goto L48;
    L51:
        float r128 = Math.max(r125, r127);
        this.R = r128;
        r123 = (int) Math.ceil(Math.max(r123, r128));
    L52:
        int r129 = Math.max(r123, getSuggestedMinimumHeight());
        int r130 = Math.max(r129, (getPaddingTop() + r129) + getPaddingBottom());
        if (r119 != 1073741824) goto L55;
        r130 = Math.max(r130, r120);
    L57:
        setMeasuredDimension(r118, r130);
        return;
    L55:
        if (r119 != Integer.MIN_VALUE) goto L57;
        r130 = Math.min(r130, r120);
        goto L57
    L48:
        if (r127 != 0.0f) goto L51;
        this.R = 0.0f;
        goto L52
    L44:
        r127 = 0.0f;
        goto L46
    L40:
        r125 = 0.0f;
        goto L41
    L35:
        if (r112 != Integer.MIN_VALUE) goto L37;
        r118 = Math.min(r118, r104);
        goto L37
    L26:
        if (r109 != 0.0f) goto L29;
        this.Q = 0.0f;
        goto L32
    L22:
        r109 = 0.0f;
        goto L24
    L18:
        r107 = 0.0f;
        goto L19
    }

    public LKUISwitchButton(Context r210, AttributeSet r310, int r311) {
        super(r210, r310, r311, com.larus.nova.R.style.LKUI_SwitchButton);
        this.B = false;
        this.T = true;
        this.U = false;
        this.I = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f284087J = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.f284112y = new Paint(1);
        Paint r100 = new Paint(1);
        this.K = r100;
        r100.setStyle(Paint.Style.STROKE);
        Paint r101 = this.K;
        Resources r102 = getResources();
        r101.setStrokeWidth(WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density);
        this.N = getPaint();
        this.f284107t = new RectF();
        this.f284108u = new RectF();
        this.f284109v = new RectF();
        this.f284099l = new PointF();
        this.f284094g = new RectF();
        this.f284110w = new RectF();
        this.f284111x = new RectF();
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, "process", new float[]{0.0f, 0.0f}).setDuration(250);
        this.C = r103;
        r103.setInterpolator(new AccelerateDecelerateInterpolator());
        this.E = new RectF();
        Resources r104 = getResources();
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        float r106 = r105 * 2.0f;
        float r107 = r105 * 20.0f;
        float r110 = r107 / 2.0f;
        if (r310 != null) goto L5;
        TypedArray r108 = null;
    L6:
        if (r108 == null) goto L8;
        Drawable r111 = r108.getDrawable(11);
        ColorStateList r112 = r108.getColorStateList(10);
        float r113 = r108.getDimension(13, r106);
        float r114 = r108.getDimension(15, r113);
        float r115 = r108.getDimension(16, r113);
        float r109 = r108.getDimension(17, r113);
        float r116 = r108.getDimension(14, r113);
        float r117 = r108.getDimension(19, r107);
        float r118 = r108.getDimension(12, r107);
        float r119 = r108.getDimension(18, Math.min(r117, r118) / 2.0f);
        float r120 = r108.getDimension(5, r119 + r106);
        Drawable r121 = r108.getDrawable(3);
        ColorStateList r211 = r108.getColorStateList(2);
        float r122 = r108.getFloat(4, 1.8f);
        int r123 = r108.getInteger(0, 250);
        boolean r124 = r108.getBoolean(6, true);
        int r125 = r108.getColor(20, 0);
        String r126 = r108.getString(9);
        String r127 = r108.getString(8);
        float r128 = r108.getDimension(7, Math.max(r106, r120 / 2.0f));
        boolean r129 = r108.getBoolean(1, true);
        r108.recycle();
        String r130 = r126;
        String r131 = r127;
        float r132 = r109;
        ColorStateList r133 = r211;
        float r212 = r119;
        float r134 = r120;
        float r135 = r114;
        float r136 = r128;
        int r137 = r123;
        Drawable r138 = r121;
        Drawable r139 = r111;
        float r140 = r118;
        boolean r141 = r129;
        float r213 = r122;
        boolean r142 = r124;
        float r214 = r116;
    L9:
        if (r310 != null) goto L11;
        TypedArray r143 = null;
    L12:
        if (r143 == null) goto L14;
        boolean r144 = r143.getBoolean(0, true);
        boolean r145 = r143.getBoolean(1, r144);
        setFocusable(r144);
        setClickable(r145);
        r143.recycle();
    L15:
        this.L = r130;
        this.M = r131;
        this.S = r136;
        this.T = r141;
        this.f284088a = r139;
        this.f284091d = r112;
        if (r139 == null) goto L18;
        boolean r146 = true;
    L19:
        this.f284113z = r146;
        this.f284098k = r125;
        if (r125 != 0) goto L25;
        TypedValue r147 = new TypedValue();
        boolean r148 = true;
        if (getContext().getTheme().resolveAttribute(com.larus.nova.R.attr.colorAccent, r147, true) == false) goto L24;
        this.f284098k = r147.data;
    L27:
        if (this.f284113z == true) goto L32;
        if (this.f284091d != null) goto L32;
        ColorStateList r149 = a.b(this.f284098k);
        this.f284091d = r149;
        this.f284100m = r149.getDefaultColor();
    L32:
        if (this.f284113z == false) goto L34;
        r117 = Math.max(r117, this.f284088a.getMinimumWidth());
        r140 = Math.max(r140, this.f284088a.getMinimumHeight());
    L34:
        this.f284099l.set(r117, r140);
        this.f284089b = r138;
        this.f284090c = r133;
        if (r138 != null) goto L38;
        r148 = false;
    L38:
        this.A = r148;
        if (r148 == true) goto L42;
        if (r133 != null) goto L42;
        ColorStateList r150 = a.a(this.f284098k);
        this.f284090c = r150;
        int r151 = r150.getDefaultColor();
        this.f284101n = r151;
        this.f284102o = this.f284090c.getColorForState(W, r151);
    L42:
        this.f284094g.set(r135, r132, r115, r214);
        float r152 = r213;
        if (this.f284094g.width() < 0.0f) goto L45;
        float r153 = Math.max(r152, 1.0f);
    L46:
        this.f284095h = r153;
        this.f284092e = r212;
        this.f284093f = r134;
        long r154 = r137;
        this.f284096i = r154;
        this.f284097j = r142;
        this.C.setDuration(r154);
        if (isChecked() == false) goto L50;
        setProcess(1.0f);
        return;
    L50:
        return;
    L45:
        r153 = r152;
        goto L46
    L24:
        this.f284098k = 3309506;
        goto L27
    L25:
        r148 = true;
        goto L27
    L18:
        r146 = false;
        goto L19
    L14:
        setFocusable(true);
        setClickable(true);
        goto L15
    L11:
        r143 = getContext().obtainStyledAttributes(r310, new int[]{R.attr.focusable, R.attr.clickable});
        goto L12
    L8:
        r117 = r107;
        r136 = r106;
        r134 = r110;
        r212 = r134;
        r131 = null;
        r130 = null;
        r125 = 0;
        r133 = null;
        r138 = null;
        r135 = 0.0f;
        r132 = 0.0f;
        r139 = null;
        r115 = 0.0f;
        r112 = null;
        r142 = true;
        r137 = 250;
        r213 = 1.8f;
        r214 = 0.0f;
        r140 = r117;
        r141 = true;
        goto L9
    L5:
        r108 = getContext().obtainStyledAttributes(r310, new int[]{com.larus.nova.R.attr.kswAnimationDuration, com.larus.nova.R.attr.kswAutoAdjustTextPosition, com.larus.nova.R.attr.kswBackColor, com.larus.nova.R.attr.kswBackDrawable, com.larus.nova.R.attr.kswBackMeasureRatio, com.larus.nova.R.attr.kswBackRadius, com.larus.nova.R.attr.kswFadeBack, com.larus.nova.R.attr.kswTextMarginH, com.larus.nova.R.attr.kswTextOff, com.larus.nova.R.attr.kswTextOn, com.larus.nova.R.attr.kswThumbColor, com.larus.nova.R.attr.kswThumbDrawable, com.larus.nova.R.attr.kswThumbHeight, com.larus.nova.R.attr.kswThumbMargin, com.larus.nova.R.attr.kswThumbMarginBottom, com.larus.nova.R.attr.kswThumbMarginLeft, com.larus.nova.R.attr.kswThumbMarginRight, com.larus.nova.R.attr.kswThumbMarginTop, com.larus.nova.R.attr.kswThumbRadius, com.larus.nova.R.attr.kswThumbWidth, com.larus.nova.R.attr.kswTintColor}, r311, com.larus.nova.R.style.LKUI_SwitchButton);
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 != r102) goto L5;
        if (r101 != r103) goto L5;
        return;
    L5:
        b();
    }
}
