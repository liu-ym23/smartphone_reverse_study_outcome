package com.bytedance.android.shopping.store.tabkit.container;

import android.net.Uri;
import com.bytedance.android.shopping.store.home.ECStoreTabKitFragment;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ TabKitCompactActivity a;
    public final /* synthetic */ ECStoreParam b;
    public final /* synthetic */ Uri c;

    public f(TabKitCompactActivity r1, ECStoreParam r2, Uri r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        ECStorePreloadInfoResponse r5 = (ECStorePreloadInfoResponse) r4;
        ECStoreTabKitFragment.a r6 = ECStoreTabKitFragment.s;
        ECStoreParam r0 = this.b;
        Uri r1 = this.c;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "storeParam");
        ECStoreTabKitFragment r2 = new ECStoreTabKitFragment();
        r6.getClass();
        r2.setArguments(ECStoreTabKitFragment.a.a(r0, r1));
        TabKitCompactActivity r7 = this.a;
        int r3 = TabKitCompactActivity.b;
        r7.y1(r2);
        this.a.a = r2;
    }
}
