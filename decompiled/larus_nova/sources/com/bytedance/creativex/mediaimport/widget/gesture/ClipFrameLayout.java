package com.bytedance.creativex.mediaimport.widget.gesture;

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
import bj4.a;
import bj4.e;

/* JADX INFO: loaded from: classes15.dex */
public abstract class ClipFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f204187m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f204188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f204189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f204190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f204191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f204192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f204193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f204194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f204195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f204196i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f204197j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f204198k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f204199l;

    public ClipFrameLayout(Context r100) {
        super(r100);
        this.f204188a = new RectF();
        this.f204189b = new Path();
        this.f204190c = new RectF();
        this.f204191d = false;
        this.f204192e = false;
        this.f204193f = false;
        this.f204197j = new Rect();
        this.f204198k = new e(new Rect());
        this.f204199l = new e(new Rect());
    }

    public ClipFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f204188a = new RectF();
        this.f204189b = new Path();
        this.f204190c = new RectF();
        this.f204191d = false;
        this.f204192e = false;
        this.f204193f = false;
        this.f204197j = new Rect();
        this.f204198k = new e(new Rect());
        this.f204199l = new e(new Rect());
    }

    public ClipFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f204188a = new RectF();
        this.f204189b = new Path();
        this.f204190c = new RectF();
        this.f204191d = false;
        this.f204192e = false;
        this.f204193f = false;
        this.f204197j = new Rect();
        this.f204198k = new e(new Rect());
        this.f204199l = new e(new Rect());
    }

    public boolean a(Canvas r100, View r101, long r102) {
        return super.drawChild(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        if (this.f204193f == false) goto L13;
        r100.save();
        r100.clipRect(this.f204190c);
        if (this.f204192e == false) goto L8;
        r100.save();
        r100.clipPath(this.f204189b);
        boolean r103 = a(r100, r101, r102);
        r100.restore();
    L11:
        r100.restore();
        return r103;
    L8:
        if (this.f204191d == false) goto L10;
        r100.save();
        r100.clipRect(this.f204188a);
        r103 = a(r100, r101, r102);
        r100.restore();
        goto L11
    L10:
        r103 = a(r100, r101, r102);
        goto L11
    L13:
        if (this.f204192e == false) goto L16;
        r100.save();
        r100.clipPath(this.f204189b);
        boolean r104 = a(r100, r101, r102);
        r100.restore();
        return r104;
    L16:
        if (this.f204191d == false) goto L19;
        r100.save();
        r100.clipRect(this.f204188a);
        boolean r105 = a(r100, r101, r102);
        r100.restore();
        return r105;
    L19:
        return a(r100, r101, r102);
    }

    public final Animator b(Rect r100, Rect r101, float r102, final boolean r103) {
        this.f204194g = new Rect(r100);
        this.f204195h = new Rect(r101);
        this.f204196i = r102;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r104.addUpdateListener(new a(this, r103));
        return r104;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f204197j.set(0, 0, getWidth(), getHeight());
    }
}
