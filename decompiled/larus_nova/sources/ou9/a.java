package ou9;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public a() {
    }

    public static FlowDowngradeToastConfig a() {
        AppHost.Companion r100 = AppHost.f326268a;
        return new FlowDowngradeToastConfig(r100.getApplication().getString(R.string.larus_trafficDegradation_featureDisable_cn), r100.getApplication().getString(R.string.larus_trafficDegradation_loadingFailure_cn), r100.getApplication().getString(R.string.larus_trafficDegradation_logInDisable_cn), r100.getApplication().getString(R.string.larus_trafficDegradation_callDisable_cn));
    }
}
