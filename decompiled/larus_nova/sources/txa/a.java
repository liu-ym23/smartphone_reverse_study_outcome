package txa;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547918b;

    /* JADX INFO: renamed from: txa.a$a, reason: collision with other inner class name */
    public static final class C7793a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f547917a, r101.f547917a) == true) goto L12;
        return false;
    L12:
        if (this.f547918b == r101.f547918b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f547917a.hashCode() * 31;
        if (this.f547918b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "BannedHintReason(desc=" + this.f547917a + ", show=" + this.f547918b + ')';
    }

    public a(boolean r100) {
        Intrinsics.checkNotNullParameter("multi_select", SocialConstants.PARAM_APP_DESC);
        this.f547917a = "multi_select";
        this.f547918b = r100;
    }
}
