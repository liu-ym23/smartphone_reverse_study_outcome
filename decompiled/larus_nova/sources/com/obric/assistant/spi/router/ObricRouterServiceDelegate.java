package com.obric.assistant.spi.router;

import android.net.Uri;
import android.os.Bundle;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u001b\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/obric/assistant/spi/router/ObricRouterServiceDelegate;", "Lcom/obric/assistant/spi/router/IObricRouterService;", "<init>", "()V", "addAllRouterInterceptor", "", "deeplinkQueryDisabled", "putDeeplinkQueryParams", "", "bundle", "Landroid/os/Bundle;", "uri", "Landroid/net/Uri;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRouterServiceDelegate implements IObricRouterService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricRouterServiceDelegate f392907b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricRouterService f392908a;

    static {
        f392907b = new ObricRouterServiceDelegate();
    }

    @Override // com.obric.assistant.spi.router.IObricRouterService
    public final boolean a() {
        return this.f392908a.a();
    }

    @Override // com.obric.assistant.spi.router.IObricRouterService
    public final void b(Bundle r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        this.f392908a.b(r100, r101);
    }

    @Override // com.obric.assistant.spi.router.IObricRouterService
    public final boolean c() {
        return this.f392908a.c();
    }

    private ObricRouterServiceDelegate() {
        IObricRouterService r100 = (IObricRouterService) ServiceManager.get().getService(IObricRouterService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultRouterServiceImpl();
    L5:
        this.f392908a = r100;
    }
}
