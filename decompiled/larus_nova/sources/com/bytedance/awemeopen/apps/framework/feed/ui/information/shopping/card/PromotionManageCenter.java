package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class PromotionManageCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f196362a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, List<DetailPromotion>> f196363b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, Long> f196364c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f196365d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f196366e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f196367f = null;

    static {
        f196362a = ((Number) AoShoppingCardSettingsConfig.f196338h.getValue()).longValue();
        f196363b = new HashMap();
        f196364c = new HashMap();
        f196365d = LazyKt.lazy(PromotionManageCenter$shopService$2.INSTANCE);
        f196366e = LazyKt.lazy(PromotionManageCenter$userInfoService$2.INSTANCE);
        f196367f = LazyKt.lazy(PromotionManageCenter$ecomService$2.INSTANCE);
    }
}
