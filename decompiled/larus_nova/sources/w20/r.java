package w20;

import com.bytedance.android.live.browser.jsbridge.base.CheckAnchorEffectInUsedResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.a8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class r<P extends a8, R extends CheckAnchorEffectInUsedResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public r() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
