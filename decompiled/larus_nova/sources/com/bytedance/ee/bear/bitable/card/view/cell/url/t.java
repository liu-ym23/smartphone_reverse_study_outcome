package com.bytedance.ee.bear.bitable.card.view.cell.url;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t extends db5.i<db5.a> {
    public t(TextView r100, un5.a.InterfaceC7903a r101) {
        super(r100, r101, null);
    }

    @Override // db5.i
    public final un5.h h(db5.a r100, db5.j r101) {
        Intrinsics.checkNotNullParameter(r101, "link");
        if ((r101 instanceof r) == false) goto L6;
        return new s(this.f467820a, r101.f467829d, ((r) r101).f208348e, this.f467822c);
    L6:
        return new un5.h(this.f467820a, r101.f467829d, this.f467822c);
    }
}
