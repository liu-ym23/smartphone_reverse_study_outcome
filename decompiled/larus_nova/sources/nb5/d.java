package nb5;

import com.bytedance.ee.bear.integrator.di.configs.net.container.OfficeUserNetServiceImpl;
import com.ss.android.lark.passportc.entity.UserState;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements ak5.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeUserNetServiceImpl f518506a;

    public d(OfficeUserNetServiceImpl r100) {
        this.f518506a = r100;
    }

    @Override // ak5.h
    public final void a(ak5.a.C0077a r100) {
        if (this.f518506a.f227093c.getState().f475035a != UserState.ONLINE) goto L5;
        this.f518506a.f227093c.getUser().getSession();
        r100.a(true, this.f518506a.f227093c.getUser().userId);
        return;
    L5:
        tt5.a.k("UserNetServiceImpl", "UserState is offline, LoginChecker false");
        r100.a(false, this.f518506a.f227093c.getUser().userId);
    }
}
