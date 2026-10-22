package fq1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l f478407a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final ILiveRoomController a(long r100, int r101) {
        return this.f478407a.a(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final void c() {
        this.f478407a.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final void d(String r100) {
        this.f478407a.d(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final IRoom f() {
        return this.f478407a.f();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final Bundle g(Bundle r100) {
        return this.f478407a.g(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final boolean h(DataCenter r100, Bundle r101) {
        return this.f478407a.h(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final boolean isMicRoom(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        return this.f478407a.isMicRoom(r100);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public o(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l r100) {
        Intrinsics.checkNotNullParameter(r100, "replayRoomService");
        this.f478407a = r100;
    }
}
