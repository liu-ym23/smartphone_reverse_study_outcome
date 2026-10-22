package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$FromSource;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.RelatedInfoManager;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListJumpToOtherPageEventData;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements ti.j {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    public final void a(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        String r7 = r6.optString("related_info");
        if (r7.length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r7 = null;
    L10:
        if (r7 == null) goto L31;
        LivePromotionListViewModel r1 = this.a.n.f();
        if (r1 == null) goto L26;
        LivePromotionListParams r2 = r1.getListParams();
        if (r2 == null) goto L26;
        String r3 = r2.getRoomId();
        if (r3 == null) goto L26;
        LivePromotionListViewModel r4 = this.a.n.f();
        if (r4 == null) goto L26;
        RoomContextController r5 = r4.getRoomContextController();
        if (r5 == null) goto L26;
        RoomContextController r8 = ControllerExtensionsKt.c(r5, r3);
        if (r8 == null) goto L26;
        RealRoomController r9 = r8.A();
        if (r9 == null) goto L26;
        EntryController r10 = r9.t;
    L27:
        if (r10 == null) goto L31;
        RelatedInfoManager r11 = r10.M();
        if (r11 == null) goto L31;
        r11.i(r7, IRelatedInfoManager$FromSource.LIVE_LIST_TAB_RESORT_ABILITY);
    L26:
        r10 = null;
    L31:
        LivePromotionListViewModel r12 = this.a.n.f();
        if (r12 == null) goto L34;
        LivePromotionListViewModel.updateWhenBackFromOtherPage$default(r12, null, true, 1, null);
    L34:
        LivePromotionListViewModel r13 = this.a.n.f();
        if (r13 == null) goto L39;
        LivePromotionListViewModel r14 = r13.getSecondViewModel();
        if (r14 == null) goto L39;
        LivePromotionListViewModel.updateWhenBackFromOtherPage$default(r14, null, true, 1, null);
    L39:
        LivePromotionListViewModel r15 = this.a.n.f();
        if (r15 == null) goto L46;
        gi2.a r16 = r15.getPromotionListParams();
        if (r16 == null) goto L46;
        com.bytedance.android.shopping.ligo.context.b<?> r17 = r16.a;
        if (r17 == null) goto L46;
        r17.g(new we3.a.c(new LiveLigoListJumpToOtherPageEventData("change_store", null, 2, null)));
    L46:
        LivePromotionListViewModel r18 = this.a.n.f();
        if (r18 == null) goto L56;
        LivePromotionListViewModel r19 = r18.getSecondViewModel();
        if (r19 == null) goto L57;
        gi2.a r20 = r19.getPromotionListParams();
        if (r20 == null) goto L58;
        com.bytedance.android.shopping.ligo.context.b<?> r21 = r20.a;
        if (r21 == null) goto L59;
        r21.g(new we3.a.c(new LiveLigoListJumpToOtherPageEventData("change_store", null, 2, null)));
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L5:
        r0 = false;
        goto L7
    }
}
