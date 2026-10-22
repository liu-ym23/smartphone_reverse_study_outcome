package com.lynx.animax.drawable;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.lynx.animax.util.AnimaXLog;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXSurfaceDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Surface f380261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SurfaceTexture f380262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitmapBufferGroup f380263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DrawableType f380264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f380265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f380266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f380268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f380269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f380270j;

    public static final enum DrawableType extends Enum<DrawableType> {
        public static final DrawableType BitmapBufferGroup = null;
        public static final DrawableType Invalid = null;
        public static final DrawableType SurfaceView = null;
        public static final DrawableType TextureView = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DrawableType[] f380271a = null;

        static {
            DrawableType r100 = new DrawableType("Invalid", 0);
            Invalid = r100;
            DrawableType r101 = new DrawableType("TextureView", 1);
            TextureView = r101;
            DrawableType r102 = new DrawableType("SurfaceView", 2);
            SurfaceView = r102;
            DrawableType r103 = new DrawableType("BitmapBufferGroup", 3);
            BitmapBufferGroup = r103;
            f380271a = new DrawableType[]{r100, r101, r102, r103};
        }

        public static DrawableType[] values() {
            return (DrawableType[]) f380271a.clone();
        }

        public static DrawableType valueOf(String r100) {
            return (DrawableType) a.a(DrawableType.class, r100);
        }

        public DrawableType(String r100, int r101) {
            super(r100, r101);
        }
    }

    private long getTypeIndex() {
        return this.f380264d.ordinal();
    }

    public boolean isTextureFirstFrameAware() {
        SurfaceTexture r100 = this.f380262b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100 instanceof FirstFrameAwareSurfaceTexture;
    }

    public BitmapBufferGroup getBitmapBufferGroup() {
        return this.f380263c;
    }

    public int getHeight() {
        return this.f380266f;
    }

    public Surface getSurface() {
        return this.f380261a;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f380262b;
    }

    public DrawableType getType() {
        return this.f380264d;
    }

    public int getWidth() {
        return this.f380265e;
    }

    public boolean isAntiAliasingEnabled() {
        return this.f380267g;
    }

    public boolean isAutoDestroyEGLContextEnabled() {
        return this.f380270j;
    }

    public boolean isPlatformSurfaceInitiallyInvalid() {
        return this.f380269i;
    }

    public boolean isSoftwareRenderEnabled() {
        return this.f380268h;
    }

    public final boolean a(int r100, int r101) {
        if (Math.abs(this.f380265e - r100) <= 1) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L12;
        AnimaXLog.b("AnimaXSurfaceDrawable", "Skip same size: " + r100 + " / " + r101);
        return false;
    L12:
        this.f380265e = r100;
        this.f380266f = r101;
        BitmapBufferGroup r103 = this.f380263c;
        if (r103 == null) goto L15;
        r103.b(r100, r101);
    L15:
        AnimaXLog.b("AnimaXSurfaceDrawable", "Update size success: " + r100 + " / " + r101);
        return true;
    L5:
        if (Math.abs(this.f380266f - r101) > 1) goto L7;
        r102 = true;
        goto L9
    }

    public AnimaXSurfaceDrawable(Surface r100, SurfaceTexture r101, BitmapBufferGroup r102, int r103, int r104) {
        this.f380267g = false;
        this.f380268h = false;
        this.f380269i = false;
        this.f380270j = false;
        this.f380261a = r100;
        this.f380262b = r101;
        this.f380263c = r102;
        if (r101 == null) goto L5;
        this.f380264d = DrawableType.TextureView;
    L10:
        this.f380265e = r103;
        this.f380266f = r104;
        return;
    L5:
        if (r102 == null) goto L7;
        this.f380264d = DrawableType.BitmapBufferGroup;
        r102.b(r103, r104);
        goto L10
    L7:
        if (r100 == null) goto L9;
        this.f380264d = DrawableType.SurfaceView;
        goto L10
    L9:
        this.f380264d = DrawableType.Invalid;
        goto L10
    }
}
