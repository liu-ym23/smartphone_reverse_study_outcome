package m07;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.lynx.media.view.TextureVideoView;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextureVideoView f511490a;

    public b(TextureVideoView r100) {
        this.f511490a = r100;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        TextureVideoView r101 = this.f511490a;
        if (r101.f264854l == true) goto L5;
    L9:
        TextureView.SurfaceTextureListener r102 = this.f511490a.f264845c;
        if (r102 == null) goto L12;
        r102.onSurfaceTextureDestroyed(r100);
    L12:
        TextureVideoView r103 = this.f511490a;
        boolean r104 = r103.f264854l;
        if (r104 == true) goto L20;
        if (r104 == true) goto L18;
        Surface r105 = r103.f264843a;
        if (r105 == null) goto L18;
        r105.release();
        r103.f264843a = null;
    L18:
        r103.f264846d = false;
        r103.f264843a = null;
        r103.f264844b = null;
    L20:
        return !this.f511490a.f264854l;
    L5:
        if (r101.f264846d == true) goto L9;
        Surface r106 = r101.f264843a;
        if (r106 == null) goto L9;
        r106.release();
        TextureVideoView r107 = this.f511490a;
        r107.f264843a = null;
        r107.f264844b = null;
        goto L9
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        TextureView.SurfaceTextureListener r101 = this.f511490a.f264845c;
        if (r101 == null) goto L6;
        r101.onSurfaceTextureUpdated(r100);
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        LLog.i("TextureVideoView", "onSurfaceTextureAvailable width = " + r101 + " height = " + r102);
        TextureVideoView r103 = this.f511490a;
        if (r103.f264854l == false) goto L28;
        Surface r104 = r103.f264843a;
        if (r104 != null) goto L7;
    L11:
        TextureVideoView r105 = this.f511490a;
        if (r105.f264843a != null) goto L34;
        r105.f264843a = new Surface(r100);
        this.f511490a.f264844b = r100;
    L27:
        this.f511490a.f264846d = true;
    L29:
        TextureVideoView r106 = this.f511490a;
        TextureView.SurfaceTextureListener r107 = r106.f264845c;
        if (r107 == null) goto L36;
        r107.onSurfaceTextureAvailable(r106.f264844b, r101, r102);
        return;
    L36:
        return;
    L34:
        SurfaceTexture r108 = r105.f264844b;     // Catch: Exception -> L25
        if (r108 != null) goto L17;
    L23:
        TextureVideoView r109 = this.f511490a;     // Catch: Exception -> L25
        r109.f264844b = r100;     // Catch: Exception -> L25
        r109.f264843a = new Surface(r100);     // Catch: Exception -> L25
    L33:
        goto L27
    L17:
        if (TextureVideoView.a(r108) == true) goto L23;
        TextureVideoView r110 = this.f511490a;     // Catch: Exception -> L25
        if (r110.f264844b == r110.getSurfaceTexture()) goto L33;
        TextureVideoView r111 = this.f511490a;     // Catch: Exception -> L25
        r111.setSurfaceTexture(r111.f264844b);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        LLog.e("TextureVideoView", "onSurfaceTextureAvailable encounter exception " + e.getMessage());
        TextureVideoView r112 = this.f511490a;
        r112.f264844b = r100;
        r112.f264843a = new Surface(r100);
        goto L27
    L7:
        if (r103.f264846d == true) goto L9;
    L10:
        this.f511490a.f264843a.release();
        TextureVideoView r113 = this.f511490a;
        r113.f264843a = null;
        r113.f264844b = null;
        goto L11
    L9:
        if (r104.isValid() == true) goto L11;
    L28:
        r103.f264843a = new Surface(r100);
        this.f511490a.f264844b = r100;
        goto L29
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        TextureView.SurfaceTextureListener r103 = this.f511490a.f264845c;
        if (r103 == null) goto L6;
        r103.onSurfaceTextureSizeChanged(r100, r101, r102);
        return;
    }
}
