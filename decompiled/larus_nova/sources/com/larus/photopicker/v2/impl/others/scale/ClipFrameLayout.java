package com.larus.photopicker.v2.impl.others.scale;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import pp9.j;
import qp9.c;

/* JADX INFO: loaded from: classes31.dex */
public abstract class ClipFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f364556m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f364557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f364558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f364559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f364560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f364561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f364562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f364563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f364564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f364565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f364566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j f364567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j f364568l;

    public ClipFrameLayout(Context r100) {
        super(r100);
        this.f364557a = new RectF();
        this.f364558b = new Path();
        this.f364559c = new RectF();
        this.f364560d = false;
        this.f364561e = false;
        this.f364562f = false;
        this.f364566j = new Rect();
        this.f364567k = new j(new Rect());
        this.f364568l = new j(new Rect());
    }

    public ClipFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f364557a = new RectF();
        this.f364558b = new Path();
        this.f364559c = new RectF();
        this.f364560d = false;
        this.f364561e = false;
        this.f364562f = false;
        this.f364566j = new Rect();
        this.f364567k = new j(new Rect());
        this.f364568l = new j(new Rect());
    }

    public ClipFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f364557a = new RectF();
        this.f364558b = new Path();
        this.f364559c = new RectF();
        this.f364560d = false;
        this.f364561e = false;
        this.f364562f = false;
        this.f364566j = new Rect();
        this.f364567k = new j(new Rect());
        this.f364568l = new j(new Rect());
    }

    public boolean a(Canvas r100, View r101, long r102) {
        return super.drawChild(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        if (this.f364562f == false) goto L13;
        r100.save();
        r100.clipRect(this.f364559c);
        if (this.f364561e == false) goto L8;
        r100.save();
        r100.clipPath(this.f364558b);
        boolean r103 = a(r100, r101, r102);
        r100.restore();
    L11:
        r100.restore();
        return r103;
    L8:
        if (this.f364560d == false) goto L10;
        r100.save();
        r100.clipRect(this.f364557a);
        r103 = a(r100, r101, r102);
        r100.restore();
        goto L11
    L10:
        r103 = a(r100, r101, r102);
        goto L11
    L13:
        if (this.f364561e == false) goto L16;
        r100.save();
        r100.clipPath(this.f364558b);
        boolean r104 = a(r100, r101, r102);
        r100.restore();
        return r104;
    L16:
        if (this.f364560d == false) goto L19;
        r100.save();
        r100.clipRect(this.f364557a);
        boolean r105 = a(r100, r101, r102);
        r100.restore();
        return r105;
    L19:
        return a(r100, r101, r102);
    }

    public final Animator b(Rect r100, Rect r101, float r102, final boolean r103) {
        this.f364563g = new Rect(r100);
        this.f364564h = new Rect(r101);
        this.f364565i = r102;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r104.addUpdateListener(new c(this, r103));
        return r104;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f364566j.set(0, 0, getWidth(), getHeight());
    }
}
