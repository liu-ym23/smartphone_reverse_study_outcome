package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveReportAggregateALogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.bb;

/* JADX INFO: loaded from: classes45.dex */
public abstract class h3<P extends bb, R extends LiveReportAggregateALogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public h3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
