package com.bytedance.ee.bear.wikiv2.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ExpandableTextView extends LinearLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f240646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExpandButton f240647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f240648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f240649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f240650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f240651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f240652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f240653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f240654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f240655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f240656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f240657l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f240658m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f240659n;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f240660a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public a(ExpandableTextView r100) {
            this.f240660a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f240660a.clearAnimation();
            ExpandableTextView r101 = this.f240660a;
            r101.f240659n = false;
            r101.getClass();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f240661a;

        @Override // java.lang.Runnable
        public final void run() {
            ExpandableTextView r100 = this.f240661a;     // Catch: Throwable -> L4
            r100.f240653h = r100.getHeight() - this.f240661a.f240646a.getHeight();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ExpandableTextView r100) {
            this.f240661a = r100;
        }
    }

    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f240662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f240663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f240664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f240665d;

        @Override // android.view.animation.Animation
        public final boolean willChangeBounds() {
            return true;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            int r102 = this.f240664c;
            int r103 = this.f240663b;
            int r104 = (int) (((r102 - r103) * r100) + r103);
            ExpandableTextView r105 = this.f240665d;
            r105.f240646a.setMaxHeight(r104 - r105.f240653h);
            this.f240662a.getLayoutParams().height = r104;
            this.f240662a.requestLayout();
        }

        public c(ExpandableTextView r100, View r101, int r102, int r103) {
            this.f240665d = r100;
            this.f240662a = r101;
            this.f240663b = r102;
            this.f240664c = r103;
            setDuration(r100.f240658m);
        }

        @Override // android.view.animation.Animation
        public final void initialize(int r100, int r101, int r102, int r103) {
            super.initialize(r100, r101, r102, r103);
        }
    }

    public interface d {
    }

    public void setOnExpandStateChangeListener(d r100) {
    }

    public CharSequence getText() {
        TextView r100 = this.f240646a;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getText();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f240646a = (TextView) findViewById(R.id.expandable_text);
        ExpandButton r100 = (ExpandButton) findViewById(R.id.expand_collapse);
        this.f240647b = r100;
        boolean r101 = this.f240649d;
        if (r101 == false) goto L5;
        Drawable r102 = this.f240654i;
    L6:
        if (r101 == false) goto L8;
        String r103 = this.f240656k;
    L9:
        r100.f240643a.setImageDrawable(r102);
        r100.f240644b.setText(r103);
        this.f240647b.setOnClickListener(this);
        return;
    L8:
        r103 = this.f240657l;
        goto L9
    L5:
        r102 = this.f240655j;
        goto L6
    }

    public ExpandableTextView(Context r100) {
        this(r100, null);
    }

    public final void a(AttributeSet r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.animAlphaStart, R.attr.animDuration, R.attr.collapseDrawable, R.attr.collapseIndicator, R.attr.expandCollapseToggleId, R.attr.expandDrawable, R.attr.expandIndicator, R.attr.expandToggleOnTextClick, R.attr.expandToggleType, R.attr.expandableTextId, R.attr.maxCollapsedLines});
        this.f240652g = r101.getInt(10, 8);
        this.f240658m = r101.getInt(1, 300);
        r101.getFloat(0, 1.0f);
        this.f240654i = r101.getDrawable(5);
        this.f240655j = r101.getDrawable(2);
        if (this.f240654i != null) goto L6;
        Context r102 = getContext();
        this.f240654i = r102.getResources().getDrawable(kac.a.b(R.drawable.facade_icon_arrow_down), r102.getTheme());
    L6:
        if (this.f240655j != null) goto L8;
        Context r103 = getContext();
        this.f240655j = r103.getResources().getDrawable(kac.a.b(R.drawable.facade_icon_arrow_up), r103.getTheme());
    L8:
        this.f240656k = getResources().getString(R.string.Doc_Wiki_SpaceDetail_ExpandIntroduction);
        this.f240657l = getResources().getString(R.string.Doc_Wiki_SpaceDetail_CollapseIntroduction);
        r101.recycle();
        setOrientation(1);
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (this.f240647b.getVisibility() == 0) goto L5;
        return;
    L5:
        boolean r111 = !this.f240649d;
        this.f240649d = r111;
        this.f240659n = true;
        if (r111 == false) goto L8;
        c r112 = new c(this, this, getHeight(), this.f240650e);
    L9:
        final ExpandButton r100 = this.f240647b;
        boolean r101 = this.f240649d;
        if (r101 == false) goto L12;
        Drawable r102 = this.f240654i;
    L13:
        if (r101 == false) goto L15;
        String r103 = this.f240656k;
    L16:
        int r104 = this.f240658m;
        r100.f240645c.cancel();
        long r105 = r104 / 2;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(r105);
        r106.addUpdateListener(new vp5.a(r100));
        r106.addListener(new vp5.c(r100, r102, r103));
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(r105);
        r107.addUpdateListener(new vp5.b(r100));
        r100.f240645c.play(r107).after(r106);
        r100.f240645c.start();
        r112.setFillAfter(true);
        r112.setAnimationListener(new a(this));
        clearAnimation();
        startAnimation(r112);
        return;
    L15:
        r103 = this.f240657l;
        goto L16
    L12:
        r102 = this.f240655j;
        goto L13
    L8:
        r112 = new c(this, this, getHeight(), (getHeight() + this.f240651f) - this.f240646a.getHeight());
        goto L9
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return this.f240659n;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r100) {
        if (r100 == 0) goto L6;
        super.setOrientation(r100);
        return;
    L6:
        throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
    }

    public void setText(CharSequence r100) {
        this.f240648c = true;
        this.f240646a.setText(r100);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        int r101 = 8;
    L6:
        setVisibility(r101);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public ExpandableTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f240649d = true;
        a(r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f240648c == true) goto L5;
    L17:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (getVisibility() == 8) goto L17;
        this.f240648c = false;
        this.f240647b.setVisibility(8);
        this.f240646a.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(r100, r101);
        if (this.f240646a.getLineCount() > this.f240652g) goto L10;
        return;
    L10:
        TextView r102 = this.f240646a;
        this.f240651f = r102.getLayout().getLineTop(r102.getLineCount()) + (r102.getCompoundPaddingTop() + r102.getCompoundPaddingBottom());
        if (this.f240649d == false) goto L13;
        this.f240646a.setMaxLines(this.f240652g);
    L13:
        this.f240647b.setVisibility(0);
        ((LinearLayout.LayoutParams) this.f240646a.getLayoutParams()).bottomMargin = 0;
        super.onMeasure(r100, r101);
        if (this.f240649d == false) goto L19;
        this.f240646a.post(new b(this));
        this.f240650e = getMeasuredHeight();
        return;
    }

    public ExpandableTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240649d = true;
        a(r101);
    }
}
