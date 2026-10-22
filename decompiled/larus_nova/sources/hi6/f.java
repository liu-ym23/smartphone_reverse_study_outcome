package hi6;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f485349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f485350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Object> f485351c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (this.f485349a == r101.f485349a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f485350b, r101.f485350b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f485351c, r101.f485351c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f485349a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f485350b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        HashMap<String, Object> r107 = this.f485351c;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "LinkInterceptorCallResult(result=" + this.f485349a + ", reason=" + this.f485350b + ", resultInfo=" + this.f485351c + ")";
    }

    public /* synthetic */ f(boolean r100, String r101) {
        this(r100, r101, new HashMap());
    }

    public f(boolean r100, String r101, HashMap<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r102, "resultInfo");
        this.f485349a = r100;
        this.f485350b = r101;
        this.f485351c = r102;
    }
}
