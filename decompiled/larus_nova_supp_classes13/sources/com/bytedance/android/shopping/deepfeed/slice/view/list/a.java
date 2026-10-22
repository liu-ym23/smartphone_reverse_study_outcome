package com.bytedance.android.shopping.deepfeed.slice.view.list;

import java.util.Map;
import kotlin.Pair;
import yg3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements e {
    public final /* synthetic */ DeepFeedSlcList a;

    @Override // yg3.e
    public final void g() {
        DeepFeedSlcList r0 = this.a;
        c r1 = r0.n;
        if (r1 == null) goto L10;
        Pair<String, Map<String, Object>> r2 = r1.d;
        if (r2 == null) goto L11;
        com.bytedance.android.shopping.deepfeed.slice.service.b r3 = r0.w();
        if (r3 == null) goto L12;
        r3.O((String) r2.getFirst(), (Map) r2.getSecond(), this.a);
        return;
    L12:
        return;
    L11:
        return;
    }

    public a(DeepFeedSlcList r1) {
        this.a = r1;
    }
}
