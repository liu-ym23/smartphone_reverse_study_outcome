package hu4;

import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineTransferModel;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import k25.e0;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements tb5.h<BitableOfflineTransferModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f487254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f487256c;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public i(boolean r100) {
        this.f487254a = r100;
        this.f487255b = "BitableSetDataHandler";
        this.f487256c = 2621440;
        if (r100 == false) goto L5;
        this.f487255b = "BitableSetDataHandler_RN";
    L5:
        OfflineCacheConfig r101 = (OfflineCacheConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        if (r101 == null) goto L9;
        this.f487256c = r101.getSingle_doc_max_length();
        return;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        Flowable.just((BitableOfflineTransferModel) r100).map(new e(this)).observeOn(Schedulers.from(e0.r())).map(new f(this)).subscribe(new g(r101, this), new h(r101, this));
    }
}
