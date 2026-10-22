package fu7;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class f implements f09.a.b {
    public f() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        h r100 = h.f478911a;
        String r101 = h.a();
        if (Intrinsics.areEqual(h.f478912b.b(), r101) == true) goto L7;
        ThreadPlus.submitRunnable(new d("location_state", r101, new a(r101)));
        return;
    }
}
