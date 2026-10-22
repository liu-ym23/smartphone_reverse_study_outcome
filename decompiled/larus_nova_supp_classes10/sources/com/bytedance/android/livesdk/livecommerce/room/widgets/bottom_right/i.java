package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import android.content.Context;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.s;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface i {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(i r8, Function1 r9, boolean r10, s r11, int r12) {
            if ((r12 & 2) == 0) goto L6;
            r9 = null;
        L6:
            if ((r12 & 4) == 0) goto L8;
            boolean r3 = false;
        L10:
            if ((r12 & 16) == 0) goto L12;
            s r5 = null;
        L13:
            r8.p(null, r9, r3, null, r5, null, null);
            return;
        L12:
            r5 = r11;
            goto L13
        L8:
            r3 = r10;
            goto L10
        }
    }

    void b();

    void f(ECUIPromotion r1);

    fk2.a g();

    void h(String r1, long r2);

    RoomContextController i();

    ExplainCardViewModel j();

    void k(String r1, String r2, boolean r3);

    Context n();

    void o(ECUIPromotion r1, boolean r2, String r3, Function1<? super ECUIPromotion, Unit> r4);

    void p(String r1, Function1<? super ECUIPromotion, Unit> r2, boolean r3, Pair<Long, Long> r4, s r5, String r6, Map<String, String> r7);

    void q(String r1, long r2);

    void r();
}
