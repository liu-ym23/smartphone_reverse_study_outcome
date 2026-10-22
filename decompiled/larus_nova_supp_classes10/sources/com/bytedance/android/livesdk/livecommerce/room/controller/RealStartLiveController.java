package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.livecommerce.event.w0;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.StartLivePromotionButton;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RealStartLiveController implements com.bytedance.android.livesdk.livecommerce.room.api.g {
    public StartLivePromotionButton a;
    public boolean b;
    public com.bytedance.android.livesdk.livecommerce.room.api.e c;
    public Context d;
    public com.bytedance.android.ec.adapter.api.state.c e;

    public RealStartLiveController() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onCreate() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onDestroyView() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onStop() {
    }

    public final void c() {
        StartLivePromotionButton r0 = this.a;
        if (r0 == null) goto L52;
        com.bytedance.android.ec.adapter.api.state.c r1 = this.e;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        com.bytedance.android.ec.adapter.api.state.c r4 = this.e;
        if (r4 == null) goto L17;
        Bundle r5 = r4.d;
        if (r5 == null) goto L17;
        int r6 = com.bytedance.android.ec.adapter.api.state.c.e;
        if (r5.getBoolean("EXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE") != true) goto L17;
        boolean r7 = true;
    L18:
        com.bytedance.android.ec.adapter.api.state.c r8 = this.e;
        if (r8 == null) goto L25;
        Bundle r9 = r8.d;
        if (r9 == null) goto L25;
        int r10 = com.bytedance.android.ec.adapter.api.state.c.e;
        if (r9.getBoolean("EXTRA_BOOL_HAS_LAST_ROOM") != true) goto L25;
        boolean r11 = true;
    L27:
        if (hh2.f.f() == true) goto L29;
        if (r7 == true) goto L35;
        if (r11 == true) goto L35;
    L34:
        boolean r12 = false;
    L37:
        if (r2 == false) goto L46;
        if (r12 == false) goto L46;
        if (this.b == true) goto L53;
        com.bytedance.android.livesdk.livecommerce.room.api.e r3 = this.c;
        if (r3 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L44:
        r3.O(r0);
        this.b = true;
        w0 r13 = new w0();
        r13.f("biz_name", "开播前购物车图标");
        r13.k();
        return;
    L53:
        return;
    L46:
        if (this.b == false) goto L55;
        com.bytedance.android.livesdk.livecommerce.room.api.e r14 = this.c;
        if (r14 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L50:
        r14.K(r0);
        this.b = false;
        return;
    L55:
        return;
    L35:
        r12 = true;
        goto L37
    L29:
        if (com.bytedance.android.livesdk.livecommerce.room.f.c(Boolean.TRUE) == true) goto L34;
    L25:
        r11 = false;
    L17:
        r7 = false;
        goto L18
    L7:
        if (((Boolean) r1.b.invoke()).booleanValue() != true) goto L9;
        r2 = true;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onViewCreated() {
        Context r1 = this.d;
        Intrinsics.checkNotNull(r1);
        com.bytedance.android.livesdk.livecommerce.room.api.e r2 = this.c;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L5:
        StartLivePromotionButton r0 = new StartLivePromotionButton(r1, r2, new AnonymousClass1(this));
        this.a = r0;
        this.b = false;
        com.bytedance.android.livesdk.livecommerce.room.api.e r3 = this.c;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L8:
        r3.L(r0, xd.h.a);
        if (this.e == null) goto L12;
        c();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onDestroy() {
        if (EComABUtils.isLiveStartMemoryLeakSwitch() == false) goto L5;
        this.d = null;
    L5:
        Lazy r0 = LiveRoomProvider.a;
        LiveRoomProvider.f = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void a(com.bytedance.android.ec.adapter.api.state.c r2) {
        Intrinsics.checkNotNullParameter(r2, "userState");
        this.e = r2;
        c();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void b(ak2.j r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.c = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.g
    public final void onContextAttached(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = r2;
    }
}
