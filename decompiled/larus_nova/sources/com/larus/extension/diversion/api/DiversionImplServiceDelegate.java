package com.larus.extension.diversion.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¨\u0006\u0006"}, d2 = {"Lcom/larus/extension/diversion/api/DiversionImplServiceDelegate;", "Lcom/larus/extension/diversion/api/IDiversionImplService;", "<init>", "()V", "getNotSupportItemDiversionCard", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiversionImplServiceDelegate implements IDiversionImplService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DiversionImplServiceDelegate f342901b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDiversionImplService f342902a;

    static {
        f342901b = new DiversionImplServiceDelegate();
    }

    @Override // com.larus.extension.diversion.api.IDiversionImplService
    public final Object a() {
        return this.f342902a.a();
    }

    private DiversionImplServiceDelegate() {
        IDiversionImplService r100 = (IDiversionImplService) ServiceManager.get().getService(IDiversionImplService.class);
        if (r100 != null) goto L5;
        r100 = new DiversionImplServiceNoop();
    L5:
        this.f342902a = r100;
    }
}
