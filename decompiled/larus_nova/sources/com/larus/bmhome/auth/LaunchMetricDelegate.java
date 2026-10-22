package com.larus.bmhome.auth;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/auth/LaunchMetricDelegate;", "Lcom/larus/bmhome/auth/ILaunchMetricService;", "<init>", "()V", "report", "", "type", "", "stage", "success", "", "error", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchMetricDelegate implements ILaunchMetricService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LaunchMetricDelegate f295730b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILaunchMetricService f295731a;

    static {
        f295730b = new LaunchMetricDelegate();
    }

    @Override // com.larus.bmhome.auth.ILaunchMetricService
    public final void a(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter("tourist_mode", "type");
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r102, "error");
        this.f295731a.a(r100, r101, r102);
    }

    private LaunchMetricDelegate() {
        ILaunchMetricService r100 = (ILaunchMetricService) ServiceManager.get().getService(ILaunchMetricService.class);
        if (r100 != null) goto L5;
        r100 = new LaunchMetricServiceNoop();
    L5:
        this.f295731a = r100;
    }
}
