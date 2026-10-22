package com.lynx.animax.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.lynx.animax.base.AnimaXError;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXLog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a implements IVideoPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VideoAsset f380343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceTexture f380344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f380345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f380346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f380347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f380348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f380350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f380351i;

    @Override // com.lynx.animax.player.IVideoPlayer
    public void destroy() {
        AnimaXLog.b("AbsVideoPlayer", "destroy: " + this);
        this.f380343a = null;
        Surface r100 = this.f380345c;
        if (r100 == null) goto L5;
        r100.release();
        this.f380345c = null;
    L5:
        SurfaceTexture r101 = this.f380344b;
        if (r101 == null) goto L9;
        r101.setOnFrameAvailableListener(null);
        this.f380344b.release();
        this.f380344b = null;
    L9:
        if (this.f380348f <= 0) goto L13;
        b("[" + getClass().getName() + "]: Error has occurred, mHasDrewOnce: " + this.f380349g + ", mHasDrewOnceAfterError: " + this.f380350h);
        return;
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public final float[] getTransformMatrix() {
        if (this.f380346d != null) goto L5;
        this.f380346d = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    L5:
        SurfaceTexture r100 = this.f380344b;
        if (r100 == null) goto L9;
        r100.getTransformMatrix(this.f380346d);
    L9:
        return this.f380346d;
    }

    public a(g r100) {
        this.f380347e = false;
        this.f380348f = 0;
        this.f380349g = false;
        this.f380350h = false;
        AnimaXLog.b("AbsVideoPlayer", "create: " + this);
        this.f380351i = r100;
    }

    public final void a(String r100) {
        AnimaXLog.a("AbsVideoPlayer", "Error(" + this.f380348f + "): " + r100);
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public void attachAsset(VideoAsset r100) {
        if (this.f380343a == null) goto L6;
        AnimaXLog.a("AbsVideoPlayer", "Attach asset more than once");
        return;
    L6:
        if (r100 != null) goto L8;
    L12:
        AnimaXLog.a("AbsVideoPlayer", "attachAsset error: asset isn't valid");
        return;
    L8:
        if (r100.f380340c == false) goto L12;
        this.f380343a = r100;
    }

    public final void b(String r100) {
        a(r100);
        IAnimaXMonitorService r101 = (IAnimaXMonitorService) this.f380351i.f380367a.a(IAnimaXMonitorService.class);
        if (r101 != null) goto L5;
        return;
    L5:
        HashMap r102 = new HashMap();
        r102.put("code", Integer.valueOf(AnimaXError.VIDEO_PLAYER_ERROR_HAS_OCCURRED.ordinal()));
        r102.put("msg", r100);
        r102.put("error_count", Integer.valueOf(this.f380348f));
        r101.reportError(new t4a.a(r102));
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public void setSurface(int r100) {
        Surface r101 = this.f380345c;
        if (r101 == null) goto L5;
        r101.release();
        this.f380345c = null;
    L5:
        SurfaceTexture r102 = this.f380344b;
        if (r102 == null) goto L8;
        r102.setOnFrameAvailableListener(null);
        this.f380344b.release();
        this.f380344b = null;
    L8:
        this.f380344b = new SurfaceTexture(r100);
        this.f380345c = new Surface(this.f380344b);
    }
}
