package w20;

import com.bytedance.android.live.browser.jsbridge.base.FormatSendLogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.w8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class r0<P extends w8, R extends FormatSendLogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public r0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
