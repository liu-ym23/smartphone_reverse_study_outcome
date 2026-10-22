package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y implements Runnable {
    public final /* synthetic */ z a;
    public final /* synthetic */ List b;

    public y(z r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        x r0 = this.a.k;
        List r1 = this.b;
        int r2 = x.j;
        r0.getClass();
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L18;
        Map r5 = ((ECRitTag) r4.next()).getEventParam();
        if (r5 == null) goto L4;
        Set r6 = r5.entrySet();
        if (r6 == null) goto L4;
        Iterator r7 = r6.iterator();
        if (r7 == null) goto L4;
    L12:
        if (r7.hasNext() == false) goto L4;
        Map.Entry r8 = (Map.Entry) r7.next();
        Object r9 = r8.getKey();
        if (r3.containsKey(r8.getKey()) == false) goto L16;
        String r10 = ((String) r3.get(r8.getKey())) + ',' + ((String) r8.getValue());
    L17:
        r3.put(r9, r10);
        goto L12
    L16:
        r10 = (String) r8.getValue();
        goto L17
    L18:
        RoomContextController r11 = null;
        if ((!r3.isEmpty()) == false) goto L21;
        LinkedHashMap r12 = r3;
    L22:
        if (r12 == null) goto L63;
        int r13 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
        ExplainCardViewModel r14 = r0.e;
        if (r14 == null) goto L28;
        ml.b r15 = r14.getLiveRoomInfo();
        if (r15 == null) goto L28;
        String r16 = r15.roomId();
    L29:
        ExplainCardViewModel r17 = r0.e;
        if (r17 == null) goto L34;
        QLiveData<ECUIPromotion> r18 = r17.getPromotionState();
        if (r18 == null) goto L34;
        ECUIPromotion r19 = (ECUIPromotion) r18.a();
    L35:
        ExplainCardViewModel r20 = r0.e;
        if (r20 == null) goto L40;
        Function0<Map<String, Map<String, String>>> r21 = r20.getEventPassthroughParams();
        if (r21 == null) goto L40;
        Map r22 = (Map) r21.invoke();
    L41:
        ExplainCardViewModel r23 = r0.e;
        if (r23 == null) goto L46;
        cf.c r24 = r23.getBtmInfo();
        if (r24 == null) goto L46;
        String r25 = r24.a();
    L47:
        String r110 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r0.y()));
        ExplainCardViewModel r26 = r0.e;
        if (r26 == null) goto L50;
        r11 = r26.getRoomContextController();
    L50:
        Intrinsics.checkNotNullParameter(r12, "params");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a("livesdk_show_product_info", new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.p(r19, ControllerExtensionsKt.c(r11, r16), r12, r22, r25, r110));
        return;
    L46:
        r25 = null;
    L40:
        r22 = null;
    L34:
        r19 = null;
    L28:
        r16 = null;
        goto L29
    L63:
        return;
    L21:
        r12 = null;
        goto L22
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
