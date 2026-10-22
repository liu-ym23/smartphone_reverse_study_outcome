package w20;

import com.bytedance.android.live.browser.jsbridge.base.InputFusionEmojiResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.da;

/* JADX INFO: loaded from: classes45.dex */
public abstract class f2<P extends da, R extends InputFusionEmojiResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
