package com.larus.bmhome.larkinput.api.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oq8.b;
import pq8.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/larkinput/api/service/LarkInputService;", "Lcom/larus/bmhome/larkinput/api/service/ILarkInputService;", "<init>", "()V", "createController", "Lcom/larus/bmhome/larkinput/api/service/ILarkInputController;", "config", "Lcom/larus/bmhome/larkinput/api/model/InlineTriggerConfig;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkInputService implements ILarkInputService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LarkInputService f312464b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILarkInputService f312465a;

    static {
        f312464b = new LarkInputService();
    }

    @Override // com.larus.bmhome.larkinput.api.service.ILarkInputService
    public final a a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return this.f312465a.a(r100);
    }

    private LarkInputService() {
        ILarkInputService r100 = (ILarkInputService) ServiceManager.get().getService(ILarkInputService.class);
        if (r100 != null) goto L5;
        r100 = new LarkInputServiceNoop();
    L5:
        this.f312465a = r100;
    }
}
