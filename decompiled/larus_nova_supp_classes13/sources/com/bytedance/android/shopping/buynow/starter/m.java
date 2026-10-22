package com.bytedance.android.shopping.buynow.starter;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements bf.c {

    public static final class a {
    }

    static {
    }

    public m() {
    }

    public final void a() {
    }

    public final String b() {
        return "continue_pay";
    }

    public final boolean c(Context r10, Uri r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "uri");
        Lazy r13 = BuyNowLog.a;
        BuyNowLog.d("ContinuePayRouter", "ContinuePayRouter open uri: " + r11);
        String r7 = UriProtector.getQueryParameter(r11, "source_btm_token");
        BuyNowLog.d("ContinuePayRouter", "BuyNowStarter create open buy now " + r11);
        int r14 = BuyNowStarter.w;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.e.getClass();
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r15 = com.bytedance.android.shopping.buynow.monitor.firstscreen.a.d;
        if (r15 == null) goto L9;
        com.bytedance.android.ec.model.d r0 = r15.c;
        if (r0 == null) goto L9;
        Long r1 = r0.b;
        if (r1 == null) goto L9;
        long r2 = r1.longValue();
    L11:
        if ((System.currentTimeMillis() - r2) < 100000) goto L13;
        r15 = null;
    L13:
        BuyNowStarter.a.b(r11, r15, null, null, null, null, r7, 188).t(r10);
        return true;
    L9:
        r2 = 0;
        goto L11
    }
}
