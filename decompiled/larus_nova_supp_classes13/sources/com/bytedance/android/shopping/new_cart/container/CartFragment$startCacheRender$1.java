package com.bytedance.android.shopping.new_cart.container;

import android.view.Choreographer;
import com.bytedance.android.shopping.new_cart.router.NewCartStarter;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartFragment$startCacheRender$1 implements Choreographer.FrameCallback {
    public final /* synthetic */ CartFragment a;

    public CartFragment$startCacheRender$1(CartFragment r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r4) {
        CartFragment r5 = this.a;
        int r6 = r5.z;
        if (r6 >= 1) goto L5;
        r5.z = r6 + 1;
        Choreographer.getInstance().postFrameCallback(this);
        return;
    L5:
        Lazy r7 = CartCommonLog.a;
        CartCommonLog.a("NewCartStarter", new CartFragment$startCacheRender$1$doFrame$1(this));
        if (CartFragment.S90(this.a).e.l.c == true) goto L16;
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r8 = NewCartStarter.t;
        CartCommonLog.a("NewCartStarter", new CartFragment$startCacheRender$1$doFrame$2(this, r8));
        if (r8 == null) goto L13;
        final CartFragment r9 = this.a;
        CartObjectContainer r1 = r9.i;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L12:
        r1.e.l.a = true;
        Map<String, Map<String, Long>> r0 = yf3.b.a;
        yf3.b.a(r9.Y90(), "CacheStartRender");
        bg3.a r2 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(r9.W90(), "onCartCacheSuccess", new CartFragment$cacheFirstPaint$1(r9, r8), new n(r9));
        return;
    L13:
        Choreographer.getInstance().postFrameCallback(this);
        return;
    }
}
