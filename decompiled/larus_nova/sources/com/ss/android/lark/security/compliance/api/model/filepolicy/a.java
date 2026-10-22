package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440396a;

    public final String getIdentifier() {
        return this.f440396a;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        this.f440396a = r100;
    }
}
