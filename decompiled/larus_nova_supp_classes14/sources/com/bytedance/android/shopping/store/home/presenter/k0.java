package com.bytedance.android.shopping.store.home.presenter;

import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k0 implements IECLynxCardLifeCycle {
    public final /* synthetic */ ECShopFloatLynxPresenter a;
    public final /* synthetic */ FrameLayout b;
    public final /* synthetic */ Map c;

    public final void createViewDuration(long r1) {
    }

    public final void onCreateKitViewEnd(long r1) {
    }

    public final void onDestroy() {
    }

    public final void onFirstScreen() {
    }

    public final void onLoadStart() {
    }

    public final void onPreCreateView(boolean r1) {
    }

    public final void onRealSuccess() {
    }

    public final void onReceivedError(com.bytedance.lynx.service.model.b r1) {
    }

    public final void onRuntimeReady() {
    }

    public final void onTimingSetup(Map<String, ? extends Object> r1) {
    }

    public final void onTimingSetupPref(com.bytedance.android.ec.hybrid.card.util.k r1) {
    }

    public final void onTimingUpdatePref(com.bytedance.android.ec.hybrid.card.util.k r1) {
    }

    public final void onTransDataTime(long r1, long r3) {
    }

    public final void onLoadSuccess() {
        uj3.j r0 = this.a.T().getCurrentTab();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d != TabEnum.PRODUCT_TAB.getType()) goto L11;
        ECLynxCard r1 = this.a.y;
        if (r1 == null) goto L12;
        r1.p("set_coin_pendant_visible", MapsKt.mapOf(new Pair[]{TuplesKt.to("visible", Boolean.TRUE), TuplesKt.to("popup", Boolean.valueOf(this.a.z))}));
        return;
    L12:
        return;
    }

    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r2, "cache");
    }

    public k0(ECShopFloatLynxPresenter r1, FrameLayout r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onLoadFailed(ECLynxCardErrorType r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }
}
