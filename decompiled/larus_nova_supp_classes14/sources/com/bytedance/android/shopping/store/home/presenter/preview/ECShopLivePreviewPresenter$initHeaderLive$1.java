package com.bytedance.android.shopping.store.home.presenter.preview;

import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/ec/adapter/api/player/IECLivePlayerClient;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECShopLivePreviewPresenter$initHeaderLive$1 extends Lambda implements Function0<IECLivePlayerClient> {
    final /* synthetic */ StoreV3LiveRoomVO $liveInfo;
    final /* synthetic */ ECShopLivePreviewPresenter this$0;

    public ECShopLivePreviewPresenter$initHeaderLive$1(ECShopLivePreviewPresenter r1, StoreV3LiveRoomVO r2) {
        this.this$0 = r1;
        this.$liveInfo = r2;
        super(0);
    }

    public final IECLivePlayerClient invoke() {
        ECShopLivePreviewPresenter r0 = this.this$0;
        StoreV3LiveRoomVO r1 = this.$liveInfo;
        int r2 = ECShopLivePreviewPresenter.D;
        le.b r3 = r0.m0(r1);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m167invoke() {
        return invoke();
    }
}
