package w20;

import com.bytedance.android.live.browser.jsbridge.base.LinkminkToolsCommonResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.fa;

/* JADX INFO: loaded from: classes45.dex */
public abstract class g2<P extends fa, R extends LinkminkToolsCommonResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public g2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
