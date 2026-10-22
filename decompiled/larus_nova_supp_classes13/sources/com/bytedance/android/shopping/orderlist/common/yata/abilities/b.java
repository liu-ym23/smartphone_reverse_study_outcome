package com.bytedance.android.shopping.orderlist.common.yata.abilities;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Context f;
    public final String g;
    public final Function0<PageFinder> h;

    public b(Context r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(OrderCommonApi.API_HOST, "apiHost");
        Intrinsics.checkNotNullParameter(r4, "pageFinderMethod");
        this.f = r3;
        this.g = OrderCommonApi.API_HOST;
        this.h = r4;
        this.a = LazyKt.lazy(new OrderCommonYataAbilityManager$confirmAbility$2(this));
        this.b = LazyKt.lazy(OrderCommonYataAbilityManager$errorHandler$2.INSTANCE);
        this.c = LazyKt.lazy(new OrderCommonYataAbilityManager$openSchemaAbility$2(this));
        this.d = LazyKt.lazy(OrderCommonYataAbilityManager$toastAbility$2.INSTANCE);
        this.e = LazyKt.lazy(new OrderCommonYataAbilityManager$networkAbility$2(this));
    }
}
