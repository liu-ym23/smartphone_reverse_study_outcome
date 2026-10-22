package com.bytedance.android.livesdk.livecommerce.intro.controller;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECLifecycleOwnerAdapter;
import com.bytedance.android.livesdk.livecommerce.intro.auction.IntroAuctionViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements oh2.h {
    public final IntroAuctionViewModel a;
    public final ECLifecycleOwnerAdapter b;

    public final int modelType() {
        return 0;
    }

    @Override // oh2.h
    public final QViewModel a() {
        return this.a;
    }

    @Override // oh2.h
    public final LifecycleOwner getLifecycleOwner() {
        return this.b;
    }

    public d(IntroAuctionWidgetController r2) {
        this.a = r2.c;
        int r0 = g.a;
        this.b = g.b(r2.o);
    }
}
