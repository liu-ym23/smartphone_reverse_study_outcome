package n38;

import com.larus.account.base.api.UserAction;
import com.larus.account.base.model.AccountStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccountStatus f516978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f516979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UserAction f516980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f516981d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f516978a == r101.f516978a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f516979b, r101.f516979b) == true) goto L15;
        return false;
    L15:
        if (this.f516980c == r101.f516980c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f516981d, r101.f516981d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f516978a.hashCode() * 31) + this.f516979b.hashCode()) * 31) + this.f516980c.hashCode()) * 31) + this.f516981d.hashCode();
    }

    public final String toString() {
        return "AccountStatusEvent(status=" + this.f516978a + ", user=" + this.f516979b + ", action=" + this.f516980c + ", businessScene=" + this.f516981d + ')';
    }

    public a(AccountStatus r100, c r101, UserAction r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r103, "businessScene");
        this.f516978a = r100;
        this.f516979b = r101;
        this.f516980c = r102;
        this.f516981d = r103;
    }
}
