package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0<T> implements Consumer {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    public c0() {
    }

    public final void accept(Object r3) {
        ALogger.i("RealTimeChorusMainViewWidget", "waitingUserMergeDataListObservable, size: " + ((ch0.m) r3).a);
    }
}
