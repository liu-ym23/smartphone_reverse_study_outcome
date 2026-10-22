package com.bytedance.bdp.bdpbase.core;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpBaseHostSettingsService extends IBdpService {
    JSONObject getSettingJson(String r100);
}
