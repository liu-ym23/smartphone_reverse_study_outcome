package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4FindSameView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class FindSameHolderBuilder extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<e> {
    public AnchorV4FindSameView i;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(com.bytedance.android.shopping.anchorv4.voavhs.head.c r3) {
        Intrinsics.checkNotNullParameter(r3, "nodeVO");
        return new e(r3.u, this.g);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b, com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final void m(final com.bytedance.android.shopping.anchorv4.voavhs.head.c r4) {
        Intrinsics.checkNotNullParameter(r4, "nodeVO");
        AnchorV4FindSameView r1 = null;
        if (com.bytedance.android.shopping.anchorv4.voavhs.head.j.a() == false) goto L13;
        Function0<Unit> r0 = new FindSameHolderBuilder$updateViewHolders$action$1(this, r4);
        AnchorV4FindSameView r5 = this.i;
        if ((r5 instanceof AnchorV4FindSameView) == false) goto L8;
        r1 = r5;
    L8:
        if (r1 != null) goto L12;
        Intrinsics.checkNotNullParameter(r0, "listener");
        if (((ArrayList) this.c).size() <= 0) goto L20;
        ListProtector.set(this.c, 0, r0);
        return;
    L20:
        return;
    L12:
        r0.invoke();
        return;
    L13:
        AnchorV4FindSameView r2 = this.i;
        if ((r2 instanceof AnchorV4FindSameView) == false) goto L17;
        r1 = r2;
    L17:
        if (r1 == null) goto L23;
        r1.update(r4);
        return;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4FindSameView] */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final View w(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r8) {
        Context r1 = getContext();
        ?? r9 = new AnchorV4FindSameView(r1, null, 0, (e) r8, this.g, 6);
        this.i = r9;
        return r9;
    }

    public FindSameHolderBuilder(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
