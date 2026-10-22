package com.bytedance.locallife.live.controller;

import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.locallife.live.util.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends d {
    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onExitRoom() {
        super.onExitRoom();
        n.a(ListenLiveStatus.END_EXIT_ROOM, null);
        n.f260724a = null;
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        super(r100, r101);
        com.bytedance.locallife.live.util.m r102 = new com.bytedance.locallife.live.util.m(r100);
        com.bytedance.locallife.live.util.m r103 = n.f260724a;
        n.f260724a = r102;
    }
}
