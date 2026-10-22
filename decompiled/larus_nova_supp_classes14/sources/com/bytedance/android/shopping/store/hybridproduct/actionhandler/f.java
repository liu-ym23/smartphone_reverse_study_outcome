package com.bytedance.android.shopping.store.hybridproduct.actionhandler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements ej.b {
    public f() {
    }

    public final void onResult(boolean r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (r3 == false) goto L5;
        dm.a.a("productsubscribe").i("addCalendar success");
        return;
    L5:
        dm.a.a("productsubscribe").i("addCalendar failed,errorCode:" + r4 + ",msg:" + r5);
    }
}
