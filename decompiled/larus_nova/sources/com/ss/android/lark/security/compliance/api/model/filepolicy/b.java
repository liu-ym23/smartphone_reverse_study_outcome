package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f440397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f440398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<PolicyModel> f440399c;

    public final c getContext() {
        return this.f440397a;
    }

    public final String getIdentifier() {
        return this.f440398b;
    }

    public b(c r100, String r101, List<PolicyModel> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r102, "policyModels");
        this.f440397a = r100;
        this.f440398b = r101;
        this.f440399c = r102;
    }
}
