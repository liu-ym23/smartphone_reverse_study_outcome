package w20;

import com.bytedance.android.live.browser.jsbridge.base.ChangeShortTouchSizeResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.y7;

/* JADX INFO: loaded from: classes45.dex */
public abstract class p<P extends y7, R extends ChangeShortTouchSizeResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public p() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
