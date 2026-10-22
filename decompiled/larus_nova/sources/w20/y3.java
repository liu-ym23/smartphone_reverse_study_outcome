package w20;

import com.bytedance.android.live.browser.jsbridge.base.MeasureTextResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.sb;

/* JADX INFO: loaded from: classes45.dex */
public abstract class y3<P extends sb, R extends MeasureTextResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public y3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
