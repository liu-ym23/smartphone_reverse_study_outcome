package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.util.LruCache;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.widgets.im.ShoppingIMButton;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q extends c0 {
    public static final LruCache<String, LruCache<String, String>> d = null;
    public static final a e = null;
    public ShoppingIMButton c;

    public static final class a {
        public a() {
        }

        public static void a(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "roomId");
            Intrinsics.checkNotNullParameter(r4, "productId");
            LruCache<String, LruCache<String, String>> r0 = q.d;
            LruCache<String, String> r1 = r0.get(r3);
            if (r1 != null) goto L5;
            LruCache<String, String> r2 = new LruCache(ECLiveABUtils.INSTANCE.getEC_LIVE_CLICK_PRODUCT_HISTORY_PRODUCT_COUNT_FOR_IM().intValue());
            r2.put(r4, r4);
            r0.put(r3, r2);
            return;
        L5:
            r1.put(r4, r4);
        }
    }

    public static final class b implements vd.a, ToolbarComponentCheckInterface {
        public final /* synthetic */ q a;

        public b(q r1) {
            this.a = r1;
        }

        public final void a(te.a r2, Function0 r3, Function1 r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "loadButton");
            Intrinsics.checkNotNullParameter(r4, "stopLoadCallback");
            b(r2, r3, r4);
        }

        public final void b(Object r6, Function0 r7, Function1 r8) {
            if (this.a.w() == true) goto L7;
            ECLiveEntranceMonitor.trace$default("checkThenLoad roomState not attached", "EntryController", false, 4, null);
            r8.invoke("roomState is not attached");
            return;
        L7:
            if ((r6 instanceof vd.b) == false) goto L10;
            q r9 = this.a;
            vd.b r10 = (vd.b) r6;
            r9.c = new ShoppingIMButton(this.a.m(), new IMController$onViewHandlerAttached$checkInterface$1$checkThenLoadInner$1(this), new IMController$onViewHandlerAttached$checkInterface$1$checkThenLoadInner$2(this), r10.getComponentExtra());
            r10.a(this.a.c);
        L12:
            r7.invoke();
            return;
        L10:
            if ((r6 instanceof ToolbarMatchInterface) == false) goto L12;
            q r11 = this.a;
            ToolbarMatchInterface r12 = (ToolbarMatchInterface) r6;
            r11.c = new ShoppingIMButton(this.a.m(), new IMController$onViewHandlerAttached$checkInterface$1$checkThenLoadInner$3(this), new IMController$onViewHandlerAttached$checkInterface$1$checkThenLoadInner$4(this), r12.getComponentExtra());
            r12.setExtraDataAfterCheck(this.a.c);
            goto L12
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r2, Function0<Unit> r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "loadButton");
            Intrinsics.checkNotNullParameter(r4, "stopLoadCallback");
            b(r2, r3, r4);
            return true;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onWidgetLoadFinished() {
    }

    static {
        e = new a();
        d = new LruCache(ECLiveABUtils.INSTANCE.getEC_LIVE_CLICK_PRODUCT_HISTORY_ROOM_COUNT_FOR_IM().intValue());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
    }

    public q(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
    }

    public static final void H(q r4) {
        LiveRoomParams r0 = r4.l();
        if (r0 == null) goto L16;
        BtmSDK r1 = BtmSDK.INSTANCE;
        ShoppingIMButton r2 = r4.c;
        if (r2 == null) goto L9;
        View r3 = r2.a;
        if (r3 == null) goto L9;
        PageFinder r5 = PageFinder.via(r3);
    L10:
        String r6 = r1.getPageId(r5);
        sg2.v r7 = new sg2.v("livesdk_ecom_im_entrance_click", r0);
        r7.e(r6);
        int r8 = ECSdk.a;
        IAdapterService r9 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r9 == null) goto L14;
        String r10 = r9.getIfClearModeValueWithClick();
        if (r10 == null) goto L14;
    L15:
        r7.c("if_clear_mode", r10);
        r7.c("is_preview", String.valueOf(r4.v()));
        r7.j("c9398.d73556", r6);
    L14:
        r10 = BDLocationException.ERROR_TIMEOUT;
    L9:
        r5 = null;
    L16:
        int r11 = ECSdk.a;
        IAdapterService r12 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r12 == null) goto L20;
        r12.sendLiveLogger("livesdk_toolbar_icon_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("btn_type", "commerce_im")}));
        return;
    }

    public static final void I(q r3) {
        LiveRoomParams r0 = r3.l();
        if (r0 == null) goto L12;
        BtmSDK r1 = BtmSDK.INSTANCE;
        ShoppingIMButton r4 = r3.c;
        if (r4 == null) goto L9;
        View r5 = r4.a;
        if (r5 == null) goto L9;
        PageFinder r6 = PageFinder.via(r5);
    L10:
        String r7 = r1.getPageId(r6);
        sg2.v r2 = new sg2.v("livesdk_ecom_im_entrance_show", r0);
        r2.e(r7);
        r2.j("c9398.d73556", r7);
        return;
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void a(com.bytedance.android.ec.adapter.api.state.a r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void d(com.bytedance.android.livesdk.livecommerce.room.api.e r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r2, "handler");
        b r3 = new b(this);
        E().I(r3);
    }

    public final void J(String r11, com.bytedance.android.btm.api.model.d r12) {
        Intrinsics.checkNotNullParameter(r11, "schema");
        UrlBuilderV2 r0 = new UrlBuilderV2(r11);
        LruCache<String, String> r13 = d.get(B());
        if (r13 == null) goto L11;
        Map<String, String> r14 = r13.snapshot();
        if (r14 == null) goto L11;
        Collection<String> r15 = r14.values();
        if (r15 == null) goto L11;
        List r16 = CollectionsKt.reversed(r15);
        if (r16 == null) goto L11;
        String r17 = CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, null, 62, null);
    L12:
        if (r17 != null) goto L14;
        r17 = "";
    L14:
        r0.addOrReplaceParam("eccs_scheme_info_api", z1.f(r0.getQuery("eccs_scheme_info_api")).put("history_view_pid", r17).toString());
        BtmUtilsKt.c(r0, r12);
        String r18 = r0.build();
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(m(), r18);
        return;
    L11:
        r17 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r2) {
        super.c(r1, r2);
    }
}
