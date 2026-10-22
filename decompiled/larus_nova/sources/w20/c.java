package w20;

import com.bytedance.android.live.browser.jsbridge.base.AdTrackInfoFromCidResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.i7;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c<P extends i7, R extends AdTrackInfoFromCidResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public c() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
