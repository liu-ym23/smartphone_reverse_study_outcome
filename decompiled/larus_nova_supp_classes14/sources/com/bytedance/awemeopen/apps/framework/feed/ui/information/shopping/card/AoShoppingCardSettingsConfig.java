package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AoShoppingCardSettingsConfig {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;

    static {
        a = LazyKt.lazy(AoShoppingCardSettingsConfig$preloadDataWaitDuration$2.INSTANCE);
        b = LazyKt.lazy(AoShoppingCardSettingsConfig$enableChangeToDoubleLineStyle$2.INSTANCE);
        c = LazyKt.lazy(AoShoppingCardSettingsConfig$timeToChangeToDoubleLineStyle$2.INSTANCE);
        d = LazyKt.lazy(AoShoppingCardSettingsConfig$enableChangeToOneCommodityCardStyle$2.INSTANCE);
        e = LazyKt.lazy(AoShoppingCardSettingsConfig$enableChangeToMultiCommodityCardStyle$2.INSTANCE);
        f = LazyKt.lazy(AoShoppingCardSettingsConfig$timeToChangeToCommodityCardStyle$2.INSTANCE);
        g = LazyKt.lazy(AoShoppingCardSettingsConfig$timeToChangeToCommodityCardStyleSecond$2.INSTANCE);
        h = LazyKt.lazy(AoShoppingCardSettingsConfig$shopCommodityExpireDuration$2.INSTANCE);
        i = LazyKt.lazy(AoShoppingCardSettingsConfig$shopCommodityNoCache$2.INSTANCE);
        j = LazyKt.lazy(AoShoppingCardSettingsConfig$requestDetailPromotionEnterFrom$2.INSTANCE);
        k = LazyKt.lazy(AoShoppingCardSettingsConfig$enableStyleOptToutiao$2.INSTANCE);
        l = LazyKt.lazy(AoShoppingCardSettingsConfig$enableHostExpand$2.INSTANCE);
        m = LazyKt.lazy(AoShoppingCardSettingsConfig$fixKolId$2.INSTANCE);
    }

    public static boolean a() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public static boolean b() {
        return ((Boolean) e.getValue()).booleanValue();
    }

    public static boolean c() {
        return ((Boolean) d.getValue()).booleanValue();
    }
}
