package e7;

import com.bytedance.android.annie.bridge.method.abs.GetDownloadGiftAssetsResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.h0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class h<P extends h0, R extends GetDownloadGiftAssetsResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public h() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
