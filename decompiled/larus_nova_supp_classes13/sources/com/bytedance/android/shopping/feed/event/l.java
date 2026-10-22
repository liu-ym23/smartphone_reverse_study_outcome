package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ rd3.a a;
    public final /* synthetic */ View b;
    public final /* synthetic */ String c;

    public final void a(String r8, Map<Object, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r9, "params");
        FeedProductEventTracker r10 = FeedProductEventTracker.a;
        Context r0 = this.b.getContext();
        rd3.a r1 = this.a;
        String r2 = this.c;
        Map<String, String> r5 = r1.k;
        Map r6 = o.a(r9);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "itemAnchor");
        u0 r11 = FeedProductEventTracker.c(r1, r2, null, false, r5, r6);
        if (r11 == null) goto L6;
        g.d(r11, r0);
        return;
    }

    public l(rd3.a r1, View r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
