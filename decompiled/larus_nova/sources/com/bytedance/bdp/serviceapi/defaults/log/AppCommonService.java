package com.bytedance.bdp.serviceapi.defaults.log;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/bdp/serviceapi/defaults/log/AppCommonService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
public interface AppCommonService extends IBdpService {
    JSONObject getSettings(String r100);
}
