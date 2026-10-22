package w20;

import com.bytedance.android.live.browser.jsbridge.base.CreateVipEmojiByTemplateResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.p8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class j0<P extends p8, R extends CreateVipEmojiByTemplateResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public j0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
