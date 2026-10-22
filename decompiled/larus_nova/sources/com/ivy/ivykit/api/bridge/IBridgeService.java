package com.ivy.ivykit.api.bridge;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/api/bridge/IBridgeService;", "", "Companion", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IBridgeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278293a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/bridge/IBridgeService$Companion;", "Lcom/ivy/ivykit/api/bridge/IBridgeService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IBridgeService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278294b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IBridgeService> f278295c = null;

        private Companion() {
        }

        static {
            f278294b = new Companion();
            f278295c = LazyKt.lazy(IBridgeService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.bridge.IBridgeService
        public final void a(a r100) {
            Intrinsics.checkNotNullParameter(r100, "bridgeConfig");
            IBridgeService r101 = f278295c.getValue();
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.bridge.IBridgeService
        public final <T> void b(T r100) {
            IBridgeService r101 = f278295c.getValue();
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.bridge.IBridgeService
        public final void c(Class<? extends IvyBridgeMethod> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            IBridgeService r101 = f278295c.getValue();
            if (r101 == null) goto L6;
            r101.c(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.bridge.IBridgeService
        public final void d(com.bytedance.ai.monitor.a r100) {
            IBridgeService r101 = f278295c.getValue();
            if (r101 == null) goto L6;
            r101.d(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.bridge.IBridgeService
        public final <T> void e(Class<? extends T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            IBridgeService r101 = f278295c.getValue();
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }
    }

    static {
        f278293a = Companion.f278294b;
    }

    void a(a r100);

    <T> void b(T r100);

    void c(Class<? extends IvyBridgeMethod> r100);

    void d(com.bytedance.ai.monitor.a r100);

    <T> void e(Class<? extends T> r100);
}
