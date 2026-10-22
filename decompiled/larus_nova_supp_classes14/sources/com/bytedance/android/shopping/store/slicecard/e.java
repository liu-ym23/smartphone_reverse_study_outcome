package com.bytedance.android.shopping.store.slicecard;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.ECShopShareHelper;
import com.bytedance.android.shopping.store.home.ECStoreTabKitFragment;
import com.bytedance.android.shopping.store.utils.c0;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class e extends d {
    public final ECStoreViewModel c;
    public final QContext d;

    public void e(IAction r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "targetView");
    }

    public e(ECStoreViewModel r2, QContext r3) {
        Intrinsics.checkNotNullParameter(r2, "storeViewModel");
        super(r2);
        this.c = r2;
        this.d = r3;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.d
    public final void c(IAction r19, View r20) {
        Intrinsics.checkNotNullParameter(r19, "action");
        Intrinsics.checkNotNullParameter(r20, "targetView");
        String r1 = r19.getType();
        SliceActionType r4 = SliceActionType.UPDATE_ITEM_STATES;
        Fragment r6 = null;
        Object r7 = null;
        Object r8 = null;
        Fragment r9 = null;
        r9 = null;
        boolean r10 = true;
        if (Intrinsics.areEqual(r1, r4.getType()) == true) goto L5;
        SliceActionType r5 = SliceActionType.OPEN_LIVE_ROOM_SCHEMA;
        if (Intrinsics.areEqual(r1, r5.getType()) == true) goto L14;
        SliceActionType r11 = SliceActionType.CLOSE_SHOP;
        if (Intrinsics.areEqual(r1, r11.getType()) == true) goto L43;
        SliceActionType r12 = SliceActionType.SHARE;
        if (Intrinsics.areEqual(r1, r12.getType()) == true) goto L71;
        e(r19, r20);
        return;
    L71:
        if ((!Intrinsics.areEqual(r19.getType(), r12.getType())) == true) goto L92;
        ECShopShareHelper r2 = this.c.getShareHelper();
        if (r2 == null) goto L84;
        int r3 = com.bytedance.android.shopping.store.home.d.f;
        r2.f(null);
        return;
    L84:
        return;
    L92:
        return;
    L43:
        if ((!Intrinsics.areEqual(r19.getType(), r11.getType())) == false) goto L46;
        return;
    L46:
        if (this.c.getStoreParam().isSplitMode() == false) goto L54;
        Lazy r13 = ECStoreFoldPhoneHelper.a;
        QContext r14 = this.d;
        if (r14 == null) goto L52;
        QUIManager r15 = r14.d();
        if (r15 == null) goto L52;
        r9 = r15.i();
    L52:
        ECStoreFoldPhoneHelper.a(r9);
        return;
    L54:
        if (this.c.interceptBackPressed(r20.getContext(), true) == true) goto L81;
        QContext r16 = this.d;
        if (r16 == null) goto L60;
        QUIManager r17 = r16.d();
        if (r17 == null) goto L60;
        Fragment r18 = r17.i();
    L62:
        if ((r18 instanceof ECStoreTabKitFragment) == false) goto L65;
        r6 = r18;
    L65:
        ECStoreTabKitFragment r21 = (ECStoreTabKitFragment) r6;
        if (r21 == null) goto L82;
        r21.finish();
        return;
    L82:
        return;
    L60:
        r18 = null;
        goto L62
    L81:
        return;
    L14:
        if ((!Intrinsics.areEqual(r19.getType(), r5.getType())) == true) goto L87;
        Map r22 = r19.getParams();
        int r23 = gj3.a.a;
        String r110 = gj3.a.b(this.c);
        c0 r24 = c0.a;
        String r25 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r22, "schema", null);
        boolean r111 = this.c.getStoreParam().isEcShare();
        String r112 = this.c.getStoreParam().getShareContent();
        String r113 = this.c.getStoreParam().getShareObject();
        String r114 = this.c.getStoreParam().getSearchParams();
        String r115 = this.c.getPassThroughLogData();
        String r116 = (String) this.c.getStoreParam().getPassThroughParam("pass_through_api");
        QContext r26 = this.d;
        if (r26 == null) goto L19;
        FragmentActivity r117 = r26.a();
    L20:
        String r27 = c0.b(r24, r25, r110, r111, r112, r113, r114, r115, r116, r117);
        if (r27 != null) goto L23;
    L26:
        if (r10 == true) goto L88;
        ECStoreViewModel r28 = this.c;
        Intrinsics.checkNotNullParameter(r28, "viewModel");
        int r29 = com.bytedance.android.ec.store.utils.h.a;
        com.bytedance.android.ec.store.utils.h.d(r28.getEntranceInfoJsonObject(), "otherclick", "live_room", r28.getAdParams(), "shop_window_ad");
        if (gj3.a.a(this.c, r27, new ShopBaseSlcActionHandlerWithViewmodel$actionOpenLiveRoomSchema$1(this)) == true) goto L89;
        String r30 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r22, "btm_id", null);
        if (r30 != null) goto L34;
        r30 = "";
    L34:
        if (r22 == null) goto L36;
        r8 = r22.get("bcm_params");
    L36:
        Map r31 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r8);
        int r32 = com.bytedance.android.ec.store.utils.b.a;
        PageFinder r33 = PageFinder.via(r20);
        BcmParams.Companion.getClass();
        String r34 = com.bytedance.android.ec.store.utils.b.b(r27, r30, r33, BcmParams.a.c(r31));
        if (r34 == null) goto L90;
        p.a.openSchema(r20.getContext(), r34);
        return;
    L90:
        return;
    L89:
        return;
    L88:
        return;
    L23:
        if (StringsKt.isBlank(r27) == true) goto L26;
        r10 = false;
        goto L26
    L19:
        r117 = null;
        goto L20
    L87:
        return;
    L5:
        if ((!Intrinsics.areEqual(r19.getType(), r4.getType())) == true) goto L86;
        Map r35 = r19.getParams();
        if (r35 == null) goto L10;
        r7 = r35.get("updated_states");
    L10:
        this.c.getSliceService().c(com.bytedance.android.ecom.arch.slice.render.util.b.o(r7));
        return;
    }
}
