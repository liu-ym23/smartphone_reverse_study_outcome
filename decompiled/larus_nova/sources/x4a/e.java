package x4a;

import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.lottieadapter.LottieAdapterAnimaX;

/* JADX INFO: loaded from: classes32.dex */
public interface e {
    void a(int r100);

    void b(int[] r100, boolean r101);

    void c(LottieAdapterAnimaX.w r100);

    void cancel();

    double getCurrentFrame();

    double getDurationMs();

    d getPlayer();

    boolean isAnimating();

    void pause();

    void play();

    void resume();

    void setAutoPlay(boolean r100);

    void setAutoReverse(boolean r100);

    void setComposition(AnimaXComposition r100);

    void setEndFrame(int r100);

    void setImageFolder(String r100);

    void setJson(String r100);

    void setLoop(boolean r100);

    void setLoopCount(int r100);

    void setMaxFrameRate(double r100);

    void setObjectFit(ObjectFit r100);

    void setProgress(float r100);

    void setSpeed(float r100);

    void setSrc(String r100);

    void setStartFrame(int r100);
}
