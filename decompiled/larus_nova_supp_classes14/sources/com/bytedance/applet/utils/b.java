package com.bytedance.applet.utils;

import com.google.gson.JsonObject;
import com.larus.audioplayer.api.stream.StreamPlayerStatus;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements y78.a {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void a(String r4, StreamPlayerStatus r5, Integer r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "uuid");
        Intrinsics.checkNotNullParameter(r5, "newStates");
        Intrinsics.checkNotNullParameter(r7, "errorMsg");
        Intrinsics.checkNotNullParameter(r8, "pauseReason");
        FLogger.a.i("StreamListener", "【stream player state change, call first part】, newStates=" + r5);
        com.bytedance.applet.task.b.a.getClass();
        com.bytedance.applet.task.b.e(r5);
        Lazy r9 = l3.d.a;
        JsonObject r10 = new JsonObject();
        r10.addProperty("uuid", r4);
        r10.addProperty("status", r5.getValue());
        if (r6 == null) goto L5;
        int r11 = r6.intValue();
    L6:
        r10.addProperty("errorCode", Integer.valueOf(r11));
        r10.addProperty("reason", r7);
        Unit r12 = Unit.INSTANCE;
        l3.d.c(new l3.a("flow.streamAudioPlayStatusChanged", r10, 4));
        return;
    L5:
        r11 = 0;
        goto L6
    }
}
