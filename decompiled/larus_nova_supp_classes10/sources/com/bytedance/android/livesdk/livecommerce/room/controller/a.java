package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class a implements com.bytedance.android.livesdk.livecommerce.room.api.b {
    public com.bytedance.android.livesdk.livecommerce.room.api.e a;
    public Context b;
    public com.bytedance.android.ec.adapter.api.state.a c;
    public com.bytedance.android.livesdk.livecommerce.room.api.c d;
    public com.bytedance.android.livesdk.livecommerce.room.api.f e;
    public com.bytedance.android.livesdk.livecommerce.room.api.h f;

    public a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void g(com.bytedance.android.livesdk.livecommerce.room.api.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageHandler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onActivityCreated() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onCreate() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onDestroy() {
        this.e = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onDestroyView() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onEnterRoomPrepared() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onExitRoom() {
        this.e = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onFirstFrame() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onP0WidgetLoadFinished() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onPause() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onResume() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onRoomVisible() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onStart() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onStop() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onWidgetLoadFinished() {
    }

    public final com.bytedance.android.ec.adapter.api.state.a b() {
        com.bytedance.android.ec.adapter.api.state.a r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentRoomState");
    L5:
        return r0;
    }

    public final Context getContext() {
        Context r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void a(com.bytedance.android.ec.adapter.api.state.a r2) {
        Intrinsics.checkNotNullParameter(r2, "stateEC");
        this.c = r2;
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void d(com.bytedance.android.livesdk.livecommerce.room.api.e r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void e(com.bytedance.android.livesdk.livecommerce.room.api.f r2) {
        Intrinsics.checkNotNullParameter(r2, "eventHub");
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void i(com.bytedance.android.livesdk.livecommerce.room.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "functionHandler");
        this.d = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void j(com.bytedance.android.livesdk.livecommerce.room.api.h r2) {
        Intrinsics.checkNotNullParameter(r2, "eventHub");
        this.f = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onContextAttached(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificViewAttached(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewClassName");
        Intrinsics.checkNotNullParameter(r2, "viewClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificWidgetLoadFinished(String r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetClassName");
        Intrinsics.checkNotNullParameter(r2, "widgetClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r2) {
        if (r2 == null) goto L5;
        this.c = r2;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificBehaviorUnload(String r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r1, "behaviorClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificBehaviorLoad(String r1, boolean r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r4, "extraData");
        Intrinsics.checkNotNullParameter(r1, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r4, "extraData");
    }
}
