package mb3;

import com.bytedance.android.shopping.collect.util.c;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<String, j>> f512777a;

    public a(com.bytedance.android.shopping.collect.controller.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f512777a = CollectionsKt.listOf(TuplesKt.to("productsCleanUp", new c(r100).f172292a));
    }
}
