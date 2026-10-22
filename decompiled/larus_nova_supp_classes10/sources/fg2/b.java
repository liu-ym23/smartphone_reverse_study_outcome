package fg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoPixelFormat;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedRemoteVideoSinkPosition;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedVideoApplyRotation;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedVideoSinkMirrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final LiveWrappedRemoteVideoSinkPosition a;
    public LiveWrappedVideoPixelFormat b;
    public final LiveWrappedVideoApplyRotation c;
    public final LiveWrappedVideoSinkMirrorType d;

    public b() {
        this.a = LiveWrappedRemoteVideoSinkPosition.AFTER_POST_PROCESS;
        this.b = LiveWrappedVideoPixelFormat.UNKNOWN;
        this.c = LiveWrappedVideoApplyRotation.DEFAULT;
        this.d = LiveWrappedVideoSinkMirrorType.OFF;
    }

    public final void a(LiveWrappedVideoPixelFormat r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}
