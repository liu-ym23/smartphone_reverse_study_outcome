package com.bytedance.android.shopping.store.tabkit.events;

import com.bytedance.android.ec.store.api.ITabKitEventListener;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabKitEventCenter {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(TabKitEventCenter$listeners$2.INSTANCE);
    }

    public static ITabKitEventListener a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        if ((!StringsKt.isBlank(r2)) == false) goto L5;
        String r0 = r2;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        return (ITabKitEventListener) ((ConcurrentHashMap) a.getValue()).get(r2);
    L5:
        r0 = null;
        goto L6
    }
}
