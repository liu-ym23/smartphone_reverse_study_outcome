package cy8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<t> f465884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f465885c;

    public o() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f465883a, r101.f465883a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465884b, r101.f465884b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465885c, r101.f465885c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465883a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<t> r104 = this.f465884b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f465885c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasMsgPromptConf(placeholder=" + this.f465883a + ", promptList=" + this.f465884b + ", noLimitPromptFormat=" + this.f465885c + ')';
    }

    public o(String r100, List<t> r101, String r102) {
        this.f465883a = r100;
        this.f465884b = r101;
        this.f465885c = r102;
    }
}
