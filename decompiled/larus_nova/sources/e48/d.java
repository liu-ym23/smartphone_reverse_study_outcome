package e48;

import com.larus.account.saas.security.model.AccountSecurityEventType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccountSecurityEventType f471001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f471003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f471004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f471005e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f471001a == r101.f471001a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471002b, r101.f471002b) == true) goto L15;
        return false;
    L15:
        if (this.f471003c == r101.f471003c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f471004d, r101.f471004d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f471005e, r101.f471005e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f471001a.hashCode() * 31) + this.f471002b.hashCode()) * 31;
        long r101 = this.f471003c;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f471004d.hashCode()) * 31;
        String r103 = this.f471005e;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "AccountSecurityEvent(eventType=" + this.f471001a + ", uid=" + this.f471002b + ", timestampMs=" + this.f471003c + ", extra=" + this.f471004d + ", source=" + this.f471005e + ')';
    }

    public d(AccountSecurityEventType r100, String r101, long r102, Map<String, String> r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.f471001a = r100;
        this.f471002b = r101;
        this.f471003c = r102;
        this.f471004d = r103;
        this.f471005e = r104;
    }
}
