package com.bytedance.kmp.livesdk.gift.platform.service;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.j;
import com.bytedance.android.scope.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public final class GiftRoomAssetService implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f252429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f252430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f252431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sc6.b f252432d;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public GiftRoomAssetService(j r100, g r101, sc6.b r102) {
        Intrinsics.checkNotNullParameter(r100, "assetService");
        Intrinsics.checkNotNullParameter(r101, "roomService");
        Intrinsics.checkNotNullParameter(r102, "giftListRoomRepository");
        this.f252430b = r100;
        this.f252431c = r101;
        this.f252432d = r102;
        this.f252429a = LazyKt.lazy(GiftRoomAssetService$enableSyncFullAssets$2.INSTANCE);
    }
}
