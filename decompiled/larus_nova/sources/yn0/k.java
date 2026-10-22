package yn0;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements l81.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f568507a = null;

    public k() {
    }

    static {
        f568507a = new k();
    }

    @Override // l81.k
    public final ILivePlayerClient getCurrentClient() {
        return LivePlatformPlayerManager.f();
    }
}
