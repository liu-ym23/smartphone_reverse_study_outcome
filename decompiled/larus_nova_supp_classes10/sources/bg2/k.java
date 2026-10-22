package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamSyncStrategy;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k {
    public LiveWrappedMixedStreamSyncStrategy a;
    public int b;
    public boolean c;
    public String d;
    public String e;
    public int f;

    public k() {
        this.a = LiveWrappedMixedStreamSyncStrategy.MIXED_STREAM_SYNC_STRATEGY_NO_SYNC;
        this.b = 2000;
        this.c = true;
        this.d = "";
        this.e = "";
        LiveWrappedMixedStreamVideoType r0 = LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_MAIN;
    }
}
