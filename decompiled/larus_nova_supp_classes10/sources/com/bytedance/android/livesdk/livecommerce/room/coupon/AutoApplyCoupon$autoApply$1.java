package com.bytedance.android.livesdk.livecommerce.room.coupon;

import android.net.Uri;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AutoApplyCoupon$autoApply$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $couponId;
    final /* synthetic */ a this$0;

    public AutoApplyCoupon$autoApply$1(a r1, String r2) {
        this.this$0 = r1;
        this.$couponId = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1122invoke() {
        String r0 = (String) this.this$0.b.p.get("legou_dialog_use_new_version");
        if (r0 != null) goto L6;
        r0 = BDLocationException.ERROR_TIMEOUT;
    L6:
        if (Intrinsics.areEqual(r0, "1") == false) goto L8;
        String r1 = f.e;
    L11:
        Uri.Builder r2 = UriProtector.parse(r1).buildUpon();
        JSONObject r3 = new JSONObject();
        r3.put("roomID", this.this$0.a.B());
        r3.put("UID", this.this$0.a.y());
        r3.put("secUID", this.this$0.a.z());
        ECContext r4 = this.this$0.a.r();
        if (r4 == null) goto L19;
        i<Integer> r5 = r4.getLiveSDKVersion();
        if (r5 == null) goto L19;
        Integer r6 = (Integer) r5.getValue();
        if (r6 == null) goto L19;
        String r7 = String.valueOf(r6.intValue());
        if (r7 == null) goto L19;
    L20:
        r3.put("ecLiveVersion", r7);
        r3.put("applyCouponID", this.$couponId);
        Unit r8 = Unit.INSTANCE;
        r2.appendQueryParameter("ec_coupon_common_state", r3.toString());
        String r9 = r2.toString();
        ECLiveHybridUtil.k(this.this$0.getContext(), r9, false, false, false, null, 252);
        return;
    L19:
        r7 = "";
        goto L20
    L8:
        r1 = EComABUtils.getShortTouchCouponLynxConfig().a();
        if (r1 != null) goto L11;
        r1 = f.d;
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1122invoke();
        return Unit.INSTANCE;
    }
}
