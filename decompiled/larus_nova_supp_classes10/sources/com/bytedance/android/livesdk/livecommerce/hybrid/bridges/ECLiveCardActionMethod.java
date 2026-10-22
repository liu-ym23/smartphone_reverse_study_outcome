package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import cf.d;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.n;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECLiveCardActionMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveCardActionMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "LiveCardActionParams(roomId=" + this.a + ", scene=" + this.b + ")";
        }

        public b(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public ECLiveCardActionMethod() {
        this.e = "ecLiveCardAction";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r6, ECBaseBridgeMethod.a r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "iReturn");
        int r1 = r6.optInt("actionType", 0);
        if (r1 != 1) goto L5;
        int r8 = n.o;
        n r9 = ControllerCenter.c(null, null).q;
        Objects.toString(r9);
        d r10 = r9.h;
        if ((r10 instanceof i) == true) goto L32;
        r10 = null;
    L32:
        i r11 = (i) r10;
        if (r11 == null) goto L35;
        r11.b();
        r7.onSuccess(null);
        return;
    L35:
        r7.onFailed(0, "card controller not exist");
        return;
    L5:
        if (r1 != 2) goto L7;
        JSONObject r12 = r6.optJSONObject("params");
        if (r12 == null) goto L13;
        String r2 = r12.optString("room_id");
    L15:
        if (r12 == null) goto L17;
        String r3 = r12.optString("scene");
    L18:
        b r0 = new b(r2, r3);
        if (r12 == null) goto L21;
        String r13 = r12.optString("scene");
    L23:
        if (Intrinsics.areEqual(r13, "apply_coupon_refresh") == true) goto L25;
        Lazy r14 = LiveEventCenter.b;
        LiveEventCenter.a.a().sendEvent("refresh_pop_card", r0);
    L28:
        r7.onSuccess(null);
        return;
    L25:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_CARD_APPLY_COUPON_REFRESH() == false) goto L28;
        Lazy r15 = LiveEventCenter.b;
        LiveEventCenter.a.a().sendEvent("refresh_pop_card", r0);
        goto L28
    L21:
        r13 = null;
        goto L23
    L17:
        r3 = null;
        goto L18
    L13:
        r2 = null;
        goto L15
    L7:
        if (r1 == 3) goto L9;
        r7.onFailed(0, "not support action");
        return;
    L9:
        Lazy r16 = LiveEventCenter.b;
        LiveEventCenter.a.a().sendEvent("get_pop_card", null);
        r7.onSuccess(null);
    }
}
