package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements Runnable {
    public final /* synthetic */ AnchorV4DetailHeadView a;
    public final /* synthetic */ AnchorV4DetailCombinePropertyPagerAdapter b;

    public f(AnchorV4DetailHeadView r1, AnchorV4DetailCombinePropertyPagerAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.a.getParent() == null) goto L11;
        AutoHeightViewPager r0 = this.a.k;     // Catch: Throwable -> L8
        if (r0 == null) goto L15;
        r0.setAdapter(this.b);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    }
}
