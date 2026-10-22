package rw;

import com.bytedance.android.gamecp.live_impl.toolbar.jsb.GameCpAnchorPromoteResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.ies.web.jsbridge2.f;
import rw.c;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<P extends c, R extends GameCpAnchorPromoteResultModel> extends f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PUBLIC;
    }
}
