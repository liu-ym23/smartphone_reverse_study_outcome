package mt6;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends bm6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f515647a = null;

    static {
        f515647a = new a();
    }

    @Override // bm6.a, mt6.b
    public final List<c> d() {
        return CollectionsKt.emptyList();
    }

    public a() {
    }

    @Override // bm6.a, mt6.b
    public final Map<String, Object> c(m16.b r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        return super.c(r100, r101);
    }
}
