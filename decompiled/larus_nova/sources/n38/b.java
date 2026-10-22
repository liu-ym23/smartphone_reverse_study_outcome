package n38;

import com.larus.account.base.api.AccountSwitchReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q38.b f516987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q38.b f516988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f516989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f516990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f516991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AccountSwitchReason f516992f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f516987a, r101.f516987a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f516988b, r101.f516988b) == true) goto L15;
        return false;
    L15:
        if (this.f516989c == r101.f516989c) goto L18;
        return false;
    L18:
        if (this.f516990d == r101.f516990d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f516991e, r101.f516991e) == true) goto L24;
        return false;
    L24:
        if (this.f516992f == r101.f516992f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        q38.b r100 = this.f516987a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        q38.b r104 = this.f516988b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f516989c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((r106 + r107) * 31) + this.f516990d) * 31;
        String r109 = this.f516991e;
        if (r109 == null) goto L19;
        r101 = r109.hashCode();
    L19:
        return ((r108 + r101) * 31) + this.f516992f.hashCode();
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccountSwitchResult(fromAccount=" + this.f516987a + ", toAccount=" + this.f516988b + ", success=" + this.f516989c + ", errorCode=" + this.f516990d + ", errorMessage=" + this.f516991e + ", reason=" + this.f516992f + ')';
    }

    public /* synthetic */ b(q38.b r100, q38.b r101, boolean r110, int r111, String r112) {
        this(r100, r101, r110, r111, r112, AccountSwitchReason.UNKNOWN);
    }

    public b(q38.b r100, q38.b r101, boolean r102, int r103, String r104, AccountSwitchReason r105) {
        Intrinsics.checkNotNullParameter(r105, "reason");
        this.f516987a = r100;
        this.f516988b = r101;
        this.f516989c = r102;
        this.f516990d = r103;
        this.f516991e = r104;
        this.f516992f = r105;
    }
}
