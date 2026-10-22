package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.p9;

/* JADX INFO: loaded from: classes45.dex */
public abstract class o1<P extends p9, R extends GetMessageBoardDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public o1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
