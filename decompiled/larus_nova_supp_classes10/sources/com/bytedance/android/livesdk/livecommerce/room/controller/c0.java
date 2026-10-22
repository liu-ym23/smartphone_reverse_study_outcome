package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class c0 implements com.bytedance.android.livesdk.livecommerce.room.api.b {
    public final CoroutineScope a;
    public final a0 b;

    public void F() {
    }

    public void G() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void a(com.bytedance.android.ec.adapter.api.state.a r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void d(com.bytedance.android.livesdk.livecommerce.room.api.e r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void e(com.bytedance.android.livesdk.livecommerce.room.api.f r2) {
        Intrinsics.checkNotNullParameter(r2, "eventHub");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void g(com.bytedance.android.livesdk.livecommerce.room.api.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageHandler");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void i(com.bytedance.android.livesdk.livecommerce.room.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "functionHandler");
    }

    public void n() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onActivityCreated() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onContextAttached(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onCreate() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onDestroyView() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onEnterRoomPrepared() {
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
    public void onSpecificViewAttached(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onStart() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onStop() {
    }

    public final RealRoomController A() {
        return this.b.m();
    }

    public final com.bytedance.android.ec.adapter.api.state.a C() {
        return this.b.i();
    }

    public final String D() {
        return this.b.a();
    }

    public final com.bytedance.android.livesdk.livecommerce.room.api.e E() {
        return this.b.g();
    }

    public final LiveRoomParams l() {
        return this.b.h();
    }

    public final Context m() {
        return this.b.context();
    }

    public final ECContext o() {
        return this.b.k();
    }

    public final com.bytedance.android.livesdk.livecommerce.room.api.c q() {
        return this.b.e();
    }

    public final boolean u() {
        return this.b.n();
    }

    public final boolean v() {
        return this.b.isPreview();
    }

    public final boolean w() {
        return this.b.j();
    }

    public final String B() {
        if (w() == true) goto L7;
        return "";
    L7:
        return C().f;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onDestroy() {
        n();
        CoroutineScopeKt.cancel$default(this.a, null, 1, null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onExitRoom() {
        F();
        n();
        G();
    }

    public final Map<String, String> p() {
        return (Map) o().getEnterRoomParams().getValue();
    }

    public final ECContext r() {
        if (w() == true) goto L7;
        return null;
    L7:
        return o();
    }

    public final boolean s() {
        if (w() == true) goto L7;
        return false;
    L7:
        return C().c;
    }

    public final boolean t() {
        if (w() == true) goto L7;
        return true;
    L7:
        return com.bytedance.android.livesdk.livecommerce.room.model.h.a(C());
    }

    public final boolean x() {
        return A().z;
    }

    public final String y() {
        if (w() == true) goto L7;
        return "";
    L7:
        return C().g;
    }

    public final String z() {
        if (w() == true) goto L7;
        return "";
    L7:
        return C().h;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onWidgetLoadFinished() {
        F();
    }

    public c0(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        this.b = r2;
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void j(com.bytedance.android.livesdk.livecommerce.room.api.h r2) {
        Intrinsics.checkNotNullParameter(r2, "eventHub");
        Intrinsics.checkNotNullParameter(r2, "eventHub");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void onSpecificWidgetLoadFinished(String r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetClassName");
        Intrinsics.checkNotNullParameter(r2, "widgetClassName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.b
    public void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r2) {
        F();
        G();
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
