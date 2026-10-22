package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ p a;

    public r(p r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        p.a r9 = (p.a) r8;
        ECUIPromotion r0 = r9.a;
        ECUIPromotion r1 = r9.b;
        p r2 = this.a;
        StringBuilder r3 = new StringBuilder("on all resp, explain card id=");
        if (r0 == null) goto L5;
        String r5 = r0.getPromotionId();
    L6:
        r3.append(r5);
        r3.append(", related card id=");
        if (r1 == null) goto L9;
        String r6 = r1.getPromotionId();
    L10:
        r3.append(r6);
        String r4 = r3.toString();
        r2.getClass();
        p.a(r4);
        this.a.b = false;
        this.a.c = r9;
        Function1<? super ECUIPromotion, Unit> r10 = this.a.d;
        if (r10 == null) goto L22;
        if (r1 == null) goto L20;
        if (r0 == null) goto L15;
        long r7 = r0.showPriority;
    L17:
        if (r7 < r1.showPriority) goto L19;
        r10.invoke(null);
        return;
    L19:
        r10.invoke(r1);
        this.a.b(r1);
        return;
    L15:
        r7 = 0;
        goto L17
    L20:
        r10.invoke(null);
        Unit r11 = Unit.INSTANCE;
        return;
    L22:
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
