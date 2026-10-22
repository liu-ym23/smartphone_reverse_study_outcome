package m5a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.lynx.clay.embedding.engine.plugins.externalview.ExternalViewPlugin;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SurfaceTexture f512163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f512164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f512165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExternalViewPlugin f512166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k5a.a f512167e;

    @Override // android.view.TextureView
    public SurfaceTexture getSurfaceTexture() {
        return this.f512163a;
    }

    public d(Context r100) {
        super(r100);
        setSurfaceTextureListener(new c(this));
    }

    public void setExternalViewPlugin(ExternalViewPlugin r100) {
        this.f512166d = r100;
    }

    public void setLifecycleListener(k5a.a r100) {
        this.f512167e = r100;
    }

    public void setSurfaceTextureReadyListener(Runnable r100) {
        this.f512164b = r100;
    }

    public void setSurfaceTextureUpdatedListener(Runnable r100) {
        this.f512165c = r100;
    }

    public void setVisible(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        setVisibility(r101);
        return;
    L4:
        r101 = 8;
        goto L5
    }
}
