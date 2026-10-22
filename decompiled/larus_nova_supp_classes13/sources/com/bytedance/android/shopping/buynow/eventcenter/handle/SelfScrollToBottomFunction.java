package com.bytedance.android.shopping.buynow.eventcenter.handle;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfScrollToBottomFunction extends com.bytedance.kmp.ec.yata.event.common.b {
    public final BuyNowViewModel a;
    public final Map<String, RecyclerView> b;
    public final RecyclerView c;

    public static final class a {
    }

    static {
    }

    public static void d(final RecyclerView r4) {
        int r0 = com.bytedance.android.shopping.buynow.utils.j.a;
        Function0<Unit> r1 = new SelfScrollToBottomFunction$scrollToBottom$1(r4);
        Intrinsics.checkNotNullParameter("selfScrollToBottom", "errorType");
        Intrinsics.checkNotNullParameter(r1, "task");
        Intrinsics.checkNotNullParameter("selfScrollToBottom", "errorType");
        Intrinsics.checkNotNullParameter(r1, "task");
        BuyNowLog.a("OrderListThrowableUtils", "orderListRunCatch selfScrollToBottom");
        r1.invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (ECAppInfoService.e.i() == true) goto L10;
        String r5 = th.getMessage();
        Map r2 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r2, "params");
        Lazy r3 = BuyNowLog.a;
        BuyNowLog.c("OrderListThrowableUtils", "logForException selfScrollToBottom " + r5 + ' ' + r2);
        return;
    L10:
        throw th;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r6) {
        Intrinsics.checkNotNullParameter(r6, "input");
        BuyNowLog.d("selfScrollToBottom", "selfScrollBottom starts");
        Map r1 = r6.q();
        if (r1 == null) goto L5;
        Object r2 = r1.get("popup_code");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
        d(this.c);
    L22:
        BuyNowLog.d("selfScrollToBottom", "selfScrollBottom finishes");
        int r7 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L18:
        RecyclerView r5 = this.b.get(r3);
        if (r5 == null) goto L21;
        d(r5);
        goto L22
    L21:
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.a.getTracker(), "selfScrollToBottom", "popup code is empty", r6);
        goto L22
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L16
    L5:
        r2 = null;
        goto L7
    }

    public SelfScrollToBottomFunction(BuyNowViewModel r2, Map<String, ? extends RecyclerView> r3, RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "popupMap");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
