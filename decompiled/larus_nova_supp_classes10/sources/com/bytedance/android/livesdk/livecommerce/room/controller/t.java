package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomController;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.room.state.UserState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements ISaasLiveRoomController {
    public final com.bytedance.android.livesdk.livecommerce.room.api.i a;
    public final com.bytedance.android.livesdk.livecommerce.room.api.b b;

    public final String businessType() {
        return "ECLiveRoomControllerAdapter";
    }

    public final void onActivityCreated() {
        this.b.onActivityCreated();
    }

    public final void onCreate() {
        this.b.onCreate();
    }

    public final void onDestroy() {
        this.b.onDestroy();
    }

    public final void onDestroyView() {
        this.b.onDestroyView();
    }

    public final void onEnterRoomPrepared() {
        this.b.onEnterRoomPrepared();
    }

    public final void onExitRoom() {
        this.b.onExitRoom();
    }

    public final void onFirstFrame() {
        this.b.onFirstFrame();
    }

    public final void onP0WidgetLoadFinished() {
        this.b.onP0WidgetLoadFinished();
    }

    public final void onRoomVisible() {
        this.b.onRoomVisible();
    }

    public final void onStart() {
        this.b.onStart();
    }

    public final void onStop() {
        this.b.onStop();
    }

    public final void onWidgetLoadFinished() {
        this.b.onWidgetLoadFinished();
    }

    public final void onContextAttached(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.b.onContextAttached(r5);
        com.bytedance.android.livesdk.livecommerce.room.api.i r1 = this.a;
        if (r1.c == LiveRoomProvider.ECProviderSource.PREVIEW) goto L6;
        Application.ActivityLifecycleCallbacks r2 = ControllerCenter.a;
        String r3 = r1.a;
        String r4 = r1.b;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(this, "controller");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "uniqueKey");
        ControllerCenter.d(r5, new WeakReference(this), r3, r4);
        return;
    }

    public final void onFunctionHandlerAttached(IBaseLiveRoomFunctionHandler r3) {
        Intrinsics.checkNotNullParameter(r3, "functionHandler");
        this.b.i(new ak2.h(r3));
    }

    public final void onMessageHandlerAttached(ILiveRoomMessageHandler r3) {
        Intrinsics.checkNotNullParameter(r3, "messageHandler");
        this.b.g(new ak2.i(r3));
    }

    public final void onRoomEventHubAttached(IRoomEventHub r3) {
        Intrinsics.checkNotNullParameter(r3, "eventHub");
        this.b.e(new ak2.o(r3));
    }

    public final void onRoomStatusChanged(IRoomState r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        com.bytedance.android.ec.adapter.api.state.a r3 = ControllerExtensionsKt.d(r2, this.a);
        if (r3 == null) goto L6;
        this.b.a(r3);
        return;
    }

    public final void onSpecificViewAttached(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewClassName");
        this.b.onSpecificViewAttached(r2);
    }

    public final void onSpecificWidgetLoadFinished(String r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetClassName");
        this.b.onSpecificWidgetLoadFinished(r2);
    }

    public final void onUserStatusChanged(UserState r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        ISaasLiveRoomController.DefaultImpls.onUserStatusChanged(this, r2);
    }

    public final void onVideoEventHubAttached(IVideoEventHub r3) {
        Intrinsics.checkNotNullParameter(r3, "eventHub");
        this.b.j(new ak2.p(r3));
    }

    public final void onViewHandlerAttached(ILiveRoomViewHandler r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.b.d(new ak2.j(r3));
    }

    public t(com.bytedance.android.livesdk.livecommerce.room.api.i r2, com.bytedance.android.livesdk.livecommerce.room.api.b r3) {
        Intrinsics.checkNotNullParameter(r2, "roomApiInfo");
        Intrinsics.checkNotNullParameter(r3, "controller");
        this.a = r2;
        this.b = r3;
    }

    public final void onLiveFinished(Context r2, IRoomState r3) {
        com.bytedance.android.ec.adapter.api.state.a r4 = ControllerExtensionsKt.d(r3, this.a);
        this.b.c(r2, r4);
    }

    public final void onSpecificBehaviorLoad(String r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "behaviorClassName");
        this.b.onSpecificBehaviorLoad(r3, r4, r5, "");
    }

    public final void onSpecificBehaviorUnload(String r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "behaviorClassName");
        this.b.onSpecificBehaviorUnload(r2, r3, r4);
    }

    public final void onSpecificBehaviorLoad(String r2, boolean r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r5, "extraData");
        this.b.onSpecificBehaviorLoad(r2, r3, r4, r5);
    }
}
