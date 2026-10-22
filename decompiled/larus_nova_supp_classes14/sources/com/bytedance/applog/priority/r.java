package com.bytedance.applog.priority;

import android.webkit.ValueCallback;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class r implements ValueCallback {
    public /* synthetic */ r() {
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r1) {
        PriorityWrapper.a((Pair) r1);
    }
}
