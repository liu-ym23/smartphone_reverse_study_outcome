package ou9;

import com.larus.common.apphost.AppHost;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public a() {
    }

    public static FlowDowngradeToastConfig a() {
        AppHost.Companion r1 = AppHost.a;
        return new FlowDowngradeToastConfig(r1.getApplication().getString(2131910602), r1.getApplication().getString(2131910603), r1.getApplication().getString(2131910604), r1.getApplication().getString(2131910598));
    }
}
