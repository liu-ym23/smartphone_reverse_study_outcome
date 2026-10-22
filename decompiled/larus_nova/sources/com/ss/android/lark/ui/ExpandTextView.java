package com.ss.android.lark.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class ExpandTextView extends AppCompatTextView implements View.OnClickListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f444542q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f444543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f444544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f444545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f444546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f444547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f444548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f444549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f444550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f444551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f444552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f444553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f444554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f444555m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f444556n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f444557o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f444558p;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandTextView f444559a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        public a(ExpandTextView r100) {
            this.f444559a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f444559a.clearAnimation();
            ExpandTextView r101 = this.f444559a;
            r101.f444551i = false;
            r101.getClass();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            ExpandTextView r101 = this.f444559a;
            int r102 = ExpandTextView.f444542q;
            r101.getClass();
            ExpandTextView r103 = this.f444559a;
            r103.setAlpha(r103.f444545c);
        }
    }

    public class b extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f444560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f444561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f444562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ExpandTextView f444563d;

        @Override // android.view.animation.Animation
        public final boolean willChangeBounds() {
            return true;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            int r102 = this.f444562c;
            int r103 = this.f444561b;
            int r104 = (int) (((r102 - r103) * r100) + r103);
            this.f444560a.getLayoutParams().height = r104;
            this.f444563d.setMaxHeight(r104);
            if (Float.compare(this.f444563d.f444545c, 1.0f) == 0) goto L6;
            ExpandTextView r105 = this.f444563d;
            float r106 = r105.f444545c;
            r105.setAlpha(r106 + (r100 * (1.0f - r106)));
            return;
        }

        public b(ExpandTextView r100, View r101, int r102, int r103) {
            this.f444563d = r100;
            this.f444560a = r101;
            this.f444561b = r102;
            this.f444562c = r103;
            setDuration(r100.f444544b);
        }

        @Override // android.view.animation.Animation
        public final void initialize(int r100, int r101, int r102, int r103) {
            super.initialize(r100, r101, r102, r103);
        }
    }

    public interface c {
    }

    public void setOnExpandStateChangeListener(c r100) {
    }

    public ExpandTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f444552j == true) goto L5;
        return;
    L5:
        this.f444550h = !this.f444550h;
        ImageSpan r101 = null;
        if (this.f444546d == null) goto L8;
        ImageSpan r102 = new ImageSpan(this.f444546d);
    L10:
        if (this.f444547e == null) goto L12;
        r101 = new ImageSpan(this.f444547e);
    L12:
        SpannableString r103 = new SpannableString("icon");
        if (r102 == null) goto L20;
        if (r101 == null) goto L20;
        if (this.f444550h == true) goto L19;
        r102 = r101;
    L19:
        r103.setSpan(r102, 0, 4, 33);
    L20:
        this.f444551i = true;
        if (this.f444550h == false) goto L23;
        b r104 = new b(this, this, getHeight(), this.f444548f);
    L24:
        r104.setFillAfter(true);
        r104.setAnimationListener(new a(this));
        clearAnimation();
        startAnimation(r104);
        return;
    L23:
        r104 = new b(this, this, getHeight(), this.f444549g);
        goto L24
    L8:
        r102 = null;
        goto L10
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        Drawable r101 = this.f444546d;
        if (r101 != null) goto L5;
        int r102 = 0;
        int r103 = 0;
    L10:
        if (this.f444552j == true) goto L12;
        return;
    L12:
        if (this.f444556n != 0) goto L19;
        int r104 = (getWidth() - getTotalPaddingRight()) + this.f444557o;
        int r105 = this.f444555m;
        if (r105 == 1) goto L18;
        if (r105 == 2) goto L17;
        int r106 = (getHeight() - getTotalPaddingBottom()) - r102;
    L26:
        r100.translate(r104, r106);
        if (this.f444550h == false) goto L34;
        Drawable r107 = this.f444546d;
        if (r107 == null) goto L34;
        if (r107.getBounds().isEmpty() == false) goto L33;
        this.f444546d.setBounds(0, 0, r103, r102);
    L33:
        this.f444546d.draw(r100);
        return;
    L34:
        Drawable r108 = this.f444547e;
        if (r108 != null) goto L37;
        return;
    L37:
        if (r108.getBounds().isEmpty() == false) goto L39;
        Drawable r109 = this.f444547e;
        r109.setBounds(0, 0, r109.getIntrinsicWidth(), this.f444547e.getIntrinsicHeight());
    L39:
        this.f444547e.draw(r100);
        return;
    L17:
        r106 = (getHeight() - r102) / 2;
        goto L26
    L18:
        r106 = getTotalPaddingTop();
        goto L26
    L19:
        int r110 = (getHeight() - getTotalPaddingBottom()) + this.f444557o;
        int r111 = this.f444555m;
        if (r111 == 1) goto L25;
        if (r111 == 2) goto L24;
        int r112 = (getWidth() - getTotalPaddingRight()) - r103;
    L23:
        int r113 = r112;
        r106 = r110;
        r104 = r113;
        goto L26
    L24:
        r112 = (getWidth() - r103) / 2;
        goto L23
    L25:
        r112 = getTotalPaddingLeft();
        goto L23
    L5:
        if (r101.getBounds().isEmpty() == false) goto L7;
        r102 = this.f444546d.getIntrinsicHeight();
        r103 = this.f444546d.getIntrinsicWidth();
        goto L10
    L7:
        r102 = this.f444546d.getBounds().height();
        r103 = this.f444546d.getBounds().width();
        goto L10
    }

    public void setCollapseDrawable(Drawable r100) {
        this.f444547e = r100;
    }

    public void setCollapsed(boolean r100) {
        this.f444550h = r100;
    }

    public void setExpandDrawable(Drawable r100) {
        this.f444546d = r100;
    }

    public void setMaxCollapsedLines(int r100) {
        this.f444543a = r100;
    }

    public ExpandTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getVisibility() != 8) goto L5;
    L32:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (this.f444551i == true) goto L32;
        getLayoutParams().height = -2;
        setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(r100, r101);
        if (getLineCount() > this.f444543a) goto L11;
        this.f444552j = false;
        return;
    L11:
        this.f444552j = true;
        this.f444549g = getLayout().getLineTop(getLineCount()) + (getCompoundPaddingTop() + getCompoundPaddingBottom());
        if (this.f444550h == false) goto L14;
        setMaxLines(this.f444543a);
    L14:
        Drawable r102 = this.f444546d;
        if (r102 != null) goto L17;
        this.f444553k = 0;
        this.f444554l = 0;
    L22:
        if (this.f444558p == false) goto L24;
    L28:
        super.onMeasure(r100, r101);
        if (this.f444550h == false) goto L34;
        this.f444548f = getMeasuredHeight();
        return;
    L34:
        return;
    L24:
        if (this.f444556n != 0) goto L26;
        setPadding(getPaddingLeft(), getPaddingTop(), (getPaddingRight() + this.f444553k) + this.f444557o, getPaddingBottom());
    L27:
        this.f444558p = true;
        goto L28
    L26:
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), (getPaddingBottom() + this.f444554l) + this.f444557o);
        goto L27
    L17:
        if (r102.getBounds().isEmpty() == false) goto L19;
        this.f444553k = this.f444546d.getIntrinsicWidth();
        this.f444554l = this.f444546d.getIntrinsicHeight();
        goto L22
    L19:
        this.f444553k = this.f444546d.getBounds().width();
        this.f444554l = this.f444546d.getBounds().height();
        goto L22
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        setCollapsed(true);
        super.setText(r100, r101);
    }

    public ExpandTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f444543a = 8;
        this.f444550h = true;
        this.f444551i = false;
        this.f444552j = true;
        this.f444553k = 0;
        this.f444554l = 0;
        this.f444555m = 0;
        this.f444556n = 0;
        this.f444557o = 0;
        this.f444558p = false;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.animAlphaStart, R.attr.animDuration, R.attr.arrowAlign, R.attr.arrowDrawableSize, R.attr.arrowPadding, R.attr.arrowPosition, R.attr.collapseDrawable, R.attr.expandDrawable, R.attr.maxCollapsedLines}, r102, 0);
        this.f444543a = r103.getInt(8, 8);
        this.f444544b = r103.getInt(1, 300);
        this.f444545c = r103.getFloat(0, 0.7f);
        this.f444546d = r103.getDrawable(7);
        this.f444547e = r103.getDrawable(6);
        int r104 = r103.getDimensionPixelSize(3, 0);
        int r105 = UIUtils.getColor(r100, R.color.icon_n3);
        Drawable r106 = this.f444546d;
        if (r106 == null) goto L7;
        r106.mutate();
        this.f444546d.setTint(r105);
        if (r104 <= 0) goto L7;
        this.f444546d.setBounds(0, 0, r104, r104);
    L7:
        Drawable r107 = this.f444547e;
        if (r107 == null) goto L12;
        r107.mutate();
        this.f444547e.setTint(r105);
        if (r104 <= 0) goto L12;
        this.f444547e.setBounds(0, 0, r104, r104);
    L12:
        this.f444555m = r103.getInteger(2, 0);
        this.f444556n = r103.getInteger(5, 0);
        this.f444557o = (int) r103.getDimension(4, UIUtils.dp2px(r100, 2.0f));
        r103.recycle();
        setClickable(true);
        setOnClickListener(this);
    }
}
