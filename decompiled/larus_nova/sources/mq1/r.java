package mq1;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public interface r {
    IReplayInnerProgressService a(DataCenter r100);

    com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar.b c(Context r100, ReplayDataContext r101, PlayerProgressServiceContext r102);

    void d();

    dl1.e f(vq1.b.a r100, long r101, String r102, com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r103, DataCenter r104);

    void g();

    void h(long r100, Bundle r101, vq1.a r102);

    tk1.e i();

    void releaseService(DataCenter r100);
}
