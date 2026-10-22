package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements ExpandableLinearLayoutV4.c {
    public final /* synthetic */ AnchorV4DetailHeadView a;
    public final /* synthetic */ List b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.ExpandableLinearLayoutV4.c
    public final void a(ExpandableLinearLayoutV4.d r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        if ((r4 instanceof ExpandableLinearLayoutV4.d.a) == false) goto L6;
        return;
    L6:
        if ((r4 instanceof ExpandableLinearLayoutV4.d.b) == false) goto L9;
        int r5 = b.a;
        b.a(this.a.n, this.b.size(), true, "");
        return;
    L9:
        if ((r4 instanceof ExpandableLinearLayoutV4.d.c) == false) goto L13;
        AnchorV4DetailHeadView.c(this.a);
        return;
    }

    public i(AnchorV4DetailHeadView r1, List r2) {
        this.a = r1;
        this.b = r2;
    }
}
