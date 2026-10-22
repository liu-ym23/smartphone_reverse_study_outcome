package com.bytedance.android.shopping.store.router.hybridpage.slice;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.store.utils.h;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.store.router.hybridpage.event.PageCardEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.android.shopping.store.slicecard.d;
import com.bytedance.android.shopping.store.utils.c0;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a extends d {
    public final HybridPageViewModel c;
    public final QContext d;

    public void e(IAction r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "targetView");
    }

    public a(HybridPageViewModel r2, QContext r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        super(r2);
        this.c = r2;
        this.d = r3;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.d
    public final void c(IAction r20, View r21) {
        Intrinsics.checkNotNullParameter(r20, "action");
        Intrinsics.checkNotNullParameter(r21, "targetView");
        String r1 = r20.getType();
        SliceActionType r4 = SliceActionType.UPDATE_ITEM_STATES;
        Object r6 = null;
        boolean r7 = true;
        if (Intrinsics.areEqual(r1, r4.getType()) == true) goto L5;
        SliceActionType r5 = SliceActionType.OPEN_LIVE_ROOM_SCHEMA;
        String r8 = "";
        if (Intrinsics.areEqual(r1, r5.getType()) == true) goto L14;
        SliceActionType r9 = SliceActionType.PUBLISH_X_EVENT;
        if (Intrinsics.areEqual(r1, r9.getType()) == true) goto L67;
        e(r20, r21);
        return;
    L67:
        if ((!Intrinsics.areEqual(r20.getType(), r9.getType())) == true) goto L91;
        Map r2 = r20.getParams();
        if (r2 == null) goto L75;
        String r3 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r2, "event_name", null);
        if (r3 == null) goto L75;
        r8 = r3;
    L75:
        Map r10 = r20.getParams();
        if (r10 == null) goto L78;
        r6 = r10.get("event_params");
    L78:
        Map r11 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r6);
        if (r11 != null) goto L81;
        r11 = new LinkedHashMap();
    L81:
        ReentrantReadWriteLock r12 = PageCardEventManager.a;
        PageCardEventManager.g(this.c.getSceneId(), r8, r11);
        return;
    L91:
        return;
    L14:
        if ((!Intrinsics.areEqual(r20.getType(), r5.getType())) == true) goto L88;
        Map r13 = r20.getParams();
        c0 r14 = c0.a;
        String r15 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r13, "schema", null);
        SliceProductCardData r16 = this.c.getSliceProductCardData();
        if (r16 != null) goto L19;
    L21:
        boolean r17 = false;
    L22:
        SliceProductCardData r18 = this.c.getSliceProductCardData();
        if (r18 == null) goto L25;
        String r19 = r18.getShareContent();
    L26:
        SliceProductCardData r22 = this.c.getSliceProductCardData();
        if (r22 == null) goto L29;
        String r110 = r22.getShareObject();
    L30:
        SliceProductCardData r23 = this.c.getSliceProductCardData();
        if (r23 == null) goto L33;
        String r111 = r23.getSearchParams();
    L34:
        String r112 = this.c.getPassThroughLogData();
        SliceProductCardData r24 = this.c.getSliceProductCardData();
        if (r24 == null) goto L37;
        String r113 = (String) r24.getPassThroughParam("pass_through_api");
    L38:
        QContext r25 = this.d;
        if (r25 == null) goto L41;
        FragmentActivity r114 = r25.a();
    L42:
        String r26 = c0.b(r14, r15, "live_cell", r17, r19, r110, r111, r112, r113, r114);
        if (r26 != null) goto L45;
    L48:
        if (r7 == true) goto L89;
        int r27 = h.a;
        SliceProductCardData r28 = this.c.getSliceProductCardData();
        if (r28 == null) goto L53;
        JSONObject r29 = r28.getEntranceInfoJsonObject();
    L54:
        h.d(r29, "otherclick", "live_room", this.c.getAdParams(), "shop_window_ad");
        String r30 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r13, "btm_id", null);
        if (r30 == null) goto L58;
        r8 = r30;
    L58:
        if (r13 == null) goto L60;
        r6 = r13.get("bcm_params");
    L60:
        Map r31 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r6);
        int r32 = com.bytedance.android.ec.store.utils.b.a;
        PageFinder r33 = PageFinder.via(r21);
        BcmParams.Companion.getClass();
        String r34 = com.bytedance.android.ec.store.utils.b.b(r26, r8, r33, BcmParams.a.c(r31));
        if (r34 == null) goto L90;
        p.a.openSchema(r21.getContext(), r34);
        return;
    L90:
        return;
    L53:
        r29 = null;
        goto L54
    L89:
        return;
    L45:
        if (StringsKt.isBlank(r26) == true) goto L48;
        r7 = false;
        goto L48
    L41:
        r114 = null;
        goto L42
    L37:
        r113 = null;
        goto L38
    L33:
        r111 = null;
        goto L34
    L29:
        r110 = null;
        goto L30
    L25:
        r19 = null;
        goto L26
    L19:
        if (r16.isEcShare() != true) goto L21;
        r17 = true;
        goto L22
    L88:
        return;
    L5:
        if ((!Intrinsics.areEqual(r20.getType(), r4.getType())) == true) goto L87;
        Map r35 = r20.getParams();
        if (r35 == null) goto L10;
        r6 = r35.get("updated_states");
    L10:
        this.c.getSliceService().c(com.bytedance.android.ecom.arch.slice.render.util.b.o(r6));
        return;
    }
}
