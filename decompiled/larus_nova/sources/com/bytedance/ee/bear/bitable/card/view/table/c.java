package com.bytedance.ee.bear.bitable.card.view.table;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableCardCoverViewPager f208862a;

    public c(BitableCardCoverViewPager r100) {
        this.f208862a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        int r109 = r104 - r102;
        int r110 = r108 - r106;
        if (Intrinsics.areEqual(this.f208862a.f208785q, Boolean.TRUE) == true) goto L7;
        if (r109 == r110) goto L8;
        this.f208862a.d(r109);
        return;
    L8:
        return;
    }
}
