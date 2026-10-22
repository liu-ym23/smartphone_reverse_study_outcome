package wc2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Single;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "updateUserInfo")
public final class d extends f<JSONObject, Object> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public d() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        if (UserSetting.b() == false) goto L9;
        IUserServiceV2 r102 = (IUserServiceV2) k.f(IUserServiceV2.class);
        if (r102 == null) goto L10;
        Single<? extends IBaseUser> r103 = r102.updateCurrentUser(null, "UpdateUserInfoMethod");
        if (r103 == null) goto L10;
        r103.subscribe(new h());
    L10:
        finishWithResult(new JSONObject());
        return;
    L9:
        ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().j().subscribe(new h());
        goto L10
    }
}
