package ed4;

import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f472206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472207b;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        return CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{100, 102, 103, 104, 106, 1201, 12002}), this.f472206a);
    }

    public final String toString() {
        return "CJLynxError(code=" + this.f472206a + ", msg=" + this.f472207b + ')';
    }

    public e(Integer r100, String r101) {
        this.f472206a = r100;
        this.f472207b = r101;
    }
}
