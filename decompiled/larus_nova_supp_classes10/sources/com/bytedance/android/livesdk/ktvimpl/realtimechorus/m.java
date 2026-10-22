package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public m(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.profit.dress.t r4 = (com.bytedance.android.live.profit.dress.t) r3;
        this.a.invoke(r4);
        ALogger.i("RTChorusRoomDressResource", "onNext: " + r4);
    }
}
