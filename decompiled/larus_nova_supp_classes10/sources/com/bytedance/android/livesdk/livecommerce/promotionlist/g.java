package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.live.ligo.DynamicType;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.shopping.ligo.container.event.AddCartExtraData;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements ti.j {
    public final /* synthetic */ b a;

    public g(b r1) {
        this.a = r1;
    }

    public final void a(JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        int r1 = com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.c.a;
        Intrinsics.checkNotNullParameter(r11, "params");
        String r4 = r11.optString("schema");
        String r0 = r11.optString("card_data");
        String r7 = r11.optString(LocationMonitorConst.TYPE);
        JSONObject r2 = z1.f(r0);
        boolean r3 = true;
        if (Intrinsics.areEqual(r7, "mount") == false) goto L5;
        r2.put("is_update", false);
    L6:
        String r5 = r2.toString();
        boolean r6 = r11.optBoolean("quit_others");
        String r12 = r11.optString("cart_extra");
        if (r12.length() > 0) goto L11;
        r3 = false;
    L11:
        if (r3 == true) goto L14;
        r12 = null;
    L14:
        if (r12 != null) goto L25;
    L20:
        AddCartExtraData r13 = null;
    L21:
        com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a r8 = new com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a(new ll.a("instant_add_on_floor", DynamicType.LYNX.getValue(), r4, r5, 10001), r7, r6, r13);
        LivePromotionListViewModel r14 = this.a.n.f();
        if (r14 == null) goto L27;
        r14.notifyPromotionCardShowBottomAddOnFloor(r8);
        return;
    L27:
        return;
    L25:
        r13 = (AddCartExtraData) new Gson().fromJson(r12, AddCartExtraData.class);     // Catch: Exception -> L17
    L19:
        if (r13 != null) goto L21;
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r13 = null;
        goto L19
    L5:
        r2.put("is_update", true);
        goto L6
    }
}
