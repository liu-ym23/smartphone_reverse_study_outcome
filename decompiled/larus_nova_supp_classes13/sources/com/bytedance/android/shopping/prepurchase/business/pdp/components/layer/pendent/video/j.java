package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.view.View;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements u {
    public final /* synthetic */ u b;
    public final /* synthetic */ i c;
    public final /* synthetic */ u d;

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
    public final void a() {
        this.b.a();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
    public final void onShow() {
        this.b.onShow();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
    public final void b(l r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        Intrinsics.checkNotNullParameter(r2, "other");
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
    public final void c(a r7) {
        Intrinsics.checkNotNullParameter(r7, "floatVideo");
        m r0 = this.c.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "video");
        DragRelativeLayout r1 = r7.a;
        if (r7.j.a() == false) goto L12;
        if (r1 == null) goto L13;
        boolean r8 = false;
        View r2 = qc3.a.c(r1, 0);
        if (r2 == null) goto L14;
        Integer r4 = Integer.valueOf(r2.getTop());
        if (r2.getLeft() <= (r1.getWidth() / 2.0f)) goto L10;
        r8 = true;
    L10:
        r0.a = new Pair(r4, Boolean.valueOf(r8));
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
    public final void onClose(boolean r3) {
        this.c.c = null;
        this.d.onClose(r3);
    }

    public j(i r1, u r2) {
        this.c = r1;
        this.d = r2;
        this.b = r2;
    }
}
