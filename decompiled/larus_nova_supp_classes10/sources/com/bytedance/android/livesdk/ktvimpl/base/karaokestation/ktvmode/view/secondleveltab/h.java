package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.KtvRoomSelectedMusicViewHolder;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
    public final /* synthetic */ PlayListContainerView a;

    public h(PlayListContainerView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "transition");
        KtvRoomSelectedMusicViewHolder r0 = PlayListContainerView.h(this.a);
        if (jc0.a.c() == false) goto L10;
        PlayListContainerView r4 = this.a;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r1 = VideoChorusDataContext.Companion.a();
        if (r1 == null) goto L7;
        jd2.c r2 = r1.f();
    L8:
        r4.o(r2);
        return;
    L7:
        r2 = null;
        goto L8
    L10:
        if ((((KtvRoomLyricsStateMachineConfig.d) r3.c) instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L13;
        if (r0 == null) goto L17;
        r0.g4(true);
        return;
    L17:
        return;
    L13:
        if (r0 == null) goto L19;
        r0.g4(false);
        return;
    }
}
