package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import vqc.c;
import vqc.f;

/* JADX INFO: loaded from: classes41.dex */
public class TransformImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f464500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f464501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f464502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f464503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f464504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f464505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f464506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f464507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f464508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f464509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f464510k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f464511l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f464512m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f464513n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public tqc.b f464514o;

    public class a implements sqc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransformImageView f464515a;

        public a(CropImageView r100) {
            this.f464515a = r100;
        }
    }

    public interface b {
        void a();

        void b(Exception r100);

        void c(float r100);

        void d(float r100);
    }

    public float getCurrentAngle() {
        return j(this.f464503d);
    }

    public float getCurrentScale() {
        return l(this.f464503d);
    }

    public int getMaxBitmapSize() {
        if (this.f464511l > 0) goto L17;
        WindowManager r100 = (WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Point r101 = new Point();
        if (r100 == null) goto L7;
        r100.getDefaultDisplay().getSize(r101);
    L7:
        int r102 = (int) Math.sqrt(Math.pow(r101.x, 2.0d) + Math.pow(r101.y, 2.0d));
        Canvas r103 = new Canvas();
        int r104 = Math.min(r103.getMaximumBitmapWidth(), r103.getMaximumBitmapHeight());
        if (r104 <= 0) goto L18;
        r102 = Math.min(r102, r104);
    L18:
        int r105 = vqc.b.a();     // Catch: Exception -> L12
    L13:
        if (r105 <= 0) goto L15;
        r102 = Math.min(r102, r105);
    L15:
        this.f464511l = r102;
    L12:
        r105 = 0;
    L17:
        return this.f464511l;
    }

    public void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public Bitmap getViewBitmap() {
        if (getDrawable() != null) goto L5;
        return null;
    L5:
        if ((getDrawable() instanceof c) == true) goto L8;
        return null;
    L8:
        return ((c) getDrawable()).f556787b;
    }

    public void m() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L5;
        return;
    L5:
        float r101 = r100.getIntrinsicWidth();
        float r102 = r100.getIntrinsicHeight();
        String.format("Image size: [%d:%d]", new Object[]{Integer.valueOf((int) r101), Integer.valueOf((int) r102)});
        RectF r103 = new RectF(0.0f, 0.0f, r101, r102);
        this.f464507h = f.a(r103);
        this.f464508i = new float[]{r103.centerX(), r103.centerY()};
        this.f464510k = true;
        b r104 = this.f464506g;
        if (r104 == null) goto L9;
        r104.a();
        return;
    }

    public tqc.b getExifInfo() {
        return this.f464514o;
    }

    public String getImageInputPath() {
        return this.f464512m;
    }

    public String getImageOutputPath() {
        return this.f464513n;
    }

    public TransformImageView(Context r100) {
        this(r100, null);
    }

    public final float j(Matrix r100) {
        r100.getValues(this.f464502c);
        float[] r101 = this.f464502c;
        double r102 = r101[1];
        r100.getValues(r101);
        return (float) (-(Math.atan2(r102, this.f464502c[0]) * 57.29577951308232d));
    }

    public final float l(Matrix r100) {
        r100.getValues(this.f464502c);
        double r101 = Math.pow(this.f464502c[0], 2.0d);
        r100.getValues(this.f464502c);
        return (float) Math.sqrt(r101 + Math.pow(this.f464502c[3], 2.0d));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        setImageDrawable(new c(r100));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix r100) {
        super.setImageMatrix(r100);
        this.f464503d.set(r100);
        this.f464503d.mapPoints(this.f464500a, this.f464507h);
        this.f464503d.mapPoints(this.f464501b, this.f464508i);
    }

    public void setMaxBitmapSize(int r100) {
        this.f464511l = r100;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r100) {
        if (r100 != ImageView.ScaleType.MATRIX) goto L6;
        super.setScaleType(r100);
        return;
    }

    public void setTransformImageListener(b r100) {
        this.f464506g = r100;
    }

    public TransformImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public void p(float r100, float r101) {
        if (r100 == 0.0f) goto L5;
    L6:
        this.f464503d.postTranslate(r100, r101);
        setImageMatrix(this.f464503d);
        return;
    L5:
        if (r101 != 0.0f) goto L6;
    }

    public final void q(Uri r100, Uri r110) throws Exception {
        int r101 = getMaxBitmapSize();
        new uqc.a(getContext(), r100, r110, r101, r101, new a((CropImageView) this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public TransformImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f464500a = new float[8];
        this.f464501b = new float[2];
        this.f464502c = new float[9];
        this.f464503d = new Matrix();
        this.f464509j = false;
        this.f464510k = false;
        this.f464511l = 0;
        init();
    }

    public final void n(float r100, float r101, float r102) {
        if (r100 == 0.0f) goto L8;
        this.f464503d.postRotate(r100, r101, r102);
        setImageMatrix(this.f464503d);
        b r103 = this.f464506g;
        if (r103 == null) goto L9;
        r103.d(j(this.f464503d));
        return;
    L9:
        return;
    }

    public void o(float r100, float r101, float r102) {
        if (r100 == 0.0f) goto L8;
        this.f464503d.postScale(r100, r100, r101, r102);
        setImageMatrix(this.f464503d);
        b r103 = this.f464506g;
        if (r103 == null) goto L9;
        r103.c(l(this.f464503d));
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L5;
    L8:
        int r105 = getPaddingLeft();
        int r106 = getPaddingTop();
        int r107 = getWidth() - getPaddingRight();
        int r108 = getHeight() - getPaddingBottom();
        this.f464504e = r107 - r105;
        this.f464505f = r108 - r106;
        m();
        return;
    L5:
        if (this.f464509j == true) goto L7;
        return;
    L7:
        if (this.f464510k == false) goto L8;
    }
}
