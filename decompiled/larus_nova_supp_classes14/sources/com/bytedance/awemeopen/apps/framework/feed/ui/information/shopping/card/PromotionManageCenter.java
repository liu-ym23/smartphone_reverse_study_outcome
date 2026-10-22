package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PromotionManageCenter {
    public static final long a = 0;
    public static final HashMap<String, List<DetailPromotion>> b = null;
    public static final HashMap<String, Long> c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    static {
        a = ((Number) AoShoppingCardSettingsConfig.h.getValue()).longValue();
        b = new HashMap();
        c = new HashMap();
        d = LazyKt.lazy(PromotionManageCenter$shopService$2.INSTANCE);
        e = LazyKt.lazy(PromotionManageCenter$userInfoService$2.INSTANCE);
        f = LazyKt.lazy(PromotionManageCenter$ecomService$2.INSTANCE);
    }
}
