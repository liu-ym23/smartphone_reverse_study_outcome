package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.bdlocation.exception.BDLocationException;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusBusinessWidget a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ Ref.ObjectRef c;

    public v(RealTimeChorusBusinessWidget r1, Ref.LongRef r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        xe2.b r8 = xe2.b.b;
        String r0 = String.valueOf(this.b.element);
        String r1 = RealTimeChorusBusinessWidget.wq(this.a).m469getLeadSingerUid().toString();
        String r2 = (String) this.c.element;
        boolean r3 = this.a.isEngineOn();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "chorusId");
        Intrinsics.checkNotNullParameter(r1, "leaderSingerId");
        Intrinsics.checkNotNullParameter(r2, "leaderSingerInteractId");
        JSONObject r9 = new JSONObject();
        r9.put("chorus_id", r0);
        r9.put("lead_singer_uid", r1);
        r9.put("lead_singer_interactId", r2);
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        r9.put("is_engine_on", r4);
        xe2.b.s(LinkMonitorData.BgmSyncInfoReceiverException, r9);
        return;
    L5:
        r4 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }
}
