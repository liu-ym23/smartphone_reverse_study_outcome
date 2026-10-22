package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ k.d a;

    public r(k.d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        k r0 = this.a.a;
        String r4 = "sendFeedbackMessage exception: " + ((Throwable) r3).getStackTrace();
        ALogger.i(bb0.b.b(), r4 + ", invoke class :" + k.class.getSimpleName());
    }
}
