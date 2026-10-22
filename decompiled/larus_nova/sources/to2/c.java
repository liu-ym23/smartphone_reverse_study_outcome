package to2;

import com.bytedance.android.livesdkapi.model.PlayerFeatureConfig;
import com.bytedance.android.livesdkapi.player.PlayerTaskManager;
import com.bytedance.android.livesdkapi.player.preload.ILivePlayerPreloadService;
import com.bytedance.android.livesdkapi.player.preload.model.PlayerPreloadRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements ILivePlayerPreloadService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f546905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PlayerFeatureConfig f546906b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f546907c = null;

    public c() {
    }

    static {
        f546907c = new c();
        f546906b = (PlayerFeatureConfig) is0.c.c().getConfig(PlayerFeatureConfig.class);
    }

    @Override // com.bytedance.android.livesdkapi.player.preload.ILivePlayerPreloadService
    public final void enqueueConnect(PlayerPreloadRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (f546905a == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "request");
        com.bytedance.android.live.player.utils.b.c("LivePlayerPreConnectManager", "enqueueConnect, request: " + r100);
        if (r100.getParallelWithOtherRequests() == false) goto L7;
        PlayerTaskManager.inst().commit(new a.CallableC7749a(r100));
        return;
    L7:
        PlayerTaskManager.inst().doInSingleThread(new b(r100), r100.getDelayedTime());
        return;
    }
}
