package pc8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f528560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f528561b;

    /* JADX INFO: renamed from: pc8.a$a, reason: collision with other inner class name */
    public static final class C7180a {
    }

    static {
    }

    public a() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f528560a, r101.f528560a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528561b, r101.f528561b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f528560a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f528561b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerClickAction(type=" + this.f528560a + ", data=" + this.f528561b + ')';
    }

    public final Integer getType() {
        return this.f528560a;
    }

    public /* synthetic */ a(Integer r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public a(Integer r100, Map<String, String> r101) {
        this.f528560a = r100;
        this.f528561b = r101;
    }
}
