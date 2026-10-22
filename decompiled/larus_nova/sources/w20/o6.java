package w20;

import com.bytedance.android.live.browser.jsbridge.base.ShowLoadingResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.we;

/* JADX INFO: loaded from: classes45.dex */
public abstract class o6<P extends we, R extends ShowLoadingResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public o6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
