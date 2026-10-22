package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.router.c;
import com.bytedance.android.shopping.extensions.k;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECOpenProductListMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenProductListMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a implements c {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;

        @Override // com.bytedance.android.livesdk.livecommerce.router.c
        public final String a() {
            String r0 = this.a.optString("unique_index");
            if (r0.length() <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L10;
            return null;
        L10:
            return r0;
        L5:
            r1 = false;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.livecommerce.router.c
        public final String b() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
            Object r1 = this.a.remove("pass_through_json");     // Catch: Throwable -> L14
            Unit r2 = null;
            if ((r1 instanceof String) == true) goto L5;
            r1 = null;
        L5:
            String r3 = (String) r1;     // Catch: Throwable -> L14
            if (r3 == null) goto L12;
            JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L14
            Iterator<String> r5 = r4.keys();     // Catch: Throwable -> L14
        L9:
            if (r5.hasNext() == false) goto L11;
            String r6 = r5.next();     // Catch: Throwable -> L14
            this.a.put(r6, r4.opt(r6));     // Catch: Throwable -> L14
            goto L9
        L11:
            r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
        L12:
            Result.constructor-impl(r2);     // Catch: Throwable -> L14
        L17:
            return this.a.toString();
        L14:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }

        public final String entryName() {
            String r0 = this.a.optString("live_list_channel");
            if (r0.length() <= 0) goto L6;
            return r0;
        L6:
            return this.a.optString("live_list_chanel");
        }

        public final String getCouponId() {
            return this.a.optString("coupon_id");
        }

        @Override // com.bytedance.android.livesdk.livecommerce.router.c
        public final String c() {
            return this.b;
        }

        public a(JSONObject r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ECOpenProductListMethod() {
        this.e = "ecOpenProductList";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r21, ECBaseBridgeMethod.a r22) {
        Intrinsics.checkNotNullParameter(r21, "params");
        Intrinsics.checkNotNullParameter(r22, "iReturn");
        String r2 = r21.optString("btm");
        String r3 = r21.optString("bcm");
        BcmParams.Companion.getClass();
        d r4 = BtmUtilsKt.d(r2, BcmParams.a.a(r3), PageFinder.via(b().a));
        String r9 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r4);
        String r5 = k.u(r21.optString("pass_through_json")).optString("preferred_coupon");
        Context r6 = getContext();
        if (r6 == null) goto L5;
        PromotionListController.T.getClass();
        PromotionListController.N(PromotionListController.a.a(), r6, "jsb", new a(r21, r5), new PromotionListController.c(null, false, null, null, r9, null, null, null, 239), false, null, null, null, 240);
    L5:
        r22.onSuccess(null);
    }
}
