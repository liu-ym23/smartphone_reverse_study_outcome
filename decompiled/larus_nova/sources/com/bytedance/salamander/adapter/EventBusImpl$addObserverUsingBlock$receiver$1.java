package com.bytedance.salamander.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/salamander/adapter/EventBusImpl$addObserverUsingBlock$receiver$1", "Landroid/content/BroadcastReceiver;", "runtime_release"}, k = 1, mv = {1, 7, 1})
public final class EventBusImpl$addObserverUsingBlock$receiver$1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "intent");
        if (Intrinsics.areEqual(r101.getAction(), null) == true) goto L5;
        return;
    L5:
        r101.getIntExtra("_sender_hash", -1);
        if (r101.getExtras() == null) goto L8;
        throw null;
    L8:
        Map r102 = MapsKt.emptyMap();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.bytedance.salamander.adapter.FoundationEventbusInterfaceKt.SLEventUserInfo }");
        TypeIntrinsics.asMutableMap(r102);
        throw null;
    }
}
