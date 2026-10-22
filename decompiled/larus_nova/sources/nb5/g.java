package nb5;

import com.bytedance.ee.bear.integrator.di.configs.net.container.UserNetServiceImpl;
import com.ss.android.lark.passportc.entity.UserState;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements ak5.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserNetServiceImpl f518513a;

    public g(UserNetServiceImpl r100) {
        this.f518513a = r100;
    }

    @Override // ak5.h
    public final void a(ak5.a.C0077a r100) {
        if (this.f518513a.f227110c.getState().f475035a != UserState.ONLINE) goto L5;
        this.f518513a.f227110c.getUser().getSession();
        r100.a(true, this.f518513a.f227110c.getUser().userId);
        return;
    L5:
        tt5.a.k("UserNetServiceImpl", "UserState is offline, LoginChecker false");
        r100.a(false, this.f518513a.f227110c.getUser().userId);
    }
}
