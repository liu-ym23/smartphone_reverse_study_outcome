package com.obric.assistant.state.api.v2.core;

import com.obric.assistant.interaction.impl.window.helpers.OverlayPermissionGuideActivity$screenStateListener$1;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/IObricDeviceStateService;", "", MiPushClient.COMMAND_REGISTER, "", "listener", "Lcom/obric/assistant/state/api/v2/core/IObricDeviceStateService$ScreenStateListener;", MiPushClient.COMMAND_UNREGISTER, "ScreenStateListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricDeviceStateService {

    public interface a {
        void onScreenOff();

        void onScreenOn();

        void onUserPresent();
    }

    void a(OverlayPermissionGuideActivity$screenStateListener$1 r100);

    void b(a r100);
}
