package com.ivy.ivykit.api.bridge;

import android.content.Context;
import com.lynx.tasm.LynxViewBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/api/bridge/IIvyLynxBridgeService;", "", "Companion", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IIvyLynxBridgeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278296a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/bridge/IIvyLynxBridgeService$Companion;", "Lcom/ivy/ivykit/api/bridge/IIvyLynxBridgeService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IIvyLynxBridgeService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278297b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IIvyLynxBridgeService> f278298c = null;

        private Companion() {
        }

        static {
            f278297b = new Companion();
            f278298c = LazyKt.lazy(IIvyLynxBridgeService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.bridge.IIvyLynxBridgeService
        public final g a(Context r100, String r101, String r102, LynxViewBuilder r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "containerId");
            Intrinsics.checkNotNullParameter(r102, "bid");
            Intrinsics.checkNotNullParameter(r103, "builder");
            IIvyLynxBridgeService r104 = f278298c.getValue();
            if (r104 != null) goto L7;
            return null;
        L7:
            return r104.a(r100, r101, r102, r103);
        }
    }

    static {
        f278296a = Companion.f278297b;
    }

    g a(Context r100, String r101, String r102, LynxViewBuilder r103);
}
