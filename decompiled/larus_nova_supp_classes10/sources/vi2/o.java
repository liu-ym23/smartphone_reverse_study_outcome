package vi2;

import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements h.f<xi2.k> {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;

    @Override // vi2.h.f
    public final wi2.a<xi2.k> execute() throws Exception {
        if (hh2.f.g() == false) goto L6;
        FilterNullArrayList r0 = new FilterNullArrayList();
        int r7 = RoomContextController.h;
        RoomContextController r8 = RoomContextController.a.a();
        String r9 = this.a;
        int r10 = si2.k.c;
        r0.add(si2.k.a.a("promotion_ids", r9));
        r0.add(si2.k.a.a("use_new_price", String.valueOf(1)));
        r0.add(si2.k.a.a("author_open_id", r8.y()));
        r0.add(si2.k.a.a("sec_author_id", r8.z()));
        r0.add(si2.k.a.a("room_id", r8.B()));
        r0.add(si2.k.a.a("room_unique_key", r8.D()));
        r0.add(si2.k.a.a("request_status", String.valueOf(this.b)));
        Map<String, String> r1 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
        SsResponse r2 = h.i(si2.g.y, r0);
        return h.f((xi2.k) h.j(r2, xi2.k.class), r1, r2);
    L6:
        FilterNullArrayList r3 = new FilterNullArrayList();
        int r11 = RoomContextController.h;
        RoomContextController r12 = RoomContextController.a.a();
        String r13 = this.a;
        int r14 = si2.k.c;
        r3.add(si2.k.a.a("promotion_ids", r13));
        r3.add(si2.k.a.a("use_new_price", String.valueOf(1)));
        r3.add(si2.k.a.a("author_id", r12.y()));
        r3.add(si2.k.a.a("sec_author_id", r12.z()));
        r3.add(si2.k.a.a("room_id", r12.B()));
        r3.add(si2.k.a.a("request_status", String.valueOf(this.b)));
        Map<String, String> r4 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r3);
        String r15 = si2.g.x;
        SsResponse r5 = h.h(r15, r3);
        xi2.k r6 = (xi2.k) h.j(r5, xi2.k.class);
        if (r6 != null) goto L28;
        String r16 = null;
    L12:
        if (r6 == null) goto L27;
        if (r6.campaignList.size() != 1) goto L27;
        ECPromotionCampaign r17 = (ECPromotionCampaign) ListProtector.get(r6.campaignList, 0);     // Catch: Exception -> L9
        if (r17 == null) goto L27;
        int r18 = ECSdk.a;     // Catch: Exception -> L9
        IECAPTService r19 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Exception -> L9
        if (r19 == null) goto L27;
        String r20 = r17.promotionId;     // Catch: Exception -> L9
        if (r16 != null) goto L23;
        r16 = "";
    L23:
        r19.record(new si2.l(r15, r20, r16, null, null, null, null));     // Catch: Exception -> L9
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L27:
        return h.f(r6, r4, r5);
    L28:
        r16 = r6.getLogId();     // Catch: Exception -> L9
        goto L12
    }

    public o(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
