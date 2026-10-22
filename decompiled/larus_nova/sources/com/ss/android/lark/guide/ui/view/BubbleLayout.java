package com.ss.android.lark.guide.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class BubbleLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout f425802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoundRectLayout f425803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrowView f425804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f425805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f425806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f425807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f425808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f425809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f425810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f425811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f425812k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f425813l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BubbleLayout f425814a;

        public a(BubbleLayout r100) {
            this.f425814a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BubbleLayout f425815a;

        public b(BubbleLayout r100) {
            this.f425815a = r100;
        }
    }

    public a getArrowOffsetSetter() {
        return new a(this);
    }

    public b getConfigSetter() {
        return new b(this);
    }

    public final void i() {
        ConstraintLayout r100 = new ConstraintLayout(getContext());
        this.f425802a = r100;
        r100.setId(R.id.bubble_container);
        addView(this.f425802a, new FrameLayout.LayoutParams(-2, -2));
        ConstraintLayout r101 = this.f425802a;
        RoundRectLayout r102 = new RoundRectLayout(getContext());
        this.f425803b = r102;
        r102.setId(R.id.bubble_card);
        r101.addView(this.f425803b, new ConstraintLayout.LayoutParams(-2, -2));
        ConstraintLayout r103 = this.f425802a;
        ArrowView r104 = new ArrowView(getContext());
        this.f425804c = r104;
        r104.setId(R.id.bubble_arrow);
        ConstraintLayout r105 = new ConstraintLayout(getContext());
        this.f425805d = r105;
        r105.setId(R.id.bubble_arrow_wrapper);
        this.f425805d.addView(this.f425804c);
        r103.addView(this.f425805d);
    }

    public float getArrowMainLen() {
        return this.f425811j;
    }

    public BubbleLayout(Context r100) {
        super(r100);
        this.f425806e = GravityCompat.END;
        this.f425813l = true;
        i();
    }

    private void setAnchorGravity(int r100) {
        this.f425806e = r100;
    }

    private void setArrowColor(int r100) {
        this.f425809h = r100;
    }

    private void setArrowCrossLength(float r100) {
        this.f425812k = r100;
    }

    private void setArrowMainLength(float r100) {
        this.f425811j = r100;
    }

    private void setArrowOffset(float r100) {
        this.f425810i = r100;
    }

    private void setCardCornerRadius(float r100) {
        this.f425808g = r100;
    }

    private void setCardFillColor(int r100) {
        this.f425807f = r100;
    }

    private void setContentView(int r100) {
        View r101 = LayoutInflater.from(getContext()).inflate(r100, this.f425803b, false);
        this.f425803b.addView(r101, -2, -2);
    }

    private void setEnforceCornerForArrow(boolean r100) {
        this.f425813l = r100;
    }

    private void setContentView(View r100) {
        this.f425803b.addView(r100, -2, -2);
    }

    public BubbleLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f425806e = GravityCompat.END;
        this.f425813l = true;
        i();
    }

    public static /* synthetic */ void a(BubbleLayout r100, boolean r101) {
        r100.setEnforceCornerForArrow(r101);
    }

    public static /* synthetic */ void b(BubbleLayout r100, float r101) {
        r100.setCardCornerRadius(r101);
    }

    public static /* synthetic */ void c(BubbleLayout r100, float r101) {
        r100.setArrowMainLength(r101);
    }

    public static /* synthetic */ void d(BubbleLayout r100, float r101) {
        r100.setArrowCrossLength(r101);
    }

    public static /* synthetic */ void e(BubbleLayout r100, View r101) {
        r100.setContentView(r101);
    }

    public static /* synthetic */ void f(BubbleLayout r100, int r101) {
        r100.setArrowColor(r101);
    }

    public static /* synthetic */ void g(BubbleLayout r100, float r101) {
        r100.setArrowOffset(r101);
    }

    public static /* synthetic */ void h(BubbleLayout r100, int r101) {
        r100.setAnchorGravity(r101);
    }

    public BubbleLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f425806e = GravityCompat.END;
        this.f425813l = true;
        i();
    }
}
