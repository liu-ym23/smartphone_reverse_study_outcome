package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IUserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements IStartLivePreviewController {
    public final com.bytedance.android.livesdk.livecommerce.room.api.g a;

    public final void onCreate() {
        this.a.onCreate();
    }

    public final void onDestroy() {
        this.a.onDestroy();
    }

    public final void onDestroyView() {
        this.a.onDestroyView();
    }

    public final void onStart() {
        this.a.onStart();
    }

    public final void onStop() {
        this.a.onStop();
    }

    public final void onViewCreated() {
        this.a.onViewCreated();
    }

    public v(RealStartLiveController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.a = r2;
    }

    public final void onContextAttached(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.onContextAttached(r2);
    }

    public final void onUserInfoChanged(IUserState r11) {
        Intrinsics.checkNotNullParameter(r11, "userState");
        com.bytedance.android.livesdk.livecommerce.room.api.g r0 = this.a;
        Intrinsics.checkNotNullParameter(r11, "$this$trans");
        r0.a(new com.bytedance.android.ec.adapter.api.state.c(r11.getUid(), r11.getSecUid(), "", "", r11.isLoginFunc(), r11.getReportParams(), r11.getExtra()));
    }

    public final void onViewHandlerAttached(ILiveRoomViewHandler r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.a.b(new ak2.j(r3));
    }
}
