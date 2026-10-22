package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public n(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.invoke(r4);
        ALogger.e("RTChorusRoomDressResource", "onError: " + r4);
    }
}
