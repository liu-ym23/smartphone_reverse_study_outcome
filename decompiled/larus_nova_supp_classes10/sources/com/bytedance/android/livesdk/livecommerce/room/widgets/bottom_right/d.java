package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.event.p0;
import com.bytedance.bdlocation.exception.BDLocationException;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ f a;
    public final /* synthetic */ sk2.a b;

    public d(f r1, sk2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        ECCurrentPromotion r7 = (ECCurrentPromotion) r6;
        if (((com.bytedance.android.ec.model.g) r7).statusCode != 0) goto L8;
        r7.a = true;
        this.a.a.b.invoke(r7);
        sk2.a r0 = this.b;
        if (r0 == null) goto L7;
        r0.a.c("explain_retry_result", "1");
        r0.c(Integer.valueOf(((com.bytedance.android.ec.model.g) r7).statusCode));
        r0.a.i(null);
        return;
    L7:
        p0 r8 = new p0();
        r8.f("explain_retry_result", "1");
        r8.k();
        Unit r9 = Unit.INSTANCE;
        return;
    L8:
        this.a.a.b.invoke(null);
        sk2.a r1 = this.b;
        if (r1 == null) goto L11;
        r1.a.c("explain_retry_result", BDLocationException.ERROR_TIMEOUT);
        r1.c(Integer.valueOf(((com.bytedance.android.ec.model.g) r7).statusCode));
        r1.a.i(null);
        return;
    L11:
        p0 r10 = new p0();
        r10.f("explain_retry_result", BDLocationException.ERROR_TIMEOUT);
        r10.k();
        Unit r11 = Unit.INSTANCE;
    }
}
