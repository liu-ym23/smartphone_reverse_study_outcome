package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements rd.c {
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

    public u(RealStartLiveController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.a = r2;
    }

    public final void a(com.bytedance.android.ec.adapter.api.state.c r2) {
        Intrinsics.checkNotNullParameter(r2, "ECUserState");
        this.a.a(r2);
    }

    public final void b(td.d r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.a.b(new ak2.j(r3));
    }

    public final void onContextAttached(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.onContextAttached(r2);
    }
}
