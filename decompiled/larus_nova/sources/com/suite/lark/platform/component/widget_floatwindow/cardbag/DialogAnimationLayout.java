package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class DialogAnimationLayout extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f461157i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f461158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f461159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f461160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutTransition f461161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<View> f461162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f461163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f461164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f461165h;

    public class a implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f461166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DialogAnimationLayout f461167b;

        public final void a() {
            boolean r100 = true;
            if (this.f461166a != 1) goto L5;
            return;
        L5:
            if (this.f461167b.getChildCount() <= 3) goto L30;
            DialogAnimationLayout r101 = this.f461167b;
            int r102 = DialogAnimationLayout.f461157i;
            r101.getClass();
            if (r101.f461162e.size() < 3) goto L9;
            int r103 = (r101.f461162e.size() - 3) + 0;
            if (r103 >= 0) goto L14;
        L16:
            r103 = -1;
        L17:
            DialogAnimationLayout r104 = this.f461167b;
            int r105 = r104.a(r103);
            if (r105 < 0) goto L21;
            if (r105 >= 3) goto L21;
        L22:
            if (r100 == true) goto L25;
            return;
        L25:
            if (r104.getChildCount() == 0) goto L32;
            r104.setLayoutTransition(null);
            r104.c();
            r104.removeViewAt(r104.a(r103));
            return;
        L32:
            return;
        L21:
            r100 = false;
            goto L22
        L14:
            if (r103 >= r101.f461162e.size()) goto L16;
        L9:
            if (r101.f461162e.size() <= 0) goto L16;
            r103 = 0;
            goto L17
        }

        public a(DialogAnimationLayout r100, int r101) {
            this.f461167b = r100;
            this.f461166a = 0;
            this.f461166a = r101;
        }
    }

    public interface b {
    }

    private Animator getAppearAnimation() {
        return ObjectAnimator.ofFloat(null, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{-this.f461158a, 0.0f}).setDuration(500);
    }

    private Animator getDisAppearAnimation() {
        return ObjectAnimator.ofFloat(null, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -this.f461158a}).setDuration(300);
    }

    public void setFinishListener(b r100) {
    }

    public final void c() {
        ValueAnimator r100 = this.f461164g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRunning() == false) goto L9;
        this.f461164g.end();
        this.f461164g = null;
        return;
    }

    public final void b() {
        this.f461163f = (int) getResources().getDimension(R.dimen.card_dp_step);
        this.f461158a = (int) getResources().getDimension(R.dimen.trans_layout_height);
        LayoutTransition r100 = this.f461161d;
        if (r100 == null) goto L5;
        setLayoutTransition(r100);
        return;
    L5:
        LayoutTransition r101 = new LayoutTransition();
        this.f461161d = r101;
        r101.setStartDelay(2, 0);
        this.f461161d.setStartDelay(3, 0);
        this.f461161d.setAnimator(2, getAppearAnimation());
        this.f461161d.setAnimator(3, getDisAppearAnimation());
        this.f461161d.addTransitionListener(new f(this));
        setLayoutTransition(this.f461161d);
    }

    public int getAppearHeight() {
        return this.f461158a;
    }

    public List<View> getPackageViews() {
        return this.f461162e;
    }

    public DialogAnimationLayout(Context r100) {
        super(r100);
        this.f461159b = -1;
        this.f461160c = 1;
        this.f461162e = new ArrayList();
        b();
    }

    public final int a(int r100) {
        if (r100 >= 0) goto L5;
    L14:
        return -1;
    L5:
        if (r100 > (this.f461162e.size() - 1)) goto L14;
        if (this.f461162e.size() >= 3) goto L10;
        return r100;
    L10:
        int r101 = r100 - (this.f461162e.size() - 3);
        if (r101 < 0) goto L14;
        if (r101 >= 3) goto L14;
        return r101;
    }

    public void setAppearHeight(int r100) {
        this.f461158a = r100;
    }

    public void setAppearWidth(int r100) {
        this.f461159b = r100;
    }

    public void setGravity(int r100) {
        this.f461160c = r100;
    }

    public void setPackageViews(List<View> r100) {
        this.f461162e = r100;
    }

    public DialogAnimationLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f461159b = -1;
        this.f461160c = 1;
        this.f461162e = new ArrayList();
        b();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredHeight();
        int r103 = this.f461165h;
        if (r102 >= r103) goto L6;
        setMeasuredDimension(r100, r103);
        return;
    }

    public DialogAnimationLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f461159b = -1;
        this.f461160c = 1;
        this.f461162e = new ArrayList();
        b();
    }
}
