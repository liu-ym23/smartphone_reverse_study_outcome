package com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers;

import android.content.Context;
import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ConcertBizIdType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final Map<ConcertBizIdType, ce2.a> a;

    public a(Context r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(ConcertBizIdType.LINK_SERVICE, new LinkServiceHandler(r4, r5));
        r0.put(ConcertBizIdType.TUNING, new TuningHandler(r5));
        r0.put(ConcertBizIdType.CHORUS, new ChorusHandler(r5));
        r0.put(ConcertBizIdType.UNKNOWN, new c());
        Unit r6 = Unit.INSTANCE;
        this.a = r0;
    }
}
