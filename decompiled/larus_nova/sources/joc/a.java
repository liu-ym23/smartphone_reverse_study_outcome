package joc;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final goc.b.e f499925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f499926b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f499925a, r101.f499925a) == true) goto L12;
        return false;
    L12:
        if (this.f499926b == r101.f499926b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f499925a.hashCode() * 31;
        if (this.f499926b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "CardVO(card=" + this.f499925a + ", isSelected=" + this.f499926b + ')';
    }

    public a(goc.b.e r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        this.f499925a = r100;
        this.f499926b = r101;
    }
}
