package w20;

import com.bytedance.android.live.browser.jsbridge.base.SendGiftPlayerEventResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.de;

/* JADX INFO: loaded from: classes45.dex */
public abstract class x5<P extends de, R extends SendGiftPlayerEventResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public x5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
