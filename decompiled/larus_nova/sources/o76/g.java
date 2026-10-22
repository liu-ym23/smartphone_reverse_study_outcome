package o76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes19.dex */
public interface g {
    int a();

    long b();

    void c(long r100);

    void d(Resolution r100, VideoModel r101);

    boolean e();

    void f(long r100, com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.b r101);

    long getCurrentPlaybackTime();

    long getDuration();

    PlaybackState getPlaybackState();

    void pause();

    void release();

    void resume();

    void setDataSource(FileDescriptor r100, long r101, long r102);

    void setDirectURL(String r100);

    void setDirectUrlUseDataLoader(String r100, String r101);

    void setLocalURL(String r100);

    void stop();
}
