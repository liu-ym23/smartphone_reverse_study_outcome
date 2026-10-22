package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements di2.a {
    public final LivePromotionListViewModel a;

    @Override // di2.a
    public final String getRoomId() {
        return this.a.getParams().getRoomId();
    }

    public b(LivePromotionListViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }
}
