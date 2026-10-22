package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes41.dex */
public class GifTextureView extends TextureView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ImageView.ScaleType[] f529690g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView.ScaleType f529691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f529692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f529693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f529694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f529695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i.b f529696f;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f529697a = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            f529697a = r100;
            r100[ImageView.ScaleType.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f529697a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f529697a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f529697a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f529697a[ImageView.ScaleType.FIT_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f529697a[ImageView.ScaleType.FIT_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f529697a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f529697a[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static class b extends PthreadThreadV2 implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final pl.droidsonroids.gif.b f529698v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public GifInfoHandle f529699w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public IOException f529700x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public long[] f529701y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final WeakReference<GifTextureView> f529702z;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GifTextureView f529703a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f529704b;

            @Override // java.lang.Runnable
            public final void run() {
                GifTextureView r100 = this.f529703a;     // Catch: Throwable -> L4
                GifInfoHandle r101 = this.f529704b.f529699w;     // Catch: Throwable -> L4
                ImageView.ScaleType[] r102 = GifTextureView.f529690g;     // Catch: Throwable -> L4
                r100.d(r101);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r100, GifTextureView r101) {
                this.f529704b = r100;
                this.f529703a = r101;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        }

        public final void l() {
            GifTextureView r100 = this.f529702z.get();     // Catch: IOException -> L42
            if (r100 != null) goto L5;
            return;
        L5:
            GifInfoHandle r101 = r100.f529693c.a();     // Catch: IOException -> L42
            this.f529699w = r101;     // Catch: IOException -> L42
            r101.A(1, r100.isOpaque());     // Catch: IOException -> L42
            int r102 = r100.f529696f.f529737b;     // Catch: IOException -> L42
            if (r102 < 0) goto L8;
            this.f529699w.z(r102);     // Catch: IOException -> L42
        L8:
            GifTextureView r103 = this.f529702z.get();
            if (r103 != null) goto L12;
            this.f529699w.s();
            return;
        L12:
            GifTextureView.a(r103, this);
            boolean r104 = r103.isAvailable();
            pl.droidsonroids.gif.b r105 = this.f529698v;
            monitor-enter(r105);
            if (r104 == false) goto L16;
            r105.c();     // Catch: Throwable -> L39
        L17:
            monitor-exit(r105);
            if (r104 == false) goto L20;
            r103.post(new a(this, r103));
        L20:
            this.f529699w.B(r103.f529695e);
        L22:
            if (isInterrupted() == true) goto L37;
            this.f529698v.a();     // Catch: InterruptedException -> L36
            GifTextureView r106 = this.f529702z.get();
            if (r106 == null) goto L37;
            SurfaceTexture r107 = r106.getSurfaceTexture();
            if (r107 == null) goto L22;
            Surface r108 = new Surface(r107);
            this.f529699w.a(r108, this.f529701y);     // Catch: Throwable -> L33
            r108.release();
        L33:
            th = move-exception;
            r108.release();
            throw th;
        L36:
            ThreadMethodProxy.currentThread().interrupt();
        L37:
            this.f529699w.s();
            this.f529699w = new GifInfoHandle();
            return;
        L16:
            r105.b();     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            throw th;
        L42:
            e = move-exception;
            this.f529700x = e;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(GifTextureView r100) {
            super("GifRenderThread");
            this.f529698v = new pl.droidsonroids.gif.b();
            this.f529699w = new GifInfoHandle();
            this.f529702z = new WeakReference(r100);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            this.f529698v.b();
            this.f529699w.r();
            interrupt();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            GifTextureView r103 = this.f529702z.get();
            if (r103 == null) goto L5;
            GifInfoHandle r104 = this.f529699w;
            ImageView.ScaleType[] r105 = GifTextureView.f529690g;
            r103.d(r104);
        L5:
            this.f529698v.c();
        }
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    static {
        f529690g = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public IOException getIOException() {
        b r100 = this.f529694d;
        IOException r101 = r100.f529700x;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return GifIOException.fromCode(r100.f529699w.j());
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        b r100 = this.f529694d;
        r100.f529698v.b();
        a(this, null);
        r100.f529699w.r();
        r100.interrupt();
        super.onDetachedFromWindow();
        SurfaceTexture r101 = getSurfaceTexture();
        if (r101 == null) goto L6;
        r101.release();
        return;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b r100 = this.f529694d;
        r100.f529701y = r100.f529699w.l();
        Parcelable r101 = super.onSaveInstanceState();
        if (this.f529696f.f529736a == false) goto L5;
        long[] r102 = this.f529694d.f529701y;
    L7:
        return new GifViewSavedState(r101, r102);
    L5:
        r102 = null;
        goto L7
    }

    public ImageView.ScaleType getScaleType() {
        return this.f529691a;
    }

    public GifTextureView(Context r100) {
        super(r100);
        this.f529691a = ImageView.ScaleType.FIT_CENTER;
        this.f529692b = new Matrix();
        this.f529695e = 1.0f;
        b(null, 0);
    }

    private void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener r100) {
        super.setSurfaceTextureListener(r100);
    }

    public final synchronized void c(j r100) {
        monitor-enter(this);
        b r101 = this.f529694d;     // Catch: Throwable -> L21
        r101.f529698v.b();     // Catch: Throwable -> L21
        a(this, null);     // Catch: Throwable -> L21
        r101.f529699w.r();     // Catch: Throwable -> L21
        r101.interrupt();     // Catch: Throwable -> L21
        ThreadMethodProxy.join(this.f529694d);     // Catch: InterruptedException -> L6 Throwable -> L21
    L8:
        this.f529693c = r100;     // Catch: Throwable -> L21
        b r102 = new b(this);     // Catch: Throwable -> L21
        this.f529694d = r102;     // Catch: Throwable -> L21
        if (r100 == null) goto L11;
        ThreadMethodProxy.start(r102);     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L11:
        SurfaceTexture r103 = getSurfaceTexture();     // Catch: Throwable -> L21
        if (r103 == null) goto L19;
        Surface r104 = new Surface(r103);     // Catch: Throwable -> L21
        r104.unlockCanvasAndPost(r104.lockCanvas(null));     // Catch: Throwable -> L16
        r104.release();     // Catch: Throwable -> L21
        goto L19
    L16:
        th = move-exception;
        r104.release();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final void d(GifInfoHandle r110) {
        Matrix r100 = new Matrix();
        float r101 = getWidth();
        float r102 = getHeight();
        float r103 = r110.m() / r101;
        float r104 = r110.g() / r102;
        RectF r105 = new RectF(0.0f, 0.0f, r110.m(), r110.g());
        RectF r106 = new RectF(0.0f, 0.0f, r101, r102);
        float r107 = 1.0f;
        switch(a.f529697a[this.f529691a.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L19;
        };
    L5:
        r100.set(this.f529692b);
        r100.preScale(r103, r104);
        goto L19
    L6:
        return;
    L7:
        r100.setRectToRect(r105, r106, Matrix.ScaleToFit.START);
        r100.preScale(r103, r104);
        goto L19
    L8:
        r100.setRectToRect(r105, r106, Matrix.ScaleToFit.END);
        r100.preScale(r103, r104);
        goto L19
    L9:
        r100.setRectToRect(r105, r106, Matrix.ScaleToFit.CENTER);
        r100.preScale(r103, r104);
        goto L19
    L17:
        float r108 = 1.0f / Math.min(r103, r104);
        r100.setScale(r103 * r108, r108 * r104, r101 / 2.0f, r102 / 2.0f);
        goto L19
    L18:
        r100.setScale(r103, r104, r101 / 2.0f, r102 / 2.0f);
    L19:
        super.setTransform(r100);
        return;
    L11:
        if (r110.m() <= r101) goto L13;
    L15:
        r107 = Math.min(1.0f / r103, 1.0f / r104);
    L16:
        r100.setScale(r103 * r107, r107 * r104, r101 / 2.0f, r102 / 2.0f);
        goto L19
    L13:
        if (r110.g() > r102) goto L15;
        goto L15
    }

    @Override // android.view.TextureView
    public final Matrix getTransform(Matrix r100) {
        if (r100 != null) goto L4;
        r100 = new Matrix();
    L4:
        r100.set(this.f529692b);
        return r100;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof GifViewSavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        GifViewSavedState r101 = (GifViewSavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        b r102 = this.f529694d;
        r102.f529701y = r101.f529705a[0];
    }

    public void setFreezesAnimation(boolean r100) {
        this.f529696f.f529736a = r100;
    }

    public void setImageMatrix(Matrix r100) {
        setTransform(r100);
    }

    public synchronized void setInputSource(j r100) {
        monitor-enter(this);
        c(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean r100) {
        if (r100 == isOpaque()) goto L6;
        super.setOpaque(r100);
        setInputSource(this.f529693c);
        return;
    }

    public void setScaleType(ImageView.ScaleType r100) {
        this.f529691a = r100;
        d(this.f529694d.f529699w);
    }

    public void setSpeed(float r100) {
        this.f529695e = r100;
        this.f529694d.f529699w.B(r100);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture r100) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener r100) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix r100) {
        this.f529692b.set(r100);
        d(this.f529694d.f529699w);
    }

    public GifTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f529691a = ImageView.ScaleType.FIT_CENTER;
        this.f529692b = new Matrix();
        this.f529695e = 1.0f;
        b(r101, 0);
    }

    public static /* synthetic */ void a(GifTextureView r100, TextureView.SurfaceTextureListener r101) {
        r100.setSuperSurfaceTextureListener(r101);
    }

    public final void b(AttributeSet r100, int r101) {
        if (r100 == null) goto L25;
        int r102 = r100.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
        if (r102 < 0) goto L9;
        ImageView.ScaleType[] r103 = f529690g;
        if (r102 >= r103.length) goto L9;
        this.f529691a = r103[r102];
    L9:
        TypedArray r104 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.gifSource, R.attr.isOpaque}, r101, 0);
        TypedValue r105 = new TypedValue();
        if (r104.getValue(0, r105) == true) goto L13;
        j r106 = null;
    L24:
        this.f529693c = r106;
        super.setOpaque(r104.getBoolean(1, false));
        r104.recycle();
        this.f529696f = new i.b(this, r100, r101);
    L27:
        if (isInEditMode() == true) goto L32;
        b r107 = new b(this);
        this.f529694d = r107;
        if (this.f529693c == null) goto L33;
        ThreadMethodProxy.start(r107);
        return;
    L33:
        return;
    L32:
        return;
    L13:
        if (r105.resourceId == 0) goto L22;
        String r108 = r104.getResources().getResourceTypeName(r105.resourceId);
        if (i.f529733a.contains(r108) == false) goto L18;
        j r109 = new j.c(r104.getResources(), r105.resourceId);
    L23:
        r106 = r109;
        goto L24
    L18:
        if ("string".equals(r108) == true) goto L22;
        throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + r108 + "' is not supported");
    L22:
        r109 = new j.a(r104.getResources().getAssets(), r105.string.toString());
        goto L23
    L25:
        super.setOpaque(false);
        this.f529696f = new i.b();
        goto L27
    }

    public GifTextureView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f529691a = ImageView.ScaleType.FIT_CENTER;
        this.f529692b = new Matrix();
        this.f529695e = 1.0f;
        b(r101, r102);
    }
}
