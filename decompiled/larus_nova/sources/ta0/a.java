package ta0;

import com.bytedance.android.live.incentive.exchange.jsb.RevenueNotifyIncomeExchangeResultResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.ies.web.jsbridge2.f;
import ta0.c;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<P extends c, R extends RevenueNotifyIncomeExchangeResultResultModel> extends f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
