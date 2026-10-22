package qv;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f534868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f534869c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f534867a, r101.f534867a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f534868b, r101.f534868b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f534869c, r101.f534869c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f534867a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f534868b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f534869c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppLaunchParams(location=" + this.f534867a + ", liveInfo=" + this.f534868b + ", bdpLogExtra=" + this.f534869c + ")";
    }

    public c(String r100, b r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "location");
        Intrinsics.checkNotNullParameter(r102, "bdpLogExtra");
        this.f534867a = r100;
        this.f534868b = r101;
        this.f534869c = r102;
    }
}
