package or2;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements e {
    public l() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // or2.e
    public final j getCurrentClient() {
        ILivePlayerClient r100 = LivePlatformPlayerManager.f();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new j(r100);
    }
}
