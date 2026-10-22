package w20;

import com.bytedance.android.live.browser.jsbridge.base.DoLiveCertResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.s8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class m0<P extends s8, R extends DoLiveCertResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public m0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
