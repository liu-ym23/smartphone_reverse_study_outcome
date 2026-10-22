package com.ivy.ivykit.api.plugin;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyPageService;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IIvyPageService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278336a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyPageService$Companion;", "Lcom/ivy/ivykit/api/plugin/IIvyPageService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IIvyPageService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278337b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IIvyPageService> f278338c = null;

        private Companion() {
        }

        static {
            f278337b = new Companion();
            f278338c = LazyKt.lazy(IIvyPageService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyPageService
        public final Fragment a(Activity r100, String r101, com.bytedance.ai.applet.page.a r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "schema");
            Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
            IIvyPageService r103 = f278338c.getValue();
            if (r103 != null) goto L7;
            return null;
        L7:
            return r103.a(r100, r101, r102);
        }
    }

    public interface a {
        void a(Integer r100, String r101);

        void onDestroy();

        void onLoadSuccess();

        void onTimingSetup(Map<String, Object> r100);
    }

    static {
        f278336a = Companion.f278337b;
    }

    Fragment a(Activity r100, String r101, com.bytedance.ai.applet.page.a r102);
}
