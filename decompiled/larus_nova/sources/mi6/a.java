package mi6;

import bg2.e;
import bg2.i;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.LiveWrappedVideoEncoderConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioAlignmentMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRenderType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRoute;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSourceType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamSycnInfoConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoDenoiseMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSourceType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushTargetType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioScenarioType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.ILiveWrappedVideoSink;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusVideoSinkManager;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import zf2.d;
import zf2.f;
import zf2.j;
import zf2.k0;
import zf2.r0;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    void A(LiveWrappedStreamIndex r100, d r101);

    void B(LiveWrappedStreamIndex r100, boolean r101);

    void C(k0 r100, LiveWrappedVideoSuperResolutionMode r101);

    void D(r0 r100);

    void E(int r100);

    void F(k0 r100, int r101);

    void G();

    void H();

    void I();

    void J();

    void K();

    void L(LiveWrappedStreamIndex r100, LiveWrappedVideoSourceType r101);

    void M(String r100, String r101);

    void N(JSONObject r100);

    void O(j r100);

    int P(eg2.a r100);

    void Q(LiveWrappedAudioRoute r100);

    void R(String r100, e r101, bg2.b r102);

    yf2.c S();

    void T(byte[] r100, LiveWrappedStreamSycnInfoConfig r101);

    void U(String r100, i r101, e r102);

    void V(LiveWrappedAudioFrameCallbackMethod r100);

    void W(LiveWrappedVideoDenoiseMode r100);

    void X(LiveWrappedAudioFrameCallbackMethod r100, f r101);

    void Y(String r100, e r101, bg2.b r102);

    void Z(String r100);

    void b();

    void d(JSONObject r100);

    void destroy();

    void e(int r100);

    void f();

    void g(String r100);

    void h(int r100);

    void i();

    void j(k0 r100, LiveWrappedAudioAlignmentMode r101);

    void k(LiveWrappedStreamIndex r100, zf2.e r101);

    void l(dg2.d r100);

    void logout();

    void m(LiveWrappedVideoEncoderConfig r100, String r101);

    void n(bg2.a r100, ChorusVideoSinkManager r101);

    void o(LiveWrappedAudioSourceType r100);

    void p(String r100, LiveWrappedMixedStreamPushTargetType r101);

    void q(com.bytedance.live.livelink.kmp.impl.base.rtc.a r100);

    void r(LiveWrappedAudioRenderType r100);

    void s(String r100, String r101);

    void t(String r100);

    int u(Function0 r100);

    void v();

    void w(String r100, i r101);

    void x(com.bytedance.live.livelink.kmp.impl.core.audio.b r100);

    void y(LiveWrappedAudioScenarioType r100);

    void z(k0 r100, ILiveWrappedVideoSink r101, fg2.b r102);
}
