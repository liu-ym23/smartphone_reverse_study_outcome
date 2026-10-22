package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.chain.event.EventState;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g0 extends com.bytedance.kmp.ec.yata.event.common.b {
    public int a;
    public final AndroidYaTaInstance b;
    public final BuyNowViewModel c;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        BuyNowLog.d("selfValidate", "Validate run");
        if (this.c.getSubmitStatusFlag() == true) goto L19;
        Lazy r1 = ECSettingKeys.a;
        int r2 = com.bytedance.android.ec.core.opt.ab.p.a;
        int r4 = com.bytedance.android.ec.core.abtest.e.a;
        Object r5 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r8 = jj4.b.b;     // Catch: Throwable -> L9
        Object r3 = jj4.a.a("buynow_order_submit_repeat", Boolean.class, r5, false);     // Catch: Throwable -> L9
        if (r3 != null) goto L16;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L16:
        if (((Boolean) r3).booleanValue() == false) goto L19;
        Lazy r9 = BuyNowLog.a;
        BuyNowLog.d("selfValidate", "Validate repeat times " + this.a);
        com.bytedance.android.shopping.buynow.tracker.a r10 = this.c.getTracker();
        int r0 = this.a;
        r10.getClass();
        r10.b("ies_ecommerce_fe_custom_log", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "repeat_submit"), TuplesKt.to("desc", "repeat_submit_" + r0)}));
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, null, null, null, 57);
    L9:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Object r13 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r13) == true) goto L14;
        r5 = r13;
    L14:
        r3 = r5;
    L19:
        this.a++;
        this.c.setSubmitStatusFlag(false);
        com.bytedance.android.shopping.buynow.tracker.a r14 = this.c.getTracker();
        r14.getClass();
        r14.b("order_submit_yata", MapsKt.emptyMap());
        com.bytedance.android.shopping.buynow.eventcenter.common.b r15 = com.bytedance.android.shopping.buynow.eventcenter.common.b.a;
        AndroidYaTaInstance r16 = this.b;
        BuyNowViewModel r17 = this.c;
        r15.getClass();
        com.bytedance.kmp.ec.yata.chain.event.b r18 = com.bytedance.android.shopping.buynow.eventcenter.common.b.a(r16, r17, r7, "__validate_conf__");
        if (r18.a != EventState.FAILED) goto L22;
        this.c.setSubmitStatusFlag(true);
    L22:
        return r18;
    }

    public g0(AndroidYaTaInstance r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "yataInstance");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.b = r2;
        this.c = r3;
    }
}
