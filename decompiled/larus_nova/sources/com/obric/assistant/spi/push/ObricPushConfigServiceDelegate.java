package com.obric.assistant.spi.push;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/push/ObricPushConfigServiceDelegate;", "Lcom/obric/assistant/spi/push/IObricPushConfigService;", "<init>", "()V", "savePushToken", "", "token", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPushConfigServiceDelegate implements IObricPushConfigService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricPushConfigServiceDelegate f392905b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricPushConfigService f392906a;

    static {
        f392905b = new ObricPushConfigServiceDelegate();
    }

    @Override // com.obric.assistant.spi.push.IObricPushConfigService
    public final void a(String r100) {
        this.f392906a.a(r100);
    }

    private ObricPushConfigServiceDelegate() {
        IObricPushConfigService r100 = (IObricPushConfigService) ServiceManager.get().getService(IObricPushConfigService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricPushConfigServiceImpl();
    L5:
        this.f392906a = r100;
    }
}
