package vm6;

import com.bytedance.locallife.dito.core.AbsDitoPlugin;
import com.bytedance.locallife.dito.data.o;
import eu6.c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements eu6.a {
    public a() {
    }

    @Override // ns6.a
    public final List<String> a() {
        return null;
    }

    @Override // eu6.a
    public final Map<String, o> Q() {
        return new LinkedHashMap();
    }

    @Override // eu6.a
    public final List<AbsDitoPlugin> i0(c r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        return CollectionsKt.emptyList();
    }
}
