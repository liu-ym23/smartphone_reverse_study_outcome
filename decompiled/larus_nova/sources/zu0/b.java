package zu0;

import com.bytedance.android.live.profit.profitCheck.jsbridge.ReportProfitCheckTaskDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import zu0.h;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b<P extends h, R extends ReportProfitCheckTaskDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
