package com.bytedance.android.shopping.store.tabkit;

import android.os.Handler;
import android.view.View;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabKitHybridTabFragment$prefetchCallback$1 extends NaPrefetchSyncCallback {
    public final /* synthetic */ TabKitHybridTabFragment a;

    public TabKitHybridTabFragment$prefetchCallback$1(TabKitHybridTabFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback
    public final void onFail(String r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        TabKitHybridTabFragment.access$getLogger$p(this.a).w("prefetch fail", null);
        TabKitHybridTabFragment.access$recordPrefetchTiming(this.a);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback
    public final void onSuccess(final String r11, final boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "result");
        dm.a.a r0 = TabKitHybridTabFragment.access$getLogger$p(this.a);
        StringBuilder r1 = new StringBuilder("prefetch success, bff_flag:");
        r1.append(TabKitHybridTabFragment.access$getEcPrefetchBffFlag$p(this.a));
        r1.append(", lynx_view:");
        ti.l r2 = TabKitHybridTabFragment.access$getHybridComponent$p(this.a);
        if (r2 == null) goto L5;
        View r3 = r2.b();
    L6:
        r1.append(r3);
        r0.i(r1.toString());
        String r4 = TabKitHybridTabFragment.access$getEcPrefetchBffFlag$p(this.a);
        if (r4 != null) goto L9;
        return;
    L9:
        ti.l r5 = TabKitHybridTabFragment.access$getHybridComponent$p(this.a);
        if (r5 == null) goto L12;
        View r6 = r5.b();
    L14:
        if ((r6 instanceof LynxView) == true) goto L16;
        r6 = null;
    L16:
        final LynxView r9 = (LynxView) r6;
        if (r9 != null) goto L19;
        return;
    L19:
        boolean r7 = Intrinsics.areEqual(z1.f(r11).optString(r4), CommentScene.COMMENTSCENE_NO_AWEME);
        TabKitHybridTabFragment.access$getLogger$p(this.a).i("prefetch success, isBff:" + r7);
        if (r7 == false) goto L29;
        TabKitHybridTabFragment.access$recordPrefetchTiming(this.a);
        TabKitHybridTabFragment.recordTime$default(this.a, TabkitSwitchTabPref.T_TAB_UPDATE_START_TIME, null, 2, null);
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L24
        final TemplateData r10 = TemplateData.fromString(r11);     // Catch: Throwable -> L24
        Handler r13 = CommonUtils.a;     // Catch: Throwable -> L24
        CommonUtils.e(true, new TabKitHybridTabFragment$prefetchCallback$1$onSuccess$$inlined$runCatching$lambda$1(r10, this, r11, r12, r9));     // Catch: Throwable -> L24
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L29:
        return;
    L12:
        r6 = null;
        goto L14
    L5:
        r3 = null;
        goto L6
    }
}
