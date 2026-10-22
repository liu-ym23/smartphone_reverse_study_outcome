package ozb;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutReason;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LogoutReason f527238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends User> f527239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<? extends User> f527240c;

    public final String toString() {
        return "LogoutEndContext{isSuccess=trueisLogoutAll=false, reason=" + this.f527238a + ", logoutUserList=" + this.f527239b + ", allUserList=" + this.f527240c + '}';
    }

    public a(LogoutReason r100, List r101, List r102) {
        this.f527238a = r100;
        this.f527239b = r101;
        this.f527240c = r102;
    }
}
