package com.bytedance.android.window.shop.holder;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements WindowHotsaleLoadMoreHolder.b {
    public final /* synthetic */ WindowHotsaleLoadMoreHolder a;

    public c(WindowHotsaleLoadMoreHolder r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder.b
    public final void a(List<? extends sq3.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        WindowHotsaleLoadMoreHolder r0 = this.a;
        WindowHotsaleLoadMoreHolder.a r1 = r0.v;
        if (r1 == null) goto L6;
        r1.b(r0.getLayoutPosition(), r3);
        return;
    }

    @Override // com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder.b
    public final void b(sq3.e r3, List<? extends sq3.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "loadMoreVO");
        Intrinsics.checkNotNullParameter(r4, "list");
        WindowHotsaleLoadMoreHolder r0 = this.a;
        WindowHotsaleLoadMoreHolder.a r1 = r0.v;
        if (r1 == null) goto L6;
        r1.a(r0.getLayoutPosition(), r3, r4);
        return;
    }
}
