package x4a;

import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.property.AnimaXKeyPath;
import com.lynx.animax.property.LayerPropertyType;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;
import com.lynx.animax.util.AnimaXMetricsCallback;
import com.lynx.lottieadapter.LottieAdapterAnimaX;

/* JADX INFO: loaded from: classes32.dex */
public interface d {
    void a(int r100);

    void b(int[] r100, boolean r101);

    void c(LottieAdapterAnimaX.w r100);

    void cancel();

    void d(ObjectPosition r100);

    void e(boolean r100);

    void f(AnimaXMetricsCallback r100);

    void g(AnimaXKeyPath r100, LottieAdapterAnimaX.a r101);

    AnimaXComposition getComposition();

    double getCurrentFrame();

    double getDurationMs();

    void h(float r100, float r101);

    void i(LayerPropertyType r100, AnimaXKeyPath r101, LottieAdapterAnimaX.b.a r102, LottieAdapterAnimaX.b.C4559b r103);

    boolean isAnimating();

    void j(long r100);

    void k(boolean r100);

    void l(boolean r100);

    void pause();

    void play();

    void resume();

    void setAutoPlay(boolean r100);

    void setAutoReverse(boolean r100);

    void setComposition(AnimaXComposition r100);

    void setEnableAudio(boolean r100);

    void setEndFrame(int r100);

    void setImageFolder(String r100);

    void setJson(String r100);

    void setLoop(boolean r100);

    void setLoopCount(int r100);

    void setMaxFrameRate(double r100);

    void setMuted(boolean r100);

    void setObjectFit(ObjectFit r100);

    void setProgress(float r100);

    void setSpeed(float r100);

    void setSrc(String r100);

    void setStartFrame(int r100);
}
