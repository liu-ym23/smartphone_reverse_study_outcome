package com.larus.common.venue.api;

import android.app.Activity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q97.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J>\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H&J%\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/larus/common/venue/api/IFlowCommonVenueService;", "", "onApplyPocket", "", "ownerActivity", "Landroid/app/Activity;", "data", "", "", "extra", "getPocketPageData", "bizScene", "", "(Ljava/lang/Integer;)Ljava/util/Map;", "preloadPocketData", "(Ljava/lang/Integer;)V", "getCommonVenueRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowCommonVenueService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f326466a = null;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J&\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¢\u0006\u0002\u0010\fJ?\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0096\u0001J\u0018\u0010\u0013\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/common/venue/api/IFlowCommonVenueService$Companion;", "Lcom/larus/common/venue/api/IFlowCommonVenueService;", "<init>", "()V", "getCommonVenueRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "getPocketPageData", "", "", "", "bizScene", "", "(Ljava/lang/Integer;)Ljava/util/Map;", "onApplyPocket", "", "ownerActivity", "Landroid/app/Activity;", "data", "extra", "preloadPocketData", "(Ljava/lang/Integer;)V", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IFlowCommonVenueService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f326467c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IFlowCommonVenueService f326468b;

        static {
            f326467c = new Companion();
        }

        @Override // com.larus.common.venue.api.IFlowCommonVenueService
        public final void b(Activity r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r102, "extra");
            this.f326468b.b(r100, r101, r102);
        }

        @Override // com.larus.common.venue.api.IFlowCommonVenueService
        public final a c() {
            return this.f326468b.c();
        }

        @Override // com.larus.common.venue.api.IFlowCommonVenueService
        public final Map<String, Object> d(Integer r100) {
            return this.f326468b.d(r100);
        }

        @Override // com.larus.common.venue.api.IFlowCommonVenueService
        public final void e(Integer r100) {
            this.f326468b.e(r100);
        }

        private Companion() {
            IFlowCommonVenueService r100 = (IFlowCommonVenueService) ServiceManager.get().getService(IFlowCommonVenueService.class);
            if (r100 != null) goto L5;
            r100 = new FlowCommonVenueServiceNoop();
        L5:
            this.f326468b = r100;
        }
    }

    static {
        f326466a = Companion.f326467c;
    }

    void b(Activity r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102);

    a c();

    Map<String, Object> d(Integer r100);

    void e(Integer r100);
}
