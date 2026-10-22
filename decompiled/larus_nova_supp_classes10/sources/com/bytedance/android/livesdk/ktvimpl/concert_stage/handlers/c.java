package com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers;

import com.bytedance.android.live.liveinteract.jsbridge.method.h;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements ce2.a {
    public c() {
    }

    @Override // ce2.a
    public final void release() {
    }

    @Override // ce2.a
    public final JsonObject b(hd2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "getStatus");
        return new JsonObject();
    }

    @Override // ce2.a
    public final void a(hd2.c r3, h.b r4) {
        Intrinsics.checkNotNullParameter(r3, "updateStatus");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.a(IConcertUpdateStatusCallback.Code.Failed, "bizId is not support", null);
    }
}
