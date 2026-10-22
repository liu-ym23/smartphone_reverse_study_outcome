package w20;

import com.bytedance.android.live.browser.jsbridge.base.CloseFeedbackPageResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.e8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class w<P extends e8, R extends CloseFeedbackPageResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f557981a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public w() {
        this.f557981a = "closeFeedbackPage";
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
