package com.bytedance.ies.xbridge.event.bridge;

import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements b.a {
    public d() {
    }

    @Override // com.bytedance.ies.xbridge.event.bridge.b.a
    public final void a(int r110) {
        String r100 = AppEvent.KeyboardStatusChange.getEventName();
        long r101 = System.currentTimeMillis();
        Pair[] r102 = new Pair[2];
        Pair r103 = TuplesKt.to("height1", Integer.valueOf(r110));
        boolean r104 = false;
        r102[0] = r103;
        if (r110 == 0) goto L5;
        r104 = true;
    L5:
        r102[1] = TuplesKt.to("visible", Boolean.valueOf(r104));
        EventCenter.enqueueEvent(new Event(r100, r101, new f66.d(new JSONObject(MapsKt.mapOf(r102)))));
    }
}
