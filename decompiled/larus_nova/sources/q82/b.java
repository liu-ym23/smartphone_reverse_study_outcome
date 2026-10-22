package q82;

import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalRedPacketEggResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import q82.e;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b<P extends e, R extends ShowCarnivalRedPacketEggResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
