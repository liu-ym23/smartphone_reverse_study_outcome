package dc7;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.weixin.BaseWxEntryActivity;
import com.bytedance.sdk.account.platform.weixin.Weixin;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IWeixinService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f467883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f467884b;

    @Override // com.bytedance.sdk.account.platform.api.IWeixinService
    public final boolean isWXAppSupportAPI() {
        return true;
    }

    @Override // com.bytedance.sdk.account.platform.api.IWeixinService
    public final String getWxAppId() {
        return this.f467884b;
    }

    @Override // com.bytedance.sdk.account.platform.api.IWeixinService
    public final void onDestroy() {
        Weixin.resetCallBack();
    }

    public a(Context r100, String r101) {
        this.f467883a = r100.getApplicationContext();
        this.f467884b = r101;
    }

    @Override // com.bytedance.sdk.account.platform.api.IWeixinService
    public final boolean authorize(String r100, String r101, AuthorizeCallback r102) {
        BaseWxEntryActivity.startAuth(this.f467883a, r100, r101);     // Catch: Exception -> L5
        Weixin.setsAuthorizeCallBack(r102);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
