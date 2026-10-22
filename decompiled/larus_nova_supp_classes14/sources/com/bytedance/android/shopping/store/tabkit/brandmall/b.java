package com.bytedance.android.shopping.store.tabkit.brandmall;

import com.bytedance.android.shopping.store.tabkit.model.z;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ TabkitFirstFramePref a;

    public b(TabkitFirstFramePref r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        z r6 = (z) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        TabkitFirstFramePref r0 = this.a;
        if (r0 == null) goto L5;
        TabkitFramePref.recordTime$default(r0, TabkitFirstFramePref.T_REQUEST_END, null, 2, null);
    L5:
        return r6;
    }
}
