package fw;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a {
    public a() {
    }

    public abstract Map a(vx1.b r100);

    public Map b(vx1.b r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Map r101 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.plus(r101, MapsKt.emptyMap());
    }
}
