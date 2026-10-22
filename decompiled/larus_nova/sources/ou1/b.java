package ou1;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements nu1.c<com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.e> {
    public b() {
    }

    @Override // nu1.c
    public final void a(com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g r100, String r101, Map r102) {
        com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.e r103 = (com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.e) r100;
        Intrinsics.checkNotNullParameter(r103, "nfa");
        Intrinsics.checkNotNullParameter(r101, "eventKey");
        Intrinsics.checkNotNullParameter(r102, "eventParams");
        r103.j(r101, r102);
    }
}
