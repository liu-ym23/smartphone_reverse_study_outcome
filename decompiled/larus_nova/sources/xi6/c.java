package xi6;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.live.livelink.kmp.api.core.video.VideoPipelineType;
import java.util.List;
import qi6.f;
import zf2.l0;

/* JADX INFO: loaded from: classes19.dex */
public interface c {
    int a(boolean r100);

    f b(VideoPipelineType r100);

    boolean c(VideoPipelineType r100, String r101);

    com.bytedance.live.livelink.kmp.impl.core.video.c d();

    void e();

    com.bytedance.live.livelink.kmp.impl.core.video.b f();

    boolean g(VideoPipelineType r100, f r101, List<String> r102, List<String> r103);

    void h(boolean r100);

    void i(String r100, String r101, LiveWrappedStreamIndex r102, l0 r103);

    void release();

    void stop(boolean r100);
}
