package xg3;

import com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        k r4 = (k) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        if ((r4 instanceof k.d) == false) goto L10;
        boolean r0 = PdpMessageOpt.a;
        PdpMessageOpt.h(this.a.c2(), r4 instanceof k.d.a);
        if (Intrinsics.areEqual(this.a.c2(), PdpMessageOpt.c) == false) goto L10;
        BasePdpMessageOptWorker r1 = PdpMessageOpt.d;
        if (r1 == null) goto L10;
        r1.e(false);
    L10:
        if ((r4 instanceof k.c.b) == false) goto L17;
        boolean r5 = PdpMessageOpt.a;
        if (Intrinsics.areEqual(this.a.c2(), PdpMessageOpt.c) == false) goto L18;
        BasePdpMessageOptWorker r6 = PdpMessageOpt.d;
        if (r6 == null) goto L19;
        r6.e(true);
        return;
    L19:
        return;
    L18:
        return;
    }
}
