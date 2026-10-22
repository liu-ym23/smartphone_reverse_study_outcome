package com.larus.common.pollingconfig.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s09.a;
import s09.b;
import s09.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/larus/common/pollingconfig/api/PollingConfigService;", "Lcom/larus/common/pollingconfig/api/PollingConfigApi;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/common/pollingconfig/api/PollingConfigApi;", "impl$delegate", "Lkotlin/Lazy;", "init", "", "registerListener", "listener", "Lcom/larus/common/pollingconfig/api/PollingConfigListener;", "unregisterListener", "getConfigOrCache", "Lcom/larus/common/pollingconfig/api/PollingConfig;", "getConfigOrCacheByKey", "", "key", "getConfigOrNull", "getConfigOrNullByKey", "getCurrentTimeStamp", "", "()Ljava/lang/Long;", "compensationCallIfNeverSucceeded", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PollingConfigService implements PollingConfigApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PollingConfigService f326423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f326424b = null;

    private PollingConfigService() {
    }

    static {
        f326423a = new PollingConfigService();
        f326424b = LazyKt.lazy(new c());
    }

    public static PollingConfigApi a() {
        return (PollingConfigApi) f326424b.getValue();
    }

    @Override // com.larus.common.pollingconfig.api.PollingConfigApi
    public final String e() {
        Intrinsics.checkNotNullParameter("guide_show_config", "key");
        PollingConfigApi r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.e();
    }

    @Override // com.larus.common.pollingconfig.api.PollingConfigApi
    public final Long c() {
        PollingConfigApi r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    @Override // com.larus.common.pollingconfig.api.PollingConfigApi
    public final a d() {
        PollingConfigApi r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d();
    }

    @Override // com.larus.common.pollingconfig.api.PollingConfigApi
    public final void g() {
        PollingConfigApi r100 = a();
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // com.larus.common.pollingconfig.api.PollingConfigApi
    public final a h() {
        PollingConfigApi r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    @Override // com.larus.common.pollingconfig.api.PollingConfigApi
    public final void init() {
        PollingConfigApi r100 = a();
        if (r100 == null) goto L6;
        r100.init();
        return;
    }

    @Override // com.larus.common.pollingconfig.api.PollingConfigApi
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        PollingConfigApi r101 = a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f(r100);
    }

    @Override // com.larus.common.pollingconfig.api.PollingConfigApi
    public final void i(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        PollingConfigApi r101 = a();
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    @Override // com.larus.common.pollingconfig.api.PollingConfigApi
    public final void j(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        PollingConfigApi r101 = a();
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }
}
