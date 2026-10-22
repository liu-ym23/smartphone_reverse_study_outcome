package com.larus.uaigc.service;

import android.app.Activity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H¦@¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J>\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H&J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0013"}, d2 = {"Lcom/larus/uaigc/service/ICreationSpringVenueService;", "", "getCacheOrFetchSpringPocketData", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preFetchSpringPocketData", "", "startObservePollingConfig", "getSpringMainVenueRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "getWorldCupMainRouterInterceptor", "onApplyPocket", "ownerActivity", "Landroid/app/Activity;", "data", "extra", "onPopNativePage", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationSpringVenueService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373934a = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0096A¢\u0006\u0002\u0010\bJ\u000b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001J?\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0096\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u0010\u0013\u001a\u00020\rH\u0096\u0001J\t\u0010\u0014\u001a\u00020\rH\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/larus/uaigc/service/ICreationSpringVenueService$Companion;", "Lcom/larus/uaigc/service/ICreationSpringVenueService;", "<init>", "()V", "getCacheOrFetchSpringPocketData", "", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSpringMainVenueRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "getWorldCupMainRouterInterceptor", "onApplyPocket", "", "ownerActivity", "Landroid/app/Activity;", "data", "extra", "onPopNativePage", "preFetchSpringPocketData", "startObservePollingConfig", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationSpringVenueService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373935c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationSpringVenueService f373936b;

        static {
            f373935c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationSpringVenueService
        public final void b(Activity r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r102, "extra");
            this.f373936b.b(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.ICreationSpringVenueService
        public final q97.a d() {
            return this.f373936b.d();
        }

        @Override // com.larus.uaigc.service.ICreationSpringVenueService
        public final void f() {
            this.f373936b.f();
        }

        @Override // com.larus.uaigc.service.ICreationSpringVenueService
        public final q97.a k() {
            return this.f373936b.k();
        }

        @Override // com.larus.uaigc.service.ICreationSpringVenueService
        public final Object l(Continuation<? super Map<String, ? extends Object>> r100) {
            return this.f373936b.l(r100);
        }

        @Override // com.larus.uaigc.service.ICreationSpringVenueService
        public final void n() {
            this.f373936b.n();
        }

        @Override // com.larus.uaigc.service.ICreationSpringVenueService
        public final void r(Activity r100) {
            this.f373936b.r(r100);
        }

        private Companion() {
            ICreationSpringVenueService r100 = (ICreationSpringVenueService) ServiceManager.get().getService(ICreationSpringVenueService.class);
            if (r100 != null) goto L5;
            r100 = new ICreationSpringVenueServiceNoop();
        L5:
            this.f373936b = r100;
        }
    }

    static {
        f373934a = Companion.f373935c;
    }

    void b(Activity r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102);

    q97.a d();

    void f();

    q97.a k();

    Object l(Continuation<? super Map<String, ? extends Object>> r100);

    void n();

    void r(Activity r100);
}
