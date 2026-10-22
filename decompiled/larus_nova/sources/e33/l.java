package e33;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f470909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<KClass<?>> f470910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f470911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f470912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f470913e;

    public final int hashCode() {
        return this.f470909a.hashCode();
    }

    public final String toString() {
        KClass r100 = (KClass) CollectionsKt.firstOrNull(this.f470910b);
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "$this$displayName");
        return String.valueOf(r100.getQualifiedName());
    L6:
        return String.valueOf(this.f470909a);
    }

    public final int a() {
        return this.f470912d;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof l) == true) goto L5;
        return false;
    L5:
        return Intrinsics.areEqual(this.f470909a, ((l) r100).f470909a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Object r100, List<? extends KClass<?>> r101, n r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "serviceKey");
        Intrinsics.checkNotNullParameter(r101, "serviceTypes");
        this.f470909a = r100;
        this.f470910b = r101;
        this.f470911c = r102;
        this.f470912d = r103;
        this.f470913e = r104;
    }
}
