package ri6;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioAlignmentMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRoute;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSampleRate;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.live.livelink.kmp.api.core.audio.AudioMode;
import java.util.Map;
import zf2.d;
import zf2.e;
import zf2.k0;

/* JADX INFO: loaded from: classes19.dex */
public interface b {
    boolean A(String r100, String r101);

    void B(String r100, LiveWrappedStreamIndex r101);

    boolean C();

    void D(String r100, LiveWrappedStreamIndex r101, String r102, int r103);

    void E(String r100, int r101);

    void a(boolean r100);

    LiveWrappedAudioRoute b();

    void c(boolean r100);

    void d(int r100);

    void e(int r100);

    void f(int r100);

    String g();

    void h(int r100);

    void i(LiveWrappedAudioFrameCallbackMethod r100, LiveWrappedAudioSampleRate r101, LiveWrappedAudioChannel r102, c r103);

    void j(k0 r100, LiveWrappedAudioAlignmentMode r101);

    void k(LiveWrappedStreamIndex r100, e r101);

    void l(String r100, LiveWrappedStreamIndex r101, String r102, boolean r103, String r104);

    void m(boolean r100);

    int n(String r100, String r101);

    void o(boolean r100, String r101);

    void p(String r100, boolean r101, String r102);

    void pause();

    void q();

    void r(String r100, LiveWrappedStreamIndex r101, d r102);

    void release();

    void resume();

    void s(String r100, boolean r101);

    void s1();

    void stop();

    void t(AudioMode r100);

    void t1();

    void u(String r100, String r101);

    void v();

    void w(String r100);

    void x();

    void y(boolean r100);

    void z(String r100, LiveWrappedStreamIndex r101, Map<String, Integer> r102);
}
