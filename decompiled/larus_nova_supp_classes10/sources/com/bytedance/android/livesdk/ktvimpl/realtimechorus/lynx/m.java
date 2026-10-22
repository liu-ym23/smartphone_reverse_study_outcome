package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m extends b7.a {
    public final /* synthetic */ c a;

    public m(c r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r2) {
        super.onLoadSuccess(r2);
        ALogger.i("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard load success");
    }

    public final boolean onFallback(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        ALogger.e("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard onFallback errorMessage=" + r4);
        return super.onFallback(r3, r4);
    }

    public final void onInnerFallback(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        super.onInnerFallback(r2, r3);
        ALogger.e("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard onInnerFallback errorMessage=" + r3);
    }

    public final void onContainerError(View r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        super.onContainerError(r2, r3, r4);
        ALogger.e("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard onContainerError errorMessage=" + r4);
    }

    public final void onLoadFail(View r1, String r2, String r3) {
        super.onLoadFail(r1, r2, r3);
        ALogger.e("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard load fail reason=" + r3);
        this.a.b = null;
    }
}
