package com.bytedance.salamander.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/salamander/adapter/EventBusImpl$addObserverUsingBlock$receiver$1", "Landroid/content/BroadcastReceiver;", "runtime_release"}, k = 1, mv = {1, 7, 1})
public final class EventBusImpl$addObserverUsingBlock$receiver$1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "intent");
        if (Intrinsics.areEqual(r4.getAction(), null) == true) goto L5;
        return;
    L5:
        r4.getIntExtra("_sender_hash", -1);
        if (r4.getExtras() == null) goto L8;
        throw null;
    L8:
        Map r5 = MapsKt.emptyMap();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.bytedance.salamander.adapter.FoundationEventbusInterfaceKt.SLEventUserInfo }");
        TypeIntrinsics.asMutableMap(r5);
        throw null;
    }
}
