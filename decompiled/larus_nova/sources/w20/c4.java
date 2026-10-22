package w20;

import com.bytedance.android.live.browser.jsbridge.base.OneButtonOpenSceneAndPlayModeResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ac;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c4<P extends ac, R extends OneButtonOpenSceneAndPlayModeResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public c4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
