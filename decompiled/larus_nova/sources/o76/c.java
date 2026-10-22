package o76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.LoadingState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.SeekState;

/* JADX INFO: loaded from: classes19.dex */
public interface c {
    void e(LoadingState r100);

    void h(ErrorCode r100);

    void i(long r100);

    void onCompletion();

    void onPrepare();

    void onPrepared();

    void onRenderStart();

    void p(PlaybackState r100);

    void q(SeekState r100);

    void s(long r100);

    void t(k r100);

    void u(float r100);
}
