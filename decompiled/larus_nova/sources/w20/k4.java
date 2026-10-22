package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenGalleryResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.jc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class k4<P extends jc, R extends OpenGalleryResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public k4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
