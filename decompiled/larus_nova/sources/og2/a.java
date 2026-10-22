package og2;

import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends BaseFeedMonitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseFeedMonitor.Scene f523184c;

    public a(BaseFeedMonitor.Scene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f523184c = r100;
    }

    public final void p(BaseFeedMonitor.RequestType r100) {
        Intrinsics.checkNotNullParameter(r100, "requestType");
        n(r100.getType(), this.f523184c, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
    }

    public final void o(Throwable r100, BaseFeedMonitor.RequestType r101) {
        Intrinsics.checkNotNullParameter(r101, "requestType");
        m(r100, r101.getType(), this.f523184c, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
    }
}
