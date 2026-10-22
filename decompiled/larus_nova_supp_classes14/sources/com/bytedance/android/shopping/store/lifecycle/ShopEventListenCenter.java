package com.bytedance.android.shopping.store.lifecycle;

import android.view.WindowManager;
import com.bytedance.android.ec.store.api.IShopEventListener;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopEventListenCenter implements IShopEventListener {
    public static final Lazy a = null;
    public static final ShopEventListenCenter b = null;

    public ShopEventListenCenter() {
    }

    public static ConcurrentHashMap a() {
        return (ConcurrentHashMap) a.getValue();
    }

    static {
        b = new ShopEventListenCenter();
        a = LazyKt.lazy(ShopEventListenCenter$listeners$2.INSTANCE);
    }

    public final void onDestroy() {
        Iterator r0 = a().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IShopEventListener) r0.next()).onDestroy();
        goto L4
    }

    public final void onPause(String r3) {
        Iterator r0 = a().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IShopEventListener) r0.next()).onPause(r3);
        goto L4
    }

    public final void onResume(String r3) {
        Iterator r0 = a().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IShopEventListener) r0.next()).onResume(r3);
        goto L4
    }

    public final void onShow(WindowManager r3) {
        Iterator r0 = a().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IShopEventListener) r0.next()).onShow(r3);
        goto L4
    }
}
