package w20;

import com.bytedance.android.live.browser.jsbridge.base.CloseLiveHistoryPageResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.g8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class y<P extends g8, R extends CloseLiveHistoryPageResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f557982a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public y() {
        this.f557982a = "closeLiveHistoryPage";
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
