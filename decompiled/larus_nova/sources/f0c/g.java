package f0c;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final User f475033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserSession f475034b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f475033a, r101.f475033a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475034b, r101.f475034b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f475033a.hashCode() * 31) + this.f475034b.hashCode();
    }

    public final String toString() {
        return "UserPayload(user=" + this.f475033a + ", session=" + this.f475034b + ')';
    }

    public g(User r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f475033a = r100;
        this.f475034b = r101;
    }
}
