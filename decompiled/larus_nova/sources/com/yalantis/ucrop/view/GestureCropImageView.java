package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import vqc.g;

/* JADX INFO: loaded from: classes41.dex */
public class GestureCropImageView extends CropImageView {
    public ScaleGestureDetector B;
    public g C;
    public GestureDetector D;
    public float E;
    public float F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f464470J;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureCropImageView f464471a;

        public a(GestureCropImageView r100) {
            this.f464471a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            GestureCropImageView r101 = this.f464471a;
            float r102 = r101.getDoubleTapTargetScale();
            float r103 = r100.getX();
            float r104 = r100.getY();
            if (r102 <= r101.getMaxScale()) goto L5;
            r102 = r101.getMaxScale();
        L5:
            float r105 = r101.getCurrentScale();
            CropImageView.b r106 = new CropImageView.b(r101, r105, r102 - r105, r103, r104);
            r101.f464448v = r106;
            r101.post(r106);
            return super.onDoubleTap(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            this.f464471a.p(-r102, -r103);
            return true;
        }
    }

    public class b extends g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureCropImageView f464472a;

        public b(GestureCropImageView r100) {
            this.f464472a = r100;
        }
    }

    public class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureCropImageView f464473a;

        public c(GestureCropImageView r100) {
            this.f464473a = r100;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            GestureCropImageView r101 = this.f464473a;
            float r102 = r100.getScaleFactor();
            GestureCropImageView r103 = this.f464473a;
            r101.o(r102, r103.E, r103.F);
            return true;
        }
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.f464470J));
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public final void init() {
        super.init();
        this.D = new GestureDetector(getContext(), new a(this), null, true);
        this.B = new ScaleGestureDetector(getContext(), new c(this));
        this.C = new g(new b(this));
    }

    public int getDoubleTapScaleSteps() {
        return this.f464470J;
    }

    public GestureCropImageView(Context r100) {
        super(r100);
        this.G = true;
        this.H = true;
        this.I = true;
        this.f464470J = 5;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if ((r110.getAction() & 255) != 0) goto L6;
        s();
    L6:
        if (r110.getPointerCount() <= 1) goto L9;
        this.E = (r110.getX(0) + r110.getX(1)) / 2.0f;
        this.F = (r110.getY(0) + r110.getY(1)) / 2.0f;
    L9:
        if (this.I == false) goto L12;
        this.D.onTouchEvent(r110);
    L12:
        if (this.H == false) goto L15;
        this.B.onTouchEvent(r110);
    L15:
        if (this.G == false) goto L51;
        g r100 = this.C;
        r100.getClass();
        int r101 = r110.getActionMasked();
        if (r101 != 0) goto L19;
        r100.f556797c = r110.getX();
        r100.f556798d = r110.getY();
        r100.f556799e = r110.findPointerIndex(r110.getPointerId(0));
        r100.f556801g = 0.0f;
        r100.f556802h = true;
        goto L51
    L19:
        if (r101 != 1) goto L21;
        r100.f556799e = -1;
        goto L51
    L21:
        if (r101 == 2) goto L30;
        if (r101 != 5) goto L25;
        r100.f556795a = r110.getX();
        r100.f556796b = r110.getY();
        r100.f556800f = r110.findPointerIndex(r110.getPointerId(r110.getActionIndex()));
        r100.f556801g = 0.0f;
        r100.f556802h = true;
        goto L51
    L25:
        if (r101 != 6) goto L51;
        r100.f556800f = -1;
        goto L51
    L30:
        if (r100.f556799e == (-1)) goto L51;
        if (r100.f556800f == (-1)) goto L51;
        if (r110.getPointerCount() <= r100.f556800f) goto L51;
        float r102 = r110.getX(r100.f556799e);
        float r103 = r110.getY(r100.f556799e);
        float r104 = r110.getX(r100.f556800f);
        float r105 = r110.getY(r100.f556800f);
        if (r100.f556802h == false) goto L38;
        r100.f556801g = 0.0f;
        r100.f556802h = false;
    L44:
        g.a r106 = r100.f556803i;
        if (r106 == null) goto L47;
        GestureCropImageView r107 = ((b) r106).f464472a;
        r107.n(r100.f556801g, r107.E, r107.F);
    L47:
        r100.f556795a = r104;
        r100.f556796b = r105;
        r100.f556797c = r102;
        r100.f556798d = r103;
        goto L51
    L38:
        float r108 = r100.f556795a;
        float r109 = (((float) Math.toDegrees((float) Math.atan2(r105 - r103, r104 - r102))) % 360.0f) - (((float) Math.toDegrees((float) Math.atan2(r100.f556796b - r100.f556798d, r108 - r100.f556797c))) % 360.0f);
        r100.f556801g = r109;
        if (r109 >= (-180.0f)) goto L42;
        r100.f556801g = r109 + 360.0f;
        goto L44
    L42:
        if (r109 <= 180.0f) goto L44;
        r100.f556801g = r109 - 360.0f;
    L51:
        if ((r110.getAction() & 255) != 1) goto L53;
        setImageToWrapCropBounds(true);
    L53:
        return true;
    }

    public void setDoubleTapScaleSteps(int r100) {
        this.f464470J = r100;
    }

    public void setGestureEnabled(boolean r100) {
        this.I = r100;
    }

    public void setRotateEnabled(boolean r100) {
        this.G = r100;
    }

    public void setScaleEnabled(boolean r100) {
        this.H = r100;
    }

    public GestureCropImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public GestureCropImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.G = true;
        this.H = true;
        this.I = true;
        this.f464470J = 5;
    }
}
