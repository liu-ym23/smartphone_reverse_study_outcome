package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j0 implements v {
    public static final j0 a = null;

    public j0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        a = new j0();
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        IHostLiveLocalLife r0 = jc1.k.f(IHostLiveLocalLife.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.useAppendExpoundCardIdInjector();
    L6:
        if (r1 == true) goto L9;
        return;
    L9:
        switch(r5.hashCode()) {
            case -1506213568: goto L33;
            case -1122536402: goto L30;
            case -1115849514: goto L27;
            case -804282046: goto L24;
            case -597919004: goto L21;
            case 21313630: goto L18;
            case 1499179894: goto L15;
            case 1499265855: goto L12;
            default: goto L61;
        };
    L61:
        return;
    L12:
        if (r5.equals("livesdk_live_show") == false) goto L53;
    L34:
        String r7 = r6.get("room_id");
        String r2 = null;
        if (r7 == null) goto L37;
        Long r8 = StringsKt.toLongOrNull(r7);
    L51:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L48
        IHostLiveLocalLife r4 = jc1.k.f(IHostLiveLocalLife.class);     // Catch: Throwable -> L48
        if (r4 == null) goto L46;
        if (r8 == null) goto L42;
        long r9 = r8.longValue();     // Catch: Throwable -> L48
    L43:
        String r10 = r4.getExpoundCardId(r9);     // Catch: Throwable -> L48
        if (r10 == null) goto L46;
        r2 = r6.put("explain_product_id", r10);     // Catch: Throwable -> L48
        goto L46
    L42:
        r9 = 0;
    L46:
        Result.constructor-impl(r2);     // Catch: Throwable -> L48
        return;
    L48:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L37:
        r8 = null;
        goto L51
    L53:
        return;
    L15:
        if (r5.equals("livesdk_live_play") == true) goto L34;
        return;
    L18:
        if (r5.equals("livesdk_audience_live_message") == true) goto L34;
        return;
    L21:
        if (r5.equals("livesdk_live_click_user") == true) goto L34;
        return;
    L24:
        if (r5.equals("livesdk_follow") == true) goto L34;
        return;
    L27:
        if (r5.equals("livesdk_live_duration") == true) goto L34;
        return;
    L30:
        if (r5.equals("livesdk_share") == true) goto L34;
        return;
    L33:
        if (r5.equals("livesdk_lottery_participate_click") == true) goto L34;
        return;
    L5:
        r1 = false;
        goto L6
    }
}
