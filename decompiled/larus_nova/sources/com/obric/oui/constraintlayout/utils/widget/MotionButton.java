package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class MotionButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f400321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f400322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f400323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewOutlineProvider f400324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f400325e;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionButton f400326a;

        public a(MotionButton r100) {
            this.f400326a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            int r102 = this.f400326a.getWidth();
            int r103 = this.f400326a.getHeight();
            r101.setRoundRect(0, 0, r102, r103, (Math.min(r102, r103) * this.f400326a.f400321a) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionButton f400327a;

        public b(MotionButton r100) {
            this.f400327a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            r101.setRoundRect(0, 0, this.f400327a.getWidth(), this.f400327a.getHeight(), this.f400327a.f400322b);
        }
    }

    public float getRound() {
        return this.f400322b;
    }

    public float getRoundPercent() {
        return this.f400321a;
    }

    public MotionButton(Context r100) {
        super(r100);
        this.f400321a = 0.0f;
        this.f400322b = Float.NaN;
        a(r100, null);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
    }

    public void setRound(float r100) {
        if (Float.isNaN(r100) == false) goto L7;
        this.f400322b = r100;
        float r101 = this.f400321a;
        this.f400321a = -1.0f;
        setRoundPercent(r101);
        return;
    L7:
        if (this.f400322b == r100) goto L9;
        boolean r102 = true;
    L10:
        this.f400322b = r100;
        if (r100 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r102 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f400323c != null) goto L16;
        this.f400323c = new Path();
    L16:
        if (this.f400325e != null) goto L19;
        this.f400325e = new RectF();
    L19:
        if (this.f400324d != null) goto L21;
        b r103 = new b(this);
        this.f400324d = r103;
        setOutlineProvider(r103);
    L21:
        setClipToOutline(true);
        this.f400325e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f400323c.reset();
        Path r104 = this.f400323c;
        RectF r105 = this.f400325e;
        float r106 = this.f400322b;
        r104.addRoundRect(r105, r106, r106, Path.Direction.CW);
        goto L23
    L9:
        r102 = false;
        goto L10
    }

    public void setRoundPercent(float r100) {
        if (this.f400321a == r100) goto L5;
        boolean r101 = true;
    L6:
        this.f400321a = r100;
        if (r100 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r101 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f400323c != null) goto L12;
        this.f400323c = new Path();
    L12:
        if (this.f400325e != null) goto L15;
        this.f400325e = new RectF();
    L15:
        if (this.f400324d != null) goto L17;
        a r102 = new a(this);
        this.f400324d = r102;
        setOutlineProvider(r102);
    L17:
        setClipToOutline(true);
        int r103 = getWidth();
        int r104 = getHeight();
        float r105 = (Math.min(r103, r104) * this.f400321a) / 2.0f;
        this.f400325e.set(0.0f, 0.0f, r103, r104);
        this.f400323c.reset();
        this.f400323c.addRoundRect(this.f400325e, r105, r105, Path.Direction.CW);
        goto L19
    L5:
        r101 = false;
        goto L6
    }

    public MotionButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400321a = 0.0f;
        this.f400322b = Float.NaN;
        a(r100, r101);
    }

    public final void a(Context r100, AttributeSet r101) {
        int r102 = 0;
        setPadding(0, 0, 0, 0);
        if (r101 == null) goto L19;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.altSrc, R.attr.blendSrc, R.attr.brightness, R.attr.contrast, R.attr.crossfade, R.attr.imagePanX, R.attr.imagePanY, R.attr.imageRotate, R.attr.imageZoom, R.attr.overlay, R.attr.round, R.attr.roundPercent, R.attr.saturation, R.attr.warmth});
        int r104 = r103.getIndexCount();
    L5:
        if (r102 >= r104) goto L13;
        int r105 = r103.getIndex(r102);
        if (r105 != 10) goto L10;
        setRound(r103.getDimension(r105, 0.0f));
    L12:
        r102 = r102 + 1;
        goto L5
    L10:
        if (r105 != 11) goto L12;
        setRoundPercent(r103.getFloat(r105, 0.0f));
        goto L12
    L13:
        r103.recycle();
        return;
    }

    public MotionButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400321a = 0.0f;
        this.f400322b = Float.NaN;
        a(r100, r101);
    }
}
