package xi4;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t implements Function1<Long, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f563944a = null;

    static {
        f563944a = new t();
    }

    public t() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Long r100) {
        Long r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.longValue() <= 0) goto L5;
        boolean r102 = true;
    L7:
        return Boolean.valueOf(r102);
    L5:
        r102 = false;
        goto L7
    }
}
