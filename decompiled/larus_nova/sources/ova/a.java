package ova;

import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f526937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f526938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f526939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f526940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f526941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final UserSession f526942f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f526937a == r101.f526937a) goto L12;
        return false;
    L12:
        if (this.f526938b == r101.f526938b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f526939c, r101.f526939c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f526940d, r101.f526940d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f526941e, r101.f526941e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f526942f, r101.f526942f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f526937a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f526938b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r101 + r102) * 31;
        String r104 = this.f526939c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f526940d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f526941e.hashCode()) * 31;
        UserSession r111 = this.f526942f;
        if (r111 == null) goto L19;
        r105 = r111.hashCode();
    L19:
        return r110 + r105;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppLinkContext(startTime=" + this.f526937a + ", isShortLink=" + this.f526938b + ", path=" + this.f526939c + ", longPath=" + this.f526940d + ", traceId=" + this.f526941e + ", userSession=" + this.f526942f + ')';
    }

    public a(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "traceId");
        this.f526937a = r100;
        this.f526938b = false;
        this.f526939c = r101;
        this.f526940d = null;
        this.f526941e = r102;
        this.f526942f = null;
    }
}
