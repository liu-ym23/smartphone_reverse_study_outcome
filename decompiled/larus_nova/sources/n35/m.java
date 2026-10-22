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

/* JADX INFO: loaded from: classes16.dex */
public final class m implements tb5.h<OfflineTransferModel> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f516954h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f516957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d1 f516958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f516959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f516960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f516961g;

    public static final class a {
    }

    static {
        f516954h = 2621440;
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final BridgeAuthType authType() {
        return BridgeAuthType.Private;
    }

    public m(String r100) {
        this.f516955a = r100;
        this.f516956b = "Office_SetDataHandler";
        this.f516958d = new d1();
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f516960f = r101.g("ccm.mobile.offline_data_manager_full_limit_query_enable");
        this.f516961g = idb.f.a().isEnable("ccm.mobile.db_error_optimization");
        OfflineCacheConfig r102 = (OfflineCacheConfig) r101.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        if (r102 == null) goto L5;
        f516954h = r102.getSingle_doc_max_length();
    L5:
        this.f516957c = e0.r();
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r103 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r103, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("mock_set_data_error_mock", "key");
        this.f516959e = r103.getInt("mock_set_data_error_mock", 0);
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r110, tb5.m r111) {
        OfflineTransferModel r112 = (OfflineTransferModel) r110;
        long r100 = System.currentTimeMillis();
        if (r112 == null) goto L28;
        Lazy r101 = FGDowngradeHelper.f216485a;
        if (FGDowngradeHelper.c() == false) goto L8;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        d25.d.g("data is invalid", r111);
        return;
    L13:
        String r103 = r112.getData();
        if (TextUtils.isEmpty(r103) == false) goto L16;
    L18:
        m0 r104 = r112.parseResourceData();
        if (r104 == null) goto L28;
        if (TextUtils.isEmpty(r104.f501550k) == true) goto L28;
        if (TextUtils.isEmpty(r104.f501541b) == true) goto L28;
        if (r112.isCheckError() == false) goto L27;
        AtomicBoolean r105 = a05.c.f1283r;
    L27:
        Flowable.just("").observeOn(Schedulers.from(this.f516957c)).subscribe(new p(this, r104, r111, r112, r100), new q(r112, r111, this));
        return;
    L16:
        if (r103.length() <= f516954h) goto L18;
        iu5.d.a(this.f516956b, new Throwable("data length: " + r103.length() + tb2.c.DEFAULT_TEXT + du5.b.g(r112.getObjToken()) + tb2.c.DEFAULT_TEXT + r112.getKey()));
        goto L18
    L8:
        if (Objects.equals(r112.getIframeJsbCheck(), this.f516955a) == true) goto L10;
        tt5.a.k(this.f516956b, "jsb check failed");
        r102 = false;
    L28:
        tt5.a.k(this.f516956b, "SetDataHandler.handle:data is null");
        d25.d.g("data is null", r111);
    }
}
