package com.bytedance.android.shopping.buynow.starter;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int e = 0;
    public final boolean a;
    public final boolean b;
    public boolean c;
    public final float d;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.ecom.arch.slice.render.context.b a() {
        float r1 = 1.0f;
        if (this.c == false) goto L10;
        nj.d r0 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r0 == null) goto L7;
        r0.getSpiltWidth();
        float r2 = 0;
    L8:
        int r3 = com.bytedance.android.shopping.sku.common.utils.c.a;
        float r4 = (com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.e.getCurrentActivity()).a * 375.0f) / r2;
        com.bytedance.android.ecom.arch.slice.render.context.b.f.getClass();
        com.bytedance.android.ecom.arch.slice.render.context.b r5 = com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r4, 1.0f, 1.0f);
    L22:
        Lazy r6 = BuyNowLog.a;
        BuyNowLog.d("BuyNowPageConfig", "enableUiAdapt:" + this.a);
        return r5;
    L7:
        r2 = 360.0f;
        goto L8
    L10:
        if (this.a == false) goto L21;
        float r7 = this.d;
        com.bytedance.android.ecom.arch.slice.render.context.b.a r8 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        if (this.b == false) goto L14;
        float r9 = com.bytedance.android.shopping.utils.o.a();
    L16:
        if (this.b == false) goto L20;
        int r10 = com.bytedance.android.shopping.utils.o.a;
        if (ECAppInfoService.e.f() == false) goto L20;
        r1 = 1.15f;
    L20:
        r8.getClass();
        r5 = com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r7, r1, r9);
        goto L22
    L14:
        r9 = 1.0f;
        goto L16
    L21:
        com.bytedance.android.ecom.arch.slice.render.context.b.a r11 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        boolean r12 = this.b;
        r11.getClass();
        r5 = com.bytedance.android.ecom.arch.slice.render.context.b.a.c(r12);
        goto L22
    }

    public b(boolean r3, boolean r4, boolean r5, float r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = true;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 375.0f;
    L14:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
