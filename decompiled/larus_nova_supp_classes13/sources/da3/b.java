package da3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface b {
    void a();

    void b();

    void c();

    void d(ExplainPlaybackVideoInfo r1, int r2);

    void e(d r1);

    void f();

    View getView();

    int getWatchedDuration();

    ECVideoView initialize(Context r1);

    boolean isPlaying();

    void release(boolean r1);

    void seek(float r1);

    void setSpeed(float r1);
}
