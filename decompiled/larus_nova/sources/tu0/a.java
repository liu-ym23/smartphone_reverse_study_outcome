package tu0;

import com.bytedance.android.live.profit.player.jsb.DressPlayClickResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.ies.web.jsbridge2.f;
import tu0.c;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a<P extends c, R extends DressPlayClickResultModel> extends f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
