package w20;

import com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.me;

/* JADX INFO: loaded from: classes45.dex */
public abstract class f6<P extends me, R extends SetEffectComposerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
