package f0c;

import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.g0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements Comparable<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserSession f475026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f475028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f475029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g0 f475030e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f475026a, r101.f475026a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475027b, r101.f475027b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f475028c, r101.f475028c) == true) goto L18;
        return false;
    L18:
        if (this.f475029d == r101.f475029d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f475030e, r101.f475030e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f475026a.hashCode() * 31) + this.f475027b.hashCode()) * 31) + this.f475028c.hashCode()) * 31;
        if (this.f475029d == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f475030e.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "[userId=" + this.f475027b + ", userState=" + this.f475028c + ", isForegroundUser=" + this.f475029d + ", session=" + this.f475026a + "]\n";
    }

    @Override // java.lang.Comparable
    public final int compareTo(d r100) {
        d r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        boolean r102 = this.f475029d;
        if (r102 == true) goto L5;
    L7:
        if (r102 == true) goto L12;
        if (r101.f475029d == false) goto L12;
        return 1;
    L12:
        return this.f475027b.compareTo(r101.f475027b);
    L5:
        if (r101.f475029d == true) goto L7;
        return -1;
    }

    public static d a(d r100, h r101, int r110) {
        g0 r102 = null;
        if ((r110 & 1) == 0) goto L5;
        UserSession r103 = r100.f475026a;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r104 = r100.f475027b;
    L11:
        if ((r110 & 4) == 0) goto L13;
        r101 = r100.f475028c;
    L13:
        h r105 = r101;
        if ((r110 & 8) == 0) goto L16;
        boolean r106 = r100.f475029d;
    L18:
        if ((r110 & 16) == 0) goto L20;
        r102 = r100.f475030e;
    L20:
        g0 r107 = r102;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r104, "userId");
        Intrinsics.checkNotNullParameter(r105, UserInfo.USERSTATE);
        Intrinsics.checkNotNullParameter(r107, "userDelegate");
        return new d(r103, r104, r105, r106, r107);
    L16:
        r106 = false;
        goto L18
    L9:
        r104 = null;
        goto L11
    L5:
        r103 = null;
        goto L7
    }

    public d(UserSession r100, String r101, h r102, boolean r103, g0 r104) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, UserInfo.USERSTATE);
        Intrinsics.checkNotNullParameter(r104, "userDelegate");
        this.f475026a = r100;
        this.f475027b = r101;
        this.f475028c = r102;
        this.f475029d = r103;
        this.f475030e = r104;
    }
}
