package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Function1 c;

    public f(long r1, boolean r3, Function1 r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        mb0.c.a.a(pd2.d.n, LinkMonitorData.APIUpdateKtvComponentSetting, System.currentTimeMillis() - this.a, r11);
        int r0 = mb0.f.a;
        boolean r1 = this.b;
        Intrinsics.checkNotNullParameter(r11, "throwable");
        JSONObject r7 = new JSONObject();
        r7.put("chorusEnable", r1);
        nd0.c.a.getClass();
        Pair r2 = nd0.c.t(r11, r7);
        int r3 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.KtvFeatureSwitch, "ktvChorusSetting", ((Number) r2.getFirst()).intValue(), (String) r2.getSecond(), r7, 64);
        ExceptionUtils.handleException(s1.getContext(), r11);
        this.c.invoke(r11);
    }
}
