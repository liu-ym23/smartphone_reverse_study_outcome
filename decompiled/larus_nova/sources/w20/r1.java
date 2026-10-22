package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetPictureResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.r9;

/* JADX INFO: loaded from: classes45.dex */
public abstract class r1<P extends r9, R extends GetPictureResultModel> extends com.bytedance.android.live.browser.jsbridge.c<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public r1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
