package of7;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f523111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f523112b;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "PSDAContext:{sdkName: null, methodName: null, atomicInfo: " + this.f523111a + '}';
    }

    public b(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "atomicInfoList");
        this.f523111a = r100;
    }

    public b(List<String> r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r100, "atomicInfoList");
        Intrinsics.checkNotNullParameter(r101, "apiParams");
        this.f523111a = r100;
        this.f523112b = r101;
    }
}
