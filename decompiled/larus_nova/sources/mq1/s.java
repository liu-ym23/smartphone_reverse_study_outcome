package mq1;

import com.bytedance.android.livesdk.chatroom.replay.player.viewcontrol.ReplayPlayerBackgroundWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public interface s {
    p a(DataCenter r100);

    j70.h<? extends h70.b> c(String r100);

    bl1.m d();

    ReplayPlayerBackgroundWidget f();

    aq1.b g();

    com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.i h(ToolbarButton r100);

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 i(DataCenter r100);

    u provideVSPlayerTipService(DataCenter r100);

    v provideVSPlayerViewControlService(DataCenter r100);

    void releaseService(DataCenter r100);
}
