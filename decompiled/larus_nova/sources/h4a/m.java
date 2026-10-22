package h4a;

import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class m implements hx7.h {
    public m() {
    }

    @Override // hx7.h
    public final void getBoundPhone() {
    }

    @Override // hx7.h
    public final String getAvatarURL() {
        return AccountService.f365697a.s();
    }

    @Override // hx7.h
    public final String getNickname() {
        return AccountService.f365697a.getNickname();
    }

    @Override // hx7.h
    public final String getSecUid() {
        return AccountService.f365697a.getSecUserId();
    }

    @Override // hx7.h
    public final String getUniqueID() {
        return o.f365780a.getUserUniqueID();
    }

    @Override // hx7.h
    public final String getUserId() {
        return o.f365780a.getUserID();
    }

    @Override // hx7.h
    public final boolean hasLogin() {
        return AccountService.f365697a.isLogin().booleanValue();
    }

    @Override // hx7.h
    public final void a(tx7.i.a r100) {
        Intrinsics.checkNotNullParameter(r100, "logoutStatusCallback");
        AccountService.f365697a.z("logout_by_jsb_x_logout_method", new l(r100));
    }
}
