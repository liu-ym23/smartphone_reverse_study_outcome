package dk9;

import com.larus.platform.api.s3;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import tx9.x3;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.bytedance.ug.sdk.luckycat.api.depend.c {
    public a() {
    }

    @Override // com.bytedance.ug.sdk.luckycat.api.depend.c
    public final void b() {
    }

    @Override // com.bytedance.ug.sdk.luckycat.api.depend.c
    public final void a() {
        x3.a("luckydog", "host_open_half_login_from_sdk", null);
        i3 r100 = i3.f365750a;
        s3.a.a(TriggerLoginScene.TRIGGER_LOGIN_AWEME_RED_PACKET, 2);
    }

    @Override // com.bytedance.ug.sdk.luckycat.api.depend.c
    public final String getSecUid() {
        return AccountService.f365697a.getSecUserId();
    }

    @Override // com.bytedance.ug.sdk.luckycat.api.depend.c
    public final String getUserId() {
        return AccountService.f365697a.getUserId();
    }

    @Override // com.bytedance.ug.sdk.luckycat.api.depend.c
    public final boolean isLogin() {
        return AccountService.f365697a.isLogin().booleanValue();
    }
}
