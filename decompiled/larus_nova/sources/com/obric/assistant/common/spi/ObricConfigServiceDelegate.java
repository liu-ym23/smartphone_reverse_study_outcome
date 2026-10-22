package com.obric.assistant.common.spi;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0096\u0001¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/common/spi/ObricConfigServiceDelegate;", "Lcom/obric/assistant/common/spi/IObricConfigService;", "<init>", "()V", "getCommonParams", "", "", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricConfigServiceDelegate implements IObricConfigService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricConfigServiceDelegate f387835b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricConfigService f387836a;

    static {
        f387835b = new ObricConfigServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.IObricConfigService
    public final Map<String, String> getCommonParams() {
        return this.f387836a.getCommonParams();
    }

    private ObricConfigServiceDelegate() {
        IObricConfigService r100 = (IObricConfigService) ServiceManager.get().getService(IObricConfigService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricConfigService();
    L5:
        this.f387836a = r100;
    }
}
