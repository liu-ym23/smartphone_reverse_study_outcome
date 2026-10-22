package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenCustomEmojiPreviewResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.fc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class g4<P extends fc, R extends OpenCustomEmojiPreviewResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public g4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
