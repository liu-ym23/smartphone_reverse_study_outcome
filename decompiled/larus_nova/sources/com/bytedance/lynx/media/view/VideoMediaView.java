package com.bytedance.lynx.media.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import f07.b;
import f07.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
public class VideoMediaView extends BaseMediaView implements c.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextureVideoView f264855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<ViewGroup> f264856i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference<b> f264857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<Runnable> f264858k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f264859l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f264860m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Runnable f264861n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f264862o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f264863p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f264864q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoMediaView f264865a;

        @Override // java.lang.Runnable
        public final void run() {
            Surface r100 = this.f264865a.getSurface();     // Catch: Throwable -> L6
            c r101 = this.f264865a.f264837b;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.f(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(VideoMediaView r100) {
            this.f264865a = r100;
        }
    }

    @Override // f07.c.e
    public final void c() {
        this.f264862o = false;
        UIUtils.setViewVisibility(this.f264855h, 0);
    }

    @Override // f07.c.e
    public final void onVideoPlay() {
        setKeepScreenOn(true);
    }

    private float getAdjustAlpha() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 26) goto L5;
        return 1.0f;
    L5:
        String r101 = Build.MODEL;
        if (r101.equals("TAH-AN00") == false) goto L8;
    L33:
        boolean r102 = true;
    L35:
        if (r100 != 29) goto L38;
        if (r102 == false) goto L40;
        return 1.0f;
    L40:
        return 0.99f;
    L38:
        return 0.99f;
    L8:
        if (r101.equals("TAH-N29") == true) goto L33;
        if (r101.equals("RLI-AN00") == true) goto L33;
        if (r101.equals("RLI-N29") == true) goto L33;
        if (r101.equals("TAH-AN00m") == true) goto L33;
        if (r101.equals("RHA-AN00m") == true) goto L33;
        if (r101.equals("MRX-AL09") == true) goto L33;
        if (r101.equals("MRX-AL19") == true) goto L33;
        if (r101.equals("MRX-AN19") == true) goto L33;
        if (r101.equals("MRX-W09") == true) goto L33;
        if (r101.equals("IN2010") == true) goto L33;
        if (r101.equals("SM-G9650") == true) goto L33;
        if (r101.equals("MRX-W19") == true) goto L33;
        r102 = false;
        goto L35
    }

    @Override // f07.c.e
    public final void a() {
        i07.a r100 = this.f264840e;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public ViewGroup getParentLayout() {
        return this.f264856i.get();
    }

    public Surface getSurface() {
        TextureVideoView r100 = this.f264855h;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurface();
    }

    public final void j() {
        if (d() == true) goto L6;
        return;
    L6:
        if (this.f264842g.booleanValue() == true) goto L11;
        if (this.f264837b.f474996m == true) goto L11;
        return;
    L11:
        if (this.f264837b.c() == true) goto L13;
    L15:
        this.f264837b.d();
        c r100 = this.f264837b;
        if (r100 != null) goto L18;
    L20:
        boolean r101 = false;
    L21:
        if (r101 == true) goto L23;
        i(new a(this));
    L23:
        LLog.i("VideoMediaView", "Did trigger VideoController play in VideoMediaView");
        this.f264860m = true;
        return;
    L18:
        if (r100.g() == false) goto L20;
        r101 = true;
        goto L21
    L13:
        if (this.f264837b.f475000q == true) goto L15;
    }

    public VideoMediaView(Context r100) {
        this(r100, null);
    }

    private void setVideoMetaInternal(ReadableMap r100) {
        int r101 = k(r100, "vwidth", "vwidth");
        int r102 = k(r100, "vheight", "vheight");
        if (r101 <= 0) goto L18;
        if (r102 <= 0) goto L18;
        if (r101 == this.f264863p) goto L8;
    L10:
        this.f264863p = r101;
        this.f264864q = r102;
        TextureVideoView r103 = this.f264855h;
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.f264847e == r101) goto L15;
    L16:
        r103.f264847e = r101;
        r103.f264848f = r102;
        r103.f264852j = 0;
        r103.f264853k = 0;
        r103.requestLayout();
    L17:
        LLog.i("VideoMediaView", "setVideoMeta: Success. Set video size to " + this.f264863p + "x" + this.f264864q);
        return;
    L15:
        if (r103.f264848f == r102) goto L17;
    L8:
        if (r102 != this.f264864q) goto L10;
        return;
    L18:
        LLog.w("VideoMediaView", "setVideoMeta: Invalid video dimensions. Width: " + r101 + ", Height: " + r102);
    }

    @Override // f07.c.e
    public final void b(Runnable r100) {
        i(r100);
    }

    public final void h(Boolean r100) {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.f264837b.f474999p == true) goto L19;
        WeakReference<b> r101 = this.f264857j;
        if (r101 == null) goto L16;
        b r102 = r101.get();
        if (r102 == null) goto L17;
        this.f264837b.f474999p = true;
        r102.n(this, r100);
        i07.a r103 = this.f264840e;
        if (r103 == null) goto L18;
        r103.b(true);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void i(Runnable r100) {
        Surface r101 = getSurface();
        if (r101 == null) goto L10;
        if (r101.isValid() == false) goto L10;
        c r102 = this.f264837b;
        if (r102 == null) goto L10;
        r102.f(r101);
        r100.run();
        return;
    L10:
        if (this.f264858k != null) goto L12;
        this.f264858k = new ArrayList();
    L12:
        this.f264858k.add(r100);
    }

    public void setParentLayout(ViewGroup r100) {
        this.f264856i = new WeakReference(r100);
    }

    public void setTextureLayout(int r100) {
        TextureVideoView r101 = this.f264855h;
        if (r101 == null) goto L6;
        r101.setVideoViewLayout(r100);
        return;
    }

    public void setTransformer(b r100) {
        this.f264857j = new WeakReference(r100);
    }

    public void setVideoMeta(ReadableMap r100) {
        if (r100 != null) goto L5;
        LLog.w("VideoMediaView", "setVideoMeta: videoMeta is null");
        return;
    L5:
        setVideoMetaInternal(r100);
    }

    public VideoMediaView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f264855h = null;
        this.f264856i = null;
        this.f264857j = null;
        this.f264858k = new ArrayList();
        this.f264859l = false;
        this.f264860m = false;
        this.f264863p = 0;
        this.f264864q = 0;
        setClipChildren(false);
        LynxContext r102 = com.lynx.tasm.utils.a.a(r100);
        if (r102 == null) goto L5;
        this.f264861n = (Runnable) r102.getSharedData("lynx_clay_request_platform_view_frame", Runnable.class);
    L5:
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, -1);
        TextureVideoView r104 = new TextureVideoView(r100);
        this.f264855h = r104;
        r104.setAlpha(getAdjustAlpha());
        setBackgroundColor(-16777216);
        r103.gravity = 17;
        addView(this.f264855h, r103);
        UIUtils.setViewVisibility(this.f264855h, 8);
        this.f264855h.setSurfaceTextureListener(new m07.c(this));
    }

    @Override // com.bytedance.lynx.media.view.BaseMediaView
    public final void g(g07.b r100, f07.a r101) {
        super.g(r100, r101);
        c r102 = this.f264837b;
        if (r102 == null) goto L6;
        r102.f474993j = this;
        return;
    }

    @Override // f07.c.e
    public final void onVideoSizeChanged(int r100, int r101) {
        TextureVideoView r102 = this.f264855h;
        if (r102.f264847e == r100) goto L5;
    L6:
        r102.f264847e = r100;
        r102.f264848f = r101;
        r102.f264852j = 0;
        r102.f264853k = 0;
        r102.requestLayout();
        return;
    L5:
        if (r102.f264848f != r101) goto L6;
    }

    public static int k(ReadableMap r100, String r101, String r102) {
        if (r100.hasKey(r101) == true) goto L15;
        LLog.w("VideoMediaView", "setVideoMeta: Missing '" + r102 + "' key");
        return 0;
    L15:
        return r100.getInt(r101);
    L10:
        e = move-exception;
        LLog.e("VideoMediaView", "setVideoMeta: Failed to retrieve '" + r102 + "'. Error: " + e.getMessage() + ", Type: " + e.getClass().getSimpleName());
        return 0;
    }
}
