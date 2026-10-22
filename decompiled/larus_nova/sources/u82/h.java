package u82;

import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaAnchorLinkUserListFragment;
import com.bytedance.android.livesdk.interactivity.medialink.network.LinkCrossRoomApi;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends t82.d {
    public h(MediaAnchorLinkUserListFragment r100) {
        super(r100);
    }

    @Override // t82.d
    public final void c(int r100) {
        ((ObservableSubscribeProxy) ((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).rivalsList(r100, false).as(this.f545019c.S90())).subscribe(new f(this), new g(this));
    }
}
