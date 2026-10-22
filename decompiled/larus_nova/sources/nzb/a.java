package nzb;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f521560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f521561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<? extends User> f521562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<? extends User> f521563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final User f521564e;

    public final String toString() {
        return "LoginEndContext{isSuccess=" + this.f521560a + ", isFastLogin=" + this.f521561b + ", loginUserList=" + this.f521562c + ", allUserList=" + this.f521563d + ", activeUser=" + this.f521564e + '}';
    }

    public a(boolean r100, boolean r101, List r102, List r103, User r104) {
        this.f521560a = r100;
        this.f521561b = r101;
        this.f521562c = r102;
        this.f521563d = r103;
        this.f521564e = r104;
    }
}
