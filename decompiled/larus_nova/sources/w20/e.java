package w20;

import com.bytedance.android.live.browser.jsbridge.base.AddSongResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.j7;

/* JADX INFO: loaded from: classes45.dex */
public abstract class e<P extends j7, R extends AddSongResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
