package com.obric.sva.sdk.effectplatform;

import com.obric.sva.sdk.utils.LogUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectPlatformMonitor;", "Lcom/ss/ugc/effectplatform/monitor/IMonitorReport;", "<init>", "()V", "monitorStatusRate", "", "serviceName", "", "status", "", "logExtraMap", "", "", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EffectPlatformMonitor implements klc.a {
    public static final Companion Companion = null;
    public static final String TAG = "EffectPlatformMonitor";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectPlatformMonitor$Companion;", "", "<init>", "()V", "TAG", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EffectPlatformMonitor() {
    }

    @Override // klc.a
    public void monitorStatusRate(String r100, int r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        Intrinsics.checkNotNullParameter(r102, "logExtraMap");
        LogUtils.i(TAG, "monitorStatusRate " + r100 + ", " + MapsKt.toMutableMap(r102), new Object[0]);
    }
}
