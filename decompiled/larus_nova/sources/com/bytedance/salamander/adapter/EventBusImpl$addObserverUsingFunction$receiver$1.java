package com.bytedance.salamander.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/salamander/adapter/EventBusImpl$addObserverUsingFunction$receiver$1", "Landroid/content/BroadcastReceiver;", "runtime_release"}, k = 1, mv = {1, 7, 1})
public final class EventBusImpl$addObserverUsingFunction$receiver$1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "intent");
        if (Intrinsics.areEqual(r101.getAction(), null) == true) goto L5;
        return;
    L5:
        r101.getIntExtra("_sender_hash", -1);
        throw null;     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
