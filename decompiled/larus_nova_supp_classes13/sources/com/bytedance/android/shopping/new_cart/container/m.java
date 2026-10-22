package com.bytedance.android.shopping.new_cart.container;

import android.view.Choreographer;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.new_cart.router.NewCartStarter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements Choreographer.FrameCallback {
    public final /* synthetic */ CartDialogFragment a;

    public m(CartDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r4) {
        CartDialogFragment r5 = this.a;
        int r6 = r5.K;
        if (r6 >= 1) goto L5;
        r5.K = r6 + 1;
        Choreographer.getInstance().postFrameCallback(this);
        return;
    L5:
        CartObjectContainer r7 = r5.h;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L9:
        if (r7.e.l.c == true) goto L30;
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r8 = NewCartStarter.t;
        if (r8 == null) goto L27;
        final CartDialogFragment r1 = this.a;
        if (r1.getContext() == null) goto L31;
        FragmentActivity r2 = r1.getActivity();
        if (r2 != null) goto L17;
    L18:
        FragmentActivity r3 = r1.getActivity();
        if (r3 != null) goto L21;
    L23:
        CartObjectContainer r9 = r1.h;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L26:
        r9.e.l.a = true;
        Map<String, Map<String, Long>> r10 = yf3.b.a;
        yf3.b.a(r1.ba0(), "CacheStartRender");
        bg3.a r11 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(r1.Y90(), "onCartCacheSuccess", new CartDialogFragment$cacheFirstPaint$1(r1, r8), new c(r1));
        return;
    L21:
        if (r3.isDestroyed() != true) goto L23;
        return;
    L17:
        if (r2.isFinishing() != true) goto L18;
        return;
    L31:
        return;
    L27:
        Choreographer.getInstance().postFrameCallback(this);
        return;
    }
}
