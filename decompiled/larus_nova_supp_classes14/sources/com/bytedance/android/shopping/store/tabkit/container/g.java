package com.bytedance.android.shopping.store.tabkit.container;

import android.net.Uri;
import com.bytedance.android.shopping.store.home.ECStoreTabKitFragment;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ TabKitCompactActivity a;
    public final /* synthetic */ ECStoreParam b;
    public final /* synthetic */ Uri c;

    public g(TabKitCompactActivity r1, ECStoreParam r2, Uri r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        TabKitCompactActivity r7 = this.a;
        ECStoreParam r0 = this.b;
        Uri r1 = this.c;
        int r2 = TabKitCompactActivity.b;
        r7.getClass();
        ECStoreTabKitFragment.a r3 = ECStoreTabKitFragment.s;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "storeParam");
        ECStoreTabKitFragment r4 = new ECStoreTabKitFragment();
        r3.getClass();
        r4.setArguments(ECStoreTabKitFragment.a.a(r0, r1));
        r7.y1(r4);
        r7.a = r4;
    }
}
