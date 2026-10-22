package ub3;

import com.bytedance.android.shopping.collect.container.CollectYataViewModel;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.store.core.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CollectYataViewModel f549351a;

    @Override // com.bytedance.kmp.ec.yata.store.core.a
    public final void d() {
    }

    @Override // com.bytedance.kmp.ec.yata.store.core.a
    public final void e() {
    }

    public b(CollectYataViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "collectYataViewModel");
        this.f549351a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.store.core.a
    public final void b(com.bytedance.kmp.ec.yata.store.core.a.C3594a r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
        r100.c();
    }

    @Override // com.bytedance.kmp.ec.yata.store.core.a
    public final void c(com.bytedance.kmp.ec.yata.store.core.a.C3594a r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
        String r101 = r100.b();
        Map<String, Object> r102 = r100.a();
        if (r101 == null) goto L9;
        if (r102 == null) goto L10;
        a r103 = this.f549351a.getCollectCustomDataCenter();
        if (r103 == null) goto L11;
        Intrinsics.checkNotNullParameter(r101, "nodeKey");
        Intrinsics.checkNotNullParameter(r102, "map");
        r103.f549349a.put(r101, MapsKt.toMutableMap(r102));
        return;
    L11:
        return;
    L10:
        return;
    }
}
