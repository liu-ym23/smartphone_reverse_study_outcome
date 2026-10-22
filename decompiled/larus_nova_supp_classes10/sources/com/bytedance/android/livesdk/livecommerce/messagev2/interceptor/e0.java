package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.ECV2WinLotteryInfo;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e0 extends a {
    public ExtraController e;
    public final RealRoomController f;

    public e0(RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        super(true);
        this.f = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        if ((r11 instanceof si2.z) == true) goto L5;
        return false;
    L5:
        si2.z r12 = (si2.z) r11;
        switch(r12.msgType) {
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L8;
            default: goto L7;
        };
    L7:
        boolean r0 = false;
    L38:
        if (r0 == false) goto L43;
        lj2.a r1 = (lj2.a) b(lj2.a.class, r12);
        if (r1 == null) goto L42;
        r1.H(r12);
    L42:
        return true;
    L43:
        return false;
    L8:
        ECV2WinLotteryInfo r2 = r12.winLotteryInfo;
        if (r2 == null) goto L37;
        Context r3 = getContext();
        if (r3 == null) goto L37;
        JSONObject r4 = tv5.a.b(r2);     // Catch: Exception -> L15
    L18:
        if (r2.lotteryType != 2) goto L20;
        String r5 = EComABUtils.getSettingScarceLotteryResultUrl();
    L21:
        Uri.Builder r6 = UriProtector.parse(r5).buildUpon();
        JSONObject r7 = new JSONObject();
        r7.put("ecom_live_lynx_data", r4);
        Unit r8 = Unit.INSTANCE;
        String r9 = r6.appendQueryParameter("mega_object", r7.toString()).build().toString();
        ExtraController r10 = this.e;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("extraController");
    L25:
        if (r10.i == false) goto L31;
        ExtraController r13 = this.e;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("extraController");
    L29:
        r13.getClass();
        ECLiveHybridUtil.k(r3, r9, false, false, false, null, 252);
        goto L37
    L31:
        if (r2.isWin == false) goto L37;
        ExtraController r14 = this.e;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("extraController");
    L36:
        r14.h = r9;
        goto L37
    L20:
        r5 = EComABUtils.getSettingLotteryResultUrl();
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r4 = new JSONObject();
    L37:
        r0 = true;
        goto L38
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        ExtraController r3 = this.f.u;
    L9:
        this.e = r3;
        return;
    L6:
        if (this.f.l() == false) goto L8;
        r3 = this.f.u;
        goto L9
    L8:
        Lazy r4 = ExtraController.l;
        r3 = ControllerCenter.c(r1, this.f.I).u;
        Objects.toString(r3);
        goto L9
    }
}
