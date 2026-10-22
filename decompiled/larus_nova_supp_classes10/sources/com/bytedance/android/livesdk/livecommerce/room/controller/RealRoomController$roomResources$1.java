package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RealRoomController$roomResources$1 implements a0 {
    public final Lazy<MutableLiveData<Boolean>> a;
    public final /* synthetic */ RealRoomController b;

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final String a() {
        return this.b.I;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final Context context() {
        return this.b.getContext();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final MutableLiveData<Boolean> d() {
        RealRoomController r0 = this.b;
        com.bytedance.android.livesdk.livecommerce.room.api.f r1 = r0.e;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        return r1.getPlaying();
    L5:
        com.bytedance.android.livesdk.livecommerce.room.api.h r2 = r0.f;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNull(r2);
        return r2.getPlaying();
    L9:
        return (MutableLiveData) this.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final com.bytedance.android.livesdk.livecommerce.room.api.c e() {
        com.bytedance.android.livesdk.livecommerce.room.api.c r0 = this.b.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("functionHandler");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final MutableLiveData f() {
        return this.b.j;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final com.bytedance.android.livesdk.livecommerce.room.api.e g() {
        com.bytedance.android.livesdk.livecommerce.room.api.e r0 = this.b.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final LiveRoomParams h() {
        RealRoomController r0 = this.b;
        LiveRoomParams r1 = r0.i;
        if (r1 == null) goto L5;
        return r1;
    L5:
        return r0.f(null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final com.bytedance.android.ec.adapter.api.state.a i() {
        return this.b.b();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean isPreview() {
        return this.b.l();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean j() {
        if (this.b.c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final ECContext k() {
        ECContext r0 = this.b.D;
        if (r0 != null) goto L6;
        ECContext r1 = new ECContext(isPreview());
        this.b.D = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean l() {
        if (this.b.d == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean n() {
        if (this.b.b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final boolean o() {
        return this.b.g;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a0
    public final RealRoomController m() {
        return this.b;
    }

    public RealRoomController$roomResources$1(RealRoomController r1) {
        this.b = r1;
        this.a = LazyKt.lazy(RealRoomController$roomResources$1$playStatusFallback$1.INSTANCE);
    }
}
