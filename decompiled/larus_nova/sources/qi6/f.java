package qi6;

import com.bytedance.live.livelink.kmp.api.base.video.NodeType;
import com.bytedance.live.livelink.kmp.api.base.video.Status;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes19.dex */
public interface f {
    String getName();

    Status getStatus();

    NodeType getType();

    void i();

    void init();

    CopyOnWriteArraySet<f> j();

    CopyOnWriteArraySet<f> k();

    void l(Status r100);

    void m(a r100);

    void pause();

    void release();

    void resume();

    void stop();
}
