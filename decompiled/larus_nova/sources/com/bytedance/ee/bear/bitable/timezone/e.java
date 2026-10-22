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

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableTimeZoneListFragment f215956a;

    public e(BitableTimeZoneListFragment r100) {
        this.f215956a = r100;
    }

    public final void a() {
        Activity r100 = (Activity) this.f215956a.getContext();
        if (r100 == null) goto L17;
        BitableTimeZoneListFragment r101 = this.f215956a;
        if (r100.isFinishing() == false) goto L7;
        return;
    L7:
        if (r100.isDestroyed() == true) goto L19;
        int[] r102 = new int[2];
        CommonActionPanelLayout r103 = r101.f215942i;
        CCMLynxCardView r104 = null;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDragPanel");
        r103 = null;
    L11:
        r103.getDragHandler().getLocationOnScreen(r102);
        int r105 = n.E(y9c.d.g(r101.getContext()));
        int r106 = n.E(n.t() - r102[1]);
        CCMLynxCardView r107 = r101.f215941h;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mCcmLynxCardView");
    L15:
        r104.sendEvent("ccm-pagesize-change", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("pageWidth", Integer.valueOf(r105)), TuplesKt.to("pageHeight", Integer.valueOf(r106))})));
        return;
    L14:
        r104 = r107;
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
