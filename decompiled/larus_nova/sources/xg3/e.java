package xg3;

import com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f563608a;

    public e(d r100) {
        this.f563608a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r100) {
        k r101 = (k) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if ((r101 instanceof k.d) == false) goto L10;
        boolean r102 = PdpMessageOpt.f43751a;
        PdpMessageOpt.h(this.f563608a.c2(), r101 instanceof k.d.a);
        if (Intrinsics.areEqual(this.f563608a.c2(), PdpMessageOpt.f43753c) == false) goto L10;
        BasePdpMessageOptWorker r103 = PdpMessageOpt.f43754d;
        if (r103 == null) goto L10;
        r103.e(false);
    L10:
        if ((r101 instanceof k.c.b) == false) goto L17;
        boolean r104 = PdpMessageOpt.f43751a;
        if (Intrinsics.areEqual(this.f563608a.c2(), PdpMessageOpt.f43753c) == false) goto L18;
        BasePdpMessageOptWorker r105 = PdpMessageOpt.f43754d;
        if (r105 == null) goto L19;
        r105.e(true);
        return;
    L19:
        return;
    L18:
        return;
    }
}
