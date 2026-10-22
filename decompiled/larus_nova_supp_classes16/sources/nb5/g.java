package nb5;

import com.bytedance.ee.bear.integrator.di.configs.net.container.UserNetServiceImpl;
import com.ss.android.lark.passportc.entity.UserState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements ak5.h {
    public final /* synthetic */ UserNetServiceImpl a;

    public g(UserNetServiceImpl r1) {
        this.a = r1;
    }

    public final void a(ak5.a.a r3) {
        if (this.a.c.getState().a != UserState.ONLINE) goto L5;
        this.a.c.getUser().getSession();
        r3.a(true, this.a.c.getUser().userId);
        return;
    L5:
        tt5.a.k("UserNetServiceImpl", "UserState is offline, LoginChecker false");
        r3.a(false, this.a.c.getUser().userId);
    }
}
