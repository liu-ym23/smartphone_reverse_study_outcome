package com.bytedance.ee.bear.basesdk;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import on4.s;
import on4.t;
import on4.u;
import on4.v;

/* JADX INFO: loaded from: classes15.dex */
public class LarkLoadingView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f206475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f206476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f206477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f206478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f206479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f206480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f206481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f206482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f206483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f206484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f206485k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f206486l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f206487m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f206488n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f206489o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f206490p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AnimatorSet f206491q;

    public final void init() {
        setBackgroundResource(R.drawable.loading_component_bg);
        this.f206475a = getContext().getResources().getDrawable(R.drawable.loading_component_one);
        this.f206476b = getContext().getResources().getDrawable(R.drawable.loading_component_two);
        this.f206477c = getContext().getResources().getDrawable(R.drawable.loading_component_three);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f206478d = false;
        this.f206491q.cancel();
    }

    public LarkLoadingView(Context r100) {
        super(r100);
        this.f206491q = new AnimatorSet();
        init();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = r100.getSaveCount();
        j(r100, r101, this.f206483i, this.f206486l, this.f206475a);
        j(r100, r101, this.f206484j, this.f206487m, this.f206476b);
        j(r100, r101, this.f206485k, this.f206488n, this.f206477c);
    }

    public LarkLoadingView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f206491q = new AnimatorSet();
        init();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L10;
        this.f206478d = true;
        if (this.f206491q.isRunning() == false) goto L7;
        return;
    L7:
        if (this.f206491q.isStarted() == true) goto L18;
        int r102 = this.f206479e;
        this.f206483i = r102;
        this.f206484j = r102;
        this.f206485k = r102;
        this.f206491q.start();
        return;
    L18:
        return;
    L10:
        if (r101 == 8) goto L14;
        if (r101 == 4) goto L14;
        return;
    L14:
        if (this.f206491q.isRunning() == false) goto L21;
        this.f206478d = false;
        this.f206491q.cancel();
        return;
    }

    public LarkLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f206491q = new AnimatorSet();
        init();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r110, int r111, int r112, int r210) {
        super.onSizeChanged(r110, r111, r112, r210);
        if (r112 == r110) goto L5;
    L6:
        float r100 = r110;
        this.f206489o = r100 / 450.0f;
        float r101 = r111;
        this.f206490p = r101 / 360.0f;
        int r102 = (int) (0.1511f * r100);
        this.f206479e = r102;
        int r103 = (int) (0.504f * r100);
        this.f206481g = r103;
        this.f206480f = (int) (r103 + 6.0f);
        this.f206482h = (int) (r100 * 0.855f);
        this.f206483i = r102;
        this.f206484j = r102;
        this.f206485k = r102;
        int r104 = (int) (0.3f * r101);
        this.f206486l = r104;
        float r105 = r101 * 0.025f;
        int r106 = r104 + ((int) ((this.f206475a.getIntrinsicHeight() + r105) * this.f206490p));
        this.f206487m = r106;
        this.f206488n = r106 + ((int) ((r105 + this.f206475a.getIntrinsicHeight()) * this.f206490p));
        s r107 = new s(this);
        t r108 = new t(this);
        u r109 = new u(this);
        ValueAnimator r113 = ValueAnimator.ofInt(new int[]{this.f206479e, this.f206480f});
        r113.setInterpolator(new DecelerateInterpolator());
        r113.setDuration(300);
        r113.addUpdateListener(r107);
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{this.f206480f, this.f206481g});
        r114.setInterpolator(new DecelerateInterpolator());
        r114.setDuration(50);
        r114.addUpdateListener(r107);
        ValueAnimator r115 = ValueAnimator.ofInt(new int[]{this.f206479e, this.f206480f});
        r115.setInterpolator(new DecelerateInterpolator());
        r115.setDuration(300);
        r115.addUpdateListener(r108);
        ValueAnimator r116 = ValueAnimator.ofInt(new int[]{this.f206480f, this.f206481g});
        r116.setInterpolator(new DecelerateInterpolator());
        r116.setDuration(50);
        r116.addUpdateListener(r108);
        ValueAnimator r117 = ValueAnimator.ofInt(new int[]{this.f206479e, this.f206480f});
        r117.setInterpolator(new DecelerateInterpolator());
        r117.setDuration(300);
        r117.addUpdateListener(r109);
        ValueAnimator r118 = ValueAnimator.ofInt(new int[]{this.f206480f, this.f206481g});
        r118.setInterpolator(new DecelerateInterpolator());
        r118.setDuration(50);
        r118.addUpdateListener(r109);
        ValueAnimator r119 = ValueAnimator.ofInt(new int[]{this.f206481g, this.f206482h});
        r119.setInterpolator(new DecelerateInterpolator());
        r119.setDuration(250);
        r119.addUpdateListener(r107);
        ValueAnimator r120 = ValueAnimator.ofInt(new int[]{this.f206481g, this.f206482h});
        r120.setInterpolator(new DecelerateInterpolator());
        r120.setDuration(250);
        r120.addUpdateListener(r108);
        ValueAnimator r121 = ValueAnimator.ofInt(new int[]{this.f206481g, this.f206482h});
        r121.setInterpolator(new DecelerateInterpolator());
        r121.setDuration(250);
        r121.addUpdateListener(r109);
        this.f206491q.play(r113).before(r114);
        this.f206491q.play(r114).with(r115);
        this.f206491q.play(r116).after(r115);
        this.f206491q.play(r117).with(r116);
        this.f206491q.play(r118).after(r117);
        this.f206491q.play(r119).after(r118);
        this.f206491q.play(r120).after(r119);
        this.f206491q.play(r121).after(r120);
        this.f206491q.addListener(new v(this));
        if (this.f206478d == true) goto L9;
        return;
    L9:
        if (this.f206491q.isRunning() == false) goto L11;
        return;
    L11:
        if (this.f206491q.isStarted() == true) goto L17;
        int r122 = this.f206479e;
        this.f206483i = r122;
        this.f206484j = r122;
        this.f206485k = r122;
        this.f206491q.start();
        return;
    L17:
        return;
    L5:
        if (r210 != r111) goto L6;
    }

    public final void j(Canvas r100, int r101, int r102, int r103, Drawable r104) {
        if (this.f206479e < r102) goto L5;
        return;
    L5:
        if (r102 >= this.f206482h) goto L9;
        r100.save();
        int r105 = (int) (r104.getIntrinsicWidth() * this.f206489o);
        int r106 = (int) (r104.getIntrinsicHeight() * this.f206490p);
        r100.translate(this.f206479e, r103);
        r100.clipRect(r105, 0, this.f206482h - this.f206479e, r106);
        r104.setBounds(0, 0, r105, r106);
        r100.translate(r102 - this.f206479e, 0.0f);
        r104.draw(r100);
        r100.restoreToCount(r101);
        return;
    }
}
