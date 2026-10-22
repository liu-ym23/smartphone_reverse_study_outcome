package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ ExplainCardWidgetController a;
    public final /* synthetic */ ExplainCardViewModel b;

    public f(ExplainCardWidgetController r1, ExplainCardViewModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r7) {
        String r8 = (String) r7;
        if (r8 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L35;
        int r2 = EComABUtils.getRoomNoFilterNoticeShowCount();
        ExplainCardWidgetController r3 = this.a;
        if (r3.l >= r2) goto L36;
        RoomContextController r4 = r3.A;
        ml.b r5 = r3.v;
        Map r6 = null;
        if (r5 == null) goto L15;
        String r9 = r5.roomId();
    L16:
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r10 = ControllerExtensionsKt.c(r4, r9).A().q;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r8, "text");
        Long r11 = Long.valueOf(CastLongProtector.parseLong(r10.B()));     // Catch: Exception -> L19
    L20:
        if (r11 == null) goto L24;
        r11.longValue();
        if (r10.b.l() == false) goto L24;
        r10.q().insertLegalMessage(r11.longValue(), r8, true);
    L24:
        int r12 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
        ml.b r13 = this.a.v;
        if (r13 == null) goto L27;
        String r14 = r13.roomId();
    L28:
        Function0<Map<String, Map<String, String>>> r15 = this.b.getEventPassthroughParams();
        if (r15 == null) goto L31;
        r6 = (Map) r15.invoke();
    L31:
        RoomContextController r16 = this.b.getRoomContextController();
        Intrinsics.checkNotNullParameter(r16, "roomContextController");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a("ECNoFilterLiveNoticeShowEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.j(ControllerExtensionsKt.c(r16, r14), r6));
        this.a.l++;
        return;
    L27:
        r14 = null;
    L19:
        r11 = null;
        goto L20
    L15:
        r9 = null;
        goto L16
    L36:
        return;
    L35:
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
