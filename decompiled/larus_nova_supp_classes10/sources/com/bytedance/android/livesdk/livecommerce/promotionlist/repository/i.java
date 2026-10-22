package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i {
    public final tj2.c a;
    public final Function3<List<String>, Boolean, UpdateLocalViewType, Unit> b;

    public i(tj2.b r2, Function3 r3) {
        Intrinsics.checkNotNullParameter(r2, "localDataSource");
        Intrinsics.checkNotNullParameter(r3, "notifyDataChangedCallback");
        this.b = r3;
        this.a = r2.k();
    }
}
