package com.bytedance.kmp.livesdk.gift.platform.service;

import com.bytedance.android.scope.o;
import com.bytedance.kmp.livesdk.gift.platform.service.interceptor.GiftMessageAssetInterceptor;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f252450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.kmp.livesdk.gift.platform.service.interceptor.b f252451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.kmp.livesdk.gift.platform.service.interceptor.a f252452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GiftMessageAssetInterceptor f252453d;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        List<Object> r100 = this.f252450a;
        ArrayList r101 = (ArrayList) r100;
        r101.add(this.f252451b);
        r101.add(this.f252452c);
        r101.add(this.f252453d);
    }

    public e(com.bytedance.kmp.livesdk.gift.platform.service.interceptor.b r100, com.bytedance.kmp.livesdk.gift.platform.service.interceptor.a r101, GiftMessageAssetInterceptor r102) {
        Intrinsics.checkNotNullParameter(r100, "localInterceptor");
        Intrinsics.checkNotNullParameter(r101, "giftInterceptor");
        Intrinsics.checkNotNullParameter(r102, "assetInterceptor");
        this.f252451b = r100;
        this.f252452c = r101;
        this.f252453d = r102;
        this.f252450a = new ArrayList();
    }
}
