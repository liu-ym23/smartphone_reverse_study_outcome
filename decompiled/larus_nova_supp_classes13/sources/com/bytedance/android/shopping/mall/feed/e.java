package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.shopping.mall.homepage.pagecard.PageCard;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.android.ec.hybrid.list.ability.o {
    public final /* synthetic */ ECMallFeed.a a;

    public static final class a implements IECLynxCardLifeCycle {
        public final /* synthetic */ e a;

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

        public final void onLoadSuccess() {
        }

        public final void onPreCreateView(boolean r1) {
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

        public final void onRealSuccess() {
            ECMallFeed.f(this.a.a.b);
        }

        public a(e r1) {
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

    public final int a() {
        return this.a.b.M;
    }

    public final void b() {
        com.bytedance.android.shopping.mall.homepage.pagecard.d r0 = this.a.b.G1;
        if (r0 == null) goto L7;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r1 = r0.a();
        if (r1 == null) goto L7;
        PageCard r2 = r1.a;
    L8:
        if (r2 != null) goto L10;
    L13:
        if (r2 == null) goto L17;
        a r3 = new a(this);
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        ((ArrayList) r2.l).add(r3);
        return;
    L17:
        return;
    L10:
        if (r2.c != true) goto L13;
        ECMallFeed.f(this.a.b);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public e(ECMallFeed.a r1) {
        this.a = r1;
    }
}
