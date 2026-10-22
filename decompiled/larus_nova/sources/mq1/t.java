package mq1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public interface t {
    p a(DataCenter r100);

    u provideVSPlayerTipService(DataCenter r100);

    v provideVSPlayerViewControlService(DataCenter r100);

    IReplayInnerProgressService provideVSProgressService(DataCenter r100);

    void releaseService(DataCenter r100);
}
