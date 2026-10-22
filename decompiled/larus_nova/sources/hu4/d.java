package hu4;

import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineTransferModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import k25.e0;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements tb5.h<BitableOfflineTransferModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487247a;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public d(boolean r100) {
        this.f487247a = "BitableGetDataHandler";
        if (r100 == false) goto L6;
        this.f487247a = "BitableGetDataHandler_RN";
        return;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        BitableOfflineTransferModel r102 = (BitableOfflineTransferModel) r100;
        Flowable.just(r102).observeOn(Schedulers.from(e0.r())).map(new a(r102, this, r101)).subscribe(b.f487244a, new c(r101, this));
    }
}
