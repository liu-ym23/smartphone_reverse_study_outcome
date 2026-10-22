package tja;

import android.view.ViewGroup;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import oja.b;

/* JADX INFO: loaded from: classes33.dex */
public interface a {
    boolean a();

    void b(ViewGroup r100);

    void c(float r100, float r101);

    void d(ViewGroup r100);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ScaleType getScaleType();

    void onCompletion();

    void onFirstFrame();

    void onPause();

    void release();

    void requestRender();

    void setLayoutParams(ViewGroup.LayoutParams r100);

    void setPlayerController(b r100);

    void setVideoRenderer(rja.a r100);
}
