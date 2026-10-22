package com.bytedance.android.shopping.store.hybridproduct;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.store.window.ECShopHybridRoundedLinearLayout;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopLynxCardHolder;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends com.bytedance.android.ec.hybrid.list.ability.m0 {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public i(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final ECLynxCardHolder a(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        String r1 = null;
        ECShopHybridRoundedLinearLayout r0 = new ECShopHybridRoundedLinearLayout(r9, null, 6, 0);
        r0.setOrientation(1);
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ECShopHybridProductListPresenter r4 = this.a;
        ECShopLynxCardHolder r2 = new ECShopLynxCardHolder(r0, r4.f, r4.N);
        Pair[] r10 = new Pair[1];
        ECShopHybridProductListPresenter r3 = this.a;
        Map<String, ? super Object> r5 = r3.h;
        r5.put("tab_id", r3.m0().getRequestParam().getRequestTabType());
        ECShopHybridProductListPresenter r6 = this.a;
        Activity r7 = com.bytedance.android.ec.core.utils.l0.b(r6.Y().c());
        Intrinsics.checkNotNullParameter(r6, "$this$getTranslucent");
        if (Build.VERSION.SDK_INT < 23) goto L19;
        if (r7 == null) goto L6;
        Window r8 = r7.getWindow();
    L7:
        if (r8 == null) goto L19;
        View r11 = r8.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r12 = ThreadMethodProxy.currentThread();
        if (r12 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r12, "getDecorView");
    L13:
        if (r11 == null) goto L19;
        if ((r11.getSystemUiVisibility() & 8192) != 8192) goto L17;
        String r13 = "lite";
    L18:
        r1 = r13;
        goto L19
    L17:
        r13 = "dark";
        goto L18
    L6:
        r8 = null;
    L19:
        r5.put("status-bar-translucent-style", r1);
        Unit r14 = Unit.INSTANCE;
        r10[0] = TuplesKt.to("meta_info", r5);
        ((ECLynxCardHolder) r2).q = MapsKt.mutableMapOf(r10);
        return r2;
    }
}
