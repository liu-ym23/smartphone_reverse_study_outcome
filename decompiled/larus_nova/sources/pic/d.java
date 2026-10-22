package pic;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.ss.android.videoshop.mediaview.TextureVideoView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextureVideoView f529423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tic.a f529424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qic.a f529425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f529426d;

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        Map<tic.a, TextureVideoView> r103 = this.f529426d.f529428b;
        HashMap r104 = (HashMap) r103;
        if (r104.containsValue(this.f529423a) == true) goto L5;
        return;
    L5:
        Surface r105 = this.f529423a.getSurface();
        if (r105 == null) goto L8;
        StringBuilder r106 = new StringBuilder("onSurfaceTextureAvailable prepare vid:");
        r106.append(this.f529424b.f546363a);
        r106.append(" title:null surface hash:");
        this.f529424b.getClass();
        r106.append(r105.hashCode());
        ajc.b.a("VideoPrepareManager", r106.toString());
        this.f529425c.setSurface(r105);
    L8:
        this.f529425c.prepare();
    }

    public d(e r100, TextureVideoView r101, tic.a r102, qic.b r103) {
        this.f529426d = r100;
        this.f529423a = r101;
        this.f529424b = r102;
        this.f529425c = r103;
    }
}
