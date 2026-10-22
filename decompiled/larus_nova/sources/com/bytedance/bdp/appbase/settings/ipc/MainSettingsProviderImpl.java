package com.bytedance.bdp.appbase.settings.ipc;

import com.bytedance.bdp.appbase.settings.expose.BdpABManager;
import com.bytedance.bdp.appbase.settings.update.BdpMainSettingsUpdater;
import java.util.Map;
import org.json.JSONObject;
import w94.a;

/* JADX INFO: loaded from: classes11.dex */
public class MainSettingsProviderImpl implements a {
    public MainSettingsProviderImpl() {
    }

    @Override // w94.a
    public void clearMockSettings(String r100) {
        BdpMainSettingsUpdater.f(r100).e();
    }

    @Override // w94.a
    public void markExpose(String r100, String r101) {
        BdpABManager.INSTANCE.markExpose(r100, r101);
    }

    @Override // w94.a
    public void setMockSettings(String r100, String r101, JSONObject r102) {
        BdpMainSettingsUpdater.f(r100).g(r101, r102);
    }

    @Override // w94.a
    public void updateSettings(String r100, Map<String, String> r101, boolean r102, String r103, boolean r104) {
        BdpMainSettingsUpdater.f(r100).h(r101, r102, r103, r104);
    }
}
