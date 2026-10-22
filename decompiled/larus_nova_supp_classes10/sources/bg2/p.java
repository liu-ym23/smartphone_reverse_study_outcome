package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoCodecType;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p {
    public LiveWrappedMixedStreamVideoCodecType a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;

    public final String toString() {
        return "LiveWrappedMixedStreamVideoConfig{videoCodec='" + this.a + "', fps=" + this.b + ", gop=" + this.c + ", bitrate=" + this.d + ", width=" + this.e + ", height=" + this.f + ", enableBframe=" + this.g + '}';
    }

    public p() {
        this.a = LiveWrappedMixedStreamVideoCodecType.MIXED_STREAM_VIDEO_CODEC_TYPE_H264;
        this.b = 15;
        this.c = 2;
        this.d = MonitorLevel.FATAL;
        this.e = 360;
        this.f = 640;
    }
}
