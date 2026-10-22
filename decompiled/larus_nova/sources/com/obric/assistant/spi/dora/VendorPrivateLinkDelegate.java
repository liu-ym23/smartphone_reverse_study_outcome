package com.obric.assistant.spi.dora;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/dora/VendorPrivateLinkDelegate;", "Lcom/obric/assistant/spi/dora/IObricVendorPrivateLinkService;", "<init>", "()V", "needActivePrivateLink", "", "refreshDeviceAsync", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VendorPrivateLinkDelegate implements IObricVendorPrivateLinkService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VendorPrivateLinkDelegate f392876b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricVendorPrivateLinkService f392877a;

    static {
        f392876b = new VendorPrivateLinkDelegate();
    }

    @Override // com.obric.assistant.spi.dora.IObricVendorPrivateLinkService
    public final boolean a() {
        return this.f392877a.a();
    }

    @Override // com.obric.assistant.spi.dora.IObricVendorPrivateLinkService
    public final void b() {
        this.f392877a.b();
    }

    private VendorPrivateLinkDelegate() {
        IObricVendorPrivateLinkService r100 = (IObricVendorPrivateLinkService) ServiceManager.get().getService(IObricVendorPrivateLinkService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultVendorPrivateLinkServiceImpl();
    L5:
        this.f392877a = r100;
    }
}
