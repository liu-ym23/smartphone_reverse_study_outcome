package com.ivy.ivykit.api.plugin;

import com.lynx.tasm.LynxViewBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyHybridMonitorService;", "", "Companion", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IIvyHybridMonitorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278327a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyHybridMonitorService$Companion;", "Lcom/ivy/ivykit/api/plugin/IIvyHybridMonitorService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IIvyHybridMonitorService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278328b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IIvyHybridMonitorService> f278329c = null;

        private Companion() {
        }

        static {
            f278328b = new Companion();
            f278329c = LazyKt.lazy(IIvyHybridMonitorService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyHybridMonitorService
        public final a a() {
            IIvyHybridMonitorService r100 = f278329c.getValue();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.a();
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyHybridMonitorService
        public final JSONObject b(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            IIvyHybridMonitorService r101 = f278329c.getValue();
            if (r101 == null) goto L9;
            JSONObject r102 = r101.b(r100);
            if (r102 != null) goto L8;
            return r100;
        L8:
            return r102;
        L9:
            return r100;
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyHybridMonitorService
        public final b c(LynxViewBuilder r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            IIvyHybridMonitorService r101 = f278329c.getValue();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.c(r100);
        }
    }

    static {
        f278327a = Companion.f278328b;
    }

    a a();

    JSONObject b(JSONObject r100);

    b c(LynxViewBuilder r100);
}
