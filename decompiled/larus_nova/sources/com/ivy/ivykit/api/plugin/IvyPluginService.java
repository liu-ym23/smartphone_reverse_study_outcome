package com.ivy.ivykit.api.plugin;

import android.content.Context;
import com.larus.home.impl.sdk.b0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ub9.k;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IvyPluginService;", "", "Companion", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IvyPluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278342a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IvyPluginService$Companion;", "Lcom/ivy/ivykit/api/plugin/IvyPluginService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IvyPluginService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278343b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IvyPluginService> f278344c = null;

        private Companion() {
        }

        static {
            f278343b = new Companion();
            f278344c = LazyKt.lazy(IvyPluginService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.plugin.IvyPluginService
        public final boolean hasInit() {
            IvyPluginService r100 = f278344c.getValue();
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.hasInit() != true) goto L7;
            return true;
        }

        @Override // com.ivy.ivykit.api.plugin.IvyPluginService
        public final void b(jx7.a r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            IvyPluginService r101 = f278344c.getValue();
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.IvyPluginService
        public final void c(c r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginConfig");
            IvyPluginService r101 = f278344c.getValue();
            if (r101 == null) goto L6;
            r101.c(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.IvyPluginService
        public final kx7.b a(Context r100, String r101, ix7.c r110, ix7.d r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "templateUrl");
            IvyPluginService r102 = f278344c.getValue();
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.a(r100, r101, r110, r111, r112);
        }
    }

    public static final class a {
        public static /* synthetic */ kx7.b a(Companion r100, Context r101, String r110, k r111, b0.b r112, String r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            k r102 = null;
        L7:
            if ((r114 & 8) == 0) goto L9;
            b0.b r103 = null;
        L11:
            if ((r114 & 16) == 0) goto L13;
            String r104 = null;
        L15:
            return r100.a(r101, r110, r102, r103, r104);
        L13:
            r104 = r113;
            goto L15
        L9:
            r103 = r112;
            goto L11
        L5:
            r102 = r111;
            goto L7
        }
    }

    static {
        f278342a = Companion.f278343b;
    }

    kx7.b a(Context r100, String r101, ix7.c r102, ix7.d r103, String r104);

    void b(jx7.a r100);

    void c(c r100);

    boolean hasInit();
}
