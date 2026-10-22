package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0<T> implements Comparator<T> {
    public a0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((ECPromotionInterationData) r1).getPriority()), Integer.valueOf(((ECPromotionInterationData) r2).getPriority()));
    }
}
