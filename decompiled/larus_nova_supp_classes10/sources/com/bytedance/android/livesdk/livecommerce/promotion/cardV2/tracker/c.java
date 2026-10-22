package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int b = 0;
    public final b a;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends d<LiveActionTracker> {
        public b() {
        }
    }

    static {
        new a();
    }

    public c() {
        this.a = new b();
    }

    public final LiveActionTracker a(String r3, com.bytedance.android.btm.api.model.d r4) {
        Intrinsics.checkNotNullParameter(r3, "pageName");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_PROMOTION_TRACKER() == false) goto L6;
        dm.a.a("ActionTrack").a("build new tracker");
        LiveActionTracker r0 = new LiveActionTracker(r3, r4, this);
        b r5 = this.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "key");
        r5.a.put(r0, d.b);
        return r0;
    L6:
        return null;
    }
}
