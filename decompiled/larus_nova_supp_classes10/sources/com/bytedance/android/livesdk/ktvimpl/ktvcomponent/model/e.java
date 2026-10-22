package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function1 b;

    public e(long r1, Function1 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r11) {
        com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
        mb0.c.a.b(pd2.d.n, LinkMonitorData.APIUpdateKtvComponentSetting, System.currentTimeMillis() - this.a, ((ExtraResponse) r12).logId);
        int r0 = mb0.f.a;
        String r1 = ((ExtraResponse) r12).logId;
        Boolean r2 = ((m) ((ExtraResponse) r12).data).multiChorusEnable;
        Intrinsics.checkNotNullParameter(r1, "logId");
        JSONObject r8 = new JSONObject();
        r8.put("logId", r1);
        if (r2 == null) goto L5;
        r8.put("chorusEnable", r2.booleanValue());
    L5:
        int r3 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.KtvFeatureSwitch, "ktvChorusSetting", 0, null, r8, 88);
        this.b.invoke(r12);
    }
}
