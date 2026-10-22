package fg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoPixelFormat;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedRemoteVideoSinkPosition;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedVideoApplyRotation;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedVideoSinkMirrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveWrappedRemoteVideoSinkPosition f476824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveWrappedVideoPixelFormat f476825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveWrappedVideoApplyRotation f476826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveWrappedVideoSinkMirrorType f476827d;

    public b() {
        this.f476824a = LiveWrappedRemoteVideoSinkPosition.AFTER_POST_PROCESS;
        this.f476825b = LiveWrappedVideoPixelFormat.UNKNOWN;
        this.f476826c = LiveWrappedVideoApplyRotation.DEFAULT;
        this.f476827d = LiveWrappedVideoSinkMirrorType.OFF;
    }

    public final void a(LiveWrappedVideoPixelFormat r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f476825b = r100;
    }
}
