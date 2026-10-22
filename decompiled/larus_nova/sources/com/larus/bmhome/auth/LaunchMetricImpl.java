package com.larus.bmhome.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/auth/LaunchMetricImpl;", "Lcom/larus/bmhome/auth/ILaunchMetricService;", "<init>", "()V", "report", "", "type", "", "stage", "success", "", "error", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchMetricImpl implements ILaunchMetricService {
    public LaunchMetricImpl() {
    }

    @Override // com.larus.bmhome.auth.ILaunchMetricService
    public final void a(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter("tourist_mode", "type");
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r102, "error");
        String r103 = b1.f295747b;
        b1.a("tourist_mode", r100, r101, r102);
    }
}
