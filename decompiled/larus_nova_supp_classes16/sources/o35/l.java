package o35;

import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.document.render.core.offline.datapage.OfflineTransferModelV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.Executor;
import k25.e0;
import kotlin.Lazy;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements tb5.h<OfflineTransferModelV2>, vv4.e {
    public static long d = 2621440;
    public final String a;
    public final Executor b;
    public String c;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public l(String r4) {
        this.a = "Office_SetDataHandlerV2";
        this.c = r4;
        OfflineCacheConfig r5 = (OfflineCacheConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        if (r5 == null) goto L5;
        d = r5.getSingle_doc_max_length();
    L5:
        this.b = e0.r();
    }

    @Override // vv4.e
    public final void a(String r1) {
        this.c = r1;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r9, final m r10) {
        final OfflineTransferModelV2 r11 = (OfflineTransferModelV2) r9;
        if (r11 != null) goto L5;
        tt5.a.k(this.a, "data is null.");
        g.c(0, r10, this.a);
        return;
    L5:
        Lazy r1 = FGDowngradeHelper.a;
        if (FGDowngradeHelper.c() == false) goto L9;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        g.c(0, r10, this.a);
        return;
    L14:
        final long r4 = System.currentTimeMillis();
        Flowable.just("").observeOn(Schedulers.from(this.b)).subscribe(new h(this, r11, r10, r4), new i(this, r11, r10));
        return;
    L9:
        if (Objects.equals(r11.getIframeJsbCheck(), this.c) == true) goto L11;
        tt5.a.k(this.a, "jsb check failed");
        r2 = false;
        goto L12
    }
}
