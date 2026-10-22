package zk1;

import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayCacheAdapter;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.customui.SwipeMenuLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements SwipeMenuLayout.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayCacheAdapter f572577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yk1.a f572578b;

    public f(ReplayCacheAdapter r100, yk1.a r101) {
        this.f572577a = r100;
        this.f572578b = r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.cache.ui.customui.SwipeMenuLayout.e
    public final void onShow() {
        ReplayCacheAdapter.y2(this.f572577a, "vs_download_episode_delete_show", this.f572578b);
    }
}
