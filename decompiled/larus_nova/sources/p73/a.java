package p73;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f527996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f527997b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f527996a, r101.f527996a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527997b, r101.f527997b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        c r100 = this.f527996a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.f527997b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CacheValue(card=" + this.f527996a + ", cacheId=" + this.f527997b + ")";
    }

    public a(c r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "cacheId");
        this.f527996a = r100;
        this.f527997b = r101;
    }
}
