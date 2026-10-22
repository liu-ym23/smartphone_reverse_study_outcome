package ze;

import com.bytedance.android.ec.base.pdp.PackDataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f571502b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PackDataSource f571503a;

    /* JADX INFO: renamed from: ze.a$a, reason: collision with other inner class name */
    public static final class C8446a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f571503a, ((a) r100).f571503a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        PackDataSource r100 = this.f571503a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PDPPreloadStrategy(dataSource=" + this.f571503a + ")";
    }

    static {
        f571502b = new a(PackDataSource.STANDARD);
    }

    public a(PackDataSource r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        this.f571503a = r100;
    }
}
