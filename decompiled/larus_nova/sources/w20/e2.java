package w20;

import com.bytedance.android.live.browser.jsbridge.base.InputActivityEmojiResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ca;

/* JADX INFO: loaded from: classes45.dex */
public abstract class e2<P extends ca, R extends InputActivityEmojiResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
