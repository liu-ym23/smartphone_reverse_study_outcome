package com.lynx.clay.embedding.engine.renderer;

import android.os.Handler;
import android.view.Surface;
import com.lynx.clay.embedding.engine.FlutterJNI;
import s5a.b;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f380933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Surface f380934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f380935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f380936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f380937e;

    public static final class ViewportMetrics {
        public int densityDpi;
        public float devicePixelRatio;
        public float fontScale;
        public int height;
        public boolean nightMode;
        public int screenHeight;
        public int screenWidth;
        public int systemGestureInsetBottom;
        public int systemGestureInsetLeft;
        public int systemGestureInsetRight;
        public int systemGestureInsetTop;
        public int viewInsetBottom;
        public int viewInsetLeft;
        public int viewInsetRight;
        public int viewInsetTop;
        public int viewPaddingBottom;
        public int viewPaddingLeft;
        public int viewPaddingRight;
        public int viewPaddingTop;
        public int width;

        public ViewportMetrics() {
            this.screenWidth = 0;
            this.screenHeight = 0;
            this.fontScale = 1.0f;
            this.nightMode = false;
            this.devicePixelRatio = 1.0f;
            this.densityDpi = 0;
            this.width = 0;
            this.height = 0;
            this.viewPaddingTop = 0;
            this.viewPaddingRight = 0;
            this.viewPaddingBottom = 0;
            this.viewPaddingLeft = 0;
            this.viewInsetTop = 0;
            this.viewInsetRight = 0;
            this.viewInsetBottom = 0;
            this.viewInsetLeft = 0;
            this.systemGestureInsetTop = 0;
            this.systemGestureInsetRight = 0;
            this.systemGestureInsetBottom = 0;
            this.systemGestureInsetLeft = 0;
        }
    }

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlutterRenderer f380938a;

        @Override // s5a.b
        public final void a() {
            this.f380938a.f380936d = false;
        }

        @Override // s5a.b
        public final void b() {
            this.f380938a.f380936d = true;
        }

        public a(FlutterRenderer r100) {
            this.f380938a = r100;
        }
    }

    public FlutterJNI getFlutterJNI() {
        return this.f380933a;
    }

    public FlutterRenderer(FlutterJNI r100) {
        this.f380935c = false;
        this.f380936d = false;
        new Handler();
        a r101 = new a(this);
        this.f380937e = r101;
        this.f380933a = r100;
        r100.addIsDisplayingFlutterUiListener(r101);
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L4;
        this.f380933a.onRenderSurfaceDestroyed();
    L5:
        this.f380934b = null;
        this.f380935c = false;
        if (this.f380936d == false) goto L8;
        this.f380937e.a();
    L8:
        this.f380936d = false;
        return;
    L4:
        this.f380933a.onSurfaceDestroyed();
        goto L5
    }

    public final void a(Surface r100, boolean r101) {
        if (this.f380934b == null) goto L5;
        b(this.f380935c);
    L5:
        this.f380934b = r100;
        this.f380935c = r101;
        if (r101 == false) goto L8;
        this.f380933a.onRenderSurfaceCreated(r100);
        return;
    L8:
        this.f380933a.onSurfaceCreated(r100);
    }
}
