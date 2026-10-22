package com.bytedance.android.shopping.store.tabkit;

import android.os.Handler;
import android.view.View;
import com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.lynx.tasm.LynxView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabKitHybridTabFragment$prefetchCallbackV2$1 extends NaPrefetchSyncCallback {
    public final /* synthetic */ TabKitHybridTabFragment a;

    public TabKitHybridTabFragment$prefetchCallbackV2$1(TabKitHybridTabFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback
    public final void onFail(String r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        TabKitHybridTabFragment.access$getLogger$p(this.a).w("prefetch fail", null);
        TabKitHybridTabFragment.access$recordPrefetchTiming(this.a);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback
    public final void onSuccess(final String r6, final boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "result");
        dm.a.a r0 = TabKitHybridTabFragment.access$getLogger$p(this.a);
        StringBuilder r1 = new StringBuilder("prefetch success, lynx_view:");
        ti.l r2 = TabKitHybridTabFragment.access$getHybridComponent$p(this.a);
        if (r2 == null) goto L5;
        View r3 = r2.b();
    L6:
        r1.append(r3);
        r0.i(r1.toString());
        ti.l r4 = TabKitHybridTabFragment.access$getHybridComponent$p(this.a);
        if (r4 == null) goto L9;
        View r5 = r4.b();
    L11:
        if ((r5 instanceof LynxView) == true) goto L13;
        r5 = null;
    L13:
        final LynxView r8 = (LynxView) r5;
        if (r8 != null) goto L16;
        return;
    L16:
        TabKitHybridTabFragment.access$recordPrefetchTiming(this.a);
        TabKitHybridTabFragment.recordTime$default(this.a, TabkitSwitchTabPref.T_TAB_UPDATE_START_TIME, null, 2, null);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L19
        Handler r10 = CommonUtils.a;     // Catch: Throwable -> L19
        CommonUtils.e(true, new TabKitHybridTabFragment$prefetchCallbackV2$1$onSuccess$$inlined$runCatching$lambda$1(this, r7, r6, r8));     // Catch: Throwable -> L19
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }
}
