package com.bytedance.ee.bear.bitable.timezone;

import android.app.Activity;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Runnable {
    public final /* synthetic */ BitableTimeZoneListFragment a;

    public e(BitableTimeZoneListFragment r1) {
        this.a = r1;
    }

    public final void a() {
        Activity r0 = (Activity) this.a.getContext();
        if (r0 == null) goto L17;
        BitableTimeZoneListFragment r1 = this.a;
        if (r0.isFinishing() == false) goto L7;
        return;
    L7:
        if (r0.isDestroyed() == true) goto L19;
        int[] r2 = new int[2];
        CommonActionPanelLayout r3 = r1.i;
        CCMLynxCardView r4 = null;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r3 = null;
    L11:
        r3.getDragHandler().getLocationOnScreen(r2);
        int r5 = n.E(y9c.d.g(r1.getContext()));
        int r6 = n.E(n.t() - r2[1]);
        CCMLynxCardView r7 = r1.h;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mCcmLynxCardView");
    L15:
        r4.sendEvent("ccm-pagesize-change", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("pageWidth", Integer.valueOf(r5)), TuplesKt.to("pageHeight", Integer.valueOf(r6))})));
        return;
    L14:
        r4 = r7;
        goto L15
    L19:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
