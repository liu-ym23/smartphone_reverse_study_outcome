package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionCountResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ v0 a;

    public e(d r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ECPromotionCountResponse r3 = (ECPromotionCountResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "response");
        if (((com.bytedance.android.ec.model.g) r3).statusCode != 0) goto L7;
        v0 r0 = this.a;
        if (r0 == null) goto L11;
        r0.onSuccess(r3);
        return;
    L11:
        return;
    L7:
        v0 r4 = this.a;
        if (r4 == null) goto L13;
        r4.onError(null);
        return;
    }
}
