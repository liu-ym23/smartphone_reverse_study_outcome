package com.bytedance.android.shopping.store.home.view;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements IECLynxCardLifeCycle {
    public final /* synthetic */ ECLynxCard a;

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
        ECLynxCard r0 = this.a;
        if (r0 == null) goto L6;
        ECLynxCard.m(r0, true, "", "", true, false, false, 0, 240);
        return;
    }

    public d(ECLynxCard r1) {
        this.a = r1;
    }

    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r2, "cache");
    }

    public final void onLoadFailed(ECLynxCardErrorType r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }
}
