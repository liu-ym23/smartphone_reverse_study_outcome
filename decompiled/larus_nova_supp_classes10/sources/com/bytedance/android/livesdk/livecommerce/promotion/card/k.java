package com.bytedance.android.livesdk.livecommerce.promotion.card;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements Iterable<Map.Entry<? extends PromotionCardModuleName, ? extends IPromotionUIConfig.d>>, KMappedMarker {
    public final Map<PromotionCardModuleName, IPromotionUIConfig.d> a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof k) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((k) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<PromotionCardModuleName, IPromotionUIConfig.d> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "UIConfigModel(config=" + this.a + ")";
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<? extends PromotionCardModuleName, ? extends IPromotionUIConfig.d>> iterator() {
        return this.a.entrySet().iterator();
    }

    public k(Map<PromotionCardModuleName, IPromotionUIConfig.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
    }

    public final IPromotionUIConfig.d a(PromotionCardModuleName r2) {
        Intrinsics.checkNotNullParameter(r2, "module");
        return this.a.get(r2);
    }
}
