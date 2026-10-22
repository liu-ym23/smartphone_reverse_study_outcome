package com.bytedance.android.shopping.mall.homepage.card.video;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.common.utility.Logger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements IECLynxCardLifeCycle {
    public b() {
    }

    public final void createViewDuration(long r1) {
    }

    public final void onCreateKitViewEnd(long r1) {
    }

    public final void onDestroy() {
    }

    public final void onFirstScreen() {
    }

    public final void onPreCreateView(boolean r1) {
    }

    public final void onRealSuccess() {
    }

    public final void onTimingSetup(Map<String, ? extends Object> r1) {
    }

    public final void onTimingSetupPref(k r1) {
    }

    public final void onTimingUpdatePref(k r1) {
    }

    public final void onTransDataTime(long r1, long r3) {
    }

    public final void onLoadStart() {
        Logger.d("puffone-NativeVideoCard.onLoadStart()", "金币Lifecycle");
    }

    public final void onLoadSuccess() {
        Logger.d("puffone-NativeVideoCard.onLoadSuccess()", "金币Lifecycle");
    }

    public final void onRuntimeReady() {
        Logger.d("puffone-NativeVideoCard.onRuntimeReady()", "金币Lifecycle");
    }

    public final void onReceivedError(com.bytedance.lynx.service.model.b r4) {
        StringBuilder r0 = new StringBuilder("金币Lifecycle ");
        String r1 = null;
        if (r4 == null) goto L5;
        Integer r2 = Integer.valueOf(r4.a);
    L6:
        r0.append(r2);
        r0.append(", ");
        if (r4 == null) goto L9;
        r1 = r4.b;
    L9:
        r0.append(r1);
        Logger.d("puffone-NativeVideoCard.onReceivedError()", r0.toString());
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        Intrinsics.checkNotNullParameter(r2, "cache");
    }

    public final void onLoadFailed(ECLynxCardErrorType r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r2, "type");
        Logger.d("puffone-NativeVideoCard.onLoadFailed()", "金币Lifecycle " + r3 + ", " + r4);
    }
}
