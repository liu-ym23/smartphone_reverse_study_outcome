package l68;

import com.bytedance.flow_audio.api.business.tts.config.FlowAudioTtsStreamType;
import com.bytedance.flow_audio.api.tracer.TtsTracer;

/* JADX INFO: loaded from: classes24.dex */
public interface a {
    void a(int r100);

    void b(b r100);

    z58.a c();

    void cancel();

    void d(FlowAudioTtsStreamType r100, String r101);

    void e(z58.a r100, TtsTracer r101);

    b getListener();

    void release();

    void start();

    void stop();
}
