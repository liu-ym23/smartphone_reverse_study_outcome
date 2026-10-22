package og2;

import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends BaseFeedMonitor {
    public final BaseFeedMonitor.Scene c;

    public a(BaseFeedMonitor.Scene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.c = r2;
    }

    public final void p(BaseFeedMonitor.RequestType r3) {
        Intrinsics.checkNotNullParameter(r3, "requestType");
        n(r3.getType(), this.c, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
    }

    public final void o(Throwable r3, BaseFeedMonitor.RequestType r4) {
        Intrinsics.checkNotNullParameter(r4, "requestType");
        m(r3, r4.getType(), this.c, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
    }
}
