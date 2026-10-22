package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x implements com.bytedance.android.livesdk.livecommerce.room.api.b {
    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void d(com.bytedance.android.livesdk.livecommerce.room.api.e r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void g(com.bytedance.android.livesdk.livecommerce.room.api.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageHandler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onActivityCreated() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onContextAttached(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroyView() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onEnterRoomPrepared() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onFirstFrame() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onP0WidgetLoadFinished() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onPause() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onResume() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onRoomVisible() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onWidgetLoadFinished() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void a(com.bytedance.android.ec.adapter.api.state.a r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void e(com.bytedance.android.livesdk.livecommerce.room.api.f r2) {
        Intrinsics.checkNotNullParameter(r2, "eventHub");
        Intrinsics.checkNotNullParameter(r2, "eventHub");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void i(com.bytedance.android.livesdk.livecommerce.room.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "functionHandler");
        Intrinsics.checkNotNullParameter(r2, "functionHandler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void j(com.bytedance.android.livesdk.livecommerce.room.api.h r2) {
        Intrinsics.checkNotNullParameter(r2, "eventHub");
        Intrinsics.checkNotNullParameter(r2, "eventHub");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificViewAttached(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewClassName");
        Intrinsics.checkNotNullParameter(r2, "viewClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificWidgetLoadFinished(String r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetClassName");
        Intrinsics.checkNotNullParameter(r2, "widgetClassName");
    }

    public x(String r2, String r3, LiveRoomProvider.ECProviderSource r4) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "uniqueKey");
        Intrinsics.checkNotNullParameter(r4, "env");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificBehaviorUnload(String r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r1, "behaviorClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificBehaviorLoad(String r1, boolean r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r4, "extraData");
        Intrinsics.checkNotNullParameter(r1, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r4, "extraData");
    }
}
