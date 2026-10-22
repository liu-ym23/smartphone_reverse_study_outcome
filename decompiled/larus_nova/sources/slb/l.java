package slb;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f542543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f542544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f542545c;

    public l() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f542543a == r101.f542543a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542544b, r101.f542544b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f542545c, r101.f542545c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f542543a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f542544b.hashCode()) * 31;
        String r102 = this.f542545c;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "PromptConfirmOptions(isPreviewMode=" + this.f542543a + ", param=" + this.f542544b + ", writingPlaceholder=" + this.f542545c + ')';
    }

    public l(Map r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = new LinkedHashMap();
    L9:
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f542543a = r102;
        this.f542544b = r100;
        this.f542545c = null;
        return;
    L5:
        r102 = false;
        goto L7
    }
}
