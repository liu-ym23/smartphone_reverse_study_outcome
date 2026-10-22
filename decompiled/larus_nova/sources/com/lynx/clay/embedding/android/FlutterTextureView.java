package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterTextureView extends TextureView implements s5a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f380506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f380507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FlutterRenderer f380508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f380509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SurfaceTexture f380510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f380511f;

    public class a implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlutterTextureView f380512a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        }

        public a(FlutterTextureView r100) {
            this.f380512a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            c5a.c.e();
            FlutterTextureView r101 = this.f380512a;
            r101.f380506a = false;
            if (r101.f380511f == false) goto L6;
            return false;
        L6:
            if (r101.f380507b == false) goto L17;
            FlutterRenderer r102 = r101.f380508c;
            if (r102 == null) goto L16;
            r102.b(false);
            SurfaceTexture r103 = r101.f380510e;
            if (r103 == null) goto L12;
            r103.release();
            r101.f380510e = null;
        L12:
            Surface r104 = r101.f380509d;
            if (r104 == null) goto L19;
            r104.release();
            r101.f380509d = null;
            return true;
        L19:
            return true;
        L16:
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        L17:
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            c5a.c.e();
            FlutterTextureView r103 = this.f380512a;
            if (r103.f380511f == false) goto L12;
            SurfaceTexture r104 = r103.f380510e;
            if (r100 == r104) goto L11;
            if (r104 == null) goto L8;
            r104.release();
            r103.f380510e = null;
        L8:
            Surface r105 = r103.f380509d;
            if (r105 == null) goto L11;
            r105.release();
            r103.f380509d = null;
        L11:
            this.f380512a.f380510e = r100;
        L12:
            FlutterTextureView r106 = this.f380512a;
            Surface r107 = r106.f380509d;
            if (r107 == null) goto L15;
            r107.release();
            r106.f380509d = null;
        L15:
            FlutterTextureView r108 = this.f380512a;
            r108.f380509d = new Surface(r100);
            FlutterTextureView r109 = this.f380512a;
            r109.f380506a = true;
            if (r109.f380507b == true) goto L18;
            return;
        L18:
            if (r109.f380508c == null) goto L23;
            if (r109.getSurfaceTexture() == null) goto L23;
            r109.f380508c.a(r109.f380509d, false);
            return;
        L23:
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            c5a.c.e();
            FlutterTextureView r103 = this.f380512a;
            if (r103.f380507b == true) goto L5;
            return;
        L5:
            if (r103.f380508c == null) goto L8;
            c5a.c.e();
            r103.f380508c.f380933a.onSurfaceChanged(r101, r102);
            return;
        L8:
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
    }

    @Override // s5a.c
    public final void b() {
        if (this.f380508c != null) goto L5;
        c5a.c.d(5, "FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
        return;
    L5:
        if (getWindowToken() == null) goto L16;
        c5a.c.e();
        FlutterRenderer r100 = this.f380508c;
        if (r100 == null) goto L15;
        r100.b(false);
        SurfaceTexture r101 = this.f380510e;
        if (r101 == null) goto L11;
        r101.release();
        this.f380510e = null;
    L11:
        Surface r102 = this.f380509d;
        if (r102 == null) goto L19;
        r102.release();
        this.f380509d = null;
    L19:
        this.f380508c = null;
        this.f380507b = false;
        return;
    L15:
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    L16:
        this.f380508c.b(false);
        Surface r103 = this.f380509d;
        if (r103 == null) goto L19;
        r103.release();
        this.f380509d = null;
        goto L19
    }

    @Override // s5a.c
    public final void pause() {
        if (this.f380508c == null) goto L5;
        this.f380508c = null;
        this.f380507b = false;
        return;
    L5:
        c5a.c.d(5, "FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f380510e == null) goto L14;
        Surface r100 = this.f380509d;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isValid() == true) goto L9;
        return;
    L9:
        if (this.f380506a == false) goto L11;
        return;
    L11:
        if (this.f380510e == getSurfaceTexture()) goto L18;
        setSurfaceTexture(this.f380510e);
        this.f380506a = true;
        return;
    L18:
        return;
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.f380508c;
    }

    public FlutterTextureView(Context r100) {
        this(r100, null);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r100) {
        c5a.c.e();
        if (this.f380508c == null) goto L5;
        c5a.c.e();
        this.f380508c.b(false);
    L5:
        this.f380508c = r100;
        this.f380507b = true;
        if (this.f380506a == false) goto L14;
        c5a.c.e();
        if (this.f380508c == null) goto L13;
        if (getSurfaceTexture() == null) goto L13;
        this.f380508c.a(this.f380509d, false);
        return;
    L13:
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
    }

    public FlutterTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f380506a = false;
        this.f380507b = false;
        this.f380511f = true;
        setSurfaceTextureListener(new a(this));
        setOpaque(false);
    }
}
