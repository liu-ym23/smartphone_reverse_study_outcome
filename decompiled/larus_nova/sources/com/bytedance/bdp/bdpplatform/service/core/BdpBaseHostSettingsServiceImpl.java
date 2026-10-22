package com.bytedance.bdp.bdpplatform.service.core;

import com.bytedance.bdp.bdpbase.core.BdpBaseHostSettingsService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.setting.BdpHostSettingService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BdpBaseHostSettingsServiceImpl implements BdpBaseHostSettingsService {
    public BdpBaseHostSettingsServiceImpl() {
    }

    @Override // com.bytedance.bdp.bdpbase.core.BdpBaseHostSettingsService
    public final JSONObject getSettingJson(String r100) {
        return ((BdpHostSettingService) BdpManager.getInst().getService(BdpHostSettingService.class)).getSettingJson(r100);
    }
}
