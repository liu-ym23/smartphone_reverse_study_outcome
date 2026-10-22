package com.ivy.ivykit.api.bridge;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/api/bridge/IBridgeMethodService;", "", "Companion", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IBridgeMethodService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278290a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/bridge/IBridgeMethodService$Companion;", "Lcom/ivy/ivykit/api/bridge/IBridgeMethodService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IBridgeMethodService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278291b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IBridgeMethodService> f278292c = null;

        private Companion() {
        }

        static {
            f278291b = new Companion();
            f278292c = LazyKt.lazy(IBridgeMethodService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.bridge.IBridgeMethodService
        public final bx7.b a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "methodName");
            IBridgeMethodService r101 = f278292c.getValue();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.a(r100);
        }
    }

    static {
        f278290a = Companion.f278291b;
    }

    bx7.b a(String r100);
}
