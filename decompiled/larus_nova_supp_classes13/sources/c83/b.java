package c83;

import com.bytedance.android.shopping.anchorv4.containers.g;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements c {
    public final AnchorV4VM a;

    @Override // c83.c
    public final void a() {
        this.a.fetchGULIfNeed();
    }

    @Override // c83.c
    public final void b() {
        g r0 = this.a.containerAbility();
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public b(AnchorV4VM r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.a = r2;
    }
}
