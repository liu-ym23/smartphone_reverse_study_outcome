package com.bytedance.android.shopping.mall.feed;

import android.util.LruCache;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedDataReuseConfig;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedDataReuseHelper {
    public static final Lazy a = null;
    public static final HashMap<String, LruCache<ECHybridListItemDTO, ECHybridListItemVO>> b = null;

    public static ECMallFeedDataReuseConfig a() {
        return (ECMallFeedDataReuseConfig) a.getValue();
    }

    static {
        a = LazyKt.lazy(ECMallFeedDataReuseHelper$reuseConfig$2.INSTANCE);
        b = new HashMap();
    }

    public static void b(final String r5, final String r6) {
        if (r5 == null) goto L33;
        boolean r1 = false;
        if (r5.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        Integer r3 = null;
        if (r0 == false) goto L10;
        String r2 = r5;
    L11:
        if (r2 == null) goto L36;
        Integer r4 = a().getMaxSize();
        if (r4 != null) goto L16;
        return;
    L16:
        if (r4.intValue() <= 0) goto L18;
        r1 = true;
    L18:
        if (r1 == false) goto L20;
        r3 = r4;
    L20:
        if (r3 == null) goto L35;
        final int r7 = r3.intValue();
        List<String> r8 = a().getEnabledPages();
        if (r8 != null) goto L24;
    L30:
        kk.d.c(new ECMallFeedDataReuseHelper$writeUnexposedDataToDiskCache$2(r5, r6, r7));
        return;
    L24:
        if ((!r8.isEmpty()) != true) goto L30;
        List<String> r9 = a().getEnabledPages();
        if (r9 != null) goto L28;
        return;
    L28:
        if (r9.contains(r5) == true) goto L30;
        return;
    L35:
        return;
    L36:
        return;
    L10:
        r2 = null;
        goto L11
    L6:
        r0 = false;
        goto L7
    }
}
