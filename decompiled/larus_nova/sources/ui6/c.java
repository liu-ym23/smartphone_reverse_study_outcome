package ui6;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.ILiveWrappedVideoSink;
import com.bytedance.live.livelink.kmp.api.core.rtc.PublicStreamType;
import yf2.f;

/* JADX INFO: loaded from: classes19.dex */
public interface c {
    void a(String r100, PublicStreamType r101);

    void b(String r100, f r101);

    void c(String r100, ILiveWrappedVideoSink r101, fg2.b r102);

    void d(String r100, PublicStreamType r101);

    void release();
}
