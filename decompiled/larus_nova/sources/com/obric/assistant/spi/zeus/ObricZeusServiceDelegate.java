package com.obric.assistant.spi.zeus;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/spi/zeus/ObricZeusServiceDelegate;", "Lcom/obric/assistant/spi/zeus/IObricZeusService;", "<init>", "()V", "getZeusPluginDebugInfo", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricZeusServiceDelegate implements IObricZeusService {
    public static final ObricZeusServiceDelegate INSTANCE = null;
    private final /* synthetic */ IObricZeusService $$delegate_0;

    static {
        INSTANCE = new ObricZeusServiceDelegate();
    }

    @Override // com.obric.assistant.spi.zeus.IObricZeusService
    public String getZeusPluginDebugInfo() {
        return this.$$delegate_0.getZeusPluginDebugInfo();
    }

    private ObricZeusServiceDelegate() {
        IObricZeusService r100 = (IObricZeusService) ServiceManager.get().getService(IObricZeusService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricZeusServiceImpl();
    L5:
        this.$$delegate_0 = r100;
    }
}
