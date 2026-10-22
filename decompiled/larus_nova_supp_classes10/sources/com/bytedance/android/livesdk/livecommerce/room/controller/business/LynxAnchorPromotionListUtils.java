package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LynxAnchorPromotionListUtils {
    public static volatile boolean a;
    public static final Lazy b = null;
    public static a c;
    public static b d;
    public static final Lazy e = null;

    public static final class a implements ti.j {
        public final String a;
        public final String b;

        public final void a(JSONObject r6) {
            Intrinsics.checkNotNullParameter(r6, "params");
            r.a("receive event:ecom.anchor.open_coupon_panel");
            FragmentActivity r7 = ECAppInfoService.e.getCurrentActivity();
            if ((r7 instanceof FragmentActivity) == false) goto L16;
            boolean r0 = LynxAnchorPromotionListUtils.a;
            FragmentManager r8 = r7.getSupportFragmentManager();
            String r1 = this.a;
            String r2 = this.b;
            if (r8 == null) goto L17;
            LiveRoomCouponListFragment r3 = new LiveRoomCouponListFragment();
            Bundle r4 = new Bundle();
            r4.putString("room_id", r1);
            r4.putString("anchor_id", r2);
            r3.setArguments(r4);
            LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "live_coupon_list", r5);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r3, r5) == true) goto L18;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L11:
            r3.show(r8, "live_coupon_list");
            return;
        L18:
            return;
        L17:
            return;
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "roomId");
            Intrinsics.checkNotNullParameter(r3, "anchorId");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements ti.j {

        public static final class a implements zk.b {
            public a() {
            }

            public final String entryName() {
                return "";
            }

            public final String getCouponId() {
                return "";
            }
        }

        public b() {
        }

        public final void a(JSONObject r19) {
            Intrinsics.checkNotNullParameter(r19, "params");
            Activity r3 = ECAppInfoService.e.getCurrentActivity();
            if ((r3 instanceof Context) == false) goto L5;
            r.a("receive event:ecom.anchor.open_anchor_promotions_panel");
            PromotionListController.T.getClass();
            PromotionListController.N(PromotionListController.a.a(), r3, "event", new a(), new PromotionListController.c(null, false, null, null, r19.optString("source_btm_token"), null, null, null, 239), false, null, null, null, 240);
            return;
        L5:
            r.a("activity is not Context");
        }
    }

    public static void a() {
        a = false;
        r.a("unRegisterLynxAnchorPromotionListEvent");
        ECLiveHybridUtil.p("ecom.anchor.pickedViewClose", (ti.j) b.getValue());
        a r0 = c;
        if (r0 == null) goto L5;
        ECLiveHybridUtil.p("ecom.anchor.open_coupon_panel", r0);
    L5:
        ECLiveHybridUtil.p("ecom.anchor.continue_push_stream", (ti.j) e.getValue());
        b r1 = d;
        if (r1 == null) goto L9;
        ECLiveHybridUtil.p("ecom.anchor.open_anchor_promotions_panel", r1);
        return;
    }

    static {
        b = LazyKt.lazy(LynxAnchorPromotionListUtils$JS_PICKED_VIEW_CLOSE_EVENT_SUBSCRIBER$2.INSTANCE);
        e = LazyKt.lazy(LynxAnchorPromotionListUtils$JS_CONTINUE_PUSH_STREAM_EVENT_SUBSCRIBER$2.INSTANCE);
    }
}
