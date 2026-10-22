package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.model.response.IconItem;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Comparator<T> {
    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IconItem) r1).getPriority()), Integer.valueOf(((IconItem) r2).getPriority()));
    }
}
