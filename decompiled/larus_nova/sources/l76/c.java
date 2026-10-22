package l76;

import com.bytedance.ies.xelement.common.LoopMode;
import com.bytedance.ies.xelement.common.LynxPlaybackState;
import com.bytedance.ies.xelement.common.PlayerType;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.LoadingState;

/* JADX INFO: loaded from: classes19.dex */
public interface c {

    public interface a {
        void H(LynxPlaybackState r100);

        void K(int r100);

        void e(LoadingState r100);

        void h();

        void n(String r100);

        void onError(int r100, String r101);

        void x(int r100);
    }

    void a(int r100);

    void attach();

    long b();

    LynxPlaybackState c();

    long d();

    void detach();

    void e(boolean r100);

    void f(boolean r100);

    void g(String r100);

    int getCurrentPlaybackTime();

    int getDuration();

    void h(String r100);

    String i();

    void j(boolean r100);

    void k(LoopMode r100);

    void l(PlayerType r100);

    void pause();

    void play();

    void setSrc(String r100);

    void stop();
}
