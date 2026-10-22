package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.l;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListSubscriberDelegate$clickBuyOrItemJsEventSubscriber$1 implements ti.j {
    public final /* synthetic */ b a;

    public LivePromotionListSubscriberDelegate$clickBuyOrItemJsEventSubscriber$1(b r1) {
        this.a = r1;
    }

    public final void a(JSONObject r20) {
        Intrinsics.checkNotNullParameter(r20, "params");
        dm.a.a("LivePromotionListSubscriberDelegate").a("========clickBuyOrItemJsEventSubscriber========");
        LivePromotionListViewModel r2 = this.a.n.f();
        ql.a r3 = null;
        if (r2 == null) goto L13;
        RoomContextController r4 = r2.getRoomContextController();
        if (r4 == null) goto L13;
        RealRoomController r5 = r4.A();
        if (r5 == null) goto L13;
        EntryController r6 = r5.t;
        if (r6 == null) goto L13;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.c r7 = r6.K();
        if (r7 == null) goto L13;
        final LiveActionTracker r8 = r7.a("livesdk_live_room", null);
    L14:
        if (r8 == null) goto L16;
        il2.a.C0145a.a(r8, "recv_js_event", MapsKt.mapOf(TuplesKt.to("params", r20)), false, null, null, null, 60);
    L16:
        String r1 = r20.optString("promotion_id");
        if (r1.length() != 0) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == false) goto L26;
        if (r8 == null) goto L63;
        il2.a r0 = il2.a.C0145a.a(r8, "check_js_event", null, false, "promotion_id_is_null", null, null, 48);
        if (r0 == null) goto L64;
        ((LiveActionTracker) r0).e(false);
        return;
    L64:
        return;
    L63:
        return;
    L26:
        JSONObject r10 = r20.optJSONObject("eventParams");
        final String r11 = r20.optString("click_area", "button");
        final boolean r16 = r20.optBoolean("reportClickEvent", false);
        final String r17 = r20.optString("btm");
        final String r18 = r20.optString("container_id");
        LivePromotionListViewModel r12 = this.a.n.f();
        if (r12 == null) goto L52;
        List<ql.a> r13 = r12.getTotalPromotions();
        if (r13 == null) goto L52;
        Iterator<T> r14 = r13.iterator();
    L32:
        if (r14.hasNext() == false) goto L36;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((ql.a) r15).getPromotionId(), r1) == false) goto L32;
    L37:
        ql.a r19 = (ql.a) r15;
        if (r19 == null) goto L52;
        if (r10 == null) goto L50;
        ql.a r21 = l.a(r19);
        if (r21 == null) goto L50;
        JSONObject r22 = r21.getExtraTransmissibleLogParams();
        if (r22 != null) goto L45;
        r22 = new JSONObject();
    L45:
        Iterator<String> r23 = r10.keys();
    L47:
        if (r23.hasNext() == false) goto L49;
        String r24 = r23.next();
        r22.put(r24, r10.opt(r24));
        goto L47
    L49:
        Unit r25 = Unit.INSTANCE;
        r21.setExtraTransmissibleLogParams(r22);
        r3 = r21;
    L50:
        if (r3 == null) goto L57;
    L56:
        r19 = r3;
    L57:
        UtilityKotlinExtentionsKt.f(r19, this.a.n.getContext(), new LivePromotionListSubscriberDelegate$clickBuyOrItemJsEventSubscriber$1$onReceiveJsEvent$4(this, r18, r17, r8, r16, r11));
        return;
    L36:
        r15 = null;
    L52:
        if (r8 == null) goto L56;
        il2.a r26 = il2.a.C0145a.a(r8, "check_js_event", null, false, "promotion_not_found", null, null, 48);
        if (r26 == null) goto L56;
        ((LiveActionTracker) r26).e(false);
        goto L56
    L19:
        r9 = false;
    L13:
        r8 = null;
        goto L14
    }
}
