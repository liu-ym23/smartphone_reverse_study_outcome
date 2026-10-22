package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetStickerInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ta;

/* JADX INFO: loaded from: classes45.dex */
public abstract class x2<P extends ta, R extends LiveGetStickerInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public x2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
