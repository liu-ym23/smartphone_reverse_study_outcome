package m5a;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.lynx.clay.embedding.engine.plugins.externalview.ExternalViewPlugin;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f512162a;

    public c(d r100) {
        this.f512162a = r100;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        d r101 = this.f512162a;
        r101.f512163a = null;
        ExternalViewPlugin r102 = r101.f512166d;
        if (r102 == null) goto L7;
        ExternalViewPlugin.nativeOnSurfaceTextureDestroyed(r102.f380827c, r100);
        return false;
    L7:
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        Runnable r101 = this.f512162a.f512165c;
        if (r101 == null) goto L6;
        r101.run();
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(final SurfaceTexture r100, final int r110, final int r111) {
        final d r101 = this.f512162a;
        r101.f512163a = r100;
        final ExternalViewPlugin r102 = r101.f512166d;
        if (r102 == null) goto L7;
        r101.postOnAnimation(new a(r101, r100, r102, r110, r111));
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(final SurfaceTexture r100, final int r110, final int r111) {
        final d r101 = this.f512162a;
        r101.f512163a = r100;
        final ExternalViewPlugin r102 = r101.f512166d;
        if (r102 == null) goto L7;
        r101.postOnAnimation(new b(r101, r100, r102, r110, r111));
        return;
    }
}
