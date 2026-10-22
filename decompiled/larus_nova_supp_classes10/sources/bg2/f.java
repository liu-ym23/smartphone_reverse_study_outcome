package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamMediaType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamSEIContentMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public boolean a;
    public float b;
    public int c;
    public boolean d;
    public LiveWrappedMixedStreamSEIContentMode e;
    public int f;
    public String g;
    public final LiveWrappedMixedStreamMediaType h;
    public LiveWrappedMixedStreamPushMode i;

    public f() {
        this.b = 2.0f;
        this.e = LiveWrappedMixedStreamSEIContentMode.MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT;
        this.f = 100;
        this.g = "";
        this.h = LiveWrappedMixedStreamMediaType.MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO;
        this.i = LiveWrappedMixedStreamPushMode.ON_STREAM;
    }
}
