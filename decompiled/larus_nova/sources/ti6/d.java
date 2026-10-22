package ti6;

import bg2.q;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.TaskMixerConfig;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public interface d {
    void a(String r100, i r101);

    void b(String r100, String r101);

    c c();

    void d(String r100, String r101);

    void e(String r100);

    e f();

    void g(q r100);

    List<f> h();

    boolean i(boolean r100, boolean r101);

    void j();

    String k();

    void l(TaskMixerConfig r100);

    void m(MixStreamType r100);

    void release();

    void stop();
}
