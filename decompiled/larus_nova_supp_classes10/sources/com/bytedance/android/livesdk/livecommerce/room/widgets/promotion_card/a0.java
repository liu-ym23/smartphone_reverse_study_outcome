package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.os.SystemClock;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ y a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.model.e c;

    public a0(y r1, Map r2, c0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        this.a.c = Long.valueOf(SystemClock.elapsedRealtime());
        y r0 = this.a;
        r0.a = false;
        ECUIPromotion r7 = com.bytedance.android.livesdk.livecommerce.utils.k.e(com.bytedance.android.livesdk.livecommerce.utils.k.c((ECCurrentPromotion) r6), Boolean.TRUE);
        if (r7 == null) goto L8;
        JSONObject r2 = r7.getExtraTransmissibleLogParams();
        if (r2 == null) goto L7;
        int r3 = com.bytedance.android.livesdk.livecommerce.room.controller.w.h;
        r2.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.c(this.b));
        r2.put("anchor_id", this.c.c());
        r2.put("room_id", this.c.roomId());
    L7:
        y.o.getClass();
        y.a.b(r7);
        Unit r4 = Unit.INSTANCE;
    L9:
        r0.d = r7;
        this.a.e = true;
        Function1<? super ECUIPromotion, Unit> r8 = this.a.g;
        if (r8 == null) goto L12;
        UtilityKotlinExtentionsKt.b.postAtFrontOfQueue(new z(r8, this));
    L12:
        this.a.g = null;
        return;
    L8:
        r7 = null;
        goto L9
    }
}
