package com.larus.extension.diversion.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0007"}, d2 = {"Lcom/larus/extension/diversion/api/DiversionConfigDelegate;", "Lcom/larus/extension/diversion/api/IDiversionConfig;", "<init>", "()V", "enableChatSettingDiversion", "", "enableNotSupportItemForDiversion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiversionConfigDelegate implements IDiversionConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DiversionConfigDelegate f342899b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDiversionConfig f342900a;

    static {
        f342899b = new DiversionConfigDelegate();
    }

    @Override // com.larus.extension.diversion.api.IDiversionConfig
    public final boolean a() {
        return this.f342900a.a();
    }

    private DiversionConfigDelegate() {
        IDiversionConfig r100 = (IDiversionConfig) ServiceManager.get().getService(IDiversionConfig.class);
        if (r100 != null) goto L5;
        r100 = new DiversionConfigNoop();
    L5:
        this.f342900a = r100;
    }
}
