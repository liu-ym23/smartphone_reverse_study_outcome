package hda;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class w1 extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f484781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScaleGestureDetector f484782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f484783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f484784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f484785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f484786f;

    public final class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f484787a;

        public a(w1 r100) {
            this.f484787a = r100;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            float r101 = this.f484787a.f484785e * r100.getScaleFactor();
            float r102 = this.f484787a.f484784d;
            float r103 = RangesKt.coerceIn(r101, r102, 4.0f * r102);
            w1 r104 = this.f484787a;
            float r105 = r103 / r104.f484785e;
            r104.f484781a.postScale(r105, r105, r100.getFocusX(), r100.getFocusY());
            w1 r106 = this.f484787a;
            r106.f484785e = r103;
            r106.b();
            w1 r107 = this.f484787a;
            r107.setImageMatrix(r107.f484781a);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            this.f484787a.f484783c.f484788a = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            this.f484787a.f484783c.f484788a = false;
        }
    }

    public final void a() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L6;
        return;
    L6:
        if (getWidth() > 0) goto L8;
        return;
    L8:
        if (getHeight() > 0) goto L10;
        return;
    L10:
        if (r100.getIntrinsicWidth() > 0) goto L12;
        return;
    L12:
        if (r100.getIntrinsicHeight() > 0) goto L14;
        return;
    L14:
        if (this.f484786f == true) goto L22;
        float r101 = getWidth() / r100.getIntrinsicWidth();
        float r102 = (getWidth() - (r100.getIntrinsicWidth() * r101)) / 2.0f;
        float r103 = (getHeight() - (r100.getIntrinsicHeight() * r101)) / 2.0f;
        this.f484781a.reset();
        this.f484781a.postScale(r101, r101);
        this.f484781a.postTranslate(r102, r103);
        b();
        setImageMatrix(this.f484781a);
        this.f484784d = r101;
        this.f484785e = r101;
        this.f484786f = true;
        return;
    }

    public final void b() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L6;
        return;
    L6:
        if (getWidth() > 0) goto L8;
        return;
    L8:
        if (getHeight() > 0) goto L10;
        return;
    L10:
        if (r100.getIntrinsicWidth() > 0) goto L12;
        return;
    L12:
        if (r100.getIntrinsicHeight() <= 0) goto L27;
        float[] r101 = new float[9];
        this.f484781a.getValues(r101);
        float r102 = r101[0];
        float r103 = r101[4];
        float r104 = r100.getIntrinsicWidth() * r102;
        float r105 = r100.getIntrinsicHeight() * r103;
        float r106 = r101[2];
        float r107 = getWidth();
        float r108 = r107 - r104;
        if (r104 > r107) goto L17;
        float r109 = r108 / 2.0f;
    L18:
        float r110 = r101[5];
        float r111 = getHeight();
        float r112 = r111 - r105;
        if (r105 > r111) goto L21;
        float r113 = r112 / 2.0f;
    L22:
        this.f484781a.postTranslate(r109 - r101[2], r113 - r101[5]);
        return;
    L21:
        r113 = RangesKt.coerceIn(r110, r112, 0.0f);
        goto L22
    L17:
        r109 = RangesKt.coerceIn(r106, r108, 0.0f);
        goto L18
    }

    public w1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f484781a = new Matrix();
        this.f484782b = new ScaleGestureDetector(r100, new a(this));
        this.f484783c = new x();
        this.f484784d = 1.0f;
        this.f484785e = 1.0f;
        setScaleType(ImageView.ScaleType.MATRIX);
        setBackgroundColor(-16777216);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f484782b.onTouchEvent(r100);
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        x r102 = this.f484783c;
        float r103 = r100.getX();
        float r104 = r100.getY();
        r102.f484789b = r103;
        r102.f484790c = r104;
        r102.f484788a = true;
    L29:
        return true;
    L5:
        if (r101 != 1) goto L7;
    L27:
        this.f484783c.f484788a = false;
        goto L29
    L7:
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L27;
        if (r101 != 5) goto L13;
    L15:
        this.f484783c.f484788a = false;
        goto L29
    L13:
        if (r101 == 6) goto L15;
    L17:
        if (this.f484782b.isInProgress() == false) goto L19;
    L26:
        this.f484783c.f484788a = false;
        goto L29
    L19:
        if (r100.getPointerCount() != 1) goto L26;
        x r105 = this.f484783c;
        float r106 = r100.getX();
        float r107 = r100.getY();
        if (r105.f484788a == true) goto L23;
        r105.f484789b = r106;
        r105.f484790c = r107;
        r105.f484788a = true;
        w r108 = null;
    L24:
        if (r108 == null) goto L29;
        this.f484781a.postTranslate(r108.f484772a, r108.f484773b);
        b();
        setImageMatrix(this.f484781a);
        goto L29
    L23:
        w r109 = new w(r106 - r105.f484789b, r107 - r105.f484790c);
        r105.f484789b = r106;
        r105.f484790c = r107;
        r108 = r109;
        goto L24
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        this.f484786f = false;
        post(new v1(this));
    }

    @Override // android.widget.ImageView
    public final void setImageURI(Uri r100) {
        super.setImageURI(r100);
        this.f484786f = false;
        post(new v1(this));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f484786f = false;
        a();
    }
}
