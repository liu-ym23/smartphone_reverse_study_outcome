package f25;

import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import k25.d1;
import k25.e0;
import k25.m0;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s implements tb5.h<OfflineTransferModel>, vv4.e {
    public static long j = 2621440;
    public final String a;
    public final boolean b;
    public final Executor c;
    public final vv4.k d;
    public final d1 e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public String i;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    @Override // vv4.e
    public final void a(String r1) {
        this.i = r1;
    }

    public s(boolean r4, vv4.k r5) {
        this.a = "SetDataHandler";
        this.e = new d1();
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r0 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r0, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("mock_set_data_error_mock", "key");
        this.h = r0.getInt("mock_set_data_error_mock", 0);
        this.b = r4;
        this.d = r5;
        com.bytedance.ee.bear.appsetting.c r6 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.f = r6.g("ccm.mobile.offline_data_manager_full_limit_query_enable");
        this.g = idb.f.a().isEnable("ccm.mobile.db_error_optimization");
        if (r4 == false) goto L5;
        this.a = "SetDataHandler_RN";
    L5:
        OfflineCacheConfig r7 = (OfflineCacheConfig) r6.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        if (r7 == null) goto L8;
        j = r7.getSingle_doc_max_length();
    L8:
        this.c = e0.r();
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r10, final tb5.m r11) {
        final OfflineTransferModel r12 = (OfflineTransferModel) r10;
        final long r5 = System.currentTimeMillis();
        if (r12 == null) goto L41;
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
        if (TextUtils.isEmpty(r2) == true) goto L19;
        if (r2.length() <= j) goto L19;
        iu5.d.a(this.a, new Throwable("data length: " + r2.length() + "  " + du5.b.g(r12.getObjToken()) + "  " + r12.getKey()));
    L19:
        if (r12.isCheckError() == false) goto L31;
        vv4.k r3 = this.d;
        if (r3 == null) goto L31;
        if ((r3.getWebView() instanceof DocBridgeWebViewV2) == false) goto L31;
        String r4 = ((DocBridgeWebViewV2) this.d.getWebView()).getObjToken();
        if (TextUtils.isEmpty(r4) == true) goto L31;
        if (TextUtils.isEmpty(r12.getObjToken()) == true) goto L31;
        boolean r6 = s1.n;
        String r7 = r12.getKey();
        boolean r8 = !TextUtils.equals(r4, r12.getObjToken());
        s1.G = r8;
        s1.H = r7;
        if (r8 == false) goto L31;
        s1.F++;
    L31:
        final m0 r9 = r12.parseResourceData();
        if (r9 == null) goto L41;
        if (TextUtils.isEmpty(r9.k) == true) goto L41;
        if (TextUtils.isEmpty(r9.b) == true) goto L41;
        if (r12.isCheckError() == false) goto L40;
        s1.I++;
    L40:
        Flowable.just("").observeOn(Schedulers.from(this.c)).subscribe(new o(this, r9, r11, r12, r5), new p(this, r12, r11));
        return;
    L8:
        if (Objects.equals(r12.getIframeJsbCheck(), this.i) == true) goto L10;
        tt5.a.k(this.a, "jsb check failed");
        r1 = false;
    L41:
        tt5.a.k(this.a, "SetDataHandler.handle:data is null");
        d25.d.g("data is null", r11);
    }
}
