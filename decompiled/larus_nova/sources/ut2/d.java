package ut2;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.browser.jsbridge.base.UrgeGiftSendResultModel;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.urge.UrgeSendGiftEventCode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import w20.d7;
import w20.of;
import zv0.f;

/* JADX INFO: loaded from: classes11.dex */
@XBridgeMethod(biz = "webcast", name = "urgeGiftSend")
public final class d extends d7<of, UrgeGiftSendResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f551628a;

    public d() {
        this.f551628a = ((IRechargeServiceExternal) k.n(IRechargeServiceExternal.class)).rechargeCenter();
    }

    public static final void j(d r100, Context r101) {
        r100.getClass();
        xs2.b.a().post(new tt2.d(UrgeSendGiftEventCode.INSUFFICIENTFUND));
        f2.b(R.string.ttlive_send_failed_insufficient_balance, 0);
        ((IHostAction) k.n(IHostAction.class)).handleSchema(r101, "sslocal://wallet_coin?charge_reason=urge_update", new Bundle());
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        of r112 = (of) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r113 = r112.b();
        if (r113 == null) goto L5;
        int r100 = r113.intValue();
    L6:
        Long r114 = r112.c();
        long r101 = 0;
        if (r114 == null) goto L9;
        long r102 = r114.longValue();
    L10:
        Number r115 = r112.a();
        if (r115 != null) goto L13;
        r115 = 0L;
    L13:
        Long r103 = r112.e();
        if (r103 == null) goto L16;
        r101 = r103.longValue();
    L16:
        String r104 = String.valueOf(r101);
        String r116 = r112.d();
        if (r116 != null) goto L19;
        r116 = "";
    L19:
        String r105 = r116;
        long r106 = r115.longValue();
        IUserService r117 = (IUserService) k.f(IUserService.class);
        if (r117 == null) goto L25;
        com.bytedance.android.livesdk.user.f r118 = r117.user();
        if (r118 == null) goto L25;
        String r119 = r118.n();
        if (r119 == null) goto L25;
    L26:
        String r120 = r119;
        CompositeDisposable r121 = new CompositeDisposable();
        this.f551628a.sync("urge_gift_panel");
        RxUtilKt.c(this.f551628a.observeWallet().compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r100, r121, r104, r105, r102, r106, r120)), r121);
        return;
    L25:
        r119 = "0";
        goto L26
    L9:
        r102 = 0;
        goto L10
    L5:
        r100 = 0;
        goto L6
    }
}
