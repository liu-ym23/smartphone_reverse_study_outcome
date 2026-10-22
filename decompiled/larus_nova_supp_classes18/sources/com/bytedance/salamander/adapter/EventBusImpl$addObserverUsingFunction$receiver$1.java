package com.bytedance.salamander.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/salamander/adapter/EventBusImpl$addObserverUsingFunction$receiver$1", "Landroid/content/BroadcastReceiver;", "runtime_release"}, k = 1, mv = {1, 7, 1})
public final class EventBusImpl$addObserverUsingFunction$receiver$1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "intent");
        if (Intrinsics.areEqual(r4.getAction(), null) == true) goto L5;
        return;
    L5:
        r4.getIntExtra("_sender_hash", -1);
        throw null;     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
