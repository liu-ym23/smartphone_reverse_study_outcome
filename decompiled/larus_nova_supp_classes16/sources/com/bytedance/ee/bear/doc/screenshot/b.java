package com.bytedance.ee.bear.doc.screenshot;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.bizwidget.shareview.i;
import fz4.a0;
import fz4.o;
import fz4.p;
import fz4.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends i {
    public final /* synthetic */ DocShotView a;

    public b(DocShotView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean U10(final ShareItemModel r8) {
        DocShotView r0 = this.a;
        a0 r1 = r0.c;
        if (r1 == null) goto L14;
        final String r2 = r0.p;
        final DocShotPresenter r3 = (DocShotPresenter) r1;
        if (r8 != null) goto L7;
    L10:
        boolean r9 = false;
    L11:
        if (r9 == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r8.getOnClickedListener() == null) goto L10;
        final ShareType r4 = r8.getType();
        r3.d(r3.h).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).doFinally(new o()).subscribe(new p(r3, r8, r2, r4), new q());
        r9 = true;
        goto L11
    L14:
        return false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean Yl(ShareType r2) {
        a0 r0 = this.a.c;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (((DocShotPresenter) r0).g(r2) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean rF(ShareItemModel r3) {
        a0 r4 = this.a.c;
        if (r4 != null) goto L5;
    L6:
        return true;
    L5:
        if (((DocShotPresenter) r4).f(2131887299, false) == true) goto L6;
        return false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.i, com.bytedance.ee.bear.bizwidget.shareview.b
    public final void s10(ShareType r3) {
        if (this.a.c != null) goto L6;
        return;
    L6:
        switch(DocShotView.a.a[r3.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            default: goto L7;
        };
    L7:
        super.s10(r3);
        return;
    L8:
        ((DocShotPresenter) this.a.c).h(r3, false);
    }
}
