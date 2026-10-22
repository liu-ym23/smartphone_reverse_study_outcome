package q9c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f532194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f532196c;

    public final int hashCode() {
        return (this.f532194a.hashCode() * 31) + this.f532195b.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.ug.scheduler.common.entity.ReachPointAction");
        a r102 = (a) r100;
        if (Intrinsics.areEqual(this.f532194a, r102.f532194a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f532195b, r102.f532195b) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scenarioId");
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f532194a = r100;
        this.f532195b = r101;
        this.f532196c = null;
    }
}
