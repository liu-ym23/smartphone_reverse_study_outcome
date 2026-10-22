package com.larus.enterprise.impl;

import com.larus.enterprise.api.IEnterpriseService;
import com.larus.enterprise.impl.apptheme.repo.ThemeConfigRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/enterprise/impl/EnterpriseServiceImpl;", "Lcom/larus/enterprise/api/IEnterpriseService;", "<init>", "()V", "isInEnterpriseMode", "", "requestThemeConfig", "", "scene", "", "createChatEnterpriseRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnterpriseServiceImpl implements IEnterpriseService {
    public EnterpriseServiceImpl() {
    }

    @Override // com.larus.enterprise.api.IEnterpriseService
    public final EnterpriseRouterInterceptor a() {
        return new EnterpriseRouterInterceptor();
    }

    @Override // com.larus.enterprise.api.IEnterpriseService
    public final boolean b() {
        return a.a();
    }

    @Override // com.larus.enterprise.api.IEnterpriseService
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ThemeConfigRepo.e(r100);
    }
}
