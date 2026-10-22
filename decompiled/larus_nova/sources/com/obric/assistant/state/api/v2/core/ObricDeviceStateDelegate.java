package com.obric.assistant.state.api.v2.core;

import com.obric.assistant.interaction.impl.window.helpers.OverlayPermissionGuideActivity$screenStateListener$1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/ObricDeviceStateDelegate;", "Lcom/obric/assistant/state/api/v2/core/IObricDeviceStateService;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "listener", "Lcom/obric/assistant/state/api/v2/core/IObricDeviceStateService$ScreenStateListener;", MiPushClient.COMMAND_UNREGISTER, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDeviceStateDelegate implements IObricDeviceStateService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricDeviceStateDelegate f392965b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricDeviceStateService f392966a;

    static {
        f392965b = new ObricDeviceStateDelegate();
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricDeviceStateService
    public final void a(OverlayPermissionGuideActivity$screenStateListener$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f392966a.a(r100);
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricDeviceStateService
    public final void b(IObricDeviceStateService.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f392966a.b(r100);
    }

    private ObricDeviceStateDelegate() {
        this.f392966a = (IObricDeviceStateService) ServiceManager.get().getService(IObricDeviceStateService.class);
    }
}
