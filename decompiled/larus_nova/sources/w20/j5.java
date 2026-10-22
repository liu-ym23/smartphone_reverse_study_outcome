package w20;

import com.bytedance.android.live.browser.jsbridge.base.ReportLiveTraceResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.jd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class j5<P extends jd, R extends ReportLiveTraceResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public j5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
