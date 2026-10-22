package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterImageView extends View implements s5a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageReader f380490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Image f380491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f380492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlutterRenderer f380493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SurfaceKind f380494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f380495f;

    public static final enum SurfaceKind extends Enum<SurfaceKind> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SurfaceKind[] f380496a = null;
        public static final SurfaceKind background = null;
        public static final SurfaceKind overlay = null;

        static {
            SurfaceKind r100 = new SurfaceKind("background", 0);
            background = r100;
            SurfaceKind r101 = new SurfaceKind("overlay", 1);
            overlay = r101;
            f380496a = new SurfaceKind[]{r100, r101};
        }

        public static SurfaceKind[] values() {
            return (SurfaceKind[]) f380496a.clone();
        }

        public static SurfaceKind valueOf(String r100) {
            return (SurfaceKind) r27.a.a(SurfaceKind.class, r100);
        }

        public SurfaceKind(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f380497a = null;

        static {
            int[] r100 = new int[SurfaceKind.values().length];
            f380497a = r100;
            r100[SurfaceKind.background.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f380497a[SurfaceKind.overlay.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // s5a.c
    public final void pause() {
    }

    @Override // s5a.c
    public final void b() {
        if (this.f380495f == true) goto L5;
        return;
    L5:
        setAlpha(0.0f);
        c(true);
        this.f380492c = null;
        Image r100 = this.f380491b;
        if (r100 == null) goto L8;
        r100.close();
        this.f380491b = null;
    L8:
        invalidate();
        this.f380495f = false;
    }

    public Surface getSurface() {
        return this.f380490a.getSurface();
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.f380493d;
    }

    public ImageReader getImageReader() {
        return this.f380490a;
    }

    public FlutterImageView(Context r100) {
        this(r100, 1, 1, SurfaceKind.background);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r100) {
        if (a.f380497a[this.f380494e.ordinal()] != 1) goto L6;
        Surface r101 = this.f380490a.getSurface();
        r100.f380934b = r101;
        r100.f380933a.onSurfaceWindowChanged(r101);
    L6:
        setAlpha(1.0f);
        this.f380493d = r100;
        this.f380495f = true;
    }

    public final boolean c(boolean r100) {
        if (this.f380495f == true) goto L5;
        return false;
    L5:
        if (r100 == false) goto L7;
        Image r101 = this.f380490a.acquireLatestImage();
    L8:
        if (r101 == null) goto L13;
        Image r102 = this.f380491b;
        if (r102 == null) goto L12;
        r102.close();
        this.f380491b = null;
    L12:
        this.f380491b = r101;
        invalidate();
    L13:
        if (r101 == null) goto L16;
        return true;
    L16:
        return false;
    L7:
        r101 = this.f380490a.acquireNextImage();
        goto L8
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        Image r101 = this.f380491b;
        if (r101 != null) goto L5;
    L18:
        Bitmap r102 = this.f380492c;
        if (r102 == null) goto L22;
        r100.drawBitmap(r102, 0.0f, 0.0f, null);
        return;
    L22:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L7;
        HardwareBuffer r103 = r101.getHardwareBuffer();
        this.f380492c = Bitmap.wrapHardwareBuffer(r103, ColorSpace.get(ColorSpace.Named.SRGB));
        r103.close();
        goto L18
    L7:
        Image.Plane[] r104 = r101.getPlanes();
        if (r104.length != 1) goto L18;
        Image.Plane r105 = r104[0];
        int r106 = r105.getRowStride() / r105.getPixelStride();
        int r107 = this.f380491b.getHeight();
        Bitmap r108 = this.f380492c;
        if (r108 != null) goto L13;
    L16:
        this.f380492c = Bitmap.createBitmap(r106, r107, Bitmap.Config.ARGB_8888);
    L17:
        ByteBuffer r109 = r105.getBuffer();
        r109.rewind();
        this.f380492c.copyPixelsFromBuffer(r109);
        goto L18
    L13:
        if (r108.getWidth() != r106) goto L16;
        if (this.f380492c.getHeight() == r107) goto L17;
        goto L16
    }

    public FlutterImageView(Context r100, AttributeSet r101) {
        this(r100, 1, 1, SurfaceKind.background);
    }

    public static ImageReader d(int r110, int r111) {
        if (r110 > 0) goto L5;
        c5a.c.d(5, "FlutterImageView", String.format(Locale.US, "ImageReader width must be greater than 0, but given width=%d, set width=1", new Object[]{Integer.valueOf(r110)}));
        int r100 = 1;
    L6:
        if (r111 > 0) goto L8;
        c5a.c.d(5, "FlutterImageView", String.format(Locale.US, "ImageReader height must be greater than 0, but given height=%d, set height=1", new Object[]{Integer.valueOf(r111)}));
        int r101 = 1;
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L14;
        return ImageReader.newInstance(r100, r101, 1, 3, 768);
    L14:
        return ImageReader.newInstance(r100, r101, 1, 3);
    L8:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L6
    }

    public final void e(int r100, int r101) {
        if (this.f380493d != null) goto L6;
        return;
    L6:
        if (r100 == this.f380490a.getWidth()) goto L8;
    L10:
        Image r102 = this.f380491b;
        if (r102 == null) goto L13;
        r102.close();
        this.f380491b = null;
    L13:
        this.f380490a.close();
        this.f380490a = d(r100, r101);
        return;
    L8:
        if (r101 != this.f380490a.getHeight()) goto L10;
    }

    public FlutterImageView(Context r100, int r101, int r102, SurfaceKind r103) {
        ImageReader r104 = d(r101, r102);
        super(r100, null);
        this.f380495f = false;
        this.f380490a = r104;
        this.f380494e = r103;
        setAlpha(0.0f);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (r100 != this.f380490a.getWidth()) goto L8;
        if (r101 != this.f380490a.getHeight()) goto L8;
        return;
    L8:
        if (this.f380494e == SurfaceKind.background) goto L10;
        return;
    L10:
        if (this.f380495f == false) goto L14;
        e(r100, r101);
        FlutterRenderer r104 = this.f380493d;
        Surface r105 = this.f380490a.getSurface();
        r104.f380934b = r105;
        r104.f380933a.onSurfaceWindowChanged(r105);
        return;
    }
}
