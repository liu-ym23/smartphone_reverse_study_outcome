package da3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;

/* JADX INFO: loaded from: classes13.dex */
public interface b {
    void a();

    void b();

    void c();

    void d(ExplainPlaybackVideoInfo r100, int r101);

    void e(d r100);

    void f();

    View getView();

    int getWatchedDuration();

    ECVideoView initialize(Context r100);

    boolean isPlaying();

    void release(boolean r100);

    void seek(float r100);

    void setSpeed(float r100);
}
