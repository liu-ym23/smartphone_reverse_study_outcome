package com.obric.assistant.common.spi.security;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/obric/assistant/common/spi/security/ObricSecurityServiceDelegate;", "Lcom/obric/assistant/common/spi/security/IObricSecurityService;", "<init>", "()V", "disableReceiveText", "", "eraseLogWithTail", "", PlayerResolution.SDKKEY.ORIGIN, "getAdditionalEraseSensitiveKeys", "", "shouldEraseLog", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSecurityServiceDelegate implements IObricSecurityService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricSecurityServiceDelegate f387847b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricSecurityService f387848a;

    static {
        f387847b = new ObricSecurityServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.security.IObricSecurityService
    public final String a(String r100) {
        return this.f387848a.a(r100);
    }

    @Override // com.obric.assistant.common.spi.security.IObricSecurityService
    public final List<String> b() {
        return this.f387848a.b();
    }

    @Override // com.obric.assistant.common.spi.security.IObricSecurityService
    public final boolean c() {
        return this.f387848a.c();
    }

    private ObricSecurityServiceDelegate() {
        IObricSecurityService r100 = (IObricSecurityService) ServiceManager.get().getService(IObricSecurityService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultSecurityServiceImpl();
    L5:
        this.f387848a = r100;
    }
}
