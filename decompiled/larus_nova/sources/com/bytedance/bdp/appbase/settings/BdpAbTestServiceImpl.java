package com.bytedance.bdp.appbase.settings;

import com.bytedance.bdp.appbase.base.abtest.BdpAbTestService;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bdp/appbase/settings/BdpAbTestServiceImpl;", "Lcom/bytedance/bdp/appbase/base/abtest/BdpAbTestService;", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpAbTestServiceImpl implements BdpAbTestService {
    public BdpAbTestServiceImpl() {
    }

    @Override // com.bytedance.bdp.appbase.base.abtest.BdpAbTestService
    public final JSONObject C2() {
        return BdpInnerSettingsHelper.getSettings("bdp_device_scores");
    }
}
