package com.bytedance.locallife.live.controller;

import com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController;
import com.bytedance.locallife.live.message.LiveLocalLifeMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class d extends AbsLiveRoomController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f259375b;

    public void a(LiveLocalLifeMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final String businessType() {
        return "LiveLocalLife";
    }

    public d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        this.f259374a = r100;
        this.f259375b = r101;
    }
}
