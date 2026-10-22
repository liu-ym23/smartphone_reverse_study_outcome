package com.bytedance.android.livesdk.ktvimpl.base;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m {
    public static final void a(float r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        JSONObject r1 = new JSONObject();
        r1.put("event_key", "setMicVolume").put("reason", r5).put("msg", "volume=" + r4);
        IInteractService r6 = jc1.k.f(IInteractService.class);
        if (r6 == null) goto L6;
        r6.onLiveCoreAVLinkLogMonitor(LiveTracingMonitor.EventType.SDK_INTERFACE_CALL.getName(), "setMicVolume", r1);
        return;
    }
}
