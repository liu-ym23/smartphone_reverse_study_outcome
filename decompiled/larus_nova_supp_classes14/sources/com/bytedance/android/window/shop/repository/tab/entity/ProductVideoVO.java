package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ProductVideoVO extends e {
    public static final /* synthetic */ int i = 0;
    public final Lazy f;
    public final double g;
    public final Long h;

    public static final class a {
        public static ProductVideoVO a(com.bytedance.android.window.shop.repository.dto.j r11) {
            ProductVideoVO r0 = null;
            if (r11 != null) goto L6;
            return null;
        L6:
            if (r11.a() != null) goto L8;
            return null;
        L8:
            Long r1 = r11.d();
            if (r1 == null) goto L15;
            r1.longValue();
            ECUrlModel r3 = r11.f();
            ECUrlModel r4 = r11.a();
            long r5 = r11.d().longValue();
            String r7 = r11.c();
            Double r2 = r11.b();
            if (r2 == null) goto L13;
            double r6 = r2.doubleValue();
        L14:
            r0 = new ProductVideoVO(r3, r4, r5, r7, r6, r11.e());
            goto L15
        L13:
            r6 = 1.0d;
        L15:
            return r0;
        }
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.e
    public final int modelType() {
        return 0;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.e
    public final float b() {
        if (this.a != null) goto L7;
        return RangesKt.coerceIn((float) this.g, 0.01f, 100.0f);
    L7:
        return super.b();
    }

    public ProductVideoVO(ECUrlModel r2, ECUrlModel r3, long r4, String r6, double r7, Long r9) {
        Intrinsics.checkNotNullParameter(r3, "cover");
        super(r2, r3, r4, r6);
        this.g = r7;
        this.h = r9;
        this.f = LazyKt.lazy(new ProductVideoVO$ecVideoModel$2(this));
    }
}
