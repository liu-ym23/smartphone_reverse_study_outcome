package com.larus.enterprise.impl.apptheme.repo;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.m4;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.n0;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class ThemeConfigRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f342472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f342473b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f342474c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/enterprise/impl/apptheme/repo/ThemeConfigRepo$RequestState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "IN_FLIGHT", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RequestState extends Enum<RequestState> {
        public static final RequestState IDLE = null;
        public static final RequestState IN_FLIGHT = null;
        public static final RequestState SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestState[] f342475a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f342476b = null;

        public static EnumEntries<RequestState> getEntries() {
            return f342476b;
        }

        static {
            RequestState r100 = new RequestState("IDLE", 0);
            IDLE = r100;
            RequestState r101 = new RequestState("IN_FLIGHT", 1);
            IN_FLIGHT = r101;
            RequestState r102 = new RequestState("SUCCESS", 2);
            SUCCESS = r102;
            RequestState[] r103 = {r100, r101, r102};
            f342475a = r103;
            f342476b = EnumEntriesKt.enumEntries(r103);
        }

        public static RequestState[] values() {
            return (RequestState[]) f342475a.clone();
        }

        public static RequestState valueOf(String r100) {
            return (RequestState) r27.a.a(RequestState.class, r100);
        }

        public RequestState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            ThemeConfigRepo.b().clear();
            ThemeConfigRepo.c().clear();
        }
    }

    public static final class b implements m4 {
        public b() {
        }

        @Override // com.larus.platform.api.m4
        public final void S1() {
            ThemeConfigRepo.b().clear();
            ThemeConfigRepo.c().clear();
        }

        @Override // com.larus.platform.api.m4
        public final void b1() {
            ThemeConfigRepo.b().clear();
            ThemeConfigRepo.c().clear();
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z89.c f342477a;

        public c(z89.c r100) {
            this.f342477a = r100;
        }
    }

    static {
        f342472a = LazyKt.lazy(new com.larus.enterprise.impl.apptheme.repo.c());
        f342473b = LazyKt.lazy(new d());
        f342474c = LazyKt.lazy(new e());
        AccountService r100 = AccountService.f365697a;
        r100.E(new a());
        r100.H(new b());
    }

    public static ConcurrentHashMap b() {
        return (ConcurrentHashMap) f342473b.getValue();
    }

    public static ConcurrentHashMap c() {
        return (ConcurrentHashMap) f342474c.getValue();
    }

    public static c a(String r100) {
        c r101 = (c) b().get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        c r102 = new c(d(r100));
        c r103 = (c) b().putIfAbsent(r100, r102);
        if (r103 != null) goto L9;
        return r102;
    L9:
        return r103;
    }

    public static z89.c d(String r100) {
        Keva r101 = Keva.getRepo("repo_name_theme_config_".concat(AccountService.f365697a.getUserId()), 0);
        String r102 = "theme_config_" + r100;
        if (r101 == null) goto L5;
        String r103 = r101.getString(r102, "");
    L6:
        z89.c r104 = (z89.c) GsonProtectorUtils.fromJson((Gson) f342472a.getValue(), r103, z89.c.class);
        if (r104 == null) goto L10;
        return r104;
    L10:
        return com.larus.enterprise.impl.apptheme.repo.b.a();
    L5:
        r103 = null;
        goto L6
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        AtomicReference r101 = (AtomicReference) c().get(r100);
        if (r101 != null) goto L9;
        r101 = new AtomicReference(RequestState.IDLE);
        AtomicReference r102 = (AtomicReference) c().putIfAbsent(r100, r101);
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        FLogger r103 = FLogger.f375446a;
        r103.d("ThemeConfigRepo", "requestThemeConfig: start");
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L14;
        r103.d("ThemeConfigRepo", "requestThemeConfig: network not available");
        return;
    L14:
        if (n0.f365775a.b() == true) goto L18;
        r103.d("ThemeConfigRepo", "requestThemeConfig: account not in enterprise mode");
        return;
    L18:
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L21;
        r103.d("ThemeConfigRepo", "requestThemeConfig: account not login");
        return;
    L21:
        RequestState r104 = (RequestState) r101.get();
        RequestState r105 = RequestState.IN_FLIGHT;
        if (r104 != r105) goto L26;
        r103.d("ThemeConfigRepo", "requestThemeConfig: already in-flight");
        return;
    L26:
        if (r104 != RequestState.SUCCESS) goto L29;
        r103.d("ThemeConfigRepo", "requestThemeConfig: already success");
        return;
    L29:
        RequestState r106 = RequestState.IDLE;
    L31:
        if (r101.compareAndSet(r106, r105) == true) goto L32;
        if (r101.get() == r106) goto L31;
        boolean r107 = false;
    L36:
        if (r107 == true) goto L38;
        return;
    L38:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ThemeConfigRepo$requestThemeConfig$1(r100, r101, null), 3, null);
        return;
    L32:
        r107 = true;
        goto L36
    }
}
