package ubb;

import com.ss.android.lark.docs.url.MiaodaUrlRoute;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f549411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MiaodaUrlRoute f549412b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f549411a, r101.f549411a) == true) goto L12;
        return false;
    L12:
        if (this.f549412b == r101.f549412b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f549411a.hashCode() * 31) + this.f549412b.hashCode();
    }

    public final String toString() {
        return "MiaodaUrlInfo(token=" + this.f549411a + ", kind=" + this.f549412b + ')';
    }

    public a(String r100, MiaodaUrlRoute r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "kind");
        this.f549411a = r100;
        this.f549412b = r101;
    }
}
