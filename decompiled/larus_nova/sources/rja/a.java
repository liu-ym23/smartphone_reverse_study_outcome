package rja;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView;

/* JADX INFO: loaded from: classes33.dex */
public interface a extends GLTextureView.m, GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: rja.a$a, reason: collision with other inner class name */
    public interface InterfaceC7494a {
        void a(Surface r100);
    }

    void f(InterfaceC7494a r100);

    void h(float r100, float r101, float r102, float r103);

    void m(ScaleType r100);

    void onCompletion();

    void onFirstFrame();
}
