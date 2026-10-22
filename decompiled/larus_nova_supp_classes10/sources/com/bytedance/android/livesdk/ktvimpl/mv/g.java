package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ KtvMvModel a;
    public final /* synthetic */ String b;

    public g(KtvMvModel r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Function3<? super String, ? super Long, ? super String, Unit> r0 = this.a.f;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(this.b, null, null);
    L5:
        String r6 = "getKtvGroupUser error " + r5.getMessage();
        ALogger.i(bb0.b.b(), r6 + ", invoke class :" + KtvMvModel.class.getSimpleName());
    }
}
