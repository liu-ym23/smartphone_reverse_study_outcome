package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveLoadShortTouchBigCardResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.va;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a3<P extends va, R extends LiveLoadShortTouchBigCardResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public a3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
