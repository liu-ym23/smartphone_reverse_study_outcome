package com.ivy.ivykit.api.plugin;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyLynxRuntimeService;", "", "Companion", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IIvyLynxRuntimeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278333a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyLynxRuntimeService$Companion;", "Lcom/ivy/ivykit/api/plugin/IIvyLynxRuntimeService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IIvyLynxRuntimeService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278334b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IIvyLynxRuntimeService> f278335c = null;

        private Companion() {
        }

        static {
            f278334b = new Companion();
            f278335c = LazyKt.lazy(IIvyLynxRuntimeService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
        public final String getLanguage() {
            IIvyLynxRuntimeService r100 = f278335c.getValue();
            if (r100 == null) goto L7;
            String r101 = r100.getLanguage();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return Locale.getDefault().getLanguage();
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
        public final Map<String, Object> a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IIvyLynxRuntimeService r101 = f278335c.getValue();
            if (r101 == null) goto L5;
            Map<String, Object> r102 = r101.a(r100);
        L6:
            if (r102 == null) goto L8;
            return r102;
        L8:
            return MapsKt.emptyMap();
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
        public final Pair<Integer, Integer> b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IIvyLynxRuntimeService r101 = f278335c.getValue();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.b(r100);
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
        public final float c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IIvyLynxRuntimeService r101 = f278335c.getValue();
            if (r101 != null) goto L7;
            Resources r102 = r100.getResources();
            return WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        L7:
            return r101.c(r100);
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService
        public final int getStatusBarHeight(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IIvyLynxRuntimeService r101 = f278335c.getValue();
            if (r101 != null) goto L7;
            return 0;
        L7:
            return r101.getStatusBarHeight(r100);
        }
    }

    static {
        f278333a = Companion.f278334b;
    }

    Map<String, Object> a(Context r100);

    Pair<Integer, Integer> b(Context r100);

    float c(Context r100);

    String getLanguage();

    int getStatusBarHeight(Context r100);
}
