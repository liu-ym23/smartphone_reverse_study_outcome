package td2;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f545507b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f545506a, r101.f545506a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f545507b, r101.f545507b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f545506a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        WeakReference<Context> r104 = this.f545507b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSongExtraInfo(enterFrom=" + this.f545506a + ", enterFromContext=" + this.f545507b + ")";
    }

    public b(String r100, WeakReference<Context> r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "enterFromContext");
        this.f545506a = r100;
        this.f545507b = r101;
    }
}
