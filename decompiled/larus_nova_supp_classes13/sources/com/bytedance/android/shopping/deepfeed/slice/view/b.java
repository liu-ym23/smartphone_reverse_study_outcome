package com.bytedance.android.shopping.deepfeed.slice.view;

import com.bytedance.android.shopping.deepfeed.slice.action.t;
import com.bytedance.android.shopping.deepfeed.slice.action.v;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements t {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.t
    public final v a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        v r0 = (v) ((LinkedHashMap) this.a.i).get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        t r1 = this.a.e;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.a(r2);
    }
}
