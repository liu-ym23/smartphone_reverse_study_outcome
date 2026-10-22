package w20;

import com.bytedance.android.live.browser.jsbridge.base.CommentPinResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.h8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a0<P extends h8, R extends CommentPinResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public a0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
