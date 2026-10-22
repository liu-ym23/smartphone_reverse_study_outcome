package com.bytedance.applet.event;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements k5.j {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public final void a(AppletMonitorableEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        r3.f("message_id", this.a);
        r3.f("questionId", this.b);
        r3.f("content", "onServerAction");
    }

    public f(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
