package com.bytedance.android.window.shop.holder.presenter;

import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends ECWindowHolderBaseFragmentPresenter {
    public t(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void b0(QModel r3) {
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r4 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r5 = com.bytedance.android.window.shop.lifecycle.c.a(d0().getShopParam().getLifecycleMonitorId());
        if (r5 == null) goto L6;
        r5.u();
        return;
    }
}
