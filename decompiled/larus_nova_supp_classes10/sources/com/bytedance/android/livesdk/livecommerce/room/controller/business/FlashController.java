package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFlashResponse;
import com.bytedance.android.livesdk.livecommerce.oldflash.LiveFlashNewFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.utils.f0;
import com.bytedance.android.livesdk.livecommerce.utils.g0;
import com.bytedance.android.livesdk.livecommerce.utils.k0;
import com.bytedance.android.livesdk.livecommerce.utils.l0;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class FlashController extends c0 {
    public static final /* synthetic */ int f = 0;
    public boolean c;
    public LiveFlashNewFragment d;
    public b e;

    public static final class a {
    }

    public static final class b {
        public boolean a;
        public int b;
        public String c;
        public String d;
        public String e;
        public boolean f;
        public Map<String, ? extends List<String>> g;

        public b() {
        }
    }

    static {
    }

    public FlashController(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
    }

    public final void K(ECFlashResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "ecFlashResponse");
        this.c = r3.isOpen();
        b r0 = new b();
        this.e = r0;
        if (r3.getHasAuth() == 0) goto L5;
        boolean r1 = true;
    L6:
        r0.f = r1;
        r0.c = r3.getShopId();
        r0.g = r3.getProperties_adapt_multi();
        r0.e = r3.getIds();
        r0.d = r3.getNames();
        r0.a = r3.isNeedBarCode();
        r0.b = r3.getLastBarCodeState();
        r0.g = r3.getProperties_adapt_multi();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void H(Context r3, Function2<? super String, ? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "cb");
        int r1 = g0.a;
        if (r3 != null) goto L5;
        r3 = m();
    L5:
        com.bytedance.android.livesdk.livecommerce.room.api.c r2 = q();
        Intrinsics.checkNotNullParameter(r4, "cb");
        if (r3 != null) goto L8;
        r4.invoke(null, "no context");
        return;
    L8:
        if (r2 == null) goto L10;
        r2.i(new f0(r3, r4));
        return;
    L10:
        r4.invoke(null, "no liveRoomProvider");
    }

    public final DialogFragment I(Context r11, Bundle r12, Long r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        b r6 = this.e;
        if (r6 == null) goto L9;
        if ((r11 instanceof FragmentActivity) == false) goto L9;
        int r0 = com.bytedance.android.livesdk.livecommerce.oldflash.r.a;
        LiveFlashNewFragment r14 = com.bytedance.android.livesdk.livecommerce.oldflash.r.a(r11, y(), z(), B(), new FlashController$showFlashPanel$1$localFlash$1(this), r6, this, r12, r13);
        this.d = r14;
        return r14;
    L9:
        return new DialogFragment();
    }

    public final void J(final Context r8, final Bundle r9, final Long r10, final Function1<? super DialogFragment, Unit> r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        si2.i r0 = com.bytedance.android.livesdk.livecommerce.oldflash.s.s;
        ECLiveABUtils r1 = ECLiveABUtils.INSTANCE;
        if (r1.getEC_LIVE_USE_NEW_ANCHOR_FLASH_SALE().booleanValue() == false) goto L41;
        dm.a.a("FlashController").a("openNewFlashPanel");
        if (r8 != null) goto L8;
        return;
    L8:
        if (r9 == null) goto L11;
        String r2 = r9.getString("enter_from", "sg_nickname");
        if (r2 == null) goto L11;
    L12:
        boolean r12 = Intrinsics.areEqual(r2, "sg_nickname");
        String r3 = "";
        if (r9 == null) goto L16;
        String r13 = r9.getString("target_id", "");
        if (r13 == null) goto L16;
    L17:
        UrlBuilderV2 r4 = new UrlBuilderV2(r1.getEC_LIVE_ANCHOR_FLASH_PURCHASE_PUBLISH_URL());
        r4.addOrReplaceParam("enter_from", r2);
        r4.addOrReplaceParam("room_id", B());
        r4.addOrReplaceParam("room_unique_key", D());
        r4.addOrReplaceParam("anchor_id", y());
        b r14 = this.e;
        if (r14 == null) goto L21;
        String r15 = r14.c;
        if (r15 == null) goto L21;
    L22:
        r4.addOrReplaceParam("shop_id", r15);
        r4.addOrReplaceParam("target_uid", r13);
        ECAppInfoService r16 = ECAppInfoService.e;
        if (we.a.a == false) goto L25;
        String r17 = "7386";
    L26:
        r4.addOrReplaceParam("ecom_appid", r17);
        String r18 = r16.e();
        if (r18 == null) goto L30;
        r3 = r18;
    L30:
        r4.addOrReplaceParam("host_app_id", r3);
        r4.addOrReplaceParam("ecom_sdk_version", String.valueOf(44700));
        com.bytedance.android.livesdk.livecommerce.utils.k.h(1);
        com.bytedance.android.livesdk.livecommerce.room.f.b(r8, r4.build());
        LiveRoomParams r19 = l();
        if (r19 == null) goto L43;
        sg2.v r20 = new sg2.v("livesdk_click_button", r19);
        if (r12 == false) goto L35;
        String r21 = "定向闪购";
    L36:
        r20.c("button_for", r21);
        if (r12 == false) goto L39;
        String r22 = "user_detail";
    L40:
        r20.c("page_name", r22);
        r20.c("entrance_name", "flash_buy");
        r20.i(null);
        return;
    L39:
        r22 = "live_stream";
        goto L40
    L35:
        r21 = "全量闪购";
        goto L36
    L43:
        return;
    L25:
        r17 = "";
    L21:
        r15 = "";
    L16:
        r13 = "";
    L11:
        r2 = "sg_nickname";
        goto L12
    L41:
        int r5 = l0.a;
        Function0<Unit> r6 = new FlashController$tryShowLiveFlashFragment$1(this, r8, r9, r10, r11);
        Intrinsics.checkNotNullParameter(r6, "goShowFlashPanel");
        CoreRequests.d(new k0(r8, SystemClock.elapsedRealtime(), r6));
    }
}
