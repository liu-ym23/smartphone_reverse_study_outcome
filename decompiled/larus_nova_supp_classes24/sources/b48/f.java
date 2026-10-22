package b48;

import com.larus.account.saas.model.AccountLoginType;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public final Boolean a;
    public final b b;
    public final AccountLoginType c;
    public final String d;
    public final Map<String, Object> e;

    public f() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        b r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
        String r7 = this.d;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.e.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccountLoginResult(isNewUserLogin=" + this.a + ", accountInfo=" + this.b + ", loginType=" + this.c + ", businessScene=" + this.d + ", extra=" + this.e + ')';
    }

    public f(Boolean r3, b r4, AccountLoginType r5, String r6) {
        Map<String, Object> r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r5, "loginType");
        Intrinsics.checkNotNullParameter(r0, "extra");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r0;
    }
}
