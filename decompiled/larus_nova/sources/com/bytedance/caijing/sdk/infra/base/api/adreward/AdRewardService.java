package com.bytedance.caijing.sdk.infra.base.api.adreward;

import android.content.Context;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import yc4.b;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u0011J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/adreward/AdRewardService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", BdpAppEventConstant.PARAMS_RIT, "", "adFrom", "creatorId", "moreRewardInfos", "retentionModel", "Lcom/bytedance/caijing/sdk/infra/base/api/adreward/AdRewardService$a;", "callback", "", "openAdReward", "Lyc4/b;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface AdRewardService extends ICJService {

    public interface a {
    }

    void openAdReward(Context r100, int r101, String r102, String r103, String r104, String r105, a r106);

    void openAdReward(b r100);
}
