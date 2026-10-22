package n35;

import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import k25.d1;
import k25.e0;
import k25.m0;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m implements tb5.h<OfflineTransferModel> {
    public static int h;
    public final String a;
    public final String b;
    public final Executor c;
    public final d1 d;
    public final int e;
    public final boolean f;
    public final boolean g;

    public static final class a {
    }

    static {
        h = 2621440;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final BridgeAuthType authType() {
        return BridgeAuthType.Private;
    }

    public m(String r4) {
        this.a = r4;
        this.b = "Office_SetDataHandler";
        this.d = new d1();
        com.bytedance.ee.bear.appsetting.c r5 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.f = r5.g("ccm.mobile.offline_data_manager_full_limit_query_enable");
        this.g = idb.f.a().isEnable("ccm.mobile.db_error_optimization");
        OfflineCacheConfig r6 = (OfflineCacheConfig) r5.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        if (r6 == null) goto L5;
        h = r6.getSingle_doc_max_length();
    L5:
        this.c = e0.r();
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r7 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r7, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("mock_set_data_error_mock", "key");
        this.e = r7.getInt("mock_set_data_error_mock", 0);
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r10, tb5.m r11) {
        OfflineTransferModel r12 = (OfflineTransferModel) r10;
        long r5 = System.currentTimeMillis();
        if (r12 == null) goto L28;
        Lazy r0 = FGDowngradeHelper.a;
        if (FGDowngradeHelper.c() == false) goto L8;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        d25.d.g("data is invalid", r11);
        return;
    L13:
        String r2 = r12.getData();
        if (TextUtils.isEmpty(r2) == false) goto L16;
    L18:
        m0 r3 = r12.parseResourceData();
        if (r3 == null) goto L28;
        if (TextUtils.isEmpty(r3.k) == true) goto L28;
        if (TextUtils.isEmpty(r3.b) == true) goto L28;
        if (r12.isCheckError() == false) goto L27;
        AtomicBoolean r4 = a05.c.r;
    L27:
        Flowable.just("").observeOn(Schedulers.from(this.c)).subscribe(new p(this, r3, r11, r12, r5), new q(r12, r11, this));
        return;
    L16:
        if (r2.length() <= h) goto L18;
        iu5.d.a(this.b, new Throwable("data length: " + r2.length() + "  " + du5.b.g(r12.getObjToken()) + "  " + r12.getKey()));
        goto L18
    L8:
        if (Objects.equals(r12.getIframeJsbCheck(), this.a) == true) goto L10;
        tt5.a.k(this.b, "jsb check failed");
        r1 = false;
    L28:
        tt5.a.k(this.b, "SetDataHandler.handle:data is null");
        d25.d.g("data is null", r11);
    }
}
